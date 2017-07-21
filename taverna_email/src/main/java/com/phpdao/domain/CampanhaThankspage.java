package com.phpdao.domain;

public class CampanhaThankspage implements java.io.Serializable{
	private Long IDTHANKSPAGE;
	private Long IDCAMPANHA;
	private String MSGTHANKS;
	private String SUBTITULO;
	private String URLVIDEO;
	private String DESCFRASE;
	private String DESCFRASE2;
	private String DESCTEXTO;

	public Long getIDTHANKSPAGE(){
		return this.IDTHANKSPAGE;
	}

	public Long getIDCAMPANHA(){
		return this.IDCAMPANHA;
	}

	public String getMSGTHANKS(){
		return this.MSGTHANKS;
	}

	public String getSUBTITULO(){
		return this.SUBTITULO;
	}

	public String getURLVIDEO(){
		return this.URLVIDEO;
	}

	public String getDESCFRASE(){
		return this.DESCFRASE;
	}

	public String getDESCFRASE2(){
		return this.DESCFRASE2;
	}

	public String getDESCTEXTO(){
		return this.DESCTEXTO;
	}


	public void setIDTHANKSPAGE(Long IDTHANKSPAGE){
		this.IDTHANKSPAGE = IDTHANKSPAGE;
	}

	public void setIDCAMPANHA(Long IDCAMPANHA){
		this.IDCAMPANHA = IDCAMPANHA;
	}

	public void setMSGTHANKS(String MSGTHANKS){
		this.MSGTHANKS = MSGTHANKS;
	}

	public void setSUBTITULO(String SUBTITULO){
		this.SUBTITULO = SUBTITULO;
	}

	public void setURLVIDEO(String URLVIDEO){
		this.URLVIDEO = URLVIDEO;
	}

	public void setDESCFRASE(String DESCFRASE){
		this.DESCFRASE = DESCFRASE;
	}

	public void setDESCFRASE2(String DESCFRASE2){
		this.DESCFRASE2 = DESCFRASE2;
	}

	public void setDESCTEXTO(String DESCTEXTO){
		this.DESCTEXTO = DESCTEXTO;
	}

}