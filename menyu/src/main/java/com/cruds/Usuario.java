package com.cruds; 
import java.sql.Connection; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import com.funcs.Utilitario; 
import java.util.Date; 
import java.sql.Timestamp; 
import com.mysql.jdbc.Statement; 
 import com.cruds.Bairros ; 
public class Usuario { 

private PreparedStatement st; 
private StringBuffer sql; 
private ResultSet rs; 
private Connection conn; 
private String Where; 
private String Join; 
private String LastSentence; 
private String Select; 
public Usuario(Connection conn) { super();this.conn = conn;} 
 private Long IdUsuario; 
 private Long rsIdUsuario; 
 private String DescNome; 
 private String rsDescNome; 
 private  boolean  nullDescNome = false; 
 private String DescTelefone; 
 private String rsDescTelefone; 
 private  boolean  nullDescTelefone = false; 
 private String DescUser; 
 private String rsDescUser; 
 private  boolean  nullDescUser = false; 
 private String DescSenha; 
 private String rsDescSenha; 
 private  boolean  nullDescSenha = false; 
 private String DescEmail; 
 private String rsDescEmail; 
 private  boolean  nullDescEmail = false; 
 private Integer CodCidade; 
 private Integer rsCodCidade; 
 private  boolean  nullCodCidade = false; 
 private String DescEndereco; 
 private String rsDescEndereco; 
 private  boolean  nullDescEndereco = false; 
 private String DescEnderecoNum; 
 private String rsDescEnderecoNum; 
 private  boolean  nullDescEnderecoNum = false; 
 private String DescEnderecoComplemento; 
 private String rsDescEnderecoComplemento; 
 private  boolean  nullDescEnderecoComplemento = false; 
 private Integer CodBairro; 
 private Integer rsCodBairro; 
 private  boolean  nullCodBairro = false; 
 private String FlagFaceuser; 
 private String rsFlagFaceuser; 
 private  boolean  nullFlagFaceuser = false; 
 private Long IdUserFace; 
 private Long rsIdUserFace; 
 private  boolean  nullIdUserFace = false; 
 private String FlagAtivado; 
 private String rsFlagAtivado; 
 private  boolean  nullFlagAtivado = false; 
 private String ChaveAtivacao; 
 private String rsChaveAtivacao; 
 private  boolean  nullChaveAtivacao = false; 
 private String DescNovoemailvalidacao; 
 private String rsDescNovoemailvalidacao; 
 private  boolean  nullDescNovoemailvalidacao = false; 
 private String ChaveAtivacaoNovoemail; 
 private String rsChaveAtivacaoNovoemail; 
 private  boolean  nullChaveAtivacaoNovoemail = false; 
 private String FlagMaioridade; 
 private String rsFlagMaioridade; 
 private  boolean  nullFlagMaioridade = false; 
 private String FlagLeutermos; 
 private String rsFlagLeutermos; 
 private  boolean  nullFlagLeutermos = false; 
 private String FlagTipo; 
 private String rsFlagTipo; 
 private  boolean  nullFlagTipo = false; 
public PreparedStatement getSt() {		return st; 	} 
 public void setSt(PreparedStatement st) {		this.st = st; 	} 
 public StringBuffer getSql() {		return sql; 	} 
 public void setSql(StringBuffer sql) {		this.sql = sql; 	} 
 public ResultSet getRs() {		return rs; 	} 
 public void setRs(ResultSet rs) {		this.rs = rs; 	} 
 public Connection getConn() {		return conn; 	} 
 public void setConn(Connection conn) {		this.conn = conn; 	}
 public String getWhere() { return this.Where; }public void setWhere(String where) { this.Where = where; }public String getJoin() {return this.Join;}public void setJoin(String join) {this.Join = join;}public String getLastSentence() {return this.LastSentence;}public void setLastSentence(String last) {this.LastSentence = last;}public String getSelect() { return this.Select; }public void setSelect(String select) { this.Select = select; }public Long getIdUsuario() {		return IdUsuario ; 	} 
 public void setIdUsuario(Long var) {		this.IdUsuario = var; 	} 
 public Long getRsIdUsuario() {		return rsIdUsuario ; 	} 
 public void setRsIdUsuario(Long var) {		this.rsIdUsuario = var; 	} 
 public String getDescNome() {		return DescNome ; 	} 
 public void setDescNome(String var) {		this.DescNome = var; 	} 
 public String getRsDescNome() {		return rsDescNome ; 	} 
 public void setRsDescNome(String var) {		this.rsDescNome = var; 	} 
 public boolean getNullDescNome() {		return nullDescNome ; 	} 
 public void setNullDescNome(boolean var) {		this.nullDescNome = var; 	} 
 public String getDescTelefone() {		return DescTelefone ; 	} 
 public void setDescTelefone(String var) {		this.DescTelefone = var; 	} 
 public String getRsDescTelefone() {		return rsDescTelefone ; 	} 
 public void setRsDescTelefone(String var) {		this.rsDescTelefone = var; 	} 
 public boolean getNullDescTelefone() {		return nullDescTelefone ; 	} 
 public void setNullDescTelefone(boolean var) {		this.nullDescTelefone = var; 	} 
 public String getDescUser() {		return DescUser ; 	} 
 public void setDescUser(String var) {		this.DescUser = var; 	} 
 public String getRsDescUser() {		return rsDescUser ; 	} 
 public void setRsDescUser(String var) {		this.rsDescUser = var; 	} 
 public boolean getNullDescUser() {		return nullDescUser ; 	} 
 public void setNullDescUser(boolean var) {		this.nullDescUser = var; 	} 
 public String getDescSenha() {		return DescSenha ; 	} 
 public void setDescSenha(String var) {		this.DescSenha = var; 	} 
 public String getRsDescSenha() {		return rsDescSenha ; 	} 
 public void setRsDescSenha(String var) {		this.rsDescSenha = var; 	} 
 public boolean getNullDescSenha() {		return nullDescSenha ; 	} 
 public void setNullDescSenha(boolean var) {		this.nullDescSenha = var; 	} 
 public String getDescEmail() {		return DescEmail ; 	} 
 public void setDescEmail(String var) {		this.DescEmail = var; 	} 
 public String getRsDescEmail() {		return rsDescEmail ; 	} 
 public void setRsDescEmail(String var) {		this.rsDescEmail = var; 	} 
 public boolean getNullDescEmail() {		return nullDescEmail ; 	} 
 public void setNullDescEmail(boolean var) {		this.nullDescEmail = var; 	} 
 public Integer getCodCidade() {		return CodCidade ; 	} 
 public void setCodCidade(Integer var) {		this.CodCidade = var; 	} 
 public Integer getRsCodCidade() {		return rsCodCidade ; 	} 
 public void setRsCodCidade(Integer var) {		this.rsCodCidade = var; 	} 
 public boolean getNullCodCidade() {		return nullCodCidade ; 	} 
 public void setNullCodCidade(boolean var) {		this.nullCodCidade = var; 	} 
 public String getDescEndereco() {		return DescEndereco ; 	} 
 public void setDescEndereco(String var) {		this.DescEndereco = var; 	} 
 public String getRsDescEndereco() {		return rsDescEndereco ; 	} 
 public void setRsDescEndereco(String var) {		this.rsDescEndereco = var; 	} 
 public boolean getNullDescEndereco() {		return nullDescEndereco ; 	} 
 public void setNullDescEndereco(boolean var) {		this.nullDescEndereco = var; 	} 
 public String getDescEnderecoNum() {		return DescEnderecoNum ; 	} 
 public void setDescEnderecoNum(String var) {		this.DescEnderecoNum = var; 	} 
 public String getRsDescEnderecoNum() {		return rsDescEnderecoNum ; 	} 
 public void setRsDescEnderecoNum(String var) {		this.rsDescEnderecoNum = var; 	} 
 public boolean getNullDescEnderecoNum() {		return nullDescEnderecoNum ; 	} 
 public void setNullDescEnderecoNum(boolean var) {		this.nullDescEnderecoNum = var; 	} 
 public String getDescEnderecoComplemento() {		return DescEnderecoComplemento ; 	} 
 public void setDescEnderecoComplemento(String var) {		this.DescEnderecoComplemento = var; 	} 
 public String getRsDescEnderecoComplemento() {		return rsDescEnderecoComplemento ; 	} 
 public void setRsDescEnderecoComplemento(String var) {		this.rsDescEnderecoComplemento = var; 	} 
 public boolean getNullDescEnderecoComplemento() {		return nullDescEnderecoComplemento ; 	} 
 public void setNullDescEnderecoComplemento(boolean var) {		this.nullDescEnderecoComplemento = var; 	} 
 public Integer getCodBairro() {		return CodBairro ; 	} 
 public void setCodBairro(Integer var) {		this.CodBairro = var; 	} 
 public Integer getRsCodBairro() {		return rsCodBairro ; 	} 
 public void setRsCodBairro(Integer var) {		this.rsCodBairro = var; 	} 
 public boolean getNullCodBairro() {		return nullCodBairro ; 	} 
 public void setNullCodBairro(boolean var) {		this.nullCodBairro = var; 	} 
 public String getFlagFaceuser() {		return FlagFaceuser ; 	} 
 public void setFlagFaceuser(String var) {		this.FlagFaceuser = var; 	} 
 public String getRsFlagFaceuser() {		return rsFlagFaceuser ; 	} 
 public void setRsFlagFaceuser(String var) {		this.rsFlagFaceuser = var; 	} 
 public boolean getNullFlagFaceuser() {		return nullFlagFaceuser ; 	} 
 public void setNullFlagFaceuser(boolean var) {		this.nullFlagFaceuser = var; 	} 
 public Long getIdUserFace() {		return IdUserFace ; 	} 
 public void setIdUserFace(Long var) {		this.IdUserFace = var; 	} 
 public Long getRsIdUserFace() {		return rsIdUserFace ; 	} 
 public void setRsIdUserFace(Long var) {		this.rsIdUserFace = var; 	} 
 public boolean getNullIdUserFace() {		return nullIdUserFace ; 	} 
 public void setNullIdUserFace(boolean var) {		this.nullIdUserFace = var; 	} 
 public String getFlagAtivado() {		return FlagAtivado ; 	} 
 public void setFlagAtivado(String var) {		this.FlagAtivado = var; 	} 
 public String getRsFlagAtivado() {		return rsFlagAtivado ; 	} 
 public void setRsFlagAtivado(String var) {		this.rsFlagAtivado = var; 	} 
 public boolean getNullFlagAtivado() {		return nullFlagAtivado ; 	} 
 public void setNullFlagAtivado(boolean var) {		this.nullFlagAtivado = var; 	} 
 public String getChaveAtivacao() {		return ChaveAtivacao ; 	} 
 public void setChaveAtivacao(String var) {		this.ChaveAtivacao = var; 	} 
 public String getRsChaveAtivacao() {		return rsChaveAtivacao ; 	} 
 public void setRsChaveAtivacao(String var) {		this.rsChaveAtivacao = var; 	} 
 public boolean getNullChaveAtivacao() {		return nullChaveAtivacao ; 	} 
 public void setNullChaveAtivacao(boolean var) {		this.nullChaveAtivacao = var; 	} 
 public String getDescNovoemailvalidacao() {		return DescNovoemailvalidacao ; 	} 
 public void setDescNovoemailvalidacao(String var) {		this.DescNovoemailvalidacao = var; 	} 
 public String getRsDescNovoemailvalidacao() {		return rsDescNovoemailvalidacao ; 	} 
 public void setRsDescNovoemailvalidacao(String var) {		this.rsDescNovoemailvalidacao = var; 	} 
 public boolean getNullDescNovoemailvalidacao() {		return nullDescNovoemailvalidacao ; 	} 
 public void setNullDescNovoemailvalidacao(boolean var) {		this.nullDescNovoemailvalidacao = var; 	} 
 public String getChaveAtivacaoNovoemail() {		return ChaveAtivacaoNovoemail ; 	} 
 public void setChaveAtivacaoNovoemail(String var) {		this.ChaveAtivacaoNovoemail = var; 	} 
 public String getRsChaveAtivacaoNovoemail() {		return rsChaveAtivacaoNovoemail ; 	} 
 public void setRsChaveAtivacaoNovoemail(String var) {		this.rsChaveAtivacaoNovoemail = var; 	} 
 public boolean getNullChaveAtivacaoNovoemail() {		return nullChaveAtivacaoNovoemail ; 	} 
 public void setNullChaveAtivacaoNovoemail(boolean var) {		this.nullChaveAtivacaoNovoemail = var; 	} 
 public String getFlagMaioridade() {		return FlagMaioridade ; 	} 
 public void setFlagMaioridade(String var) {		this.FlagMaioridade = var; 	} 
 public String getRsFlagMaioridade() {		return rsFlagMaioridade ; 	} 
 public void setRsFlagMaioridade(String var) {		this.rsFlagMaioridade = var; 	} 
 public boolean getNullFlagMaioridade() {		return nullFlagMaioridade ; 	} 
 public void setNullFlagMaioridade(boolean var) {		this.nullFlagMaioridade = var; 	} 
 public String getFlagLeutermos() {		return FlagLeutermos ; 	} 
 public void setFlagLeutermos(String var) {		this.FlagLeutermos = var; 	} 
 public String getRsFlagLeutermos() {		return rsFlagLeutermos ; 	} 
 public void setRsFlagLeutermos(String var) {		this.rsFlagLeutermos = var; 	} 
 public boolean getNullFlagLeutermos() {		return nullFlagLeutermos ; 	} 
 public void setNullFlagLeutermos(boolean var) {		this.nullFlagLeutermos = var; 	} 
 public String getFlagTipo() {		return FlagTipo ; 	} 
 public void setFlagTipo(String var) {		this.FlagTipo = var; 	} 
 public String getRsFlagTipo() {		return rsFlagTipo ; 	} 
 public void setRsFlagTipo(String var) {		this.rsFlagTipo = var; 	} 
 public boolean getNullFlagTipo() {		return nullFlagTipo ; 	} 
 public void setNullFlagTipo(boolean var) {		this.nullFlagTipo = var; 	} 
 
