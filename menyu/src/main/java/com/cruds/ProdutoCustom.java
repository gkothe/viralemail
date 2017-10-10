package com.cruds; 
import java.sql.Connection; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import com.funcs.Utilitario; 
import java.util.Date; 
import java.sql.Timestamp; 
import com.mysql.jdbc.Statement; 
 import com.cruds.Loja ; 
public class ProdutoCustom { 

private PreparedStatement st; 
private StringBuffer sql; 
private ResultSet rs; 
private Connection conn; 
private String Where; 
private String Join; 
private String LastSentence; 
private String Select; 
public ProdutoCustom(Connection conn) { super();this.conn = conn;} 
 private Integer IdCustom; 
 private Integer rsIdCustom; 
 private String DescCustom; 
 private String rsDescCustom; 
 private  boolean  nullDescCustom = false; 
 private Integer IdLoja; 
 private Integer rsIdLoja; 
 private  boolean  nullIdLoja = false; 
public PreparedStatement getSt() {		return st; 	} 
 public void setSt(PreparedStatement st) {		this.st = st; 	} 
 public StringBuffer getSql() {		return sql; 	} 
 public void setSql(StringBuffer sql) {		this.sql = sql; 	} 
 public ResultSet getRs() {		return rs; 	} 
 public void setRs(ResultSet rs) {		this.rs = rs; 	} 
 public Connection getConn() {		return conn; 	} 
 public void setConn(Connection conn) {		this.conn = conn; 	}
 public String getWhere() { return this.Where; }public void setWhere(String where) { this.Where = where; }public String getJoin() {return this.Join;}public void setJoin(String join) {this.Join = join;}public String getLastSentence() {return this.LastSentence;}public void setLastSentence(String last) {this.LastSentence = last;}public String getSelect() { return this.Select; }public void setSelect(String select) { this.Select = select; }public Integer getIdCustom() {		return IdCustom ; 	} 
 public void setIdCustom(Integer var) {		this.IdCustom = var; 	} 
 public Integer getRsIdCustom() {		return rsIdCustom ; 	} 
 public void setRsIdCustom(Integer var) {		this.rsIdCustom = var; 	} 
 public String getDescCustom() {		return DescCustom ; 	} 
 public void setDescCustom(String var) {		this.DescCustom = var; 	} 
 public String getRsDescCustom() {		return rsDescCustom ; 	} 
 public void setRsDescCustom(String var) {		this.rsDescCustom = var; 	} 
 public boolean getNullDescCustom() {		return nullDescCustom ; 	} 
 public void setNullDescCustom(boolean var) {		this.nullDescCustom = var; 	} 
 public Integer getIdLoja() {		return IdLoja ; 	} 
 public void setIdLoja(Integer var) {		this.IdLoja = var; 	} 
 public Integer getRsIdLoja() {		return rsIdLoja ; 	} 
 public void setRsIdLoja(Integer var) {		this.rsIdLoja = var; 	} 
 public boolean getNullIdLoja() {		return nullIdLoja ; 	} 
 public void setNullIdLoja(boolean var) {		this.nullIdLoja = var; 	} 
 public Loja  getFkIdLoja() throws Exception {  Loja oFK = new Loja(conn);  oFK.setIdLoja(getRsIdLoja());  oFK.lista();  oFK.next();  return oFK; } public void posicionaRs() throws Exception{ if ( getSelect() == null ) {    try {   rsIdCustom = rs.getInt("id_custom"); } catch (Exception e) { e.printStackTrace();  }  try {   rsDescCustom = rs.getString("desc_custom"); } catch (Exception e) { e.printStackTrace();  }  try {   rsIdLoja = rs.getInt("id_loja"); } catch (Exception e) { e.printStackTrace();  } }  }   public boolean next(){    boolean resultado;   resultado = false;    try{ limpaRs();    resultado = rs.next();    if (resultado){ posicionaRs(); }   } catch (Exception e){    e.printStackTrace(); }     return resultado; } public void limpaRs() throws Exception{  rsIdCustom=  null ;  rsDescCustom=  null ;  rsIdLoja=  null ;   }  public ResultSet lista() throws Exception { sql = new StringBuffer(); if(getSelect()!=null){ sql.append(" select "+getSelect()+" "); }else {sql.append(" select *   "); } if(getJoin()!=null){ sql.append(" from "+getJoin()+" where  1=1 "); }else {sql.append(" from produto_custom where  1=1 "); } if( getIdCustom() != null ) { sql.append(" and produto_custom .id_custom = ? "); } if( getDescCustom() != null ) { sql.append(" and produto_custom .desc_custom = ? "); } if( getIdLoja() != null ) { sql.append(" and produto_custom .id_loja = ? "); } if(getWhere()!=null){ sql.append(" and "+ getWhere()+" "); }        if(getLastSentence()!=null){ sql.append(" "+ getLastSentence()+""); }        st = conn.prepareStatement(sql.toString());  int contparam = 1;  if( getIdCustom() != null ){ st.setInt(contparam,getIdCustom()); contparam++;}  if( getDescCustom() != null ){ st.setString(contparam,getDescCustom()); contparam++;}  if( getIdLoja() != null ){ st.setInt(contparam,getIdLoja()); contparam++;}  	rs = st.executeQuery();  	return rs; }public void update() throws Exception {  if( getIdCustom() == null || getIdCustom() == 0 ) {  throw new Exception("Erro, Pk IdCustom não setada. Update de produto_custom."); }sql = new StringBuffer();sql.append(" update produto_custom set id_custom =  " + getIdCustom() + "  "); if( getDescCustom() != null ) { sql.append(" ,  desc_custom = ? "); } if( getNullDescCustom()) { sql.append(" ,  desc_custom = null "); } if( getIdLoja() != null ) { sql.append(" ,  id_loja = ? "); } if( getNullIdLoja()) { sql.append(" ,  id_loja = null "); } sql.append(" where id_custom =  " + getIdCustom() + "  "); if(getWhere()!=null){ sql.append(" and "+ getWhere()+" "); }        st = conn.prepareStatement(sql.toString());  int contparam = 1;  if( getDescCustom() != null ){ st.setString(contparam,getDescCustom()); contparam++;}  if( getIdLoja() != null ){ st.setInt(contparam,getIdLoja()); contparam++;}  		st.executeUpdate() ;} public void delete() throws Exception { sql = new StringBuffer();sql.append(" delete from produto_custom "); sql.append(" where id_custom =  " + getIdCustom() + "  "); st = conn.prepareStatement(sql.toString());  		st.executeUpdate() ;} public void insert() throws Exception { sql = new StringBuffer();StringBuffer values = new StringBuffer();sql.append(" insert into produto_custom  (id_custom " );values.append(" value (? "); if( getDescCustom() != null ) {sql.append(" , desc_custom ");values.append(", ? "); }  if( getIdLoja() != null ) {sql.append(" , id_loja ");values.append(", ? "); } sql.append(" ) ");values.append(" ) ");sql.append( values.toString()); 	st = conn.prepareStatement(sql.toString(),Statement.RETURN_GENERATED_KEYS);  int contparam = 1;   int id = 	 Utilitario.retornaIdinsert 	 ("produto_custom", "id_custom", conn); st.setInt(contparam, id); contparam++;  if( getDescCustom() != null ){ st.setString(contparam,getDescCustom()); contparam++;  }  if( getIdLoja() != null ){ st.setInt(contparam,getIdLoja()); contparam++;  }  		if (st.executeUpdate() == 1) { setIdCustom(id);} else { throw new Exception("Erro, contate suporte. Inserção de produto_custom.");}}
 
 }