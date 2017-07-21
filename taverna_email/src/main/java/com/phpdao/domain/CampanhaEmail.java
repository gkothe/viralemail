package com.phpdao.domain;

public class CampanhaEmail implements java.io.Serializable{
	private Long IDEMAIL;
	private Long IDCAMPANHA;
	private String DESCEMAIL;
	private String DESCTITULO;

	public Long getIDEMAIL(){
		return this.IDEMAIL;
	}

	public Long getIDCAMPANHA(){
		return this.IDCAMPANHA;
	}

	public String getDESCEMAIL(){
		return this.DESCEMAIL;
	}

	public String getDESCTITULO(){
		return this.DESCTITULO;
	}


	public void setIDEMAIL(Long IDEMAIL){
		this.IDEMAIL = IDEMAIL;
	}

	public void setIDCAMPANHA(Long IDCAMPANHA){
		this.IDCAMPANHA = IDCAMPANHA;
	}

	public void setDESCEMAIL(String DESCEMAIL){
		this.DESCEMAIL = DESCEMAIL;
	}

	public void setDESCTITULO(String DESCTITULO){
		this.DESCTITULO = DESCTITULO;
	}

}