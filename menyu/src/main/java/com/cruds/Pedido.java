package com.cruds;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.funcs.Utilitario;
import java.util.Date;
import java.sql.Timestamp;
import com.mysql.jdbc.Statement;
import com.cruds.Loja;
import com.cruds.Usuario;

public class Pedido {

	private PreparedStatement st;
	private StringBuffer sql;
	private ResultSet rs;
	private Connection conn;
	private String Where;
	private String Join;
	private String LastSentence;
	private String Select;

	public Pedido(Connection conn) {
		super();
		this.conn = conn;
	}

	private Long IdPedido;
	private Long rsIdPedido;
	private Integer IdLoja;
	private Integer rsIdLoja;
	private boolean nullIdLoja = false;
	private Long IdUsuario;
	private Long rsIdUsuario;
	private boolean nullIdUsuario = false;
	private Timestamp DataPedido;
	private Timestamp rsDataPedido;
	private boolean nullDataPedido = false;
	private String FlagStatus;
	private String rsFlagStatus;
	private boolean nullFlagStatus = false;
	private Double ValTotalprod;
	private Double rsValTotalprod;
	private boolean nullValTotalprod = false;
	private Long NumPed;
	private Long rsNumPed;
	private boolean nullNumPed = false;
	private Integer IdModoPagamento;
	private Integer rsIdModoPagamento;
	private boolean nullIdModoPagamento = false;
	private String NumTelefonecontatoCliente;
	private String rsNumTelefonecontatoCliente;
	private boolean nullNumTelefonecontatoCliente = false;
	private Timestamp TempoEstimadoEntrega;
	private Timestamp rsTempoEstimadoEntrega;
	private boolean nullTempoEstimadoEntrega = false;
	private String NomePessoa;
	private String rsNomePessoa;
	private boolean nullNomePessoa = false;
	private String NumMesaEntrega;
	private String rsNumMesaEntrega;
	private boolean nullNumMesaEntrega = false;
	private String FlagVizualizado;
	private String rsFlagVizualizado;
	private boolean nullFlagVizualizado = false;
	private Double NumTrocopara;
	private Double rsNumTrocopara;
	private boolean nullNumTrocopara = false;
	private String DescObservacao;
	private String rsDescObservacao;
	private boolean nullDescObservacao = false;
	private String FlagMarcado;
	private String rsFlagMarcado;
	private boolean nullFlagMarcado = false;

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

	public Integer getIdLoja() {
		return IdLoja;
	}

	public void setIdLoja(Integer var) {
		this.IdLoja = var;
	}

	public Integer getRsIdLoja() {
		return rsIdLoja;
	}

	public void setRsIdLoja(Integer var) {
		this.rsIdLoja = var;
	}

	public boolean getNullIdLoja() {
		return nullIdLoja;
	}

	public void setNullIdLoja(boolean var) {
		this.nullIdLoja = var;
	}

	public Long getIdUsuario() {
		return IdUsuario;
	}

	public void setIdUsuario(Long var) {
		this.IdUsuario = var;
	}

	public Long getRsIdUsuario() {
		return rsIdUsuario;
	}

	public void setRsIdUsuario(Long var) {
		this.rsIdUsuario = var;
	}

	public boolean getNullIdUsuario() {
		return nullIdUsuario;
	}

	public void setNullIdUsuario(boolean var) {
		this.nullIdUsuario = var;
	}

	public Timestamp getDataPedido() {
		return DataPedido;
	}

	public void setDataPedido(Timestamp var) {
		this.DataPedido = var;
	}

	public Timestamp getRsDataPedido() {
		return rsDataPedido;
	}

	public void setRsDataPedido(Timestamp var) {
		this.rsDataPedido = var;
	}

	public boolean getNullDataPedido() {
		return nullDataPedido;
	}

	public void setNullDataPedido(boolean var) {
		this.nullDataPedido = var;
	}

	public String getFlagStatus() {
		return FlagStatus;
	}

	public void setFlagStatus(String var) {
		this.FlagStatus = var;
	}

	public String getRsFlagStatus() {
		return rsFlagStatus;
	}

	public void setRsFlagStatus(String var) {
		this.rsFlagStatus = var;
	}

	public boolean getNullFlagStatus() {
		return nullFlagStatus;
	}

	public void setNullFlagStatus(boolean var) {
		this.nullFlagStatus = var;
	}

	public Double getValTotalprod() {
		return ValTotalprod;
	}

