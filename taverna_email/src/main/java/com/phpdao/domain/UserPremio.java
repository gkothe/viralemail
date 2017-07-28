package com.phpdao.domain;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.funcs.Sys_parametros;
import com.funcs.Utilitario;

public class UserPremio implements java.io.Serializable {

	private Long idpremio;
	private Long idusuario;
	private String descname;
	private String descextensao;
	private String descpath;

	private PreparedStatement st;
	private StringBuffer sql;
	private ResultSet rs;
	private Connection conn;

	public Long getIdpremio() {
		return idpremio;
	}

	public void setIdpremio(Long idpremio) {
		this.idpremio = idpremio;
	}

	public Long getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(Long idusuario) {
		this.idusuario = idusuario;
	}

	public String getDescname() {
		return descname;
	}

	public void setDescname(String descname) {
		this.descname = descname;
	}

	public String getDescextensao() {
		return descextensao;
	}

	public void setDescextensao(String descextensao) {
		this.descextensao = descextensao;
	}

	public String getDescpath() {
		return descpath;
	}

	public void setDescpath(String descpath) {
		this.descpath = descpath;
	}

	public UserPremio(Connection conn) {
		super();
		this.conn = conn;
	}

	public ResultSet lista() throws Exception {

		sql = new StringBuffer();
		sql.append(" select * from user_premios where  1=1 ");

		if (getIdpremio() != null && getIdpremio() != 0) {
			sql.append(" and  id_premio = ? ");
		}

		if (getIdusuario() != null && getIdusuario() != 0) {
			sql.append(" and  id_usuario = ? ");
		}

		st = conn.prepareStatement(sql.toString());

		int contparam = 1;

		if (getIdpremio() != null && getIdpremio() != 0) {
			st.setLong(contparam, getIdpremio());
			contparam++;
		}

		if (getIdusuario() != null && getIdusuario() != 0) {
			st.setLong(contparam, getIdusuario());
			contparam++;
		}

		rs = st.executeQuery();

		return rs;
	}

	public void insert() throws Exception {

		sql = new StringBuffer();
		sql.append("	INSERT INTO user_premios (id_premio) value (?) ");
		st = conn.prepareStatement(sql.toString());
		long id = Utilitario.retornaIdinsertLong("user_premios", "id_premio", conn);
		st.setLong(1, id);

		if (st.executeUpdate() == 1) {
			setIdpremio(id);
			update();
		} else {
			throw new Exception("Erro, contate suporte. Inserção Prêmios.");
		}

	}

	public void update() throws Exception {

		sql = new StringBuffer();
		sql.append("	update user_premios set id_premio =  " + getIdpremio() + " "); // seta a pk soh para ter um "set"

		if (getIdusuario() != null && getIdusuario() != 0) {
			sql.append(", id_usuario = ? ");
		}

		if (getDescname() != null) {
			sql.append(", desc_name = ? ");
		}

		if (getDescextensao() != null) {
			sql.append(", desc_extensao = ? ");
		}

		if (getDescpath() != null) {
			sql.append(", desc_path = ? ");
		}

		sql.append(" where id_premio = " + getIdpremio() + " ");

		st = conn.prepareStatement(sql.toString());

		int contparam = 1;

		if (getIdusuario() != null && getIdusuario() != 0) {
			st.setLong(contparam, getIdusuario());
			contparam++;
		}

		if (getDescname() != null) {
			st.setString(contparam, getDescname());
			contparam++;
		}

		if (getDescextensao() != null) {
			st.setString(contparam, getDescextensao());
			contparam++;
		}

		if (getDescpath() != null) {
			st.setString(contparam, getDescpath());
			contparam++;
		}

		if (st.executeUpdate() == 1) {

		} else {
			throw new Exception("Erro, contate suporte. Update de land page.");
		}

	}

	public void delete() throws Exception {

		sql = new StringBuffer();
		sql.append("delete from user_premios where 1=1 ");

		if (getIdusuario() != null && getIdusuario() != 0) {
			sql.append("and id_usuario = ? ");
		}

		if (getIdpremio() != null && getIdpremio() != 0) {
			sql.append("and id_premio = ? ");
		}

		st = conn.prepareStatement(sql.toString());

		int contparam = 1;

		if (getIdusuario() != null && getIdusuario() != 0) {
			st.setLong(contparam, getIdusuario());
			contparam++;
		}

		if (getIdpremio() != null && getIdpremio() != 0) {
			st.setLong(contparam, getIdpremio());
			contparam++;
		}

		st.executeUpdate();

	}

	public static void insertPremio(HttpServletRequest request, HttpServletResponse response, Connection conn, long user) throws Exception {

		PrintWriter out = response.getWriter();
		JSONObject objRetorno = new JSONObject();
		JSONObject param = Utilitario.getJsonFromRequest(request, response);

		if (param.get("desc_name").toString().equalsIgnoreCase("")) {
			throw new Exception("Você deve inserir o nome da sua camapanha.");
		}

		if (param.get("desc_path").toString().equalsIgnoreCase("")) {
			throw new Exception("Você deve inserir a url do seu premio.");
		}

		UserPremio up = new UserPremio(conn);
		up.setIdusuario(user);
		up.setDescname(param.get("desc_name").toString());
		up.setDescpath(param.get("desc_path").toString());
		up.insert();

		objRetorno.put("msgok", "ok");
		objRetorno.put("msg", "Prêmio salvo!");

		out.print(objRetorno.toJSONString());

	}

}