package com.gerador; 
import java.sql.Connection; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import com.funcs.Utilitario; 
import java.util.Date; 
import java.sql.Timestamp; 

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
 private Integer IdParam; 
 private Integer rsIdParam; 
 private Long IdUsuarioAdmin; 
 private Long rsIdUsuarioAdmin; 
 private  boolean  nullIdUsuarioAdmin = false; 
 private String FlagManutencao; 
 private String rsFlagManutencao; 
 private  boolean  nullFlagManutencao = false; 
 private String DescKey; 
 private String rsDescKey; 
 private  boolean  nullDescKey = false; 
 private Long SegsTesteAjax; 
 private Long rsSegsTesteAjax; 
 private  boolean  nullSegsTesteAjax = false; 
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
 private Long IdVisitante; 
 private Long rsIdVisitante; 
 private  boolean  nullIdVisitante = false; 
 private Integer PedHorasokey; 
 private Integer rsPedHorasokey; 
 private  boolean  nullPedHorasokey = false; 
 private Integer NumTempomaxcancMinuto; 
 private Integer rsNumTempomaxcancMinuto; 
 private  boolean  nullNumTempomaxcancMinuto = false; 
 private Integer CodRecusa; 
 private Integer rsCodRecusa; 
 private  boolean  nullCodRecusa = false; 
 private String OnesignalKey; 
 private String rsOnesignalKey; 
 private  boolean  nullOnesignalKey = false; 
 private String OnesignalUrl; 
 private String rsOnesignalUrl; 
 private  boolean  nullOnesignalUrl = false; 
 private String OnesignalAppid; 
 private String rsOnesignalAppid; 
 private  boolean  nullOnesignalAppid = false; 
 private Integer NumMinutosNotFinal; 
 private Integer rsNumMinutosNotFinal; 
 private  boolean  nullNumMinutosNotFinal = false; 
 private Integer NumSegsNotFinalExec; 
 private Integer rsNumSegsNotFinalExec; 
 private  boolean  nullNumSegsNotFinalExec = false; 
 private Integer CodCancelamentosys; 
 private Integer rsCodCancelamentosys; 
 private  boolean  nullCodCancelamentosys = false; 
 private String DescWebappfolder; 
 private String rsDescWebappfolder; 
 private  boolean  nullDescWebappfolder = false; 
 private String IgnorarRegramaior18; 
 private String rsIgnorarRegramaior18; 
 private  boolean  nullIgnorarRegramaior18 = false; 
 private String FaceRedirectUriWebapp; 
 private String rsFaceRedirectUriWebapp; 
 private  boolean  nullFaceRedirectUriWebapp = false; 
 private String TragoaquiNumTelefone; 
 private String rsTragoaquiNumTelefone; 
 private  boolean  nullTragoaquiNumTelefone = false; 
 private String TragoaquiPagFacebook; 
 private String rsTragoaquiPagFacebook; 
 private  boolean  nullTragoaquiPagFacebook = false; 
 private String AppVersao; 
 private String rsAppVersao; 
 private  boolean  nullAppVersao = false; 
 private Integer Applicacao; 
 private Integer rsApplicacao; 
 private  boolean  nullApplicacao = false; 
 private Integer SysMinutesAgenNotResp; 
 private Integer rsSysMinutesAgenNotResp; 
 private  boolean  nullSysMinutesAgenNotResp = false; 
 private String UrlWebsocket; 
 private String rsUrlWebsocket; 
 private  boolean  nullUrlWebsocket = false; 
