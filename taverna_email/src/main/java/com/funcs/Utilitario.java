package com.funcs;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.HtmlEmail;
import org.json.simple.JSONObject;

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

	public static int retornaIdinsertChaveSecundariaInt(String tabela, String nomechaveprimaria, String valchaveprimaria, String coluna, Connection conn) throws Exception {
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

	public static Long retornaIdinsertChaveSecundariaLong(String tabela, String nomechaveprimaria, String valchaveprimaria, String coluna, Connection conn) throws Exception {
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
		long id = 1;
		ResultSet rs2 = st.executeQuery();
		if (rs2.next()) {
			id = rs2.getInt("missing");
		}

		return id;
	}

	
	private static final int maxsize = 1000;

	public static DecimalFormatSymbols dfs = new DecimalFormatSymbols(new Locale("pt", "BR"));
	public static NumberFormat df = new DecimalFormat("###,###.#", dfs);
	public static NumberFormat df2 = new DecimalFormat("#,###,##0.00", dfs);
	public static NumberFormat df3 = new DecimalFormat("#,###,##0.0", dfs);

	public static void main(String[] args) {
		// Connection conn = null;

		try {
		} catch (Exception e) {
			System.out.println(e);
			try {
				// conn.close();
			} catch (Exception es) { // TODO: handle exception } }
			}

		}
	}

}