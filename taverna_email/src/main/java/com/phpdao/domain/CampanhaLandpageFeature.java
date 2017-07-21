package com.phpdao.domain;

public class CampanhaLandpageFeature implements java.io.Serializable{
	private Long IDLANDPAGE;
	private Long IDFEATURE;
	private String DESCFEATURE;
	private String DESCCLASSICON;

	public Long getIDLANDPAGE(){
		return this.IDLANDPAGE;
	}

	public Long getIDFEATURE(){
		return this.IDFEATURE;
	}

	public String getDESCFEATURE(){
		return this.DESCFEATURE;
	}

	public String getDESCCLASSICON(){
		return this.DESCCLASSICON;
	}


	public void setIDLANDPAGE(Long IDLANDPAGE){
		this.IDLANDPAGE = IDLANDPAGE;
	}

	public void setIDFEATURE(Long IDFEATURE){
		this.IDFEATURE = IDFEATURE;
	}

	public void setDESCFEATURE(String DESCFEATURE){
		this.DESCFEATURE = DESCFEATURE;
	}

	public void setDESCCLASSICON(String DESCCLASSICON){
		this.DESCCLASSICON = DESCCLASSICON;
	}

}