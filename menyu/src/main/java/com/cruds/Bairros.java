package com.cruds; 
import java.sql.Connection; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import com.funcs.Utilitario; 
import java.util.Date; 
import java.sql.Timestamp; 
import com.mysql.jdbc.Statement; 
 import com.cruds.Cidade ; 
public class Bairros { 

private PreparedStatement st; 
private StringBuffer sql; 
private ResultSet rs; 
private Connection conn; 
private String Where; 
private String Join; 
private String LastSentence; 
private String Select; 
public Bairros(Connection conn) { super();this.conn = conn;} 
 private Integer CodBairro; 
 private Integer rsCodBairro; 
 private Integer CodCidade; 
 private Integer rsCodCidade; 
 private  boolean  nullCodCidade = false; 
 private String DescBairro; 
 private String rsDescBairro; 
 private  boolean  nullDescBairro = false; 
 private String DescGooglemaps; 
 private String rsDescGooglemaps; 
 private  boolean  nullDescGooglemaps = false; 
public PreparedStatement getSt() {		return st; 	} 
 public void setSt(PreparedStatement st) {		this.st = st; 	} 
 public StringBuffer getSql() {		return sql; 	} 
 public void setSql(StringBuffer sql) {		this.sql = sql; 	} 
 public ResultSet getRs() {		return rs; 	} 
 public void setRs(ResultSet rs) {		this.rs = rs; 	} 
 public Connection getConn() {		return conn; 	} 
 public void setConn(Connection conn) {		this.conn = conn; 	}
 public String getWhere() { return this.Where; }public void setWhere(String where) { this.Where = where; }public String getJoin() {return this.Join;}public void setJoin(String join) {this.Join = join;}public String getLastSentence() {return this.LastSentence;}public void setLastSentence(String last) {this.LastSentence = last;}public String getSelect() { return this.Select; }public void setSelect(String select) { this.Select = select; }public Integer getCodBairro() {		return CodBairro ; 	} 
 public void setCodBairro(Integer var) {		this.CodBairro = var; 	} 
 public Integer getRsCodBairro() {		return rsCodBairro ; 	} 
 public void setRsCodBairro(Integer var) {		this.rsCodBairro = var; 	} 
 public Integer getCodCidade() {		return CodCidade ; 	} 
 public void setCodCidade(Integer var) {		this.CodCidade = var; 	} 
 public Integer getRsCodCidade() {		return rsCodCidade ; 	} 
 public void setRsCodCidade(Integer var) {		this.rsCodCidade = var; 	} 
 public boolean getNullCodCidade() {		return nullCodCidade ; 	} 
 public void setNullCodCidade(boolean var) {		this.nullCodCidade = var; 	} 
 public String getDescBairro() {		return DescBairro ; 	} 
 public void setDescBairro(String var) {		this.DescBairro = var; 	} 
 public String getRsDescBairro() {		return rsDescBairro ; 	} 
 public void setRsDescBairro(String var) {		this.rsDescBairro = var; 	} 
 public boolean getNullDescBairro() {		return nullDescBairro ; 	} 
 public void setNullDescBairro(boolean var) {		this.nullDescBairro = var; 	} 
 public String getDescGooglemaps() {		return DescGooglemaps ; 	} 
 public void setDescGooglemaps(String var) {		this.DescGooglemaps = var; 	} 
 public String getRsDescGooglemaps() {		return rsDescGooglemaps ; 	} 
 public void setRsDescGooglemaps(String var) {		this.rsDescGooglemaps = var; 	} 
 public boolean getNullDescGooglemaps() {		return nullDescGooglemaps ; 	} 
 public void setNullDescGooglemaps(boolean var) {		this.nullDescGooglemaps = var; 	} 
 public Cidade  getFkCodCidade() throws Exception {  Cidade oFK = new Cidade(conn);  oFK.setCodCidade(getRsCodCidade());  oFK.lista();  oFK.next();  return oFK; } public void posicionaRs() throws Exception{ if ( getSelect() == null ) {    try {   rsCodBairro = rs.getInt("cod_bairro"); } catch (Exception e) { e.printStackTrace();  }  try {   rsCodCidade = rs.getInt("cod_cidade"); } catch (Exception e) { e.printStackTrace();  }  try {   rsDescBairro = rs.getString("desc_bairro"); } catch (Exception e) { e.printStackTrace();  }  try {   rsDescGooglemaps = rs.getString("desc_googlemaps"); } catch (Exception e) { e.printStackTrace();  } }  }   public boolean next(){    boolean resultado;   resultado = false;    try{ limpaRs();    resultado = rs.next();    if (resultado){ posicionaRs(); }   } catch (Exception e){    e.printStackTrace(); }     return resultado; } public void limpaRs() throws Exception{  rsCodBairro=  null ;  rsCodCidade=  null ;  rsDescBairro=  null ;  rsDescGooglemaps=  null ;   }  public ResultSet lista() throws Exception { sql = new StringBuffer(); if(getSelect()!=null){ sql.append(" select "+getSelect()+" "); }else {sql.append(" select *   "); } if(getJoin()!=null){ sql.append(" from "+getJoin()+" where  1=1 "); }else {sql.append(" from bairros where  1=1 "); } if( getCodBairro() != null ) { sql.append(" and bairros .cod_bairro = ? "); } if( getCodCidade() != null ) { sql.append(" and bairros .cod_cidade = ? "); } if( getDescBairro() != null ) { sql.append(" and bairros .desc_bairro = ? "); } if( getDescGooglemaps() != null ) { sql.append(" and bairros .desc_googlemaps = ? "); } if(getWhere()!=null){ sql.append(" and "+ getWhere()+" "); }        if(getLastSentence()!=null){ sql.append(" "+ getLastSentence()+""); }        st = conn.prepareStatement(sql.toString());  int contparam = 1;  if( getCodBairro() != null ){ st.setInt(contparam,getCodBairro()); contparam++;}  if( getCodCidade() != null ){ st.setInt(contparam,getCodCidade()); contparam++;}  if( getDescBairro() != null ){ st.setString(contparam,getDescBairro()); contparam++;}  if( getDescGooglemaps() != null ){ st.setString(contparam,getDescGooglemaps()); contparam++;}  	rs = st.executeQuery();  	return rs; }public void update() throws Exception {  if( getCodBairro() == null || getCodBairro() == 0 ) {  throw new Exception("Erro, Pk CodBairro não setada. Update de bairros."); }sql = new StringBuffer();sql.append(" update bairros set cod_bairro =  " + getCodBairro() + "  "); if( getCodCidade() != null ) { sql.append(" ,  cod_cidade = ? "); } if( getNullCodCidade()) { sql.append(" ,  cod_cidade = null "); } if( getDescBairro() != null ) { sql.append(" ,  desc_bairro = ? "); } if( getNullDescBairro()) { sql.append(" ,  desc_bairro = null "); } if( getDescGooglemaps() != null ) { sql.append(" ,  desc_googlemaps = ? "); } if( getNullDescGooglemaps()) { sql.append(" ,  desc_googlemaps = null "); } sql.append(" where cod_bairro =  " + getCodBairro() + "  "); if(getWhere()!=null){ sql.append(" and "+ getWhere()+" "); }        st = conn.prepareStatement(sql.toString());  int contparam = 1;  if( getCodCidade() != null ){ st.setInt(contparam,getCodCidade()); contparam++;}  if( getDescBairro() != null ){ st.setString(contparam,getDescBairro()); contparam++;}  if( getDescGooglemaps() != null ){ st.setString(contparam,getDescGooglemaps()); contparam++;}  		st.executeUpdate() ;} public void delete() throws Exception { sql = new StringBuffer();sql.append(" delete from bairros "); sql.append(" where cod_bairro =  " + getCodBairro() + "  "); st = conn.prepareStatement(sql.toString());  		st.executeUpdate() ;} public void insert() throws Exception { sql = new StringBuffer();StringBuffer values = new StringBuffer();sql.append(" insert into bairros  (");values.append(" value ("); if( getCodCidade() != null ) {sql.append(" , cod_cidade ");values.append(", ? "); }  if( getDescBairro() != null ) {sql.append(" , desc_bairro ");values.append(", ? "); }  if( getDescGooglemaps() != null ) {sql.append(" , desc_googlemaps ");values.append(", ? "); } sql.append(" ) ");values.append(" ) ");sql = new StringBuffer(sql.toString().replaceFirst(",", ""));values = new StringBuffer(values.toString().replaceFirst(",", ""));sql.append( values.toString()); 	st = conn.prepareStatement(sql.toString(),Statement.RETURN_GENERATED_KEYS);  int contparam = 1;  if( getCodCidade() != null ){ st.setInt(contparam,getCodCidade()); contparam++;  }  if( getDescBairro() != null ){ st.setString(contparam,getDescBairro()); contparam++;  }  if( getDescGooglemaps() != null ){ st.setString(contparam,getDescGooglemaps()); contparam++;  }  		if (st.executeUpdate() == 1) {  	rs = st.getGeneratedKeys();  if (rs.next()){ setCodBairro(rs.getInt(1)); } } else { throw new Exception("Erro, contate suporte. Inserção de bairros.");}}
 
 }