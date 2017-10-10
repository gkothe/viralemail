package com.cruds; 
import java.sql.Connection; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import com.funcs.Utilitario; 
import java.util.Date; 
import java.sql.Timestamp; 
import com.mysql.jdbc.Statement; 
 import com.cruds.Cidade ;  import com.cruds.Bairros ; 
public class Loja { 

private PreparedStatement st; 
private StringBuffer sql; 
private ResultSet rs; 
private Connection conn; 
private String Where; 
private String Join; 
private String LastSentence; 
private String Select; 
public Loja(Connection conn) { super();this.conn = conn;} 
 private Integer IdLoja; 
 private Integer rsIdLoja; 
 private Integer CodCidade; 
 private Integer rsCodCidade; 
 private  boolean  nullCodCidade = false; 
 private Integer CodBairro; 
 private Integer rsCodBairro; 
 private  boolean  nullCodBairro = false; 
 private String DescRazaoSocial; 
 private String rsDescRazaoSocial; 
 private  boolean  nullDescRazaoSocial = false; 
 private String DescNomeAbrev; 
 private String rsDescNomeAbrev; 
 private  boolean  nullDescNomeAbrev = false; 
 private String DescTelefone; 
 private String rsDescTelefone; 
 private  boolean  nullDescTelefone = false; 
 private String DescEndereco; 
 private String rsDescEndereco; 
 private  boolean  nullDescEndereco = false; 
 private String NumEnderec; 
 private String rsNumEnderec; 
 private  boolean  nullNumEnderec = false; 
 private String DescComplemento; 
 private String rsDescComplemento; 
 private  boolean  nullDescComplemento = false; 
 private String DescLogin; 
 private String rsDescLogin; 
 private  boolean  nullDescLogin = false; 
 private String DescSenha; 
 private String rsDescSenha; 
 private  boolean  nullDescSenha = false; 
 private String DescMail; 
 private String rsDescMail; 
 private  boolean  nullDescMail = false; 
 private String FlagAtivoMaster; 
 private String rsFlagAtivoMaster; 
 private  boolean  nullFlagAtivoMaster = false; 
 private String FlagAtivo; 
 private String rsFlagAtivo; 
 private  boolean  nullFlagAtivo = false; 
 private Timestamp DateLastajax; 
 private Timestamp rsDateLastajax; 
 private  boolean  nullDateLastajax = false; 
 private String TxtObsHora; 
 private String rsTxtObsHora; 
 private  boolean  nullTxtObsHora = false; 
 private String DescLoja; 
 private String rsDescLoja; 
 private  boolean  nullDescLoja = false; 
public PreparedStatement getSt() {		return st; 	} 
 public void setSt(PreparedStatement st) {		this.st = st; 	} 
 public StringBuffer getSql() {		return sql; 	} 
 public void setSql(StringBuffer sql) {		this.sql = sql; 	} 
 public ResultSet getRs() {		return rs; 	} 
 public void setRs(ResultSet rs) {		this.rs = rs; 	} 
 public Connection getConn() {		return conn; 	} 
 public void setConn(Connection conn) {		this.conn = conn; 	}
 public String getWhere() { return this.Where; }public void setWhere(String where) { this.Where = where; }public String getJoin() {return this.Join;}public void setJoin(String join) {this.Join = join;}public String getLastSentence() {return this.LastSentence;}public void setLastSentence(String last) {this.LastSentence = last;}public String getSelect() { return this.Select; }public void setSelect(String select) { this.Select = select; }public Integer getIdLoja() {		return IdLoja ; 	} 
 public void setIdLoja(Integer var) {		this.IdLoja = var; 	} 
 public Integer getRsIdLoja() {		return rsIdLoja ; 	} 
 public void setRsIdLoja(Integer var) {		this.rsIdLoja = var; 	} 
 public Integer getCodCidade() {		return CodCidade ; 	} 
 public void setCodCidade(Integer var) {		this.CodCidade = var; 	} 
 public Integer getRsCodCidade() {		return rsCodCidade ; 	} 
 public void setRsCodCidade(Integer var) {		this.rsCodCidade = var; 	} 
 public boolean getNullCodCidade() {		return nullCodCidade ; 	} 
 public void setNullCodCidade(boolean var) {		this.nullCodCidade = var; 	} 
 public Integer getCodBairro() {		return CodBairro ; 	} 
 public void setCodBairro(Integer var) {		this.CodBairro = var; 	} 
 public Integer getRsCodBairro() {		return rsCodBairro ; 	} 
 public void setRsCodBairro(Integer var) {		this.rsCodBairro = var; 	} 
 public boolean getNullCodBairro() {		return nullCodBairro ; 	} 
 public void setNullCodBairro(boolean var) {		this.nullCodBairro = var; 	} 
 public String getDescRazaoSocial() {		return DescRazaoSocial ; 	} 
 public void setDescRazaoSocial(String var) {		this.DescRazaoSocial = var; 	} 
 public String getRsDescRazaoSocial() {		return rsDescRazaoSocial ; 	} 
 public void setRsDescRazaoSocial(String var) {		this.rsDescRazaoSocial = var; 	} 
 public boolean getNullDescRazaoSocial() {		return nullDescRazaoSocial ; 	} 
 public void setNullDescRazaoSocial(boolean var) {		this.nullDescRazaoSocial = var; 	} 
 public String getDescNomeAbrev() {		return DescNomeAbrev ; 	} 
 public void setDescNomeAbrev(String var) {		this.DescNomeAbrev = var; 	} 
 public String getRsDescNomeAbrev() {		return rsDescNomeAbrev ; 	} 
 public void setRsDescNomeAbrev(String var) {		this.rsDescNomeAbrev = var; 	} 
 public boolean getNullDescNomeAbrev() {		return nullDescNomeAbrev ; 	} 
 public void setNullDescNomeAbrev(boolean var) {		this.nullDescNomeAbrev = var; 	} 
 public String getDescTelefone() {		return DescTelefone ; 	} 
 public void setDescTelefone(String var) {		this.DescTelefone = var; 	} 
 public String getRsDescTelefone() {		return rsDescTelefone ; 	} 
 public void setRsDescTelefone(String var) {		this.rsDescTelefone = var; 	} 
 public boolean getNullDescTelefone() {		return nullDescTelefone ; 	} 
 public void setNullDescTelefone(boolean var) {		this.nullDescTelefone = var; 	} 
 public String getDescEndereco() {		return DescEndereco ; 	} 
 public void setDescEndereco(String var) {		this.DescEndereco = var; 	} 
 public String getRsDescEndereco() {		return rsDescEndereco ; 	} 
 public void setRsDescEndereco(String var) {		this.rsDescEndereco = var; 	} 
 public boolean getNullDescEndereco() {		return nullDescEndereco ; 	} 
 public void setNullDescEndereco(boolean var) {		this.nullDescEndereco = var; 	} 
 public String getNumEnderec() {		return NumEnderec ; 	} 
 public void setNumEnderec(String var) {		this.NumEnderec = var; 	} 
 public String getRsNumEnderec() {		return rsNumEnderec ; 	} 
 public void setRsNumEnderec(String var) {		this.rsNumEnderec = var; 	} 
 public boolean getNullNumEnderec() {		return nullNumEnderec ; 	} 
 public void setNullNumEnderec(boolean var) {		this.nullNumEnderec = var; 	} 
 public String getDescComplemento() {		return DescComplemento ; 	} 
 public void setDescComplemento(String var) {		this.DescComplemento = var; 	} 
 public String getRsDescComplemento() {		return rsDescComplemento ; 	} 
 public void setRsDescComplemento(String var) {		this.rsDescComplemento = var; 	} 
 public boolean getNullDescComplemento() {		return nullDescComplemento ; 	} 
 public void setNullDescComplemento(boolean var) {		this.nullDescComplemento = var; 	} 
 public String getDescLogin() {		return DescLogin ; 	} 
 public void setDescLogin(String var) {		this.DescLogin = var; 	} 
 public String getRsDescLogin() {		return rsDescLogin ; 	} 
 public void setRsDescLogin(String var) {		this.rsDescLogin = var; 	} 
 public boolean getNullDescLogin() {		return nullDescLogin ; 	} 
 public void setNullDescLogin(boolean var) {		this.nullDescLogin = var; 	} 
 public String getDescSenha() {		return DescSenha ; 	} 
 public void setDescSenha(String var) {		this.DescSenha = var; 	} 
 public String getRsDescSenha() {		return rsDescSenha ; 	} 
 public void setRsDescSenha(String var) {		this.rsDescSenha = var; 	} 
 public boolean getNullDescSenha() {		return nullDescSenha ; 	} 
 public void setNullDescSenha(boolean var) {		this.nullDescSenha = var; 	} 
 public String getDescMail() {		return DescMail ; 	} 
 public void setDescMail(String var) {		this.DescMail = var; 	} 
 public String getRsDescMail() {		return rsDescMail ; 	} 
 public void setRsDescMail(String var) {		this.rsDescMail = var; 	} 
 public boolean getNullDescMail() {		return nullDescMail ; 	} 
 public void setNullDescMail(boolean var) {		this.nullDescMail = var; 	} 
 public String getFlagAtivoMaster() {		return FlagAtivoMaster ; 	} 
 public void setFlagAtivoMaster(String var) {		this.FlagAtivoMaster = var; 	} 
 public String getRsFlagAtivoMaster() {		return rsFlagAtivoMaster ; 	} 
 public void setRsFlagAtivoMaster(String var) {		this.rsFlagAtivoMaster = var; 	} 
 public boolean getNullFlagAtivoMaster() {		return nullFlagAtivoMaster ; 	} 
 public void setNullFlagAtivoMaster(boolean var) {		this.nullFlagAtivoMaster = var; 	} 
 public String getFlagAtivo() {		return FlagAtivo ; 	} 
 public void setFlagAtivo(String var) {		this.FlagAtivo = var; 	} 
 public String getRsFlagAtivo() {		return rsFlagAtivo ; 	} 
 public void setRsFlagAtivo(String var) {		this.rsFlagAtivo = var; 	} 
 public boolean getNullFlagAtivo() {		return nullFlagAtivo ; 	} 
 public void setNullFlagAtivo(boolean var) {		this.nullFlagAtivo = var; 	} 
 public Timestamp getDateLastajax() {		return DateLastajax ; 	} 
 public void setDateLastajax(Timestamp var) {		this.DateLastajax = var; 	} 
 public Timestamp getRsDateLastajax() {		return rsDateLastajax ; 	} 
 public void setRsDateLastajax(Timestamp var) {		this.rsDateLastajax = var; 	} 
 public boolean getNullDateLastajax() {		return nullDateLastajax ; 	} 
 public void setNullDateLastajax(boolean var) {		this.nullDateLastajax = var; 	} 
 public String getTxtObsHora() {		return TxtObsHora ; 	} 
 public void setTxtObsHora(String var) {		this.TxtObsHora = var; 	} 
 public String getRsTxtObsHora() {		return rsTxtObsHora ; 	} 
 public void setRsTxtObsHora(String var) {		this.rsTxtObsHora = var; 	} 
 public boolean getNullTxtObsHora() {		return nullTxtObsHora ; 	} 
 public void setNullTxtObsHora(boolean var) {		this.nullTxtObsHora = var; 	} 
 public String getDescLoja() {		return DescLoja ; 	} 
 public void setDescLoja(String var) {		this.DescLoja = var; 	} 
 public String getRsDescLoja() {		return rsDescLoja ; 	} 
 public void setRsDescLoja(String var) {		this.rsDescLoja = var; 	} 
 public boolean getNullDescLoja() {		return nullDescLoja ; 	} 
 public void setNullDescLoja(boolean var) {		this.nullDescLoja = var; 	} 
 public Cidade  getFkCodCidade() throws Exception {  Cidade oFK = new Cidade(conn);  oFK.setCodCidade(getRsCodCidade());  oFK.lista();  oFK.next();  return oFK; }public Bairros  getFkCodBairro() throws Exception {  Bairros oFK = new Bairros(conn);  oFK.setCodBairro(getRsCodBairro());  oFK.lista();  oFK.next();  return oFK; } public void posicionaRs() throws Exception{ if ( getSelect() == null ) {    try {   rsIdLoja = rs.getInt("id_loja"); } catch (Exception e) { e.printStackTrace();  }  try {   rsCodCidade = rs.getInt("cod_cidade"); } catch (Exception e) { e.printStackTrace();  }  try {   rsCodBairro = rs.getInt("cod_bairro"); } catch (Exception e) { e.printStackTrace();  }  try {   rsDescRazaoSocial = rs.getString("desc_razao_social"); } catch (Exception e) { e.printStackTrace();  }  try {   rsDescNomeAbrev = rs.getString("desc_nome_abrev"); } catch (Exception e) { e.printStackTrace();  }  try {   rsDescTelefone = rs.getString("desc_telefone"); } catch (Exception e) { e.printStackTrace();  }  try {   rsDescEndereco = rs.getString("desc_endereco"); } catch (Exception e) { e.printStackTrace();  }  try {   rsNumEnderec = rs.getString("num_enderec"); } catch (Exception e) { e.printStackTrace();  }  try {   rsDescComplemento = rs.getString("desc_complemento"); } catch (Exception e) { e.printStackTrace();  }  try {   rsDescLogin = rs.getString("desc_login"); } catch (Exception e) { e.printStackTrace();  }  try {   rsDescSenha = rs.getString("desc_senha"); } catch (Exception e) { e.printStackTrace();  }  try {   rsDescMail = rs.getString("desc_mail"); } catch (Exception e) { e.printStackTrace();  }  try {   rsFlagAtivoMaster = rs.getString("flag_ativo_master"); } catch (Exception e) { e.printStackTrace();  }  try {   rsFlagAtivo = rs.getString("flag_ativo"); } catch (Exception e) { e.printStackTrace();  }  try {   rsDateLastajax = rs.getTimestamp("date_lastajax"); } catch (Exception e) { e.printStackTrace();  }  try {   rsTxtObsHora = rs.getString("txt_obs_hora"); } catch (Exception e) { e.printStackTrace();  }  try {   rsDescLoja = rs.getString("desc_loja"); } catch (Exception e) { e.printStackTrace();  } }  }   public boolean next(){    boolean resultado;   resultado = false;    try{ limpaRs();    resultado = rs.next();    if (resultado){ posicionaRs(); }   } catch (Exception e){    e.printStackTrace(); }     return resultado; } public void limpaRs() throws Exception{  rsIdLoja=  null ;  rsCodCidade=  null ;  rsCodBairro=  null ;  rsDescRazaoSocial=  null ;  rsDescNomeAbrev=  null ;  rsDescTelefone=  null ;  rsDescEndereco=  null ;  rsNumEnderec=  null ;  rsDescComplemento=  null ;  rsDescLogin=  null ;  rsDescSenha=  null ;  rsDescMail=  null ;  rsFlagAtivoMaster=  null ;  rsFlagAtivo=  null ;  rsDateLastajax=  null ;  rsTxtObsHora=  null ;  rsDescLoja=  null ;   }  public ResultSet lista() throws Exception { sql = new StringBuffer(); if(getSelect()!=null){ sql.append(" select "+getSelect()+" "); }else {sql.append(" select *   "); } if(getJoin()!=null){ sql.append(" from "+getJoin()+" where  1=1 "); }else {sql.append(" from loja where  1=1 "); } if( getIdLoja() != null ) { sql.append(" and loja .id_loja = ? "); } if( getCodCidade() != null ) { sql.append(" and loja .cod_cidade = ? "); } if( getCodBairro() != null ) { sql.append(" and loja .cod_bairro = ? "); } if( getDescRazaoSocial() != null ) { sql.append(" and loja .desc_razao_social = ? "); } if( getDescNomeAbrev() != null ) { sql.append(" and loja .desc_nome_abrev = ? "); } if( getDescTelefone() != null ) { sql.append(" and loja .desc_telefone = ? "); } if( getDescEndereco() != null ) { sql.append(" and loja .desc_endereco = ? "); } if( getNumEnderec() != null ) { sql.append(" and loja .num_enderec = ? "); } if( getDescComplemento() != null ) { sql.append(" and loja .desc_complemento = ? "); } if( getDescLogin() != null ) { sql.append(" and loja .desc_login = ? "); } if( getDescSenha() != null ) { sql.append(" and loja .desc_senha = ? "); } if( getDescMail() != null ) { sql.append(" and loja .desc_mail = ? "); } if( getFlagAtivoMaster() != null ) { sql.append(" and loja .flag_ativo_master = ? "); } if( getFlagAtivo() != null ) { sql.append(" and loja .flag_ativo = ? "); } if( getDateLastajax() != null ) { sql.append(" and loja .date_lastajax = ? "); } if( getTxtObsHora() != null ) { sql.append(" and loja .txt_obs_hora = ? "); } if( getDescLoja() != null ) { sql.append(" and loja .desc_loja = ? "); } if(getWhere()!=null){ sql.append(" and "+ getWhere()+" "); }        if(getLastSentence()!=null){ sql.append(" "+ getLastSentence()+""); }        st = conn.prepareStatement(sql.toString());  int contparam = 1;  if( getIdLoja() != null ){ st.setInt(contparam,getIdLoja()); contparam++;}  if( getCodCidade() != null ){ st.setInt(contparam,getCodCidade()); contparam++;}  if( getCodBairro() != null ){ st.setInt(contparam,getCodBairro()); contparam++;}  if( getDescRazaoSocial() != null ){ st.setString(contparam,getDescRazaoSocial()); contparam++;}  if( getDescNomeAbrev() != null ){ st.setString(contparam,getDescNomeAbrev()); contparam++;}  if( getDescTelefone() != null ){ st.setString(contparam,getDescTelefone()); contparam++;}  if( getDescEndereco() != null ){ st.setString(contparam,getDescEndereco()); contparam++;}  if( getNumEnderec() != null ){ st.setString(contparam,getNumEnderec()); contparam++;}  if( getDescComplemento() != null ){ st.setString(contparam,getDescComplemento()); contparam++;}  if( getDescLogin() != null ){ st.setString(contparam,getDescLogin()); contparam++;}  if( getDescSenha() != null ){ st.setString(contparam,getDescSenha()); contparam++;}  if( getDescMail() != null ){ st.setString(contparam,getDescMail()); contparam++;}  if( getFlagAtivoMaster() != null ){ st.setString(contparam,getFlagAtivoMaster()); contparam++;}  if( getFlagAtivo() != null ){ st.setString(contparam,getFlagAtivo()); contparam++;}  if( getDateLastajax() != null ){ st.setTimestamp(contparam,getDateLastajax()); contparam++;}  if( getTxtObsHora() != null ){ st.setString(contparam,getTxtObsHora()); contparam++;}  if( getDescLoja() != null ){ st.setString(contparam,getDescLoja()); contparam++;}  	rs = st.executeQuery();  	return rs; }public void update() throws Exception {  if( getIdLoja() == null || getIdLoja() == 0 ) {  throw new Exception("Erro, Pk IdLoja não setada. Update de loja."); }sql = new StringBuffer();sql.append(" update loja set id_loja =  " + getIdLoja() + "  "); if( getCodCidade() != null ) { sql.append(" ,  cod_cidade = ? "); } if( getNullCodCidade()) { sql.append(" ,  cod_cidade = null "); } if( getCodBairro() != null ) { sql.append(" ,  cod_bairro = ? "); } if( getNullCodBairro()) { sql.append(" ,  cod_bairro = null "); } if( getDescRazaoSocial() != null ) { sql.append(" ,  desc_razao_social = ? "); } if( getNullDescRazaoSocial()) { sql.append(" ,  desc_razao_social = null "); } if( getDescNomeAbrev() != null ) { sql.append(" ,  desc_nome_abrev = ? "); } if( getNullDescNomeAbrev()) { sql.append(" ,  desc_nome_abrev = null "); } if( getDescTelefone() != null ) { sql.append(" ,  desc_telefone = ? "); } if( getNullDescTelefone()) { sql.append(" ,  desc_telefone = null "); } if( getDescEndereco() != null ) { sql.append(" ,  desc_endereco = ? "); } if( getNullDescEndereco()) { sql.append(" ,  desc_endereco = null "); } if( getNumEnderec() != null ) { sql.append(" ,  num_enderec = ? "); } if( getNullNumEnderec()) { sql.append(" ,  num_enderec = null "); } if( getDescComplemento() != null ) { sql.append(" ,  desc_complemento = ? "); } if( getNullDescComplemento()) { sql.append(" ,  desc_complemento = null "); } if( getDescLogin() != null ) { sql.append(" ,  desc_login = ? "); } if( getNullDescLogin()) { sql.append(" ,  desc_login = null "); } if( getDescSenha() != null ) { sql.append(" ,  desc_senha = ? "); } if( getNullDescSenha()) { sql.append(" ,  desc_senha = null "); } if( getDescMail() != null ) { sql.append(" ,  desc_mail = ? "); } if( getNullDescMail()) { sql.append(" ,  desc_mail = null "); } if( getFlagAtivoMaster() != null ) { sql.append(" ,  flag_ativo_master = ? "); } if( getNullFlagAtivoMaster()) { sql.append(" ,  flag_ativo_master = null "); } if( getFlagAtivo() != null ) { sql.append(" ,  flag_ativo = ? "); } if( getNullFlagAtivo()) { sql.append(" ,  flag_ativo = null "); } if( getDateLastajax() != null ) { sql.append(" ,  date_lastajax = ? "); } if( getNullDateLastajax()) { sql.append(" ,  date_lastajax = null "); } if( getTxtObsHora() != null ) { sql.append(" ,  txt_obs_hora = ? "); } if( getNullTxtObsHora()) { sql.append(" ,  txt_obs_hora = null "); } if( getDescLoja() != null ) { sql.append(" ,  desc_loja = ? "); } if( getNullDescLoja()) { sql.append(" ,  desc_loja = null "); } sql.append(" where id_loja =  " + getIdLoja() + "  "); if(getWhere()!=null){ sql.append(" and "+ getWhere()+" "); }        st = conn.prepareStatement(sql.toString());  int contparam = 1;  if( getCodCidade() != null ){ st.setInt(contparam,getCodCidade()); contparam++;}  if( getCodBairro() != null ){ st.setInt(contparam,getCodBairro()); contparam++;}  if( getDescRazaoSocial() != null ){ st.setString(contparam,getDescRazaoSocial()); contparam++;}  if( getDescNomeAbrev() != null ){ st.setString(contparam,getDescNomeAbrev()); contparam++;}  if( getDescTelefone() != null ){ st.setString(contparam,getDescTelefone()); contparam++;}  if( getDescEndereco() != null ){ st.setString(contparam,getDescEndereco()); contparam++;}  if( getNumEnderec() != null ){ st.setString(contparam,getNumEnderec()); contparam++;}  if( getDescComplemento() != null ){ st.setString(contparam,getDescComplemento()); contparam++;}  if( getDescLogin() != null ){ st.setString(contparam,getDescLogin()); contparam++;}  if( getDescSenha() != null ){ st.setString(contparam,getDescSenha()); contparam++;}  if( getDescMail() != null ){ st.setString(contparam,getDescMail()); contparam++;}  if( getFlagAtivoMaster() != null ){ st.setString(contparam,getFlagAtivoMaster()); contparam++;}  if( getFlagAtivo() != null ){ st.setString(contparam,getFlagAtivo()); contparam++;}  if( getDateLastajax() != null ){ st.setTimestamp(contparam,getDateLastajax()); contparam++;}  if( getTxtObsHora() != null ){ st.setString(contparam,getTxtObsHora()); contparam++;}  if( getDescLoja() != null ){ st.setString(contparam,getDescLoja()); contparam++;}  		st.executeUpdate() ;} public void delete() throws Exception { sql = new StringBuffer();sql.append(" delete from loja "); sql.append(" where id_loja =  " + getIdLoja() + "  "); st = conn.prepareStatement(sql.toString());  		st.executeUpdate() ;} public void insert() throws Exception { sql = new StringBuffer();StringBuffer values = new StringBuffer();sql.append(" insert into loja  (");values.append(" value ("); if( getCodCidade() != null ) {sql.append(" , cod_cidade ");values.append(", ? "); }  if( getCodBairro() != null ) {sql.append(" , cod_bairro ");values.append(", ? "); }  if( getDescRazaoSocial() != null ) {sql.append(" , desc_razao_social ");values.append(", ? "); }  if( getDescNomeAbrev() != null ) {sql.append(" , desc_nome_abrev ");values.append(", ? "); }  if( getDescTelefone() != null ) {sql.append(" , desc_telefone ");values.append(", ? "); }  if( getDescEndereco() != null ) {sql.append(" , desc_endereco ");values.append(", ? "); }  if( getNumEnderec() != null ) {sql.append(" , num_enderec ");values.append(", ? "); }  if( getDescComplemento() != null ) {sql.append(" , desc_complemento ");values.append(", ? "); }  if( getDescLogin() != null ) {sql.append(" , desc_login ");values.append(", ? "); }  if( getDescSenha() != null ) {sql.append(" , desc_senha ");values.append(", ? "); }  if( getDescMail() != null ) {sql.append(" , desc_mail ");values.append(", ? "); }  if( getFlagAtivoMaster() != null ) {sql.append(" , flag_ativo_master ");values.append(", ? "); }  if( getFlagAtivo() != null ) {sql.append(" , flag_ativo ");values.append(", ? "); }  if( getDateLastajax() != null ) {sql.append(" , date_lastajax ");values.append(", ? "); }  if( getTxtObsHora() != null ) {sql.append(" , txt_obs_hora ");values.append(", ? "); }  if( getDescLoja() != null ) {sql.append(" , desc_loja ");values.append(", ? "); } sql.append(" ) ");values.append(" ) ");sql = new StringBuffer(sql.toString().replaceFirst(",", ""));values = new StringBuffer(values.toString().replaceFirst(",", ""));sql.append( values.toString()); 	st = conn.prepareStatement(sql.toString(),Statement.RETURN_GENERATED_KEYS);  int contparam = 1;  if( getCodCidade() != null ){ st.setInt(contparam,getCodCidade()); contparam++;  }  if( getCodBairro() != null ){ st.setInt(contparam,getCodBairro()); contparam++;  }  if( getDescRazaoSocial() != null ){ st.setString(contparam,getDescRazaoSocial()); contparam++;  }  if( getDescNomeAbrev() != null ){ st.setString(contparam,getDescNomeAbrev()); contparam++;  }  if( getDescTelefone() != null ){ st.setString(contparam,getDescTelefone()); contparam++;  }  if( getDescEndereco() != null ){ st.setString(contparam,getDescEndereco()); contparam++;  }  if( getNumEnderec() != null ){ st.setString(contparam,getNumEnderec()); contparam++;  }  if( getDescComplemento() != null ){ st.setString(contparam,getDescComplemento()); contparam++;  }  if( getDescLogin() != null ){ st.setString(contparam,getDescLogin()); contparam++;  }  if( getDescSenha() != null ){ st.setString(contparam,getDescSenha()); contparam++;  }  if( getDescMail() != null ){ st.setString(contparam,getDescMail()); contparam++;  }  if( getFlagAtivoMaster() != null ){ st.setString(contparam,getFlagAtivoMaster()); contparam++;  }  if( getFlagAtivo() != null ){ st.setString(contparam,getFlagAtivo()); contparam++;  }  if( getDateLastajax() != null ){ st.setTimestamp(contparam,getDateLastajax()); contparam++;  }  if( getTxtObsHora() != null ){ st.setString(contparam,getTxtObsHora()); contparam++;  }  if( getDescLoja() != null ){ st.setString(contparam,getDescLoja()); contparam++;  }  		if (st.executeUpdate() == 1) {  	rs = st.getGeneratedKeys();  if (rs.next()){ setIdLoja(rs.getInt(1)); } } else { throw new Exception("Erro, contate suporte. Inserção de loja.");}}
 
 }