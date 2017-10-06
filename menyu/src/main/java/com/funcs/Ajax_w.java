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
import com.cruds.HM_SysParametros;
import com.cruds.HM_Usuario;

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
			HM_SysParametros sys = new HM_SysParametros(conn, 1);

			if (cmd.equalsIgnoreCase("login")) {
				String flag_face = request.getParameter("flag_face") == null ? "" : request.getParameter("flag_face"); // S javascript, A nativo, N não

				if (!(flag_face.equalsIgnoreCase("S")) && !(flag_face.equalsIgnoreCase("N")) && !(flag_face.equalsIgnoreCase("A"))) {
					throw new Exception("Parâmetros de de login incorretos, ta metendo a mão onde não deve mané! ");
				}

				if (flag_face.equalsIgnoreCase("S")) {
					MobileLogin.loginMobileFace(request, response, conn, sys, true);
				} else {
					String user = request.getParameter("user");
					String pass = request.getParameter("pass");
					MobileLogin.loginMobile(request, response, conn, user, pass);
				}
			} else if (cmd.equalsIgnoreCase("cadastro")) {
				inserirUser(request, response, conn, sys);
			}else if (cmd.equalsIgnoreCase("rec_senha")) {
				//inserirUser(request, response, conn, sys);
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

	private static void inserirUser(HttpServletRequest request, HttpServletResponse response, Connection conn, HM_SysParametros sys) throws Exception {

		PrintWriter out = response.getWriter();

		JSONObject objRetorno = new JSONObject();
		String desc_usuario = request.getParameter("c_username") == null ? "" : request.getParameter("c_username");
		String desc_senha = request.getParameter("c_password") == null ? "" : request.getParameter("c_password");
		String desc_senha_conf = request.getParameter("c_passwordconfirm") == null ? "" : request.getParameter("c_passwordconfirm");
		String desc_email = request.getParameter("c_email") == null ? "" : request.getParameter("c_email");
		String desc_nome = request.getParameter("c_nome") == null ? "" : request.getParameter("c_nome");

		if (desc_usuario.equalsIgnoreCase("")) {
			throw new Exception("Você deve preencher o campo de usuário.");
		}

		if (desc_senha.equalsIgnoreCase("")) {
			throw new Exception("Você deve preencher o campo de senha.");
		}

		if (desc_email.equalsIgnoreCase("")) {
			throw new Exception("Você deve preencher o campo de email.");
		}

		if (!desc_senha.equalsIgnoreCase(desc_senha_conf)) {
			throw new Exception("Erro. As senhas são diferentes.");
		}

		PreparedStatement st = conn.prepareStatement("select * from  usuario where  Binary desc_email =  ? ");
		st.setString(1, desc_email);
		ResultSet rs = st.executeQuery();
		if (rs.next()) {

			if (rs.getString("flag_faceuser").equalsIgnoreCase("S")) {
				throw new Exception("Este e-mail já está relacionado a uma conta do Facebook. Se você não possui mais uma conta de Facebook, você pode voltar a tela de login e clicar que recuperar senha.");
			} else {
				throw new Exception("E-mail já cadastrado! Se você se esqueceu de sua senha, volte a tela de login e clique em recuperar senha.");
			}
		}

		st = conn.prepareStatement("SELECT 1 from  usuario where  Binary desc_user = ? ");
		st.setString(1, desc_usuario);
		rs = st.executeQuery();

		if (rs.next()) {
			throw new Exception("Nome de usuário ja existente!");
		}

		String validacao = Utilitario.StringGen(1000, 32).substring(0, 99);

		HM_Usuario user = new HM_Usuario(conn);
		user.setDescEmail(desc_email);
		user.setDescSenha(desc_senha);
		user.setDescUser(desc_usuario);
		user.setDescNome(desc_nome);
		user.setFlagFaceuser("N");
		user.setFlagAtivado("S");
		user.insert();

		objRetorno.put("msg", "ok");

		out.print(objRetorno.toJSONString());

	}

}
