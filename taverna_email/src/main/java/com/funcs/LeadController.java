package com.funcs;

import java.io.PrintWriter;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.json.simple.JSONObject;

import com.configs.Conexao;
import com.phpdao.domain.Campanha;
import com.phpdao.domain.UserPremio;

@SuppressWarnings("unchecked")
@WebServlet(urlPatterns = { "/campanha/*" })
public class LeadController extends javax.servlet.http.HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		processaRequisicoes(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		processaRequisicoes(request, response);
	}

	public void processaRequisicoes(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("--------entro lead");
		Map map = request.getParameterMap();
		for (Iterator iterator = map.keySet().iterator(); iterator.hasNext();) {
			String type = (String) iterator.next();
			System.out.println(type + " : " + request.getParameter(type));
		}

		try {
			request.setCharacterEncoding("UTF-8");

			String id = request.getParameter("ref");
			String ac = request.getParameter("acao") == null ? "" : request.getParameter("acao");

			if (id == null) {
				erroPage(request, response);
			} else if (ac.equalsIgnoreCase("ajax_w")) {
				Ajax_w.ajax_w(request, response);
			} else {
				abreCampanha(request, response);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			try {
				// exibeErro(request, response, ex);
			} catch (Exception e) {
			}
		}
	}

	private void erroPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			request.getRequestDispatcher("/WEB-INF/erroPage.html").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
		}
	}

	private void abreCampanha(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			request.getRequestDispatcher("/WEB-INF/template1.html").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
		}
	}

}
