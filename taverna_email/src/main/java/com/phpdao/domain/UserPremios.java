package com.phpdao.domain; 
import java.sql.Connection; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import com.funcs.Utilitario; 
import java.util.Date; 
import java.sql.Timestamp; 

public class UserPremios { 

private PreparedStatement st; 
private StringBuffer sql; 
private ResultSet rs; 
private Connection conn; 
private String Where; 
private String Join; 
private String LastSentence; 
private String Select; 
public UserPremios(Connection conn) { super();this.conn = conn;} 
 private Long IdPremio; 
 private Long rsIdPremio; 
 private Long IdUsuario; 
 private Long rsIdUsuario; 
 private  boolean  nullIdUsuario = false; 
 private String DescName; 
 private String rsDescName; 
 private  boolean  nullDescName = false; 
 private String DescExtensao; 
 private String rsDescExtensao; 
 private  boolean  nullDescExtensao = false; 
 private String DescPath; 
 private String rsDescPath; 
 private  boolean  nullDescPath = false; 
public PreparedStatement getSt() {		return st; 	} 
 public void setSt(PreparedStatement st) {		this.st = st; 	} 
 public StringBuffer getSql() {		return sql; 	} 
 public void setSql(StringBuffer sql) {		this.sql = sql; 	} 
 public ResultSet getRs() {		return rs; 	} 
 public void setRs(ResultSet rs) {		this.rs = rs; 	} 
 public Connection getConn() {		return conn; 	} 
 public void setConn(Connection conn) {		this.conn = conn; 	}
 public String getWhere() { return this.Where; }public void setWhere(String where) { this.Where = where; }public String getJoin() {return this.Join;}public void setJoin(String join) {this.Join = join;}public String getLastSentence() {return this.LastSentence;}public void setLastSentence(String last) {this.LastSentence = last;}public String getSelect() { return this.Select; }public void setSelect(String select) { this.Select = select; }public Long getIdPremio() {		return IdPremio ; 	} 
 public void setIdPremio(Long var) {		this.IdPremio = var; 	} 
 public Long getRsIdPremio() {		return rsIdPremio ; 	} 
 public void setRsIdPremio(Long var) {		this.rsIdPremio = var; 	} 
 public Long getIdUsuario() {		return IdUsuario ; 	} 
 public void setIdUsuario(Long var) {		this.IdUsuario = var; 	} 
 public Long getRsIdUsuario() {		return rsIdUsuario ; 	} 
 public void setRsIdUsuario(Long var) {		this.rsIdUsuario = var; 	} 
 public boolean getNullIdUsuario() {		return nullIdUsuario ; 	} 
 public void setNullIdUsuario(boolean var) {		this.nullIdUsuario = var; 	} 
 public String getDescName() {		return DescName ; 	} 
 public void setDescName(String var) {		this.DescName = var; 	} 
 public String getRsDescName() {		return rsDescName ; 	} 
 public void setRsDescName(String var) {		this.rsDescName = var; 	} 
 public boolean getNullDescName() {		return nullDescName ; 	} 
 public void setNullDescName(boolean var) {		this.nullDescName = var; 	} 
 public String getDescExtensao() {		return DescExtensao ; 	} 
 public void setDescExtensao(String var) {		this.DescExtensao = var; 	} 
 public String getRsDescExtensao() {		return rsDescExtensao ; 	} 
 public void setRsDescExtensao(String var) {		this.rsDescExtensao = var; 	} 
 public boolean getNullDescExtensao() {		return nullDescExtensao ; 	} 
 public void setNullDescExtensao(boolean var) {		this.nullDescExtensao = var; 	} 
 public String getDescPath() {		return DescPath ; 	} 
 public void setDescPath(String var) {		this.DescPath = var; 	} 
 public String getRsDescPath() {		return rsDescPath ; 	} 
 public void setRsDescPath(String var) {		this.rsDescPath = var; 	} 
 public boolean getNullDescPath() {		return nullDescPath ; 	} 
 public void setNullDescPath(boolean var) {		this.nullDescPath = var; 	} 
  public void posicionaRs() throws Exception{ if ( getSelect() == null ) {    try {   rsIdPremio = rs.getLong("id_premio"); } catch (Exception e) { e.printStackTrace();  }  try {   rsIdUsuario = rs.getLong("id_usuario"); } catch (Exception e) { e.printStackTrace();  }  try {   rsDescName = rs.getString("desc_name"); } catch (Exception e) { e.printStackTrace();  }  try {   rsDescExtensao = rs.getString("desc_extensao"); } catch (Exception e) { e.printStackTrace();  }  try {   rsDescPath = rs.getString("desc_path"); } catch (Exception e) { e.printStackTrace();  } }  }   public boolean next(){    boolean resultado;   resultado = false;    try{ limpaRs();    resultado = rs.next();    if (resultado){ posicionaRs(); }   } catch (Exception e){    e.printStackTrace(); }     return resultado; } public void limpaRs() throws Exception{  rsIdPremio=  null ;  rsIdUsuario=  null ;  rsDescName=  null ;  rsDescExtensao=  null ;  rsDescPath=  null ;   }  public ResultSet lista() throws Exception { sql = new StringBuffer(); if(getSelect()!=null){ sql.append(" select "+getSelect()+" "); }else {sql.append(" select * from user_premios  "); } if(getJoin()!=null){ sql.append(" from "+getJoin()+" where  1=1 "); }else {sql.append(" from user_premios where  1=1 "); } if( getIdPremio() != null ) { sql.append(" and user_premios .id_premio = ? "); } if( getIdUsuario() != null ) { sql.append(" and user_premios .id_usuario = ? "); } if( getDescName() != null ) { sql.append(" and user_premios .desc_name = ? "); } if( getDescExtensao() != null ) { sql.append(" and user_premios .desc_extensao = ? "); } if( getDescPath() != null ) { sql.append(" and user_premios .desc_path = ? "); } if(getWhere()!=null){ sql.append(" and "+ getWhere()+" "); }        if(getLastSentence()!=null){ sql.append(" "+ getLastSentence()+""); }        st = conn.prepareStatement(sql.toString());  int contparam = 1;  if( getIdPremio() != null ){ st.setLong(contparam,getIdPremio()); contparam++;}  if( getIdUsuario() != null ){ st.setLong(contparam,getIdUsuario()); contparam++;}  if( getDescName() != null ){ st.setString(contparam,getDescName()); contparam++;}  if( getDescExtensao() != null ){ st.setString(contparam,getDescExtensao()); contparam++;}  if( getDescPath() != null ){ st.setString(contparam,getDescPath()); contparam++;}  	rs = st.executeQuery();  	return rs; }public void update() throws Exception { sql = new StringBuffer();sql.append(" update user_premios set id_premio =  " + getIdPremio() + "  "); if( getIdUsuario() != null ) { sql.append(" ,  id_usuario = ? "); } if( getNullIdUsuario()) { sql.append(" ,  id_usuario = null "); } if( getDescName() != null ) { sql.append(" ,  desc_name = ? "); } if( getNullDescName()) { sql.append(" ,  desc_name = null "); } if( getDescExtensao() != null ) { sql.append(" ,  desc_extensao = ? "); } if( getNullDescExtensao()) { sql.append(" ,  desc_extensao = null "); } if( getDescPath() != null ) { sql.append(" ,  desc_path = ? "); } if( getNullDescPath()) { sql.append(" ,  desc_path = null "); } sql.append(" where id_premio =  " + getIdPremio() + "  "); if(getWhere()!=null){ sql.append(" and "+ getWhere()+" "); }        st = conn.prepareStatement(sql.toString());  int contparam = 1;  if( getIdUsuario() != null ){ st.setLong(contparam,getIdUsuario()); contparam++;}  if( getDescName() != null ){ st.setString(contparam,getDescName()); contparam++;}  if( getDescExtensao() != null ){ st.setString(contparam,getDescExtensao()); contparam++;}  if( getDescPath() != null ){ st.setString(contparam,getDescPath()); contparam++;}  		st.executeUpdate() ;} public void delete() throws Exception { sql = new StringBuffer();sql.append(" delete from user_premios "); sql.append(" where id_premio =  " + getIdPremio() + "  "); st = conn.prepareStatement(sql.toString());  		st.executeUpdate() ;} public void insert() throws Exception { sql = new StringBuffer();StringBuffer values = new StringBuffer();sql.append(" insert into user_premios  (id_premio " );values.append(" value (? "); if( getIdPremio() != null ) {sql.append(" , id_premio ");values.append(", ? "); }  if( getIdUsuario() != null ) {sql.append(" , id_usuario ");values.append(", ? "); }  if( getDescName() != null ) {sql.append(" , desc_name ");values.append(", ? "); }  if( getDescExtensao() != null ) {sql.append(" , desc_extensao ");values.append(", ? "); }  if( getDescPath() != null ) {sql.append(" , desc_path ");values.append(", ? "); } sql.append(" ) ");values.append(" ) ");sql.append( values.toString()); 	st = conn.prepareStatement(sql.toString());   long id = 	 Utilitario.retornaIdinsertLong	 ("user_premios", "id_premio", conn); int contparam = 1;  st.setLong(contparam, id); contparam++;  if( getIdUsuario() != null ){ st.setLong(contparam,getIdUsuario()); contparam++;  }  if( getDescName() != null ){ st.setString(contparam,getDescName()); contparam++;  }  if( getDescExtensao() != null ){ st.setString(contparam,getDescExtensao()); contparam++;  }  if( getDescPath() != null ){ st.setString(contparam,getDescPath()); contparam++;  }  		if (st.executeUpdate() == 1) { setIdPremio(id);} else { throw new Exception("Erro, contate suporte. Inserção de user_premios.");}}
 
 }