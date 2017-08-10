package com.phpdao.domain; 
import java.sql.Connection; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import com.funcs.Utilitario; 
import java.util.Date; 
import java.sql.Timestamp; 

public class CampanhaLandpageFeatures { 

private PreparedStatement st; 
private StringBuffer sql; 
private ResultSet rs; 
private Connection conn; 
private String Where; 
private String Join; 
private String LastSentence; 
private String Select; 
public CampanhaLandpageFeatures(Connection conn) { super();this.conn = conn;} 
 private Long IdLandpage; 
 private Long rsIdLandpage; 
 private Integer IdFeature; 
 private Integer rsIdFeature; 
 private String DescFeature; 
 private String rsDescFeature; 
 private  boolean  nullDescFeature = false; 
 private String DescClassIcon; 
 private String rsDescClassIcon; 
 private  boolean  nullDescClassIcon = false; 
 private String DescName; 
 private String rsDescName; 
 private  boolean  nullDescName = false; 
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
 public Integer getIdFeature() {		return IdFeature ; 	} 
 public void setIdFeature(Integer var) {		this.IdFeature = var; 	} 
 public Integer getRsIdFeature() {		return rsIdFeature ; 	} 
 public void setRsIdFeature(Integer var) {		this.rsIdFeature = var; 	} 
 public String getDescFeature() {		return DescFeature ; 	} 
 public void setDescFeature(String var) {		this.DescFeature = var; 	} 
 public String getRsDescFeature() {		return rsDescFeature ; 	} 
 public void setRsDescFeature(String var) {		this.rsDescFeature = var; 	} 
 public boolean getNullDescFeature() {		return nullDescFeature ; 	} 
 public void setNullDescFeature(boolean var) {		this.nullDescFeature = var; 	} 
 public String getDescClassIcon() {		return DescClassIcon ; 	} 
 public void setDescClassIcon(String var) {		this.DescClassIcon = var; 	} 
 public String getRsDescClassIcon() {		return rsDescClassIcon ; 	} 
 public void setRsDescClassIcon(String var) {		this.rsDescClassIcon = var; 	} 
 public boolean getNullDescClassIcon() {		return nullDescClassIcon ; 	} 
 public void setNullDescClassIcon(boolean var) {		this.nullDescClassIcon = var; 	} 
 public String getDescName() {		return DescName ; 	} 
 public void setDescName(String var) {		this.DescName = var; 	} 
 public String getRsDescName() {		return rsDescName ; 	} 
 public void setRsDescName(String var) {		this.rsDescName = var; 	} 
 public boolean getNullDescName() {		return nullDescName ; 	} 
 public void setNullDescName(boolean var) {		this.nullDescName = var; 	} 
  public void posicionaRs() throws Exception{ if ( getSelect() == null ) {    try {   rsIdLandpage = rs.getLong("id_landpage"); } catch (Exception e) { e.printStackTrace();  }  try {   rsIdFeature = rs.getInt("id_feature"); } catch (Exception e) { e.printStackTrace();  }  try {   rsDescFeature = rs.getString("desc_feature"); } catch (Exception e) { e.printStackTrace();  }  try {   rsDescClassIcon = rs.getString("desc_class_icon"); } catch (Exception e) { e.printStackTrace();  }  try {   rsDescName = rs.getString("desc_name"); } catch (Exception e) { e.printStackTrace();  } }  }   public boolean next(){    boolean resultado;   resultado = false;    try{ limpaRs();    resultado = rs.next();    if (resultado){ posicionaRs(); }   } catch (Exception e){    e.printStackTrace(); }     return resultado; } public void limpaRs() throws Exception{  rsIdLandpage=  null ;  rsIdFeature=  null ;  rsDescFeature=  null ;  rsDescClassIcon=  null ;  rsDescName=  null ;   }  public ResultSet lista() throws Exception { sql = new StringBuffer(); if(getSelect()!=null){ sql.append(" select "+getSelect()+" "); }else {sql.append(" select *   "); } if(getJoin()!=null){ sql.append(" from "+getJoin()+" where  1=1 "); }else {sql.append(" from campanha_landpage_features where  1=1 "); } if( getIdLandpage() != null ) { sql.append(" and campanha_landpage_features .id_landpage = ? "); } if( getIdFeature() != null ) { sql.append(" and campanha_landpage_features .id_feature = ? "); } if( getDescFeature() != null ) { sql.append(" and campanha_landpage_features .desc_feature = ? "); } if( getDescClassIcon() != null ) { sql.append(" and campanha_landpage_features .desc_class_icon = ? "); } if( getDescName() != null ) { sql.append(" and campanha_landpage_features .desc_name = ? "); } if(getWhere()!=null){ sql.append(" and "+ getWhere()+" "); }        if(getLastSentence()!=null){ sql.append(" "+ getLastSentence()+""); }        st = conn.prepareStatement(sql.toString());  int contparam = 1;  if( getIdLandpage() != null ){ st.setLong(contparam,getIdLandpage()); contparam++;}  if( getIdFeature() != null ){ st.setInt(contparam,getIdFeature()); contparam++;}  if( getDescFeature() != null ){ st.setString(contparam,getDescFeature()); contparam++;}  if( getDescClassIcon() != null ){ st.setString(contparam,getDescClassIcon()); contparam++;}  if( getDescName() != null ){ st.setString(contparam,getDescName()); contparam++;}  	rs = st.executeQuery();  	return rs; }public void update() throws Exception { sql = new StringBuffer();sql.append(" update campanha_landpage_features set id_feature =  " + getIdFeature() + "  "); if( getDescFeature() != null ) { sql.append(" ,  desc_feature = ? "); } if( getNullDescFeature()) { sql.append(" ,  desc_feature = null "); } if( getDescClassIcon() != null ) { sql.append(" ,  desc_class_icon = ? "); } if( getNullDescClassIcon()) { sql.append(" ,  desc_class_icon = null "); } if( getDescName() != null ) { sql.append(" ,  desc_name = ? "); } if( getNullDescName()) { sql.append(" ,  desc_name = null "); } sql.append(" where id_feature =  " + getIdFeature() + "  "); sql.append(" and id_landpage =  " + getIdLandpage() + "  "); if(getWhere()!=null){ sql.append(" and "+ getWhere()+" "); }        st = conn.prepareStatement(sql.toString());  int contparam = 1;  if( getDescFeature() != null ){ st.setString(contparam,getDescFeature()); contparam++;}  if( getDescClassIcon() != null ){ st.setString(contparam,getDescClassIcon()); contparam++;}  if( getDescName() != null ){ st.setString(contparam,getDescName()); contparam++;}  		st.executeUpdate() ;} public void delete() throws Exception { sql = new StringBuffer();sql.append(" delete from campanha_landpage_features "); sql.append(" where id_feature =  " + getIdFeature() + "  "); sql.append(" and id_landpage =  " + getIdLandpage() + "  "); st = conn.prepareStatement(sql.toString());  		st.executeUpdate() ;} public void insert() throws Exception { sql = new StringBuffer();StringBuffer values = new StringBuffer();sql.append(" insert into campanha_landpage_features  (id_feature,id_landpage " );values.append(" value (?,? "); if( getIdLandpage() != null ) {sql.append(" , id_landpage ");values.append(", ? "); }  if( getIdFeature() != null ) {sql.append(" , id_feature ");values.append(", ? "); }  if( getDescFeature() != null ) {sql.append(" , desc_feature ");values.append(", ? "); }  if( getDescClassIcon() != null ) {sql.append(" , desc_class_icon ");values.append(", ? "); }  if( getDescName() != null ) {sql.append(" , desc_name ");values.append(", ? "); } sql.append(" ) ");values.append(" ) ");sql.append( values.toString()); 	st = conn.prepareStatement(sql.toString());   long id = 	 Utilitario.retornaIdinsertChaveSecundariaLong	("campanha_landpage_features", "id_feature", getIdFeature()+"", "id_landpage", conn);  int contparam = 1;  st.setInt(contparam, getIdFeature()); contparam++;  st.setLong(contparam,id); contparam++;  if( getDescFeature() != null ){ st.setString(contparam,getDescFeature()); contparam++;  }  if( getDescClassIcon() != null ){ st.setString(contparam,getDescClassIcon()); contparam++;  }  if( getDescName() != null ){ st.setString(contparam,getDescName()); contparam++;  }  		if (st.executeUpdate() == 1) { setIdLandpage(id);} else { throw new Exception("Erro, contate suporte. Inserção de campanha_landpage_features.");}}
 
 }