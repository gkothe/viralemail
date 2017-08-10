package com.gerador; 
import java.sql.Connection; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import com.funcs.Utilitario; 
import java.util.Date; 
import java.sql.Timestamp; 

public class CampanhaLeads { 

private PreparedStatement st; 
private StringBuffer sql; 
private ResultSet rs; 
private Connection conn; 
private String Where; 
private String Join; 
private String LastSentence; 
private String Select; 
public CampanhaLeads(Connection conn) { super();this.conn = conn;} 
 private Long IdLead; 
 private Long rsIdLead; 
 private Long IdCampanha; 
 private Long rsIdCampanha; 
 private  boolean  nullIdCampanha = false; 
 private Long IdLeadReferencia; 
 private Long rsIdLeadReferencia; 
 private  boolean  nullIdLeadReferencia = false; 
 private String DescEmail; 
 private String rsDescEmail; 
 private  boolean  nullDescEmail = false; 
 private String DescLinkReferal; 
 private String rsDescLinkReferal; 
 private  boolean  nullDescLinkReferal = false; 
public PreparedStatement getSt() {		return st; 	} 
 public void setSt(PreparedStatement st) {		this.st = st; 	} 
 public StringBuffer getSql() {		return sql; 	} 
 public void setSql(StringBuffer sql) {		this.sql = sql; 	} 
 public ResultSet getRs() {		return rs; 	} 
 public void setRs(ResultSet rs) {		this.rs = rs; 	} 
 public Connection getConn() {		return conn; 	} 
 public void setConn(Connection conn) {		this.conn = conn; 	}
 public String getWhere() { return this.Where; }public void setWhere(String where) { this.Where = where; }public String getJoin() {return this.Join;}public void setJoin(String join) {this.Join = join;}public String getLastSentence() {return this.LastSentence;}public void setLastSentence(String last) {this.LastSentence = last;}public String getSelect() { return this.Select; }public void setSelect(String select) { this.Select = select; }public Long getIdLead() {		return IdLead ; 	} 
 public void setIdLead(Long var) {		this.IdLead = var; 	} 
 public Long getRsIdLead() {		return rsIdLead ; 	} 
 public void setRsIdLead(Long var) {		this.rsIdLead = var; 	} 
 public Long getIdCampanha() {		return IdCampanha ; 	} 
 public void setIdCampanha(Long var) {		this.IdCampanha = var; 	} 
 public Long getRsIdCampanha() {		return rsIdCampanha ; 	} 
 public void setRsIdCampanha(Long var) {		this.rsIdCampanha = var; 	} 
 public boolean getNullIdCampanha() {		return nullIdCampanha ; 	} 
 public void setNullIdCampanha(boolean var) {		this.nullIdCampanha = var; 	} 
 public Long getIdLeadReferencia() {		return IdLeadReferencia ; 	} 
 public void setIdLeadReferencia(Long var) {		this.IdLeadReferencia = var; 	} 
 public Long getRsIdLeadReferencia() {		return rsIdLeadReferencia ; 	} 
 public void setRsIdLeadReferencia(Long var) {		this.rsIdLeadReferencia = var; 	} 
 public boolean getNullIdLeadReferencia() {		return nullIdLeadReferencia ; 	} 
 public void setNullIdLeadReferencia(boolean var) {		this.nullIdLeadReferencia = var; 	} 
 public String getDescEmail() {		return DescEmail ; 	} 
 public void setDescEmail(String var) {		this.DescEmail = var; 	} 
 public String getRsDescEmail() {		return rsDescEmail ; 	} 
 public void setRsDescEmail(String var) {		this.rsDescEmail = var; 	} 
 public boolean getNullDescEmail() {		return nullDescEmail ; 	} 
 public void setNullDescEmail(boolean var) {		this.nullDescEmail = var; 	} 
 public String getDescLinkReferal() {		return DescLinkReferal ; 	} 
 public void setDescLinkReferal(String var) {		this.DescLinkReferal = var; 	} 
 public String getRsDescLinkReferal() {		return rsDescLinkReferal ; 	} 
 public void setRsDescLinkReferal(String var) {		this.rsDescLinkReferal = var; 	} 
 public boolean getNullDescLinkReferal() {		return nullDescLinkReferal ; 	} 
 public void setNullDescLinkReferal(boolean var) {		this.nullDescLinkReferal = var; 	} 
  public void posicionaRs() throws Exception{ if ( getSelect() == null ) {    try {   rsIdLead = rs.getLong("id_lead"); } catch (Exception e) { e.printStackTrace();  }  try {   rsIdCampanha = rs.getLong("id_campanha"); } catch (Exception e) { e.printStackTrace();  }  try {   rsIdLeadReferencia = rs.getLong("id_lead_referencia"); } catch (Exception e) { e.printStackTrace();  }  try {   rsDescEmail = rs.getString("desc_email"); } catch (Exception e) { e.printStackTrace();  }  try {   rsDescLinkReferal = rs.getString("desc_link_referal"); } catch (Exception e) { e.printStackTrace();  } }  }   public boolean next(){    boolean resultado;   resultado = false;    try{ limpaRs();    resultado = rs.next();    if (resultado){ posicionaRs(); }   } catch (Exception e){    e.printStackTrace(); }     return resultado; } public void limpaRs() throws Exception{  rsIdLead=  null ;  rsIdCampanha=  null ;  rsIdLeadReferencia=  null ;  rsDescEmail=  null ;  rsDescLinkReferal=  null ;   }  public ResultSet lista() throws Exception { sql = new StringBuffer(); if(getSelect()!=null){ sql.append(" select "+getSelect()+" "); }else {sql.append(" select * from campanha_leads  "); } if(getJoin()!=null){ sql.append(" from "+getJoin()+" where  1=1 "); }else {sql.append(" from campanha_leads where  1=1 "); } if( getIdLead() != null ) { sql.append(" and campanha_leads .id_lead = ? "); } if( getIdCampanha() != null ) { sql.append(" and campanha_leads .id_campanha = ? "); } if( getIdLeadReferencia() != null ) { sql.append(" and campanha_leads .id_lead_referencia = ? "); } if( getDescEmail() != null ) { sql.append(" and campanha_leads .desc_email = ? "); } if( getDescLinkReferal() != null ) { sql.append(" and campanha_leads .desc_link_referal = ? "); } if(getWhere()!=null){ sql.append(" and "+ getWhere()+" "); }        if(getLastSentence()!=null){ sql.append(" "+ getLastSentence()+""); }        st = conn.prepareStatement(sql.toString());  int contparam = 1;  if( getIdLead() != null ){ st.setLong(contparam,getIdLead()); contparam++;}  if( getIdCampanha() != null ){ st.setLong(contparam,getIdCampanha()); contparam++;}  if( getIdLeadReferencia() != null ){ st.setLong(contparam,getIdLeadReferencia()); contparam++;}  if( getDescEmail() != null ){ st.setString(contparam,getDescEmail()); contparam++;}  if( getDescLinkReferal() != null ){ st.setString(contparam,getDescLinkReferal()); contparam++;}  	rs = st.executeQuery();  	return rs; }public void update() throws Exception { sql = new StringBuffer();sql.append(" update campanha_leads set id_lead =  " + getIdLead() + "  "); if( getIdCampanha() != null ) { sql.append(" ,  id_campanha = ? "); } if( getNullIdCampanha()) { sql.append(" ,  id_campanha = null "); } if( getIdLeadReferencia() != null ) { sql.append(" ,  id_lead_referencia = ? "); } if( getNullIdLeadReferencia()) { sql.append(" ,  id_lead_referencia = null "); } if( getDescEmail() != null ) { sql.append(" ,  desc_email = ? "); } if( getNullDescEmail()) { sql.append(" ,  desc_email = null "); } if( getDescLinkReferal() != null ) { sql.append(" ,  desc_link_referal = ? "); } if( getNullDescLinkReferal()) { sql.append(" ,  desc_link_referal = null "); } sql.append(" where id_lead =  " + getIdLead() + "  "); if(getWhere()!=null){ sql.append(" and "+ getWhere()+" "); }        st = conn.prepareStatement(sql.toString());  int contparam = 1;  if( getIdCampanha() != null ){ st.setLong(contparam,getIdCampanha()); contparam++;}  if( getIdLeadReferencia() != null ){ st.setLong(contparam,getIdLeadReferencia()); contparam++;}  if( getDescEmail() != null ){ st.setString(contparam,getDescEmail()); contparam++;}  if( getDescLinkReferal() != null ){ st.setString(contparam,getDescLinkReferal()); contparam++;}  		st.executeUpdate() ;} public void delete() throws Exception { sql = new StringBuffer();sql.append(" delete from campanha_leads "); sql.append(" where id_lead =  " + getIdLead() + "  "); st = conn.prepareStatement(sql.toString());  		st.executeUpdate() ;} public void insert() throws Exception { sql = new StringBuffer();StringBuffer values = new StringBuffer();sql.append(" insert into campanha_leads  (id_lead " );values.append(" value (? "); if( getIdLead() != null ) {sql.append(" , id_lead ");values.append(", ? "); }  if( getIdCampanha() != null ) {sql.append(" , id_campanha ");values.append(", ? "); }  if( getIdLeadReferencia() != null ) {sql.append(" , id_lead_referencia ");values.append(", ? "); }  if( getDescEmail() != null ) {sql.append(" , desc_email ");values.append(", ? "); }  if( getDescLinkReferal() != null ) {sql.append(" , desc_link_referal ");values.append(", ? "); } sql.append(" ) ");values.append(" ) ");sql.append( values.toString()); 	st = conn.prepareStatement(sql.toString());   long id = 	 Utilitario.retornaIdinsertLong	 ("campanha_leads", "id_lead", conn); int contparam = 1;  st.setLong(contparam, id); contparam++;  if( getIdCampanha() != null ){ st.setLong(contparam,getIdCampanha()); contparam++;  }  if( getIdLeadReferencia() != null ){ st.setLong(contparam,getIdLeadReferencia()); contparam++;  }  if( getDescEmail() != null ){ st.setString(contparam,getDescEmail()); contparam++;  }  if( getDescLinkReferal() != null ){ st.setString(contparam,getDescLinkReferal()); contparam++;  }  		if (st.executeUpdate() == 1) { setIdLead(id);} else { throw new Exception("Erro, contate suporte. Inserção de campanha_leads.");}}
 
 }