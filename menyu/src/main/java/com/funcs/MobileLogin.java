package com.funcs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Base64;
import java.util.Date;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DatatypeConverter;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.configs.Conexao;
import com.cruds.HM_Usuario;
import com.cruds.HM_SysParametros;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class MobileLogin {

	private static long tempotoken = 604800000; // 1 semana ou 1 mes, nao lembro


	public static void loginMobile(HttpServletRequest request, HttpServletResponse response, Connection conn, String user, String pass) throws Exception {

		PrintWriter out = response.getWriter();

		JSONObject objRetorno = new JSONObject();

		String sql = "select  *, Coalesce(flag_maioridade,'N')  as maior18, Coalesce(flag_leutermos,'N') as termos from usuario where Binary desc_user = ?  and Binary desc_senha = ? and (flag_ativado = 'S' or flag_ativado = 'V')";

		PreparedStatement st = conn.prepareStatement(sql);
		st.setString(1, user);
		st.setString(2, pass);
		ResultSet rs = st.executeQuery();

		if (rs.next()) {
			objRetorno.put("msg", "ok");
			MobileLogin mob = new MobileLogin();
			objRetorno.put("token", mob.criaToken(user, pass, tempotoken, conn, 0));//

			objRetorno.put("email", rs.getString("desc_email"));//
			objRetorno.put("usrtype", "user");//

		} else {
			objRetorno.put("erro", "Login inválido!");
		}

		out.print(objRetorno.toJSONString());

	}

	public static void loginMobileFace(HttpServletRequest request, HttpServletResponse response, Connection conn, HM_SysParametros sys, boolean nativo) throws Exception {

		PrintWriter out = response.getWriter();
		JSONObject objRetorno = new JSONObject();
		String url = "";
		HttpURLConnection con;
		URL obj;
		String tokentest;
		int responseCode;
		BufferedReader in;
		StringBuffer responsestr;
		String inputLine;
		JSONObject json;
		if (!nativo) {

			String code = request.getParameter("zcode");
			boolean cordova = request.getParameter("cordova") == null ? true : Boolean.parseBoolean(request.getParameter("cordova"));

			/*
			 * GET graph.facebook.com/debug_token? input_token={token-to-inspect} &access_token={app-token-or-admin-token}
			 */

			// validacao1
			if (cordova) {
				url = "https://graph.facebook.com/v2.3/oauth/access_token?client_id=" + sys.getRsFaceAppId() + "&redirect_uri=" + sys.getRsFaceRedirectUri() + "&client_secret=" + sys.getRsFaceAppSecretkey() + "&code=" + code;
			} else {
				url = "https://graph.facebook.com/v2.3/oauth/access_token?client_id=" + sys.getRsFaceAppId() + "&redirect_uri=" + sys.getRsFaceRedirectUriWebapp() + "&client_secret=" + sys.getRsFaceAppSecretkey() + "&code=" + code;
			}

			System.out.println(url);
			obj = new URL(url);
			con = (HttpURLConnection) obj.openConnection();

			con.setRequestMethod("GET");
			responseCode = con.getResponseCode();

			if (responseCode == 400) {
				throw new Exception("Erro 400 na busca de credencias.");
			}

			in = new BufferedReader(new InputStreamReader(con.getInputStream()));

			responsestr = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				responsestr.append(inputLine);
			}
			in.close();

			json = (JSONObject) new JSONParser().parse(responsestr.toString());

			tokentest = json.get("access_token").toString();
		} else {

			// nativo
			tokentest = request.getParameter("token") == null ? "" : request.getParameter("token");

		}

		// validacao2

		url = "https://graph.facebook.com/debug_token?input_token=" + tokentest + "&access_token=" + sys.getRsFaceAppToken();
		obj = new URL(url);
		con = (HttpURLConnection) obj.openConnection();

		con.setRequestMethod("GET");

		responseCode = con.getResponseCode();

		if (responseCode == 400) {
			throw new Exception("Erro 400 na busca de credencias.");
		}

		in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		responsestr = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			responsestr.append(inputLine);
		}
		in.close();

		json = (JSONObject) new JSONParser().parse(responsestr.toString());

		json = (JSONObject) json.get("data");
		// System.out.println(json.get("user_id"));
		// System.out.println(json.get("app_id"));
		long userid = Long.parseLong(json.get("user_id").toString());
		long app_id = Long.parseLong(json.get("app_id").toString());

		if (app_id != sys.getRsFaceAppId()) {
			throw new Exception("Erro nas credenciais");
		}

		String sql = "select  *, Coalesce(flag_maioridade,'N') as maior18,Coalesce(flag_leutermos,'N') as termos from usuario where id_user_face = ?  and flag_faceuser = 'S'  ";

		PreparedStatement st = conn.prepareStatement(sql);
		st.setLong(1, userid);
		ResultSet rs = st.executeQuery();
		MobileLogin mob = new MobileLogin();
		String email = "";
		if (rs.next()) {
			atualizaFaceUser(request, response, tokentest, conn, sys, userid);
			objRetorno.put("token", mob.criaToken(rs.getString("desc_user"), rs.getString("desc_senha"), tempotoken, conn, 0));//
			objRetorno.put("name", rs.getString("desc_nome").split(" ")[0]);
			objRetorno.put("usrtype", "user");//
			

			objRetorno.put("termos", rs.getString("termos").equalsIgnoreCase("") ? "N" : rs.getString("termos"));

			String latitude = request.getParameter("latitude") == null ? "" : request.getParameter("latitude");
			String longitude = request.getParameter("longitude") == null ? "" : request.getParameter("longitude");
			
	

			objRetorno.put("email", rs.getString("desc_email"));//
			email = rs.getString("desc_email");
		} else {

			JSONObject info = cadastrausuario(request, response, tokentest, conn, sys);
			objRetorno.put("token", mob.criaToken(info.get("user").toString(), info.get("pass").toString(), tempotoken, conn, 0));//
			objRetorno.put("name", info.get("name").toString());
			objRetorno.put("usrtype", "user");//
	
			objRetorno.put("termos", "N");
			objRetorno.put("cidadeatual", "N");
			objRetorno.put("email", info.get("email"));//
			email = info.get("email").toString();

			

		}

		// TODO teste

		System.out.println(objRetorno.toJSONString());
		objRetorno.put("msg", "ok");
		out.print(objRetorno.toJSONString());

	}

	private static void atualizaFaceUser(HttpServletRequest request, HttpServletResponse response, String tokentest, Connection conn, HM_SysParametros sys, long useridface) throws Exception {

		String url = "https://graph.facebook.com/me?fields=name,id,email&access_token=" + tokentest;
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		con.setRequestMethod("GET");

		int responseCode = con.getResponseCode();

		if (responseCode == 400) {
			throw new Exception("Erro 400 na busca de credencias.");
		}

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer responsestr = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			responsestr.append(inputLine);
		}
		in.close();

		JSONObject json = (JSONObject) new JSONParser().parse(responsestr.toString());

		String name = json.get("name").toString();
		String id = json.get("id").toString();
		String email = json.get("email").toString();

		String sql = "update usuario set desc_email = ? ,  desc_nome= ?, desc_user = ?  where  id_user_face = ?  ";

		PreparedStatement st = conn.prepareStatement(sql.toString());
		st.setString(1, email);
		st.setString(2, name);
		st.setString(3, email);
		st.setLong(4, Long.parseLong(id));

		st.executeUpdate();

	}

	private static JSONObject cadastrausuario(HttpServletRequest request, HttpServletResponse response, String tokentest, Connection conn, HM_SysParametros sys) throws Exception {
		JSONObject objjson = new JSONObject();

		String url = "https://graph.facebook.com/me?fields=name,id,email&access_token=" + tokentest;
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		con.setRequestMethod("GET");

		int responseCode = con.getResponseCode();

		if (responseCode == 400) {
			throw new Exception("Erro 400 na busca de credencias.");
		}

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer responsestr = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			responsestr.append(inputLine);
		}
		in.close();

		JSONObject json = (JSONObject) new JSONParser().parse(responsestr.toString());

		String name = json.get("name").toString();
		String id = json.get("id").toString();
		String email = json.get("email") == null ? "" : json.get("email").toString();

		if (email.equalsIgnoreCase("")) {
			throw new Exception("Ops! Não conseguimos obter seu e-mail relacionado ao Facebook. <br><br> Isto geralmente acontece quando o Facebook não conseguiu validar seu e-mail cadastrado. <br><br> Por favor vá nas configurações do seu Facebook e informe um e-mail válido. <br><br> Você também pode clicar em 'Cadastrar-se' para criar uma conta no Tragoaqui. ");
		}

		PreparedStatement st = conn.prepareStatement(" select * from usuario where desc_email = ?  and flag_ativado = 'S' ");
		st.setString(1, email);
		ResultSet rs = st.executeQuery();

		if (rs.next()) {

			StringBuffer sql = new StringBuffer();
			sql.append("update usuario  set `FLAG_FACEUSER` = ? , `ID_USER_FACE` = ?, DESC_NOME= ?, FLAG_ATIVADO = ? , CHAVE_ATIVACAO = ?  where  DESC_EMAIL = ?  ");

			st = conn.prepareStatement(sql.toString());
			st.setString(1, "S");
			st.setLong(2, Long.parseLong(id));
			st.setString(3, name);
			st.setString(4, "S");
			st.setString(5, "");
			st.setString(6, email);

			st.executeUpdate();

			objjson.put("name", name.split(" ")[0]);
			objjson.put("pass", rs.getString("DESC_SENHA"));
			objjson.put("user", rs.getString("DESC_USER"));

		} else {
			String pass = Utilitario.StringGen(130, 32);
			HM_Usuario user = new HM_Usuario(conn);
			user.setDescNome(name);
			user.setDescEmail(email);
			user.setDescSenha(pass);
			user.setDescUser(email);
			user.setFlagFaceuser("S");
			user.setIdUserFace(Long.parseLong(id));
			user.setFlagAtivado("S");
			user.insert();
			
			objjson.put("name", name.split(" ")[0]);
			objjson.put("pass", pass);
			objjson.put("user", email);
			objjson.put("email", email);

		}

		return objjson;
	}

	private String returnKey() {// nao esta sendo usado, server para gerar uma key. Qem sabe mudar a key quando liga o servidor?
		SecretKey secretKey = null;
		try {
			secretKey = KeyGenerator.getInstance("AES").generateKey();

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} // get base64 encoded version of the key
		return Base64.getEncoder().encodeToString(secretKey.getEncoded());
	}

	// http://stackoverflow.com/questions/5355466/converting-secret-key-into-a-string-and-vice-versa
	private String criaToken(String user, String pass, long ttlMillis, Connection conn, int cidade) throws Exception {

		// The JWT signature algorithm we will be using to sign the token
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);

		HM_SysParametros sys = new HM_SysParametros(conn,1);
		
		

		// We will sign our JWT with our ApiKey secret
		byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(sys.getRsDescKey());
		Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

		// Let's set the JWT Claims
		// JwtBuilder builder =
		// Jwts.builder().setId(id).setIssuedAt(now).setSubject(subject).setIssuer(issuer).signWith(signatureAlgorithm,
		// signingKey);

		JwtBuilder builder = Jwts.builder().claim("cidade", cidade).setId(user).setSubject(pass).setIssuedAt(now).signWith(signatureAlgorithm, signingKey);
		// if it has been specified, let's add the expiration
		if (ttlMillis >= 0) {
			long expMillis = nowMillis + ttlMillis;
			Date exp = new Date(expMillis);
			// builder.setExpiration(exp);
		}

		// Builds the JWT and serializes it to a compact, URL-safe string
		return builder.compact();
	}

	public static JSONObject parseJWT(HttpServletRequest request, HttpServletResponse response, Connection conn, String jwt, HM_SysParametros sys) throws Exception {

		try {
			Claims claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(sys.getRsDescKey())).parseClaimsJws(jwt).getBody();
			String user = claims.getId();
			String pass = claims.getSubject();

			JSONObject ret = new JSONObject();

			String sql = "select * from usuario where Binary desc_user = ?  and Binary desc_senha = ? ";

			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, user);
			st.setString(2, pass);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				long codusuer = rs.getLong("id_usuario");

