package com.gerador; 
import java.sql.Connection; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import com.funcs.Utilitario; 
import java.util.Date; 
import java.sql.Timestamp; 

public class Campanha { 

private PreparedStatement st; 
private StringBuffer sql; 
private ResultSet rs; 
private Connection conn; 
private String Where; 
private String Join; 
private String LastSentence; 
private String Select; 
public Campanha(Connection conn) { super();this.conn = conn;} 
 private Long IdCampanha; 
 private Long rsIdCampanha; 
 private Long IdUsuario; 
 private Long rsIdUsuario; 
 private  boolean  nullIdUsuario = false; 
 private Timestamp DataCriacao; 
 private Timestamp rsDataCriacao; 
 private  boolean  nullDataCriacao = false; 
 private String LinkInicial; 
 private String rsLinkInicial; 
 private  boolean  nullLinkInicial = false; 
 private String DescNome; 
 private String rsDescNome; 
 private  boolean  nullDescNome = false; 
 private String DescObs; 
 private String rsDescObs; 
 private  boolean  nullDescObs = false; 
 private String FlagAtivo; 
 private String rsFlagAtivo; 
 private  boolean  nullFlagAtivo = false; 
public PreparedStatement getSt() {		return st; 	} 
 public void setSt(PreparedStatement st) {		this.st = st; 	} 
 public StringBuffer getSql() {		return sql; 	} 
 public void setSql(StringBuffer sql) {		this.sql = sql; 	} 
 public ResultSet getRs() {		return rs; 	} 
 public void setRs(ResultSet rs) {		this.rs = rs; 	} 
 public Connection getConn() {		return conn; 	} 
 public void setConn(Connection conn) {		this.conn = conn; 	}
 public String getWhere() { return this.Where; }public void setWhere(String where) { this.Where = where; }public String getJoin() {return this.Join;}public void setJoin(String join) {this.Join = join;}public String getLastSentence() {return this.LastSentence;}public void setLastSentence(String last) {this.LastSentence = last;}public String getSelect() { return this.Select; }public void setSelect(String select) { this.Select = select; }public Long getIdCampanha() {		return IdCampanha ; 	} 
 public void setIdCampanha(Long var) {		this.IdCampanha = var; 	} 
 public Long getRsIdCampanha() {		return rsIdCampanha ; 	} 
 public void setRsIdCampanha(Long var) {		this.rsIdCampanha = var; 	} 
 public Long getIdUsuario() {		return IdUsuario ; 	} 
 public void setIdUsuario(Long var) {		this.IdUsuario = var; 	} 
 public Long getRsIdUsuario() {		return rsIdUsuario ; 	} 
 public void setRsIdUsuario(Long var) {		this.rsIdUsuario = var; 	} 
 public boolean getNullIdUsuario() {		return nullIdUsuario ; 	} 
 public void setNullIdUsuario(boolean var) {		this.nullIdUsuario = var; 	} 
 public Timestamp getDataCriacao() {		return DataCriacao ; 	} 
 public void setDataCriacao(Timestamp var) {		this.DataCriacao = var; 	} 
 public Timestamp getRsDataCriacao() {		return rsDataCriacao ; 	} 
 public void setRsDataCriacao(Timestamp var) {		this.rsDataCriacao = var; 	} 
 public boolean getNullDataCriacao() {		return nullDataCriacao ; 	} 
 public void setNullDataCriacao(boolean var) {		this.nullDataCriacao = var; 	} 
 public String getLinkInicial() {		return LinkInicial ; 	} 
 public void setLinkInicial(String var) {		this.LinkInicial = var; 	} 
 public String getRsLinkInicial() {		return rsLinkInicial ; 	} 
 public void setRsLinkInicial(String var) {		this.rsLinkInicial = var; 	} 
 public boolean getNullLinkInicial() {		return nullLinkInicial ; 	} 
 public void setNullLinkInicial(boolean var) {		this.nullLinkInicial = var; 	} 
 public String getDescNome() {		return DescNome ; 	} 
 public void setDescNome(String var) {		this.DescNome = var; 	} 
 public String getRsDescNome() {		return rsDescNome ; 	} 
 public void setRsDescNome(String var) {		this.rsDescNome = var; 	} 
 public boolean getNullDescNome() {		return nullDescNome ; 	} 
 public void setNullDescNome(boolean var) {		this.nullDescNome = var; 	} 
 public String getDescObs() {		return DescObs ; 	} 
 public void setDescObs(String var) {		this.DescObs = var; 	} 
 public String getRsDescObs() {		return rsDescObs ; 	} 
 public void setRsDescObs(String var) {		this.rsDescObs = var; 	} 
 public boolean getNullDescObs() {		return nullDescObs ; 	} 
 public void setNullDescObs(boolean var) {		this.nullDescObs = var; 	} 
 public String getFlagAtivo() {		return FlagAtivo ; 	} 
 public void setFlagAtivo(String var) {		this.FlagAtivo = var; 	} 
 public String getRsFlagAtivo() {		return rsFlagAtivo ; 	} 
 public void setRsFlagAtivo(String var) {		this.rsFlagAtivo = var; 	} 
 public boolean getNullFlagAtivo() {		return nullFlagAtivo ; 	} 
 public void setNullFlagAtivo(boolean var) {		this.nullFlagAtivo = var; 	} 
  public void posicionaRs() throws Exception{ if ( getSelect() == null ) {    try {   rsIdCampanha = rs.getLong("id_campanha"); } catch (Exception e) { e.printStackTrace();  }  try {   rsIdUsuario = rs.getLong("id_usuario"); } catch (Exception e) { e.printStackTrace();  }  try {   rsDataCriacao = rs.getTimestamp("data_criacao"); } catch (Exception e) { e.printStackTrace();  }  try {   rsLinkInicial = rs.getString("link_inicial"); } catch (Exception e) { e.printStackTrace();  }  try {   rsDescNome = rs.getString("desc_nome"); } catch (Exception e) { e.printStackTrace();  }  try {   rsDescObs = rs.getString("desc_obs"); } catch (Exception e) { e.printStackTrace();  }  try {   rsFlagAtivo = rs.getString("flag_ativo"); } catch (Exception e) { e.printStackTrace();  } }  }   public boolean next(){    boolean resultado;   resultado = false;    try{ limpaRs();    resultado = rs.next();    if (resultado){ posicionaRs(); }   } catch (Exception e){    e.printStackTrace(); }     return resultado; } public void limpaRs() throws Exception{  rsIdCampanha=  null ;  rsIdUsuario=  null ;  rsDataCriacao=  null ;  rsLinkInicial=  null ;  rsDescNome=  null ;  rsDescObs=  null ;  rsFlagAtivo=  null ;   }  public ResultSet lista() throws Exception { sql = new StringBuffer(); if(getSelect()!=null){ sql.append(" select "+getSelect()+" "); }else {sql.append(" select * from campanha  "); } if(getJoin()!=null){ sql.append(" from "+getJoin()+" where  1=1 "); }else {sql.append(" from campanha where  1=1 "); } if( getIdCampanha() != null ) { sql.append(" and campanha .id_campanha = ? "); } if( getIdUsuario() != null ) { sql.append(" and campanha .id_usuario = ? "); } if( getDataCriacao() != null ) { sql.append(" and campanha .data_criacao = ? "); } if( getLinkInicial() != null ) { sql.append(" and campanha .link_inicial = ? "); } if( getDescNome() != null ) { sql.append(" and campanha .desc_nome = ? "); } if( getDescObs() != null ) { sql.append(" and campanha .desc_obs = ? "); } if( getFlagAtivo() != null ) { sql.append(" and campanha .flag_ativo = ? "); } if(getWhere()!=null){ sql.append(" and "+ getWhere()+" "); }        if(getLastSentence()!=null){ sql.append(" "+ getLastSentence()+""); }        st = conn.prepareStatement(sql.toString());  int contparam = 1;  if( getIdCampanha() != null ){ st.setLong(contparam,getIdCampanha()); contparam++;}  if( getIdUsuario() != null ){ st.setLong(contparam,getIdUsuario()); contparam++;}  if( getDataCriacao() != null ){ st.setTimestamp(contparam,getDataCriacao()); contparam++;}  if( getLinkInicial() != null ){ st.setString(contparam,getLinkInicial()); contparam++;}  if( getDescNome() != null ){ st.setString(contparam,getDescNome()); contparam++;}  if( getDescObs() != null ){ st.setString(contparam,getDescObs()); contparam++;}  if( getFlagAtivo() != null ){ st.setString(contparam,getFlagAtivo()); contparam++;}  	rs = st.executeQuery();  	return rs; }public void update() throws Exception { sql = new StringBuffer();sql.append(" update campanha set id_campanha =  " + getIdCampanha() + "  "); if( getIdUsuario() != null ) { sql.append(" ,  id_usuario = ? "); } if( getNullIdUsuario()) { sql.append(" ,  id_usuario = null "); } if( getDataCriacao() != null ) { sql.append(" ,  data_criacao = ? "); } if( getNullDataCriacao()) { sql.append(" ,  data_criacao = null "); } if( getLinkInicial() != null ) { sql.append(" ,  link_inicial = ? "); } if( getNullLinkInicial()) { sql.append(" ,  link_inicial = null "); } if( getDescNome() != null ) { sql.append(" ,  desc_nome = ? "); } if( getNullDescNome()) { sql.append(" ,  desc_nome = null "); } if( getDescObs() != null ) { sql.append(" ,  desc_obs = ? "); } if( getNullDescObs()) { sql.append(" ,  desc_obs = null "); } if( getFlagAtivo() != null ) { sql.append(" ,  flag_ativo = ? "); } if( getNullFlagAtivo()) { sql.append(" ,  flag_ativo = null "); } sql.append(" where id_campanha =  " + getIdCampanha() + "  "); if(getWhere()!=null){ sql.append(" and "+ getWhere()+" "); }        st = conn.prepareStatement(sql.toString());  int contparam = 1;  if( getIdUsuario() != null ){ st.setLong(contparam,getIdUsuario()); contparam++;}  if( getDataCriacao() != null ){ st.setTimestamp(contparam,getDataCriacao()); contparam++;}  if( getLinkInicial() != null ){ st.setString(contparam,getLinkInicial()); contparam++;}  if( getDescNome() != null ){ st.setString(contparam,getDescNome()); contparam++;}  if( getDescObs() != null ){ st.setString(contparam,getDescObs()); contparam++;}  if( getFlagAtivo() != null ){ st.setString(contparam,getFlagAtivo()); contparam++;}  		st.executeUpdate() ;} public void delete() throws Exception { sql = new StringBuffer();sql.append(" delete from campanha "); sql.append(" where id_campanha =  " + getIdCampanha() + "  "); st = conn.prepareStatement(sql.toString());  		st.executeUpdate() ;} public void insert() throws Exception { sql = new StringBuffer();StringBuffer values = new StringBuffer();sql.append(" insert into campanha  (id_campanha " );values.append(" value (? "); if( getIdCampanha() != null ) {sql.append(" , id_campanha ");values.append(", ? "); }  if( getIdUsuario() != null ) {sql.append(" , id_usuario ");values.append(", ? "); }  if( getDataCriacao() != null ) {sql.append(" , data_criacao ");values.append(", ? "); }  if( getLinkInicial() != null ) {sql.append(" , link_inicial ");values.append(", ? "); }  if( getDescNome() != null ) {sql.append(" , desc_nome ");values.append(", ? "); }  if( getDescObs() != null ) {sql.append(" , desc_obs ");values.append(", ? "); }  if( getFlagAtivo() != null ) {sql.append(" , flag_ativo ");values.append(", ? "); } sql.append(" ) ");values.append(" ) ");sql.append( values.toString()); 	st = conn.prepareStatement(sql.toString());   long id = 	 Utilitario.retornaIdinsertLong	 ("campanha", "id_campanha", conn); int contparam = 1;  st.setLong(contparam, id); contparam++;  if( getIdUsuario() != null ){ st.setLong(contparam,getIdUsuario()); contparam++;  }  if( getDataCriacao() != null ){ st.setTimestamp(contparam,getDataCriacao()); contparam++;  }  if( getLinkInicial() != null ){ st.setString(contparam,getLinkInicial()); contparam++;  }  if( getDescNome() != null ){ st.setString(contparam,getDescNome()); contparam++;  }  if( getDescObs() != null ){ st.setString(contparam,getDescObs()); contparam++;  }  if( getFlagAtivo() != null ){ st.setString(contparam,getFlagAtivo()); contparam++;  }  		if (st.executeUpdate() == 1) { setIdCampanha(id);} else { throw new Exception("Erro, contate suporte. Inserção de campanha.");}}
 
 }