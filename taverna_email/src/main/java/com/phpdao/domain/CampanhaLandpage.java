package com.phpdao.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.funcs.Utilitario;

public class CampanhaLandpage implements java.io.Serializable {
	private Long idlandpage;
	private Long idcampanha;
	private String desctitulo1;
	private String descsubtitulo1;
	private String urlvideo;
	private String desccampanha;
	private String desctitulo2;
	private String subtitulo2;
	private Long qtdimage;
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

	public Long getIdcampanha() {
		return idcampanha;
	}

	public void setIdcampanha(Long idcampanha) {
		this.idcampanha = idcampanha;
	}

	public String getDesctitulo1() {
		return desctitulo1;
	}

	public void setDesctitulo1(String desctitulo1) {
		this.desctitulo1 = desctitulo1;
	}

	public String getDescsubtitulo1() {
		return descsubtitulo1;
	}

	public void setDescsubtitulo1(String descsubtitulo1) {
		this.descsubtitulo1 = descsubtitulo1;
	}

	public String getUrlvideo() {
		return urlvideo;
	}

	public void setUrlvideo(String urlvideo) {
		this.urlvideo = urlvideo;
	}

	public String getDesccampanha() {
		return desccampanha;
	}

	public void setDesccampanha(String desccampanha) {
		this.desccampanha = desccampanha;
	}

	public String getDesctitulo2() {
		return desctitulo2;
	}

	public void setDesctitulo2(String desctitulo2) {
		this.desctitulo2 = desctitulo2;
	}

	public String getSubtitulo2() {
		return subtitulo2;
	}

	public void setSubtitulo2(String subtitulo2) {
		this.subtitulo2 = subtitulo2;
	}

	public Long getQtdimage() {
		return qtdimage;
	}

	public void setQtdimage(Long qtdimage) {
		this.qtdimage = qtdimage;
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

	public CampanhaLandpage(Connection conn) {
		super();
		this.conn = conn;
	}

	public void delete() throws Exception {

		sql = new StringBuffer();
		sql.append("delete from campanha_landpage where 1=1 ");

		if (getIdcampanha() != null && getIdcampanha() != 0) {
			sql.append("and id_campanha = ? ");
		}

		if (getIdlandpage() != null && getIdlandpage() != 0) {
			sql.append("and id_landpage = ? ");
		}

		st = conn.prepareStatement(sql.toString());

		int contparam = 1;

		if (getIdcampanha() != null && getIdcampanha() != 0) {
			st.setLong(contparam, getIdcampanha());
			contparam++;
		}

		if (getIdlandpage() != null && getIdlandpage() != 0) {
			st.setLong(contparam, getIdlandpage());
			contparam++;
		}

		st.executeUpdate();

	}

	public void Insert() throws Exception {

		sql = new StringBuffer();
		sql.append("	INSERT INTO campanha_landpage (id_landpage) value (?) ");
		st = conn.prepareStatement(sql.toString());
		long id_landpage = Utilitario.retornaIdinsertLong("campanha_landpage", "id_landpage", conn);
		st.setLong(1, id_landpage);

		if (st.executeUpdate() == 1) {
			setIdlandpage(id_landpage);
			update();
		} else {
			throw new Exception("Erro, contate suporte. Inserção de land page.");
		}

	}

	public void update() throws Exception {

		sql = new StringBuffer();
		sql.append("	update campanha_landpage set id_landpage =  " + getIdlandpage() + " "); // seta a pk soh para ter um "set"

		if (getDesctitulo1() != null) {
			sql.append(", desc_titulo_1 = ? ");
		}

		if (getDescsubtitulo1() != null) {
			sql.append(", desc_sub_titulo_1 = ? ");
		}

		if (getUrlvideo() != null) {
			sql.append(", url_video = ? ");
		}

		if (getDesccampanha() != null) {
			sql.append(", desc_campanha = ? ");
		}

		if (getDesctitulo2() != null) {
			sql.append(", desc_titulo_2 = ? ");
		}

		if (getSubtitulo2() != null) {
			sql.append(", sub_titulo_2 = ? ");
		}

		if (getIdcampanha() != null && getIdcampanha() != 0) {
			sql.append(", id_campanha = ? ");
		}

		sql.append(" where id_landpage = " + getIdlandpage() + " ");

		st = conn.prepareStatement(sql.toString());

		int contparam = 1;

		if (getDesctitulo1() != null) {
			st.setString(contparam, getDesctitulo1());
			contparam++;
		}

		if (getDescsubtitulo1() != null) {
			st.setString(contparam, getDescsubtitulo1());
			contparam++;
		}

		if (getUrlvideo() != null) {
			st.setString(contparam, getUrlvideo());
			contparam++;
		}

		if (getDesccampanha() != null) {
			st.setString(contparam, getDesccampanha());
			contparam++;
		}

		if (getDesctitulo2() != null) {
			st.setString(contparam, getDesctitulo2());
			contparam++;
		}

		if (getSubtitulo2() != null) {
			st.setString(contparam, getSubtitulo2());
			contparam++;
		}

		if (getIdcampanha() != null && getIdcampanha() != 0) {
			st.setLong(contparam, getIdcampanha());
			contparam++;
		}

		if (st.executeUpdate() == 1) {

		} else {
			throw new Exception("Erro, contate suporte. Update de land page.");
		}

	}

}