package com.phpdao.domain;

public class CampanhaLead implements java.io.Serializable{
	private Long IDLEAD;
	private Long IDCAMPANHA;
	private Long IDLEADREFERENCIA;
	private String DESCEMAIL;
	private String DESCLINKREFERAL;

	public Long getIDLEAD(){
		return this.IDLEAD;
	}

	public Long getIDCAMPANHA(){
		return this.IDCAMPANHA;
	}

	public Long getIDLEADREFERENCIA(){
		return this.IDLEADREFERENCIA;
	}

	public String getDESCEMAIL(){
		return this.DESCEMAIL;
	}

	public String getDESCLINKREFERAL(){
		return this.DESCLINKREFERAL;
	}


	public void setIDLEAD(Long IDLEAD){
		this.IDLEAD = IDLEAD;
	}

	public void setIDCAMPANHA(Long IDCAMPANHA){
		this.IDCAMPANHA = IDCAMPANHA;
	}

	public void setIDLEADREFERENCIA(Long IDLEADREFERENCIA){
		this.IDLEADREFERENCIA = IDLEADREFERENCIA;
	}

	public void setDESCEMAIL(String DESCEMAIL){
		this.DESCEMAIL = DESCEMAIL;
	}

	public void setDESCLINKREFERAL(String DESCLINKREFERAL){
		this.DESCLINKREFERAL = DESCLINKREFERAL;
	}

}