	public void setValTotalprod(Double var) {
		this.ValTotalprod = var;
	}

	public Double getRsValTotalprod() {
		return rsValTotalprod;
	}

	public void setRsValTotalprod(Double var) {
		this.rsValTotalprod = var;
	}

	public boolean getNullValTotalprod() {
		return nullValTotalprod;
	}

	public void setNullValTotalprod(boolean var) {
		this.nullValTotalprod = var;
	}

	public Long getNumPed() {
		return NumPed;
	}

	public void setNumPed(Long var) {
		this.NumPed = var;
	}

	public Long getRsNumPed() {
		return rsNumPed;
	}

	public void setRsNumPed(Long var) {
		this.rsNumPed = var;
	}

	public boolean getNullNumPed() {
		return nullNumPed;
	}

	public void setNullNumPed(boolean var) {
		this.nullNumPed = var;
	}

	public Integer getIdModoPagamento() {
		return IdModoPagamento;
	}

	public void setIdModoPagamento(Integer var) {
		this.IdModoPagamento = var;
	}

	public Integer getRsIdModoPagamento() {
		return rsIdModoPagamento;
	}

	public void setRsIdModoPagamento(Integer var) {
		this.rsIdModoPagamento = var;
	}

	public boolean getNullIdModoPagamento() {
		return nullIdModoPagamento;
	}

	public void setNullIdModoPagamento(boolean var) {
		this.nullIdModoPagamento = var;
	}

	public String getNumTelefonecontatoCliente() {
		return NumTelefonecontatoCliente;
	}

	public void setNumTelefonecontatoCliente(String var) {
		this.NumTelefonecontatoCliente = var;
	}

	public String getRsNumTelefonecontatoCliente() {
		return rsNumTelefonecontatoCliente;
	}

	public void setRsNumTelefonecontatoCliente(String var) {
		this.rsNumTelefonecontatoCliente = var;
	}

	public boolean getNullNumTelefonecontatoCliente() {
		return nullNumTelefonecontatoCliente;
	}

	public void setNullNumTelefonecontatoCliente(boolean var) {
		this.nullNumTelefonecontatoCliente = var;
	}

	public Timestamp getTempoEstimadoEntrega() {
		return TempoEstimadoEntrega;
	}

	public void setTempoEstimadoEntrega(Timestamp var) {
		this.TempoEstimadoEntrega = var;
	}

	public Timestamp getRsTempoEstimadoEntrega() {
		return rsTempoEstimadoEntrega;
	}

	public void setRsTempoEstimadoEntrega(Timestamp var) {
		this.rsTempoEstimadoEntrega = var;
	}

	public boolean getNullTempoEstimadoEntrega() {
		return nullTempoEstimadoEntrega;
	}

	public void setNullTempoEstimadoEntrega(boolean var) {
		this.nullTempoEstimadoEntrega = var;
	}

	public String getNomePessoa() {
		return NomePessoa;
	}

	public void setNomePessoa(String var) {
		this.NomePessoa = var;
	}

	public String getRsNomePessoa() {
		return rsNomePessoa;
	}

	public void setRsNomePessoa(String var) {
		this.rsNomePessoa = var;
	}

	public boolean getNullNomePessoa() {
		return nullNomePessoa;
	}

	public void setNullNomePessoa(boolean var) {
		this.nullNomePessoa = var;
	}

	public String getNumMesaEntrega() {
		return NumMesaEntrega;
	}

	public void setNumMesaEntrega(String var) {
		this.NumMesaEntrega = var;
	}

	public String getRsNumMesaEntrega() {
		return rsNumMesaEntrega;
	}

	public void setRsNumMesaEntrega(String var) {
		this.rsNumMesaEntrega = var;
	}

	public boolean getNullNumMesaEntrega() {
		return nullNumMesaEntrega;
	}

	public void setNullNumMesaEntrega(boolean var) {
		this.nullNumMesaEntrega = var;
	}

	public String getFlagVizualizado() {
		return FlagVizualizado;
	}

	public void setFlagVizualizado(String var) {
		this.FlagVizualizado = var;
	}

	public String getRsFlagVizualizado() {
		return rsFlagVizualizado;
	}

	public void setRsFlagVizualizado(String var) {
		this.rsFlagVizualizado = var;
	}

	public boolean getNullFlagVizualizado() {
		return nullFlagVizualizado;
	}

