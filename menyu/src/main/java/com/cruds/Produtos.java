package com.cruds; 
import java.sql.Connection; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import com.funcs.Utilitario; 
import java.util.Date; 
import java.sql.Timestamp; 
import com.mysql.jdbc.Statement; 
 import com.cruds.ProdutoCustom ;  import com.cruds.Categoria ; 
public class Produtos { 

private PreparedStatement st; 
private StringBuffer sql; 
private ResultSet rs; 
private Connection conn; 
private String Where; 
private String Join; 
private String LastSentence; 
private String Select; 
public Produtos(Connection conn) { super();this.conn = conn;} 
 private Integer IdProd; 
 private Integer rsIdProd; 
 private String DescProd; 
 private String rsDescProd; 
 private  boolean  nullDescProd = false; 
 private String DescAbreviado; 
 private String rsDescAbreviado; 
 private  boolean  nullDescAbreviado = false; 
 private String FlagAtivo; 
 private String rsFlagAtivo; 
 private  boolean  nullFlagAtivo = false; 
 private Integer QtdImages; 
 private Integer rsQtdImages; 
 private  boolean  nullQtdImages = false; 
 private Integer IdCategoria; 
 private Integer rsIdCategoria; 
 private  boolean  nullIdCategoria = false; 
 private String DescKeyWords; 
 private String rsDescKeyWords; 
 private  boolean  nullDescKeyWords = false; 
 private Double ValUnit; 
 private Double rsValUnit; 
 private  boolean  nullValUnit = false; 
 private Integer IdCustom; 
 private Integer rsIdCustom; 
 private  boolean  nullIdCustom = false; 
public PreparedStatement getSt() {		return st; 	} 
 public void setSt(PreparedStatement st) {		this.st = st; 	} 
 public StringBuffer getSql() {		return sql; 	} 
 public void setSql(StringBuffer sql) {		this.sql = sql; 	} 
 public ResultSet getRs() {		return rs; 	} 
 public void setRs(ResultSet rs) {		this.rs = rs; 	} 
 public Connection getConn() {		return conn; 	} 
 public void setConn(Connection conn) {		this.conn = conn; 	}
 public String getWhere() { return this.Where; }public void setWhere(String where) { this.Where = where; }public String getJoin() {return this.Join;}public void setJoin(String join) {this.Join = join;}public String getLastSentence() {return this.LastSentence;}public void setLastSentence(String last) {this.LastSentence = last;}public String getSelect() { return this.Select; }public void setSelect(String select) { this.Select = select; }public Integer getIdProd() {		return IdProd ; 	} 
 public void setIdProd(Integer var) {		this.IdProd = var; 	} 
 public Integer getRsIdProd() {		return rsIdProd ; 	} 
 public void setRsIdProd(Integer var) {		this.rsIdProd = var; 	} 
 public String getDescProd() {		return DescProd ; 	} 
 public void setDescProd(String var) {		this.DescProd = var; 	} 
 public String getRsDescProd() {		return rsDescProd ; 	} 
 public void setRsDescProd(String var) {		this.rsDescProd = var; 	} 
 public boolean getNullDescProd() {		return nullDescProd ; 	} 
 public void setNullDescProd(boolean var) {		this.nullDescProd = var; 	} 
 public String getDescAbreviado() {		return DescAbreviado ; 	} 
 public void setDescAbreviado(String var) {		this.DescAbreviado = var; 	} 
 public String getRsDescAbreviado() {		return rsDescAbreviado ; 	} 
 public void setRsDescAbreviado(String var) {		this.rsDescAbreviado = var; 	} 
 public boolean getNullDescAbreviado() {		return nullDescAbreviado ; 	} 
 public void setNullDescAbreviado(boolean var) {		this.nullDescAbreviado = var; 	} 
 public String getFlagAtivo() {		return FlagAtivo ; 	} 
 public void setFlagAtivo(String var) {		this.FlagAtivo = var; 	} 
 public String getRsFlagAtivo() {		return rsFlagAtivo ; 	} 
 public void setRsFlagAtivo(String var) {		this.rsFlagAtivo = var; 	} 
 public boolean getNullFlagAtivo() {		return nullFlagAtivo ; 	} 
 public void setNullFlagAtivo(boolean var) {		this.nullFlagAtivo = var; 	} 
 public Integer getQtdImages() {		return QtdImages ; 	} 
 public void setQtdImages(Integer var) {		this.QtdImages = var; 	} 
 public Integer getRsQtdImages() {		return rsQtdImages ; 	} 
 public void setRsQtdImages(Integer var) {		this.rsQtdImages = var; 	} 
 public boolean getNullQtdImages() {		return nullQtdImages ; 	} 
 public void setNullQtdImages(boolean var) {		this.nullQtdImages = var; 	} 
 public Integer getIdCategoria() {		return IdCategoria ; 	} 
 public void setIdCategoria(Integer var) {		this.IdCategoria = var; 	} 
 public Integer getRsIdCategoria() {		return rsIdCategoria ; 	} 
 public void setRsIdCategoria(Integer var) {		this.rsIdCategoria = var; 	} 
 public boolean getNullIdCategoria() {		return nullIdCategoria ; 	} 
 public void setNullIdCategoria(boolean var) {		this.nullIdCategoria = var; 	} 
 public String getDescKeyWords() {		return DescKeyWords ; 	} 
 public void setDescKeyWords(String var) {		this.DescKeyWords = var; 	} 
 public String getRsDescKeyWords() {		return rsDescKeyWords ; 	} 
 public void setRsDescKeyWords(String var) {		this.rsDescKeyWords = var; 	} 
 public boolean getNullDescKeyWords() {		return nullDescKeyWords ; 	} 
 public void setNullDescKeyWords(boolean var) {		this.nullDescKeyWords = var; 	} 
 public Double getValUnit() {		return ValUnit ; 	} 
 public void setValUnit(Double var) {		this.ValUnit = var; 	} 
 public Double getRsValUnit() {		return rsValUnit ; 	} 
 public void setRsValUnit(Double var) {		this.rsValUnit = var; 	} 
 public boolean getNullValUnit() {		return nullValUnit ; 	} 
 public void setNullValUnit(boolean var) {		this.nullValUnit = var; 	} 
 public Integer getIdCustom() {		return IdCustom ; 	} 
 public void setIdCustom(Integer var) {		this.IdCustom = var; 	} 
 public Integer getRsIdCustom() {		return rsIdCustom ; 	} 
 public void setRsIdCustom(Integer var) {		this.rsIdCustom = var; 	} 
 public boolean getNullIdCustom() {		return nullIdCustom ; 	} 
 public void setNullIdCustom(boolean var) {		this.nullIdCustom = var; 	} 
 public Categoria  getFkIdCategoria() throws Exception {  Categoria oFK = new Categoria(conn);  oFK.setIdCategoria(getRsIdCategoria());  oFK.lista();  oFK.next();  return oFK; }public ProdutoCustom  getFkIdCustom() throws Exception {  ProdutoCustom oFK = new ProdutoCustom(conn);  oFK.setIdCustom(getRsIdCustom());  oFK.lista();  oFK.next();  return oFK; } public void posicionaRs() throws Exception{ if ( getSelect() == null ) {    try {   rsIdProd = rs.getInt("id_prod"); } catch (Exception e) { e.printStackTrace();  }  try {   rsDescProd = rs.getString("desc_prod"); } catch (Exception e) { e.printStackTrace();  }  try {   rsDescAbreviado = rs.getString("desc_abreviado"); } catch (Exception e) { e.printStackTrace();  }  try {   rsFlagAtivo = rs.getString("flag_ativo"); } catch (Exception e) { e.printStackTrace();  }  try {   rsQtdImages = rs.getInt("qtd_images"); } catch (Exception e) { e.printStackTrace();  }  try {   rsIdCategoria = rs.getInt("id_categoria"); } catch (Exception e) { e.printStackTrace();  }  try {   rsDescKeyWords = rs.getString("desc_key_words"); } catch (Exception e) { e.printStackTrace();  }  try {   rsValUnit = rs.getDouble("val_unit"); } catch (Exception e) { e.printStackTrace();  }  try {   rsIdCustom = rs.getInt("id_custom"); } catch (Exception e) { e.printStackTrace();  } }  }   public boolean next(){    boolean resultado;   resultado = false;    try{ limpaRs();    resultado = rs.next();    if (resultado){ posicionaRs(); }   } catch (Exception e){    e.printStackTrace(); }     return resultado; } public void limpaRs() throws Exception{  rsIdProd=  null ;  rsDescProd=  null ;  rsDescAbreviado=  null ;  rsFlagAtivo=  null ;  rsQtdImages=  null ;  rsIdCategoria=  null ;  rsDescKeyWords=  null ;  rsValUnit=  null ;  rsIdCustom=  null ;   }  public ResultSet lista() throws Exception { sql = new StringBuffer(); if(getSelect()!=null){ sql.append(" select "+getSelect()+" "); }else {sql.append(" select *   "); } if(getJoin()!=null){ sql.append(" from "+getJoin()+" where  1=1 "); }else {sql.append(" from produtos where  1=1 "); } if( getIdProd() != null ) { sql.append(" and produtos .id_prod = ? "); } if( getDescProd() != null ) { sql.append(" and produtos .desc_prod = ? "); } if( getDescAbreviado() != null ) { sql.append(" and produtos .desc_abreviado = ? "); } if( getFlagAtivo() != null ) { sql.append(" and produtos .flag_ativo = ? "); } if( getQtdImages() != null ) { sql.append(" and produtos .qtd_images = ? "); } if( getIdCategoria() != null ) { sql.append(" and produtos .id_categoria = ? "); } if( getDescKeyWords() != null ) { sql.append(" and produtos .desc_key_words = ? "); } if( getValUnit() != null ) { sql.append(" and produtos .val_unit = ? "); } if( getIdCustom() != null ) { sql.append(" and produtos .id_custom = ? "); } if(getWhere()!=null){ sql.append(" and "+ getWhere()+" "); }        if(getLastSentence()!=null){ sql.append(" "+ getLastSentence()+""); }        st = conn.prepareStatement(sql.toString());  int contparam = 1;  if( getIdProd() != null ){ st.setInt(contparam,getIdProd()); contparam++;}  if( getDescProd() != null ){ st.setString(contparam,getDescProd()); contparam++;}  if( getDescAbreviado() != null ){ st.setString(contparam,getDescAbreviado()); contparam++;}  if( getFlagAtivo() != null ){ st.setString(contparam,getFlagAtivo()); contparam++;}  if( getQtdImages() != null ){ st.setInt(contparam,getQtdImages()); contparam++;}  if( getIdCategoria() != null ){ st.setInt(contparam,getIdCategoria()); contparam++;}  if( getDescKeyWords() != null ){ st.setString(contparam,getDescKeyWords()); contparam++;}  if( getValUnit() != null ){ st.setDouble(contparam,getValUnit()); contparam++;}  if( getIdCustom() != null ){ st.setInt(contparam,getIdCustom()); contparam++;}  	rs = st.executeQuery();  	return rs; }public void update() throws Exception {  if( getIdProd() == null || getIdProd() == 0 ) {  throw new Exception("Erro, Pk IdProd não setada. Update de produtos."); }sql = new StringBuffer();sql.append(" update produtos set id_prod =  " + getIdProd() + "  "); if( getDescProd() != null ) { sql.append(" ,  desc_prod = ? "); } if( getNullDescProd()) { sql.append(" ,  desc_prod = null "); } if( getDescAbreviado() != null ) { sql.append(" ,  desc_abreviado = ? "); } if( getNullDescAbreviado()) { sql.append(" ,  desc_abreviado = null "); } if( getFlagAtivo() != null ) { sql.append(" ,  flag_ativo = ? "); } if( getNullFlagAtivo()) { sql.append(" ,  flag_ativo = null "); } if( getQtdImages() != null ) { sql.append(" ,  qtd_images = ? "); } if( getNullQtdImages()) { sql.append(" ,  qtd_images = null "); } if( getIdCategoria() != null ) { sql.append(" ,  id_categoria = ? "); } if( getNullIdCategoria()) { sql.append(" ,  id_categoria = null "); } if( getDescKeyWords() != null ) { sql.append(" ,  desc_key_words = ? "); } if( getNullDescKeyWords()) { sql.append(" ,  desc_key_words = null "); } if( getValUnit() != null ) { sql.append(" ,  val_unit = ? "); } if( getNullValUnit()) { sql.append(" ,  val_unit = null "); } if( getIdCustom() != null ) { sql.append(" ,  id_custom = ? "); } if( getNullIdCustom()) { sql.append(" ,  id_custom = null "); } sql.append(" where id_prod =  " + getIdProd() + "  "); if(getWhere()!=null){ sql.append(" and "+ getWhere()+" "); }        st = conn.prepareStatement(sql.toString());  int contparam = 1;  if( getDescProd() != null ){ st.setString(contparam,getDescProd()); contparam++;}  if( getDescAbreviado() != null ){ st.setString(contparam,getDescAbreviado()); contparam++;}  if( getFlagAtivo() != null ){ st.setString(contparam,getFlagAtivo()); contparam++;}  if( getQtdImages() != null ){ st.setInt(contparam,getQtdImages()); contparam++;}  if( getIdCategoria() != null ){ st.setInt(contparam,getIdCategoria()); contparam++;}  if( getDescKeyWords() != null ){ st.setString(contparam,getDescKeyWords()); contparam++;}  if( getValUnit() != null ){ st.setDouble(contparam,getValUnit()); contparam++;}  if( getIdCustom() != null ){ st.setInt(contparam,getIdCustom()); contparam++;}  		st.executeUpdate() ;} public void delete() throws Exception { sql = new StringBuffer();sql.append(" delete from produtos "); sql.append(" where id_prod =  " + getIdProd() + "  "); st = conn.prepareStatement(sql.toString());  		st.executeUpdate() ;} public void insert() throws Exception { sql = new StringBuffer();StringBuffer values = new StringBuffer();sql.append(" insert into produtos  (");values.append(" value ("); if( getDescProd() != null ) {sql.append(" , desc_prod ");values.append(", ? "); }  if( getDescAbreviado() != null ) {sql.append(" , desc_abreviado ");values.append(", ? "); }  if( getFlagAtivo() != null ) {sql.append(" , flag_ativo ");values.append(", ? "); }  if( getQtdImages() != null ) {sql.append(" , qtd_images ");values.append(", ? "); }  if( getIdCategoria() != null ) {sql.append(" , id_categoria ");values.append(", ? "); }  if( getDescKeyWords() != null ) {sql.append(" , desc_key_words ");values.append(", ? "); }  if( getValUnit() != null ) {sql.append(" , val_unit ");values.append(", ? "); }  if( getIdCustom() != null ) {sql.append(" , id_custom ");values.append(", ? "); } sql.append(" ) ");values.append(" ) ");sql = new StringBuffer(sql.toString().replaceFirst(",", ""));values = new StringBuffer(values.toString().replaceFirst(",", ""));sql.append( values.toString()); 	st = conn.prepareStatement(sql.toString(),Statement.RETURN_GENERATED_KEYS);  int contparam = 1;  if( getDescProd() != null ){ st.setString(contparam,getDescProd()); contparam++;  }  if( getDescAbreviado() != null ){ st.setString(contparam,getDescAbreviado()); contparam++;  }  if( getFlagAtivo() != null ){ st.setString(contparam,getFlagAtivo()); contparam++;  }  if( getQtdImages() != null ){ st.setInt(contparam,getQtdImages()); contparam++;  }  if( getIdCategoria() != null ){ st.setInt(contparam,getIdCategoria()); contparam++;  }  if( getDescKeyWords() != null ){ st.setString(contparam,getDescKeyWords()); contparam++;  }  if( getValUnit() != null ){ st.setDouble(contparam,getValUnit()); contparam++;  }  if( getIdCustom() != null ){ st.setInt(contparam,getIdCustom()); contparam++;  }  		if (st.executeUpdate() == 1) {  	rs = st.getGeneratedKeys();  if (rs.next()){ setIdProd(rs.getInt(1)); } } else { throw new Exception("Erro, contate suporte. Inserção de produtos.");}}
 
 }