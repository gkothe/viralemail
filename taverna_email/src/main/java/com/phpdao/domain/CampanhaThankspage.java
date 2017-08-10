package com.phpdao.domain; 
import java.sql.Connection; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import com.funcs.Utilitario; 
import java.util.Date; 
import java.sql.Timestamp; 

public class CampanhaThankspage { 

private PreparedStatement st; 
private StringBuffer sql; 
private ResultSet rs; 
private Connection conn; 
private String Where; 
private String Join; 
private String LastSentence; 
private String Select; 
public CampanhaThankspage(Connection conn) { super();this.conn = conn;} 
 private Long IdThankspage; 
 private Long rsIdThankspage; 
 private Long IdCampanha; 
 private Long rsIdCampanha; 
 private  boolean  nullIdCampanha = false; 
 private String MsgThanks; 
 private String rsMsgThanks; 
 private  boolean  nullMsgThanks = false; 
 private String SubTitulo; 
 private String rsSubTitulo; 
 private  boolean  nullSubTitulo = false; 
 private String UrlVideo; 
 private String rsUrlVideo; 
 private  boolean  nullUrlVideo = false; 
 private String DescFrase; 
 private String rsDescFrase; 
 private  boolean  nullDescFrase = false; 
 private String DescFrase2; 
 private String rsDescFrase2; 
 private  boolean  nullDescFrase2 = false; 
 private String DescTexto; 
 private String rsDescTexto; 
 private  boolean  nullDescTexto = false; 
public PreparedStatement getSt() {		return st; 	} 
 public void setSt(PreparedStatement st) {		this.st = st; 	} 
 public StringBuffer getSql() {		return sql; 	} 
 public void setSql(StringBuffer sql) {		this.sql = sql; 	} 
 public ResultSet getRs() {		return rs; 	} 
 public void setRs(ResultSet rs) {		this.rs = rs; 	} 
 public Connection getConn() {		return conn; 	} 
 public void setConn(Connection conn) {		this.conn = conn; 	}
 public String getWhere() { return this.Where; }public void setWhere(String where) { this.Where = where; }public String getJoin() {return this.Join;}public void setJoin(String join) {this.Join = join;}public String getLastSentence() {return this.LastSentence;}public void setLastSentence(String last) {this.LastSentence = last;}public String getSelect() { return this.Select; }public void setSelect(String select) { this.Select = select; }public Long getIdThankspage() {		return IdThankspage ; 	} 
 public void setIdThankspage(Long var) {		this.IdThankspage = var; 	} 
 public Long getRsIdThankspage() {		return rsIdThankspage ; 	} 
 public void setRsIdThankspage(Long var) {		this.rsIdThankspage = var; 	} 
 public Long getIdCampanha() {		return IdCampanha ; 	} 
 public void setIdCampanha(Long var) {		this.IdCampanha = var; 	} 
 public Long getRsIdCampanha() {		return rsIdCampanha ; 	} 
 public void setRsIdCampanha(Long var) {		this.rsIdCampanha = var; 	} 
 public boolean getNullIdCampanha() {		return nullIdCampanha ; 	} 
 public void setNullIdCampanha(boolean var) {		this.nullIdCampanha = var; 	} 
 public String getMsgThanks() {		return MsgThanks ; 	} 
 public void setMsgThanks(String var) {		this.MsgThanks = var; 	} 
 public String getRsMsgThanks() {		return rsMsgThanks ; 	} 
 public void setRsMsgThanks(String var) {		this.rsMsgThanks = var; 	} 
 public boolean getNullMsgThanks() {		return nullMsgThanks ; 	} 
 public void setNullMsgThanks(boolean var) {		this.nullMsgThanks = var; 	} 
 public String getSubTitulo() {		return SubTitulo ; 	} 
 public void setSubTitulo(String var) {		this.SubTitulo = var; 	} 
 public String getRsSubTitulo() {		return rsSubTitulo ; 	} 
 public void setRsSubTitulo(String var) {		this.rsSubTitulo = var; 	} 
 public boolean getNullSubTitulo() {		return nullSubTitulo ; 	} 
 public void setNullSubTitulo(boolean var) {		this.nullSubTitulo = var; 	} 
 public String getUrlVideo() {		return UrlVideo ; 	} 
 public void setUrlVideo(String var) {		this.UrlVideo = var; 	} 
 public String getRsUrlVideo() {		return rsUrlVideo ; 	} 
 public void setRsUrlVideo(String var) {		this.rsUrlVideo = var; 	} 
 public boolean getNullUrlVideo() {		return nullUrlVideo ; 	} 
 public void setNullUrlVideo(boolean var) {		this.nullUrlVideo = var; 	} 
 public String getDescFrase() {		return DescFrase ; 	} 
 public void setDescFrase(String var) {		this.DescFrase = var; 	} 
 public String getRsDescFrase() {		return rsDescFrase ; 	} 
 public void setRsDescFrase(String var) {		this.rsDescFrase = var; 	} 
 public boolean getNullDescFrase() {		return nullDescFrase ; 	} 
 public void setNullDescFrase(boolean var) {		this.nullDescFrase = var; 	} 
 public String getDescFrase2() {		return DescFrase2 ; 	} 
 public void setDescFrase2(String var) {		this.DescFrase2 = var; 	} 
 public String getRsDescFrase2() {		return rsDescFrase2 ; 	} 
 public void setRsDescFrase2(String var) {		this.rsDescFrase2 = var; 	} 
 public boolean getNullDescFrase2() {		return nullDescFrase2 ; 	} 
 public void setNullDescFrase2(boolean var) {		this.nullDescFrase2 = var; 	} 
 public String getDescTexto() {		return DescTexto ; 	} 
 public void setDescTexto(String var) {		this.DescTexto = var; 	} 
 public String getRsDescTexto() {		return rsDescTexto ; 	} 
 public void setRsDescTexto(String var) {		this.rsDescTexto = var; 	} 
 public boolean getNullDescTexto() {		return nullDescTexto ; 	} 
 public void setNullDescTexto(boolean var) {		this.nullDescTexto = var; 	} 
  public void posicionaRs() throws Exception{ if ( getSelect() == null ) {    try {   rsIdThankspage = rs.getLong("id_thankspage"); } catch (Exception e) { e.printStackTrace();  }  try {   rsIdCampanha = rs.getLong("id_campanha"); } catch (Exception e) { e.printStackTrace();  }  try {   rsMsgThanks = rs.getString("msg_thanks"); } catch (Exception e) { e.printStackTrace();  }  try {   rsSubTitulo = rs.getString("sub_titulo"); } catch (Exception e) { e.printStackTrace();  }  try {   rsUrlVideo = rs.getString("url_video"); } catch (Exception e) { e.printStackTrace();  }  try {   rsDescFrase = rs.getString("desc_frase"); } catch (Exception e) { e.printStackTrace();  }  try {   rsDescFrase2 = rs.getString("desc_frase2"); } catch (Exception e) { e.printStackTrace();  }  try {   rsDescTexto = rs.getString("desc_texto"); } catch (Exception e) { e.printStackTrace();  } }  }   public boolean next(){    boolean resultado;   resultado = false;    try{ limpaRs();    resultado = rs.next();    if (resultado){ posicionaRs(); }   } catch (Exception e){    e.printStackTrace(); }     return resultado; } public void limpaRs() throws Exception{  rsIdThankspage=  null ;  rsIdCampanha=  null ;  rsMsgThanks=  null ;  rsSubTitulo=  null ;  rsUrlVideo=  null ;  rsDescFrase=  null ;  rsDescFrase2=  null ;  rsDescTexto=  null ;   }  public ResultSet lista() throws Exception { sql = new StringBuffer(); if(getSelect()!=null){ sql.append(" select "+getSelect()+" "); }else {sql.append(" select *   "); } if(getJoin()!=null){ sql.append(" from "+getJoin()+" where  1=1 "); }else {sql.append(" from campanha_thankspage where  1=1 "); } if( getIdThankspage() != null ) { sql.append(" and campanha_thankspage .id_thankspage = ? "); } if( getIdCampanha() != null ) { sql.append(" and campanha_thankspage .id_campanha = ? "); } if( getMsgThanks() != null ) { sql.append(" and campanha_thankspage .msg_thanks = ? "); } if( getSubTitulo() != null ) { sql.append(" and campanha_thankspage .sub_titulo = ? "); } if( getUrlVideo() != null ) { sql.append(" and campanha_thankspage .url_video = ? "); } if( getDescFrase() != null ) { sql.append(" and campanha_thankspage .desc_frase = ? "); } if( getDescFrase2() != null ) { sql.append(" and campanha_thankspage .desc_frase2 = ? "); } if( getDescTexto() != null ) { sql.append(" and campanha_thankspage .desc_texto = ? "); } if(getWhere()!=null){ sql.append(" and "+ getWhere()+" "); }        if(getLastSentence()!=null){ sql.append(" "+ getLastSentence()+""); }        st = conn.prepareStatement(sql.toString());  int contparam = 1;  if( getIdThankspage() != null ){ st.setLong(contparam,getIdThankspage()); contparam++;}  if( getIdCampanha() != null ){ st.setLong(contparam,getIdCampanha()); contparam++;}  if( getMsgThanks() != null ){ st.setString(contparam,getMsgThanks()); contparam++;}  if( getSubTitulo() != null ){ st.setString(contparam,getSubTitulo()); contparam++;}  if( getUrlVideo() != null ){ st.setString(contparam,getUrlVideo()); contparam++;}  if( getDescFrase() != null ){ st.setString(contparam,getDescFrase()); contparam++;}  if( getDescFrase2() != null ){ st.setString(contparam,getDescFrase2()); contparam++;}  if( getDescTexto() != null ){ st.setString(contparam,getDescTexto()); contparam++;}  	rs = st.executeQuery();  	return rs; }public void update() throws Exception { sql = new StringBuffer();sql.append(" update campanha_thankspage set id_thankspage =  " + getIdThankspage() + "  "); if( getIdCampanha() != null ) { sql.append(" ,  id_campanha = ? "); } if( getNullIdCampanha()) { sql.append(" ,  id_campanha = null "); } if( getMsgThanks() != null ) { sql.append(" ,  msg_thanks = ? "); } if( getNullMsgThanks()) { sql.append(" ,  msg_thanks = null "); } if( getSubTitulo() != null ) { sql.append(" ,  sub_titulo = ? "); } if( getNullSubTitulo()) { sql.append(" ,  sub_titulo = null "); } if( getUrlVideo() != null ) { sql.append(" ,  url_video = ? "); } if( getNullUrlVideo()) { sql.append(" ,  url_video = null "); } if( getDescFrase() != null ) { sql.append(" ,  desc_frase = ? "); } if( getNullDescFrase()) { sql.append(" ,  desc_frase = null "); } if( getDescFrase2() != null ) { sql.append(" ,  desc_frase2 = ? "); } if( getNullDescFrase2()) { sql.append(" ,  desc_frase2 = null "); } if( getDescTexto() != null ) { sql.append(" ,  desc_texto = ? "); } if( getNullDescTexto()) { sql.append(" ,  desc_texto = null "); } sql.append(" where id_thankspage =  " + getIdThankspage() + "  "); if(getWhere()!=null){ sql.append(" and "+ getWhere()+" "); }        st = conn.prepareStatement(sql.toString());  int contparam = 1;  if( getIdCampanha() != null ){ st.setLong(contparam,getIdCampanha()); contparam++;}  if( getMsgThanks() != null ){ st.setString(contparam,getMsgThanks()); contparam++;}  if( getSubTitulo() != null ){ st.setString(contparam,getSubTitulo()); contparam++;}  if( getUrlVideo() != null ){ st.setString(contparam,getUrlVideo()); contparam++;}  if( getDescFrase() != null ){ st.setString(contparam,getDescFrase()); contparam++;}  if( getDescFrase2() != null ){ st.setString(contparam,getDescFrase2()); contparam++;}  if( getDescTexto() != null ){ st.setString(contparam,getDescTexto()); contparam++;}  		st.executeUpdate() ;} public void delete() throws Exception { sql = new StringBuffer();sql.append(" delete from campanha_thankspage "); sql.append(" where id_thankspage =  " + getIdThankspage() + "  "); st = conn.prepareStatement(sql.toString());  		st.executeUpdate() ;} public void insert() throws Exception { sql = new StringBuffer();StringBuffer values = new StringBuffer();sql.append(" insert into campanha_thankspage  (id_thankspage " );values.append(" value (? "); if( getIdThankspage() != null ) {sql.append(" , id_thankspage ");values.append(", ? "); }  if( getIdCampanha() != null ) {sql.append(" , id_campanha ");values.append(", ? "); }  if( getMsgThanks() != null ) {sql.append(" , msg_thanks ");values.append(", ? "); }  if( getSubTitulo() != null ) {sql.append(" , sub_titulo ");values.append(", ? "); }  if( getUrlVideo() != null ) {sql.append(" , url_video ");values.append(", ? "); }  if( getDescFrase() != null ) {sql.append(" , desc_frase ");values.append(", ? "); }  if( getDescFrase2() != null ) {sql.append(" , desc_frase2 ");values.append(", ? "); }  if( getDescTexto() != null ) {sql.append(" , desc_texto ");values.append(", ? "); } sql.append(" ) ");values.append(" ) ");sql.append( values.toString()); 	st = conn.prepareStatement(sql.toString());   long id = 	 Utilitario.retornaIdinsertLong	 ("campanha_thankspage", "id_thankspage", conn); int contparam = 1;  st.setLong(contparam, id); contparam++;  if( getIdCampanha() != null ){ st.setLong(contparam,getIdCampanha()); contparam++;  }  if( getMsgThanks() != null ){ st.setString(contparam,getMsgThanks()); contparam++;  }  if( getSubTitulo() != null ){ st.setString(contparam,getSubTitulo()); contparam++;  }  if( getUrlVideo() != null ){ st.setString(contparam,getUrlVideo()); contparam++;  }  if( getDescFrase() != null ){ st.setString(contparam,getDescFrase()); contparam++;  }  if( getDescFrase2() != null ){ st.setString(contparam,getDescFrase2()); contparam++;  }  if( getDescTexto() != null ){ st.setString(contparam,getDescTexto()); contparam++;  }  		if (st.executeUpdate() == 1) { setIdThankspage(id);} else { throw new Exception("Erro, contate suporte. Inserção de campanha_thankspage.");}}
 
 }