	public void setNullFlagVizualizado(boolean var) {
		this.nullFlagVizualizado = var;
	}

	public Double getNumTrocopara() {
		return NumTrocopara;
	}

	public void setNumTrocopara(Double var) {
		this.NumTrocopara = var;
	}

	public Double getRsNumTrocopara() {
		return rsNumTrocopara;
	}

	public void setRsNumTrocopara(Double var) {
		this.rsNumTrocopara = var;
	}

	public boolean getNullNumTrocopara() {
		return nullNumTrocopara;
	}

	public void setNullNumTrocopara(boolean var) {
		this.nullNumTrocopara = var;
	}

	public String getDescObservacao() {
		return DescObservacao;
	}

	public void setDescObservacao(String var) {
		this.DescObservacao = var;
	}

	public String getRsDescObservacao() {
		return rsDescObservacao;
	}

	public void setRsDescObservacao(String var) {
		this.rsDescObservacao = var;
	}

	public boolean getNullDescObservacao() {
		return nullDescObservacao;
	}

	public void setNullDescObservacao(boolean var) {
		this.nullDescObservacao = var;
	}

	public String getFlagMarcado() {
		return FlagMarcado;
	}

	public void setFlagMarcado(String var) {
		this.FlagMarcado = var;
	}

	public String getRsFlagMarcado() {
		return rsFlagMarcado;
	}

	public void setRsFlagMarcado(String var) {
		this.rsFlagMarcado = var;
	}

	public boolean getNullFlagMarcado() {
		return nullFlagMarcado;
	}

	public void setNullFlagMarcado(boolean var) {
		this.nullFlagMarcado = var;
	}

	// somente para pk single
	public Loja getFkIdLoja() throws Exception {
		Loja oFK = new Loja(conn);
		oFK.setIdLoja(getRsIdLoja());
		oFK.lista();
		oFK.next();
		return oFK;
	}

