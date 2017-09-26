package com.cruds;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.funcs.Utilitario;
import java.util.Date;
import java.sql.Timestamp;
import com.mysql.jdbc.Statement;
import com.cruds.Pedido;
import com.cruds.Produtos;

public class PedidoItem {

	private PreparedStatement st;
	private StringBuffer sql;
	private ResultSet rs;
	private Connection conn;
	private String Where;
	private String Join;
	private String LastSentence;
	private String Select;

	public PedidoItem(Connection conn) {
		super();
		this.conn = conn;
	}

	private Long IdPedido;
	private Long rsIdPedido;
	private Integer SeqItem;
	private Integer rsSeqItem;
	private Double ValUnit;
	private Double rsValUnit;
	private boolean nullValUnit = false;
	private Integer IdProd;
	private Integer rsIdProd;
	private boolean nullIdProd = false;
	private Long QtdProd;
	private Long rsQtdProd;
	private boolean nullQtdProd = false;
	private String FlagRecusado;
	private String rsFlagRecusado;
	private boolean nullFlagRecusado = false;
	private Integer RecusadoDisponivel;
	private Integer rsRecusadoDisponivel;
	private boolean nullRecusadoDisponivel = false;

	public PreparedStatement getSt() {
		return st;
	}

	public void setSt(PreparedStatement st) {
		this.st = st;
	}

	public StringBuffer getSql() {
		return sql;
	}

	public void setSql(StringBuffer sql) {
		this.sql = sql;
	}

	public ResultSet getRs() {
		return rs;
	}

