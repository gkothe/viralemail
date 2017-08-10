package com.gerador; 
import com.funcs.Utilitario; 
import java.util.Date; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
import org.json.simple.JSONObject; 
import java.sql.Connection; 
import java.text.SimpleDateFormat; 
import java.io.PrintWriter; 
import org.json.simple.JSONArray; 

public class Ajax_Campanha{ 

 public void carregaUnicoAjax(HttpServletRequest request, HttpServletResponse response, Connection conn ) throws Exception{  JSONObject retorno = new JSONObject();	PrintWriter out = response.getWriter();  String pk = request.getParameter("id_campanha") == null ? "" : request.getParameter("id_campanha");   	if (!Utilitario.isNumeric(pk)) { throw new Exception("Parâmetro inválido!"); } 	Campanha obj = new Campanha(conn);  	obj.setIdCampanha( Long.parseLong(pk) ); 	obj.lista(); 	if(obj.next()){retorno.put("id_usuario", obj.getIdUsuario() == null ? 0 : obj.getIdUsuario() );retorno.put("data_criacao", obj.getDataCriacao() == null ? 0 :new SimpleDateFormat("dd/MM/yyyy HH:mm").format(obj.getDataCriacao() ));retorno.put("link_inicial", obj.getLinkInicial() == null ? "" : obj.getLinkInicial() );retorno.put("desc_nome", obj.getDescNome() == null ? "" : obj.getDescNome() );retorno.put("desc_obs", obj.getDescObs() == null ? "" : obj.getDescObs() );retorno.put("flag_ativo", obj.getFlagAtivo() == null ? "" : obj.getFlagAtivo() ); 	} 	retorno.put("msg", ""); 	retorno.put("msgok", "ok"); 	out.print(retorno.toJSONString()); } public void SaveAjax(HttpServletRequest request, HttpServletResponse response, Connection conn ) throws Exception{  JSONObject retorno = new JSONObject();	PrintWriter out = response.getWriter();  String id_campanha = request.getParameter("id_campanha") == null ? "" : request.getParameter("id_campanha");   String id_usuario = request.getParameter("id_usuario") == null ? "" : request.getParameter("id_usuario");   String data_criacao = request.getParameter("data_criacao") == null ? "" : request.getParameter("data_criacao");   String link_inicial = request.getParameter("link_inicial") == null ? "" : request.getParameter("link_inicial");   String desc_nome = request.getParameter("desc_nome") == null ? "" : request.getParameter("desc_nome");   String desc_obs = request.getParameter("desc_obs") == null ? "" : request.getParameter("desc_obs");   String flag_ativo = request.getParameter("flag_ativo") == null ? "" : request.getParameter("flag_ativo");   	if (!Utilitario.isNumeric(id_campanha)) { throw new Exception("Parâmetro inválido!"); } 	if (!Utilitario.isNumeric(id_usuario)) { throw new Exception("Parâmetro inválido!"); } if(data_criacao.equalsIgnoreCase("")){ throw new Exception("Campo data_criacao esta em branco!"); }  if(link_inicial.equalsIgnoreCase("")){ throw new Exception("Campo link_inicial esta em branco!"); }  if(desc_nome.equalsIgnoreCase("")){ throw new Exception("Campo desc_nome esta em branco!"); }  if(desc_obs.equalsIgnoreCase("")){ throw new Exception("Campo desc_obs esta em branco!"); }  if(flag_ativo.equalsIgnoreCase("")){ throw new Exception("Campo flag_ativo esta em branco!"); }  	Campanha obj = new Campanha(conn);  	obj.setIdCampanha( Long.parseLong(id_campanha) ); 	obj.setIdUsuario( Long.parseLong(id_usuario) ); 	obj.setDataCriacao(	Utilitario.getTimeStamp(new SimpleDateFormat("dd/MM/yyyy").parse(data_criacao)) ); 	obj.setLinkInicial( link_inicial ); 	obj.setDescNome( desc_nome ); 	obj.setDescObs( desc_obs ); 	obj.setFlagAtivo( flag_ativo ); 	obj.insert(); 	obj.update(); 	retorno.put("msg", ""); 	retorno.put("msgok", "ok"); 	out.print(retorno.toJSONString()); } public void ListaAjax(HttpServletRequest request, HttpServletResponse response, Connection conn ) throws Exception{  JSONObject retorno = new JSONObject();JSONObject objjson = new JSONObject();	PrintWriter out = response.getWriter(); JSONArray array = new JSONArray(); String id_campanha = request.getParameter("id_campanha") == null ? "" : request.getParameter("id_campanha");   String id_usuario = request.getParameter("id_usuario") == null ? "" : request.getParameter("id_usuario");   String data_criacao = request.getParameter("data_criacao") == null ? "" : request.getParameter("data_criacao");   String link_inicial = request.getParameter("link_inicial") == null ? "" : request.getParameter("link_inicial");   String desc_nome = request.getParameter("desc_nome") == null ? "" : request.getParameter("desc_nome");   String desc_obs = request.getParameter("desc_obs") == null ? "" : request.getParameter("desc_obs");   String flag_ativo = request.getParameter("flag_ativo") == null ? "" : request.getParameter("flag_ativo");   	if (!Utilitario.isNumeric(id_campanha)) { throw new Exception("Parâmetro inválido!"); } 	if (!Utilitario.isNumeric(id_usuario)) { throw new Exception("Parâmetro inválido!"); } if(data_criacao.equalsIgnoreCase("")){ throw new Exception("Campo data_criacao esta em branco!"); }  if(link_inicial.equalsIgnoreCase("")){ throw new Exception("Campo link_inicial esta em branco!"); }  if(desc_nome.equalsIgnoreCase("")){ throw new Exception("Campo desc_nome esta em branco!"); }  if(desc_obs.equalsIgnoreCase("")){ throw new Exception("Campo desc_obs esta em branco!"); }  if(flag_ativo.equalsIgnoreCase("")){ throw new Exception("Campo flag_ativo esta em branco!"); }  	Campanha obj = new Campanha(conn);  if(!id_campanha.equalsIgnoreCase("")){   	obj.setIdCampanha( Long.parseLong(id_campanha) ); } if(!id_usuario.equalsIgnoreCase("")){   	obj.setIdUsuario( Long.parseLong(id_usuario) ); } if(!data_criacao.equalsIgnoreCase("")){   	obj.setDataCriacao(	Utilitario.getTimeStamp(new SimpleDateFormat("dd/MM/yyyy").parse(data_criacao)) ); } if(!link_inicial.equalsIgnoreCase("")){   	obj.setLinkInicial( link_inicial ); } if(!desc_nome.equalsIgnoreCase("")){   	obj.setDescNome( desc_nome ); } if(!desc_obs.equalsIgnoreCase("")){   	obj.setDescObs( desc_obs ); } if(!flag_ativo.equalsIgnoreCase("")){   	obj.setFlagAtivo( flag_ativo ); } 	obj.lista(); 	while(obj.next()){objjson = new JSONObject();objjson.put("id_campanha", obj.getIdCampanha() == null ? 0 : obj.getIdCampanha() );objjson.put("id_usuario", obj.getIdUsuario() == null ? 0 : obj.getIdUsuario() );objjson.put("data_criacao", obj.getDataCriacao() == null ? 0 :new SimpleDateFormat("dd/MM/yyyy HH:mm").format(obj.getDataCriacao() ));objjson.put("link_inicial", obj.getLinkInicial() == null ? "" : obj.getLinkInicial() );objjson.put("desc_nome", obj.getDescNome() == null ? "" : obj.getDescNome() );objjson.put("desc_obs", obj.getDescObs() == null ? "" : obj.getDescObs() );objjson.put("flag_ativo", obj.getFlagAtivo() == null ? "" : obj.getFlagAtivo() );array.add(objjson); 	} 	retorno.put("lista", array); 	retorno.put("msg", ""); 	retorno.put("msgok", "ok"); 	out.print(retorno.toJSONString()); }
 
 }