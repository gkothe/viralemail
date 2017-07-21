package com.phpdao.domain;

public class Campanha implements java.io.Serializable{
	private Long IDCAMPANHA;
	private Long IDUSUARIO;
	private java.util.Date DATACRIACAO;
	private String LINKINICIAL;

	public Long getIDCAMPANHA(){
		return this.IDCAMPANHA;
	}

	public Long getIDUSUARIO(){
		return this.IDUSUARIO;
	}

	public java.util.Date getDATACRIACAO(){
		return this.DATACRIACAO;
	}

	public String getLINKINICIAL(){
		return this.LINKINICIAL;
	}


	public void setIDCAMPANHA(Long IDCAMPANHA){
		this.IDCAMPANHA = IDCAMPANHA;
	}

	public void setIDUSUARIO(Long IDUSUARIO){
		this.IDUSUARIO = IDUSUARIO;
	}

	public void setDATACRIACAO(java.util.Date DATACRIACAO){
		this.DATACRIACAO = DATACRIACAO;
	}

	public void setLINKINICIAL(String LINKINICIAL){
		this.LINKINICIAL = LINKINICIAL;
	}

}