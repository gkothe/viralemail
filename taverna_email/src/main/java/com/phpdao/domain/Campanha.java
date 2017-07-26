package com.phpdao.domain;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.configs.Conexao;
import com.funcs.Sys_parametros;
import com.funcs.Utilitario;

public class Campanha implements java.io.Serializable {
	private Long idcampanha;
	private Long idusuario;
	private java.util.Date datacriacao;
	private String linkinicial;
	private String desc_nome;
	private String desc_obs;
	private PreparedStatement st;
	private StringBuffer sql;
	private ResultSet rs;
	private Connection conn;

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

	public Long getIdcampanha() {
		return idcampanha;
	}

	public void setIdcampanha(Long idcampanha) {
		this.idcampanha = idcampanha;
	}

	public Long getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(Long idusuario) {
		this.idusuario = idusuario;
	}

	public java.util.Date getDatacriacao() {
		return datacriacao;
	}

	public void setDatacriacao(java.util.Date datacriacao) {
		this.datacriacao = datacriacao;
	}

	public String getLinkinicial() {
		return linkinicial;
	}

	public void setLinkinicial(String linkinicial) {
		this.linkinicial = linkinicial;
	}

	public String getDesc_nome() {
		return desc_nome;
	}

	public void setDesc_nome(String desc_nome) {
		this.desc_nome = desc_nome;
	}

	public String getDesc_obs() {
		return desc_obs;
	}

	public void setDesc_obs(String desc_obs) {
		this.desc_obs = desc_obs;
	}

	public ResultSet lista() throws Exception {

		sql = new StringBuffer();
		sql.append(" select * from campanha where  1=1 ");

		if (getIdcampanha() != null) {
			sql.append(" and  id_campanha = ? ");
		}

		if (getIdusuario() != null) {
			sql.append(" and  id_usuario = ? ");
		}

		if (getLinkinicial() != null) {
			sql.append(" and  link_inicial = ? ");
		}

		st = conn.prepareStatement(sql.toString());

		int contparam = 1;

		if (getIdcampanha() != null) {
			st.setLong(contparam, getIdcampanha());
			contparam++;
		}

		if (getIdusuario() != null) {
			st.setLong(contparam, getIdusuario());
			contparam++;
		}

		if (getLinkinicial() != null) {
			st.setString(contparam, getLinkinicial());
			contparam++;
		}

		rs = st.executeQuery();

		return rs;
	}

	public static void updateCampanha(HttpServletRequest request, HttpServletResponse response, Connection conn, long user) throws Exception {
		Sys_parametros sys = new Sys_parametros(conn);
		PrintWriter out = response.getWriter();
		JSONObject objRetorno = new JSONObject();
		JSONObject param = Utilitario.getJsonFromRequest(request, response);
		PreparedStatement st;
		StringBuffer sql;
		ResultSet rs;

		long id_camapanha = Long.parseLong(param.get("id_campanha").toString());
		
		Campanha campanha = new Campanha(conn);
		campanha.setIdcampanha(id_camapanha);
		campanha.setIdusuario(user);
		rs  = campanha.lista();
		if(rs.next()){
			//deletar land_page features //TODO
			
			CampanhaLandpage landpage = new CampanhaLandpage(conn);
			landpage.setIdcampanha(id_camapanha);
			landpage.delete();
			
			landpage = new CampanhaLandpage(conn);
			landpage.setIdcampanha(id_camapanha);
			landpage.setDesctitulo1(param.get("desc_titulo_1").toString());
			landpage.setDescsubtitulo1(param.get("desc_sub_titulo_1").toString());
			landpage.setUrlvideo(param.get("url_video").toString());
			landpage.setDesccampanha(param.get("desc_campanha").toString());
			landpage.setDesctitulo2(param.get("desc_titulo_2").toString());
			landpage.setSubtitulo2(param.get("sub_titulo_2").toString());
			landpage.Insert();
			
		}else{
			throw new Exception("Campanha não encontrada.");
		}

		
		// landpage.setIdcampanha();

	}

	public static void InsertCampanha(HttpServletRequest request, HttpServletResponse response, Connection conn, long user) throws Exception {
		Sys_parametros sys = new Sys_parametros(conn);
		PrintWriter out = response.getWriter();
		JSONObject objRetorno = new JSONObject();
		JSONObject param = Utilitario.getJsonFromRequest(request, response);
		PreparedStatement st;
		StringBuffer sql;
		ResultSet rs;

		if (param.get("desc_nome").toString().equalsIgnoreCase("")) {
			throw new Exception("Você deve inserir o nome da sua camapanha.");
		}

		int id_camapanha = Utilitario.retornaIdinsert("campanha", "id_campanha", conn);

		// String ref = Utilitario.StringGen(1000, 32).substring(0, 10) + "_"+id_camapanha;
		/*
		 * Campanha camp = new Campanha(conn); camp.setLinkinicial(ref); rs = camp.lista(); while (rs.next()) { ref = Utilitario.StringGen(1000, 32).substring(0, 10); camp = new Campanha(conn); camp.setLinkinicial(ref); rs.close(); rs = camp.lista(); }
		 */

		sql = new StringBuffer();
		sql.append("INSERT INTO campanha (id_campanha,id_usuario, data_criacao, link_inicial, desc_nome, desc_obs) ");
		sql.append("values (?,?,now(),?,?,?)");
		st = conn.prepareStatement(sql.toString());

		int contparam = 1;

		st.setInt(contparam, id_camapanha);
		contparam++;

		st.setLong(contparam, user);
		contparam++;

		st.setString(contparam, id_camapanha + "");// ver se botar o link de fato //TODO
		contparam++;

		st.setString(contparam, param.get("desc_nome").toString());
		contparam++;

		st.setString(contparam, param.get("desc_observacao").toString());
		contparam++;

		st.executeUpdate();

		objRetorno.put("id_campanha", id_camapanha);
		objRetorno.put("msgok", "ok");
		objRetorno.put("msg", "Campanha criada!");

		out.print(objRetorno.toJSONString());

	}

	public Campanha(Connection conn) {
		super();
		this.conn = conn;
	}

}