	// somente para pk single
	public Usuario getFkIdUsuario() throws Exception {
		Usuario oFK = new Usuario(conn);
		oFK.setIdUsuario(getRsIdUsuario());
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
				rsIdLoja = rs.getInt("id_loja");
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				rsIdUsuario = rs.getLong("id_usuario");
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				rsDataPedido = rs.getTimestamp("data_pedido");
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				rsFlagStatus = rs.getString("flag_status");
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				rsValTotalprod = rs.getDouble("val_totalprod");
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				rsNumPed = rs.getLong("num_ped");
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				rsIdModoPagamento = rs.getInt("id_modo_pagamento");
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				rsNumTelefonecontatoCliente = rs.getString("num_telefonecontato_cliente");
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				rsTempoEstimadoEntrega = rs.getTimestamp("tempo_estimado_entrega");
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				rsNomePessoa = rs.getString("nome_pessoa");
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				rsNumMesaEntrega = rs.getString("num_mesa_entrega");
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				rsFlagVizualizado = rs.getString("flag_vizualizado");
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				rsNumTrocopara = rs.getDouble("num_trocopara");
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				rsDescObservacao = rs.getString("desc_observacao");
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				rsFlagMarcado = rs.getString("flag_marcado");
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
		rsIdLoja = null;
		rsIdUsuario = null;
		rsDataPedido = null;
		rsFlagStatus = null;
		rsValTotalprod = null;
		rsNumPed = null;
		rsIdModoPagamento = null;
		rsNumTelefonecontatoCliente = null;
		rsTempoEstimadoEntrega = null;
		rsNomePessoa = null;
		rsNumMesaEntrega = null;
		rsFlagVizualizado = null;
		rsNumTrocopara = null;
		rsDescObservacao = null;
		rsFlagMarcado = null;
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
			sql.append(" from pedido where  1=1 ");
		}
		if (getIdPedido() != null) {
			sql.append(" and pedido .id_pedido = ? ");
		}
		if (getIdLoja() != null) {
			sql.append(" and pedido .id_loja = ? ");
		}
		if (getIdUsuario() != null) {
			sql.append(" and pedido .id_usuario = ? ");
		}
		if (getDataPedido() != null) {
			sql.append(" and pedido .data_pedido = ? ");
		}
		if (getFlagStatus() != null) {
			sql.append(" and pedido .flag_status = ? ");
		}
		if (getValTotalprod() != null) {
			sql.append(" and pedido .val_totalprod = ? ");
		}
		if (getNumPed() != null) {
			sql.append(" and pedido .num_ped = ? ");
		}
		if (getIdModoPagamento() != null) {
			sql.append(" and pedido .id_modo_pagamento = ? ");
		}
		if (getNumTelefonecontatoCliente() != null) {
			sql.append(" and pedido .num_telefonecontato_cliente = ? ");
		}
		if (getTempoEstimadoEntrega() != null) {
			sql.append(" and pedido .tempo_estimado_entrega = ? ");
		}
		if (getNomePessoa() != null) {
			sql.append(" and pedido .nome_pessoa = ? ");
		}
		if (getNumMesaEntrega() != null) {
			sql.append(" and pedido .num_mesa_entrega = ? ");
		}
		if (getFlagVizualizado() != null) {
			sql.append(" and pedido .flag_vizualizado = ? ");
		}
		if (getNumTrocopara() != null) {
			sql.append(" and pedido .num_trocopara = ? ");
		}
		if (getDescObservacao() != null) {
			sql.append(" and pedido .desc_observacao = ? ");
		}
		if (getFlagMarcado() != null) {
			sql.append(" and pedido .flag_marcado = ? ");
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
		if (getIdLoja() != null) {
			st.setInt(contparam, getIdLoja());
			contparam++;
		}
		if (getIdUsuario() != null) {
			st.setLong(contparam, getIdUsuario());
			contparam++;
		}
		if (getDataPedido() != null) {
			st.setTimestamp(contparam, getDataPedido());
			contparam++;
		}
		if (getFlagStatus() != null) {
			st.setString(contparam, getFlagStatus());
			contparam++;
		}
		if (getValTotalprod() != null) {
			st.setDouble(contparam, getValTotalprod());
			contparam++;
		}
		if (getNumPed() != null) {
			st.setLong(contparam, getNumPed());
			contparam++;
		}
		if (getIdModoPagamento() != null) {
			st.setInt(contparam, getIdModoPagamento());
			contparam++;
		}
		if (getNumTelefonecontatoCliente() != null) {
			st.setString(contparam, getNumTelefonecontatoCliente());
			contparam++;
		}
		if (getTempoEstimadoEntrega() != null) {
			st.setTimestamp(contparam, getTempoEstimadoEntrega());
			contparam++;
		}
		if (getNomePessoa() != null) {
			st.setString(contparam, getNomePessoa());
			contparam++;
		}
		if (getNumMesaEntrega() != null) {
			st.setString(contparam, getNumMesaEntrega());
			contparam++;
		}
		if (getFlagVizualizado() != null) {
			st.setString(contparam, getFlagVizualizado());
			contparam++;
		}
		if (getNumTrocopara() != null) {
			st.setDouble(contparam, getNumTrocopara());
			contparam++;
		}
		if (getDescObservacao() != null) {
			st.setString(contparam, getDescObservacao());
			contparam++;
		}
		if (getFlagMarcado() != null) {
			st.setString(contparam, getFlagMarcado());
			contparam++;
		}
		rs = st.executeQuery();
		return rs;
	}

