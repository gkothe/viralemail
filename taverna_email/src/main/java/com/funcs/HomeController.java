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
import com.phpdao.domain.HM_Campanha;
import com.phpdao.domain.HM_UserPremios;

@SuppressWarnings("unchecked")
@WebServlet(urlPatterns = { "/home/*" })
public class HomeController extends javax.servlet.http.HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		processaRequisicoes(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		processaRequisicoes(request, response);
	}

	public void processaRequisicoes(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("--------entro home");
		Map map = request.getParameterMap();
		for (Iterator iterator = map.keySet().iterator(); iterator.hasNext();) {
			String type = (String) iterator.next();
			System.out.println(type + " : " + request.getParameter(type));
		}

		try {

			String strTipo = request.getParameter("ac");
			if (strTipo == null) {
				strTipo = "home";
			}

			request.setCharacterEncoding("UTF-8");

			if (request.getSession().getAttribute("id_user") == null) {
				if (strTipo.equalsIgnoreCase("ajax")) {
					ajaxErro(request, response);
				} else {
					request.getSession().invalidate();
					response.sendRedirect(request.getContextPath() + "/");
				}
			} else {

				if (strTipo.equalsIgnoreCase("campanhaInsert")) {
					campanhaInsert(request, response);
				} else if (strTipo.equalsIgnoreCase("campanhaEdit")) {
					campanhaEdit(request, response);
				} else if (strTipo.equalsIgnoreCase("uploadImage")) {
					uploadImage(request, response);
				} else if (strTipo.equalsIgnoreCase("insertPremio")) {
					insertPremio(request, response);
				} else if (strTipo.equalsIgnoreCase("listaped")) {
					dashpedidos(request, response);
				} else if (strTipo.equalsIgnoreCase("home")) {
					home(request, response);
				} else if (strTipo.equalsIgnoreCase("campanha_lista")) {
					campanha_lista(request, response);
				} else if (strTipo.equalsIgnoreCase("campanha_detail")) {
					campanha_details(request, response);
				} else if (strTipo.equalsIgnoreCase("listaped")) {
					dashpedidos(request, response);
				} else if (strTipo.equalsIgnoreCase("logout")) {
					request.getSession().invalidate();
					response.sendRedirect(request.getContextPath() + "/");
					// request.getRequestDispatcher("").forward(request,
					// response);
					return;
				} else if (strTipo.equalsIgnoreCase("ajax")) {
					ajax(request, response);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			try {
				// exibeErro(request, response, ex);
			} catch (Exception e) {
			}
		}
	}

	private void ajaxErro(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PrintWriter out = response.getWriter();

		response.setContentType("text/x-json; charset=UTF-8");
		response.setDateHeader("Expires", 0);
		response.setDateHeader("Last-Modified", new java.util.Date().getTime());
		response.setHeader("Cache-Control", "no-cache, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		request.setCharacterEncoding("UTF-8");

		JSONObject objRetorno = new JSONObject();

		try {
			objRetorno.put("errologin", "Por favor realize o login novamente!");
			out.print(objRetorno.toJSONString());
		} catch (Exception ex) {

			ex.printStackTrace();
			out.print(objRetorno.toJSONString());

		}
	}

	private void ajax(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PrintWriter out = response.getWriter();

		response.setContentType("text/x-json; charset=UTF-8");
		response.setDateHeader("Expires", 0);
		response.setDateHeader("Last-Modified", new java.util.Date().getTime());
		response.setHeader("Cache-Control", "no-cache, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		request.setCharacterEncoding("UTF-8");

		long coduser = Long.parseLong(request.getSession(false).getAttribute("id_user").toString());
		Connection conn = null;
		JSONObject objRetorno = new JSONObject();

		try {
			conn = Conexao.getConexao();
			conn.setAutoCommit(false);
			String cmd = request.getParameter("cmd");

			if (cmd.equalsIgnoreCase("insertCamapanha")) {
				HM_Campanha.InsertCampanha(request, response, conn, coduser);
			} else if (cmd.equalsIgnoreCase("updateCamapanha")) {
				HM_Campanha.updateCampanha(request, response, conn, coduser);
			} else if (cmd.equalsIgnoreCase("insertPremio")) {
				HM_UserPremios.insertPremio(request, response, conn, coduser);
			} else if (cmd.equalsIgnoreCase("loadCampanha")) {
				HM_Campanha.LoadCampanha(request, response, conn, coduser);
			}else if (cmd.equalsIgnoreCase("listaCampanhas")) {
				HM_Campanha.listaCampanhas(request, response, conn, coduser);
			}else if (cmd.equalsIgnoreCase("loadCampanhaDetail")) {
				HM_Campanha.LoadCampanhaDetails(request, response, conn, coduser);
			}
			
			

			conn.commit();
		} catch (Exception ex) {
			if (ex.getMessage() == null || ex.getMessage().equals("")) {
				objRetorno.put("erro", "Erro, por favor entrar em contato com suporte.");
			} else {
				objRetorno.put("erro", ex.getMessage());
			}

			ex.printStackTrace();
			out.print(objRetorno.toJSONString());
			try {
				conn.rollback();
			} catch (Exception exr) {
			}
		} finally {
			try {
				conn.close();
			} catch (Exception ex) {
			}
		}
	}

	private void uploadImage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			request.getRequestDispatcher("/WEB-INF/upload_image.html").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
		}
	}

	private void home(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			request.getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
		}
	}

	private void campanhaInsert(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			request.getRequestDispatcher("/WEB-INF/camapanha_insert.html").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
		}
	}

	private void campanha_details(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			request.getRequestDispatcher("/WEB-INF/campanha_details.html").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
		}
	}

	private void campanhaEdit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			request.getRequestDispatcher("/WEB-INF/camapanha_edit.html").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
		}
	}
	
	private void campanha_lista(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			request.getRequestDispatcher("/WEB-INF/campanha_lista.html").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
		}
	}
	private void insertPremio(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			request.getRequestDispatcher("/WEB-INF/insert_premio.html").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
		}
	}

	
	private void dashpedidos(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			request.getRequestDispatcher("/WEB-INF/dash1_pedidos.html").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
		}
	}

}
