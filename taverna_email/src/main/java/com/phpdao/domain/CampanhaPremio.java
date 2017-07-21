package com.phpdao.domain;

public class CampanhaPremio implements java.io.Serializable{
	private Long IDPREMIO;
	private Long IDCAMPANHA;
	private String DESCNAME;
	private String DESCEXTENSAO;
	private String DESCPATH;
	private java.util.Date DATAINSERCAO;

	public Long getIDPREMIO(){
		return this.IDPREMIO;
	}

	public Long getIDCAMPANHA(){
		return this.IDCAMPANHA;
	}

	public String getDESCNAME(){
		return this.DESCNAME;
	}

	public String getDESCEXTENSAO(){
		return this.DESCEXTENSAO;
	}

	public String getDESCPATH(){
		return this.DESCPATH;
	}

	public java.util.Date getDATAINSERCAO(){
		return this.DATAINSERCAO;
	}


	public void setIDPREMIO(Long IDPREMIO){
		this.IDPREMIO = IDPREMIO;
	}

	public void setIDCAMPANHA(Long IDCAMPANHA){
		this.IDCAMPANHA = IDCAMPANHA;
	}

	public void setDESCNAME(String DESCNAME){
		this.DESCNAME = DESCNAME;
	}

	public void setDESCEXTENSAO(String DESCEXTENSAO){
		this.DESCEXTENSAO = DESCEXTENSAO;
	}

	public void setDESCPATH(String DESCPATH){
		this.DESCPATH = DESCPATH;
	}

	public void setDATAINSERCAO(java.util.Date DATAINSERCAO){
		this.DATAINSERCAO = DATAINSERCAO;
	}

}