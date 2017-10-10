package com.cruds;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.funcs.Utilitario;
import java.util.Date;
import java.sql.Timestamp;
import com.mysql.jdbc.Statement;
import com.cruds.ProdutoCustom;

public class ProdutoCustomItem {

	private PreparedStatement st;
	private StringBuffer sql;
	private ResultSet rs;
	private Connection conn;
	private String Where;
	private String Join;
	private String LastSentence;
	private String Select;

	public ProdutoCustomItem(Connection conn) {
		super();
		this.conn = conn;
	}

	private Integer IdCustom;
	private Integer rsIdCustom;
	private Integer SeqItem;
	private Integer rsSeqItem;
	private String DescItem;
	private String rsDescItem;
	private boolean nullDescItem = false;
	private Integer FlagTipo;
	private Integer rsFlagTipo;
	private boolean nullFlagTipo = false;
	private String ValValidos;
	private String rsValValidos;
	private boolean nullValValidos = false;
	private String ValPreco;
	private String rsValPreco;
	private boolean nullValPreco = false;

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

	public Integer getIdCustom() {
		return IdCustom;
	}

	public void setIdCustom(Integer var) {
		this.IdCustom = var;
	}

	public Integer getRsIdCustom() {
		return rsIdCustom;
	}

	public void setRsIdCustom(Integer var) {
		this.rsIdCustom = var;
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

	public String getDescItem() {
		return DescItem;
	}

	public void setDescItem(String var) {
		this.DescItem = var;
	}

	public String getRsDescItem() {
		return rsDescItem;
	}

	public void setRsDescItem(String var) {
		this.rsDescItem = var;
	}

	public boolean getNullDescItem() {
		return nullDescItem;
	}

	public void setNullDescItem(boolean var) {
		this.nullDescItem = var;
	}

	public Integer getFlagTipo() {
		return FlagTipo;
	}

	public void setFlagTipo(Integer var) {
		this.FlagTipo = var;
	}

	public Integer getRsFlagTipo() {
		return rsFlagTipo;
	}

	public void setRsFlagTipo(Integer var) {
		this.rsFlagTipo = var;
	}

	public boolean getNullFlagTipo() {
		return nullFlagTipo;
	}

	public void setNullFlagTipo(boolean var) {
		this.nullFlagTipo = var;
	}

	public String getValValidos() {
		return ValValidos;
	}

	public void setValValidos(String var) {
		this.ValValidos = var;
	}

	public String getRsValValidos() {
		return rsValValidos;
	}

	public void setRsValValidos(String var) {
		this.rsValValidos = var;
	}

	public boolean getNullValValidos() {
		return nullValValidos;
	}

	public void setNullValValidos(boolean var) {
		this.nullValValidos = var;
	}

	public String getValPreco() {
		return ValPreco;
	}

	public void setValPreco(String var) {
		this.ValPreco = var;
	}

	public String getRsValPreco() {
		return rsValPreco;
	}

	public void setRsValPreco(String var) {
		this.rsValPreco = var;
	}

	public boolean getNullValPreco() {
		return nullValPreco;
	}

	public void setNullValPreco(boolean var) {
		this.nullValPreco = var;
	}

	public ProdutoCustom getFkIdCustom() throws Exception {
		ProdutoCustom oFK = new ProdutoCustom(conn);
		oFK.setIdCustom(getRsIdCustom());
		oFK.lista();
		oFK.next();
		return oFK;
	}

	public void posicionaRs() throws Exception {
		if (getSelect() == null) {
			try {
				rsIdCustom = rs.getInt("id_custom");
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				rsSeqItem = rs.getInt("seq_item");
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				rsDescItem = rs.getString("desc_item");
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				rsFlagTipo = rs.getInt("flag_tipo");
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				rsValValidos = rs.getString("val_validos");
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				rsValPreco = rs.getString("val_preco");
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
		rsIdCustom = null;
		rsSeqItem = null;
		rsDescItem = null;
		rsFlagTipo = null;
		rsValValidos = null;
		rsValPreco = null;
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
			sql.append(" from produto_custom_item where  1=1 ");
		}
		if (getIdCustom() != null) {
			sql.append(" and produto_custom_item .id_custom = ? ");
		}
		if (getSeqItem() != null) {
			sql.append(" and produto_custom_item .seq_item = ? ");
		}
		if (getDescItem() != null) {
			sql.append(" and produto_custom_item .desc_item = ? ");
		}
		if (getFlagTipo() != null) {
			sql.append(" and produto_custom_item .flag_tipo = ? ");
		}
		if (getValValidos() != null) {
			sql.append(" and produto_custom_item .val_validos = ? ");
		}
		if (getValPreco() != null) {
			sql.append(" and produto_custom_item .val_preco = ? ");
		}
		if (getWhere() != null) {
			sql.append(" and " + getWhere() + " ");
		}
		if (getLastSentence() != null) {
			sql.append(" " + getLastSentence() + "");
		}
		st = conn.prepareStatement(sql.toString());
		int contparam = 1;
		if (getIdCustom() != null) {
			st.setInt(contparam, getIdCustom());
			contparam++;
		}
		if (getSeqItem() != null) {
			st.setInt(contparam, getSeqItem());
			contparam++;
		}
		if (getDescItem() != null) {
			st.setString(contparam, getDescItem());
			contparam++;
		}
		if (getFlagTipo() != null) {
			st.setInt(contparam, getFlagTipo());
			contparam++;
		}
		if (getValValidos() != null) {
			st.setString(contparam, getValValidos());
			contparam++;
		}
		if (getValPreco() != null) {
			st.setString(contparam, getValPreco());
			contparam++;
		}
		rs = st.executeQuery();
		return rs;
	}

	public void update() throws Exception {
		if (getIdCustom() == null || getIdCustom() == 0) {
			throw new Exception("Erro, Pk IdCustom não setada. Update de produto_custom_item.");
		}
		if (getSeqItem() == null || getSeqItem() == 0) {
			throw new Exception("Erro, Pk SeqItem não setada. Update de produto_custom_item.");
		}
		sql = new StringBuffer();
		sql.append(" update produto_custom_item set id_custom =  " + getIdCustom() + "  ");
		if (getDescItem() != null) {
			sql.append(" ,  desc_item = ? ");
		}
		if (getNullDescItem()) {
			sql.append(" ,  desc_item = null ");
		}
		if (getFlagTipo() != null) {
			sql.append(" ,  flag_tipo = ? ");
		}
		if (getNullFlagTipo()) {
			sql.append(" ,  flag_tipo = null ");
		}
		if (getValValidos() != null) {
			sql.append(" ,  val_validos = ? ");
		}
		if (getNullValValidos()) {
			sql.append(" ,  val_validos = null ");
		}
		if (getValPreco() != null) {
			sql.append(" ,  val_preco = ? ");
		}
		if (getNullValPreco()) {
			sql.append(" ,  val_preco = null ");
		}
		sql.append(" where id_custom =  " + getIdCustom() + "  ");
		sql.append(" and seq_item =  " + getSeqItem() + "  ");
		if (getWhere() != null) {
			sql.append(" and " + getWhere() + " ");
		}
		st = conn.prepareStatement(sql.toString());
		int contparam = 1;
		if (getDescItem() != null) {
			st.setString(contparam, getDescItem());
			contparam++;
		}
		if (getFlagTipo() != null) {
			st.setInt(contparam, getFlagTipo());
			contparam++;
		}
		if (getValValidos() != null) {
			st.setString(contparam, getValValidos());
			contparam++;
		}
		if (getValPreco() != null) {
			st.setString(contparam, getValPreco());
			contparam++;
		}
		st.executeUpdate();
	}

	public void delete() throws Exception {
		sql = new StringBuffer();
		sql.append(" delete from produto_custom_item ");
		sql.append(" where id_custom =  " + getIdCustom() + "  ");
		sql.append(" and seq_item =  " + getSeqItem() + "  ");
		st = conn.prepareStatement(sql.toString());
		st.executeUpdate();
	}

	public void insert() throws Exception {
		sql = new StringBuffer();
		StringBuffer values = new StringBuffer();
		sql.append(" insert into produto_custom_item  (id_custom,seq_item ");
		values.append(" value (?,? ");
		if (getDescItem() != null) {
			sql.append(" , desc_item ");
			values.append(", ? ");
		}
		if (getFlagTipo() != null) {
			sql.append(" , flag_tipo ");
			values.append(", ? ");
		}
		if (getValValidos() != null) {
			sql.append(" , val_validos ");
			values.append(", ? ");
		}
		if (getValPreco() != null) {
			sql.append(" , val_preco ");
			values.append(", ? ");
		}
		sql.append(" ) ");
		values.append(" ) ");
		sql.append(values.toString());
		st = conn.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
		int contparam = 1;
		int id = Utilitario.retornaIdinsertChaveSecundaria("produto_custom_item", "id_custom", getIdCustom() + "", "seq_item", conn);
		st.setInt(contparam, getIdCustom());
		contparam++;
		st.setInt(contparam, id);
		contparam++;
		if (getDescItem() != null) {
			st.setString(contparam, getDescItem());
			contparam++;
		}
		if (getFlagTipo() != null) {
			st.setInt(contparam, getFlagTipo());
			contparam++;
		}
		if (getValValidos() != null) {
			st.setString(contparam, getValValidos());
			contparam++;
		}
		if (getValPreco() != null) {
			st.setString(contparam, getValPreco());
			contparam++;
		}
		if (st.executeUpdate() == 1) {
			setSeqItem(id);
		} else {
			throw new Exception("Erro, contate suporte. Inserção de produto_custom_item.");
		}
	}

}