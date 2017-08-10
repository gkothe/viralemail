package com.phpdao.domain; 
import java.sql.Connection; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import com.funcs.Utilitario; 
import java.util.Date; 
import java.sql.Timestamp; 

public class Estado { 

private PreparedStatement st; 
private StringBuffer sql; 
private ResultSet rs; 
private Connection conn; 
private String Where; 
private String Join; 
private String LastSentence; 
private String Select; 
public Estado(Connection conn) { super();this.conn = conn;} 
 private Integer IdEstado; 
 private Integer rsIdEstado; 
 private String DescUf; 
 private String rsDescUf; 
 private  boolean  nullDescUf = false; 
 private String DescEstado; 
 private String rsDescEstado; 
 private  boolean  nullDescEstado = false; 
public PreparedStatement getSt() {		return st; 	} 
 public void setSt(PreparedStatement st) {		this.st = st; 	} 
 public StringBuffer getSql() {		return sql; 	} 
 public void setSql(StringBuffer sql) {		this.sql = sql; 	} 
 public ResultSet getRs() {		return rs; 	} 
 public void setRs(ResultSet rs) {		this.rs = rs; 	} 
 public Connection getConn() {		return conn; 	} 
 public void setConn(Connection conn) {		this.conn = conn; 	}
 public String getWhere() { return this.Where; }public void setWhere(String where) { this.Where = where; }public String getJoin() {return this.Join;}public void setJoin(String join) {this.Join = join;}public String getLastSentence() {return this.LastSentence;}public void setLastSentence(String last) {this.LastSentence = last;}public String getSelect() { return this.Select; }public void setSelect(String select) { this.Select = select; }public Integer getIdEstado() {		return IdEstado ; 	} 
 public void setIdEstado(Integer var) {		this.IdEstado = var; 	} 
 public Integer getRsIdEstado() {		return rsIdEstado ; 	} 
 public void setRsIdEstado(Integer var) {		this.rsIdEstado = var; 	} 
 public String getDescUf() {		return DescUf ; 	} 
 public void setDescUf(String var) {		this.DescUf = var; 	} 
 public String getRsDescUf() {		return rsDescUf ; 	} 
 public void setRsDescUf(String var) {		this.rsDescUf = var; 	} 
 public boolean getNullDescUf() {		return nullDescUf ; 	} 
 public void setNullDescUf(boolean var) {		this.nullDescUf = var; 	} 
 public String getDescEstado() {		return DescEstado ; 	} 
 public void setDescEstado(String var) {		this.DescEstado = var; 	} 
 public String getRsDescEstado() {		return rsDescEstado ; 	} 
 public void setRsDescEstado(String var) {		this.rsDescEstado = var; 	} 
 public boolean getNullDescEstado() {		return nullDescEstado ; 	} 
 public void setNullDescEstado(boolean var) {		this.nullDescEstado = var; 	} 
  public void posicionaRs() throws Exception{ if ( getSelect() == null ) {    try {   rsIdEstado = rs.getInt("id_estado"); } catch (Exception e) { e.printStackTrace();  }  try {   rsDescUf = rs.getString("desc_uf"); } catch (Exception e) { e.printStackTrace();  }  try {   rsDescEstado = rs.getString("desc_estado"); } catch (Exception e) { e.printStackTrace();  } }  }   public boolean next(){    boolean resultado;   resultado = false;    try{ limpaRs();    resultado = rs.next();    if (resultado){ posicionaRs(); }   } catch (Exception e){    e.printStackTrace(); }     return resultado; } public void limpaRs() throws Exception{  rsIdEstado=  null ;  rsDescUf=  null ;  rsDescEstado=  null ;   }  public ResultSet lista() throws Exception { sql = new StringBuffer(); if(getSelect()!=null){ sql.append(" select "+getSelect()+" "); }else {sql.append(" select * from estado  "); } if(getJoin()!=null){ sql.append(" from "+getJoin()+" where  1=1 "); }else {sql.append(" from estado where  1=1 "); } if( getIdEstado() != null ) { sql.append(" and estado .id_estado = ? "); } if( getDescUf() != null ) { sql.append(" and estado .desc_uf = ? "); } if( getDescEstado() != null ) { sql.append(" and estado .desc_estado = ? "); } if(getWhere()!=null){ sql.append(" and "+ getWhere()+" "); }        if(getLastSentence()!=null){ sql.append(" "+ getLastSentence()+""); }        st = conn.prepareStatement(sql.toString());  int contparam = 1;  if( getIdEstado() != null ){ st.setInt(contparam,getIdEstado()); contparam++;}  if( getDescUf() != null ){ st.setString(contparam,getDescUf()); contparam++;}  if( getDescEstado() != null ){ st.setString(contparam,getDescEstado()); contparam++;}  	rs = st.executeQuery();  	return rs; }public void update() throws Exception { sql = new StringBuffer();sql.append(" update estado set id_estado =  " + getIdEstado() + "  "); if( getDescUf() != null ) { sql.append(" ,  desc_uf = ? "); } if( getNullDescUf()) { sql.append(" ,  desc_uf = null "); } if( getDescEstado() != null ) { sql.append(" ,  desc_estado = ? "); } if( getNullDescEstado()) { sql.append(" ,  desc_estado = null "); } sql.append(" where id_estado =  " + getIdEstado() + "  "); if(getWhere()!=null){ sql.append(" and "+ getWhere()+" "); }        st = conn.prepareStatement(sql.toString());  int contparam = 1;  if( getDescUf() != null ){ st.setString(contparam,getDescUf()); contparam++;}  if( getDescEstado() != null ){ st.setString(contparam,getDescEstado()); contparam++;}  		st.executeUpdate() ;} public void delete() throws Exception { sql = new StringBuffer();sql.append(" delete from estado "); sql.append(" where id_estado =  " + getIdEstado() + "  "); st = conn.prepareStatement(sql.toString());  		st.executeUpdate() ;} public void insert() throws Exception { sql = new StringBuffer();StringBuffer values = new StringBuffer();sql.append(" insert into estado  (id_estado " );values.append(" value (? "); if( getIdEstado() != null ) {sql.append(" , id_estado ");values.append(", ? "); }  if( getDescUf() != null ) {sql.append(" , desc_uf ");values.append(", ? "); }  if( getDescEstado() != null ) {sql.append(" , desc_estado ");values.append(", ? "); } sql.append(" ) ");values.append(" ) ");sql.append( values.toString()); 	st = conn.prepareStatement(sql.toString());   int id = 	 Utilitario.retornaIdinsert 	 ("estado", "id_estado", conn); int contparam = 1;  st.setInt(contparam, id); contparam++;  if( getDescUf() != null ){ st.setString(contparam,getDescUf()); contparam++;  }  if( getDescEstado() != null ){ st.setString(contparam,getDescEstado()); contparam++;  }  		if (st.executeUpdate() == 1) { setIdEstado(id);} else { throw new Exception("Erro, contate suporte. Inserção de estado.");}}
 
 }