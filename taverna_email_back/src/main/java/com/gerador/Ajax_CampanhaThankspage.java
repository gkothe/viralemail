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

public class Ajax_CampanhaThankspage{ 

 public void carregaUnicoAjax(HttpServletRequest request, HttpServletResponse response, Connection conn ) throws Exception{  JSONObject retorno = new JSONObject();	PrintWriter out = response.getWriter();  String pk = request.getParameter("id_thankspage") == null ? "" : request.getParameter("id_thankspage");   	if (!Utilitario.isNumeric(pk)) { throw new Exception("Parâmetro inválido!"); } 	CampanhaThankspage obj = new CampanhaThankspage(conn);  	obj.setIdThankspage( Long.parseLong(pk) ); 	obj.lista(); 	if(obj.next()){retorno.put("id_campanha", obj.getIdCampanha() == null ? 0 : obj.getIdCampanha() );retorno.put("msg_thanks", obj.getMsgThanks() == null ? "" : obj.getMsgThanks() );retorno.put("sub_titulo", obj.getSubTitulo() == null ? "" : obj.getSubTitulo() );retorno.put("url_video", obj.getUrlVideo() == null ? "" : obj.getUrlVideo() );retorno.put("desc_frase", obj.getDescFrase() == null ? "" : obj.getDescFrase() );retorno.put("desc_frase2", obj.getDescFrase2() == null ? "" : obj.getDescFrase2() );retorno.put("desc_texto", obj.getDescTexto() == null ? "" : obj.getDescTexto() ); 	} 	retorno.put("msg", ""); 	retorno.put("msgok", "ok"); 	out.print(retorno.toJSONString()); } public void SaveAjax(HttpServletRequest request, HttpServletResponse response, Connection conn ) throws Exception{  JSONObject retorno = new JSONObject();	PrintWriter out = response.getWriter();  String id_thankspage = request.getParameter("id_thankspage") == null ? "" : request.getParameter("id_thankspage");   String id_campanha = request.getParameter("id_campanha") == null ? "" : request.getParameter("id_campanha");   String msg_thanks = request.getParameter("msg_thanks") == null ? "" : request.getParameter("msg_thanks");   String sub_titulo = request.getParameter("sub_titulo") == null ? "" : request.getParameter("sub_titulo");   String url_video = request.getParameter("url_video") == null ? "" : request.getParameter("url_video");   String desc_frase = request.getParameter("desc_frase") == null ? "" : request.getParameter("desc_frase");   String desc_frase2 = request.getParameter("desc_frase2") == null ? "" : request.getParameter("desc_frase2");   String desc_texto = request.getParameter("desc_texto") == null ? "" : request.getParameter("desc_texto");   	if (!Utilitario.isNumeric(id_thankspage)) { throw new Exception("Parâmetro inválido!"); } 	if (!Utilitario.isNumeric(id_campanha)) { throw new Exception("Parâmetro inválido!"); } if(msg_thanks.equalsIgnoreCase("")){ throw new Exception("Campo msg_thanks esta em branco!"); }  if(sub_titulo.equalsIgnoreCase("")){ throw new Exception("Campo sub_titulo esta em branco!"); }  if(url_video.equalsIgnoreCase("")){ throw new Exception("Campo url_video esta em branco!"); }  if(desc_frase.equalsIgnoreCase("")){ throw new Exception("Campo desc_frase esta em branco!"); }  if(desc_frase2.equalsIgnoreCase("")){ throw new Exception("Campo desc_frase2 esta em branco!"); }  if(desc_texto.equalsIgnoreCase("")){ throw new Exception("Campo desc_texto esta em branco!"); }  	CampanhaThankspage obj = new CampanhaThankspage(conn);  	obj.setIdThankspage( Long.parseLong(id_thankspage) ); 	obj.setIdCampanha( Long.parseLong(id_campanha) ); 	obj.setMsgThanks( msg_thanks ); 	obj.setSubTitulo( sub_titulo ); 	obj.setUrlVideo( url_video ); 	obj.setDescFrase( desc_frase ); 	obj.setDescFrase2( desc_frase2 ); 	obj.setDescTexto( desc_texto ); 	obj.insert(); 	obj.update(); 	retorno.put("msg", ""); 	retorno.put("msgok", "ok"); 	out.print(retorno.toJSONString()); } public void ListaAjax(HttpServletRequest request, HttpServletResponse response, Connection conn ) throws Exception{  JSONObject retorno = new JSONObject();JSONObject objjson = new JSONObject();	PrintWriter out = response.getWriter(); JSONArray array = new JSONArray(); String id_thankspage = request.getParameter("id_thankspage") == null ? "" : request.getParameter("id_thankspage");   String id_campanha = request.getParameter("id_campanha") == null ? "" : request.getParameter("id_campanha");   String msg_thanks = request.getParameter("msg_thanks") == null ? "" : request.getParameter("msg_thanks");   String sub_titulo = request.getParameter("sub_titulo") == null ? "" : request.getParameter("sub_titulo");   String url_video = request.getParameter("url_video") == null ? "" : request.getParameter("url_video");   String desc_frase = request.getParameter("desc_frase") == null ? "" : request.getParameter("desc_frase");   String desc_frase2 = request.getParameter("desc_frase2") == null ? "" : request.getParameter("desc_frase2");   String desc_texto = request.getParameter("desc_texto") == null ? "" : request.getParameter("desc_texto");   	if (!Utilitario.isNumeric(id_thankspage)) { throw new Exception("Parâmetro inválido!"); } 	if (!Utilitario.isNumeric(id_campanha)) { throw new Exception("Parâmetro inválido!"); } if(msg_thanks.equalsIgnoreCase("")){ throw new Exception("Campo msg_thanks esta em branco!"); }  if(sub_titulo.equalsIgnoreCase("")){ throw new Exception("Campo sub_titulo esta em branco!"); }  if(url_video.equalsIgnoreCase("")){ throw new Exception("Campo url_video esta em branco!"); }  if(desc_frase.equalsIgnoreCase("")){ throw new Exception("Campo desc_frase esta em branco!"); }  if(desc_frase2.equalsIgnoreCase("")){ throw new Exception("Campo desc_frase2 esta em branco!"); }  if(desc_texto.equalsIgnoreCase("")){ throw new Exception("Campo desc_texto esta em branco!"); }  	CampanhaThankspage obj = new CampanhaThankspage(conn);  if(!id_thankspage.equalsIgnoreCase("")){   	obj.setIdThankspage( Long.parseLong(id_thankspage) ); } if(!id_campanha.equalsIgnoreCase("")){   	obj.setIdCampanha( Long.parseLong(id_campanha) ); } if(!msg_thanks.equalsIgnoreCase("")){   	obj.setMsgThanks( msg_thanks ); } if(!sub_titulo.equalsIgnoreCase("")){   	obj.setSubTitulo( sub_titulo ); } if(!url_video.equalsIgnoreCase("")){   	obj.setUrlVideo( url_video ); } if(!desc_frase.equalsIgnoreCase("")){   	obj.setDescFrase( desc_frase ); } if(!desc_frase2.equalsIgnoreCase("")){   	obj.setDescFrase2( desc_frase2 ); } if(!desc_texto.equalsIgnoreCase("")){   	obj.setDescTexto( desc_texto ); } 	obj.lista(); 	while(obj.next()){objjson = new JSONObject();objjson.put("id_thankspage", obj.getIdThankspage() == null ? 0 : obj.getIdThankspage() );objjson.put("id_campanha", obj.getIdCampanha() == null ? 0 : obj.getIdCampanha() );objjson.put("msg_thanks", obj.getMsgThanks() == null ? "" : obj.getMsgThanks() );objjson.put("sub_titulo", obj.getSubTitulo() == null ? "" : obj.getSubTitulo() );objjson.put("url_video", obj.getUrlVideo() == null ? "" : obj.getUrlVideo() );objjson.put("desc_frase", obj.getDescFrase() == null ? "" : obj.getDescFrase() );objjson.put("desc_frase2", obj.getDescFrase2() == null ? "" : obj.getDescFrase2() );objjson.put("desc_texto", obj.getDescTexto() == null ? "" : obj.getDescTexto() );array.add(objjson); 	} 	retorno.put("lista", array); 	retorno.put("msg", ""); 	retorno.put("msgok", "ok"); 	out.print(retorno.toJSONString()); }
 
 }