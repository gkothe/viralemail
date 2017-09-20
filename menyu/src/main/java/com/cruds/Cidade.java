package com.cruds; 
import java.sql.Connection; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import com.funcs.Utilitario; 
import java.util.Date; 
import java.sql.Timestamp; 

public class Cidade { 

private PreparedStatement st; 
private StringBuffer sql; 
private ResultSet rs; 
private Connection conn; 
private String Where; 
private String Join; 
private String LastSentence; 
private String Select; 
public Cidade(Connection conn) { super();this.conn = conn;} 
 private Integer CodCidade; 
 private Integer rsCodCidade; 
 private String DescCidade; 
 private String rsDescCidade; 
 private  boolean  nullDescCidade = false; 
 private Double MapsLatitude; 
 private Double rsMapsLatitude; 
 private  boolean  nullMapsLatitude = false; 
 private Double MapsLongitude; 
 private Double rsMapsLongitude; 
 private  boolean  nullMapsLongitude = false; 
public PreparedStatement getSt() {		return st; 	} 
 public void setSt(PreparedStatement st) {		this.st = st; 	} 
 public StringBuffer getSql() {		return sql; 	} 
 public void setSql(StringBuffer sql) {		this.sql = sql; 	} 
 public ResultSet getRs() {		return rs; 	} 
 public void setRs(ResultSet rs) {		this.rs = rs; 	} 
 public Connection getConn() {		return conn; 	} 
 public void setConn(Connection conn) {		this.conn = conn; 	}
 public String getWhere() { return this.Where; }public void setWhere(String where) { this.Where = where; }public String getJoin() {return this.Join;}public void setJoin(String join) {this.Join = join;}public String getLastSentence() {return this.LastSentence;}public void setLastSentence(String last) {this.LastSentence = last;}public String getSelect() { return this.Select; }public void setSelect(String select) { this.Select = select; }public Integer getCodCidade() {		return CodCidade ; 	} 
 public void setCodCidade(Integer var) {		this.CodCidade = var; 	} 
 public Integer getRsCodCidade() {		return rsCodCidade ; 	} 
 public void setRsCodCidade(Integer var) {		this.rsCodCidade = var; 	} 
 public String getDescCidade() {		return DescCidade ; 	} 
 public void setDescCidade(String var) {		this.DescCidade = var; 	} 
 public String getRsDescCidade() {		return rsDescCidade ; 	} 
 public void setRsDescCidade(String var) {		this.rsDescCidade = var; 	} 
 public boolean getNullDescCidade() {		return nullDescCidade ; 	} 
 public void setNullDescCidade(boolean var) {		this.nullDescCidade = var; 	} 
 public Double getMapsLatitude() {		return MapsLatitude ; 	} 
 public void setMapsLatitude(Double var) {		this.MapsLatitude = var; 	} 
 public Double getRsMapsLatitude() {		return rsMapsLatitude ; 	} 
 public void setRsMapsLatitude(Double var) {		this.rsMapsLatitude = var; 	} 
 public boolean getNullMapsLatitude() {		return nullMapsLatitude ; 	} 
 public void setNullMapsLatitude(boolean var) {		this.nullMapsLatitude = var; 	} 
 public Double getMapsLongitude() {		return MapsLongitude ; 	} 
 public void setMapsLongitude(Double var) {		this.MapsLongitude = var; 	} 
 public Double getRsMapsLongitude() {		return rsMapsLongitude ; 	} 
 public void setRsMapsLongitude(Double var) {		this.rsMapsLongitude = var; 	} 
 public boolean getNullMapsLongitude() {		return nullMapsLongitude ; 	} 
 public void setNullMapsLongitude(boolean var) {		this.nullMapsLongitude = var; 	} 
  public void posicionaRs() throws Exception{ if ( getSelect() == null ) {    try {   rsCodCidade = rs.getInt("cod_cidade"); } catch (Exception e) { e.printStackTrace();  }  try {   rsDescCidade = rs.getString("desc_cidade"); } catch (Exception e) { e.printStackTrace();  }  try {   rsMapsLatitude = rs.getDouble("maps_latitude"); } catch (Exception e) { e.printStackTrace();  }  try {   rsMapsLongitude = rs.getDouble("maps_longitude"); } catch (Exception e) { e.printStackTrace();  } }  }   public boolean next(){    boolean resultado;   resultado = false;    try{ limpaRs();    resultado = rs.next();    if (resultado){ posicionaRs(); }   } catch (Exception e){    e.printStackTrace(); }     return resultado; } public void limpaRs() throws Exception{  rsCodCidade=  null ;  rsDescCidade=  null ;  rsMapsLatitude=  null ;  rsMapsLongitude=  null ;   }  public ResultSet lista() throws Exception { sql = new StringBuffer(); if(getSelect()!=null){ sql.append(" select "+getSelect()+" "); }else {sql.append(" select *   "); } if(getJoin()!=null){ sql.append(" from "+getJoin()+" where  1=1 "); }else {sql.append(" from cidade where  1=1 "); } if( getCodCidade() != null ) { sql.append(" and cidade .cod_cidade = ? "); } if( getDescCidade() != null ) { sql.append(" and cidade .desc_cidade = ? "); } if( getMapsLatitude() != null ) { sql.append(" and cidade .maps_latitude = ? "); } if( getMapsLongitude() != null ) { sql.append(" and cidade .maps_longitude = ? "); } if(getWhere()!=null){ sql.append(" and "+ getWhere()+" "); }        if(getLastSentence()!=null){ sql.append(" "+ getLastSentence()+""); }        st = conn.prepareStatement(sql.toString());  int contparam = 1;  if( getCodCidade() != null ){ st.setInt(contparam,getCodCidade()); contparam++;}  if( getDescCidade() != null ){ st.setString(contparam,getDescCidade()); contparam++;}  if( getMapsLatitude() != null ){ st.setDouble(contparam,getMapsLatitude()); contparam++;}  if( getMapsLongitude() != null ){ st.setDouble(contparam,getMapsLongitude()); contparam++;}  	rs = st.executeQuery();  	return rs; }public void update() throws Exception {  if( getCodCidade() == null || getCodCidade() == 0 ) {  throw new Exception("Erro, Pk CodCidade não setada. Update de cidade."); }sql = new StringBuffer();sql.append(" update cidade set cod_cidade =  " + getCodCidade() + "  "); if( getDescCidade() != null ) { sql.append(" ,  desc_cidade = ? "); } if( getNullDescCidade()) { sql.append(" ,  desc_cidade = null "); } if( getMapsLatitude() != null ) { sql.append(" ,  maps_latitude = ? "); } if( getNullMapsLatitude()) { sql.append(" ,  maps_latitude = null "); } if( getMapsLongitude() != null ) { sql.append(" ,  maps_longitude = ? "); } if( getNullMapsLongitude()) { sql.append(" ,  maps_longitude = null "); } sql.append(" where cod_cidade =  " + getCodCidade() + "  "); if(getWhere()!=null){ sql.append(" and "+ getWhere()+" "); }        st = conn.prepareStatement(sql.toString());  int contparam = 1;  if( getDescCidade() != null ){ st.setString(contparam,getDescCidade()); contparam++;}  if( getMapsLatitude() != null ){ st.setDouble(contparam,getMapsLatitude()); contparam++;}  if( getMapsLongitude() != null ){ st.setDouble(contparam,getMapsLongitude()); contparam++;}  		st.executeUpdate() ;} public void delete() throws Exception { sql = new StringBuffer();sql.append(" delete from cidade "); sql.append(" where cod_cidade =  " + getCodCidade() + "  "); st = conn.prepareStatement(sql.toString());  		st.executeUpdate() ;} public void insert() throws Exception { sql = new StringBuffer();StringBuffer values = new StringBuffer();sql.append(" insert into cidade  (cod_cidade " );values.append(" value (? "); if( getDescCidade() != null ) {sql.append(" , desc_cidade ");values.append(", ? "); }  if( getMapsLatitude() != null ) {sql.append(" , maps_latitude ");values.append(", ? "); }  if( getMapsLongitude() != null ) {sql.append(" , maps_longitude ");values.append(", ? "); } sql.append(" ) ");values.append(" ) ");sql.append( values.toString()); 	st = conn.prepareStatement(sql.toString());   int id = 	 Utilitario.retornaIdinsert 	 ("cidade", "cod_cidade", conn); int contparam = 1;  st.setInt(contparam, id); contparam++;  if( getDescCidade() != null ){ st.setString(contparam,getDescCidade()); contparam++;  }  if( getMapsLatitude() != null ){ st.setDouble(contparam,getMapsLatitude()); contparam++;  }  if( getMapsLongitude() != null ){ st.setDouble(contparam,getMapsLongitude()); contparam++;  }  		if (st.executeUpdate() == 1) { setCodCidade(id);} else { throw new Exception("Erro, contate suporte. Inserção de cidade.");}}
 
 }