 //somente para pk single 
public Bairros  getFkCodBairro() throws Exception {  Bairros oFK = new Bairros(conn);  oFK.setCodBairro(getRsCodBairro());  oFK.lista();  oFK.next();  return oFK; } public void posicionaRs() throws Exception{ if ( getSelect() == null ) {    try {   rsIdUsuario = rs.getLong("id_usuario"); } catch (Exception e) { e.printStackTrace();  }  try {   rsDescNome = rs.getString("desc_nome"); } catch (Exception e) { e.printStackTrace();  }  try {   rsDescTelefone = rs.getString("desc_telefone"); } catch (Exception e) { e.printStackTrace();  }  try {   rsDescUser = rs.getString("desc_user"); } catch (Exception e) { e.printStackTrace();  }  try {   rsDescSenha = rs.getString("desc_senha"); } catch (Exception e) { e.printStackTrace();  }  try {   rsDescEmail = rs.getString("desc_email"); } catch (Exception e) { e.printStackTrace();  }  try {   rsCodCidade = rs.getInt("cod_cidade"); } catch (Exception e) { e.printStackTrace();  }  try {   rsDescEndereco = rs.getString("desc_endereco"); } catch (Exception e) { e.printStackTrace();  }  try {   rsDescEnderecoNum = rs.getString("desc_endereco_num"); } catch (Exception e) { e.printStackTrace();  }  try {   rsDescEnderecoComplemento = rs.getString("desc_endereco_complemento"); } catch (Exception e) { e.printStackTrace();  }  try {   rsCodBairro = rs.getInt("cod_bairro"); } catch (Exception e) { e.printStackTrace();  }  try {   rsFlagFaceuser = rs.getString("flag_faceuser"); } catch (Exception e) { e.printStackTrace();  }  try {   rsIdUserFace = rs.getLong("id_user_face"); } catch (Exception e) { e.printStackTrace();  }  try {   rsFlagAtivado = rs.getString("flag_ativado"); } catch (Exception e) { e.printStackTrace();  }  try {   rsChaveAtivacao = rs.getString("chave_ativacao"); } catch (Exception e) { e.printStackTrace();  }  try {   rsDescNovoemailvalidacao = rs.getString("desc_novoemailvalidacao"); } catch (Exception e) { e.printStackTrace();  }  try {   rsChaveAtivacaoNovoemail = rs.getString("chave_ativacao_novoemail"); } catch (Exception e) { e.printStackTrace();  }  try {   rsFlagMaioridade = rs.getString("flag_maioridade"); } catch (Exception e) { e.printStackTrace();  }  try {   rsFlagLeutermos = rs.getString("flag_leutermos"); } catch (Exception e) { e.printStackTrace();  }  try {   rsFlagTipo = rs.getString("flag_tipo"); } catch (Exception e) { e.printStackTrace();  } }  }   public boolean next(){    boolean resultado;   resultado = false;    try{ limpaRs();    resultado = rs.next();    if (resultado){ posicionaRs(); }   } catch (Exception e){    e.printStackTrace(); }     return resultado; } public void limpaRs() throws Exception{  rsIdUsuario=  null ;  rsDescNome=  null ;  rsDescTelefone=  null ;  rsDescUser=  null ;  rsDescSenha=  null ;  rsDescEmail=  null ;  rsCodCidade=  null ;  rsDescEndereco=  null ;  rsDescEnderecoNum=  null ;  rsDescEnderecoComplemento=  null ;  rsCodBairro=  null ;  rsFlagFaceuser=  null ;  rsIdUserFace=  null ;  rsFlagAtivado=  null ;  rsChaveAtivacao=  null ;  rsDescNovoemailvalidacao=  null ;  rsChaveAtivacaoNovoemail=  null ;  rsFlagMaioridade=  null ;  rsFlagLeutermos=  null ;  rsFlagTipo=  null ;   }  public ResultSet lista() throws Exception { sql = new StringBuffer(); if(getSelect()!=null){ sql.append(" select "+getSelect()+" "); }else {sql.append(" select *   "); } if(getJoin()!=null){ sql.append(" from "+getJoin()+" where  1=1 "); }else {sql.append(" from usuario where  1=1 "); } if( getIdUsuario() != null ) { sql.append(" and usuario .id_usuario = ? "); } if( getDescNome() != null ) { sql.append(" and usuario .desc_nome = ? "); } if( getDescTelefone() != null ) { sql.append(" and usuario .desc_telefone = ? "); } if( getDescUser() != null ) { sql.append(" and usuario .desc_user = ? "); } if( getDescSenha() != null ) { sql.append(" and usuario .desc_senha = ? "); } if( getDescEmail() != null ) { sql.append(" and usuario .desc_email = ? "); } if( getCodCidade() != null ) { sql.append(" and usuario .cod_cidade = ? "); } if( getDescEndereco() != null ) { sql.append(" and usuario .desc_endereco = ? "); } if( getDescEnderecoNum() != null ) { sql.append(" and usuario .desc_endereco_num = ? "); } if( getDescEnderecoComplemento() != null ) { sql.append(" and usuario .desc_endereco_complemento = ? "); } if( getCodBairro() != null ) { sql.append(" and usuario .cod_bairro = ? "); } if( getFlagFaceuser() != null ) { sql.append(" and usuario .flag_faceuser = ? "); } if( getIdUserFace() != null ) { sql.append(" and usuario .id_user_face = ? "); } if( getFlagAtivado() != null ) { sql.append(" and usuario .flag_ativado = ? "); } if( getChaveAtivacao() != null ) { sql.append(" and usuario .chave_ativacao = ? "); } if( getDescNovoemailvalidacao() != null ) { sql.append(" and usuario .desc_novoemailvalidacao = ? "); } if( getChaveAtivacaoNovoemail() != null ) { sql.append(" and usuario .chave_ativacao_novoemail = ? "); } if( getFlagMaioridade() != null ) { sql.append(" and usuario .flag_maioridade = ? "); } if( getFlagLeutermos() != null ) { sql.append(" and usuario .flag_leutermos = ? "); } if( getFlagTipo() != null ) { sql.append(" and usuario .flag_tipo = ? "); } if(getWhere()!=null){ sql.append(" and "+ getWhere()+" "); }        if(getLastSentence()!=null){ sql.append(" "+ getLastSentence()+""); }        st = conn.prepareStatement(sql.toString());  int contparam = 1;  if( getIdUsuario() != null ){ st.setLong(contparam,getIdUsuario()); contparam++;}  if( getDescNome() != null ){ st.setString(contparam,getDescNome()); contparam++;}  if( getDescTelefone() != null ){ st.setString(contparam,getDescTelefone()); contparam++;}  if( getDescUser() != null ){ st.setString(contparam,getDescUser()); contparam++;}  if( getDescSenha() != null ){ st.setString(contparam,getDescSenha()); contparam++;}  if( getDescEmail() != null ){ st.setString(contparam,getDescEmail()); contparam++;}  if( getCodCidade() != null ){ st.setInt(contparam,getCodCidade()); contparam++;}  if( getDescEndereco() != null ){ st.setString(contparam,getDescEndereco()); contparam++;}  if( getDescEnderecoNum() != null ){ st.setString(contparam,getDescEnderecoNum()); contparam++;}  if( getDescEnderecoComplemento() != null ){ st.setString(contparam,getDescEnderecoComplemento()); contparam++;}  if( getCodBairro() != null ){ st.setInt(contparam,getCodBairro()); contparam++;}  if( getFlagFaceuser() != null ){ st.setString(contparam,getFlagFaceuser()); contparam++;}  if( getIdUserFace() != null ){ st.setLong(contparam,getIdUserFace()); contparam++;}  if( getFlagAtivado() != null ){ st.setString(contparam,getFlagAtivado()); contparam++;}  if( getChaveAtivacao() != null ){ st.setString(contparam,getChaveAtivacao()); contparam++;}  if( getDescNovoemailvalidacao() != null ){ st.setString(contparam,getDescNovoemailvalidacao()); contparam++;}  if( getChaveAtivacaoNovoemail() != null ){ st.setString(contparam,getChaveAtivacaoNovoemail()); contparam++;}  if( getFlagMaioridade() != null ){ st.setString(contparam,getFlagMaioridade()); contparam++;}  if( getFlagLeutermos() != null ){ st.setString(contparam,getFlagLeutermos()); contparam++;}  if( getFlagTipo() != null ){ st.setString(contparam,getFlagTipo()); contparam++;}  	rs = st.executeQuery();  	return rs; }public void update() throws Exception {  if( getIdUsuario() == null || getIdUsuario() == 0 ) {  throw new Exception("Erro, Pk IdUsuario não setada. Update de usuario."); }sql = new StringBuffer();sql.append(" update usuario set id_usuario =  " + getIdUsuario() + "  "); if( getDescNome() != null ) { sql.append(" ,  desc_nome = ? "); } if( getNullDescNome()) { sql.append(" ,  desc_nome = null "); } if( getDescTelefone() != null ) { sql.append(" ,  desc_telefone = ? "); } if( getNullDescTelefone()) { sql.append(" ,  desc_telefone = null "); } if( getDescUser() != null ) { sql.append(" ,  desc_user = ? "); } if( getNullDescUser()) { sql.append(" ,  desc_user = null "); } if( getDescSenha() != null ) { sql.append(" ,  desc_senha = ? "); } if( getNullDescSenha()) { sql.append(" ,  desc_senha = null "); } if( getDescEmail() != null ) { sql.append(" ,  desc_email = ? "); } if( getNullDescEmail()) { sql.append(" ,  desc_email = null "); } if( getCodCidade() != null ) { sql.append(" ,  cod_cidade = ? "); } if( getNullCodCidade()) { sql.append(" ,  cod_cidade = null "); } if( getDescEndereco() != null ) { sql.append(" ,  desc_endereco = ? "); } if( getNullDescEndereco()) { sql.append(" ,  desc_endereco = null "); } if( getDescEnderecoNum() != null ) { sql.append(" ,  desc_endereco_num = ? "); } if( getNullDescEnderecoNum()) { sql.append(" ,  desc_endereco_num = null "); } if( getDescEnderecoComplemento() != null ) { sql.append(" ,  desc_endereco_complemento = ? "); } if( getNullDescEnderecoComplemento()) { sql.append(" ,  desc_endereco_complemento = null "); } if( getCodBairro() != null ) { sql.append(" ,  cod_bairro = ? "); } if( getNullCodBairro()) { sql.append(" ,  cod_bairro = null "); } if( getFlagFaceuser() != null ) { sql.append(" ,  flag_faceuser = ? "); } if( getNullFlagFaceuser()) { sql.append(" ,  flag_faceuser = null "); } if( getIdUserFace() != null ) { sql.append(" ,  id_user_face = ? "); } if( getNullIdUserFace()) { sql.append(" ,  id_user_face = null "); } if( getFlagAtivado() != null ) { sql.append(" ,  flag_ativado = ? "); } if( getNullFlagAtivado()) { sql.append(" ,  flag_ativado = null "); } if( getChaveAtivacao() != null ) { sql.append(" ,  chave_ativacao = ? "); } if( getNullChaveAtivacao()) { sql.append(" ,  chave_ativacao = null "); } if( getDescNovoemailvalidacao() != null ) { sql.append(" ,  desc_novoemailvalidacao = ? "); } if( getNullDescNovoemailvalidacao()) { sql.append(" ,  desc_novoemailvalidacao = null "); } if( getChaveAtivacaoNovoemail() != null ) { sql.append(" ,  chave_ativacao_novoemail = ? "); } if( getNullChaveAtivacaoNovoemail()) { sql.append(" ,  chave_ativacao_novoemail = null "); } if( getFlagMaioridade() != null ) { sql.append(" ,  flag_maioridade = ? "); } if( getNullFlagMaioridade()) { sql.append(" ,  flag_maioridade = null "); } if( getFlagLeutermos() != null ) { sql.append(" ,  flag_leutermos = ? "); } if( getNullFlagLeutermos()) { sql.append(" ,  flag_leutermos = null "); } if( getFlagTipo() != null ) { sql.append(" ,  flag_tipo = ? "); } if( getNullFlagTipo()) { sql.append(" ,  flag_tipo = null "); } sql.append(" where id_usuario =  " + getIdUsuario() + "  "); if(getWhere()!=null){ sql.append(" and "+ getWhere()+" "); }        st = conn.prepareStatement(sql.toString());  int contparam = 1;  if( getDescNome() != null ){ st.setString(contparam,getDescNome()); contparam++;}  if( getDescTelefone() != null ){ st.setString(contparam,getDescTelefone()); contparam++;}  if( getDescUser() != null ){ st.setString(contparam,getDescUser()); contparam++;}  if( getDescSenha() != null ){ st.setString(contparam,getDescSenha()); contparam++;}  if( getDescEmail() != null ){ st.setString(contparam,getDescEmail()); contparam++;}  if( getCodCidade() != null ){ st.setInt(contparam,getCodCidade()); contparam++;}  if( getDescEndereco() != null ){ st.setString(contparam,getDescEndereco()); contparam++;}  if( getDescEnderecoNum() != null ){ st.setString(contparam,getDescEnderecoNum()); contparam++;}  if( getDescEnderecoComplemento() != null ){ st.setString(contparam,getDescEnderecoComplemento()); contparam++;}  if( getCodBairro() != null ){ st.setInt(contparam,getCodBairro()); contparam++;}  if( getFlagFaceuser() != null ){ st.setString(contparam,getFlagFaceuser()); contparam++;}  if( getIdUserFace() != null ){ st.setLong(contparam,getIdUserFace()); contparam++;}  if( getFlagAtivado() != null ){ st.setString(contparam,getFlagAtivado()); contparam++;}  if( getChaveAtivacao() != null ){ st.setString(contparam,getChaveAtivacao()); contparam++;}  if( getDescNovoemailvalidacao() != null ){ st.setString(contparam,getDescNovoemailvalidacao()); contparam++;}  if( getChaveAtivacaoNovoemail() != null ){ st.setString(contparam,getChaveAtivacaoNovoemail()); contparam++;}  if( getFlagMaioridade() != null ){ st.setString(contparam,getFlagMaioridade()); contparam++;}  if( getFlagLeutermos() != null ){ st.setString(contparam,getFlagLeutermos()); contparam++;}  if( getFlagTipo() != null ){ st.setString(contparam,getFlagTipo()); contparam++;}  		st.executeUpdate() ;} public void delete() throws Exception { sql = new StringBuffer();sql.append(" delete from usuario "); sql.append(" where id_usuario =  " + getIdUsuario() + "  "); st = conn.prepareStatement(sql.toString());  		st.executeUpdate() ;} public void insert() throws Exception { sql = new StringBuffer();StringBuffer values = new StringBuffer();sql.append(" insert into usuario  (");values.append(" value ("); if( getDescNome() != null ) {sql.append(" , desc_nome ");values.append(", ? "); }  if( getDescTelefone() != null ) {sql.append(" , desc_telefone ");values.append(", ? "); }  if( getDescUser() != null ) {sql.append(" , desc_user ");values.append(", ? "); }  if( getDescSenha() != null ) {sql.append(" , desc_senha ");values.append(", ? "); }  if( getDescEmail() != null ) {sql.append(" , desc_email ");values.append(", ? "); }  if( getCodCidade() != null ) {sql.append(" , cod_cidade ");values.append(", ? "); }  if( getDescEndereco() != null ) {sql.append(" , desc_endereco ");values.append(", ? "); }  if( getDescEnderecoNum() != null ) {sql.append(" , desc_endereco_num ");values.append(", ? "); }  if( getDescEnderecoComplemento() != null ) {sql.append(" , desc_endereco_complemento ");values.append(", ? "); }  if( getCodBairro() != null ) {sql.append(" , cod_bairro ");values.append(", ? "); }  if( getFlagFaceuser() != null ) {sql.append(" , flag_faceuser ");values.append(", ? "); }  if( getIdUserFace() != null ) {sql.append(" , id_user_face ");values.append(", ? "); }  if( getFlagAtivado() != null ) {sql.append(" , flag_ativado ");values.append(", ? "); }  if( getChaveAtivacao() != null ) {sql.append(" , chave_ativacao ");values.append(", ? "); }  if( getDescNovoemailvalidacao() != null ) {sql.append(" , desc_novoemailvalidacao ");values.append(", ? "); }  if( getChaveAtivacaoNovoemail() != null ) {sql.append(" , chave_ativacao_novoemail ");values.append(", ? "); }  if( getFlagMaioridade() != null ) {sql.append(" , flag_maioridade ");values.append(", ? "); }  if( getFlagLeutermos() != null ) {sql.append(" , flag_leutermos ");values.append(", ? "); }  if( getFlagTipo() != null ) {sql.append(" , flag_tipo ");values.append(", ? "); } sql.append(" ) ");values.append(" ) ");sql = new StringBuffer(sql.toString().replaceFirst(",", ""));values = new StringBuffer(values.toString().replaceFirst(",", ""));sql.append( values.toString()); 	st = conn.prepareStatement(sql.toString(),Statement.RETURN_GENERATED_KEYS);  int contparam = 1;  if( getDescNome() != null ){ st.setString(contparam,getDescNome()); contparam++;  }  if( getDescTelefone() != null ){ st.setString(contparam,getDescTelefone()); contparam++;  }  if( getDescUser() != null ){ st.setString(contparam,getDescUser()); contparam++;  }  if( getDescSenha() != null ){ st.setString(contparam,getDescSenha()); contparam++;  }  if( getDescEmail() != null ){ st.setString(contparam,getDescEmail()); contparam++;  }  if( getCodCidade() != null ){ st.setInt(contparam,getCodCidade()); contparam++;  }  if( getDescEndereco() != null ){ st.setString(contparam,getDescEndereco()); contparam++;  }  if( getDescEnderecoNum() != null ){ st.setString(contparam,getDescEnderecoNum()); contparam++;  }  if( getDescEnderecoComplemento() != null ){ st.setString(contparam,getDescEnderecoComplemento()); contparam++;  }  if( getCodBairro() != null ){ st.setInt(contparam,getCodBairro()); contparam++;  }  if( getFlagFaceuser() != null ){ st.setString(contparam,getFlagFaceuser()); contparam++;  }  if( getIdUserFace() != null ){ st.setLong(contparam,getIdUserFace()); contparam++;  }  if( getFlagAtivado() != null ){ st.setString(contparam,getFlagAtivado()); contparam++;  }  if( getChaveAtivacao() != null ){ st.setString(contparam,getChaveAtivacao()); contparam++;  }  if( getDescNovoemailvalidacao() != null ){ st.setString(contparam,getDescNovoemailvalidacao()); contparam++;  }  if( getChaveAtivacaoNovoemail() != null ){ st.setString(contparam,getChaveAtivacaoNovoemail()); contparam++;  }  if( getFlagMaioridade() != null ){ st.setString(contparam,getFlagMaioridade()); contparam++;  }  if( getFlagLeutermos() != null ){ st.setString(contparam,getFlagLeutermos()); contparam++;  }  if( getFlagTipo() != null ){ st.setString(contparam,getFlagTipo()); contparam++;  }  		if (st.executeUpdate() == 1) {  	rs = st.getGeneratedKeys();  if (rs.next()){ setIdUsuario(rs.getLong(1)); } } else { throw new Exception("Erro, contate suporte. Inserção de usuario.");}}
 
 }