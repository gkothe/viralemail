package com.cruds; 
import java.sql.Connection; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import com.funcs.Utilitario; 
import java.util.Date; 
import java.sql.Timestamp; 
import com.mysql.jdbc.Statement; 

public class SysParametros { 

private PreparedStatement st; 
private StringBuffer sql; 
private ResultSet rs; 
private Connection conn; 
private String Where; 
private String Join; 
private String LastSentence; 
private String Select; 
public SysParametros(Connection conn) { super();this.conn = conn;} 
 private Integer IdParametro; 
 private Integer rsIdParametro; 
 private String FlagManutencao; 
 private String rsFlagManutencao; 
 private  boolean  nullFlagManutencao = false; 
 private String DescKey; 
 private String rsDescKey; 
 private  boolean  nullDescKey = false; 
 private Long FaceAppId; 
 private Long rsFaceAppId; 
 private  boolean  nullFaceAppId = false; 
 private String FaceAppSecretkey; 
 private String rsFaceAppSecretkey; 
 private  boolean  nullFaceAppSecretkey = false; 
 private String FaceAppToken; 
 private String rsFaceAppToken; 
 private  boolean  nullFaceAppToken = false; 
 private String FaceRedirectUri; 
 private String rsFaceRedirectUri; 
 private  boolean  nullFaceRedirectUri = false; 
 private String UrlSystem; 
 private String rsUrlSystem; 
 private  boolean  nullUrlSystem = false; 
 private String OnesignalKey; 
 private String rsOnesignalKey; 
 private  boolean  nullOnesignalKey = false; 
 private String OnesignalUrl; 
 private String rsOnesignalUrl; 
 private  boolean  nullOnesignalUrl = false; 
 private String OnesignalAppid; 
 private String rsOnesignalAppid; 
 private  boolean  nullOnesignalAppid = false; 
 private String DescWebappfolder; 
 private String rsDescWebappfolder; 
 private  boolean  nullDescWebappfolder = false; 
 private String FaceRedirectUriWebapp; 
 private String rsFaceRedirectUriWebapp; 
 private  boolean  nullFaceRedirectUriWebapp = false; 
 private String UrlWebsocket; 
 private String rsUrlWebsocket; 
 private  boolean  nullUrlWebsocket = false; 
 private String SysHostNameSmtp; 
 private String rsSysHostNameSmtp; 
 private  boolean  nullSysHostNameSmtp = false; 
 private Integer SysSmtpPort; 
 private Integer rsSysSmtpPort; 
 private  boolean  nullSysSmtpPort = false; 
 private String SysEmail; 
 private String rsSysEmail; 
 private  boolean  nullSysEmail = false; 
 private String SysSenha; 
 private String rsSysSenha; 
 private  boolean  nullSysSenha = false; 
 private String SysFromemail; 
 private String rsSysFromemail; 
 private  boolean  nullSysFromemail = false; 
 private String SysFromdesc; 
 private String rsSysFromdesc; 
 private  boolean  nullSysFromdesc = false; 
 private String SysTls; 
 private String rsSysTls; 
 private  boolean  nullSysTls = false; 
public PreparedStatement getSt() {		return st; 	} 
 public void setSt(PreparedStatement st) {		this.st = st; 	} 
 public StringBuffer getSql() {		return sql; 	} 
 public void setSql(StringBuffer sql) {		this.sql = sql; 	} 
 public ResultSet getRs() {		return rs; 	} 
 public void setRs(ResultSet rs) {		this.rs = rs; 	} 
 public Connection getConn() {		return conn; 	} 
 public void setConn(Connection conn) {		this.conn = conn; 	}
 public String getWhere() { return this.Where; }public void setWhere(String where) { this.Where = where; }public String getJoin() {return this.Join;}public void setJoin(String join) {this.Join = join;}public String getLastSentence() {return this.LastSentence;}public void setLastSentence(String last) {this.LastSentence = last;}public String getSelect() { return this.Select; }public void setSelect(String select) { this.Select = select; }public Integer getIdParametro() {		return IdParametro ; 	} 
 public void setIdParametro(Integer var) {		this.IdParametro = var; 	} 
 public Integer getRsIdParametro() {		return rsIdParametro ; 	} 
 public void setRsIdParametro(Integer var) {		this.rsIdParametro = var; 	} 
 public String getFlagManutencao() {		return FlagManutencao ; 	} 
 public void setFlagManutencao(String var) {		this.FlagManutencao = var; 	} 
 public String getRsFlagManutencao() {		return rsFlagManutencao ; 	} 
 public void setRsFlagManutencao(String var) {		this.rsFlagManutencao = var; 	} 
 public boolean getNullFlagManutencao() {		return nullFlagManutencao ; 	} 
 public void setNullFlagManutencao(boolean var) {		this.nullFlagManutencao = var; 	} 
 public String getDescKey() {		return DescKey ; 	} 
 public void setDescKey(String var) {		this.DescKey = var; 	} 
 public String getRsDescKey() {		return rsDescKey ; 	} 
 public void setRsDescKey(String var) {		this.rsDescKey = var; 	} 
 public boolean getNullDescKey() {		return nullDescKey ; 	} 
 public void setNullDescKey(boolean var) {		this.nullDescKey = var; 	} 
 public Long getFaceAppId() {		return FaceAppId ; 	} 
 public void setFaceAppId(Long var) {		this.FaceAppId = var; 	} 
 public Long getRsFaceAppId() {		return rsFaceAppId ; 	} 
 public void setRsFaceAppId(Long var) {		this.rsFaceAppId = var; 	} 
 public boolean getNullFaceAppId() {		return nullFaceAppId ; 	} 
 public void setNullFaceAppId(boolean var) {		this.nullFaceAppId = var; 	} 
 public String getFaceAppSecretkey() {		return FaceAppSecretkey ; 	} 
 public void setFaceAppSecretkey(String var) {		this.FaceAppSecretkey = var; 	} 
 public String getRsFaceAppSecretkey() {		return rsFaceAppSecretkey ; 	} 
 public void setRsFaceAppSecretkey(String var) {		this.rsFaceAppSecretkey = var; 	} 
 public boolean getNullFaceAppSecretkey() {		return nullFaceAppSecretkey ; 	} 
 public void setNullFaceAppSecretkey(boolean var) {		this.nullFaceAppSecretkey = var; 	} 
 public String getFaceAppToken() {		return FaceAppToken ; 	} 
 public void setFaceAppToken(String var) {		this.FaceAppToken = var; 	} 
 public String getRsFaceAppToken() {		return rsFaceAppToken ; 	} 
 public void setRsFaceAppToken(String var) {		this.rsFaceAppToken = var; 	} 
 public boolean getNullFaceAppToken() {		return nullFaceAppToken ; 	} 
 public void setNullFaceAppToken(boolean var) {		this.nullFaceAppToken = var; 	} 
 public String getFaceRedirectUri() {		return FaceRedirectUri ; 	} 
 public void setFaceRedirectUri(String var) {		this.FaceRedirectUri = var; 	} 
 public String getRsFaceRedirectUri() {		return rsFaceRedirectUri ; 	} 
 public void setRsFaceRedirectUri(String var) {		this.rsFaceRedirectUri = var; 	} 
 public boolean getNullFaceRedirectUri() {		return nullFaceRedirectUri ; 	} 
 public void setNullFaceRedirectUri(boolean var) {		this.nullFaceRedirectUri = var; 	} 
 public String getUrlSystem() {		return UrlSystem ; 	} 
 public void setUrlSystem(String var) {		this.UrlSystem = var; 	} 
 public String getRsUrlSystem() {		return rsUrlSystem ; 	} 
 public void setRsUrlSystem(String var) {		this.rsUrlSystem = var; 	} 
 public boolean getNullUrlSystem() {		return nullUrlSystem ; 	} 
 public void setNullUrlSystem(boolean var) {		this.nullUrlSystem = var; 	} 
 public String getOnesignalKey() {		return OnesignalKey ; 	} 
 public void setOnesignalKey(String var) {		this.OnesignalKey = var; 	} 
 public String getRsOnesignalKey() {		return rsOnesignalKey ; 	} 
 public void setRsOnesignalKey(String var) {		this.rsOnesignalKey = var; 	} 
 public boolean getNullOnesignalKey() {		return nullOnesignalKey ; 	} 
 public void setNullOnesignalKey(boolean var) {		this.nullOnesignalKey = var; 	} 
 public String getOnesignalUrl() {		return OnesignalUrl ; 	} 
 public void setOnesignalUrl(String var) {		this.OnesignalUrl = var; 	} 
 public String getRsOnesignalUrl() {		return rsOnesignalUrl ; 	} 
 public void setRsOnesignalUrl(String var) {		this.rsOnesignalUrl = var; 	} 
 public boolean getNullOnesignalUrl() {		return nullOnesignalUrl ; 	} 
 public void setNullOnesignalUrl(boolean var) {		this.nullOnesignalUrl = var; 	} 
 public String getOnesignalAppid() {		return OnesignalAppid ; 	} 
 public void setOnesignalAppid(String var) {		this.OnesignalAppid = var; 	} 
 public String getRsOnesignalAppid() {		return rsOnesignalAppid ; 	} 
 public void setRsOnesignalAppid(String var) {		this.rsOnesignalAppid = var; 	} 
 public boolean getNullOnesignalAppid() {		return nullOnesignalAppid ; 	} 
 public void setNullOnesignalAppid(boolean var) {		this.nullOnesignalAppid = var; 	} 
 public String getDescWebappfolder() {		return DescWebappfolder ; 	} 
 public void setDescWebappfolder(String var) {		this.DescWebappfolder = var; 	} 
 public String getRsDescWebappfolder() {		return rsDescWebappfolder ; 	} 
 public void setRsDescWebappfolder(String var) {		this.rsDescWebappfolder = var; 	} 
 public boolean getNullDescWebappfolder() {		return nullDescWebappfolder ; 	} 
 public void setNullDescWebappfolder(boolean var) {		this.nullDescWebappfolder = var; 	} 
 public String getFaceRedirectUriWebapp() {		return FaceRedirectUriWebapp ; 	} 
 public void setFaceRedirectUriWebapp(String var) {		this.FaceRedirectUriWebapp = var; 	} 
 public String getRsFaceRedirectUriWebapp() {		return rsFaceRedirectUriWebapp ; 	} 
 public void setRsFaceRedirectUriWebapp(String var) {		this.rsFaceRedirectUriWebapp = var; 	} 
 public boolean getNullFaceRedirectUriWebapp() {		return nullFaceRedirectUriWebapp ; 	} 
 public void setNullFaceRedirectUriWebapp(boolean var) {		this.nullFaceRedirectUriWebapp = var; 	} 
 public String getUrlWebsocket() {		return UrlWebsocket ; 	} 
 public void setUrlWebsocket(String var) {		this.UrlWebsocket = var; 	} 
 public String getRsUrlWebsocket() {		return rsUrlWebsocket ; 	} 
 public void setRsUrlWebsocket(String var) {		this.rsUrlWebsocket = var; 	} 
 public boolean getNullUrlWebsocket() {		return nullUrlWebsocket ; 	} 
 public void setNullUrlWebsocket(boolean var) {		this.nullUrlWebsocket = var; 	} 
 public String getSysHostNameSmtp() {		return SysHostNameSmtp ; 	} 
 public void setSysHostNameSmtp(String var) {		this.SysHostNameSmtp = var; 	} 
 public String getRsSysHostNameSmtp() {		return rsSysHostNameSmtp ; 	} 
 public void setRsSysHostNameSmtp(String var) {		this.rsSysHostNameSmtp = var; 	} 
 public boolean getNullSysHostNameSmtp() {		return nullSysHostNameSmtp ; 	} 
 public void setNullSysHostNameSmtp(boolean var) {		this.nullSysHostNameSmtp = var; 	} 
 public Integer getSysSmtpPort() {		return SysSmtpPort ; 	} 
 public void setSysSmtpPort(Integer var) {		this.SysSmtpPort = var; 	} 
 public Integer getRsSysSmtpPort() {		return rsSysSmtpPort ; 	} 
 public void setRsSysSmtpPort(Integer var) {		this.rsSysSmtpPort = var; 	} 
 public boolean getNullSysSmtpPort() {		return nullSysSmtpPort ; 	} 
 public void setNullSysSmtpPort(boolean var) {		this.nullSysSmtpPort = var; 	} 
 public String getSysEmail() {		return SysEmail ; 	} 
 public void setSysEmail(String var) {		this.SysEmail = var; 	} 
 public String getRsSysEmail() {		return rsSysEmail ; 	} 
 public void setRsSysEmail(String var) {		this.rsSysEmail = var; 	} 
 public boolean getNullSysEmail() {		return nullSysEmail ; 	} 
 public void setNullSysEmail(boolean var) {		this.nullSysEmail = var; 	} 
 public String getSysSenha() {		return SysSenha ; 	} 
 public void setSysSenha(String var) {		this.SysSenha = var; 	} 
 public String getRsSysSenha() {		return rsSysSenha ; 	} 
 public void setRsSysSenha(String var) {		this.rsSysSenha = var; 	} 
 public boolean getNullSysSenha() {		return nullSysSenha ; 	} 
 public void setNullSysSenha(boolean var) {		this.nullSysSenha = var; 	} 
 public String getSysFromemail() {		return SysFromemail ; 	} 
 public void setSysFromemail(String var) {		this.SysFromemail = var; 	} 
 public String getRsSysFromemail() {		return rsSysFromemail ; 	} 
 public void setRsSysFromemail(String var) {		this.rsSysFromemail = var; 	} 
 public boolean getNullSysFromemail() {		return nullSysFromemail ; 	} 
 public void setNullSysFromemail(boolean var) {		this.nullSysFromemail = var; 	} 
 public String getSysFromdesc() {		return SysFromdesc ; 	} 
 public void setSysFromdesc(String var) {		this.SysFromdesc = var; 	} 
 public String getRsSysFromdesc() {		return rsSysFromdesc ; 	} 
 public void setRsSysFromdesc(String var) {		this.rsSysFromdesc = var; 	} 
 public boolean getNullSysFromdesc() {		return nullSysFromdesc ; 	} 
 public void setNullSysFromdesc(boolean var) {		this.nullSysFromdesc = var; 	} 
 public String getSysTls() {		return SysTls ; 	} 
 public void setSysTls(String var) {		this.SysTls = var; 	} 
 public String getRsSysTls() {		return rsSysTls ; 	} 
 public void setRsSysTls(String var) {		this.rsSysTls = var; 	} 
 public boolean getNullSysTls() {		return nullSysTls ; 	} 
 public void setNullSysTls(boolean var) {		this.nullSysTls = var; 	} 
  public void posicionaRs() throws Exception{ if ( getSelect() == null ) {    try {   rsIdParametro = rs.getInt("id_parametro"); } catch (Exception e) { e.printStackTrace();  }  try {   rsFlagManutencao = rs.getString("flag_manutencao"); } catch (Exception e) { e.printStackTrace();  }  try {   rsDescKey = rs.getString("desc_key"); } catch (Exception e) { e.printStackTrace();  }  try {   rsFaceAppId = rs.getLong("face_app_id"); } catch (Exception e) { e.printStackTrace();  }  try {   rsFaceAppSecretkey = rs.getString("face_app_secretkey"); } catch (Exception e) { e.printStackTrace();  }  try {   rsFaceAppToken = rs.getString("face_app_token"); } catch (Exception e) { e.printStackTrace();  }  try {   rsFaceRedirectUri = rs.getString("face_redirect_uri"); } catch (Exception e) { e.printStackTrace();  }  try {   rsUrlSystem = rs.getString("url_system"); } catch (Exception e) { e.printStackTrace();  }  try {   rsOnesignalKey = rs.getString("onesignal_key"); } catch (Exception e) { e.printStackTrace();  }  try {   rsOnesignalUrl = rs.getString("onesignal_url"); } catch (Exception e) { e.printStackTrace();  }  try {   rsOnesignalAppid = rs.getString("onesignal_appid"); } catch (Exception e) { e.printStackTrace();  }  try {   rsDescWebappfolder = rs.getString("desc_webappfolder"); } catch (Exception e) { e.printStackTrace();  }  try {   rsFaceRedirectUriWebapp = rs.getString("face_redirect_uri_webapp"); } catch (Exception e) { e.printStackTrace();  }  try {   rsUrlWebsocket = rs.getString("url_websocket"); } catch (Exception e) { e.printStackTrace();  }  try {   rsSysHostNameSmtp = rs.getString("sys_host_name_smtp"); } catch (Exception e) { e.printStackTrace();  }  try {   rsSysSmtpPort = rs.getInt("sys_smtp_port"); } catch (Exception e) { e.printStackTrace();  }  try {   rsSysEmail = rs.getString("sys_email"); } catch (Exception e) { e.printStackTrace();  }  try {   rsSysSenha = rs.getString("sys_senha"); } catch (Exception e) { e.printStackTrace();  }  try {   rsSysFromemail = rs.getString("sys_fromemail"); } catch (Exception e) { e.printStackTrace();  }  try {   rsSysFromdesc = rs.getString("sys_fromdesc"); } catch (Exception e) { e.printStackTrace();  }  try {   rsSysTls = rs.getString("sys_tls"); } catch (Exception e) { e.printStackTrace();  } }  }   public boolean next(){    boolean resultado;   resultado = false;    try{ limpaRs();    resultado = rs.next();    if (resultado){ posicionaRs(); }   } catch (Exception e){    e.printStackTrace(); }     return resultado; } public void limpaRs() throws Exception{  rsIdParametro=  null ;  rsFlagManutencao=  null ;  rsDescKey=  null ;  rsFaceAppId=  null ;  rsFaceAppSecretkey=  null ;  rsFaceAppToken=  null ;  rsFaceRedirectUri=  null ;  rsUrlSystem=  null ;  rsOnesignalKey=  null ;  rsOnesignalUrl=  null ;  rsOnesignalAppid=  null ;  rsDescWebappfolder=  null ;  rsFaceRedirectUriWebapp=  null ;  rsUrlWebsocket=  null ;  rsSysHostNameSmtp=  null ;  rsSysSmtpPort=  null ;  rsSysEmail=  null ;  rsSysSenha=  null ;  rsSysFromemail=  null ;  rsSysFromdesc=  null ;  rsSysTls=  null ;   }  public ResultSet lista() throws Exception { sql = new StringBuffer(); if(getSelect()!=null){ sql.append(" select "+getSelect()+" "); }else {sql.append(" select *   "); } if(getJoin()!=null){ sql.append(" from "+getJoin()+" where  1=1 "); }else {sql.append(" from sys_parametros where  1=1 "); } if( getIdParametro() != null ) { sql.append(" and sys_parametros .id_parametro = ? "); } if( getFlagManutencao() != null ) { sql.append(" and sys_parametros .flag_manutencao = ? "); } if( getDescKey() != null ) { sql.append(" and sys_parametros .desc_key = ? "); } if( getFaceAppId() != null ) { sql.append(" and sys_parametros .face_app_id = ? "); } if( getFaceAppSecretkey() != null ) { sql.append(" and sys_parametros .face_app_secretkey = ? "); } if( getFaceAppToken() != null ) { sql.append(" and sys_parametros .face_app_token = ? "); } if( getFaceRedirectUri() != null ) { sql.append(" and sys_parametros .face_redirect_uri = ? "); } if( getUrlSystem() != null ) { sql.append(" and sys_parametros .url_system = ? "); } if( getOnesignalKey() != null ) { sql.append(" and sys_parametros .onesignal_key = ? "); } if( getOnesignalUrl() != null ) { sql.append(" and sys_parametros .onesignal_url = ? "); } if( getOnesignalAppid() != null ) { sql.append(" and sys_parametros .onesignal_appid = ? "); } if( getDescWebappfolder() != null ) { sql.append(" and sys_parametros .desc_webappfolder = ? "); } if( getFaceRedirectUriWebapp() != null ) { sql.append(" and sys_parametros .face_redirect_uri_webapp = ? "); } if( getUrlWebsocket() != null ) { sql.append(" and sys_parametros .url_websocket = ? "); } if( getSysHostNameSmtp() != null ) { sql.append(" and sys_parametros .sys_host_name_smtp = ? "); } if( getSysSmtpPort() != null ) { sql.append(" and sys_parametros .sys_smtp_port = ? "); } if( getSysEmail() != null ) { sql.append(" and sys_parametros .sys_email = ? "); } if( getSysSenha() != null ) { sql.append(" and sys_parametros .sys_senha = ? "); } if( getSysFromemail() != null ) { sql.append(" and sys_parametros .sys_fromemail = ? "); } if( getSysFromdesc() != null ) { sql.append(" and sys_parametros .sys_fromdesc = ? "); } if( getSysTls() != null ) { sql.append(" and sys_parametros .sys_tls = ? "); } if(getWhere()!=null){ sql.append(" and "+ getWhere()+" "); }        if(getLastSentence()!=null){ sql.append(" "+ getLastSentence()+""); }        st = conn.prepareStatement(sql.toString());  int contparam = 1;  if( getIdParametro() != null ){ st.setInt(contparam,getIdParametro()); contparam++;}  if( getFlagManutencao() != null ){ st.setString(contparam,getFlagManutencao()); contparam++;}  if( getDescKey() != null ){ st.setString(contparam,getDescKey()); contparam++;}  if( getFaceAppId() != null ){ st.setLong(contparam,getFaceAppId()); contparam++;}  if( getFaceAppSecretkey() != null ){ st.setString(contparam,getFaceAppSecretkey()); contparam++;}  if( getFaceAppToken() != null ){ st.setString(contparam,getFaceAppToken()); contparam++;}  if( getFaceRedirectUri() != null ){ st.setString(contparam,getFaceRedirectUri()); contparam++;}  if( getUrlSystem() != null ){ st.setString(contparam,getUrlSystem()); contparam++;}  if( getOnesignalKey() != null ){ st.setString(contparam,getOnesignalKey()); contparam++;}  if( getOnesignalUrl() != null ){ st.setString(contparam,getOnesignalUrl()); contparam++;}  if( getOnesignalAppid() != null ){ st.setString(contparam,getOnesignalAppid()); contparam++;}  if( getDescWebappfolder() != null ){ st.setString(contparam,getDescWebappfolder()); contparam++;}  if( getFaceRedirectUriWebapp() != null ){ st.setString(contparam,getFaceRedirectUriWebapp()); contparam++;}  if( getUrlWebsocket() != null ){ st.setString(contparam,getUrlWebsocket()); contparam++;}  if( getSysHostNameSmtp() != null ){ st.setString(contparam,getSysHostNameSmtp()); contparam++;}  if( getSysSmtpPort() != null ){ st.setInt(contparam,getSysSmtpPort()); contparam++;}  if( getSysEmail() != null ){ st.setString(contparam,getSysEmail()); contparam++;}  if( getSysSenha() != null ){ st.setString(contparam,getSysSenha()); contparam++;}  if( getSysFromemail() != null ){ st.setString(contparam,getSysFromemail()); contparam++;}  if( getSysFromdesc() != null ){ st.setString(contparam,getSysFromdesc()); contparam++;}  if( getSysTls() != null ){ st.setString(contparam,getSysTls()); contparam++;}  	rs = st.executeQuery();  	return rs; }public void update() throws Exception {  if( getIdParametro() == null || getIdParametro() == 0 ) {  throw new Exception("Erro, Pk IdParametro não setada. Update de sys_parametros."); }sql = new StringBuffer();sql.append(" update sys_parametros set id_parametro =  " + getIdParametro() + "  "); if( getFlagManutencao() != null ) { sql.append(" ,  flag_manutencao = ? "); } if( getNullFlagManutencao()) { sql.append(" ,  flag_manutencao = null "); } if( getDescKey() != null ) { sql.append(" ,  desc_key = ? "); } if( getNullDescKey()) { sql.append(" ,  desc_key = null "); } if( getFaceAppId() != null ) { sql.append(" ,  face_app_id = ? "); } if( getNullFaceAppId()) { sql.append(" ,  face_app_id = null "); } if( getFaceAppSecretkey() != null ) { sql.append(" ,  face_app_secretkey = ? "); } if( getNullFaceAppSecretkey()) { sql.append(" ,  face_app_secretkey = null "); } if( getFaceAppToken() != null ) { sql.append(" ,  face_app_token = ? "); } if( getNullFaceAppToken()) { sql.append(" ,  face_app_token = null "); } if( getFaceRedirectUri() != null ) { sql.append(" ,  face_redirect_uri = ? "); } if( getNullFaceRedirectUri()) { sql.append(" ,  face_redirect_uri = null "); } if( getUrlSystem() != null ) { sql.append(" ,  url_system = ? "); } if( getNullUrlSystem()) { sql.append(" ,  url_system = null "); } if( getOnesignalKey() != null ) { sql.append(" ,  onesignal_key = ? "); } if( getNullOnesignalKey()) { sql.append(" ,  onesignal_key = null "); } if( getOnesignalUrl() != null ) { sql.append(" ,  onesignal_url = ? "); } if( getNullOnesignalUrl()) { sql.append(" ,  onesignal_url = null "); } if( getOnesignalAppid() != null ) { sql.append(" ,  onesignal_appid = ? "); } if( getNullOnesignalAppid()) { sql.append(" ,  onesignal_appid = null "); } if( getDescWebappfolder() != null ) { sql.append(" ,  desc_webappfolder = ? "); } if( getNullDescWebappfolder()) { sql.append(" ,  desc_webappfolder = null "); } if( getFaceRedirectUriWebapp() != null ) { sql.append(" ,  face_redirect_uri_webapp = ? "); } if( getNullFaceRedirectUriWebapp()) { sql.append(" ,  face_redirect_uri_webapp = null "); } if( getUrlWebsocket() != null ) { sql.append(" ,  url_websocket = ? "); } if( getNullUrlWebsocket()) { sql.append(" ,  url_websocket = null "); } if( getSysHostNameSmtp() != null ) { sql.append(" ,  sys_host_name_smtp = ? "); } if( getNullSysHostNameSmtp()) { sql.append(" ,  sys_host_name_smtp = null "); } if( getSysSmtpPort() != null ) { sql.append(" ,  sys_smtp_port = ? "); } if( getNullSysSmtpPort()) { sql.append(" ,  sys_smtp_port = null "); } if( getSysEmail() != null ) { sql.append(" ,  sys_email = ? "); } if( getNullSysEmail()) { sql.append(" ,  sys_email = null "); } if( getSysSenha() != null ) { sql.append(" ,  sys_senha = ? "); } if( getNullSysSenha()) { sql.append(" ,  sys_senha = null "); } if( getSysFromemail() != null ) { sql.append(" ,  sys_fromemail = ? "); } if( getNullSysFromemail()) { sql.append(" ,  sys_fromemail = null "); } if( getSysFromdesc() != null ) { sql.append(" ,  sys_fromdesc = ? "); } if( getNullSysFromdesc()) { sql.append(" ,  sys_fromdesc = null "); } if( getSysTls() != null ) { sql.append(" ,  sys_tls = ? "); } if( getNullSysTls()) { sql.append(" ,  sys_tls = null "); } sql.append(" where id_parametro =  " + getIdParametro() + "  "); if(getWhere()!=null){ sql.append(" and "+ getWhere()+" "); }        st = conn.prepareStatement(sql.toString());  int contparam = 1;  if( getFlagManutencao() != null ){ st.setString(contparam,getFlagManutencao()); contparam++;}  if( getDescKey() != null ){ st.setString(contparam,getDescKey()); contparam++;}  if( getFaceAppId() != null ){ st.setLong(contparam,getFaceAppId()); contparam++;}  if( getFaceAppSecretkey() != null ){ st.setString(contparam,getFaceAppSecretkey()); contparam++;}  if( getFaceAppToken() != null ){ st.setString(contparam,getFaceAppToken()); contparam++;}  if( getFaceRedirectUri() != null ){ st.setString(contparam,getFaceRedirectUri()); contparam++;}  if( getUrlSystem() != null ){ st.setString(contparam,getUrlSystem()); contparam++;}  if( getOnesignalKey() != null ){ st.setString(contparam,getOnesignalKey()); contparam++;}  if( getOnesignalUrl() != null ){ st.setString(contparam,getOnesignalUrl()); contparam++;}  if( getOnesignalAppid() != null ){ st.setString(contparam,getOnesignalAppid()); contparam++;}  if( getDescWebappfolder() != null ){ st.setString(contparam,getDescWebappfolder()); contparam++;}  if( getFaceRedirectUriWebapp() != null ){ st.setString(contparam,getFaceRedirectUriWebapp()); contparam++;}  if( getUrlWebsocket() != null ){ st.setString(contparam,getUrlWebsocket()); contparam++;}  if( getSysHostNameSmtp() != null ){ st.setString(contparam,getSysHostNameSmtp()); contparam++;}  if( getSysSmtpPort() != null ){ st.setInt(contparam,getSysSmtpPort()); contparam++;}  if( getSysEmail() != null ){ st.setString(contparam,getSysEmail()); contparam++;}  if( getSysSenha() != null ){ st.setString(contparam,getSysSenha()); contparam++;}  if( getSysFromemail() != null ){ st.setString(contparam,getSysFromemail()); contparam++;}  if( getSysFromdesc() != null ){ st.setString(contparam,getSysFromdesc()); contparam++;}  if( getSysTls() != null ){ st.setString(contparam,getSysTls()); contparam++;}  		st.executeUpdate() ;} public void delete() throws Exception { sql = new StringBuffer();sql.append(" delete from sys_parametros "); sql.append(" where id_parametro =  " + getIdParametro() + "  "); st = conn.prepareStatement(sql.toString());  		st.executeUpdate() ;} public void insert() throws Exception { sql = new StringBuffer();StringBuffer values = new StringBuffer();sql.append(" insert into sys_parametros  (id_parametro " );values.append(" value (? "); if( getFlagManutencao() != null ) {sql.append(" , flag_manutencao ");values.append(", ? "); }  if( getDescKey() != null ) {sql.append(" , desc_key ");values.append(", ? "); }  if( getFaceAppId() != null ) {sql.append(" , face_app_id ");values.append(", ? "); }  if( getFaceAppSecretkey() != null ) {sql.append(" , face_app_secretkey ");values.append(", ? "); }  if( getFaceAppToken() != null ) {sql.append(" , face_app_token ");values.append(", ? "); }  if( getFaceRedirectUri() != null ) {sql.append(" , face_redirect_uri ");values.append(", ? "); }  if( getUrlSystem() != null ) {sql.append(" , url_system ");values.append(", ? "); }  if( getOnesignalKey() != null ) {sql.append(" , onesignal_key ");values.append(", ? "); }  if( getOnesignalUrl() != null ) {sql.append(" , onesignal_url ");values.append(", ? "); }  if( getOnesignalAppid() != null ) {sql.append(" , onesignal_appid ");values.append(", ? "); }  if( getDescWebappfolder() != null ) {sql.append(" , desc_webappfolder ");values.append(", ? "); }  if( getFaceRedirectUriWebapp() != null ) {sql.append(" , face_redirect_uri_webapp ");values.append(", ? "); }  if( getUrlWebsocket() != null ) {sql.append(" , url_websocket ");values.append(", ? "); }  if( getSysHostNameSmtp() != null ) {sql.append(" , sys_host_name_smtp ");values.append(", ? "); }  if( getSysSmtpPort() != null ) {sql.append(" , sys_smtp_port ");values.append(", ? "); }  if( getSysEmail() != null ) {sql.append(" , sys_email ");values.append(", ? "); }  if( getSysSenha() != null ) {sql.append(" , sys_senha ");values.append(", ? "); }  if( getSysFromemail() != null ) {sql.append(" , sys_fromemail ");values.append(", ? "); }  if( getSysFromdesc() != null ) {sql.append(" , sys_fromdesc ");values.append(", ? "); }  if( getSysTls() != null ) {sql.append(" , sys_tls ");values.append(", ? "); } sql.append(" ) ");values.append(" ) ");sql.append( values.toString()); 	st = conn.prepareStatement(sql.toString(),Statement.RETURN_GENERATED_KEYS);  int contparam = 1;   int id = 	 Utilitario.retornaIdinsert 	 ("sys_parametros", "id_parametro", conn); st.setInt(contparam, id); contparam++;  if( getFlagManutencao() != null ){ st.setString(contparam,getFlagManutencao()); contparam++;  }  if( getDescKey() != null ){ st.setString(contparam,getDescKey()); contparam++;  }  if( getFaceAppId() != null ){ st.setLong(contparam,getFaceAppId()); contparam++;  }  if( getFaceAppSecretkey() != null ){ st.setString(contparam,getFaceAppSecretkey()); contparam++;  }  if( getFaceAppToken() != null ){ st.setString(contparam,getFaceAppToken()); contparam++;  }  if( getFaceRedirectUri() != null ){ st.setString(contparam,getFaceRedirectUri()); contparam++;  }  if( getUrlSystem() != null ){ st.setString(contparam,getUrlSystem()); contparam++;  }  if( getOnesignalKey() != null ){ st.setString(contparam,getOnesignalKey()); contparam++;  }  if( getOnesignalUrl() != null ){ st.setString(contparam,getOnesignalUrl()); contparam++;  }  if( getOnesignalAppid() != null ){ st.setString(contparam,getOnesignalAppid()); contparam++;  }  if( getDescWebappfolder() != null ){ st.setString(contparam,getDescWebappfolder()); contparam++;  }  if( getFaceRedirectUriWebapp() != null ){ st.setString(contparam,getFaceRedirectUriWebapp()); contparam++;  }  if( getUrlWebsocket() != null ){ st.setString(contparam,getUrlWebsocket()); contparam++;  }  if( getSysHostNameSmtp() != null ){ st.setString(contparam,getSysHostNameSmtp()); contparam++;  }  if( getSysSmtpPort() != null ){ st.setInt(contparam,getSysSmtpPort()); contparam++;  }  if( getSysEmail() != null ){ st.setString(contparam,getSysEmail()); contparam++;  }  if( getSysSenha() != null ){ st.setString(contparam,getSysSenha()); contparam++;  }  if( getSysFromemail() != null ){ st.setString(contparam,getSysFromemail()); contparam++;  }  if( getSysFromdesc() != null ){ st.setString(contparam,getSysFromdesc()); contparam++;  }  if( getSysTls() != null ){ st.setString(contparam,getSysTls()); contparam++;  }  		if (st.executeUpdate() == 1) { setIdParametro(id);} else { throw new Exception("Erro, contate suporte. Inserção de sys_parametros.");}}
 
 }