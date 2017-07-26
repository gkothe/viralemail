package com.phpdao.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserImagePage {

	private Long id_image;
	private Long id_associacao;
	private Long id_page;
	private String flag_pagetipe; // L = landpage, T = thankspage

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

	public Long getId_associacao() {
		return id_associacao;
	}

	public void setId_associacao(Long id_associacao) {
		this.id_associacao = id_associacao;
	}

	public Long getId_page() {
		return id_page;
	}

	public void setId_page(Long id_page) {
		this.id_page = id_page;
	}

	public String getFlag_pagetipe() {
		return flag_pagetipe;
	}

	public void setFlag_pagetipe(String flag_pagetipe) {
		this.flag_pagetipe = flag_pagetipe;
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

}