	public void update() throws Exception {
		if (getIdPedido() == null || getIdPedido() == 0) {
			throw new Exception("Erro, Pk IdPedido não setada. Update de pedido.");
		}
		sql = new StringBuffer();
		sql.append(" update pedido set id_pedido =  " + getIdPedido() + "  ");
		if (getIdLoja() != null) {
			sql.append(" ,  id_loja = ? ");
		}
		if (getNullIdLoja()) {
			sql.append(" ,  id_loja = null ");
		}
		if (getIdUsuario() != null) {
			sql.append(" ,  id_usuario = ? ");
		}
		if (getNullIdUsuario()) {
			sql.append(" ,  id_usuario = null ");
		}
		if (getDataPedido() != null) {
			sql.append(" ,  data_pedido = ? ");
		}
		if (getNullDataPedido()) {
			sql.append(" ,  data_pedido = null ");
		}
		if (getFlagStatus() != null) {
			sql.append(" ,  flag_status = ? ");
		}
		if (getNullFlagStatus()) {
			sql.append(" ,  flag_status = null ");
		}
		if (getValTotalprod() != null) {
			sql.append(" ,  val_totalprod = ? ");
		}
		if (getNullValTotalprod()) {
			sql.append(" ,  val_totalprod = null ");
		}
		if (getNumPed() != null) {
			sql.append(" ,  num_ped = ? ");
		}
		if (getNullNumPed()) {
			sql.append(" ,  num_ped = null ");
		}
		if (getIdModoPagamento() != null) {
			sql.append(" ,  id_modo_pagamento = ? ");
		}
		if (getNullIdModoPagamento()) {
			sql.append(" ,  id_modo_pagamento = null ");
		}
		if (getNumTelefonecontatoCliente() != null) {
			sql.append(" ,  num_telefonecontato_cliente = ? ");
		}
		if (getNullNumTelefonecontatoCliente()) {
			sql.append(" ,  num_telefonecontato_cliente = null ");
		}
		if (getTempoEstimadoEntrega() != null) {
			sql.append(" ,  tempo_estimado_entrega = ? ");
		}
		if (getNullTempoEstimadoEntrega()) {
			sql.append(" ,  tempo_estimado_entrega = null ");
		}
		if (getNomePessoa() != null) {
			sql.append(" ,  nome_pessoa = ? ");
		}
		if (getNullNomePessoa()) {
			sql.append(" ,  nome_pessoa = null ");
		}
		if (getNumMesaEntrega() != null) {
			sql.append(" ,  num_mesa_entrega = ? ");
		}
		if (getNullNumMesaEntrega()) {
			sql.append(" ,  num_mesa_entrega = null ");
		}
		if (getFlagVizualizado() != null) {
			sql.append(" ,  flag_vizualizado = ? ");
		}
		if (getNullFlagVizualizado()) {
			sql.append(" ,  flag_vizualizado = null ");
		}
		if (getNumTrocopara() != null) {
			sql.append(" ,  num_trocopara = ? ");
		}
		if (getNullNumTrocopara()) {
			sql.append(" ,  num_trocopara = null ");
		}
		if (getDescObservacao() != null) {
			sql.append(" ,  desc_observacao = ? ");
		}
		if (getNullDescObservacao()) {
			sql.append(" ,  desc_observacao = null ");
		}
		if (getFlagMarcado() != null) {
			sql.append(" ,  flag_marcado = ? ");
		}
		if (getNullFlagMarcado()) {
			sql.append(" ,  flag_marcado = null ");
		}
		sql.append(" where id_pedido =  " + getIdPedido() + "  ");
		if (getWhere() != null) {
			sql.append(" and " + getWhere() + " ");
		}
		st = conn.prepareStatement(sql.toString());
		int contparam = 1;
		if (getIdLoja() != null) {
			st.setInt(contparam, getIdLoja());
			contparam++;
		}
		if (getIdUsuario() != null) {
			st.setLong(contparam, getIdUsuario());
			contparam++;
		}
		if (getDataPedido() != null) {
			st.setTimestamp(contparam, getDataPedido());
			contparam++;
		}
		if (getFlagStatus() != null) {
			st.setString(contparam, getFlagStatus());
			contparam++;
		}
		if (getValTotalprod() != null) {
			st.setDouble(contparam, getValTotalprod());
			contparam++;
		}
		if (getNumPed() != null) {
			st.setLong(contparam, getNumPed());
			contparam++;
		}
		if (getIdModoPagamento() != null) {
			st.setInt(contparam, getIdModoPagamento());
			contparam++;
		}
		if (getNumTelefonecontatoCliente() != null) {
			st.setString(contparam, getNumTelefonecontatoCliente());
			contparam++;
		}
		if (getTempoEstimadoEntrega() != null) {
			st.setTimestamp(contparam, getTempoEstimadoEntrega());
			contparam++;
		}
		if (getNomePessoa() != null) {
			st.setString(contparam, getNomePessoa());
			contparam++;
		}
		if (getNumMesaEntrega() != null) {
			st.setString(contparam, getNumMesaEntrega());
			contparam++;
		}
		if (getFlagVizualizado() != null) {
			st.setString(contparam, getFlagVizualizado());
			contparam++;
		}
		if (getNumTrocopara() != null) {
			st.setDouble(contparam, getNumTrocopara());
			contparam++;
		}
		if (getDescObservacao() != null) {
			st.setString(contparam, getDescObservacao());
			contparam++;
		}
		if (getFlagMarcado() != null) {
			st.setString(contparam, getFlagMarcado());
			contparam++;
		}
		st.executeUpdate();
	}

	public void delete() throws Exception {
		sql = new StringBuffer();
		sql.append(" delete from pedido ");
		sql.append(" where id_pedido =  " + getIdPedido() + "  ");
		st = conn.prepareStatement(sql.toString());
		st.executeUpdate();
	}

