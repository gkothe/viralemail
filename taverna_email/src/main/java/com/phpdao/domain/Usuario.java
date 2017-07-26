package com.phpdao.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Usuario implements java.io.Serializable {
	private Long idusuario;
	private Long codcidade;
	private String descnome;
	private String desctelefone;
	private String descendereco;
	private String numenderec;
	private String desccomplemento;
	private String desclogin;
	private String descsenha;
	private String descmail;
	private String flagativo;
	private java.util.Date datelastajax;
	private String numcpf;
	private String desccep;
	private String flagativado;
	private String chaveativacao;
	private String descnovoemailvalidacao;
	private String chaveativacaonovoemail;
	private PreparedStatement st;
	private StringBuffer sql;
	private ResultSet rs;
	private Connection conn;

	public Long getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(Long idusuario) {
		this.idusuario = idusuario;
	}

	public Long getCodcidade() {
		return codcidade;
	}

	public void setCodcidade(Long codcidade) {
		this.codcidade = codcidade;
	}

	public String getDescnome() {
		return descnome;
	}

	public void setDescnome(String descnome) {
		this.descnome = descnome;
	}

	public String getDesctelefone() {
		return desctelefone;
	}

	public void setDesctelefone(String desctelefone) {
		this.desctelefone = desctelefone;
	}

	public String getDescendereco() {
		return descendereco;
	}

	public void setDescendereco(String descendereco) {
		this.descendereco = descendereco;
	}

	public String getNumenderec() {
		return numenderec;
	}

	public void setNumenderec(String numenderec) {
		this.numenderec = numenderec;
	}

	public String getDesccomplemento() {
		return desccomplemento;
	}

	public void setDesccomplemento(String desccomplemento) {
		this.desccomplemento = desccomplemento;
	}

	public String getDesclogin() {
		return desclogin;
	}

	public void setDesclogin(String desclogin) {
		this.desclogin = desclogin;
	}

	public String getDescsenha() {
		return descsenha;
	}

	public void setDescsenha(String descsenha) {
		this.descsenha = descsenha;
	}

	public String getDescmail() {
		return descmail;
	}

	public void setDescmail(String descmail) {
		this.descmail = descmail;
	}

	public String getFlagativo() {
		return flagativo;
	}

	public void setFlagativo(String flagativo) {
		this.flagativo = flagativo;
	}

	public java.util.Date getDatelastajax() {
		return datelastajax;
	}

	public void setDatelastajax(java.util.Date datelastajax) {
		this.datelastajax = datelastajax;
	}

	public String getNumcpf() {
		return numcpf;
	}

	public void setNumcpf(String numcpf) {
		this.numcpf = numcpf;
	}

	public String getDesccep() {
		return desccep;
	}

	public void setDesccep(String desccep) {
		this.desccep = desccep;
	}

	public String getFlagativado() {
		return flagativado;
	}

	public void setFlagativado(String flagativado) {
		this.flagativado = flagativado;
	}

	public String getChaveativacao() {
		return chaveativacao;
	}

	public void setChaveativacao(String chaveativacao) {
		this.chaveativacao = chaveativacao;
	}

	public String getDescnovoemailvalidacao() {
		return descnovoemailvalidacao;
	}

	public void setDescnovoemailvalidacao(String descnovoemailvalidacao) {
		this.descnovoemailvalidacao = descnovoemailvalidacao;
	}

	public String getChaveativacaonovoemail() {
		return chaveativacaonovoemail;
	}

	public void setChaveativacaonovoemail(String chaveativacaonovoemail) {
		this.chaveativacaonovoemail = chaveativacaonovoemail;
	}


	public ResultSet lista() throws Exception {

		sql = new StringBuffer();
		sql.append(" select * from usuario where  1=1 ");

		if (getDescmail() != null) {
			sql.append(" and  desc_mail = ? ");
		}
		
		if (getDesclogin() != null) {
			sql.append(" and  desc_login = ? ");
		}
		
		if (getChaveativacao() != null) {
			sql.append(" and chave_ativacao = ? ");
		}

		st = conn.prepareStatement(sql.toString());
		
		int contparam = 1;
		if (getDescmail() != null) {
			st.setString(contparam, getDescmail());
			contparam++;
		}
		
		if (getDesclogin() != null) {
			st.setString(contparam, getDesclogin());
			contparam++;
		}
		
		if (getChaveativacao() != null) {
			st.setString(contparam, getChaveativacao());
			contparam++;
		}

		rs = st.executeQuery();

		return rs;
	}

	public Usuario(Connection conn) {
		super();
		this.conn = conn;
	}

}