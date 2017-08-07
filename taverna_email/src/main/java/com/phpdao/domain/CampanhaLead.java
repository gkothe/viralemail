package com.phpdao.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.funcs.Utilitario;

public class CampanhaLead implements java.io.Serializable {
	private Long idlead;
	private Long idcampanha;
	private Long idleadreferencia;
	private String descemail;
	private String desclinkreferal;

	private PreparedStatement st;
	private StringBuffer sql;
	private ResultSet rs;
	private Connection conn;

	public Long getIdlead() {
		return idlead;
	}

	public void setIdlead(Long idlead) {
		this.idlead = idlead;
	}

	public Long getIdcampanha() {
		return idcampanha;
	}

	public void setIdcampanha(Long idcampanha) {
		this.idcampanha = idcampanha;
	}

	public Long getIdleadreferencia() {
		return idleadreferencia;
	}

	public void setIdleadreferencia(Long idleadreferencia) {
		this.idleadreferencia = idleadreferencia;
	}

	public String getDescemail() {
		return descemail;
	}

	public void setDescemail(String descemail) {
		this.descemail = descemail;
	}

	public String getDesclinkreferal() {
		return desclinkreferal;
	}

	public void setDesclinkreferal(String desclinkreferal) {
		this.desclinkreferal = desclinkreferal;
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

	public CampanhaLead(Connection conn) {
		super();
		this.conn = conn;
	}

	public void delete() throws Exception {

		sql = new StringBuffer();
		sql.append("delete from campanha_leads where 1=1 ");

		if (getIdcampanha() != null && getIdcampanha() != 0) {
			sql.append("and id_campanha = ? ");
		}

		if (getIdlead() != null && getIdlead() != 0) {
			sql.append("and id_lead = ? ");
		}

		if (getIdleadreferencia() != null && getIdleadreferencia() != 0) {
			sql.append("and id_lead_referencia = ? ");
		}

		st = conn.prepareStatement(sql.toString());

		int contparam = 1;

		if (getIdcampanha() != null && getIdcampanha() != 0) {
			st.setLong(contparam, getIdcampanha());
			contparam++;
		}

		if (getIdlead() != null && getIdlead() != 0) {
			st.setLong(contparam, getIdlead());
			contparam++;
		}

		if (getIdleadreferencia() != null && getIdleadreferencia() != 0) {
			st.setLong(contparam, getIdleadreferencia());
			contparam++;
		}

		st.executeUpdate();

	}

	public ResultSet lista() throws Exception {

		sql = new StringBuffer();
		sql.append("	select * from  campanha_leads where 1=1 "); // seta a pk soh para ter um "set"

		if (getIdcampanha() != null && getIdcampanha() != 0) {
			sql.append("and id_campanha = ? ");
		}

		if (getIdlead() != null && getIdlead() != 0) {
			sql.append("and id_lead = ? ");
		}

		if (getIdleadreferencia() != null && getIdleadreferencia() != 0) {
			sql.append("and id_lead_referencia = ? ");
		}
		
		if (getDescemail() != null ) {
			sql.append("and desc_email = ? ");
		}
		
		st = conn.prepareStatement(sql.toString());

		int contparam = 1;

		if (getIdcampanha() != null && getIdcampanha() != 0) {
			st.setLong(contparam, getIdcampanha());
			contparam++;
		}

		if (getIdlead() != null && getIdlead() != 0) {
			st.setLong(contparam, getIdlead());
			contparam++;
		}

		if (getIdleadreferencia() != null && getIdleadreferencia() != 0) {
			st.setLong(contparam, getIdleadreferencia());
			contparam++;
		}
		
		if (getDescemail() != null ) {
			st.setString(contparam, getDescemail());
			contparam++;
		}

		rs = st.executeQuery();

		return rs;

	}

	public void insert() throws Exception {

		sql = new StringBuffer();
		sql.append("	INSERT INTO campanha_leads (id_lead) value (?) ");
		st = conn.prepareStatement(sql.toString());
		long id = Utilitario.retornaIdinsertLong("campanha_leads", "id_lead", conn);
		st.setLong(1, id);
		if (st.executeUpdate() == 1) {
			setIdlead(id);
			update();
		} else {
			throw new Exception("Erro, contate suporte. Inserção de lead.");
		}

	}

	public void update() throws Exception {

		sql = new StringBuffer();
		sql.append("	update campanha_leads set id_lead =  " + getIdlead() + " "); // seta a pk soh para ter um "set"

		if (getIdcampanha() != null && getIdcampanha() != 0) {
			sql.append(", id_campanha = ? ");
		}

		if (getIdleadreferencia() != null && getIdleadreferencia() != 0) {
			sql.append(", id_lead_referencia = ? ");
		}

		if (getDescemail() != null) {
			sql.append(", desc_email = ? ");
		}

		if (getDesclinkreferal() != null) {
			sql.append(", desc_link_referal = ? ");
		}

		sql.append(" where id_lead = " + getIdlead() + " ");

		st = conn.prepareStatement(sql.toString());

		int contparam = 1;

		if (getIdcampanha() != null && getIdcampanha() != 0) {
			st.setLong(contparam, getIdcampanha());
			contparam++;
		}

		if (getIdleadreferencia() != null && getIdleadreferencia() != 0) {
			st.setLong(contparam, getIdleadreferencia());
			contparam++;
		}

		if (getDescemail() != null) {
			st.setString(contparam, getDescemail());
			contparam++;
		}

		if (getDesclinkreferal() != null) {
			st.setString(contparam, getDesclinkreferal());
			contparam++;
		}

		if (st.executeUpdate() == 1) {

		} else {
			throw new Exception("Erro, contate suporte. Update de land page.");
		}

	}

}