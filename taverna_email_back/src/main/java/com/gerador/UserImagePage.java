package com.gerador; 
import java.sql.Connection; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import com.funcs.Utilitario; 
import java.util.Date; 
import java.sql.Timestamp; 

public class UserImagePage { 

private PreparedStatement st; 
private StringBuffer sql; 
private ResultSet rs; 
private Connection conn; 
private String Where; 
private String Join; 
private String LastSentence; 
private String Select; 
public UserImagePage(Connection conn) { super();this.conn = conn;} 
 private Long IdAssociacao; 
 private Long rsIdAssociacao; 
 private Long IdImage; 
 private Long rsIdImage; 
 private  boolean  nullIdImage = false; 
 private String IdPage; 
 private String rsIdPage; 
 private  boolean  nullIdPage = false; 
 private String FlagPagetipe; 
 private String rsFlagPagetipe; 
 private  boolean  nullFlagPagetipe = false; 
 private Long IdCampanha; 
 private Long rsIdCampanha; 
 private  boolean  nullIdCampanha = false; 
public PreparedStatement getSt() {		return st; 	} 
 public void setSt(PreparedStatement st) {		this.st = st; 	} 
 public StringBuffer getSql() {		return sql; 	} 
 public void setSql(StringBuffer sql) {		this.sql = sql; 	} 
 public ResultSet getRs() {		return rs; 	} 
 public void setRs(ResultSet rs) {		this.rs = rs; 	} 
 public Connection getConn() {		return conn; 	} 
 public void setConn(Connection conn) {		this.conn = conn; 	}
 public String getWhere() { return this.Where; }public void setWhere(String where) { this.Where = where; }public String getJoin() {return this.Join;}public void setJoin(String join) {this.Join = join;}public String getLastSentence() {return this.LastSentence;}public void setLastSentence(String last) {this.LastSentence = last;}public String getSelect() { return this.Select; }public void setSelect(String select) { this.Select = select; }public Long getIdAssociacao() {		return IdAssociacao ; 	} 
 public void setIdAssociacao(Long var) {		this.IdAssociacao = var; 	} 
 public Long getRsIdAssociacao() {		return rsIdAssociacao ; 	} 
 public void setRsIdAssociacao(Long var) {		this.rsIdAssociacao = var; 	} 
 public Long getIdImage() {		return IdImage ; 	} 
 public void setIdImage(Long var) {		this.IdImage = var; 	} 
 public Long getRsIdImage() {		return rsIdImage ; 	} 
 public void setRsIdImage(Long var) {		this.rsIdImage = var; 	} 
 public boolean getNullIdImage() {		return nullIdImage ; 	} 
 public void setNullIdImage(boolean var) {		this.nullIdImage = var; 	} 
 public String getIdPage() {		return IdPage ; 	} 
 public void setIdPage(String var) {		this.IdPage = var; 	} 
 public String getRsIdPage() {		return rsIdPage ; 	} 
 public void setRsIdPage(String var) {		this.rsIdPage = var; 	} 
 public boolean getNullIdPage() {		return nullIdPage ; 	} 
 public void setNullIdPage(boolean var) {		this.nullIdPage = var; 	} 
 public String getFlagPagetipe() {		return FlagPagetipe ; 	} 
 public void setFlagPagetipe(String var) {		this.FlagPagetipe = var; 	} 
 public String getRsFlagPagetipe() {		return rsFlagPagetipe ; 	} 
 public void setRsFlagPagetipe(String var) {		this.rsFlagPagetipe = var; 	} 
 public boolean getNullFlagPagetipe() {		return nullFlagPagetipe ; 	} 
 public void setNullFlagPagetipe(boolean var) {		this.nullFlagPagetipe = var; 	} 
 public Long getIdCampanha() {		return IdCampanha ; 	} 
 public void setIdCampanha(Long var) {		this.IdCampanha = var; 	} 
 public Long getRsIdCampanha() {		return rsIdCampanha ; 	} 
 public void setRsIdCampanha(Long var) {		this.rsIdCampanha = var; 	} 
 public boolean getNullIdCampanha() {		return nullIdCampanha ; 	} 
 public void setNullIdCampanha(boolean var) {		this.nullIdCampanha = var; 	} 
  public void posicionaRs() throws Exception{ if ( getSelect() == null ) {    try {   rsIdAssociacao = rs.getLong("id_associacao"); } catch (Exception e) { e.printStackTrace();  }  try {   rsIdImage = rs.getLong("id_image"); } catch (Exception e) { e.printStackTrace();  }  try {   rsIdPage = rs.getString("id_page"); } catch (Exception e) { e.printStackTrace();  }  try {   rsFlagPagetipe = rs.getString("flag_pagetipe"); } catch (Exception e) { e.printStackTrace();  }  try {   rsIdCampanha = rs.getLong("id_campanha"); } catch (Exception e) { e.printStackTrace();  } }  }   public boolean next(){    boolean resultado;   resultado = false;    try{ limpaRs();    resultado = rs.next();    if (resultado){ posicionaRs(); }   } catch (Exception e){    e.printStackTrace(); }     return resultado; } public void limpaRs() throws Exception{  rsIdAssociacao=  null ;  rsIdImage=  null ;  rsIdPage=  null ;  rsFlagPagetipe=  null ;  rsIdCampanha=  null ;   }  public ResultSet lista() throws Exception { sql = new StringBuffer(); if(getSelect()!=null){ sql.append(" select "+getSelect()+" "); }else {sql.append(" select * from user_image_page  "); } if(getJoin()!=null){ sql.append(" from "+getJoin()+" where  1=1 "); }else {sql.append(" from user_image_page where  1=1 "); } if( getIdAssociacao() != null ) { sql.append(" and user_image_page .id_associacao = ? "); } if( getIdImage() != null ) { sql.append(" and user_image_page .id_image = ? "); } if( getIdPage() != null ) { sql.append(" and user_image_page .id_page = ? "); } if( getFlagPagetipe() != null ) { sql.append(" and user_image_page .flag_pagetipe = ? "); } if( getIdCampanha() != null ) { sql.append(" and user_image_page .id_campanha = ? "); } if(getWhere()!=null){ sql.append(" and "+ getWhere()+" "); }        if(getLastSentence()!=null){ sql.append(" "+ getLastSentence()+""); }        st = conn.prepareStatement(sql.toString());  int contparam = 1;  if( getIdAssociacao() != null ){ st.setLong(contparam,getIdAssociacao()); contparam++;}  if( getIdImage() != null ){ st.setLong(contparam,getIdImage()); contparam++;}  if( getIdPage() != null ){ st.setString(contparam,getIdPage()); contparam++;}  if( getFlagPagetipe() != null ){ st.setString(contparam,getFlagPagetipe()); contparam++;}  if( getIdCampanha() != null ){ st.setLong(contparam,getIdCampanha()); contparam++;}  	rs = st.executeQuery();  	return rs; }public void update() throws Exception { sql = new StringBuffer();sql.append(" update user_image_page set id_associacao =  " + getIdAssociacao() + "  "); if( getIdImage() != null ) { sql.append(" ,  id_image = ? "); } if( getNullIdImage()) { sql.append(" ,  id_image = null "); } if( getIdPage() != null ) { sql.append(" ,  id_page = ? "); } if( getNullIdPage()) { sql.append(" ,  id_page = null "); } if( getFlagPagetipe() != null ) { sql.append(" ,  flag_pagetipe = ? "); } if( getNullFlagPagetipe()) { sql.append(" ,  flag_pagetipe = null "); } if( getIdCampanha() != null ) { sql.append(" ,  id_campanha = ? "); } if( getNullIdCampanha()) { sql.append(" ,  id_campanha = null "); } sql.append(" where id_associacao =  " + getIdAssociacao() + "  "); if(getWhere()!=null){ sql.append(" and "+ getWhere()+" "); }        st = conn.prepareStatement(sql.toString());  int contparam = 1;  if( getIdImage() != null ){ st.setLong(contparam,getIdImage()); contparam++;}  if( getIdPage() != null ){ st.setString(contparam,getIdPage()); contparam++;}  if( getFlagPagetipe() != null ){ st.setString(contparam,getFlagPagetipe()); contparam++;}  if( getIdCampanha() != null ){ st.setLong(contparam,getIdCampanha()); contparam++;}  		st.executeUpdate() ;} public void delete() throws Exception { sql = new StringBuffer();sql.append(" delete from user_image_page "); sql.append(" where id_associacao =  " + getIdAssociacao() + "  "); st = conn.prepareStatement(sql.toString());  		st.executeUpdate() ;} public void insert() throws Exception { sql = new StringBuffer();StringBuffer values = new StringBuffer();sql.append(" insert into user_image_page  (id_associacao " );values.append(" value (? "); if( getIdAssociacao() != null ) {sql.append(" , id_associacao ");values.append(", ? "); }  if( getIdImage() != null ) {sql.append(" , id_image ");values.append(", ? "); }  if( getIdPage() != null ) {sql.append(" , id_page ");values.append(", ? "); }  if( getFlagPagetipe() != null ) {sql.append(" , flag_pagetipe ");values.append(", ? "); }  if( getIdCampanha() != null ) {sql.append(" , id_campanha ");values.append(", ? "); } sql.append(" ) ");values.append(" ) ");sql.append( values.toString()); 	st = conn.prepareStatement(sql.toString());   long id = 	 Utilitario.retornaIdinsertLong	 ("user_image_page", "id_associacao", conn); int contparam = 1;  st.setLong(contparam, id); contparam++;  if( getIdImage() != null ){ st.setLong(contparam,getIdImage()); contparam++;  }  if( getIdPage() != null ){ st.setString(contparam,getIdPage()); contparam++;  }  if( getFlagPagetipe() != null ){ st.setString(contparam,getFlagPagetipe()); contparam++;  }  if( getIdCampanha() != null ){ st.setLong(contparam,getIdCampanha()); contparam++;  }  		if (st.executeUpdate() == 1) { setIdAssociacao(id);} else { throw new Exception("Erro, contate suporte. Inserção de user_image_page.");}}
 
 }