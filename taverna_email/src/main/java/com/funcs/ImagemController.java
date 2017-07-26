package com.funcs;

import java.io.File;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.imageio.ImageIO;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.json.simple.JSONObject;

import com.configs.Conexao;

@SuppressWarnings("unchecked")
@WebServlet(urlPatterns = { "/imageup/*" })
@MultipartConfig(maxFileSize = 1024 * 1024 * 3, maxRequestSize = 1024 * 1024 * 50) //TODO tratar se todo for mais q 50mb
public class ImagemController extends javax.servlet.http.HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		processaRequisicoes(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		processaRequisicoes(request, response);
	}

	public void processaRequisicoes(HttpServletRequest request, HttpServletResponse response) {

		Connection conn = null;

		try {
			long coduser = Long.parseLong(request.getSession(false).getAttribute("id_user").toString());
			conn = Conexao.getConexao();
			conn.setAutoCommit(false);
			response.setContentType("text/x-json; charset=UTF-8");
			response.setDateHeader("Expires", 0);
			response.setDateHeader("Last-Modified", new java.util.Date().getTime());
			response.setHeader("Cache-Control", "no-cache, must-revalidate");
			response.setHeader("Pragma", "no-cache");
			request.setCharacterEncoding("UTF-8");

			if (request.getSession().getAttribute("id_user") != null) {
				gravaImagem(request, response, coduser, conn);
			} else {
				throw new Exception("Você não tem permissão para realizar esta operação.");
			}
			conn.commit();
		} catch (Exception ex) {
			try {
				JSONObject objRetorno = new JSONObject();
				PrintWriter out = response.getWriter();
				if (ex.getMessage() == null || ex.getMessage().equals("")) {
					objRetorno.put("erro", "Erro, por favor entrar em contato com suporte.");
				} else {
					if (ex.getMessage().contains("maximum permitted")) {
						objRetorno.put("erro", "O tamanho máximo para uma foto é de 3Mb.");
					} else {
						objRetorno.put("erro", ex.getMessage());
					}
				}

				ex.printStackTrace();
				out.print(objRetorno.toJSONString());
			} catch (Exception e1) {
			}

		} finally {
			try {
				conn.close();
			} catch (Exception ex) {
			}
		}
	}

	private String getFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		System.out.println("content-disposition header= " + contentDisp);
		String[] tokens = contentDisp.split(";");
		for (String token : tokens) {
			if (token.trim().startsWith("filename")) {
				return token.substring(token.indexOf("=") + 2, token.length() - 1);
			}
		}
		return "";
	}

	private void gravaImagem(HttpServletRequest request, HttpServletResponse response, long coduser, Connection conn) throws Exception {
		PrintWriter out = response.getWriter();
		JSONObject objRetorno = new JSONObject();

		Sys_parametros sys = new Sys_parametros(conn);
		PreparedStatement st;
		StringBuffer sql;
		ResultSet rs;
		int contparam = 1;
		long id_image = 0;

		String uploadFilePath = sys.getPath() + "/WEB-INF/" + coduser;

		File fileSaveDir = new File(uploadFilePath);
		if (!fileSaveDir.exists()) {
			fileSaveDir.mkdirs();
		}

		String fileName = null;
		// Get all the parts from request and write it to the file on server
		for (Part part : request.getParts()) {
			fileName = getFileName(part);
			InputStream input = part.getInputStream();
			try {
				ImageIO.read(input).toString();
			} catch (Exception e) {
				throw new Exception("O arquivo " + fileName + " não é uma imagem.");
			}
			id_image = Utilitario.retornaIdinsertLong("user_image", "id_image", conn);

			String path = uploadFilePath + File.separator + id_image + "_" + fileName;

			part.write(path);
			sql = new StringBuffer();
			sql.append("INSERT INTO user_image (id_image,id_usuario, desc_image, desc_path_system) ");
			sql.append("values (?,?,?,?)");
			st = conn.prepareStatement(sql.toString());

			contparam = 1;

			st.setLong(contparam, id_image);
			contparam++;

			st.setLong(contparam, coduser);
			contparam++;

			st.setString(contparam, fileName);
			contparam++;

			st.setString(contparam, path);
			contparam++;

			st.executeUpdate();
		}

		objRetorno.put("msg", "Imagens salvas!");
		objRetorno.put("msgok", "ok");

		out.print(objRetorno.toJSONString());

	}

}
