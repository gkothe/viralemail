package com.phpdao.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.funcs.Utilitario;

public class CampanhaEmail implements java.io.Serializable {
	private Long idemail;
	private Long idcampanha;
	private String descemail;
	private String desctitulo;
	private Integer qtd_referencia;
	private PreparedStatement st;
	private StringBuffer sql;
	private ResultSet rs;
	private Connection conn;

	public Integer getQtd_referencia() {
		return qtd_referencia;
	}

	public void setQtd_referencia(Integer qtd_referencia) {
		this.qtd_referencia = qtd_referencia;
	}

	public Long getIdemail() {
		return idemail;
	}

	public void setIdemail(Long idemail) {
		this.idemail = idemail;
	}

	public Long getIdcampanha() {
		return idcampanha;
	}

	public void setIdcampanha(Long idcampanha) {
		this.idcampanha = idcampanha;
	}

	public String getDescemail() {
		return descemail;
	}

	public void setDescemail(String descemail) {
		this.descemail = descemail;
	}

	public String getDesctitulo() {
		return desctitulo;
	}

	public void setDesctitulo(String desctitulo) {
		this.desctitulo = desctitulo;
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

	public CampanhaEmail(Connection conn) {
		super();
		this.conn = conn;
	}

	public void Insert() throws Exception {

		sql = new StringBuffer();
		sql.append("	INSERT INTO campanha_email (id_email) value (?) ");
		st = conn.prepareStatement(sql.toString());
		long id = Utilitario.retornaIdinsertLong("campanha_email", "id_email", conn);
		st.setLong(1, id);

		if (st.executeUpdate() == 1) {
			setIdemail(id);
			update();
		} else {
			throw new Exception("Erro, contate suporte. Inserção de Email da campanha.");
		}

	}

	public void update() throws Exception {

		sql = new StringBuffer();
		sql.append("	update campanha_email set id_email =  " + getIdemail() + " "); // seta a pk soh para ter um "set"

		if (getIdcampanha() != null && getIdcampanha() != 0) {
			sql.append(", id_campanha = ? ");
		}

		if (getDescemail() != null) {
			sql.append(", desc_email = ? ");
		}

		if (getDesctitulo() != null) {
			sql.append(", desc_titulo = ? ");
		}

		if (getQtd_referencia() != null) {
			sql.append(", qtd_referencia = ? ");
		}

		sql.append(" where id_email = " + getIdemail() + " ");

		st = conn.prepareStatement(sql.toString());

		int contparam = 1;

		if (getIdcampanha() != null && getIdcampanha() != 0) {
			st.setLong(contparam, getIdcampanha());
			contparam++;
		}

		if (getDescemail() != null) {
			st.setString(contparam, getDescemail());
			contparam++;
		}

		if (getDesctitulo() != null) {
			st.setString(contparam, getDesctitulo());
			contparam++;
		}

		if (getQtd_referencia() != null) {
			st.setInt(contparam, getQtd_referencia());
			contparam++;
		}

		if (st.executeUpdate() == 1) {

		} else {
			throw new Exception("Erro, contate suporte. Update de land page.");
		}

	}

	public void delete() throws Exception {

		sql = new StringBuffer();
		sql.append("delete from campanha_email where 1=1 ");

		if (getIdcampanha() != null && getIdcampanha() != 0) {
			sql.append("and id_campanha = ? ");
		}

		if (getIdemail() != null && getIdemail() != 0) {
			sql.append("and id_email = ? ");
		}

		st = conn.prepareStatement(sql.toString());

		int contparam = 1;

		if (getIdcampanha() != null && getIdcampanha() != 0) {
			st.setLong(contparam, getIdcampanha());
			contparam++;
		}

		if (getIdemail() != null && getIdemail() != 0) {
			st.setLong(contparam, getIdemail());
			contparam++;
		}

		st.executeUpdate();

	}

}