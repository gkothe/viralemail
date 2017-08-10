package com.phpdao.domain; 
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
 private Integer IdEstado; 
 private Integer rsIdEstado; 
 private  boolean  nullIdEstado = false; 
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
 public Integer getIdEstado() {		return IdEstado ; 	} 
 public void setIdEstado(Integer var) {		this.IdEstado = var; 	} 
 public Integer getRsIdEstado() {		return rsIdEstado ; 	} 
 public void setRsIdEstado(Integer var) {		this.rsIdEstado = var; 	} 
 public boolean getNullIdEstado() {		return nullIdEstado ; 	} 
 public void setNullIdEstado(boolean var) {		this.nullIdEstado = var; 	} 
  public void posicionaRs() throws Exception{ if ( getSelect() == null ) {    try {   rsCodCidade = rs.getInt("cod_cidade"); } catch (Exception e) { e.printStackTrace();  }  try {   rsDescCidade = rs.getString("desc_cidade"); } catch (Exception e) { e.printStackTrace();  }  try {   rsIdEstado = rs.getInt("id_estado"); } catch (Exception e) { e.printStackTrace();  } }  }   public boolean next(){    boolean resultado;   resultado = false;    try{ limpaRs();    resultado = rs.next();    if (resultado){ posicionaRs(); }   } catch (Exception e){    e.printStackTrace(); }     return resultado; } public void limpaRs() throws Exception{  rsCodCidade=  null ;  rsDescCidade=  null ;  rsIdEstado=  null ;   }  public ResultSet lista() throws Exception { sql = new StringBuffer(); if(getSelect()!=null){ sql.append(" select "+getSelect()+" "); }else {sql.append(" select * from cidade  "); } if(getJoin()!=null){ sql.append(" from "+getJoin()+" where  1=1 "); }else {sql.append(" from cidade where  1=1 "); } if( getCodCidade() != null ) { sql.append(" and cidade .cod_cidade = ? "); } if( getDescCidade() != null ) { sql.append(" and cidade .desc_cidade = ? "); } if( getIdEstado() != null ) { sql.append(" and cidade .id_estado = ? "); } if(getWhere()!=null){ sql.append(" and "+ getWhere()+" "); }        if(getLastSentence()!=null){ sql.append(" "+ getLastSentence()+""); }        st = conn.prepareStatement(sql.toString());  int contparam = 1;  if( getCodCidade() != null ){ st.setInt(contparam,getCodCidade()); contparam++;}  if( getDescCidade() != null ){ st.setString(contparam,getDescCidade()); contparam++;}  if( getIdEstado() != null ){ st.setInt(contparam,getIdEstado()); contparam++;}  	rs = st.executeQuery();  	return rs; }public void update() throws Exception { sql = new StringBuffer();sql.append(" update cidade set cod_cidade =  " + getCodCidade() + "  "); if( getDescCidade() != null ) { sql.append(" ,  desc_cidade = ? "); } if( getNullDescCidade()) { sql.append(" ,  desc_cidade = null "); } if( getIdEstado() != null ) { sql.append(" ,  id_estado = ? "); } if( getNullIdEstado()) { sql.append(" ,  id_estado = null "); } sql.append(" where cod_cidade =  " + getCodCidade() + "  "); if(getWhere()!=null){ sql.append(" and "+ getWhere()+" "); }        st = conn.prepareStatement(sql.toString());  int contparam = 1;  if( getDescCidade() != null ){ st.setString(contparam,getDescCidade()); contparam++;}  if( getIdEstado() != null ){ st.setInt(contparam,getIdEstado()); contparam++;}  		st.executeUpdate() ;} public void delete() throws Exception { sql = new StringBuffer();sql.append(" delete from cidade "); sql.append(" where cod_cidade =  " + getCodCidade() + "  "); st = conn.prepareStatement(sql.toString());  		st.executeUpdate() ;} public void insert() throws Exception { sql = new StringBuffer();StringBuffer values = new StringBuffer();sql.append(" insert into cidade  (cod_cidade " );values.append(" value (? "); if( getCodCidade() != null ) {sql.append(" , cod_cidade ");values.append(", ? "); }  if( getDescCidade() != null ) {sql.append(" , desc_cidade ");values.append(", ? "); }  if( getIdEstado() != null ) {sql.append(" , id_estado ");values.append(", ? "); } sql.append(" ) ");values.append(" ) ");sql.append( values.toString()); 	st = conn.prepareStatement(sql.toString());   int id = 	 Utilitario.retornaIdinsert 	 ("cidade", "cod_cidade", conn); int contparam = 1;  st.setInt(contparam, id); contparam++;  if( getDescCidade() != null ){ st.setString(contparam,getDescCidade()); contparam++;  }  if( getIdEstado() != null ){ st.setInt(contparam,getIdEstado()); contparam++;  }  		if (st.executeUpdate() == 1) { setCodCidade(id);} else { throw new Exception("Erro, contate suporte. Inserção de cidade.");}}
 
 }