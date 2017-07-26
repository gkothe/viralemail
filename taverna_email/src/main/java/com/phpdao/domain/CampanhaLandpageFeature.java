package com.phpdao.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CampanhaLandpageFeature implements java.io.Serializable{
	private Long idlandpage;
	private Long idfeature;
	private String descfeature;
	private String descclassicon;
	private PreparedStatement st;
	private StringBuffer sql;
	private ResultSet rs;
	private Connection conn;
	public Long getIdlandpage() {
		return idlandpage;
	}
	public void setIdlandpage(Long idlandpage) {
		this.idlandpage = idlandpage;
	}
	public Long getIdfeature() {
		return idfeature;
	}
	public void setIdfeature(Long idfeature) {
		this.idfeature = idfeature;
	}
	public String getDescfeature() {
		return descfeature;
	}
	public void setDescfeature(String descfeature) {
		this.descfeature = descfeature;
	}

	public String getDescclassicon() {
		return descclassicon;
	}
	public void setDescclassicon(String descclassicon) {
		this.descclassicon = descclassicon;
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
	
	public CampanhaLandpageFeature(Connection conn) {
		super();
		this.conn = conn;
	}
	
	
	
	

}