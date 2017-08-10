package com.phpdao.domain; 
import java.sql.Connection; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import com.funcs.Utilitario; 
import java.util.Date; 
import java.sql.Timestamp; 

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
 private Integer CodCidade; 
 private Integer rsCodCidade; 
 private  boolean  nullCodCidade = false; 
 private String DescNome; 
 private String rsDescNome; 
 private  boolean  nullDescNome = false; 
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
 private String FlagAtivo; 
 private String rsFlagAtivo; 
 private  boolean  nullFlagAtivo = false; 
 private Timestamp DateLastajax; 
 private Timestamp rsDateLastajax; 
 private  boolean  nullDateLastajax = false; 
 private String NumCpf; 
 private String rsNumCpf; 
 private  boolean  nullNumCpf = false; 
 private String DescCep; 
 private String rsDescCep; 
 private  boolean  nullDescCep = false; 
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
 public Integer getCodCidade() {		return CodCidade ; 	} 
 public void setCodCidade(Integer var) {		this.CodCidade = var; 	} 
 public Integer getRsCodCidade() {		return rsCodCidade ; 	} 
 public void setRsCodCidade(Integer var) {		this.rsCodCidade = var; 	} 
 public boolean getNullCodCidade() {		return nullCodCidade ; 	} 
 public void setNullCodCidade(boolean var) {		this.nullCodCidade = var; 	} 
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
 public String getNumCpf() {		return NumCpf ; 	} 
 public void setNumCpf(String var) {		this.NumCpf = var; 	} 
 public String getRsNumCpf() {		return rsNumCpf ; 	} 
 public void setRsNumCpf(String var) {		this.rsNumCpf = var; 	} 
 public boolean getNullNumCpf() {		return nullNumCpf ; 	} 
 public void setNullNumCpf(boolean var) {		this.nullNumCpf = var; 	} 
 public String getDescCep() {		return DescCep ; 	} 
 public void setDescCep(String var) {		this.DescCep = var; 	} 
 public String getRsDescCep() {		return rsDescCep ; 	} 
 public void setRsDescCep(String var) {		this.rsDescCep = var; 	} 
 public boolean getNullDescCep() {		return nullDescCep ; 	} 
 public void setNullDescCep(boolean var) {		this.nullDescCep = var; 	} 
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
  public void posicionaRs() throws Exception{ if ( getSelect() == null ) {    try {   rsIdUsuario = rs.getLong("id_usuario"); } catch (Exception e) { e.printStackTrace();  }  try {   rsCodCidade = rs.getInt("cod_cidade"); } catch (Exception e) { e.printStackTrace();  }  try {   rsDescNome = rs.getString("desc_nome"); } catch (Exception e) { e.printStackTrace();  }  try {   rsDescTelefone = rs.getString("desc_telefone"); } catch (Exception e) { e.printStackTrace();  }  try {   rsDescEndereco = rs.getString("desc_endereco"); } catch (Exception e) { e.printStackTrace();  }  try {   rsNumEnderec = rs.getString("num_enderec"); } catch (Exception e) { e.printStackTrace();  }  try {   rsDescComplemento = rs.getString("desc_complemento"); } catch (Exception e) { e.printStackTrace();  }  try {   rsDescLogin = rs.getString("desc_login"); } catch (Exception e) { e.printStackTrace();  }  try {   rsDescSenha = rs.getString("desc_senha"); } catch (Exception e) { e.printStackTrace();  }  try {   rsDescMail = rs.getString("desc_mail"); } catch (Exception e) { e.printStackTrace();  }  try {   rsFlagAtivo = rs.getString("flag_ativo"); } catch (Exception e) { e.printStackTrace();  }  try {   rsDateLastajax = rs.getTimestamp("date_lastajax"); } catch (Exception e) { e.printStackTrace();  }  try {   rsNumCpf = rs.getString("num_cpf"); } catch (Exception e) { e.printStackTrace();  }  try {   rsDescCep = rs.getString("desc_cep"); } catch (Exception e) { e.printStackTrace();  }  try {   rsFlagAtivado = rs.getString("flag_ativado"); } catch (Exception e) { e.printStackTrace();  }  try {   rsChaveAtivacao = rs.getString("chave_ativacao"); } catch (Exception e) { e.printStackTrace();  }  try {   rsDescNovoemailvalidacao = rs.getString("desc_novoemailvalidacao"); } catch (Exception e) { e.printStackTrace();  }  try {   rsChaveAtivacaoNovoemail = rs.getString("chave_ativacao_novoemail"); } catch (Exception e) { e.printStackTrace();  } }  }   public boolean next(){    boolean resultado;   resultado = false;    try{ limpaRs();    resultado = rs.next();    if (resultado){ posicionaRs(); }   } catch (Exception e){    e.printStackTrace(); }     return resultado; } public void limpaRs() throws Exception{  rsIdUsuario=  null ;  rsCodCidade=  null ;  rsDescNome=  null ;  rsDescTelefone=  null ;  rsDescEndereco=  null ;  rsNumEnderec=  null ;  rsDescComplemento=  null ;  rsDescLogin=  null ;  rsDescSenha=  null ;  rsDescMail=  null ;  rsFlagAtivo=  null ;  rsDateLastajax=  null ;  rsNumCpf=  null ;  rsDescCep=  null ;  rsFlagAtivado=  null ;  rsChaveAtivacao=  null ;  rsDescNovoemailvalidacao=  null ;  rsChaveAtivacaoNovoemail=  null ;   }  public ResultSet lista() throws Exception { sql = new StringBuffer(); if(getSelect()!=null){ sql.append(" select "+getSelect()+" "); }else {sql.append(" select * from usuario  "); } if(getJoin()!=null){ sql.append(" from "+getJoin()+" where  1=1 "); }else {sql.append(" from usuario where  1=1 "); } if( getIdUsuario() != null ) { sql.append(" and usuario .id_usuario = ? "); } if( getCodCidade() != null ) { sql.append(" and usuario .cod_cidade = ? "); } if( getDescNome() != null ) { sql.append(" and usuario .desc_nome = ? "); } if( getDescTelefone() != null ) { sql.append(" and usuario .desc_telefone = ? "); } if( getDescEndereco() != null ) { sql.append(" and usuario .desc_endereco = ? "); } if( getNumEnderec() != null ) { sql.append(" and usuario .num_enderec = ? "); } if( getDescComplemento() != null ) { sql.append(" and usuario .desc_complemento = ? "); } if( getDescLogin() != null ) { sql.append(" and usuario .desc_login = ? "); } if( getDescSenha() != null ) { sql.append(" and usuario .desc_senha = ? "); } if( getDescMail() != null ) { sql.append(" and usuario .desc_mail = ? "); } if( getFlagAtivo() != null ) { sql.append(" and usuario .flag_ativo = ? "); } if( getDateLastajax() != null ) { sql.append(" and usuario .date_lastajax = ? "); } if( getNumCpf() != null ) { sql.append(" and usuario .num_cpf = ? "); } if( getDescCep() != null ) { sql.append(" and usuario .desc_cep = ? "); } if( getFlagAtivado() != null ) { sql.append(" and usuario .flag_ativado = ? "); } if( getChaveAtivacao() != null ) { sql.append(" and usuario .chave_ativacao = ? "); } if( getDescNovoemailvalidacao() != null ) { sql.append(" and usuario .desc_novoemailvalidacao = ? "); } if( getChaveAtivacaoNovoemail() != null ) { sql.append(" and usuario .chave_ativacao_novoemail = ? "); } if(getWhere()!=null){ sql.append(" and "+ getWhere()+" "); }        if(getLastSentence()!=null){ sql.append(" "+ getLastSentence()+""); }        st = conn.prepareStatement(sql.toString());  int contparam = 1;  if( getIdUsuario() != null ){ st.setLong(contparam,getIdUsuario()); contparam++;}  if( getCodCidade() != null ){ st.setInt(contparam,getCodCidade()); contparam++;}  if( getDescNome() != null ){ st.setString(contparam,getDescNome()); contparam++;}  if( getDescTelefone() != null ){ st.setString(contparam,getDescTelefone()); contparam++;}  if( getDescEndereco() != null ){ st.setString(contparam,getDescEndereco()); contparam++;}  if( getNumEnderec() != null ){ st.setString(contparam,getNumEnderec()); contparam++;}  if( getDescComplemento() != null ){ st.setString(contparam,getDescComplemento()); contparam++;}  if( getDescLogin() != null ){ st.setString(contparam,getDescLogin()); contparam++;}  if( getDescSenha() != null ){ st.setString(contparam,getDescSenha()); contparam++;}  if( getDescMail() != null ){ st.setString(contparam,getDescMail()); contparam++;}  if( getFlagAtivo() != null ){ st.setString(contparam,getFlagAtivo()); contparam++;}  if( getDateLastajax() != null ){ st.setTimestamp(contparam,getDateLastajax()); contparam++;}  if( getNumCpf() != null ){ st.setString(contparam,getNumCpf()); contparam++;}  if( getDescCep() != null ){ st.setString(contparam,getDescCep()); contparam++;}  if( getFlagAtivado() != null ){ st.setString(contparam,getFlagAtivado()); contparam++;}  if( getChaveAtivacao() != null ){ st.setString(contparam,getChaveAtivacao()); contparam++;}  if( getDescNovoemailvalidacao() != null ){ st.setString(contparam,getDescNovoemailvalidacao()); contparam++;}  if( getChaveAtivacaoNovoemail() != null ){ st.setString(contparam,getChaveAtivacaoNovoemail()); contparam++;}  	rs = st.executeQuery();  	return rs; }public void update() throws Exception { sql = new StringBuffer();sql.append(" update usuario set id_usuario =  " + getIdUsuario() + "  "); if( getCodCidade() != null ) { sql.append(" ,  cod_cidade = ? "); } if( getNullCodCidade()) { sql.append(" ,  cod_cidade = null "); } if( getDescNome() != null ) { sql.append(" ,  desc_nome = ? "); } if( getNullDescNome()) { sql.append(" ,  desc_nome = null "); } if( getDescTelefone() != null ) { sql.append(" ,  desc_telefone = ? "); } if( getNullDescTelefone()) { sql.append(" ,  desc_telefone = null "); } if( getDescEndereco() != null ) { sql.append(" ,  desc_endereco = ? "); } if( getNullDescEndereco()) { sql.append(" ,  desc_endereco = null "); } if( getNumEnderec() != null ) { sql.append(" ,  num_enderec = ? "); } if( getNullNumEnderec()) { sql.append(" ,  num_enderec = null "); } if( getDescComplemento() != null ) { sql.append(" ,  desc_complemento = ? "); } if( getNullDescComplemento()) { sql.append(" ,  desc_complemento = null "); } if( getDescLogin() != null ) { sql.append(" ,  desc_login = ? "); } if( getNullDescLogin()) { sql.append(" ,  desc_login = null "); } if( getDescSenha() != null ) { sql.append(" ,  desc_senha = ? "); } if( getNullDescSenha()) { sql.append(" ,  desc_senha = null "); } if( getDescMail() != null ) { sql.append(" ,  desc_mail = ? "); } if( getNullDescMail()) { sql.append(" ,  desc_mail = null "); } if( getFlagAtivo() != null ) { sql.append(" ,  flag_ativo = ? "); } if( getNullFlagAtivo()) { sql.append(" ,  flag_ativo = null "); } if( getDateLastajax() != null ) { sql.append(" ,  date_lastajax = ? "); } if( getNullDateLastajax()) { sql.append(" ,  date_lastajax = null "); } if( getNumCpf() != null ) { sql.append(" ,  num_cpf = ? "); } if( getNullNumCpf()) { sql.append(" ,  num_cpf = null "); } if( getDescCep() != null ) { sql.append(" ,  desc_cep = ? "); } if( getNullDescCep()) { sql.append(" ,  desc_cep = null "); } if( getFlagAtivado() != null ) { sql.append(" ,  flag_ativado = ? "); } if( getNullFlagAtivado()) { sql.append(" ,  flag_ativado = null "); } if( getChaveAtivacao() != null ) { sql.append(" ,  chave_ativacao = ? "); } if( getNullChaveAtivacao()) { sql.append(" ,  chave_ativacao = null "); } if( getDescNovoemailvalidacao() != null ) { sql.append(" ,  desc_novoemailvalidacao = ? "); } if( getNullDescNovoemailvalidacao()) { sql.append(" ,  desc_novoemailvalidacao = null "); } if( getChaveAtivacaoNovoemail() != null ) { sql.append(" ,  chave_ativacao_novoemail = ? "); } if( getNullChaveAtivacaoNovoemail()) { sql.append(" ,  chave_ativacao_novoemail = null "); } sql.append(" where id_usuario =  " + getIdUsuario() + "  "); if(getWhere()!=null){ sql.append(" and "+ getWhere()+" "); }        st = conn.prepareStatement(sql.toString());  int contparam = 1;  if( getCodCidade() != null ){ st.setInt(contparam,getCodCidade()); contparam++;}  if( getDescNome() != null ){ st.setString(contparam,getDescNome()); contparam++;}  if( getDescTelefone() != null ){ st.setString(contparam,getDescTelefone()); contparam++;}  if( getDescEndereco() != null ){ st.setString(contparam,getDescEndereco()); contparam++;}  if( getNumEnderec() != null ){ st.setString(contparam,getNumEnderec()); contparam++;}  if( getDescComplemento() != null ){ st.setString(contparam,getDescComplemento()); contparam++;}  if( getDescLogin() != null ){ st.setString(contparam,getDescLogin()); contparam++;}  if( getDescSenha() != null ){ st.setString(contparam,getDescSenha()); contparam++;}  if( getDescMail() != null ){ st.setString(contparam,getDescMail()); contparam++;}  if( getFlagAtivo() != null ){ st.setString(contparam,getFlagAtivo()); contparam++;}  if( getDateLastajax() != null ){ st.setTimestamp(contparam,getDateLastajax()); contparam++;}  if( getNumCpf() != null ){ st.setString(contparam,getNumCpf()); contparam++;}  if( getDescCep() != null ){ st.setString(contparam,getDescCep()); contparam++;}  if( getFlagAtivado() != null ){ st.setString(contparam,getFlagAtivado()); contparam++;}  if( getChaveAtivacao() != null ){ st.setString(contparam,getChaveAtivacao()); contparam++;}  if( getDescNovoemailvalidacao() != null ){ st.setString(contparam,getDescNovoemailvalidacao()); contparam++;}  if( getChaveAtivacaoNovoemail() != null ){ st.setString(contparam,getChaveAtivacaoNovoemail()); contparam++;}  		st.executeUpdate() ;} public void delete() throws Exception { sql = new StringBuffer();sql.append(" delete from usuario "); sql.append(" where id_usuario =  " + getIdUsuario() + "  "); st = conn.prepareStatement(sql.toString());  		st.executeUpdate() ;} public void insert() throws Exception { sql = new StringBuffer();StringBuffer values = new StringBuffer();sql.append(" insert into usuario  (id_usuario " );values.append(" value (? "); if( getIdUsuario() != null ) {sql.append(" , id_usuario ");values.append(", ? "); }  if( getCodCidade() != null ) {sql.append(" , cod_cidade ");values.append(", ? "); }  if( getDescNome() != null ) {sql.append(" , desc_nome ");values.append(", ? "); }  if( getDescTelefone() != null ) {sql.append(" , desc_telefone ");values.append(", ? "); }  if( getDescEndereco() != null ) {sql.append(" , desc_endereco ");values.append(", ? "); }  if( getNumEnderec() != null ) {sql.append(" , num_enderec ");values.append(", ? "); }  if( getDescComplemento() != null ) {sql.append(" , desc_complemento ");values.append(", ? "); }  if( getDescLogin() != null ) {sql.append(" , desc_login ");values.append(", ? "); }  if( getDescSenha() != null ) {sql.append(" , desc_senha ");values.append(", ? "); }  if( getDescMail() != null ) {sql.append(" , desc_mail ");values.append(", ? "); }  if( getFlagAtivo() != null ) {sql.append(" , flag_ativo ");values.append(", ? "); }  if( getDateLastajax() != null ) {sql.append(" , date_lastajax ");values.append(", ? "); }  if( getNumCpf() != null ) {sql.append(" , num_cpf ");values.append(", ? "); }  if( getDescCep() != null ) {sql.append(" , desc_cep ");values.append(", ? "); }  if( getFlagAtivado() != null ) {sql.append(" , flag_ativado ");values.append(", ? "); }  if( getChaveAtivacao() != null ) {sql.append(" , chave_ativacao ");values.append(", ? "); }  if( getDescNovoemailvalidacao() != null ) {sql.append(" , desc_novoemailvalidacao ");values.append(", ? "); }  if( getChaveAtivacaoNovoemail() != null ) {sql.append(" , chave_ativacao_novoemail ");values.append(", ? "); } sql.append(" ) ");values.append(" ) ");sql.append( values.toString()); 	st = conn.prepareStatement(sql.toString());   long id = 	 Utilitario.retornaIdinsertLong	 ("usuario", "id_usuario", conn); int contparam = 1;  st.setLong(contparam, id); contparam++;  if( getCodCidade() != null ){ st.setInt(contparam,getCodCidade()); contparam++;  }  if( getDescNome() != null ){ st.setString(contparam,getDescNome()); contparam++;  }  if( getDescTelefone() != null ){ st.setString(contparam,getDescTelefone()); contparam++;  }  if( getDescEndereco() != null ){ st.setString(contparam,getDescEndereco()); contparam++;  }  if( getNumEnderec() != null ){ st.setString(contparam,getNumEnderec()); contparam++;  }  if( getDescComplemento() != null ){ st.setString(contparam,getDescComplemento()); contparam++;  }  if( getDescLogin() != null ){ st.setString(contparam,getDescLogin()); contparam++;  }  if( getDescSenha() != null ){ st.setString(contparam,getDescSenha()); contparam++;  }  if( getDescMail() != null ){ st.setString(contparam,getDescMail()); contparam++;  }  if( getFlagAtivo() != null ){ st.setString(contparam,getFlagAtivo()); contparam++;  }  if( getDateLastajax() != null ){ st.setTimestamp(contparam,getDateLastajax()); contparam++;  }  if( getNumCpf() != null ){ st.setString(contparam,getNumCpf()); contparam++;  }  if( getDescCep() != null ){ st.setString(contparam,getDescCep()); contparam++;  }  if( getFlagAtivado() != null ){ st.setString(contparam,getFlagAtivado()); contparam++;  }  if( getChaveAtivacao() != null ){ st.setString(contparam,getChaveAtivacao()); contparam++;  }  if( getDescNovoemailvalidacao() != null ){ st.setString(contparam,getDescNovoemailvalidacao()); contparam++;  }  if( getChaveAtivacaoNovoemail() != null ){ st.setString(contparam,getChaveAtivacaoNovoemail()); contparam++;  }  		if (st.executeUpdate() == 1) { setIdUsuario(id);} else { throw new Exception("Erro, contate suporte. Inserção de usuario.");}}
 
 }