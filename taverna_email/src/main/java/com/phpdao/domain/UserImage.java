package com.phpdao.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserImage {

	private Long id_image;
	private Long id_usuario;
	private String desc_image;
	private String desc_path_system;

	private PreparedStatement st;
	private StringBuffer sql;
	private ResultSet rs;
	private Connection conn;

	public Long getId_image() {
		return id_image;
	}

	public void setId_image(Long id_image) {
		this.id_image = id_image;
	}

	public Long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getDesc_image() {
		return desc_image;
	}

	public void setDesc_image(String desc_image) {
		this.desc_image = desc_image;
	}

	public String getDesc_path_system() {
		return desc_path_system;
	}

	public void setDesc_path_system(String desc_path_system) {
		this.desc_path_system = desc_path_system;
	}

	public PreparedStatement getSt() {
		return st;
	}

	public void setSt(PreparedStatement st) {
		this.st = st;
	}

	public StringBuffer getSql() {
		return sql;
	}

	public void setSql(StringBuffer sql) {
		this.sql = sql;
	}

	public ResultSet getRs() {
		return rs;
	}

	public void setRs(ResultSet rs) {
		this.rs = rs;
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public UserImage(Connection conn) {
		super();
		this.conn = conn;
	}

	public ResultSet lista() throws Exception {

		sql = new StringBuffer();
		sql.append(" select * from user_image where  1=1 ");

		if (getId_image() != null && getId_image() != 0) {
			sql.append("and id_image = ? ");
		}

		if (getId_usuario() != null && getId_usuario() != 0) {
			sql.append("and id_usuario = ? ");
		}

		st = conn.prepareStatement(sql.toString());

		int contparam = 1;

		if (getId_image() != null && getId_image() != 0) {
			st.setLong(contparam, getId_image());
			contparam++;
		}

		if (getId_usuario() != null && getId_usuario() != 0) {
			st.setLong(contparam, getId_usuario());
			contparam++;
		}

		rs = st.executeQuery();

		return rs;
	}

}
