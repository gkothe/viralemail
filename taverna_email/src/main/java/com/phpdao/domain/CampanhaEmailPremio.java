package com.phpdao.domain; 
import java.sql.Connection; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import com.funcs.Utilitario; 
import java.util.Date; 
import java.sql.Timestamp; 

public class CampanhaEmailPremio { 

private PreparedStatement st; 
private StringBuffer sql; 
private ResultSet rs; 
private Connection conn; 
private String Where; 
private String Join; 
private String LastSentence; 
private String Select; 
public CampanhaEmailPremio(Connection conn) { super();this.conn = conn;} 
 private Long IdEmail; 
 private Long rsIdEmail; 
 private Long IdPremio; 
 private Long rsIdPremio; 
public PreparedStatement getSt() {		return st; 	} 
 public void setSt(PreparedStatement st) {		this.st = st; 	} 
 public StringBuffer getSql() {		return sql; 	} 
 public void setSql(StringBuffer sql) {		this.sql = sql; 	} 
 public ResultSet getRs() {		return rs; 	} 
 public void setRs(ResultSet rs) {		this.rs = rs; 	} 
 public Connection getConn() {		return conn; 	} 
 public void setConn(Connection conn) {		this.conn = conn; 	}
 public String getWhere() { return this.Where; }public void setWhere(String where) { this.Where = where; }public String getJoin() {return this.Join;}public void setJoin(String join) {this.Join = join;}public String getLastSentence() {return this.LastSentence;}public void setLastSentence(String last) {this.LastSentence = last;}public String getSelect() { return this.Select; }public void setSelect(String select) { this.Select = select; }public Long getIdEmail() {		return IdEmail ; 	} 
 public void setIdEmail(Long var) {		this.IdEmail = var; 	} 
 public Long getRsIdEmail() {		return rsIdEmail ; 	} 
 public void setRsIdEmail(Long var) {		this.rsIdEmail = var; 	} 
 public Long getIdPremio() {		return IdPremio ; 	} 
 public void setIdPremio(Long var) {		this.IdPremio = var; 	} 
 public Long getRsIdPremio() {		return rsIdPremio ; 	} 
 public void setRsIdPremio(Long var) {		this.rsIdPremio = var; 	} 
  public void posicionaRs() throws Exception{ if ( getSelect() == null ) {    try {   rsIdEmail = rs.getLong("id_email"); } catch (Exception e) { e.printStackTrace();  }  try {   rsIdPremio = rs.getLong("id_premio"); } catch (Exception e) { e.printStackTrace();  } }  }   public boolean next(){    boolean resultado;   resultado = false;    try{ limpaRs();    resultado = rs.next();    if (resultado){ posicionaRs(); }   } catch (Exception e){    e.printStackTrace(); }     return resultado; } public void limpaRs() throws Exception{  rsIdEmail=  null ;  rsIdPremio=  null ;   }  public ResultSet lista() throws Exception { sql = new StringBuffer(); if(getSelect()!=null){ sql.append(" select "+getSelect()+" "); }else {sql.append(" select *   "); } if(getJoin()!=null){ sql.append(" from "+getJoin()+" where  1=1 "); }else {sql.append(" from campanha_email_premio where  1=1 "); } if( getIdEmail() != null ) { sql.append(" and campanha_email_premio .id_email = ? "); } if( getIdPremio() != null ) { sql.append(" and campanha_email_premio .id_premio = ? "); } if(getWhere()!=null){ sql.append(" and "+ getWhere()+" "); }        if(getLastSentence()!=null){ sql.append(" "+ getLastSentence()+""); }        st = conn.prepareStatement(sql.toString());  int contparam = 1;  if( getIdEmail() != null ){ st.setLong(contparam,getIdEmail()); contparam++;}  if( getIdPremio() != null ){ st.setLong(contparam,getIdPremio()); contparam++;}  	rs = st.executeQuery();  	return rs; }public void update() throws Exception { sql = new StringBuffer();sql.append(" update campanha_email_premio set id_email =  " + getIdEmail() + "  "); sql.append(" where id_email =  " + getIdEmail() + "  "); sql.append(" and id_premio =  " + getIdPremio() + "  "); if(getWhere()!=null){ sql.append(" and "+ getWhere()+" "); }        st = conn.prepareStatement(sql.toString());  int contparam = 1;  		st.executeUpdate() ;} public void delete() throws Exception { sql = new StringBuffer();sql.append(" delete from campanha_email_premio "); sql.append(" where id_email =  " + getIdEmail() + "  "); sql.append(" and id_premio =  " + getIdPremio() + "  "); st = conn.prepareStatement(sql.toString());  		st.executeUpdate() ;} public void insert() throws Exception { sql = new StringBuffer();StringBuffer values = new StringBuffer();sql.append(" insert into campanha_email_premio  (id_email,id_premio " );values.append(" value (?,? "); if( getIdEmail() != null ) {sql.append(" , id_email ");values.append(", ? "); }  if( getIdPremio() != null ) {sql.append(" , id_premio ");values.append(", ? "); } sql.append(" ) ");values.append(" ) ");sql.append( values.toString()); 	st = conn.prepareStatement(sql.toString());   long id = 	 Utilitario.retornaIdinsertChaveSecundariaLong	("campanha_email_premio", "id_email", getIdEmail()+"", "id_premio", conn);  int contparam = 1;  st.setLong(contparam, getIdEmail()); contparam++;  st.setLong(contparam,id); contparam++;  		if (st.executeUpdate() == 1) { setIdPremio(id);} else { throw new Exception("Erro, contate suporte. Inserção de campanha_email_premio.");}}
 
 }