public PreparedStatement getSt() {		return st; 	} 
 public void setSt(PreparedStatement st) {		this.st = st; 	} 
 public StringBuffer getSql() {		return sql; 	} 
 public void setSql(StringBuffer sql) {		this.sql = sql; 	} 
 public ResultSet getRs() {		return rs; 	} 
 public void setRs(ResultSet rs) {		this.rs = rs; 	} 
 public Connection getConn() {		return conn; 	} 
 public void setConn(Connection conn) {		this.conn = conn; 	}
 public String getWhere() { return this.Where; }public void setWhere(String where) { this.Where = where; }public String getJoin() {return this.Join;}public void setJoin(String join) {this.Join = join;}public String getLastSentence() {return this.LastSentence;}public void setLastSentence(String last) {this.LastSentence = last;}public String getSelect() { return this.Select; }public void setSelect(String select) { this.Select = select; }public Integer getIdParam() {		return IdParam ; 	} 
 public void setIdParam(Integer var) {		this.IdParam = var; 	} 
 public Integer getRsIdParam() {		return rsIdParam ; 	} 
 public void setRsIdParam(Integer var) {		this.rsIdParam = var; 	} 
 public Long getIdUsuarioAdmin() {		return IdUsuarioAdmin ; 	} 
 public void setIdUsuarioAdmin(Long var) {		this.IdUsuarioAdmin = var; 	} 
 public Long getRsIdUsuarioAdmin() {		return rsIdUsuarioAdmin ; 	} 
 public void setRsIdUsuarioAdmin(Long var) {		this.rsIdUsuarioAdmin = var; 	} 
 public boolean getNullIdUsuarioAdmin() {		return nullIdUsuarioAdmin ; 	} 
 public void setNullIdUsuarioAdmin(boolean var) {		this.nullIdUsuarioAdmin = var; 	} 
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
 public Long getSegsTesteAjax() {		return SegsTesteAjax ; 	} 
 public void setSegsTesteAjax(Long var) {		this.SegsTesteAjax = var; 	} 
 public Long getRsSegsTesteAjax() {		return rsSegsTesteAjax ; 	} 
 public void setRsSegsTesteAjax(Long var) {		this.rsSegsTesteAjax = var; 	} 
 public boolean getNullSegsTesteAjax() {		return nullSegsTesteAjax ; 	} 
 public void setNullSegsTesteAjax(boolean var) {		this.nullSegsTesteAjax = var; 	} 
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
 public Long getIdVisitante() {		return IdVisitante ; 	} 
 public void setIdVisitante(Long var) {		this.IdVisitante = var; 	} 
 public Long getRsIdVisitante() {		return rsIdVisitante ; 	} 
 public void setRsIdVisitante(Long var) {		this.rsIdVisitante = var; 	} 
 public boolean getNullIdVisitante() {		return nullIdVisitante ; 	} 
 public void setNullIdVisitante(boolean var) {		this.nullIdVisitante = var; 	} 
 public Integer getPedHorasokey() {		return PedHorasokey ; 	} 
 public void setPedHorasokey(Integer var) {		this.PedHorasokey = var; 	} 
 public Integer getRsPedHorasokey() {		return rsPedHorasokey ; 	} 
 public void setRsPedHorasokey(Integer var) {		this.rsPedHorasokey = var; 	} 
 public boolean getNullPedHorasokey() {		return nullPedHorasokey ; 	} 
 public void setNullPedHorasokey(boolean var) {		this.nullPedHorasokey = var; 	} 
 public Integer getNumTempomaxcancMinuto() {		return NumTempomaxcancMinuto ; 	} 
 public void setNumTempomaxcancMinuto(Integer var) {		this.NumTempomaxcancMinuto = var; 	} 
 public Integer getRsNumTempomaxcancMinuto() {		return rsNumTempomaxcancMinuto ; 	} 
 public void setRsNumTempomaxcancMinuto(Integer var) {		this.rsNumTempomaxcancMinuto = var; 	} 
 public boolean getNullNumTempomaxcancMinuto() {		return nullNumTempomaxcancMinuto ; 	} 
 public void setNullNumTempomaxcancMinuto(boolean var) {		this.nullNumTempomaxcancMinuto = var; 	} 
 public Integer getCodRecusa() {		return CodRecusa ; 	} 
 public void setCodRecusa(Integer var) {		this.CodRecusa = var; 	} 
 public Integer getRsCodRecusa() {		return rsCodRecusa ; 	} 
 public void setRsCodRecusa(Integer var) {		this.rsCodRecusa = var; 	} 
 public boolean getNullCodRecusa() {		return nullCodRecusa ; 	} 
 public void setNullCodRecusa(boolean var) {		this.nullCodRecusa = var; 	} 
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
 public Integer getNumMinutosNotFinal() {		return NumMinutosNotFinal ; 	} 
 public void setNumMinutosNotFinal(Integer var) {		this.NumMinutosNotFinal = var; 	} 
 public Integer getRsNumMinutosNotFinal() {		return rsNumMinutosNotFinal ; 	} 
 public void setRsNumMinutosNotFinal(Integer var) {		this.rsNumMinutosNotFinal = var; 	} 
 public boolean getNullNumMinutosNotFinal() {		return nullNumMinutosNotFinal ; 	} 
 public void setNullNumMinutosNotFinal(boolean var) {		this.nullNumMinutosNotFinal = var; 	} 
 public Integer getNumSegsNotFinalExec() {		return NumSegsNotFinalExec ; 	} 
 public void setNumSegsNotFinalExec(Integer var) {		this.NumSegsNotFinalExec = var; 	} 
 public Integer getRsNumSegsNotFinalExec() {		return rsNumSegsNotFinalExec ; 	} 
 public void setRsNumSegsNotFinalExec(Integer var) {		this.rsNumSegsNotFinalExec = var; 	} 
 public boolean getNullNumSegsNotFinalExec() {		return nullNumSegsNotFinalExec ; 	} 
 public void setNullNumSegsNotFinalExec(boolean var) {		this.nullNumSegsNotFinalExec = var; 	} 
 public Integer getCodCancelamentosys() {		return CodCancelamentosys ; 	} 
 public void setCodCancelamentosys(Integer var) {		this.CodCancelamentosys = var; 	} 
 public Integer getRsCodCancelamentosys() {		return rsCodCancelamentosys ; 	} 
 public void setRsCodCancelamentosys(Integer var) {		this.rsCodCancelamentosys = var; 	} 
 public boolean getNullCodCancelamentosys() {		return nullCodCancelamentosys ; 	} 
 public void setNullCodCancelamentosys(boolean var) {		this.nullCodCancelamentosys = var; 	} 
 public String getDescWebappfolder() {		return DescWebappfolder ; 	} 
 public void setDescWebappfolder(String var) {		this.DescWebappfolder = var; 	} 
 public String getRsDescWebappfolder() {		return rsDescWebappfolder ; 	} 
 public void setRsDescWebappfolder(String var) {		this.rsDescWebappfolder = var; 	} 
 public boolean getNullDescWebappfolder() {		return nullDescWebappfolder ; 	} 
 public void setNullDescWebappfolder(boolean var) {		this.nullDescWebappfolder = var; 	} 
 public String getIgnorarRegramaior18() {		return IgnorarRegramaior18 ; 	} 
 public void setIgnorarRegramaior18(String var) {		this.IgnorarRegramaior18 = var; 	} 
 public String getRsIgnorarRegramaior18() {		return rsIgnorarRegramaior18 ; 	} 
 public void setRsIgnorarRegramaior18(String var) {		this.rsIgnorarRegramaior18 = var; 	} 
 public boolean getNullIgnorarRegramaior18() {		return nullIgnorarRegramaior18 ; 	} 
 public void setNullIgnorarRegramaior18(boolean var) {		this.nullIgnorarRegramaior18 = var; 	} 
 public String getFaceRedirectUriWebapp() {		return FaceRedirectUriWebapp ; 	} 
 public void setFaceRedirectUriWebapp(String var) {		this.FaceRedirectUriWebapp = var; 	} 
 public String getRsFaceRedirectUriWebapp() {		return rsFaceRedirectUriWebapp ; 	} 
 public void setRsFaceRedirectUriWebapp(String var) {		this.rsFaceRedirectUriWebapp = var; 	} 
 public boolean getNullFaceRedirectUriWebapp() {		return nullFaceRedirectUriWebapp ; 	} 
 public void setNullFaceRedirectUriWebapp(boolean var) {		this.nullFaceRedirectUriWebapp = var; 	} 
 public String getTragoaquiNumTelefone() {		return TragoaquiNumTelefone ; 	} 
 public void setTragoaquiNumTelefone(String var) {		this.TragoaquiNumTelefone = var; 	} 
 public String getRsTragoaquiNumTelefone() {		return rsTragoaquiNumTelefone ; 	} 
 public void setRsTragoaquiNumTelefone(String var) {		this.rsTragoaquiNumTelefone = var; 	} 
 public boolean getNullTragoaquiNumTelefone() {		return nullTragoaquiNumTelefone ; 	} 
 public void setNullTragoaquiNumTelefone(boolean var) {		this.nullTragoaquiNumTelefone = var; 	} 
 public String getTragoaquiPagFacebook() {		return TragoaquiPagFacebook ; 	} 
 public void setTragoaquiPagFacebook(String var) {		this.TragoaquiPagFacebook = var; 	} 
 public String getRsTragoaquiPagFacebook() {		return rsTragoaquiPagFacebook ; 	} 
 public void setRsTragoaquiPagFacebook(String var) {		this.rsTragoaquiPagFacebook = var; 	} 
 public boolean getNullTragoaquiPagFacebook() {		return nullTragoaquiPagFacebook ; 	} 
 public void setNullTragoaquiPagFacebook(boolean var) {		this.nullTragoaquiPagFacebook = var; 	} 
 public String getAppVersao() {		return AppVersao ; 	} 
 public void setAppVersao(String var) {		this.AppVersao = var; 	} 
 public String getRsAppVersao() {		return rsAppVersao ; 	} 
 public void setRsAppVersao(String var) {		this.rsAppVersao = var; 	} 
 public boolean getNullAppVersao() {		return nullAppVersao ; 	} 
 public void setNullAppVersao(boolean var) {		this.nullAppVersao = var; 	} 
 public Integer getApplicacao() {		return Applicacao ; 	} 
 public void setApplicacao(Integer var) {		this.Applicacao = var; 	} 
 public Integer getRsApplicacao() {		return rsApplicacao ; 	} 
 public void setRsApplicacao(Integer var) {		this.rsApplicacao = var; 	} 
 public boolean getNullApplicacao() {		return nullApplicacao ; 	} 
 public void setNullApplicacao(boolean var) {		this.nullApplicacao = var; 	} 
 public Integer getSysMinutesAgenNotResp() {		return SysMinutesAgenNotResp ; 	} 
 public void setSysMinutesAgenNotResp(Integer var) {		this.SysMinutesAgenNotResp = var; 	} 
 public Integer getRsSysMinutesAgenNotResp() {		return rsSysMinutesAgenNotResp ; 	} 
 public void setRsSysMinutesAgenNotResp(Integer var) {		this.rsSysMinutesAgenNotResp = var; 	} 
 public boolean getNullSysMinutesAgenNotResp() {		return nullSysMinutesAgenNotResp ; 	} 
 public void setNullSysMinutesAgenNotResp(boolean var) {		this.nullSysMinutesAgenNotResp = var; 	} 
 public String getUrlWebsocket() {		return UrlWebsocket ; 	} 
 public void setUrlWebsocket(String var) {		this.UrlWebsocket = var; 	} 
 public String getRsUrlWebsocket() {		return rsUrlWebsocket ; 	} 
 public void setRsUrlWebsocket(String var) {		this.rsUrlWebsocket = var; 	} 
 public boolean getNullUrlWebsocket() {		return nullUrlWebsocket ; 	} 
 public void setNullUrlWebsocket(boolean var) {		this.nullUrlWebsocket = var; 	} 
  public void posicionaRs() throws Exception{ if ( getSelect() == null ) {    try {   rsIdParam = rs.getInt("id_param"); } catch (Exception e) { e.printStackTrace();  }  try {   rsIdUsuarioAdmin = rs.getLong("id_usuario_admin"); } catch (Exception e) { e.printStackTrace();  }  try {   rsFlagManutencao = rs.getString("flag_manutencao"); } catch (Exception e) { e.printStackTrace();  }  try {   rsDescKey = rs.getString("desc_key"); } catch (Exception e) { e.printStackTrace();  }  try {   rsSegsTesteAjax = rs.getLong("segs_teste_ajax"); } catch (Exception e) { e.printStackTrace();  }  try {   rsFaceAppId = rs.getLong("face_app_id"); } catch (Exception e) { e.printStackTrace();  }  try {   rsFaceAppSecretkey = rs.getString("face_app_secretkey"); } catch (Exception e) { e.printStackTrace();  }  try {   rsFaceAppToken = rs.getString("face_app_token"); } catch (Exception e) { e.printStackTrace();  }  try {   rsFaceRedirectUri = rs.getString("face_redirect_uri"); } catch (Exception e) { e.printStackTrace();  }  try {   rsUrlSystem = rs.getString("url_system"); } catch (Exception e) { e.printStackTrace();  }  try {   rsSysHostNameSmtp = rs.getString("sys_host_name_smtp"); } catch (Exception e) { e.printStackTrace();  }  try {   rsSysSmtpPort = rs.getInt("sys_smtp_port"); } catch (Exception e) { e.printStackTrace();  }  try {   rsSysEmail = rs.getString("sys_email"); } catch (Exception e) { e.printStackTrace();  }  try {   rsSysSenha = rs.getString("sys_senha"); } catch (Exception e) { e.printStackTrace();  }  try {   rsSysFromemail = rs.getString("sys_fromemail"); } catch (Exception e) { e.printStackTrace();  }  try {   rsSysFromdesc = rs.getString("sys_fromdesc"); } catch (Exception e) { e.printStackTrace();  }  try {   rsSysTls = rs.getString("sys_tls"); } catch (Exception e) { e.printStackTrace();  }  try {   rsIdVisitante = rs.getLong("id_visitante"); } catch (Exception e) { e.printStackTrace();  }  try {   rsPedHorasokey = rs.getInt("ped_horasokey"); } catch (Exception e) { e.printStackTrace();  }  try {   rsNumTempomaxcancMinuto = rs.getInt("num_tempomaxcanc_minuto"); } catch (Exception e) { e.printStackTrace();  }  try {   rsCodRecusa = rs.getInt("cod_recusa"); } catch (Exception e) { e.printStackTrace();  }  try {   rsOnesignalKey = rs.getString("onesignal_key"); } catch (Exception e) { e.printStackTrace();  }  try {   rsOnesignalUrl = rs.getString("onesignal_url"); } catch (Exception e) { e.printStackTrace();  }  try {   rsOnesignalAppid = rs.getString("onesignal_appid"); } catch (Exception e) { e.printStackTrace();  }  try {   rsNumMinutosNotFinal = rs.getInt("num_minutos_not_final"); } catch (Exception e) { e.printStackTrace();  }  try {   rsNumSegsNotFinalExec = rs.getInt("num_segs_not_final_exec"); } catch (Exception e) { e.printStackTrace();  }  try {   rsCodCancelamentosys = rs.getInt("cod_cancelamentosys"); } catch (Exception e) { e.printStackTrace();  }  try {   rsDescWebappfolder = rs.getString("desc_webappfolder"); } catch (Exception e) { e.printStackTrace();  }  try {   rsIgnorarRegramaior18 = rs.getString("ignorar_regramaior18"); } catch (Exception e) { e.printStackTrace();  }  try {   rsFaceRedirectUriWebapp = rs.getString("face_redirect_uri_webapp"); } catch (Exception e) { e.printStackTrace();  }  try {   rsTragoaquiNumTelefone = rs.getString("tragoaqui_num_telefone"); } catch (Exception e) { e.printStackTrace();  }  try {   rsTragoaquiPagFacebook = rs.getString("tragoaqui_pag_facebook"); } catch (Exception e) { e.printStackTrace();  }  try {   rsAppVersao = rs.getString("app_versao"); } catch (Exception e) { e.printStackTrace();  }  try {   rsApplicacao = rs.getInt("applicacao"); } catch (Exception e) { e.printStackTrace();  }  try {   rsSysMinutesAgenNotResp = rs.getInt("sys_minutes_agen_not_resp"); } catch (Exception e) { e.printStackTrace();  }  try {   rsUrlWebsocket = rs.getString("url_websocket"); } catch (Exception e) { e.printStackTrace();  } }  }   public boolean next(){    boolean resultado;   resultado = false;    try{ limpaRs();    resultado = rs.next();    if (resultado){ posicionaRs(); }   } catch (Exception e){    e.printStackTrace(); }     return resultado; } public void limpaRs() throws Exception{  rsIdParam=  null ;  rsIdUsuarioAdmin=  null ;  rsFlagManutencao=  null ;  rsDescKey=  null ;  rsSegsTesteAjax=  null ;  rsFaceAppId=  null ;  rsFaceAppSecretkey=  null ;  rsFaceAppToken=  null ;  rsFaceRedirectUri=  null ;  rsUrlSystem=  null ;  rsSysHostNameSmtp=  null ;  rsSysSmtpPort=  null ;  rsSysEmail=  null ;  rsSysSenha=  null ;  rsSysFromemail=  null ;  rsSysFromdesc=  null ;  rsSysTls=  null ;  rsIdVisitante=  null ;  rsPedHorasokey=  null ;  rsNumTempomaxcancMinuto=  null ;  rsCodRecusa=  null ;  rsOnesignalKey=  null ;  rsOnesignalUrl=  null ;  rsOnesignalAppid=  null ;  rsNumMinutosNotFinal=  null ;  rsNumSegsNotFinalExec=  null ;  rsCodCancelamentosys=  null ;  rsDescWebappfolder=  null ;  rsIgnorarRegramaior18=  null ;  rsFaceRedirectUriWebapp=  null ;  rsTragoaquiNumTelefone=  null ;  rsTragoaquiPagFacebook=  null ;  rsAppVersao=  null ;  rsApplicacao=  null ;  rsSysMinutesAgenNotResp=  null ;  rsUrlWebsocket=  null ;   }  public ResultSet lista() throws Exception { sql = new StringBuffer(); if(getSelect()!=null){ sql.append(" select "+getSelect()+" "); }else {sql.append(" select * from sys_parametros  "); } if(getJoin()!=null){ sql.append(" from "+getJoin()+" where  1=1 "); }else {sql.append(" from sys_parametros where  1=1 "); } if( getIdParam() != null ) { sql.append(" and sys_parametros .id_param = ? "); } if( getIdUsuarioAdmin() != null ) { sql.append(" and sys_parametros .id_usuario_admin = ? "); } if( getFlagManutencao() != null ) { sql.append(" and sys_parametros .flag_manutencao = ? "); } if( getDescKey() != null ) { sql.append(" and sys_parametros .desc_key = ? "); } if( getSegsTesteAjax() != null ) { sql.append(" and sys_parametros .segs_teste_ajax = ? "); } if( getFaceAppId() != null ) { sql.append(" and sys_parametros .face_app_id = ? "); } if( getFaceAppSecretkey() != null ) { sql.append(" and sys_parametros .face_app_secretkey = ? "); } if( getFaceAppToken() != null ) { sql.append(" and sys_parametros .face_app_token = ? "); } if( getFaceRedirectUri() != null ) { sql.append(" and sys_parametros .face_redirect_uri = ? "); } if( getUrlSystem() != null ) { sql.append(" and sys_parametros .url_system = ? "); } if( getSysHostNameSmtp() != null ) { sql.append(" and sys_parametros .sys_host_name_smtp = ? "); } if( getSysSmtpPort() != null ) { sql.append(" and sys_parametros .sys_smtp_port = ? "); } if( getSysEmail() != null ) { sql.append(" and sys_parametros .sys_email = ? "); } if( getSysSenha() != null ) { sql.append(" and sys_parametros .sys_senha = ? "); } if( getSysFromemail() != null ) { sql.append(" and sys_parametros .sys_fromemail = ? "); } if( getSysFromdesc() != null ) { sql.append(" and sys_parametros .sys_fromdesc = ? "); } if( getSysTls() != null ) { sql.append(" and sys_parametros .sys_tls = ? "); } if( getIdVisitante() != null ) { sql.append(" and sys_parametros .id_visitante = ? "); } if( getPedHorasokey() != null ) { sql.append(" and sys_parametros .ped_horasokey = ? "); } if( getNumTempomaxcancMinuto() != null ) { sql.append(" and sys_parametros .num_tempomaxcanc_minuto = ? "); } if( getCodRecusa() != null ) { sql.append(" and sys_parametros .cod_recusa = ? "); } if( getOnesignalKey() != null ) { sql.append(" and sys_parametros .onesignal_key = ? "); } if( getOnesignalUrl() != null ) { sql.append(" and sys_parametros .onesignal_url = ? "); } if( getOnesignalAppid() != null ) { sql.append(" and sys_parametros .onesignal_appid = ? "); } if( getNumMinutosNotFinal() != null ) { sql.append(" and sys_parametros .num_minutos_not_final = ? "); } if( getNumSegsNotFinalExec() != null ) { sql.append(" and sys_parametros .num_segs_not_final_exec = ? "); } if( getCodCancelamentosys() != null ) { sql.append(" and sys_parametros .cod_cancelamentosys = ? "); } if( getDescWebappfolder() != null ) { sql.append(" and sys_parametros .desc_webappfolder = ? "); } if( getIgnorarRegramaior18() != null ) { sql.append(" and sys_parametros .ignorar_regramaior18 = ? "); } if( getFaceRedirectUriWebapp() != null ) { sql.append(" and sys_parametros .face_redirect_uri_webapp = ? "); } if( getTragoaquiNumTelefone() != null ) { sql.append(" and sys_parametros .tragoaqui_num_telefone = ? "); } if( getTragoaquiPagFacebook() != null ) { sql.append(" and sys_parametros .tragoaqui_pag_facebook = ? "); } if( getAppVersao() != null ) { sql.append(" and sys_parametros .app_versao = ? "); } if( getApplicacao() != null ) { sql.append(" and sys_parametros .applicacao = ? "); } if( getSysMinutesAgenNotResp() != null ) { sql.append(" and sys_parametros .sys_minutes_agen_not_resp = ? "); } if( getUrlWebsocket() != null ) { sql.append(" and sys_parametros .url_websocket = ? "); } if(getWhere()!=null){ sql.append(" and "+ getWhere()+" "); }        if(getLastSentence()!=null){ sql.append(" "+ getLastSentence()+""); }        st = conn.prepareStatement(sql.toString());  int contparam = 1;  if( getIdParam() != null ){ st.setInt(contparam,getIdParam()); contparam++;}  if( getIdUsuarioAdmin() != null ){ st.setLong(contparam,getIdUsuarioAdmin()); contparam++;}  if( getFlagManutencao() != null ){ st.setString(contparam,getFlagManutencao()); contparam++;}  if( getDescKey() != null ){ st.setString(contparam,getDescKey()); contparam++;}  if( getSegsTesteAjax() != null ){ st.setLong(contparam,getSegsTesteAjax()); contparam++;}  if( getFaceAppId() != null ){ st.setLong(contparam,getFaceAppId()); contparam++;}  if( getFaceAppSecretkey() != null ){ st.setString(contparam,getFaceAppSecretkey()); contparam++;}  if( getFaceAppToken() != null ){ st.setString(contparam,getFaceAppToken()); contparam++;}  if( getFaceRedirectUri() != null ){ st.setString(contparam,getFaceRedirectUri()); contparam++;}  if( getUrlSystem() != null ){ st.setString(contparam,getUrlSystem()); contparam++;}  if( getSysHostNameSmtp() != null ){ st.setString(contparam,getSysHostNameSmtp()); contparam++;}  if( getSysSmtpPort() != null ){ st.setInt(contparam,getSysSmtpPort()); contparam++;}  if( getSysEmail() != null ){ st.setString(contparam,getSysEmail()); contparam++;}  if( getSysSenha() != null ){ st.setString(contparam,getSysSenha()); contparam++;}  if( getSysFromemail() != null ){ st.setString(contparam,getSysFromemail()); contparam++;}  if( getSysFromdesc() != null ){ st.setString(contparam,getSysFromdesc()); contparam++;}  if( getSysTls() != null ){ st.setString(contparam,getSysTls()); contparam++;}  if( getIdVisitante() != null ){ st.setLong(contparam,getIdVisitante()); contparam++;}  if( getPedHorasokey() != null ){ st.setInt(contparam,getPedHorasokey()); contparam++;}  if( getNumTempomaxcancMinuto() != null ){ st.setInt(contparam,getNumTempomaxcancMinuto()); contparam++;}  if( getCodRecusa() != null ){ st.setInt(contparam,getCodRecusa()); contparam++;}  if( getOnesignalKey() != null ){ st.setString(contparam,getOnesignalKey()); contparam++;}  if( getOnesignalUrl() != null ){ st.setString(contparam,getOnesignalUrl()); contparam++;}  if( getOnesignalAppid() != null ){ st.setString(contparam,getOnesignalAppid()); contparam++;}  if( getNumMinutosNotFinal() != null ){ st.setInt(contparam,getNumMinutosNotFinal()); contparam++;}  if( getNumSegsNotFinalExec() != null ){ st.setInt(contparam,getNumSegsNotFinalExec()); contparam++;}  if( getCodCancelamentosys() != null ){ st.setInt(contparam,getCodCancelamentosys()); contparam++;}  if( getDescWebappfolder() != null ){ st.setString(contparam,getDescWebappfolder()); contparam++;}  if( getIgnorarRegramaior18() != null ){ st.setString(contparam,getIgnorarRegramaior18()); contparam++;}  if( getFaceRedirectUriWebapp() != null ){ st.setString(contparam,getFaceRedirectUriWebapp()); contparam++;}  if( getTragoaquiNumTelefone() != null ){ st.setString(contparam,getTragoaquiNumTelefone()); contparam++;}  if( getTragoaquiPagFacebook() != null ){ st.setString(contparam,getTragoaquiPagFacebook()); contparam++;}  if( getAppVersao() != null ){ st.setString(contparam,getAppVersao()); contparam++;}  if( getApplicacao() != null ){ st.setInt(contparam,getApplicacao()); contparam++;}  if( getSysMinutesAgenNotResp() != null ){ st.setInt(contparam,getSysMinutesAgenNotResp()); contparam++;}  if( getUrlWebsocket() != null ){ st.setString(contparam,getUrlWebsocket()); contparam++;}  	rs = st.executeQuery();  	return rs; }public void update() throws Exception { sql = new StringBuffer();sql.append(" update sys_parametros set id_param =  " + getIdParam() + "  "); if( getIdUsuarioAdmin() != null ) { sql.append(" ,  id_usuario_admin = ? "); } if( getNullIdUsuarioAdmin()) { sql.append(" ,  id_usuario_admin = null "); } if( getFlagManutencao() != null ) { sql.append(" ,  flag_manutencao = ? "); } if( getNullFlagManutencao()) { sql.append(" ,  flag_manutencao = null "); } if( getDescKey() != null ) { sql.append(" ,  desc_key = ? "); } if( getNullDescKey()) { sql.append(" ,  desc_key = null "); } if( getSegsTesteAjax() != null ) { sql.append(" ,  segs_teste_ajax = ? "); } if( getNullSegsTesteAjax()) { sql.append(" ,  segs_teste_ajax = null "); } if( getFaceAppId() != null ) { sql.append(" ,  face_app_id = ? "); } if( getNullFaceAppId()) { sql.append(" ,  face_app_id = null "); } if( getFaceAppSecretkey() != null ) { sql.append(" ,  face_app_secretkey = ? "); } if( getNullFaceAppSecretkey()) { sql.append(" ,  face_app_secretkey = null "); } if( getFaceAppToken() != null ) { sql.append(" ,  face_app_token = ? "); } if( getNullFaceAppToken()) { sql.append(" ,  face_app_token = null "); } if( getFaceRedirectUri() != null ) { sql.append(" ,  face_redirect_uri = ? "); } if( getNullFaceRedirectUri()) { sql.append(" ,  face_redirect_uri = null "); } if( getUrlSystem() != null ) { sql.append(" ,  url_system = ? "); } if( getNullUrlSystem()) { sql.append(" ,  url_system = null "); } if( getSysHostNameSmtp() != null ) { sql.append(" ,  sys_host_name_smtp = ? "); } if( getNullSysHostNameSmtp()) { sql.append(" ,  sys_host_name_smtp = null "); } if( getSysSmtpPort() != null ) { sql.append(" ,  sys_smtp_port = ? "); } if( getNullSysSmtpPort()) { sql.append(" ,  sys_smtp_port = null "); } if( getSysEmail() != null ) { sql.append(" ,  sys_email = ? "); } if( getNullSysEmail()) { sql.append(" ,  sys_email = null "); } if( getSysSenha() != null ) { sql.append(" ,  sys_senha = ? "); } if( getNullSysSenha()) { sql.append(" ,  sys_senha = null "); } if( getSysFromemail() != null ) { sql.append(" ,  sys_fromemail = ? "); } if( getNullSysFromemail()) { sql.append(" ,  sys_fromemail = null "); } if( getSysFromdesc() != null ) { sql.append(" ,  sys_fromdesc = ? "); } if( getNullSysFromdesc()) { sql.append(" ,  sys_fromdesc = null "); } if( getSysTls() != null ) { sql.append(" ,  sys_tls = ? "); } if( getNullSysTls()) { sql.append(" ,  sys_tls = null "); } if( getIdVisitante() != null ) { sql.append(" ,  id_visitante = ? "); } if( getNullIdVisitante()) { sql.append(" ,  id_visitante = null "); } if( getPedHorasokey() != null ) { sql.append(" ,  ped_horasokey = ? "); } if( getNullPedHorasokey()) { sql.append(" ,  ped_horasokey = null "); } if( getNumTempomaxcancMinuto() != null ) { sql.append(" ,  num_tempomaxcanc_minuto = ? "); } if( getNullNumTempomaxcancMinuto()) { sql.append(" ,  num_tempomaxcanc_minuto = null "); } if( getCodRecusa() != null ) { sql.append(" ,  cod_recusa = ? "); } if( getNullCodRecusa()) { sql.append(" ,  cod_recusa = null "); } if( getOnesignalKey() != null ) { sql.append(" ,  onesignal_key = ? "); } if( getNullOnesignalKey()) { sql.append(" ,  onesignal_key = null "); } if( getOnesignalUrl() != null ) { sql.append(" ,  onesignal_url = ? "); } if( getNullOnesignalUrl()) { sql.append(" ,  onesignal_url = null "); } if( getOnesignalAppid() != null ) { sql.append(" ,  onesignal_appid = ? "); } if( getNullOnesignalAppid()) { sql.append(" ,  onesignal_appid = null "); } if( getNumMinutosNotFinal() != null ) { sql.append(" ,  num_minutos_not_final = ? "); } if( getNullNumMinutosNotFinal()) { sql.append(" ,  num_minutos_not_final = null "); } if( getNumSegsNotFinalExec() != null ) { sql.append(" ,  num_segs_not_final_exec = ? "); } if( getNullNumSegsNotFinalExec()) { sql.append(" ,  num_segs_not_final_exec = null "); } if( getCodCancelamentosys() != null ) { sql.append(" ,  cod_cancelamentosys = ? "); } if( getNullCodCancelamentosys()) { sql.append(" ,  cod_cancelamentosys = null "); } if( getDescWebappfolder() != null ) { sql.append(" ,  desc_webappfolder = ? "); } if( getNullDescWebappfolder()) { sql.append(" ,  desc_webappfolder = null "); } if( getIgnorarRegramaior18() != null ) { sql.append(" ,  ignorar_regramaior18 = ? "); } if( getNullIgnorarRegramaior18()) { sql.append(" ,  ignorar_regramaior18 = null "); } if( getFaceRedirectUriWebapp() != null ) { sql.append(" ,  face_redirect_uri_webapp = ? "); } if( getNullFaceRedirectUriWebapp()) { sql.append(" ,  face_redirect_uri_webapp = null "); } if( getTragoaquiNumTelefone() != null ) { sql.append(" ,  tragoaqui_num_telefone = ? "); } if( getNullTragoaquiNumTelefone()) { sql.append(" ,  tragoaqui_num_telefone = null "); } if( getTragoaquiPagFacebook() != null ) { sql.append(" ,  tragoaqui_pag_facebook = ? "); } if( getNullTragoaquiPagFacebook()) { sql.append(" ,  tragoaqui_pag_facebook = null "); } if( getAppVersao() != null ) { sql.append(" ,  app_versao = ? "); } if( getNullAppVersao()) { sql.append(" ,  app_versao = null "); } if( getApplicacao() != null ) { sql.append(" ,  applicacao = ? "); } if( getNullApplicacao()) { sql.append(" ,  applicacao = null "); } if( getSysMinutesAgenNotResp() != null ) { sql.append(" ,  sys_minutes_agen_not_resp = ? "); } if( getNullSysMinutesAgenNotResp()) { sql.append(" ,  sys_minutes_agen_not_resp = null "); } if( getUrlWebsocket() != null ) { sql.append(" ,  url_websocket = ? "); } if( getNullUrlWebsocket()) { sql.append(" ,  url_websocket = null "); } sql.append(" where id_param =  " + getIdParam() + "  "); if(getWhere()!=null){ sql.append(" and "+ getWhere()+" "); }        st = conn.prepareStatement(sql.toString());  int contparam = 1;  if( getIdUsuarioAdmin() != null ){ st.setLong(contparam,getIdUsuarioAdmin()); contparam++;}  if( getFlagManutencao() != null ){ st.setString(contparam,getFlagManutencao()); contparam++;}  if( getDescKey() != null ){ st.setString(contparam,getDescKey()); contparam++;}  if( getSegsTesteAjax() != null ){ st.setLong(contparam,getSegsTesteAjax()); contparam++;}  if( getFaceAppId() != null ){ st.setLong(contparam,getFaceAppId()); contparam++;}  if( getFaceAppSecretkey() != null ){ st.setString(contparam,getFaceAppSecretkey()); contparam++;}  if( getFaceAppToken() != null ){ st.setString(contparam,getFaceAppToken()); contparam++;}  if( getFaceRedirectUri() != null ){ st.setString(contparam,getFaceRedirectUri()); contparam++;}  if( getUrlSystem() != null ){ st.setString(contparam,getUrlSystem()); contparam++;}  if( getSysHostNameSmtp() != null ){ st.setString(contparam,getSysHostNameSmtp()); contparam++;}  if( getSysSmtpPort() != null ){ st.setInt(contparam,getSysSmtpPort()); contparam++;}  if( getSysEmail() != null ){ st.setString(contparam,getSysEmail()); contparam++;}  if( getSysSenha() != null ){ st.setString(contparam,getSysSenha()); contparam++;}  if( getSysFromemail() != null ){ st.setString(contparam,getSysFromemail()); contparam++;}  if( getSysFromdesc() != null ){ st.setString(contparam,getSysFromdesc()); contparam++;}  if( getSysTls() != null ){ st.setString(contparam,getSysTls()); contparam++;}  if( getIdVisitante() != null ){ st.setLong(contparam,getIdVisitante()); contparam++;}  if( getPedHorasokey() != null ){ st.setInt(contparam,getPedHorasokey()); contparam++;}  if( getNumTempomaxcancMinuto() != null ){ st.setInt(contparam,getNumTempomaxcancMinuto()); contparam++;}  if( getCodRecusa() != null ){ st.setInt(contparam,getCodRecusa()); contparam++;}  if( getOnesignalKey() != null ){ st.setString(contparam,getOnesignalKey()); contparam++;}  if( getOnesignalUrl() != null ){ st.setString(contparam,getOnesignalUrl()); contparam++;}  if( getOnesignalAppid() != null ){ st.setString(contparam,getOnesignalAppid()); contparam++;}  if( getNumMinutosNotFinal() != null ){ st.setInt(contparam,getNumMinutosNotFinal()); contparam++;}  if( getNumSegsNotFinalExec() != null ){ st.setInt(contparam,getNumSegsNotFinalExec()); contparam++;}  if( getCodCancelamentosys() != null ){ st.setInt(contparam,getCodCancelamentosys()); contparam++;}  if( getDescWebappfolder() != null ){ st.setString(contparam,getDescWebappfolder()); contparam++;}  if( getIgnorarRegramaior18() != null ){ st.setString(contparam,getIgnorarRegramaior18()); contparam++;}  if( getFaceRedirectUriWebapp() != null ){ st.setString(contparam,getFaceRedirectUriWebapp()); contparam++;}  if( getTragoaquiNumTelefone() != null ){ st.setString(contparam,getTragoaquiNumTelefone()); contparam++;}  if( getTragoaquiPagFacebook() != null ){ st.setString(contparam,getTragoaquiPagFacebook()); contparam++;}  if( getAppVersao() != null ){ st.setString(contparam,getAppVersao()); contparam++;}  if( getApplicacao() != null ){ st.setInt(contparam,getApplicacao()); contparam++;}  if( getSysMinutesAgenNotResp() != null ){ st.setInt(contparam,getSysMinutesAgenNotResp()); contparam++;}  if( getUrlWebsocket() != null ){ st.setString(contparam,getUrlWebsocket()); contparam++;}  		st.executeUpdate() ;} public void delete() throws Exception { sql = new StringBuffer();sql.append(" delete from sys_parametros "); sql.append(" where id_param =  " + getIdParam() + "  "); st = conn.prepareStatement(sql.toString());  		st.executeUpdate() ;} public void insert() throws Exception { sql = new StringBuffer();StringBuffer values = new StringBuffer();sql.append(" insert into sys_parametros  (id_param " );values.append(" value (? "); if( getIdParam() != null ) {sql.append(" , id_param ");values.append(", ? "); }  if( getIdUsuarioAdmin() != null ) {sql.append(" , id_usuario_admin ");values.append(", ? "); }  if( getFlagManutencao() != null ) {sql.append(" , flag_manutencao ");values.append(", ? "); }  if( getDescKey() != null ) {sql.append(" , desc_key ");values.append(", ? "); }  if( getSegsTesteAjax() != null ) {sql.append(" , segs_teste_ajax ");values.append(", ? "); }  if( getFaceAppId() != null ) {sql.append(" , face_app_id ");values.append(", ? "); }  if( getFaceAppSecretkey() != null ) {sql.append(" , face_app_secretkey ");values.append(", ? "); }  if( getFaceAppToken() != null ) {sql.append(" , face_app_token ");values.append(", ? "); }  if( getFaceRedirectUri() != null ) {sql.append(" , face_redirect_uri ");values.append(", ? "); }  if( getUrlSystem() != null ) {sql.append(" , url_system ");values.append(", ? "); }  if( getSysHostNameSmtp() != null ) {sql.append(" , sys_host_name_smtp ");values.append(", ? "); }  if( getSysSmtpPort() != null ) {sql.append(" , sys_smtp_port ");values.append(", ? "); }  if( getSysEmail() != null ) {sql.append(" , sys_email ");values.append(", ? "); }  if( getSysSenha() != null ) {sql.append(" , sys_senha ");values.append(", ? "); }  if( getSysFromemail() != null ) {sql.append(" , sys_fromemail ");values.append(", ? "); }  if( getSysFromdesc() != null ) {sql.append(" , sys_fromdesc ");values.append(", ? "); }  if( getSysTls() != null ) {sql.append(" , sys_tls ");values.append(", ? "); }  if( getIdVisitante() != null ) {sql.append(" , id_visitante ");values.append(", ? "); }  if( getPedHorasokey() != null ) {sql.append(" , ped_horasokey ");values.append(", ? "); }  if( getNumTempomaxcancMinuto() != null ) {sql.append(" , num_tempomaxcanc_minuto ");values.append(", ? "); }  if( getCodRecusa() != null ) {sql.append(" , cod_recusa ");values.append(", ? "); }  if( getOnesignalKey() != null ) {sql.append(" , onesignal_key ");values.append(", ? "); }  if( getOnesignalUrl() != null ) {sql.append(" , onesignal_url ");values.append(", ? "); }  if( getOnesignalAppid() != null ) {sql.append(" , onesignal_appid ");values.append(", ? "); }  if( getNumMinutosNotFinal() != null ) {sql.append(" , num_minutos_not_final ");values.append(", ? "); }  if( getNumSegsNotFinalExec() != null ) {sql.append(" , num_segs_not_final_exec ");values.append(", ? "); }  if( getCodCancelamentosys() != null ) {sql.append(" , cod_cancelamentosys ");values.append(", ? "); }  if( getDescWebappfolder() != null ) {sql.append(" , desc_webappfolder ");values.append(", ? "); }  if( getIgnorarRegramaior18() != null ) {sql.append(" , ignorar_regramaior18 ");values.append(", ? "); }  if( getFaceRedirectUriWebapp() != null ) {sql.append(" , face_redirect_uri_webapp ");values.append(", ? "); }  if( getTragoaquiNumTelefone() != null ) {sql.append(" , tragoaqui_num_telefone ");values.append(", ? "); }  if( getTragoaquiPagFacebook() != null ) {sql.append(" , tragoaqui_pag_facebook ");values.append(", ? "); }  if( getAppVersao() != null ) {sql.append(" , app_versao ");values.append(", ? "); }  if( getApplicacao() != null ) {sql.append(" , applicacao ");values.append(", ? "); }  if( getSysMinutesAgenNotResp() != null ) {sql.append(" , sys_minutes_agen_not_resp ");values.append(", ? "); }  if( getUrlWebsocket() != null ) {sql.append(" , url_websocket ");values.append(", ? "); } sql.append(" ) ");values.append(" ) ");sql.append( values.toString()); 	st = conn.prepareStatement(sql.toString());   int id = 	 Utilitario.retornaIdinsert 	 ("sys_parametros", "id_param", conn); int contparam = 1;  st.setInt(contparam, id); contparam++;  if( getIdUsuarioAdmin() != null ){ st.setLong(contparam,getIdUsuarioAdmin()); contparam++;  }  if( getFlagManutencao() != null ){ st.setString(contparam,getFlagManutencao()); contparam++;  }  if( getDescKey() != null ){ st.setString(contparam,getDescKey()); contparam++;  }  if( getSegsTesteAjax() != null ){ st.setLong(contparam,getSegsTesteAjax()); contparam++;  }  if( getFaceAppId() != null ){ st.setLong(contparam,getFaceAppId()); contparam++;  }  if( getFaceAppSecretkey() != null ){ st.setString(contparam,getFaceAppSecretkey()); contparam++;  }  if( getFaceAppToken() != null ){ st.setString(contparam,getFaceAppToken()); contparam++;  }  if( getFaceRedirectUri() != null ){ st.setString(contparam,getFaceRedirectUri()); contparam++;  }  if( getUrlSystem() != null ){ st.setString(contparam,getUrlSystem()); contparam++;  }  if( getSysHostNameSmtp() != null ){ st.setString(contparam,getSysHostNameSmtp()); contparam++;  }  if( getSysSmtpPort() != null ){ st.setInt(contparam,getSysSmtpPort()); contparam++;  }  if( getSysEmail() != null ){ st.setString(contparam,getSysEmail()); contparam++;  }  if( getSysSenha() != null ){ st.setString(contparam,getSysSenha()); contparam++;  }  if( getSysFromemail() != null ){ st.setString(contparam,getSysFromemail()); contparam++;  }  if( getSysFromdesc() != null ){ st.setString(contparam,getSysFromdesc()); contparam++;  }  if( getSysTls() != null ){ st.setString(contparam,getSysTls()); contparam++;  }  if( getIdVisitante() != null ){ st.setLong(contparam,getIdVisitante()); contparam++;  }  if( getPedHorasokey() != null ){ st.setInt(contparam,getPedHorasokey()); contparam++;  }  if( getNumTempomaxcancMinuto() != null ){ st.setInt(contparam,getNumTempomaxcancMinuto()); contparam++;  }  if( getCodRecusa() != null ){ st.setInt(contparam,getCodRecusa()); contparam++;  }  if( getOnesignalKey() != null ){ st.setString(contparam,getOnesignalKey()); contparam++;  }  if( getOnesignalUrl() != null ){ st.setString(contparam,getOnesignalUrl()); contparam++;  }  if( getOnesignalAppid() != null ){ st.setString(contparam,getOnesignalAppid()); contparam++;  }  if( getNumMinutosNotFinal() != null ){ st.setInt(contparam,getNumMinutosNotFinal()); contparam++;  }  if( getNumSegsNotFinalExec() != null ){ st.setInt(contparam,getNumSegsNotFinalExec()); contparam++;  }  if( getCodCancelamentosys() != null ){ st.setInt(contparam,getCodCancelamentosys()); contparam++;  }  if( getDescWebappfolder() != null ){ st.setString(contparam,getDescWebappfolder()); contparam++;  }  if( getIgnorarRegramaior18() != null ){ st.setString(contparam,getIgnorarRegramaior18()); contparam++;  }  if( getFaceRedirectUriWebapp() != null ){ st.setString(contparam,getFaceRedirectUriWebapp()); contparam++;  }  if( getTragoaquiNumTelefone() != null ){ st.setString(contparam,getTragoaquiNumTelefone()); contparam++;  }  if( getTragoaquiPagFacebook() != null ){ st.setString(contparam,getTragoaquiPagFacebook()); contparam++;  }  if( getAppVersao() != null ){ st.setString(contparam,getAppVersao()); contparam++;  }  if( getApplicacao() != null ){ st.setInt(contparam,getApplicacao()); contparam++;  }  if( getSysMinutesAgenNotResp() != null ){ st.setInt(contparam,getSysMinutesAgenNotResp()); contparam++;  }  if( getUrlWebsocket() != null ){ st.setString(contparam,getUrlWebsocket()); contparam++;  }  		if (st.executeUpdate() == 1) { setIdParam(id);} else { throw new Exception("Erro, contate suporte. Inserção de sys_parametros.");}}
 
 }