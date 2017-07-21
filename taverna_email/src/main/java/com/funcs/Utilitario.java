package com.funcs;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.HtmlEmail;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.configs.Conexao;

public class Utilitario {



	public static JSONObject getJsonFromRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		JSONObject obj = new JSONObject();

		Map map = request.getParameterMap();
		for (Iterator iterator = map.keySet().iterator(); iterator.hasNext();) {
			String type = (String) iterator.next();
			obj.put(type, request.getParameter(type) == null ? "" : request.getParameter(type));
		}

		return obj;

	}

	public static JSONArray FlagEntreRet() {
		JSONArray payids = new JSONArray();
		JSONObject obj = new JSONObject();

		obj = new JSONObject();
		obj.put("flag_entre_ret", "L");
		obj.put("desc", "Retirada no local");
		payids.add(obj);

		obj = new JSONObject();
		obj.put("flag_entre_ret", "T");
		obj.put("desc", "Tele-entrega");
		payids.add(obj);

		obj = new JSONObject();
		obj.put("flag_entre_ret", "A");
		obj.put("desc", "Agendamento");
		payids.add(obj);

		return payids;

	}

	public static boolean isNumeric(String str) {
		try {
			double d = Double.parseDouble(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	public static void sendEmail(String para, String html, String subject, Connection conn) throws Exception {
		Sys_parametros sys = new Sys_parametros(conn);
		String rodape = "";
		System.setProperty("mail.mime.charset", "UTF-8");

		HtmlEmail mailService = new HtmlEmail();
		mailService.setHostName(sys.getSys_host_name_smtp());
		mailService.setSmtpPort(sys.getSys_smtp_port());
		mailService.setAuthenticator(new DefaultAuthenticator(sys.getSys_email(), sys.getSys_senha()));
		mailService.setFrom(sys.getSys_fromemail(), sys.getSys_fromdesc());
		mailService.setStartTLSEnabled(sys.getSys_tls());
		mailService.setSubject(subject);
		mailService.setHtmlMsg(html + rodape);
		mailService.addTo(para);
		mailService.setCharset("utf-8");
		mailService.send();

		System.out.println("Email sent:" + new Date());
	}

	public static String StringGen(int a, int b) {
		SecureRandom random = new SecureRandom();
		return new BigInteger(a, random).toString(b);
	}


	public static String getDescMes(int mes) {

		if (mes == 1) {
			return "Janeiro";
		} else if (mes == 2) {
			return "Fevereiro";
		} else if (mes == 3) {
			return "Março";
		} else if (mes == 4) {
			return "Abril";
		} else if (mes == 5) {
			return "Maio";
		} else if (mes == 6) {
			return "Junho";
		} else if (mes == 7) {
			return "Julho";
		} else if (mes == 8) {
			return "Agosto";
		} else if (mes == 9) {
			return "Setembro";
		} else if (mes == 10) {
			return "Outubro";
		} else if (mes == 11) {
			return "Novembro";
		} else if (mes == 12) {
			return "Dezembro";
		}

		return "Inválido";
	}

	public static int getnumMes(String mes) {

		if (mes.equalsIgnoreCase("janeiro")) {
			return 1;
		} else if (mes.equalsIgnoreCase("Fevereiro")) {
			return 2;
		} else if (mes.equalsIgnoreCase("Março")) {
			return 3;
		} else if (mes.equalsIgnoreCase("Abril")) {
			return 4;
		} else if (mes.equalsIgnoreCase("Maio")) {
			return 5;
		} else if (mes.equalsIgnoreCase("Junho")) {
			return 6;
		} else if (mes.equalsIgnoreCase("Julho")) {
			return 7;
		} else if (mes.equalsIgnoreCase("Agosto")) {
			return 8;
		} else if (mes.equalsIgnoreCase("Setembro")) {
			return 9;
		} else if (mes.equalsIgnoreCase("Outubro")) {
			return 10;
		} else if (mes.equalsIgnoreCase("novembro")) {
			return 11;
		} else if (mes.equalsIgnoreCase("dezembro")) {
			return 12;
		}
		return 0;
	}


	//




	

	public static int retornaIdinsert(String tabela, String coluna, Connection conn) throws Exception {
		String varname1 = "";
		// so funciona para pk single
		varname1 = "";
		varname1 += "SELECT ";
		varname1 += " z.expected AS missing ";
		varname1 += "FROM ( ";
		varname1 += " SELECT ";
		varname1 += "  @rownum:=@rownum+1 AS expected, ";
		varname1 += "  IF(@rownum=" + coluna + ", 0, @rownum:=" + coluna + ") AS got ";
		varname1 += " FROM ";
		varname1 += "  (SELECT @rownum:=0) AS a ";
		varname1 += "  JOIN  " + tabela;
		varname1 += "  ORDER BY  " + coluna;
		varname1 += " ) AS z ";
		varname1 += " WHERE z.got!=0 ";
		varname1 += "union ";
		varname1 += " select  Coalesce(max(" + coluna + "+1),1)     AS missing from  " + tabela;
		varname1 += " limit 1";

		PreparedStatement st = conn.prepareStatement(varname1);
		int id = 1;
		ResultSet rs2 = st.executeQuery();
		if (rs2.next()) {
			id = rs2.getInt("missing");
		}

		return id;
	}

	public static long retornaIdinsertLong(String tabela, String coluna, Connection conn) throws Exception {
		String varname1 = "";
		// so funciona para pk single
		varname1 = "";
		varname1 += "SELECT ";
		varname1 += " z.expected AS missing ";
		varname1 += "FROM ( ";
		varname1 += " SELECT ";
		varname1 += "  @rownum:=@rownum+1 AS expected, ";
		varname1 += "  IF(@rownum=" + coluna + ", 0, @rownum:=" + coluna + ") AS got ";
		varname1 += " FROM ";
		varname1 += "  (SELECT @rownum:=0) AS a ";
		varname1 += "  JOIN  " + tabela;
		varname1 += "  ORDER BY  " + coluna;
		varname1 += " ) AS z ";
		varname1 += " WHERE z.got!=0 ";
		varname1 += "union ";
		varname1 += " select  Coalesce(max(" + coluna + "+1),1)     AS missing from  " + tabela;
		varname1 += " limit 1";

		PreparedStatement st = conn.prepareStatement(varname1);
		long id = 1;
		ResultSet rs2 = st.executeQuery();
		if (rs2.next()) {
			id = rs2.getLong("missing");
		}

		return id;
	}

	public static Integer diaSemanaSimple(Connection conn) throws Exception {

		// de acordo com o que ta no banco de dados, se for DAY_OF_WEEK = 1 vai ser domingo (codigo 7 no banco), resto é o dia menos 1.
		// 1 Segunda-feira
		// 2 Terça-feira
		// 3 Quarta-feira
		// 4 Quinta-feira
		// 5 Sexta-feira
		// 6 Sábado
		// 7 Domingo
		// 8 Feriado/custom

		// Calendar
		// SUNDAY, 1
		// MONDAY, 2
		// TUESDAY, 3
		// WEDNESDAY 4
		// THURSDAY, 5
		// FRIDAY, 6
		// SATURDAY. 7

		return new GregorianCalendar().get(Calendar.DAY_OF_WEEK) == 1 ? 7 : new GregorianCalendar().get(Calendar.DAY_OF_WEEK) - 1;
	}

	public static Integer diaDasemanaFromDate(String date) throws Exception {

		Calendar c = Calendar.getInstance();
		c.setTime(new SimpleDateFormat("dd/MM/yyyy").parse(date));
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		if (dayOfWeek == 1) {
			dayOfWeek = 7;
		} else {
			dayOfWeek = dayOfWeek - 1;
		}
		return dayOfWeek;

	}

	

	public static Date testeHora(String mask, String hora, String msg) throws Exception {

		Date datatempoentregateste2;// tempo de entrega do usuario
		try {
			datatempoentregateste2 = new SimpleDateFormat(mask).parse(hora);
		} catch (Exception e) {
			if (msg.equalsIgnoreCase("")) {
				throw new Exception("Horario inválido");
			} else {
				throw new Exception(msg);
			}

		}

		if (mask.equalsIgnoreCase("HH:mm")) {

			int t = Integer.parseInt(hora.substring(0, 2));
			if (t > 24)
				throw new Exception("As horas não pode ser maior que 24.");

			t = Integer.parseInt(hora.substring(3, 5));
			if (t > 59)
				throw new Exception("Os minutos não podem ser maior que 59.");

		}

		if (mask.equalsIgnoreCase("HHmm")) {

			int t = Integer.parseInt(hora.substring(0, 2));
			if (t > 24)
				throw new Exception("As horas não pode ser maior que 24.");

			t = Integer.parseInt(hora.substring(2, 4));
			if (t > 59)
				throw new Exception("Os minutos não podem ser maior que 59.");

		}

		return datatempoentregateste2;

	}





	


	public static java.sql.Timestamp getTimeStamp(Date data) {
		return new java.sql.Timestamp(data.getTime());
	}

	public static void copiaStream(InputStream in, OutputStream out, boolean blnFecharIn, boolean blnFecharOut) throws IOException {
		synchronized (in) {
			synchronized (out) {
				byte[] buffer = new byte[256];
				while (true) {
					int bytesRead = in.read(buffer);
					if (bytesRead == -1)
						break;
					out.write(buffer, 0, bytesRead);
				}
			}
		}
		if (blnFecharIn) {
			in.close();
		}
		if (blnFecharOut) {
			out.close();
		}
	}

	public static void copiaStream(InputStream in, OutputStream out) throws IOException {
		copiaStream(in, out, false, false);
	}

	public static int retornaIdinsertChaveSecundaria(String tabela, String nomechaveprimaria, String valchaveprimaria, String coluna, Connection conn) throws Exception {
		String varname1 = "";
		// so funciona para pk single

		varname1 += " SELECT z.expected AS missing  ";
		varname1 += " FROM   ( ";
		varname1 += " SELECT   @rownum:=@rownum+1                         AS expected,IF(@rownum=" + coluna + ", 0, @rownum:=" + coluna + ") as got";
		varname1 += " FROM     ( ";
		varname1 += " SELECT @rownum:=0) AS a ";
		varname1 += " JOIN     " + tabela + " ";
		varname1 += " where " + nomechaveprimaria + " = " + valchaveprimaria + " ";
		varname1 += " ORDER BY " + coluna + " ) AS z ";
		varname1 += " WHERE  z.got!=0 ";
		varname1 += " UNION ";
		varname1 += " SELECT COALESCE(max(" + coluna + "+1),1) AS missing ";
		varname1 += " FROM   " + tabela + " where " + nomechaveprimaria + " = " + valchaveprimaria + " limit 1 ";

		PreparedStatement st = conn.prepareStatement(varname1);
		int id = 1;
		ResultSet rs2 = st.executeQuery();
		if (rs2.next()) {
			id = rs2.getInt("missing");
		}

		return id;
	}

	private static final int maxsize = 1000;

	public static void sizeimage(String cod) {
		try {
			// mudei direitorio para o m16_/***/produtos
			BufferedImage originalImage = ImageIO.read(new File("D:\\phonegap_projects\\tragoaqui_contextos\\m_16\\src\\main\\webapp\\images\\produtos\\" + cod + "_1.jpg"));

			int type = originalImage.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : originalImage.getType();
			Double IMG_WIDTH = new Double(maxsize);
			Double IMG_HEIGHT = new Double(maxsize);

			BufferedImage resizedImage = ImageIO.read(new File("D:\\phonegap_projects\\tragoaqui_contextos\\m_16\\src\\main\\webapp\\images\\produtos\\" + cod + "_1.jpg"));
			int width = resizedImage.getWidth();
			int height = resizedImage.getHeight();

			if (width > maxsize || height > maxsize) {
				if (height > width) {

					double perc = (width * 100) / height;
					IMG_WIDTH = (maxsize * perc) / 100;

				} else if (height < width) {

					double perc = (height * 100) / width;
					IMG_HEIGHT = (maxsize * perc) / 100;

				}
				resizedImage = new BufferedImage(IMG_WIDTH.intValue(), IMG_HEIGHT.intValue(), type);

				Graphics2D g = resizedImage.createGraphics();
				g.drawImage(originalImage, 0, 0, IMG_WIDTH.intValue(), IMG_HEIGHT.intValue(), null);
				g.dispose();

				// ImageIO.write(resizedImage, "jpg", new File("D:\\Program Files\\Mydocs\\Visual Studio 2015\\Projects\\chamaTrago\\chamaTrago\\www\\img\\prodsmin\\" + cod + "_min.jpg"));
				ImageIO.write(resizedImage, "jpg", new File("D:\\phonegap_projects\\tragoaqui_contextos\\m_16\\src\\main\\webapp\\images\\prodsmin\\" + cod + "_min.jpg"));

			}

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

	}

	public static void sizeimage2(String cod) {
		try {
			// mudei direitorio para o m16_/***/produtos
			BufferedImage originalImage = ImageIO.read(new File("D:\\phonegap_projects\\tragoaqui_contextos\\m_16\\src\\main\\webapp\\images\\produtos\\" + cod + "_1.jpg"));

			int type = originalImage.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : originalImage.getType();
			Double IMG_WIDTH = new Double(maxsize);
			Double IMG_HEIGHT = new Double(maxsize);

			BufferedImage resizedImage = ImageIO.read(new File("D:\\phonegap_projects\\tragoaqui_contextos\\m_16\\src\\main\\webapp\\images\\produtos\\" + cod + "_1.jpg"));
			int width = resizedImage.getWidth();
			int height = resizedImage.getHeight();

			if (width > maxsize || height > maxsize) {
				if (height > width) {

					double perc = (width * 100) / height;
					IMG_WIDTH = (maxsize * perc) / 100;

				} else if (height < width) {

					double perc = (height * 100) / width;
					IMG_HEIGHT = (maxsize * perc) / 100;

				}
				resizedImage = new BufferedImage(IMG_WIDTH.intValue(), IMG_HEIGHT.intValue(), type);

				Graphics2D g = resizedImage.createGraphics();
				g.drawImage(originalImage, 0, 0, IMG_WIDTH.intValue(), IMG_HEIGHT.intValue(), null);
				g.dispose();

				// ImageIO.write(resizedImage, "jpg", new File("D:\\Program Files\\Mydocs\\Visual Studio 2015\\Projects\\chamaTrago\\chamaTrago\\www\\img\\prodsmin\\" + cod + "_min.jpg"));
				ImageIO.write(resizedImage, "jpg", new File("D:\\phonegap_projects\\tragoaqui_contextos\\m_16\\src\\main\\webapp\\images\\produtos\\" + cod + "_1.jpg"));

			}

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

	}

	public static void resizeAllimage() throws Exception {
		Connection conn = null;
		try {
			conn = Conexao.getConexao();
			String varname1 = "";

			varname1 = " select * from produtos ";

			PreparedStatement st = conn.prepareStatement(varname1);
			ResultSet rs2 = st.executeQuery();
			while (rs2.next()) {
				try {
					System.out.println(rs2.getInt("ID_PROD"));
					sizeimage(rs2.getInt("ID_PROD") + "");
				} catch (Exception e) {
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		try {
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}


	public static DecimalFormatSymbols dfs = new DecimalFormatSymbols(new Locale("pt", "BR"));
	public static NumberFormat df = new DecimalFormat("###,###.#", dfs);
	public static NumberFormat df2 = new DecimalFormat("#,###,##0.00", dfs);
	public static NumberFormat df3 = new DecimalFormat("#,###,##0.0", dfs);

	public static void renamefiles() throws IOException {

		for (int i = 0; i < 150; i++) {

			File file = new File("C:/Users/gkothe/Desktop/img_fit/img_fit" + i + "_1.jpg");

			// File (or directory) with new name
			File file2 = new File("D:/phonegap_projects/TragoAqui_Fit/www/img/prodsmin/" + i + "_min.jpg");

			if (file2.exists())
				throw new java.io.IOException("file exists");

			// Rename file (or directory)
			boolean success = file.renameTo(file2);

			if (!success) {
				// File was not successfully renamed
			}

		}

		// File (or directory) with old name

	}

	public static void renamefiles3() throws IOException {

		File dir = new File("C:/Users/gkothe/Desktop/img_fit/img_fit");

		if (dir.isDirectory()) { // make sure it's a directory
			for (final File f : dir.listFiles()) {
				try {
					File newfile = new File("C:/Users/gkothe/Desktop/img_fit/img_fit/" + f.getName().toLowerCase());

					if (f.renameTo(newfile)) {
						System.out.println("Rename succesful");
					} else {
						System.out.println("Rename failed");
					}
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}
	}

	// File (or directory) with old name

	public static void renamefilesSys() throws IOException {

		for (int i = 0; i < 150; i++) {

			File file = new File("D:/phonegap_projects/m_16/m_16/src/main/webapp/images/produtos/" + i + ".jpg");

			// File (or directory) with new name
			File file2 = new File("D:/phonegap_projects/m_16/m_16/src/main/webapp/images/produtos/" + i + "_1.jpg");

			if (file2.exists())
				throw new java.io.IOException("file exists");

			// Rename file (or directory)
			boolean success = file.renameTo(file2);

			if (!success) {
				// File was not successfully renamed
			}

		}

		// File (or directory) with old name

	}






	public static void main(String[] args) {
		// Connection conn = null;

		try {
			// conn = Conexao.getConexao();
			// Sys_parametros sys = new Sys_parametros(conn);

			// getCidadeBairroGps("-29.69579482872522", "-52.44530843952397", conn, 0, sys);

			// readTableprods("D:/phonegap_projects/prods_listas/lista_uplen.xlt",6);

			resizeAllimage();

			// oneSginal(sys, "g.kothe@hotmail.com", "aaaa", new JSONObject());
			// oneSginal(sys, "morratu@hotmail.com", "aaaa", new JSONObject());
		} catch (Exception e) {
			System.out.println(e);
			try {
				// conn.close();
			} catch (Exception es) { // TODO: handle exception } }
			}

		}
	}

	/*
	 * public static void main(String[] args) {
	 * 
	 * Connection conn =null; try { // sendEmail("g.kothe@hotmail.com", "aaaa", "Recuperação de senha"); conn = Conexao.getConexao(); // String validacao = Utilitario.StringGen(1000, 32).substring(0, 99); // Sys_parametros sys = new Sys_parametros(Conexao.getConexao()); // String texto = " Bem vindo ao TragoAqui, para validar seu e-mail clique no link abaixo: <br> " + sys.getUrl_system() + "mobile/ac=validar&token=" + validacao; // Utilitario.sendEmail("g.kothe@hotmail.com", texto, "Ativação da sua conta no TragoAqui!");
	 * 
	 * // System.out.println("Horario_1".toString().substring("Horario_1".toString().length() - 1, "Horario_1".toString().length())); // String hora = "1234";
	 * 
	 * // System.out.println(hora.substring(0, 2)); // System.out.println(hora.substring(2, 4));
	 * 
	 * String sql = " 	select * from pedido  where id_pedido = 1   ";
	 * 
	 * PreparedStatement st = conn.prepareStatement(sql);
	 * 
	 * ResultSet rs = st.executeQuery();
	 * 
	 * if (rs.next()) {
	 * 
	 * Date datatempoentregateste; Date datatempoentregateste2; try { datatempoentregateste = new SimpleDateFormat("HH:mm").parse("01:00"); datatempoentregateste2 = new SimpleDateFormat("HH:mm").parse(rs.getString("TEMPO_ESTIMADO_DESEJADO")); System.out.println(datatempoentregateste); System.out.println(datatempoentregateste2);
	 * 
	 * 
	 * } catch (Exception e) { throw new Exception("Tempo de entrega inválidos!"); }
	 * 
	 * if(datatempoentregateste.after(datatempoentregateste2)){ throw new Exception("Tempo de entrega é acima do desejado!"); }
	 * 
	 * } } catch (Exception e) { // TODO: handle exception e.printStackTrace(); }
	 * 
	 * try { conn.close(); } catch (Exception e) { // TODO: handle exception } }
	 */

}
