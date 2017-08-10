package com.phpdao.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.funcs.Utilitario;

public class CampanhaThankspage implements java.io.Serializable {
	private Long idthankspage;
	private Long idcampanha;
	private String msgthanks;
	private String subtitulo;
	private String urlvideo;
	private String descfrase;
	private String descfrase2;
	private String desctexto;

	private PreparedStatement st;
	private StringBuffer sql;
	private ResultSet rs;
	private Connection conn;

	public Long getIdthankspage() {
		return idthankspage;
	}

	public void setIdthankspage(Long idthankspage) {
		this.idthankspage = idthankspage;
	}

	public Long getIdcampanha() {
		return idcampanha;
	}

	public void setIdcampanha(Long idcampanha) {
		this.idcampanha = idcampanha;
	}

	public String getMsgthanks() {
		return msgthanks;
	}

	public void setMsgthanks(String msgthanks) {
		this.msgthanks = msgthanks;
	}

	public String getSubtitulo() {
		return subtitulo;
	}

	public void setSubtitulo(String subtitulo) {
		this.subtitulo = subtitulo;
	}

	public String getUrlvideo() {
		return urlvideo;
	}

	public void setUrlvideo(String urlvideo) {
		this.urlvideo = urlvideo;
	}

	public String getDescfrase() {
		return descfrase;
	}

	public void setDescfrase(String descfrase) {
		this.descfrase = descfrase;
	}

	public String getDescfrase2() {
		return descfrase2;
	}

	public void setDescfrase2(String descfrase2) {
		this.descfrase2 = descfrase2;
	}

	public String getDesctexto() {
		return desctexto;
	}

	public void setDesctexto(String desctexto) {
		this.desctexto = desctexto;
	}

	public CampanhaThankspage(Connection conn) {
		super();
		this.conn = conn;
	}

	public void delete() throws Exception {

		sql = new StringBuffer();
		sql.append("delete from campanha_thankspage where 1=1 ");

		if (getIdcampanha() != null && getIdcampanha() != 0) {
			sql.append("and id_campanha = ? ");
		}

		if (getIdthankspage() != null && getIdthankspage() != 0) {
			sql.append("and id_thankspage = ? ");
		}

		st = conn.prepareStatement(sql.toString());

		int contparam = 1;

		if (getIdcampanha() != null && getIdcampanha() != 0) {
			st.setLong(contparam, getIdcampanha());
			contparam++;
		}

		if (getIdthankspage() != null && getIdthankspage() != 0) {
			st.setLong(contparam, getIdthankspage());
			contparam++;
		}

		st.executeUpdate();

	}

	public void Insert() throws Exception {

		sql = new StringBuffer();
		sql.append("	INSERT INTO campanha_thankspage (id_thankspage) value (?) ");
		st = conn.prepareStatement(sql.toString());
		long id = Utilitario.retornaIdinsertLong("campanha_thankspage", "id_thankspage", conn);
		st.setLong(1, id);

		if (st.executeUpdate() == 1) {
			setIdthankspage(id);
			update();
		} else {
			throw new Exception("Erro, contate suporte. Inserção de land page.");
		}

	}

	public void update() throws Exception {

		sql = new StringBuffer();
		sql.append("	update campanha_thankspage set id_thankspage =  " + getIdthankspage() + " "); // seta a pk soh para ter um "set"

		if (getMsgthanks() != null) {
			sql.append(", msg_thanks = ? ");
		}

		if (getSubtitulo() != null) {
			sql.append(", sub_titulo = ? ");
		}

		if (getUrlvideo() != null) {
			sql.append(", url_video = ? ");
		}

		if (getDescfrase() != null) {
			sql.append(", desc_frase = ? ");
		}

		if (getDescfrase2() != null) {
			sql.append(", desc_frase2 = ? ");
		}

		if (getDesctexto() != null) {
			sql.append(", desc_texto = ? ");
		}

		if (getIdcampanha() != null && getIdcampanha() != 0) {
			sql.append(", id_campanha = ? ");
		}

		sql.append(" where id_thankspage = " + getIdthankspage() + " ");

		st = conn.prepareStatement(sql.toString());

		int contparam = 1;

		if (getMsgthanks() != null) {
			st.setString(contparam, getMsgthanks());
			contparam++;
		}

		if (getSubtitulo() != null) {
			st.setString(contparam, getSubtitulo());
			contparam++;
		}

		if (getUrlvideo() != null) {
			st.setString(contparam, getUrlvideo());
			contparam++;
		}

		if (getDescfrase() != null) {
			st.setString(contparam, getDescfrase());
			contparam++;
		}

		if (getDescfrase2() != null) {
			st.setString(contparam, getDescfrase2());
			contparam++;
		}

		if (getDesctexto() != null) {
			st.setString(contparam, getDesctexto());
			contparam++;
		}

		if (getIdcampanha() != null && getIdcampanha() != 0) {
			sql.append(", id_campanha = ? ");
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