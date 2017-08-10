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

public class Ajax_Cidade{ 

 public void carregaUnicoAjax(HttpServletRequest request, HttpServletResponse response, Connection conn ) throws Exception{  JSONObject retorno = new JSONObject();	PrintWriter out = response.getWriter();  String pk = request.getParameter("cod_cidade") == null ? "" : request.getParameter("cod_cidade");   	if (!Utilitario.isNumeric(pk)) { throw new Exception("Parâmetro inválido!"); } 	Cidade obj = new Cidade(conn);  	obj.setCodCidade( Integer.parseInt(pk) ); 	obj.lista(); 	if(obj.next()){retorno.put("desc_cidade", obj.getDescCidade() == null ? "" : obj.getDescCidade() );retorno.put("id_estado", obj.getIdEstado() == null ? "" : obj.getIdEstado() ); 	} 	retorno.put("msg", ""); 	retorno.put("msgok", "ok"); 	out.print(retorno.toJSONString()); } public void SaveAjax(HttpServletRequest request, HttpServletResponse response, Connection conn ) throws Exception{  JSONObject retorno = new JSONObject();	PrintWriter out = response.getWriter();  String cod_cidade = request.getParameter("cod_cidade") == null ? "" : request.getParameter("cod_cidade");   String desc_cidade = request.getParameter("desc_cidade") == null ? "" : request.getParameter("desc_cidade");   String id_estado = request.getParameter("id_estado") == null ? "" : request.getParameter("id_estado");   	if (!Utilitario.isNumeric(cod_cidade)) { throw new Exception("Parâmetro inválido!"); } if(desc_cidade.equalsIgnoreCase("")){ throw new Exception("Campo desc_cidade esta em branco!"); }  	if (!Utilitario.isNumeric(id_estado)) { throw new Exception("Parâmetro inválido!"); } 	Cidade obj = new Cidade(conn);  	obj.setCodCidade( Integer.parseInt(cod_cidade) ); 	obj.setDescCidade( desc_cidade ); 	obj.setIdEstado( Integer.parseInt(id_estado) ); 	obj.insert(); 	obj.update(); 	retorno.put("msg", ""); 	retorno.put("msgok", "ok"); 	out.print(retorno.toJSONString()); } public void ListaAjax(HttpServletRequest request, HttpServletResponse response, Connection conn ) throws Exception{  JSONObject retorno = new JSONObject();JSONObject objjson = new JSONObject();	PrintWriter out = response.getWriter(); JSONArray array = new JSONArray(); String cod_cidade = request.getParameter("cod_cidade") == null ? "" : request.getParameter("cod_cidade");   String desc_cidade = request.getParameter("desc_cidade") == null ? "" : request.getParameter("desc_cidade");   String id_estado = request.getParameter("id_estado") == null ? "" : request.getParameter("id_estado");   	if (!Utilitario.isNumeric(cod_cidade)) { throw new Exception("Parâmetro inválido!"); } if(desc_cidade.equalsIgnoreCase("")){ throw new Exception("Campo desc_cidade esta em branco!"); }  	if (!Utilitario.isNumeric(id_estado)) { throw new Exception("Parâmetro inválido!"); } 	Cidade obj = new Cidade(conn);  if(!cod_cidade.equalsIgnoreCase("")){   	obj.setCodCidade( Integer.parseInt(cod_cidade) ); } if(!desc_cidade.equalsIgnoreCase("")){   	obj.setDescCidade( desc_cidade ); } if(!id_estado.equalsIgnoreCase("")){   	obj.setIdEstado( Integer.parseInt(id_estado) ); } 	obj.lista(); 	while(obj.next()){objjson = new JSONObject();objjson.put("cod_cidade", obj.getCodCidade() == null ? "" : obj.getCodCidade() );objjson.put("desc_cidade", obj.getDescCidade() == null ? "" : obj.getDescCidade() );objjson.put("id_estado", obj.getIdEstado() == null ? "" : obj.getIdEstado() );array.add(objjson); 	} 	retorno.put("lista", array); 	retorno.put("msg", ""); 	retorno.put("msgok", "ok"); 	out.print(retorno.toJSONString()); }
 
 }