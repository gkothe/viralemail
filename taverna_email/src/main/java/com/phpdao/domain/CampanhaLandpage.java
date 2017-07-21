package com.phpdao.domain;

public class CampanhaLandpage implements java.io.Serializable{
	private Long IDLANDPAGE;
	private Long IDCAMPANHA;
	private String DESCTITULO1;
	private String DESCSUBTITULO1;
	private String URLVIDEO;
	private String DESCCAMPANHA;
	private String DESCTITULO2;
	private String SUBTITULO2;
	private Long QTDIMAGE;

	public Long getIDLANDPAGE(){
		return this.IDLANDPAGE;
	}

	public Long getIDCAMPANHA(){
		return this.IDCAMPANHA;
	}

	public String getDESCTITULO1(){
		return this.DESCTITULO1;
	}

	public String getDESCSUBTITULO1(){
		return this.DESCSUBTITULO1;
	}

	public String getURLVIDEO(){
		return this.URLVIDEO;
	}

	public String getDESCCAMPANHA(){
		return this.DESCCAMPANHA;
	}

	public String getDESCTITULO2(){
		return this.DESCTITULO2;
	}

	public String getSUBTITULO2(){
		return this.SUBTITULO2;
	}

	public Long getQTDIMAGE(){
		return this.QTDIMAGE;
	}


	public void setIDLANDPAGE(Long IDLANDPAGE){
		this.IDLANDPAGE = IDLANDPAGE;
	}

	public void setIDCAMPANHA(Long IDCAMPANHA){
		this.IDCAMPANHA = IDCAMPANHA;
	}

	public void setDESCTITULO1(String DESCTITULO1){
		this.DESCTITULO1 = DESCTITULO1;
	}

	public void setDESCSUBTITULO1(String DESCSUBTITULO1){
		this.DESCSUBTITULO1 = DESCSUBTITULO1;
	}

	public void setURLVIDEO(String URLVIDEO){
		this.URLVIDEO = URLVIDEO;
	}

	public void setDESCCAMPANHA(String DESCCAMPANHA){
		this.DESCCAMPANHA = DESCCAMPANHA;
	}

	public void setDESCTITULO2(String DESCTITULO2){
		this.DESCTITULO2 = DESCTITULO2;
	}

	public void setSUBTITULO2(String SUBTITULO2){
		this.SUBTITULO2 = SUBTITULO2;
	}

	public void setQTDIMAGE(Long QTDIMAGE){
		this.QTDIMAGE = QTDIMAGE;
	}

}