package com.phpdao.domain; 
import java.sql.Connection; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import com.funcs.Utilitario; 
import java.util.Date; 
import java.sql.Timestamp; 

public class UserImage { 

private PreparedStatement st; 
private StringBuffer sql; 
private ResultSet rs; 
private Connection conn; 
private String Where; 
private String Join; 
private String LastSentence; 
private String Select; 
public UserImage(Connection conn) { super();this.conn = conn;} 
 private Long IdImage; 
 private Long rsIdImage; 
 private Long IdUsuario; 
 private Long rsIdUsuario; 
 private  boolean  nullIdUsuario = false; 
 private String DescImage; 
 private String rsDescImage; 
 private  boolean  nullDescImage = false; 
 private String DescPathSystem; 
 private String rsDescPathSystem; 
 private  boolean  nullDescPathSystem = false; 
public PreparedStatement getSt() {		return st; 	} 
 public void setSt(PreparedStatement st) {		this.st = st; 	} 
 public StringBuffer getSql() {		return sql; 	} 
 public void setSql(StringBuffer sql) {		this.sql = sql; 	} 
 public ResultSet getRs() {		return rs; 	} 
 public void setRs(ResultSet rs) {		this.rs = rs; 	} 
 public Connection getConn() {		return conn; 	} 
 public void setConn(Connection conn) {		this.conn = conn; 	}
 public String getWhere() { return this.Where; }public void setWhere(String where) { this.Where = where; }public String getJoin() {return this.Join;}public void setJoin(String join) {this.Join = join;}public String getLastSentence() {return this.LastSentence;}public void setLastSentence(String last) {this.LastSentence = last;}public String getSelect() { return this.Select; }public void setSelect(String select) { this.Select = select; }public Long getIdImage() {		return IdImage ; 	} 
 public void setIdImage(Long var) {		this.IdImage = var; 	} 
 public Long getRsIdImage() {		return rsIdImage ; 	} 
 public void setRsIdImage(Long var) {		this.rsIdImage = var; 	} 
 public Long getIdUsuario() {		return IdUsuario ; 	} 
 public void setIdUsuario(Long var) {		this.IdUsuario = var; 	} 
 public Long getRsIdUsuario() {		return rsIdUsuario ; 	} 
 public void setRsIdUsuario(Long var) {		this.rsIdUsuario = var; 	} 
 public boolean getNullIdUsuario() {		return nullIdUsuario ; 	} 
 public void setNullIdUsuario(boolean var) {		this.nullIdUsuario = var; 	} 
 public String getDescImage() {		return DescImage ; 	} 
 public void setDescImage(String var) {		this.DescImage = var; 	} 
 public String getRsDescImage() {		return rsDescImage ; 	} 
 public void setRsDescImage(String var) {		this.rsDescImage = var; 	} 
 public boolean getNullDescImage() {		return nullDescImage ; 	} 
 public void setNullDescImage(boolean var) {		this.nullDescImage = var; 	} 
 public String getDescPathSystem() {		return DescPathSystem ; 	} 
 public void setDescPathSystem(String var) {		this.DescPathSystem = var; 	} 
 public String getRsDescPathSystem() {		return rsDescPathSystem ; 	} 
 public void setRsDescPathSystem(String var) {		this.rsDescPathSystem = var; 	} 
 public boolean getNullDescPathSystem() {		return nullDescPathSystem ; 	} 
 public void setNullDescPathSystem(boolean var) {		this.nullDescPathSystem = var; 	} 
  public void posicionaRs() throws Exception{ if ( getSelect() == null ) {    try {   rsIdImage = rs.getLong("id_image"); } catch (Exception e) { e.printStackTrace();  }  try {   rsIdUsuario = rs.getLong("id_usuario"); } catch (Exception e) { e.printStackTrace();  }  try {   rsDescImage = rs.getString("desc_image"); } catch (Exception e) { e.printStackTrace();  }  try {   rsDescPathSystem = rs.getString("desc_path_system"); } catch (Exception e) { e.printStackTrace();  } }  }   public boolean next(){    boolean resultado;   resultado = false;    try{ limpaRs();    resultado = rs.next();    if (resultado){ posicionaRs(); }   } catch (Exception e){    e.printStackTrace(); }     return resultado; } public void limpaRs() throws Exception{  rsIdImage=  null ;  rsIdUsuario=  null ;  rsDescImage=  null ;  rsDescPathSystem=  null ;   }  public ResultSet lista() throws Exception { sql = new StringBuffer(); if(getSelect()!=null){ sql.append(" select "+getSelect()+" "); }else {sql.append(" select * from user_image  "); } if(getJoin()!=null){ sql.append(" from "+getJoin()+" where  1=1 "); }else {sql.append(" from user_image where  1=1 "); } if( getIdImage() != null ) { sql.append(" and user_image .id_image = ? "); } if( getIdUsuario() != null ) { sql.append(" and user_image .id_usuario = ? "); } if( getDescImage() != null ) { sql.append(" and user_image .desc_image = ? "); } if( getDescPathSystem() != null ) { sql.append(" and user_image .desc_path_system = ? "); } if(getWhere()!=null){ sql.append(" and "+ getWhere()+" "); }        if(getLastSentence()!=null){ sql.append(" "+ getLastSentence()+""); }        st = conn.prepareStatement(sql.toString());  int contparam = 1;  if( getIdImage() != null ){ st.setLong(contparam,getIdImage()); contparam++;}  if( getIdUsuario() != null ){ st.setLong(contparam,getIdUsuario()); contparam++;}  if( getDescImage() != null ){ st.setString(contparam,getDescImage()); contparam++;}  if( getDescPathSystem() != null ){ st.setString(contparam,getDescPathSystem()); contparam++;}  	rs = st.executeQuery();  	return rs; }public void update() throws Exception { sql = new StringBuffer();sql.append(" update user_image set id_image =  " + getIdImage() + "  "); if( getIdUsuario() != null ) { sql.append(" ,  id_usuario = ? "); } if( getNullIdUsuario()) { sql.append(" ,  id_usuario = null "); } if( getDescImage() != null ) { sql.append(" ,  desc_image = ? "); } if( getNullDescImage()) { sql.append(" ,  desc_image = null "); } if( getDescPathSystem() != null ) { sql.append(" ,  desc_path_system = ? "); } if( getNullDescPathSystem()) { sql.append(" ,  desc_path_system = null "); } sql.append(" where id_image =  " + getIdImage() + "  "); if(getWhere()!=null){ sql.append(" and "+ getWhere()+" "); }        st = conn.prepareStatement(sql.toString());  int contparam = 1;  if( getIdUsuario() != null ){ st.setLong(contparam,getIdUsuario()); contparam++;}  if( getDescImage() != null ){ st.setString(contparam,getDescImage()); contparam++;}  if( getDescPathSystem() != null ){ st.setString(contparam,getDescPathSystem()); contparam++;}  		st.executeUpdate() ;} public void delete() throws Exception { sql = new StringBuffer();sql.append(" delete from user_image "); sql.append(" where id_image =  " + getIdImage() + "  "); st = conn.prepareStatement(sql.toString());  		st.executeUpdate() ;} public void insert() throws Exception { sql = new StringBuffer();StringBuffer values = new StringBuffer();sql.append(" insert into user_image  (id_image " );values.append(" value (? "); if( getIdImage() != null ) {sql.append(" , id_image ");values.append(", ? "); }  if( getIdUsuario() != null ) {sql.append(" , id_usuario ");values.append(", ? "); }  if( getDescImage() != null ) {sql.append(" , desc_image ");values.append(", ? "); }  if( getDescPathSystem() != null ) {sql.append(" , desc_path_system ");values.append(", ? "); } sql.append(" ) ");values.append(" ) ");sql.append( values.toString()); 	st = conn.prepareStatement(sql.toString());   long id = 	 Utilitario.retornaIdinsertLong	 ("user_image", "id_image", conn); int contparam = 1;  st.setLong(contparam, id); contparam++;  if( getIdUsuario() != null ){ st.setLong(contparam,getIdUsuario()); contparam++;  }  if( getDescImage() != null ){ st.setString(contparam,getDescImage()); contparam++;  }  if( getDescPathSystem() != null ){ st.setString(contparam,getDescPathSystem()); contparam++;  }  		if (st.executeUpdate() == 1) { setIdImage(id);} else { throw new Exception("Erro, contate suporte. Inserção de user_image.");}}
 
 }