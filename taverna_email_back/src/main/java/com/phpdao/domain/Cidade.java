package com.phpdao.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Cidade implements java.io.Serializable{
	private Long codcidade;
	private String desccidade;
	private	PreparedStatement st;
	private StringBuffer sql;
	private ResultSet rs;
	private Connection conn;
	
	
	public Long getCodcidade() {
		return codcidade;
	}
	public void setCodcidade(Long codcidade) {
		this.codcidade = codcidade;
	}
	public String getDesccidade() {
		return desccidade;
	}
	public void setDesccidade(String desccidade) {
		this.desccidade = desccidade;
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
	
	public Cidade(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public ResultSet lista() throws Exception{
		
		sql = new StringBuffer();
		sql.append(" select * from cidade where  1=1 ");
		
		if(getCodcidade()!=null){
			sql.append(" and cod_cidade = ? ");
		}
		
		st = conn.prepareStatement(sql.toString());
		int contparam = 1;
		if(getCodcidade()!=null){
			st.setLong(contparam, getCodcidade());
			contparam++;
		}
		
		rs = st.executeQuery();
		
		return rs;
	}
	
	
}