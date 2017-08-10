package com.phpdao.domain; 
import java.sql.Connection; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import com.funcs.Utilitario; 
import java.util.Date; 
import java.sql.Timestamp; 

public class CampanhaLandpage { 

private PreparedStatement st; 
private StringBuffer sql; 
private ResultSet rs; 
private Connection conn; 
private String Where; 
private String Join; 
private String LastSentence; 
private String Select; 
public CampanhaLandpage(Connection conn) { super();this.conn = conn;} 
 private Long IdLandpage; 
 private Long rsIdLandpage; 
 private Long IdCampanha; 
 private Long rsIdCampanha; 
 private  boolean  nullIdCampanha = false; 
 private String DescTitulo1; 
 private String rsDescTitulo1; 
 private  boolean  nullDescTitulo1 = false; 
 private String DescSubTitulo1; 
 private String rsDescSubTitulo1; 
 private  boolean  nullDescSubTitulo1 = false; 
 private String UrlVideo; 
 private String rsUrlVideo; 
 private  boolean  nullUrlVideo = false; 
 private String DescCampanha; 
 private String rsDescCampanha; 
 private  boolean  nullDescCampanha = false; 
 private String DescTitulo2; 
 private String rsDescTitulo2; 
 private  boolean  nullDescTitulo2 = false; 
 private String SubTitulo2; 
 private String rsSubTitulo2; 
 private  boolean  nullSubTitulo2 = false; 
public PreparedStatement getSt() {		return st; 	} 
 public void setSt(PreparedStatement st) {		this.st = st; 	} 
 public StringBuffer getSql() {		return sql; 	} 
 public void setSql(StringBuffer sql) {		this.sql = sql; 	} 
 public ResultSet getRs() {		return rs; 	} 
 public void setRs(ResultSet rs) {		this.rs = rs; 	} 
 public Connection getConn() {		return conn; 	} 
 public void setConn(Connection conn) {		this.conn = conn; 	}
 public String getWhere() { return this.Where; }public void setWhere(String where) { this.Where = where; }public String getJoin() {return this.Join;}public void setJoin(String join) {this.Join = join;}public String getLastSentence() {return this.LastSentence;}public void setLastSentence(String last) {this.LastSentence = last;}public String getSelect() { return this.Select; }public void setSelect(String select) { this.Select = select; }public Long getIdLandpage() {		return IdLandpage ; 	} 
 public void setIdLandpage(Long var) {		this.IdLandpage = var; 	} 
 public Long getRsIdLandpage() {		return rsIdLandpage ; 	} 
 public void setRsIdLandpage(Long var) {		this.rsIdLandpage = var; 	} 
 public Long getIdCampanha() {		return IdCampanha ; 	} 
 public void setIdCampanha(Long var) {		this.IdCampanha = var; 	} 
 public Long getRsIdCampanha() {		return rsIdCampanha ; 	} 
 public void setRsIdCampanha(Long var) {		this.rsIdCampanha = var; 	} 
 public boolean getNullIdCampanha() {		return nullIdCampanha ; 	} 
 public void setNullIdCampanha(boolean var) {		this.nullIdCampanha = var; 	} 
 public String getDescTitulo1() {		return DescTitulo1 ; 	} 
 public void setDescTitulo1(String var) {		this.DescTitulo1 = var; 	} 
 public String getRsDescTitulo1() {		return rsDescTitulo1 ; 	} 
 public void setRsDescTitulo1(String var) {		this.rsDescTitulo1 = var; 	} 
 public boolean getNullDescTitulo1() {		return nullDescTitulo1 ; 	} 
 public void setNullDescTitulo1(boolean var) {		this.nullDescTitulo1 = var; 	} 
 public String getDescSubTitulo1() {		return DescSubTitulo1 ; 	} 
 public void setDescSubTitulo1(String var) {		this.DescSubTitulo1 = var; 	} 
 public String getRsDescSubTitulo1() {		return rsDescSubTitulo1 ; 	} 
 public void setRsDescSubTitulo1(String var) {		this.rsDescSubTitulo1 = var; 	} 
 public boolean getNullDescSubTitulo1() {		return nullDescSubTitulo1 ; 	} 
 public void setNullDescSubTitulo1(boolean var) {		this.nullDescSubTitulo1 = var; 	} 
 public String getUrlVideo() {		return UrlVideo ; 	} 
 public void setUrlVideo(String var) {		this.UrlVideo = var; 	} 
 public String getRsUrlVideo() {		return rsUrlVideo ; 	} 
 public void setRsUrlVideo(String var) {		this.rsUrlVideo = var; 	} 
 public boolean getNullUrlVideo() {		return nullUrlVideo ; 	} 
 public void setNullUrlVideo(boolean var) {		this.nullUrlVideo = var; 	} 
 public String getDescCampanha() {		return DescCampanha ; 	} 
 public void setDescCampanha(String var) {		this.DescCampanha = var; 	} 
 public String getRsDescCampanha() {		return rsDescCampanha ; 	} 
 public void setRsDescCampanha(String var) {		this.rsDescCampanha = var; 	} 
 public boolean getNullDescCampanha() {		return nullDescCampanha ; 	} 
 public void setNullDescCampanha(boolean var) {		this.nullDescCampanha = var; 	} 
 public String getDescTitulo2() {		return DescTitulo2 ; 	} 
 public void setDescTitulo2(String var) {		this.DescTitulo2 = var; 	} 
 public String getRsDescTitulo2() {		return rsDescTitulo2 ; 	} 
 public void setRsDescTitulo2(String var) {		this.rsDescTitulo2 = var; 	} 
 public boolean getNullDescTitulo2() {		return nullDescTitulo2 ; 	} 
 public void setNullDescTitulo2(boolean var) {		this.nullDescTitulo2 = var; 	} 
 public String getSubTitulo2() {		return SubTitulo2 ; 	} 
 public void setSubTitulo2(String var) {		this.SubTitulo2 = var; 	} 
 public String getRsSubTitulo2() {		return rsSubTitulo2 ; 	} 
 public void setRsSubTitulo2(String var) {		this.rsSubTitulo2 = var; 	} 
 public boolean getNullSubTitulo2() {		return nullSubTitulo2 ; 	} 
 public void setNullSubTitulo2(boolean var) {		this.nullSubTitulo2 = var; 	} 
  public void posicionaRs() throws Exception{ if ( getSelect() == null ) {    try {   rsIdLandpage = rs.getLong("id_landpage"); } catch (Exception e) { e.printStackTrace();  }  try {   rsIdCampanha = rs.getLong("id_campanha"); } catch (Exception e) { e.printStackTrace();  }  try {   rsDescTitulo1 = rs.getString("desc_titulo_1"); } catch (Exception e) { e.printStackTrace();  }  try {   rsDescSubTitulo1 = rs.getString("desc_sub_titulo_1"); } catch (Exception e) { e.printStackTrace();  }  try {   rsUrlVideo = rs.getString("url_video"); } catch (Exception e) { e.printStackTrace();  }  try {   rsDescCampanha = rs.getString("desc_campanha"); } catch (Exception e) { e.printStackTrace();  }  try {   rsDescTitulo2 = rs.getString("desc_titulo_2"); } catch (Exception e) { e.printStackTrace();  }  try {   rsSubTitulo2 = rs.getString("sub_titulo_2"); } catch (Exception e) { e.printStackTrace();  } }  }   public boolean next(){    boolean resultado;   resultado = false;    try{ limpaRs();    resultado = rs.next();    if (resultado){ posicionaRs(); }   } catch (Exception e){    e.printStackTrace(); }     return resultado; } public void limpaRs() throws Exception{  rsIdLandpage=  null ;  rsIdCampanha=  null ;  rsDescTitulo1=  null ;  rsDescSubTitulo1=  null ;  rsUrlVideo=  null ;  rsDescCampanha=  null ;  rsDescTitulo2=  null ;  rsSubTitulo2=  null ;   }  public ResultSet lista() throws Exception { sql = new StringBuffer(); if(getSelect()!=null){ sql.append(" select "+getSelect()+" "); }else {sql.append(" select * from campanha_landpage  "); } if(getJoin()!=null){ sql.append(" from "+getJoin()+" where  1=1 "); }else {sql.append(" from campanha_landpage where  1=1 "); } if( getIdLandpage() != null ) { sql.append(" and campanha_landpage .id_landpage = ? "); } if( getIdCampanha() != null ) { sql.append(" and campanha_landpage .id_campanha = ? "); } if( getDescTitulo1() != null ) { sql.append(" and campanha_landpage .desc_titulo_1 = ? "); } if( getDescSubTitulo1() != null ) { sql.append(" and campanha_landpage .desc_sub_titulo_1 = ? "); } if( getUrlVideo() != null ) { sql.append(" and campanha_landpage .url_video = ? "); } if( getDescCampanha() != null ) { sql.append(" and campanha_landpage .desc_campanha = ? "); } if( getDescTitulo2() != null ) { sql.append(" and campanha_landpage .desc_titulo_2 = ? "); } if( getSubTitulo2() != null ) { sql.append(" and campanha_landpage .sub_titulo_2 = ? "); } if(getWhere()!=null){ sql.append(" and "+ getWhere()+" "); }        if(getLastSentence()!=null){ sql.append(" "+ getLastSentence()+""); }        st = conn.prepareStatement(sql.toString());  int contparam = 1;  if( getIdLandpage() != null ){ st.setLong(contparam,getIdLandpage()); contparam++;}  if( getIdCampanha() != null ){ st.setLong(contparam,getIdCampanha()); contparam++;}  if( getDescTitulo1() != null ){ st.setString(contparam,getDescTitulo1()); contparam++;}  if( getDescSubTitulo1() != null ){ st.setString(contparam,getDescSubTitulo1()); contparam++;}  if( getUrlVideo() != null ){ st.setString(contparam,getUrlVideo()); contparam++;}  if( getDescCampanha() != null ){ st.setString(contparam,getDescCampanha()); contparam++;}  if( getDescTitulo2() != null ){ st.setString(contparam,getDescTitulo2()); contparam++;}  if( getSubTitulo2() != null ){ st.setString(contparam,getSubTitulo2()); contparam++;}  	rs = st.executeQuery();  	return rs; }public void update() throws Exception { sql = new StringBuffer();sql.append(" update campanha_landpage set id_landpage =  " + getIdLandpage() + "  "); if( getIdCampanha() != null ) { sql.append(" ,  id_campanha = ? "); } if( getNullIdCampanha()) { sql.append(" ,  id_campanha = null "); } if( getDescTitulo1() != null ) { sql.append(" ,  desc_titulo_1 = ? "); } if( getNullDescTitulo1()) { sql.append(" ,  desc_titulo_1 = null "); } if( getDescSubTitulo1() != null ) { sql.append(" ,  desc_sub_titulo_1 = ? "); } if( getNullDescSubTitulo1()) { sql.append(" ,  desc_sub_titulo_1 = null "); } if( getUrlVideo() != null ) { sql.append(" ,  url_video = ? "); } if( getNullUrlVideo()) { sql.append(" ,  url_video = null "); } if( getDescCampanha() != null ) { sql.append(" ,  desc_campanha = ? "); } if( getNullDescCampanha()) { sql.append(" ,  desc_campanha = null "); } if( getDescTitulo2() != null ) { sql.append(" ,  desc_titulo_2 = ? "); } if( getNullDescTitulo2()) { sql.append(" ,  desc_titulo_2 = null "); } if( getSubTitulo2() != null ) { sql.append(" ,  sub_titulo_2 = ? "); } if( getNullSubTitulo2()) { sql.append(" ,  sub_titulo_2 = null "); } sql.append(" where id_landpage =  " + getIdLandpage() + "  "); if(getWhere()!=null){ sql.append(" and "+ getWhere()+" "); }        st = conn.prepareStatement(sql.toString());  int contparam = 1;  if( getIdCampanha() != null ){ st.setLong(contparam,getIdCampanha()); contparam++;}  if( getDescTitulo1() != null ){ st.setString(contparam,getDescTitulo1()); contparam++;}  if( getDescSubTitulo1() != null ){ st.setString(contparam,getDescSubTitulo1()); contparam++;}  if( getUrlVideo() != null ){ st.setString(contparam,getUrlVideo()); contparam++;}  if( getDescCampanha() != null ){ st.setString(contparam,getDescCampanha()); contparam++;}  if( getDescTitulo2() != null ){ st.setString(contparam,getDescTitulo2()); contparam++;}  if( getSubTitulo2() != null ){ st.setString(contparam,getSubTitulo2()); contparam++;}  		st.executeUpdate() ;} public void delete() throws Exception { sql = new StringBuffer();sql.append(" delete from campanha_landpage "); sql.append(" where id_landpage =  " + getIdLandpage() + "  "); st = conn.prepareStatement(sql.toString());  		st.executeUpdate() ;} public void insert() throws Exception { sql = new StringBuffer();StringBuffer values = new StringBuffer();sql.append(" insert into campanha_landpage  (id_landpage " );values.append(" value (? "); if( getIdLandpage() != null ) {sql.append(" , id_landpage ");values.append(", ? "); }  if( getIdCampanha() != null ) {sql.append(" , id_campanha ");values.append(", ? "); }  if( getDescTitulo1() != null ) {sql.append(" , desc_titulo_1 ");values.append(", ? "); }  if( getDescSubTitulo1() != null ) {sql.append(" , desc_sub_titulo_1 ");values.append(", ? "); }  if( getUrlVideo() != null ) {sql.append(" , url_video ");values.append(", ? "); }  if( getDescCampanha() != null ) {sql.append(" , desc_campanha ");values.append(", ? "); }  if( getDescTitulo2() != null ) {sql.append(" , desc_titulo_2 ");values.append(", ? "); }  if( getSubTitulo2() != null ) {sql.append(" , sub_titulo_2 ");values.append(", ? "); } sql.append(" ) ");values.append(" ) ");sql.append( values.toString()); 	st = conn.prepareStatement(sql.toString());   long id = 	 Utilitario.retornaIdinsertLong	 ("campanha_landpage", "id_landpage", conn); int contparam = 1;  st.setLong(contparam, id); contparam++;  if( getIdCampanha() != null ){ st.setLong(contparam,getIdCampanha()); contparam++;  }  if( getDescTitulo1() != null ){ st.setString(contparam,getDescTitulo1()); contparam++;  }  if( getDescSubTitulo1() != null ){ st.setString(contparam,getDescSubTitulo1()); contparam++;  }  if( getUrlVideo() != null ){ st.setString(contparam,getUrlVideo()); contparam++;  }  if( getDescCampanha() != null ){ st.setString(contparam,getDescCampanha()); contparam++;  }  if( getDescTitulo2() != null ){ st.setString(contparam,getDescTitulo2()); contparam++;  }  if( getSubTitulo2() != null ){ st.setString(contparam,getSubTitulo2()); contparam++;  }  		if (st.executeUpdate() == 1) { setIdLandpage(id);} else { throw new Exception("Erro, contate suporte. Inserção de campanha_landpage.");}}
 
 }