	public void insert() throws Exception {
		sql = new StringBuffer();
		StringBuffer values = new StringBuffer();
		sql.append(" insert into pedido  (");
		values.append(" value (");
		if (getIdLoja() != null) {
			sql.append(" , id_loja ");
			values.append(", ? ");
		}
		if (getIdUsuario() != null) {
			sql.append(" , id_usuario ");
			values.append(", ? ");
		}
		if (getDataPedido() != null) {
			sql.append(" , data_pedido ");
			values.append(", ? ");
		}
		if (getFlagStatus() != null) {
			sql.append(" , flag_status ");
			values.append(", ? ");
		}
		if (getValTotalprod() != null) {
			sql.append(" , val_totalprod ");
			values.append(", ? ");
		}
		if (getNumPed() != null) {
			sql.append(" , num_ped ");
			values.append(", ? ");
		}
		if (getIdModoPagamento() != null) {
			sql.append(" , id_modo_pagamento ");
			values.append(", ? ");
		}
		if (getNumTelefonecontatoCliente() != null) {
			sql.append(" , num_telefonecontato_cliente ");
			values.append(", ? ");
		}
		if (getTempoEstimadoEntrega() != null) {
			sql.append(" , tempo_estimado_entrega ");
			values.append(", ? ");
		}
		if (getNomePessoa() != null) {
			sql.append(" , nome_pessoa ");
			values.append(", ? ");
		}
		if (getNumMesaEntrega() != null) {
			sql.append(" , num_mesa_entrega ");
			values.append(", ? ");
		}
		if (getFlagVizualizado() != null) {
			sql.append(" , flag_vizualizado ");
			values.append(", ? ");
		}
		if (getNumTrocopara() != null) {
			sql.append(" , num_trocopara ");
			values.append(", ? ");
		}
		if (getDescObservacao() != null) {
			sql.append(" , desc_observacao ");
			values.append(", ? ");
		}
		if (getFlagMarcado() != null) {
			sql.append(" , flag_marcado ");
			values.append(", ? ");
		}
		sql.append(" ) ");
		values.append(" ) ");
		sql = new StringBuffer(sql.toString().replaceFirst(",", ""));
		values = new StringBuffer(values.toString().replaceFirst(",", ""));
		sql.append(values.toString());
		st = conn.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
		int contparam = 1;
		if (getIdLoja() != null) {
			st.setInt(contparam, getIdLoja());
			contparam++;
		}
		if (getIdUsuario() != null) {
			st.setLong(contparam, getIdUsuario());
			contparam++;
		}
		if (getDataPedido() != null) {
			st.setTimestamp(contparam, getDataPedido());
			contparam++;
		}
		if (getFlagStatus() != null) {
			st.setString(contparam, getFlagStatus());
			contparam++;
		}
		if (getValTotalprod() != null) {
			st.setDouble(contparam, getValTotalprod());
			contparam++;
		}
		if (getNumPed() != null) {
			st.setLong(contparam, getNumPed());
			contparam++;
		}
		if (getIdModoPagamento() != null) {
			st.setInt(contparam, getIdModoPagamento());
			contparam++;
		}
		if (getNumTelefonecontatoCliente() != null) {
			st.setString(contparam, getNumTelefonecontatoCliente());
			contparam++;
		}
		if (getTempoEstimadoEntrega() != null) {
			st.setTimestamp(contparam, getTempoEstimadoEntrega());
			contparam++;
		}
		if (getNomePessoa() != null) {
			st.setString(contparam, getNomePessoa());
			contparam++;
		}
		if (getNumMesaEntrega() != null) {
			st.setString(contparam, getNumMesaEntrega());
			contparam++;
		}
		if (getFlagVizualizado() != null) {
			st.setString(contparam, getFlagVizualizado());
			contparam++;
		}
		if (getNumTrocopara() != null) {
			st.setDouble(contparam, getNumTrocopara());
			contparam++;
		}
		if (getDescObservacao() != null) {
			st.setString(contparam, getDescObservacao());
			contparam++;
		}
		if (getFlagMarcado() != null) {
			st.setString(contparam, getFlagMarcado());
			contparam++;
		}
		if (st.executeUpdate() == 1) {
			rs = st.getGeneratedKeys();
			if (rs.next()) {
				setIdPedido(rs.getLong(1));
			}
		} else {
			throw new Exception("Erro, contate suporte. Inserção de pedido.");
		}
	}

}