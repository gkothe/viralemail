package com.phpdao.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.funcs.Utilitario;

public class CampanhaEmailPremio implements java.io.Serializable {
	private Long idemail;
	private Long idpremio;

	private PreparedStatement st;
	private StringBuffer sql;
	private ResultSet rs;
	private Connection conn;

	public Long getIdemail() {
		return idemail;
	}

	public void setIdemail(Long idemail) {
		this.idemail = idemail;
	}

	public Long getIdpremio() {
		return idpremio;
	}

	public void setIdpremio(Long idpremio) {
		this.idpremio = idpremio;
	}

	public CampanhaEmailPremio(Connection conn) {
		super();
		this.conn = conn;
	}

	public void delete() throws Exception {

		sql = new StringBuffer();
		sql.append("delete from campanha_email_premio where 1=1 ");

		if (getIdpremio() != null && getIdpremio() != 0) {
			sql.append("and id_premio = ? ");
		}

		if (getIdemail() != null && getIdemail() != 0) {
			sql.append("and id_email = ? ");
		}

		st = conn.prepareStatement(sql.toString());

		int contparam = 1;

		if (getIdpremio() != null && getIdpremio() != 0) {
			st.setLong(contparam, getIdpremio());
			contparam++;
		}

		if (getIdemail() != null && getIdemail() != 0) {
			st.setLong(contparam, getIdemail());
			contparam++;
		}

		st.executeUpdate();

	}

	public ResultSet lista() throws Exception {

		sql = new StringBuffer();
		sql.append(" select * from campanha_email_premio where  1=1 ");

		if (getIdpremio() != null && getIdpremio() != 0) {
			sql.append("and id_premio = ? ");
		}

		if (getIdemail() != null && getIdemail() != 0) {
			sql.append("and id_email = ? ");
		}

		st = conn.prepareStatement(sql.toString());

		int contparam = 1;

		if (getIdpremio() != null && getIdpremio() != 0) {
			st.setLong(contparam, getIdpremio());
			contparam++;
		}

		if (getIdemail() != null && getIdemail() != 0) {
			st.setLong(contparam, getIdemail());
			contparam++;
		}

		rs = st.executeQuery();

		return rs;

	}

	public void Insert() throws Exception {

		sql = new StringBuffer();
		sql.append("	INSERT INTO campanha_email_premio (id_premio, id_email) value (?,?) ");
		st = conn.prepareStatement(sql.toString());
		st.setLong(1, getIdpremio());
		st.setLong(2, getIdemail());

		if (st.executeUpdate() == 1) {

		} else {
			throw new Exception("Erro, contate suporte. Inserção de relação de email e prêmio.");
		}

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