package com.funcs;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.configs.Conexao;
import com.cruds.HM_Categoria;
import com.cruds.HM_Pedido;
import com.cruds.HM_PedidoItem;
import com.cruds.HM_ProdutoCustomItem;
import com.cruds.HM_Produtos;
import com.cruds.HM_SysParametros;
import com.cruds.HM_Usuario;

public class Ajax {

	public Utilitario u = new Utilitario();
	public static DecimalFormatSymbols dfs = new DecimalFormatSymbols(new Locale("pt", "BR"));
	public static NumberFormat df = new DecimalFormat("###,###.#", dfs);
	public static NumberFormat df2 = new DecimalFormat("#,###,##0.00", dfs);

	public static void ajax(HttpServletRequest request, HttpServletResponse response) throws Exception {// ajax que nao precisam de login
		PrintWriter out = response.getWriter();

		response.setContentType("text/x-json; charset=UTF-8");
		response.setDateHeader("Expires", 0);
		response.setDateHeader("Last-Modified", new java.util.Date().getTime());
		response.setHeader("Cache-Control", "no-cache, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		request.setCharacterEncoding("UTF-8");
		response.setHeader("Access-Control-Allow-Headers", "Content-Type");
		response.setHeader("Access-Control-Allow-Methods", "GET, POST");
		response.setHeader("Access-Control-Allow-Origin", "*");

		Connection conn = null;
		JSONObject objRetorno = new JSONObject();

		try {
			conn = Conexao.getConexao();
			conn.setAutoCommit(false);

			String cmd = request.getParameter("cmd");
			Ajax funcs = new Ajax();
			HM_SysParametros sys = new HM_SysParametros(conn, 1);

			JSONObject ret = MobileLogin.parseJWT(request, response, conn, request.getHeader("X-Auth-Token"), sys);

			long cod_usuario = Long.parseLong(ret.get("coduser").toString());

			if (cod_usuario == 0) {
				throw new Exception("Usuário inválido");
			}

			if (sys.getRsFlagManutencao().equalsIgnoreCase("S")) {
				throw new Exception("Servidor está em manutenção. Tente novamente mais tarde. Cheers! ");
			}

			if (cmd.equalsIgnoreCase("getProdutos")) {
				funcs.getProdutos(request, response, conn);
			} else if (cmd.equalsIgnoreCase("fazerPedido")) {
				funcs.criarPedido(request, response, conn, cod_usuario);
			}

			conn.commit();
		} catch (Exception ex) {
			if (ex.getMessage() == null || ex.getMessage().equals("")) {
				objRetorno.put("erro", "Erro, por favor entrar em contato com suporte.");
			} else {
				objRetorno.put("erro", ex.getMessage());
			}

			ex.printStackTrace();
			out.print(objRetorno.toJSONString());
			try {
				conn.rollback();
			} catch (Exception exr) {
			}
		} finally {
			try {
				conn.close();
			} catch (Exception ex) {
			}
		}
	}

	public void getProdutos(HttpServletRequest request, HttpServletResponse response, Connection conn) throws Exception {
		JSONObject retorno = new JSONObject();
		PrintWriter out = response.getWriter();
		JSONObject objjson = new JSONObject();
		JSONObject obj_custom = new JSONObject();

		JSONArray lista = new JSONArray();
		JSONObject categorias_obj = new JSONObject();
		JSONArray prods_array = new JSONArray();
		JSONArray custons = new JSONArray();

		HM_Produtos obj = new HM_Produtos(conn);
		HM_ProdutoCustomItem customitem = new HM_ProdutoCustomItem(conn);
		HM_Categoria categorias = new HM_Categoria(conn);
		categorias.lista();
		categorias.setLastSentence("order by desc_categoria");
		while (categorias.next()) {
			categorias_obj = new JSONObject();
			obj = new HM_Produtos(conn);
			obj.setIdCategoria(categorias.getRsIdCategoria());
			obj.setLastSentence("order by desc_abreviado");
			obj.lista();
			prods_array = new JSONArray();
			while (obj.next()) {
				objjson = new JSONObject();
				objjson.put("id_prod", obj.getRsIdProd() == null ? "" : obj.getRsIdProd());
				objjson.put("qtd", 0);
				objjson.put("desc_prod", obj.getRsDescProd() == null ? "" : obj.getRsDescProd());
				objjson.put("desc_abreviado", obj.getRsDescAbreviado() == null ? "" : obj.getRsDescAbreviado());
				objjson.put("flag_ativo", obj.getRsFlagAtivo() == null ? "" : obj.getRsFlagAtivo());
				objjson.put("qtd_images", obj.getRsQtdImages() == null ? "" : obj.getRsQtdImages());
				objjson.put("val_unit", obj.getRsValUnit() == null ? 0 : "R$ " + Utilitario.df2.format(obj.getRsValUnit()));
				objjson.put("val_unit_raw", obj.getRsValUnit() == null ? 0 : (obj.getRsValUnit()));
				objjson.put("desc_key_words", obj.getRsDescKeyWords() == null ? "" : obj.getRsDescKeyWords());

				if (obj.getRsIdCustom() != null && obj.getRsIdCustom() != 0) {

					customitem = new HM_ProdutoCustomItem(conn);
					customitem.setIdCustom(obj.getRsIdCustom());
					customitem.lista();
					custons = new JSONArray();
					JSONArray vals = new JSONArray();

					while (customitem.next()) {
						obj_custom = new JSONObject();

						obj_custom.put("desc_item", customitem.getRsDescItem());
						obj_custom.put("flag_tipo", customitem.getRsFlagTipo());
					

						if (customitem.getRsFlagTipo() == 1) { // Faxa de valor Slider ex: de 0 a 100, 0~100, onde o val preço multiplica pelo valor escolhido da faxa.
							String[] vals_precos = customitem.getRsValValidos().split("~");
							obj_custom.put("val_sel", Integer.parseInt(vals_precos[0]));
							obj_custom.put("val_min_f", df.format(Double.parseDouble(vals_precos[0])));
							obj_custom.put("val_max_f", df.format(Double.parseDouble(vals_precos[1])));
							obj_custom.put("val_min", Integer.parseInt(vals_precos[0]));
							obj_custom.put("val_max", Integer.parseInt(vals_precos[1]));
							obj_custom.put("val_mod", customitem.getRsValPreco());

						} else if (customitem.getRsFlagTipo() == 2) { // Tipo 2 -> com opções, Ex: 200;400;600 , Val:0;3;5; Combo box
							String[] vals_validos = customitem.getRsValValidos().split(";");
							String[] vals_precos = customitem.getRsValPreco().split(";");

							JSONObject preco_val_json = new JSONObject();

							for (int i = 0; i < vals_precos.length; i++) {
								preco_val_json = new JSONObject();
								preco_val_json.put("opc", vals_validos[i]);
								preco_val_json.put("val", vals_precos[i]);
								preco_val_json.put("val_f", df2.format(Double.parseDouble(vals_precos[i])));
								vals.add(preco_val_json);	
							}
							
							
							obj_custom.put("vals", vals);
							obj_custom.put("val_sel", vals_validos[0]);
						} else if (customitem.getRsFlagTipo() == 3) { // Tipo de Sim e Não, será um checkbox. Para diferentes opçõe se usa o tipo 2;

							obj_custom.put("val_sel", false);
							obj_custom.put("val", customitem.getRsValPreco());
							obj_custom.put("val_f", df2.format(Double.parseDouble(customitem.getRsValPreco())));

						}

						custons.add(obj_custom);
					}
					objjson.put("custom_list", custons);
					objjson.put("custom", true);
				} else {
					objjson.put("custom", false);
				}

				prods_array.add(objjson);
			}
			if (prods_array.size() > 0) {
				categorias_obj.put("lista", prods_array);
				categorias_obj.put("show", false);
				categorias_obj.put("nome", categorias.getRsDescCategoria());
				lista.add(categorias_obj);
			}
		}

		retorno.put("lista", lista);
		retorno.put("msg", "");
		retorno.put("msgok", "ok");
		out.print(retorno.toJSONString());
	}

	public void criarPedido(HttpServletRequest request, HttpServletResponse response, Connection conn, long cod_usuario) throws Exception {
		JSONObject retorno = new JSONObject();
		PrintWriter out = response.getWriter();
		JSONObject objjson = new JSONObject();
		// P - Pendente
		// A - Aceito
		// E - Em preparo
		// F- Finalizadop

		String carrinhoStr = request.getParameter("carrinho") == null ? "" : request.getParameter("carrinho");
		String mesa = request.getParameter("mesa") == null ? "" : request.getParameter("mesa");

		if (mesa.equalsIgnoreCase("")) {
			u.ex("Mesa não informada.");
		}

		JSONObject carrinho = (JSONObject) new JSONParser().parse(carrinhoStr);
		Set keys = carrinho.keySet();
		Iterator<String> it = keys.iterator();

		long id_pedido = 0;

		HM_Produtos prod = new HM_Produtos(conn);
		HM_Pedido pedido = new HM_Pedido(conn);
		pedido.setIdLoja(1);
		pedido.setIdUsuario(cod_usuario);
		pedido.setDataPedido(Utilitario.getTimeStamp(new Date()));
		pedido.setFlagStatus("P");
		pedido.setValTotalprod(0.0);
		// pedido.setNumPed(Long.parseLong(num_ped));
		pedido.setNumMesaEntrega(mesa);
		pedido.setFlagVizualizado("N");
		pedido.setFlagMarcado("N");
		pedido.insert();
		id_pedido = pedido.getIdPedido();
		HM_PedidoItem item = new HM_PedidoItem(conn);
		double val_total = 0;
		while (it.hasNext()) {
			String key = it.next();
			// if (carrinho.get(key) instanceof org.json.JSONObject) {
			objjson = (JSONObject) carrinho.get(key);
			prod = new HM_Produtos(conn);
			prod.setIdProd(Integer.parseInt(objjson.get("id_prod").toString()));
			prod.lista();
			if (prod.next()) {
				item = new HM_PedidoItem(conn);
				item.setIdPedido(pedido.getIdPedido());
				item.setValUnit(prod.getRsValUnit());
				item.setIdProd(prod.getRsIdProd());
				item.setQtdProd(Long.parseLong(objjson.get("qtd").toString()));
				val_total = val_total + (prod.getRsValUnit() * Long.parseLong(objjson.get("qtd").toString()));
				item.insert();

			} else {
				u.ex("Produto não encontrado.");
			}
		}

		pedido = new HM_Pedido(conn);
		pedido.setIdPedido(id_pedido);
		pedido.setValTotalprod(val_total);
		pedido.update();

		retorno.put("msg", "");
		retorno.put("msgok", "ok");
		System.out.println(retorno.toJSONString());
		out.print(retorno.toJSONString());
	}

}
