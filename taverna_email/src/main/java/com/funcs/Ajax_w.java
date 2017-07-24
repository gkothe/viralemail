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
import com.phpdao.domain.Cidade;
import com.phpdao.domain.Usuario;

public class Ajax_w {

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

}
