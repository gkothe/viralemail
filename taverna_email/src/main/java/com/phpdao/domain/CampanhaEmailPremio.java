package com.phpdao.domain;

public class CampanhaEmailPremio implements java.io.Serializable{
	private Long IDEMAIL;
	private Long IDPREMIO;

	public Long getIDEMAIL(){
		return this.IDEMAIL;
	}

	public Long getIDPREMIO(){
		return this.IDPREMIO;
	}


	public void setIDEMAIL(Long IDEMAIL){
		this.IDEMAIL = IDEMAIL;
	}

	public void setIDPREMIO(Long IDPREMIO){
		this.IDPREMIO = IDPREMIO;
	}

}