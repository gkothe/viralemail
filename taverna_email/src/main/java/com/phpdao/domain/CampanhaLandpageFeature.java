package com.phpdao.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.funcs.Utilitario;

public class CampanhaLandpageFeature implements java.io.Serializable {
	private Long idlandpage;
	private Long idfeature;
	private String descfeature;
	private String descclassicon;
	private String descname;
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

	public String getDescname() {
		return descname;
	}

	public void setDescname(String descname) {
		this.descname = descname;
	}

	public void Insert() throws Exception {

		sql = new StringBuffer();
		sql.append("	INSERT INTO campanha_landpage_features (id_landpage,id_feature) value (?,?) ");
		st = conn.prepareStatement(sql.toString());
		long id = Utilitario.retornaIdinsertChaveSecundariaLong("campanha_landpage_features", "id_landpage", getIdlandpage() + "", "id_feature", conn);
		st.setLong(1, getIdlandpage());
		st.setLong(2, id);

		if (st.executeUpdate() == 1) {
			setIdfeature(id);
			update();
		} else {
			throw new Exception("Erro, contate suporte. Inserção de land page.");
		}

	}

	public void update() throws Exception {

		sql = new StringBuffer();
		sql.append("	update campanha_landpage_features set id_landpage =  " + getIdlandpage() + " "); // seta a pk soh para ter um "set"

		if (getDescfeature() != null) {
			sql.append(", desc_feature = ? ");
		}

		if (getDescclassicon() != null) {
			sql.append(", desc_class_icon = ? ");
		}

		if (getDescname() != null) {
			sql.append(", desc_name = ? ");
		}

		sql.append(" where id_landpage = " + getIdlandpage() + " and id_feature = " + getIdfeature() + " ");

		st = conn.prepareStatement(sql.toString());

		int contparam = 1;

		if (getDescfeature() != null) {
			st.setString(contparam, getDescfeature());
			contparam++;
		}

		if (getDescclassicon() != null) {
			st.setString(contparam, getDescclassicon());
			contparam++;
		}

		if (getDescname() != null) {
			st.setString(contparam, getDescname());
			contparam++;
		}

		if (st.executeUpdate() == 1) {

		} else {
			throw new Exception("Erro, contate suporte. Update de land page.");
		}

	}

	public void delete() throws Exception {

		sql = new StringBuffer();
		sql.append("delete from campanha_landpage_features where 1=1 ");

		if (getIdfeature() != null && getIdfeature() != 0) {
			sql.append("and id_feature = ? ");
		}

		if (getIdlandpage() != null && getIdlandpage() != 0) {
			sql.append("and id_landpage = ? ");
		}

		st = conn.prepareStatement(sql.toString());

		int contparam = 1;

		if (getIdfeature() != null && getIdfeature() != 0) {
			st.setLong(contparam, getIdfeature());
			contparam++;
		}

		if (getIdlandpage() != null && getIdlandpage() != 0) {
			st.setLong(contparam, getIdlandpage());
			contparam++;
		}

		st.executeUpdate();

	}

}