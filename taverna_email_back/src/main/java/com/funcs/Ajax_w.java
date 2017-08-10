package com.funcs;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.configs.Conexao;
import com.phpdao.domain.Campanha;
import com.phpdao.domain.CampanhaEmail;
import com.phpdao.domain.CampanhaEmailPremio;
import com.phpdao.domain.CampanhaLandpage;
import com.phpdao.domain.CampanhaLandpageFeature;
import com.phpdao.domain.CampanhaLead;
import com.phpdao.domain.CampanhaThankspage;
import com.phpdao.domain.Cidade;
import com.phpdao.domain.UserImage;
import com.phpdao.domain.UserImagePage;
import com.phpdao.domain.UserPremio;
import com.phpdao.domain.Usuario;

public class Ajax_w {

	public static void ajax_w(HttpServletRequest request, HttpServletResponse response) throws Exception {// ajax que nao precisam de login
		PrintWriter out = response.getWriter();

		response.setContentType("text/x-json; charset=UTF-8");
		response.setDateHeader("Expires", 0);
		response.setDateHeader("Last-Modified", new java.util.Date().getTime());
		response.setHeader("Cache-Control", "no-cache, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		request.setCharacterEncoding("UTF-8");

		Connection conn = null;
		JSONObject objRetorno = new JSONObject();

		try {
			conn = Conexao.getConexao();
			conn.setAutoCommit(false);
			String cmd = request.getParameter("cmd");

			if (cmd.equalsIgnoreCase("doCadastro")) {
				Ajax_w.Cadastro(request, response, conn);
			} else if (cmd.equalsIgnoreCase("loadCampanhabyRef")) {
				Ajax_w.LoadCampanhabyRef(request, response, conn);
			} else if (cmd.equalsIgnoreCase("sendLead")) {
				Ajax_w.SendLead(request, response, conn);
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

	public static void validarConta(HttpServletRequest request, HttpServletResponse response) {

		Connection conn = null;
		try {
			conn = Conexao.getConexao();
			conn.setAutoCommit(false);

			String token = request.getParameter("token") == null ? "" : request.getParameter("token");
			String msg = "";

			boolean erro = false;
			if (!token.equalsIgnoreCase("")) {
				msg = "Token inválido.";
				erro = true;
			}

			String sql = "select * from usuario where Binary chave_ativacao = ?   ";
			Sys_parametros sys = new Sys_parametros(conn);
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, token);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {

				sql = "update usuario  set chave_ativacao = ? ,  flag_ativado = ? , flag_ativo = ? where  chave_ativacao = ?  ";

				st = conn.prepareStatement(sql.toString());
				st.setString(1, "");
				st.setString(2, "S");
				st.setString(3, "S");
				st.setString(4, token);
				st.executeUpdate();

				msg = "Seu e-mail foi verificado e sua conta foi ativada. Você já pode logar no " + sys.getSys_fromdesc() + "! :-)";
				erro = false;
			} else {
				if (!token.equalsIgnoreCase("")) {
					msg = "Link inválido. Se você recebeu este link por e-mail e já o acessou, você já esta apto a logar no " + sys.getSys_fromdesc() + "!  ";
					erro = true;
				}
			}

			if (erro)
				request.setAttribute("erro", erro);
			else
				request.setAttribute("erro", erro);

			request.setAttribute("msg", msg);
			request.getRequestDispatcher("/WEB-INF/msg.jsp").forward(request, response);

			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (Exception e2) {
			}

			try {
				conn.close();
			} catch (Exception e2) {
			}
		}

	}

	public static void Cadastro(HttpServletRequest request, HttpServletResponse response, Connection conn) throws Exception {
		Sys_parametros sys = new Sys_parametros(conn);
		PrintWriter out = response.getWriter();
		JSONObject objRetorno = new JSONObject();
		JSONObject param = Utilitario.getJsonFromRequest(request, response);
		PreparedStatement st;
		StringBuffer sql;
		ResultSet rs;
		Usuario user;

		if (param.get("desc_nome").toString().equalsIgnoreCase("")) {
			throw new Exception("Você deve inserir seu nome.");
		}

		if (!param.get("desc_senha").toString().equalsIgnoreCase(param.get("desc_senha_repita").toString())) {
			throw new Exception("As senhas estão diferentes!");
		}

		if (param.get("cod_cidade").toString().equalsIgnoreCase("")) {
			throw new Exception("Você deve escolher uma cidade.");
		} else {

			if (!Utilitario.isNumeric(param.get("cod_cidade").toString())) {
				throw new Exception("Cidade inválida");
			}

			Cidade cidade = new Cidade(conn);
			cidade.setCodcidade(Long.parseLong(param.get("cod_cidade").toString()));
			rs = cidade.lista();
			if (!rs.next()) {
				throw new Exception("Cidade não existente");
			}
		}

		if (param.get("desc_telefone").toString().equalsIgnoreCase("")) {
			throw new Exception("Você deve inserir um telefone.");// TODO validar formato qdo for pago
		}

		if (param.get("desc_endereco").toString().equalsIgnoreCase("")) {
			throw new Exception("Você deve inserir um endereço.");
		}

		if (param.get("num_endereco").toString().equalsIgnoreCase("")) {

			if (!Utilitario.isNumeric(param.get("num_endereco").toString())) {
				throw new Exception("Número de endereço inválido.");
			}

			throw new Exception("Você deve inserir um numero de endereço.");
		}

		if (param.get("desc_cep").toString().equalsIgnoreCase("")) {
			throw new Exception("Você deve inserir seu CEP.");// TODO validar formato qdo for pago
		}

		if (param.get("num_cpf").toString().equalsIgnoreCase("")) {// validar cpf
			throw new Exception("Você deve seu CPF.");
		}

		if (param.get("desc_email").toString().equalsIgnoreCase("")) {

			throw new Exception("Você deve inserir um e-mail.");
		} else {

			user = new Usuario(conn);
			user.setDescmail(param.get("desc_email").toString());
			rs = user.lista();
			if (rs.next()) {
				throw new Exception("Este e-mail já esta em uso.");
			}
		}

		if (param.get("desc_login").toString().equalsIgnoreCase("")) {
			throw new Exception("Você deve inserir um usuario.");
		} else {
			user = new Usuario(conn);
			user.setDesclogin(param.get("desc_login").toString());
			rs = user.lista();
			if (rs.next()) {
				throw new Exception("Este login já esta em uso.");
			}
		}

		if (param.get("desc_senha").toString().equalsIgnoreCase("")) {
			throw new Exception("Você deve inserir uma senha.");
		}

		String validacao = Utilitario.StringGen(1000, 32).substring(0, 99);
		user = new Usuario(conn);
		user.setChaveativacao(validacao);
		rs = user.lista();
		while (rs.next()) {
			validacao = Utilitario.StringGen(1000, 32).substring(0, 99);
			user = new Usuario(conn);
			user.setChaveativacao(validacao);
			rs.close();
			rs = user.lista();
		}

		sql = new StringBuffer();
		sql.append("INSERT INTO usuario (COD_CIDADE, DESC_NOME, DESC_TELEFONE, DESC_ENDERECO, NUM_ENDEREC, DESC_COMPLEMENTO, DESC_LOGIN, DESC_SENHA, DESC_MAIL, FLAG_ATIVO, NUM_CPF, DESC_CEP, FLAG_ATIVADO, CHAVE_ATIVACAO) ");
		sql.append("values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		st = conn.prepareStatement(sql.toString());

		int contparam = 1;
		st.setInt(contparam, Integer.parseInt(param.get("cod_cidade").toString()));
		contparam++;

		st.setString(contparam, param.get("desc_nome").toString());
		contparam++;

		st.setString(contparam, param.get("desc_telefone").toString());
		contparam++;

		st.setString(contparam, param.get("desc_endereco").toString());
		contparam++;

		st.setInt(contparam, Integer.parseInt(param.get("num_endereco").toString()));
		contparam++;

		st.setString(contparam, param.get("desc_complemento").toString());
		contparam++;

		st.setString(contparam, param.get("desc_login").toString());
		contparam++;

		st.setString(contparam, param.get("desc_senha").toString());
		contparam++;

		st.setString(contparam, param.get("desc_email").toString());
		contparam++;

		st.setString(contparam, "N");
		contparam++;

		st.setString(contparam, param.get("num_cpf").toString().replaceAll("[\\D]", ""));
		contparam++;

		st.setString(contparam, param.get("desc_cep").toString().replaceAll("[\\D]", ""));
		contparam++;

		st.setString(contparam, "N");
		contparam++;

		st.setString(contparam, validacao);
		contparam++;

		st.executeUpdate();

		String texto = "Olá, <br>  Bem vindo ao " + sys.getSys_fromdesc() + ", para validar sua conta clique <a href='" + sys.getUrl_system() + "?acao=validarEmail&token=" + validacao + "'> AQUI </a> e você estará pronto para utilizar nossos serviços. <br> Suas informações de login são: <br> Usuário: " + param.get("desc_login").toString() + " <br> Senha: " + param.get("desc_senha").toString();
		Utilitario.sendEmail(param.get("desc_email").toString(), texto, sys.getSys_fromdesc() + " - Criação de conta!", conn);

		objRetorno.put("msgok", "ok");
		objRetorno.put("msg", "Seu usuário foi criado. Para validar se cadastro, acesse seu e-mail.");

		out.print(objRetorno.toJSONString());

	}

	public static void LoadCampanhabyRef(HttpServletRequest request, HttpServletResponse response, Connection conn) throws Exception {
		// Load camapnha landpage
		PrintWriter out = response.getWriter();
		JSONObject objRetorno = new JSONObject();
		JSONObject param = Utilitario.getJsonFromRequest(request, response);
		ResultSet rs;
		Campanha camp = new Campanha(conn);
		camp.setLinkinicial(param.get("ref").toString());
		rs = camp.lista();
		if (rs.next()) {

			camp.setIdcampanha(rs.getLong("id_campanha"));

			JSONObject land = camp.getLandPage();

			objRetorno.put("landpage", land);
			objRetorno.put("landpagefeatures", camp.getLandPageFeatures(Long.parseLong(land.get("id_landpage").toString())));
			objRetorno.put("landpageImage", camp.getLandPageImages(Long.parseLong(land.get("id_landpage").toString())));

			objRetorno.put("msgok", "ok");

		} else {
			throw new Exception("Campanha inexistente.");
		}

		out.print(objRetorno.toJSONString());

	}

	/*
	 * problemas do snedlead] pode botar qalqer coisa como email e vai inserir e contar como referencia se ele botar qalqer outro email valido, usando proprio link de rederencia, acaba virnando um spam. 
	 * Esse email(se for valido) vai receber o premio 1, mas n vai fazer ideia do qq se trata, e nao vai saber qal o seu link de referencia para mandar para outras pessoas. 
	 * 
	 * soluções:
	 * Enviar um email, com um link. Quando a pessoa clickar neste link ( e la encontraria os link premios?) ativa o insert do referencia, ou um update confirmado , flag_ref_valido = 'S'
	 * O email 1, tinha q ter umas informaçõs padroes da camapnha e etc
	 */

	public static void SendLead(HttpServletRequest request, HttpServletResponse response, Connection conn) throws Exception {
		// Load camapnha landpage
		PrintWriter out = response.getWriter();
		JSONObject objRetorno = new JSONObject();
		JSONObject param = Utilitario.getJsonFromRequest(request, response);

		CampanhaLead clead = new CampanhaLead(conn);
		CampanhaEmail c_mail = new CampanhaEmail(conn);
		Sys_parametros sys = new Sys_parametros(conn);

		ResultSet rs;
		ResultSet rs2;
		Campanha camp = new Campanha(conn);
		camp.setLinkinicial(param.get("ref").toString());
		rs = camp.lista();
		if (rs.next()) {

			String lead = param.get("lead").toString();
			String l_ref = param.get("lerf") == null ? "" : param.get("lerf").toString();

			if (!l_ref.equalsIgnoreCase("")) {
				if (!Utilitario.isNumeric(l_ref)) {
					throw new Exception("Refêrencia inválida..");
				}
			}

			clead = new CampanhaLead(conn);
			clead.setIdcampanha(rs.getLong("id_campanha"));
			clead.setDescemail(lead);
			rs2 = clead.lista();
			if (rs2.next()) {
				throw new Exception("Este e-mail já foi usado para esta campanha!");
			}

			clead = new CampanhaLead(conn);
			clead.setIdcampanha(rs.getLong("id_campanha"));
			clead.setDescemail(lead);
			clead.insert();
			long id_lead = clead.getIdlead();

			clead = new CampanhaLead(conn);
			clead.setIdlead(id_lead);
			clead.setDesclinkreferal(sys.getUrl_system() + "campanha?ref=" + param.get("ref").toString() + "&l=" + id_lead);
			if (!l_ref.equalsIgnoreCase("")) {
				clead.setIdleadreferencia(Long.parseLong(l_ref));
			}

			clead.update();
			String linkref = clead.getDesclinkreferal();

			c_mail = new CampanhaEmail(conn);
			c_mail.setIdcampanha(rs.getLong("id_campanha"));
			c_mail.setQtd_referencia(0);
			c_mail.sendEmail(lead);

			// *********parte do referal
			if (!l_ref.equalsIgnoreCase("")) {
				String emaildoref = "";
				int contador = 0;

				clead = new CampanhaLead(conn);
				clead.setIdcampanha(rs.getLong("id_campanha"));
				clead.setIdlead(Long.parseLong(l_ref));
				rs2 = clead.lista();
				if (rs2.next()) {
					emaildoref = rs2.getString("desc_email");
				} else {
					throw new Exception("Refêrencia inválida..");
				}

				clead = new CampanhaLead(conn);
				clead.setIdcampanha(rs.getLong("id_campanha"));
				clead.setIdleadreferencia(Long.parseLong(l_ref));
				rs2 = clead.lista();
				while (rs2.next()) {
					contador++;
				}

				if (contador != 0) {
					c_mail = new CampanhaEmail(conn);
					c_mail.setIdcampanha(rs.getLong("id_campanha"));
					c_mail.setQtd_referencia(contador);
					c_mail.sendEmail(emaildoref);
				}
			}

			objRetorno.put("ref", linkref);

			objRetorno.put("msgok", "ok");
			objRetorno.put("msg", "Seu link de referencia é " + linkref);

		} else {
			throw new Exception("Campanha inexistente.");
		}

		out.print(objRetorno.toJSONString());

	}

}