	public void setRs(ResultSet rs) {
		this.rs = rs;
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public String getWhere() {
		return this.Where;
	}

	public void setWhere(String where) {
		this.Where = where;
	}

	public String getJoin() {
		return this.Join;
	}

	public void setJoin(String join) {
		this.Join = join;
	}

	public String getLastSentence() {
		return this.LastSentence;
	}

	public void setLastSentence(String last) {
		this.LastSentence = last;
	}

	public String getSelect() {
		return this.Select;
	}

	public void setSelect(String select) {
		this.Select = select;
	}

	public Long getIdPedido() {
		return IdPedido;
	}

	public void setIdPedido(Long var) {
		this.IdPedido = var;
	}

	public Long getRsIdPedido() {
		return rsIdPedido;
	}

	public void setRsIdPedido(Long var) {
		this.rsIdPedido = var;
	}

	public Integer getSeqItem() {
		return SeqItem;
	}

	public void setSeqItem(Integer var) {
		this.SeqItem = var;
	}

	public Integer getRsSeqItem() {
		return rsSeqItem;
	}

	public void setRsSeqItem(Integer var) {
		this.rsSeqItem = var;
	}

	public Double getValUnit() {
		return ValUnit;
	}

	public void setValUnit(Double var) {
		this.ValUnit = var;
	}

	public Double getRsValUnit() {
		return rsValUnit;
	}

	public void setRsValUnit(Double var) {
		this.rsValUnit = var;
	}

	public boolean getNullValUnit() {
		return nullValUnit;
	}

	public void setNullValUnit(boolean var) {
		this.nullValUnit = var;
	}

	public Integer getIdProd() {
		return IdProd;
	}

	public void setIdProd(Integer var) {
		this.IdProd = var;
	}

	public Integer getRsIdProd() {
		return rsIdProd;
	}

	public void setRsIdProd(Integer var) {
		this.rsIdProd = var;
	}

	public boolean getNullIdProd() {
		return nullIdProd;
	}

	public void setNullIdProd(boolean var) {
		this.nullIdProd = var;
	}

	public Long getQtdProd() {
		return QtdProd;
	}

	public void setQtdProd(Long var) {
		this.QtdProd = var;
	}

	public Long getRsQtdProd() {
		return rsQtdProd;
	}

	public void setRsQtdProd(Long var) {
		this.rsQtdProd = var;
	}

	public boolean getNullQtdProd() {
		return nullQtdProd;
	}

	public void setNullQtdProd(boolean var) {
		this.nullQtdProd = var;
	}

	public String getFlagRecusado() {
		return FlagRecusado;
	}

	public void setFlagRecusado(String var) {
		this.FlagRecusado = var;
	}

	public String getRsFlagRecusado() {
		return rsFlagRecusado;
	}

	public void setRsFlagRecusado(String var) {
		this.rsFlagRecusado = var;
	}

	public boolean getNullFlagRecusado() {
		return nullFlagRecusado;
	}

	public void setNullFlagRecusado(boolean var) {
		this.nullFlagRecusado = var;
	}

	public Integer getRecusadoDisponivel() {
		return RecusadoDisponivel;
	}

	public void setRecusadoDisponivel(Integer var) {
		this.RecusadoDisponivel = var;
	}

	public Integer getRsRecusadoDisponivel() {
		return rsRecusadoDisponivel;
	}

	public void setRsRecusadoDisponivel(Integer var) {
		this.rsRecusadoDisponivel = var;
	}

	public boolean getNullRecusadoDisponivel() {
		return nullRecusadoDisponivel;
	}

	public void setNullRecusadoDisponivel(boolean var) {
		this.nullRecusadoDisponivel = var;
	}

	// somente para pk single
	public Pedido getFkIdPedido() throws Exception {
		Pedido oFK = new Pedido(conn);
		oFK.setIdPedido(getRsIdPedido());
		oFK.lista();
		oFK.next();
		return oFK;
	}

	// somente para pk single
	public Produtos getFkIdProd() throws Exception {
		Produtos oFK = new Produtos(conn);
		oFK.setIdProd(getRsIdProd());
		oFK.lista();
		oFK.next();
		return oFK;
	}

	public void posicionaRs() throws Exception {
		if (getSelect() == null) {
			try {
				rsIdPedido = rs.getLong("id_pedido");
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				rsSeqItem = rs.getInt("seq_item");
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				rsValUnit = rs.getDouble("val_unit");
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				rsIdProd = rs.getInt("id_prod");
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				rsQtdProd = rs.getLong("qtd_prod");
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				rsFlagRecusado = rs.getString("flag_recusado");
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				rsRecusadoDisponivel = rs.getInt("recusado_disponivel");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public boolean next() {
		boolean resultado;
		resultado = false;
		try {
			limpaRs();
			resultado = rs.next();
			if (resultado) {
				posicionaRs();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultado;
	}

	public void limpaRs() throws Exception {
		rsIdPedido = null;
		rsSeqItem = null;
		rsValUnit = null;
		rsIdProd = null;
		rsQtdProd = null;
		rsFlagRecusado = null;
		rsRecusadoDisponivel = null;
	}

	public ResultSet lista() throws Exception {
		sql = new StringBuffer();
		if (getSelect() != null) {
			sql.append(" select " + getSelect() + " ");
		} else {
			sql.append(" select *   ");
		}
		if (getJoin() != null) {
			sql.append(" from " + getJoin() + " where  1=1 ");
		} else {
			sql.append(" from pedido_item where  1=1 ");
		}
		if (getIdPedido() != null) {
			sql.append(" and pedido_item .id_pedido = ? ");
		}
		if (getSeqItem() != null) {
			sql.append(" and pedido_item .seq_item = ? ");
		}
		if (getValUnit() != null) {
			sql.append(" and pedido_item .val_unit = ? ");
		}
		if (getIdProd() != null) {
			sql.append(" and pedido_item .id_prod = ? ");
		}
		if (getQtdProd() != null) {
			sql.append(" and pedido_item .qtd_prod = ? ");
		}
		if (getFlagRecusado() != null) {
			sql.append(" and pedido_item .flag_recusado = ? ");
		}
		if (getRecusadoDisponivel() != null) {
			sql.append(" and pedido_item .recusado_disponivel = ? ");
		}
		if (getWhere() != null) {
			sql.append(" and " + getWhere() + " ");
		}
		if (getLastSentence() != null) {
			sql.append(" " + getLastSentence() + "");
		}
		st = conn.prepareStatement(sql.toString());
		int contparam = 1;
		if (getIdPedido() != null) {
			st.setLong(contparam, getIdPedido());
			contparam++;
		}
		if (getSeqItem() != null) {
			st.setInt(contparam, getSeqItem());
			contparam++;
		}
		if (getValUnit() != null) {
			st.setDouble(contparam, getValUnit());
			contparam++;
		}
		if (getIdProd() != null) {
			st.setInt(contparam, getIdProd());
			contparam++;
		}
		if (getQtdProd() != null) {
			st.setLong(contparam, getQtdProd());
			contparam++;
		}
		if (getFlagRecusado() != null) {
			st.setString(contparam, getFlagRecusado());
			contparam++;
		}
		if (getRecusadoDisponivel() != null) {
			st.setInt(contparam, getRecusadoDisponivel());
			contparam++;
		}
		rs = st.executeQuery();
		return rs;
	}

	public void update() throws Exception {
		if (getIdPedido() == null || getIdPedido() == 0) {
			throw new Exception("Erro, Pk IdPedido não setada. Update de pedido_item.");
		}
		if (getSeqItem() == null || getSeqItem() == 0) {
			throw new Exception("Erro, Pk SeqItem não setada. Update de pedido_item.");
		}
		sql = new StringBuffer();
		sql.append(" update pedido_item set id_pedido =  " + getIdPedido() + "  ");
		if (getValUnit() != null) {
			sql.append(" ,  val_unit = ? ");
		}
		if (getNullValUnit()) {
			sql.append(" ,  val_unit = null ");
		}
		if (getIdProd() != null) {
			sql.append(" ,  id_prod = ? ");
		}
		if (getNullIdProd()) {
			sql.append(" ,  id_prod = null ");
		}
		if (getQtdProd() != null) {
			sql.append(" ,  qtd_prod = ? ");
		}
		if (getNullQtdProd()) {
			sql.append(" ,  qtd_prod = null ");
		}
		if (getFlagRecusado() != null) {
			sql.append(" ,  flag_recusado = ? ");
		}
		if (getNullFlagRecusado()) {
			sql.append(" ,  flag_recusado = null ");
		}
		if (getRecusadoDisponivel() != null) {
			sql.append(" ,  recusado_disponivel = ? ");
		}
		if (getNullRecusadoDisponivel()) {
			sql.append(" ,  recusado_disponivel = null ");
		}
		sql.append(" where id_pedido =  " + getIdPedido() + "  ");
		sql.append(" and seq_item =  " + getSeqItem() + "  ");
		if (getWhere() != null) {
			sql.append(" and " + getWhere() + " ");
		}
		st = conn.prepareStatement(sql.toString());
		int contparam = 1;
		if (getValUnit() != null) {
			st.setDouble(contparam, getValUnit());
			contparam++;
		}
		if (getIdProd() != null) {
			st.setInt(contparam, getIdProd());
			contparam++;
		}
		if (getQtdProd() != null) {
			st.setLong(contparam, getQtdProd());
			contparam++;
		}
		if (getFlagRecusado() != null) {
			st.setString(contparam, getFlagRecusado());
			contparam++;
		}
		if (getRecusadoDisponivel() != null) {
			st.setInt(contparam, getRecusadoDisponivel());
			contparam++;
		}
		st.executeUpdate();
	}

	public void delete() throws Exception {
		sql = new StringBuffer();
		sql.append(" delete from pedido_item ");
		sql.append(" where id_pedido =  " + getIdPedido() + "  ");
		sql.append(" and seq_item =  " + getSeqItem() + "  ");
		st = conn.prepareStatement(sql.toString());
		st.executeUpdate();
	}

	public void insert() throws Exception {
		sql = new StringBuffer();
		StringBuffer values = new StringBuffer();
		sql.append(" insert into pedido_item  (id_pedido,seq_item ");
		values.append(" value (?,? ");
		if (getValUnit() != null) {
			sql.append(" , val_unit ");
			values.append(", ? ");
		}
		if (getIdProd() != null) {
			sql.append(" , id_prod ");
			values.append(", ? ");
		}
		if (getQtdProd() != null) {
			sql.append(" , qtd_prod ");
			values.append(", ? ");
		}
		if (getFlagRecusado() != null) {
			sql.append(" , flag_recusado ");
			values.append(", ? ");
		}
		if (getRecusadoDisponivel() != null) {
			sql.append(" , recusado_disponivel ");
			values.append(", ? ");
		}
		sql.append(" ) ");
		values.append(" ) ");
		sql.append(values.toString());
		st = conn.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
		int contparam = 1;
		int id = Utilitario.retornaIdinsertChaveSecundaria("pedido_item", "id_pedido", getIdPedido() + "", "seq_item", conn);
		st.setLong(contparam, getIdPedido());
		contparam++;
		st.setInt(contparam, id);
		contparam++;
		if (getValUnit() != null) {
			st.setDouble(contparam, getValUnit());
			contparam++;
		}
		if (getIdProd() != null) {
			st.setInt(contparam, getIdProd());
			contparam++;
		}
		if (getQtdProd() != null) {
			st.setLong(contparam, getQtdProd());
			contparam++;
		}
		if (getFlagRecusado() != null) {
			st.setString(contparam, getFlagRecusado());
			contparam++;
		}
		if (getRecusadoDisponivel() != null) {
			st.setInt(contparam, getRecusadoDisponivel());
			contparam++;
		}
		if (st.executeUpdate() == 1) {
			setSeqItem(id);
		} else {
			throw new Exception("Erro, contate suporte. Inserção de pedido_item.");
		}
	}

}