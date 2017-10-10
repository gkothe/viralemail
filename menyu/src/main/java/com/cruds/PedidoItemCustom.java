package com.cruds; 
import java.sql.Connection; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import com.funcs.Utilitario; 
import java.util.Date; 
import java.sql.Timestamp; 
import com.mysql.jdbc.Statement; 
 import com.cruds.PedidoItem ;  import com.cruds.PedidoItem ;  import com.cruds.ProdutoCustomItem ;  import com.cruds.ProdutoCustomItem ;  import com.cruds.Produtos ; 
public class PedidoItemCustom { 

private PreparedStatement st; 
private StringBuffer sql; 
private ResultSet rs; 
private Connection conn; 
private String Where; 
private String Join; 
private String LastSentence; 
private String Select; 
public PedidoItemCustom(Connection conn) { super();this.conn = conn;} 
 private Long IdCustomPedido; 
 private Long rsIdCustomPedido; 
 private Long IdPedido; 
 private Long rsIdPedido; 
 private  boolean  nullIdPedido = false; 
 private Integer SeqItem; 
 private Integer rsSeqItem; 
 private  boolean  nullSeqItem = false; 
 private Integer IdProd; 
 private Integer rsIdProd; 
 private  boolean  nullIdProd = false; 
 private String ValFlag; 
 private String rsValFlag; 
 private  boolean  nullValFlag = false; 
 private Double ValItem; 
 private Double rsValItem; 
 private  boolean  nullValItem = false; 
 private Integer IdCustom; 
 private Integer rsIdCustom; 
 private  boolean  nullIdCustom = false; 
 private Integer SeqItemCustom; 
 private Integer rsSeqItemCustom; 
 private  boolean  nullSeqItemCustom = false; 
public PreparedStatement getSt() {		return st; 	} 
 public void setSt(PreparedStatement st) {		this.st = st; 	} 
 public StringBuffer getSql() {		return sql; 	} 
 public void setSql(StringBuffer sql) {		this.sql = sql; 	} 
 public ResultSet getRs() {		return rs; 	} 
 public void setRs(ResultSet rs) {		this.rs = rs; 	} 
 public Connection getConn() {		return conn; 	} 
 public void setConn(Connection conn) {		this.conn = conn; 	}
 public String getWhere() { return this.Where; }public void setWhere(String where) { this.Where = where; }public String getJoin() {return this.Join;}public void setJoin(String join) {this.Join = join;}public String getLastSentence() {return this.LastSentence;}public void setLastSentence(String last) {this.LastSentence = last;}public String getSelect() { return this.Select; }public void setSelect(String select) { this.Select = select; }public Long getIdCustomPedido() {		return IdCustomPedido ; 	} 
 public void setIdCustomPedido(Long var) {		this.IdCustomPedido = var; 	} 
 public Long getRsIdCustomPedido() {		return rsIdCustomPedido ; 	} 
 public void setRsIdCustomPedido(Long var) {		this.rsIdCustomPedido = var; 	} 
 public Long getIdPedido() {		return IdPedido ; 	} 
 public void setIdPedido(Long var) {		this.IdPedido = var; 	} 
 public Long getRsIdPedido() {		return rsIdPedido ; 	} 
 public void setRsIdPedido(Long var) {		this.rsIdPedido = var; 	} 
 public boolean getNullIdPedido() {		return nullIdPedido ; 	} 
 public void setNullIdPedido(boolean var) {		this.nullIdPedido = var; 	} 
 public Integer getSeqItem() {		return SeqItem ; 	} 
 public void setSeqItem(Integer var) {		this.SeqItem = var; 	} 
 public Integer getRsSeqItem() {		return rsSeqItem ; 	} 
 public void setRsSeqItem(Integer var) {		this.rsSeqItem = var; 	} 
 public boolean getNullSeqItem() {		return nullSeqItem ; 	} 
 public void setNullSeqItem(boolean var) {		this.nullSeqItem = var; 	} 
 public Integer getIdProd() {		return IdProd ; 	} 
 public void setIdProd(Integer var) {		this.IdProd = var; 	} 
 public Integer getRsIdProd() {		return rsIdProd ; 	} 
 public void setRsIdProd(Integer var) {		this.rsIdProd = var; 	} 
 public boolean getNullIdProd() {		return nullIdProd ; 	} 
 public void setNullIdProd(boolean var) {		this.nullIdProd = var; 	} 
 public String getValFlag() {		return ValFlag ; 	} 
 public void setValFlag(String var) {		this.ValFlag = var; 	} 
 public String getRsValFlag() {		return rsValFlag ; 	} 
 public void setRsValFlag(String var) {		this.rsValFlag = var; 	} 
 public boolean getNullValFlag() {		return nullValFlag ; 	} 
 public void setNullValFlag(boolean var) {		this.nullValFlag = var; 	} 
 public Double getValItem() {		return ValItem ; 	} 
 public void setValItem(Double var) {		this.ValItem = var; 	} 
 public Double getRsValItem() {		return rsValItem ; 	} 
 public void setRsValItem(Double var) {		this.rsValItem = var; 	} 
 public boolean getNullValItem() {		return nullValItem ; 	} 
 public void setNullValItem(boolean var) {		this.nullValItem = var; 	} 
 public Integer getIdCustom() {		return IdCustom ; 	} 
 public void setIdCustom(Integer var) {		this.IdCustom = var; 	} 
 public Integer getRsIdCustom() {		return rsIdCustom ; 	} 
 public void setRsIdCustom(Integer var) {		this.rsIdCustom = var; 	} 
 public boolean getNullIdCustom() {		return nullIdCustom ; 	} 
 public void setNullIdCustom(boolean var) {		this.nullIdCustom = var; 	} 
 public Integer getSeqItemCustom() {		return SeqItemCustom ; 	} 
 public void setSeqItemCustom(Integer var) {		this.SeqItemCustom = var; 	} 
 public Integer getRsSeqItemCustom() {		return rsSeqItemCustom ; 	} 
 public void setRsSeqItemCustom(Integer var) {		this.rsSeqItemCustom = var; 	} 
 public boolean getNullSeqItemCustom() {		return nullSeqItemCustom ; 	} 
 public void setNullSeqItemCustom(boolean var) {		this.nullSeqItemCustom = var; 	} 
 public Produtos  getFkIdProd() throws Exception {  Produtos oFK = new Produtos(conn);  oFK.setIdProd(getRsIdProd());  oFK.lista();  oFK.next();  return oFK; }public ProdutoCustomItem  getFkIdCustomseqItemCustom() throws Exception {  ProdutoCustomItem oFK = new ProdutoCustomItem(conn);  oFK.setIdCustom(getRsIdCustom());  oFK.setSeqItem(getRsSeqItemCustom());  oFK.lista();  oFK.next();  return oFK; }public PedidoItem  getFkIdPedidoseqItem() throws Exception {  PedidoItem oFK = new PedidoItem(conn);  oFK.setIdPedido(getRsIdPedido());  oFK.setSeqItem(getRsSeqItem());  oFK.lista();  oFK.next();  return oFK; } public void posicionaRs() throws Exception{ if ( getSelect() == null ) {    try {   rsIdCustomPedido = rs.getLong("id_custom_pedido"); } catch (Exception e) { e.printStackTrace();  }  try {   rsIdPedido = rs.getLong("id_pedido"); } catch (Exception e) { e.printStackTrace();  }  try {   rsSeqItem = rs.getInt("seq_item"); } catch (Exception e) { e.printStackTrace();  }  try {   rsIdProd = rs.getInt("id_prod"); } catch (Exception e) { e.printStackTrace();  }  try {   rsValFlag = rs.getString("val_flag"); } catch (Exception e) { e.printStackTrace();  }  try {   rsValItem = rs.getDouble("val_item"); } catch (Exception e) { e.printStackTrace();  }  try {   rsIdCustom = rs.getInt("id_custom"); } catch (Exception e) { e.printStackTrace();  }  try {   rsSeqItemCustom = rs.getInt("seq_item_custom"); } catch (Exception e) { e.printStackTrace();  } }  }   public boolean next(){    boolean resultado;   resultado = false;    try{ limpaRs();    resultado = rs.next();    if (resultado){ posicionaRs(); }   } catch (Exception e){    e.printStackTrace(); }     return resultado; } public void limpaRs() throws Exception{  rsIdCustomPedido=  null ;  rsIdPedido=  null ;  rsSeqItem=  null ;  rsIdProd=  null ;  rsValFlag=  null ;  rsValItem=  null ;  rsIdCustom=  null ;  rsSeqItemCustom=  null ;   }  public ResultSet lista() throws Exception { sql = new StringBuffer(); if(getSelect()!=null){ sql.append(" select "+getSelect()+" "); }else {sql.append(" select *   "); } if(getJoin()!=null){ sql.append(" from "+getJoin()+" where  1=1 "); }else {sql.append(" from pedido_item_custom where  1=1 "); } if( getIdCustomPedido() != null ) { sql.append(" and pedido_item_custom .id_custom_pedido = ? "); } if( getIdPedido() != null ) { sql.append(" and pedido_item_custom .id_pedido = ? "); } if( getSeqItem() != null ) { sql.append(" and pedido_item_custom .seq_item = ? "); } if( getIdProd() != null ) { sql.append(" and pedido_item_custom .id_prod = ? "); } if( getValFlag() != null ) { sql.append(" and pedido_item_custom .val_flag = ? "); } if( getValItem() != null ) { sql.append(" and pedido_item_custom .val_item = ? "); } if( getIdCustom() != null ) { sql.append(" and pedido_item_custom .id_custom = ? "); } if( getSeqItemCustom() != null ) { sql.append(" and pedido_item_custom .seq_item_custom = ? "); } if(getWhere()!=null){ sql.append(" and "+ getWhere()+" "); }        if(getLastSentence()!=null){ sql.append(" "+ getLastSentence()+""); }        st = conn.prepareStatement(sql.toString());  int contparam = 1;  if( getIdCustomPedido() != null ){ st.setLong(contparam,getIdCustomPedido()); contparam++;}  if( getIdPedido() != null ){ st.setLong(contparam,getIdPedido()); contparam++;}  if( getSeqItem() != null ){ st.setInt(contparam,getSeqItem()); contparam++;}  if( getIdProd() != null ){ st.setInt(contparam,getIdProd()); contparam++;}  if( getValFlag() != null ){ st.setString(contparam,getValFlag()); contparam++;}  if( getValItem() != null ){ st.setDouble(contparam,getValItem()); contparam++;}  if( getIdCustom() != null ){ st.setInt(contparam,getIdCustom()); contparam++;}  if( getSeqItemCustom() != null ){ st.setInt(contparam,getSeqItemCustom()); contparam++;}  	rs = st.executeQuery();  	return rs; }public void update() throws Exception {  if( getIdCustomPedido() == null || getIdCustomPedido() == 0 ) {  throw new Exception("Erro, Pk IdCustomPedido não setada. Update de pedido_item_custom."); }sql = new StringBuffer();sql.append(" update pedido_item_custom set id_custom_pedido =  " + getIdCustomPedido() + "  "); if( getIdPedido() != null ) { sql.append(" ,  id_pedido = ? "); } if( getNullIdPedido()) { sql.append(" ,  id_pedido = null "); } if( getSeqItem() != null ) { sql.append(" ,  seq_item = ? "); } if( getNullSeqItem()) { sql.append(" ,  seq_item = null "); } if( getIdProd() != null ) { sql.append(" ,  id_prod = ? "); } if( getNullIdProd()) { sql.append(" ,  id_prod = null "); } if( getValFlag() != null ) { sql.append(" ,  val_flag = ? "); } if( getNullValFlag()) { sql.append(" ,  val_flag = null "); } if( getValItem() != null ) { sql.append(" ,  val_item = ? "); } if( getNullValItem()) { sql.append(" ,  val_item = null "); } if( getIdCustom() != null ) { sql.append(" ,  id_custom = ? "); } if( getNullIdCustom()) { sql.append(" ,  id_custom = null "); } if( getSeqItemCustom() != null ) { sql.append(" ,  seq_item_custom = ? "); } if( getNullSeqItemCustom()) { sql.append(" ,  seq_item_custom = null "); } sql.append(" where id_custom_pedido =  " + getIdCustomPedido() + "  "); if(getWhere()!=null){ sql.append(" and "+ getWhere()+" "); }        st = conn.prepareStatement(sql.toString());  int contparam = 1;  if( getIdPedido() != null ){ st.setLong(contparam,getIdPedido()); contparam++;}  if( getSeqItem() != null ){ st.setInt(contparam,getSeqItem()); contparam++;}  if( getIdProd() != null ){ st.setInt(contparam,getIdProd()); contparam++;}  if( getValFlag() != null ){ st.setString(contparam,getValFlag()); contparam++;}  if( getValItem() != null ){ st.setDouble(contparam,getValItem()); contparam++;}  if( getIdCustom() != null ){ st.setInt(contparam,getIdCustom()); contparam++;}  if( getSeqItemCustom() != null ){ st.setInt(contparam,getSeqItemCustom()); contparam++;}  		st.executeUpdate() ;} public void delete() throws Exception { sql = new StringBuffer();sql.append(" delete from pedido_item_custom "); sql.append(" where id_custom_pedido =  " + getIdCustomPedido() + "  "); st = conn.prepareStatement(sql.toString());  		st.executeUpdate() ;} public void insert() throws Exception { sql = new StringBuffer();StringBuffer values = new StringBuffer();sql.append(" insert into pedido_item_custom  (id_custom_pedido " );values.append(" value (? "); if( getIdPedido() != null ) {sql.append(" , id_pedido ");values.append(", ? "); }  if( getSeqItem() != null ) {sql.append(" , seq_item ");values.append(", ? "); }  if( getIdProd() != null ) {sql.append(" , id_prod ");values.append(", ? "); }  if( getValFlag() != null ) {sql.append(" , val_flag ");values.append(", ? "); }  if( getValItem() != null ) {sql.append(" , val_item ");values.append(", ? "); }  if( getIdCustom() != null ) {sql.append(" , id_custom ");values.append(", ? "); }  if( getSeqItemCustom() != null ) {sql.append(" , seq_item_custom ");values.append(", ? "); } sql.append(" ) ");values.append(" ) ");sql.append( values.toString()); 	st = conn.prepareStatement(sql.toString(),Statement.RETURN_GENERATED_KEYS);  int contparam = 1;   long id = 	 Utilitario.retornaIdinsertLong	 ("pedido_item_custom", "id_custom_pedido", conn); st.setLong(contparam, id); contparam++;  if( getIdPedido() != null ){ st.setLong(contparam,getIdPedido()); contparam++;  }  if( getSeqItem() != null ){ st.setInt(contparam,getSeqItem()); contparam++;  }  if( getIdProd() != null ){ st.setInt(contparam,getIdProd()); contparam++;  }  if( getValFlag() != null ){ st.setString(contparam,getValFlag()); contparam++;  }  if( getValItem() != null ){ st.setDouble(contparam,getValItem()); contparam++;  }  if( getIdCustom() != null ){ st.setInt(contparam,getIdCustom()); contparam++;  }  if( getSeqItemCustom() != null ){ st.setInt(contparam,getSeqItemCustom()); contparam++;  }  		if (st.executeUpdate() == 1) { setIdCustomPedido(id);} else { throw new Exception("Erro, contate suporte. Inserção de pedido_item_custom.");}}
 
 }