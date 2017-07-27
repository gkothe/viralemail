package com.phpdao.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.funcs.Utilitario;

public class UserImagePage {

	private Long id_image;
	private Long id_associacao;
	private Long id_page;
	private String flag_pagetipe; // L = landpage, T = thankspage
	private Long id_campanha;
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

	public Long getId_campanha() {
		return id_campanha;
	}

	public void setId_campanha(Long id_campanha) {
		this.id_campanha = id_campanha;
	}

	public UserImagePage(Connection conn) {
		super();
		this.conn = conn;
	}

	public ResultSet lista() throws Exception {

		sql = new StringBuffer();
		sql.append(" select * from user_image_page where  1=1 ");

		if (getId_image() != null && getId_image() != 0) {
			sql.append("and id_image = ? ");
		}

		if (getId_page() != null && getId_page() != 0) {
			sql.append("and id_page = ? ");
		}

		if (getFlag_pagetipe() != null) {
			sql.append("and flag_pagetipe = ? ");
		}

		if (getId_campanha() != null && getId_page() != 0) {
			sql.append("and id_campanha = ? ");
		}

		if (getId_associacao() != null && getId_associacao() != 0) {
			sql.append("and id_associacao = ? ");
		}

		st = conn.prepareStatement(sql.toString());

		int contparam = 1;

		if (getId_image() != null && getId_image() != 0) {
			st.setLong(contparam, getId_image());
			contparam++;
		}

		if (getId_page() != null && getId_page() != 0) {
			st.setLong(contparam, getId_page());
			contparam++;
		}

		if (getFlag_pagetipe() != null) {
			st.setString(contparam, getFlag_pagetipe());
			contparam++;
		}

		if (getId_campanha() != null && getId_campanha() != 0) {
			st.setLong(contparam, getId_campanha());
			contparam++;
		}

		if (getId_associacao() != null && getId_associacao() != 0) {
			st.setLong(contparam, getId_campanha());
			contparam++;
		}

		rs = st.executeQuery();

		return rs;
	}

	public void delete() throws Exception {

		sql = new StringBuffer();
		sql.append("delete from user_image_page where 1=1 ");

		if (getId_campanha() != null && getId_campanha() != 0) {
			sql.append("and id_campanha = ? ");
		}

		if (getId_associacao() != null && getId_associacao() != 0) {
			sql.append("and id_associacao = ? ");
		}

		if (getId_image() != null && getId_image() != 0) {
			sql.append("and id_image = ? ");
		}

		st = conn.prepareStatement(sql.toString());

		int contparam = 1;

		if (getId_campanha() != null && getId_campanha() != 0) {
			st.setLong(contparam, getId_campanha());
			contparam++;
		}

		if (getId_associacao() != null && getId_associacao() != 0) {
			st.setLong(contparam, getId_associacao());
			contparam++;
		}

		if (getId_image() != null && getId_image() != 0) {
			st.setLong(contparam, getId_image());
			contparam++;
		}

		st.executeUpdate();

	}

	public void Insert() throws Exception {

		sql = new StringBuffer();
		sql.append("	INSERT INTO user_image_page (id_associacao) value (?) ");
		st = conn.prepareStatement(sql.toString());
		long id = Utilitario.retornaIdinsertLong("user_image_page", "id_associacao", conn);
		st.setLong(1, id);

		if (st.executeUpdate() == 1) {
			setId_associacao(id);
			update();
		} else {
			throw new Exception("Erro, contate suporte. Inserção de land page.");
		}

	}

	public void update() throws Exception {

		sql = new StringBuffer();
		sql.append("	update user_image_page set id_associacao =  " + getId_associacao() + " "); // seta a pk soh para ter um "set"

		if (getId_image() != null && getId_image() != 0) {
			sql.append(", id_image = ? ");
		}

		if (getId_page() != null && getId_page() != 0) {
			sql.append(", id_page = ? ");
		}

		if (getFlag_pagetipe() != null) {
			sql.append(", flag_pagetipe = ? ");
		}

		if (getId_campanha() != null && getId_page() != 0) {
			sql.append(", id_campanha = ? ");
		}

		sql.append(" where id_associacao = " + getId_associacao() + " ");

		st = conn.prepareStatement(sql.toString());

		int contparam = 1;

		if (getId_image() != null && getId_image() != 0) {
			st.setLong(contparam, getId_image());
			contparam++;
		}

		if (getId_page() != null && getId_page() != 0) {
			st.setLong(contparam, getId_page());
			contparam++;
		}

		if (getFlag_pagetipe() != null) {
			st.setString(contparam, getFlag_pagetipe());
			contparam++;
		}

		if (getId_campanha() != null && getId_campanha() != 0) {
			st.setLong(contparam, getId_campanha());
			contparam++;
		}

		if (st.executeUpdate() == 1) {

		} else {
			throw new Exception("Erro, contate suporte. Update de land page.");
		}

	}

}
