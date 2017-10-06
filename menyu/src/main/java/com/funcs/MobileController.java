package com.funcs;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.configs.AcessoController;
import com.configs.Conexao;
import com.configs.SysController;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/api" })
//Não logado
public class MobileController extends javax.servlet.http.HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		processaRequisicoes(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		processaRequisicoes(request, response);
	}
	

	protected void doOptions(HttpServletRequest request, HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Methods", "GET, POST");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Headers", "AUTHORIZATION,X-Auth-Token");
	}


	private void processaRequisicoes(HttpServletRequest request, HttpServletResponse response) {

		try {
//
			Map map = request.getParameterMap();
			for (Iterator iterator = map.keySet().iterator(); iterator.hasNext();) {
				String type = (String) iterator.next();
				System.out.println(type + " : " + request.getParameter(type));
			}

			request.setCharacterEncoding("UTF-8");

			String identAcao = request.getParameter("acao") == null ? "" : request.getParameter("acao").toString().trim();

			if (identAcao.equalsIgnoreCase("ajax_w")) {//ajax sem auth token
				Ajax_w.ajax_w(request, response);
			}else if (identAcao.equalsIgnoreCase("ajax")) {//ajax com authtoken
				Ajax.ajax(request, response);
			} 

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	

}
