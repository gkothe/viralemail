package com.funcs;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
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
import com.cruds.HM_Produtos;

public class Ajax_w {

	public Utilitario u = new Utilitario();
	
	public static void ajax_w(HttpServletRequest request, HttpServletResponse response) throws Exception {// ajax que nao precisam de login
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
			Ajax_w funcs = new Ajax_w();

			if (cmd.equalsIgnoreCase("getProdutos")) {
				funcs.getProdutos(request, response, conn);
			}
			if (cmd.equalsIgnoreCase("fazerPedido")) {
				funcs.criarPedido(request, response, conn);
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

		
		
		JSONArray lista = new JSONArray();
		JSONObject categorias_obj = new JSONObject();
		JSONArray prods_array = new JSONArray();
		JSONArray categ_array = new JSONArray();

		HM_Produtos obj = new HM_Produtos(conn);
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
		System.out.println(retorno.toJSONString());
		out.print(retorno.toJSONString());
	}

	public void criarPedido(HttpServletRequest request, HttpServletResponse response, Connection conn) throws Exception {
		JSONObject retorno = new JSONObject();
		PrintWriter out = response.getWriter();
		JSONObject objjson = new JSONObject();
		// P - Pendente
		// A - Aceito
		// E - Em preparo
		// F- Finalizadop

		String carrinhoStr = request.getParameter("carrinho") == null ? "" : request.getParameter("carrinho");
		String mesa = request.getParameter("mesa") == null ? "" : request.getParameter("mesa");

		if(mesa.equalsIgnoreCase("")){
			u.ex("Mesa não informada.");
		}
		
		JSONObject carrinho = (JSONObject) new JSONParser().parse(carrinhoStr);
		Set keys = carrinho.keySet();
		Iterator<String> it = keys.iterator();
		
		long id_pedido = 0;

		HM_Produtos prod = new HM_Produtos(conn);
		HM_Pedido pedido = new HM_Pedido(conn);
		pedido.setIdLoja(1);
		pedido.setIdUsuario(1l);
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
//			if (carrinho.get(key) instanceof org.json.JSONObject) {
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
//			}
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
