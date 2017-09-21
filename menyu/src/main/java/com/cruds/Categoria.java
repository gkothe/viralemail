package com.cruds;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.funcs.Utilitario;
import java.util.Date;
import java.sql.Timestamp;
import com.mysql.jdbc.Statement;

public class Categoria {

	private PreparedStatement st;
	private StringBuffer sql;
	private ResultSet rs;
	private Connection conn;
	private String Where;
	private String Join;
	private String LastSentence;
	private String Select;

	public Categoria(Connection conn) {
		super();
		this.conn = conn;
	}

	private Integer IdCategoria;
	private Integer rsIdCategoria;
	private String DescCategoria;
	private String rsDescCategoria;
	private boolean nullDescCategoria = false;
	private String DescKeyWords;
	private String rsDescKeyWords;
	private boolean nullDescKeyWords = false;

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

	public Integer getIdCategoria() {
		return IdCategoria;
	}

	public void setIdCategoria(Integer var) {
		this.IdCategoria = var;
	}

	public Integer getRsIdCategoria() {
		return rsIdCategoria;
	}

	public void setRsIdCategoria(Integer var) {
		this.rsIdCategoria = var;
	}

	public String getDescCategoria() {
		return DescCategoria;
	}

	public void setDescCategoria(String var) {
		this.DescCategoria = var;
	}

	public String getRsDescCategoria() {
		return rsDescCategoria;
	}

	public void setRsDescCategoria(String var) {
		this.rsDescCategoria = var;
	}

	public boolean getNullDescCategoria() {
		return nullDescCategoria;
	}

	public void setNullDescCategoria(boolean var) {
		this.nullDescCategoria = var;
	}

	public String getDescKeyWords() {
		return DescKeyWords;
	}

	public void setDescKeyWords(String var) {
		this.DescKeyWords = var;
	}

	public String getRsDescKeyWords() {
		return rsDescKeyWords;
	}

	public void setRsDescKeyWords(String var) {
		this.rsDescKeyWords = var;
	}

	public boolean getNullDescKeyWords() {
		return nullDescKeyWords;
	}

	public void setNullDescKeyWords(boolean var) {
		this.nullDescKeyWords = var;
	}

	public void posicionaRs() throws Exception {
		if (getSelect() == null) {
			try {
				rsIdCategoria = rs.getInt("id_categoria");
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				rsDescCategoria = rs.getString("desc_categoria");
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				rsDescKeyWords = rs.getString("desc_key_words");
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
		rsIdCategoria = null;
		rsDescCategoria = null;
		rsDescKeyWords = null;
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
			sql.append(" from categoria where  1=1 ");
		}
		if (getIdCategoria() != null) {
			sql.append(" and categoria .id_categoria = ? ");
		}
		if (getDescCategoria() != null) {
			sql.append(" and categoria .desc_categoria = ? ");
		}
		if (getDescKeyWords() != null) {
			sql.append(" and categoria .desc_key_words = ? ");
		}
		if (getWhere() != null) {
			sql.append(" and " + getWhere() + " ");
		}
		if (getLastSentence() != null) {
			sql.append(" " + getLastSentence() + "");
		}
		st = conn.prepareStatement(sql.toString());
		int contparam = 1;
		if (getIdCategoria() != null) {
			st.setInt(contparam, getIdCategoria());
			contparam++;
		}
		if (getDescCategoria() != null) {
			st.setString(contparam, getDescCategoria());
			contparam++;
		}
		if (getDescKeyWords() != null) {
			st.setString(contparam, getDescKeyWords());
			contparam++;
		}
		rs = st.executeQuery();
		return rs;
	}

	public void update() throws Exception {
		if (getIdCategoria() == null || getIdCategoria() == 0) {
			throw new Exception("Erro, Pk IdCategoria não setada. Update de categoria.");
		}
		sql = new StringBuffer();
		sql.append(" update categoria set id_categoria =  " + getIdCategoria() + "  ");
		if (getDescCategoria() != null) {
			sql.append(" ,  desc_categoria = ? ");
		}
		if (getNullDescCategoria()) {
			sql.append(" ,  desc_categoria = null ");
		}
		if (getDescKeyWords() != null) {
			sql.append(" ,  desc_key_words = ? ");
		}
		if (getNullDescKeyWords()) {
			sql.append(" ,  desc_key_words = null ");
		}
		sql.append(" where id_categoria =  " + getIdCategoria() + "  ");
		if (getWhere() != null) {
			sql.append(" and " + getWhere() + " ");
		}
		st = conn.prepareStatement(sql.toString());
		int contparam = 1;
		if (getDescCategoria() != null) {
			st.setString(contparam, getDescCategoria());
			contparam++;
		}
		if (getDescKeyWords() != null) {
			st.setString(contparam, getDescKeyWords());
			contparam++;
		}
		st.executeUpdate();
	}

	public void delete() throws Exception {
		sql = new StringBuffer();
		sql.append(" delete from categoria ");
		sql.append(" where id_categoria =  " + getIdCategoria() + "  ");
		st = conn.prepareStatement(sql.toString());
		st.executeUpdate();
	}

	public void insert() throws Exception {
		sql = new StringBuffer();
		StringBuffer values = new StringBuffer();
		sql.append(" insert into categoria  (id_categoria ");
		values.append(" value (? ");
		if (getDescCategoria() != null) {
			sql.append(" , desc_categoria ");
			values.append(", ? ");
		}
		if (getDescKeyWords() != null) {
			sql.append(" , desc_key_words ");
			values.append(", ? ");
		}
		sql.append(" ) ");
		values.append(" ) ");
		sql.append(values.toString());
		st = conn.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
		int contparam = 1;
		int id = Utilitario.retornaIdinsert("categoria", "id_categoria", conn);
		st.setInt(contparam, id);
		contparam++;
		if (getDescCategoria() != null) {
			st.setString(contparam, getDescCategoria());
			contparam++;
		}
		if (getDescKeyWords() != null) {
			st.setString(contparam, getDescKeyWords());
			contparam++;
		}
		if (st.executeUpdate() == 1) {
			setIdCategoria(id);
		} else {
			throw new Exception("Erro, contate suporte. Inserção de categoria.");
		}
	}

}