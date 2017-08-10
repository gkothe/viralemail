package com.phpdao.domain; 
import java.sql.Connection; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import com.funcs.Utilitario; 
import java.util.Date; 
import java.sql.Timestamp; 

public class CampanhaEmail { 

private PreparedStatement st; 
private StringBuffer sql; 
private ResultSet rs; 
private Connection conn; 
private String Where; 
private String Join; 
private String LastSentence; 
private String Select; 
public CampanhaEmail(Connection conn) { super();this.conn = conn;} 
 private Long IdEmail; 
 private Long rsIdEmail; 
 private Long IdCampanha; 
 private Long rsIdCampanha; 
 private  boolean  nullIdCampanha = false; 
 private String DescEmail; 
 private String rsDescEmail; 
 private  boolean  nullDescEmail = false; 
 private String DescTitulo; 
 private String rsDescTitulo; 
 private  boolean  nullDescTitulo = false; 
 private Integer QtdReferencia; 
 private Integer rsQtdReferencia; 
 private  boolean  nullQtdReferencia = false; 
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
 public Long getIdCampanha() {		return IdCampanha ; 	} 
 public void setIdCampanha(Long var) {		this.IdCampanha = var; 	} 
 public Long getRsIdCampanha() {		return rsIdCampanha ; 	} 
 public void setRsIdCampanha(Long var) {		this.rsIdCampanha = var; 	} 
 public boolean getNullIdCampanha() {		return nullIdCampanha ; 	} 
 public void setNullIdCampanha(boolean var) {		this.nullIdCampanha = var; 	} 
 public String getDescEmail() {		return DescEmail ; 	} 
 public void setDescEmail(String var) {		this.DescEmail = var; 	} 
 public String getRsDescEmail() {		return rsDescEmail ; 	} 
 public void setRsDescEmail(String var) {		this.rsDescEmail = var; 	} 
 public boolean getNullDescEmail() {		return nullDescEmail ; 	} 
 public void setNullDescEmail(boolean var) {		this.nullDescEmail = var; 	} 
 public String getDescTitulo() {		return DescTitulo ; 	} 
 public void setDescTitulo(String var) {		this.DescTitulo = var; 	} 
 public String getRsDescTitulo() {		return rsDescTitulo ; 	} 
 public void setRsDescTitulo(String var) {		this.rsDescTitulo = var; 	} 
 public boolean getNullDescTitulo() {		return nullDescTitulo ; 	} 
 public void setNullDescTitulo(boolean var) {		this.nullDescTitulo = var; 	} 
 public Integer getQtdReferencia() {		return QtdReferencia ; 	} 
 public void setQtdReferencia(Integer var) {		this.QtdReferencia = var; 	} 
 public Integer getRsQtdReferencia() {		return rsQtdReferencia ; 	} 
 public void setRsQtdReferencia(Integer var) {		this.rsQtdReferencia = var; 	} 
 public boolean getNullQtdReferencia() {		return nullQtdReferencia ; 	} 
 public void setNullQtdReferencia(boolean var) {		this.nullQtdReferencia = var; 	} 
  public void posicionaRs() throws Exception{ if ( getSelect() == null ) {    try {   rsIdEmail = rs.getLong("id_email"); } catch (Exception e) { e.printStackTrace();  }  try {   rsIdCampanha = rs.getLong("id_campanha"); } catch (Exception e) { e.printStackTrace();  }  try {   rsDescEmail = rs.getString("desc_email"); } catch (Exception e) { e.printStackTrace();  }  try {   rsDescTitulo = rs.getString("desc_titulo"); } catch (Exception e) { e.printStackTrace();  }  try {   rsQtdReferencia = rs.getInt("qtd_referencia"); } catch (Exception e) { e.printStackTrace();  } }  }   public boolean next(){    boolean resultado;   resultado = false;    try{ limpaRs();    resultado = rs.next();    if (resultado){ posicionaRs(); }   } catch (Exception e){    e.printStackTrace(); }     return resultado; } public void limpaRs() throws Exception{  rsIdEmail=  null ;  rsIdCampanha=  null ;  rsDescEmail=  null ;  rsDescTitulo=  null ;  rsQtdReferencia=  null ;   }  public ResultSet lista() throws Exception { sql = new StringBuffer(); if(getSelect()!=null){ sql.append(" select "+getSelect()+" "); }else {sql.append(" select *   "); } if(getJoin()!=null){ sql.append(" from "+getJoin()+" where  1=1 "); }else {sql.append(" from campanha_email where  1=1 "); } if( getIdEmail() != null ) { sql.append(" and campanha_email .id_email = ? "); } if( getIdCampanha() != null ) { sql.append(" and campanha_email .id_campanha = ? "); } if( getDescEmail() != null ) { sql.append(" and campanha_email .desc_email = ? "); } if( getDescTitulo() != null ) { sql.append(" and campanha_email .desc_titulo = ? "); } if( getQtdReferencia() != null ) { sql.append(" and campanha_email .qtd_referencia = ? "); } if(getWhere()!=null){ sql.append(" and "+ getWhere()+" "); }        if(getLastSentence()!=null){ sql.append(" "+ getLastSentence()+""); }        st = conn.prepareStatement(sql.toString());  int contparam = 1;  if( getIdEmail() != null ){ st.setLong(contparam,getIdEmail()); contparam++;}  if( getIdCampanha() != null ){ st.setLong(contparam,getIdCampanha()); contparam++;}  if( getDescEmail() != null ){ st.setString(contparam,getDescEmail()); contparam++;}  if( getDescTitulo() != null ){ st.setString(contparam,getDescTitulo()); contparam++;}  if( getQtdReferencia() != null ){ st.setInt(contparam,getQtdReferencia()); contparam++;}  	rs = st.executeQuery();  	return rs; }public void update() throws Exception { sql = new StringBuffer();sql.append(" update campanha_email set id_email =  " + getIdEmail() + "  "); if( getIdCampanha() != null ) { sql.append(" ,  id_campanha = ? "); } if( getNullIdCampanha()) { sql.append(" ,  id_campanha = null "); } if( getDescEmail() != null ) { sql.append(" ,  desc_email = ? "); } if( getNullDescEmail()) { sql.append(" ,  desc_email = null "); } if( getDescTitulo() != null ) { sql.append(" ,  desc_titulo = ? "); } if( getNullDescTitulo()) { sql.append(" ,  desc_titulo = null "); } if( getQtdReferencia() != null ) { sql.append(" ,  qtd_referencia = ? "); } if( getNullQtdReferencia()) { sql.append(" ,  qtd_referencia = null "); } sql.append(" where id_email =  " + getIdEmail() + "  "); if(getWhere()!=null){ sql.append(" and "+ getWhere()+" "); }        st = conn.prepareStatement(sql.toString());  int contparam = 1;  if( getIdCampanha() != null ){ st.setLong(contparam,getIdCampanha()); contparam++;}  if( getDescEmail() != null ){ st.setString(contparam,getDescEmail()); contparam++;}  if( getDescTitulo() != null ){ st.setString(contparam,getDescTitulo()); contparam++;}  if( getQtdReferencia() != null ){ st.setInt(contparam,getQtdReferencia()); contparam++;}  		st.executeUpdate() ;} public void delete() throws Exception { sql = new StringBuffer();sql.append(" delete from campanha_email "); sql.append(" where id_email =  " + getIdEmail() + "  "); st = conn.prepareStatement(sql.toString());  		st.executeUpdate() ;} public void insert() throws Exception { sql = new StringBuffer();StringBuffer values = new StringBuffer();sql.append(" insert into campanha_email  (id_email " );values.append(" value (? "); if( getIdEmail() != null ) {sql.append(" , id_email ");values.append(", ? "); }  if( getIdCampanha() != null ) {sql.append(" , id_campanha ");values.append(", ? "); }  if( getDescEmail() != null ) {sql.append(" , desc_email ");values.append(", ? "); }  if( getDescTitulo() != null ) {sql.append(" , desc_titulo ");values.append(", ? "); }  if( getQtdReferencia() != null ) {sql.append(" , qtd_referencia ");values.append(", ? "); } sql.append(" ) ");values.append(" ) ");sql.append( values.toString()); 	st = conn.prepareStatement(sql.toString());   long id = 	 Utilitario.retornaIdinsertLong	 ("campanha_email", "id_email", conn); int contparam = 1;  st.setLong(contparam, id); contparam++;  if( getIdCampanha() != null ){ st.setLong(contparam,getIdCampanha()); contparam++;  }  if( getDescEmail() != null ){ st.setString(contparam,getDescEmail()); contparam++;  }  if( getDescTitulo() != null ){ st.setString(contparam,getDescTitulo()); contparam++;  }  if( getQtdReferencia() != null ){ st.setInt(contparam,getQtdReferencia()); contparam++;  }  		if (st.executeUpdate() == 1) { setIdEmail(id);} else { throw new Exception("Erro, contate suporte. Inserção de campanha_email.");}}
 
 }