//				sql = " update usuario set date_lastajax = now() where id_usuario = ? ";
//				st = conn.prepareStatement(sql.toString());
//				st.setLong(1, (codusuer));
//				st.executeUpdate();

				if (rs.wasNull()) {// acho que nao tem como isso acontecer, mas por via das duvida...
					ret.put("coduser", 0);
				} else {
					ret.put("coduser", codusuer);
				}

			} else {
				throw new Exception("Dados de acesso inválidos. Realize o login novamente.");
			}

			return ret;

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Dados de acesso inválidos.  Realize o login novamente.");
		}

	}

	public static void validarEmailNovo(HttpServletRequest request, HttpServletResponse response) {
		Connection conn = null;
		boolean erro = false;
		String msg = "";
		try {
			conn = Conexao.getConexao();
			conn.setAutoCommit(false);

			String token = request.getParameter("token") == null ? "" : request.getParameter("token");

			if (!token.equalsIgnoreCase("")) {
				msg = "Token inválido.";
				erro = true;

			}

			String sql = "select * from usuario where binary chave_ativacao_novoemail = ?   ";

			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, token);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {

				sql = "update usuario  set  chave_ativacao_novoemail = ? ,  desc_novoemailvalidacao = ? , desc_email = ? where  id_usuario = ?  ";

				st = conn.prepareStatement(sql);
				st.setString(1, "");
				st.setString(2, "");
				st.setString(3, rs.getString("desc_novoemailvalidacao"));
				st.setLong(4, rs.getLong("id_usuario"));
				st.executeUpdate();

				msg = "Seu e-mail foi verificado e atualizado! Para receber notifcações dos pedidos, você deve sair do TragoAqui e entrar novamente.";
				erro = false;
			} else {
				if (!token.equalsIgnoreCase("")) {
					msg = "Token inválido.";
					erro = true;
				}
			}

			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (Exception e2) {
			}

			try {
				conn.close();
			} catch (Exception e2) {
			}
			erro = true;
			msg = e.getMessage();

		}

		try {

			if (erro)
				request.setAttribute("erro", erro);
			else
				request.setAttribute("erro", erro);

			request.setAttribute("msg", msg);
			request.getRequestDispatcher("/WEB-INF/msg.jsp").forward(request, response);
		} catch (Exception e2) {
		}

	}

	

}
