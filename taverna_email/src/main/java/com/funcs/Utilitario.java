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

	public static JSONArray payments_ids() {
		JSONArray payids = new JSONArray();
		JSONObject obj = new JSONObject();

		obj = new JSONObject();
		obj.put("payid", "");
		obj.put("desc", "Escolha um tipo de cartão de crédito");
		payids.add(obj);

		obj = new JSONObject();
		obj.put("payid", "master");
		obj.put("desc", "Mastercard");
		payids.add(obj);

		obj = new JSONObject();
		obj.put("payid", "visa");
		obj.put("desc", "Visa");
		payids.add(obj);

		return payids;

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
		String rodape = "<br><br> Equipe " + sys.getSys_fromdesc() + " <br>";
		rodape = rodape + " " + sys.getTragoaqui_num_telefone() + " <br>";
		rodape = rodape + " " + sys.getSys_fromemail() + " <br>";
		rodape = rodape + " " + sys.getTragoaqui_pag_facebook() + " <br>";
		rodape = rodape + " www.tragoaqui.com.br <br>";

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

	public static String returnStatusPedidoFlag(String flag, String serv) {

		if (flag.equalsIgnoreCase("E") && serv.equalsIgnoreCase("T")) {
			return "Aceito";
			// return "Em envio";
		} else if (flag.equalsIgnoreCase("R")) {
			return "Recusado";
		} else if (flag.equalsIgnoreCase("O")) {
			return "Finalizado";
		} else if (flag.equalsIgnoreCase("A")) {
			return "Aberto";
		} else if (flag.equalsIgnoreCase("E") && serv.equalsIgnoreCase("L")) {

			return "Aceito";
			// return "Em espera";
		} else if (flag.equalsIgnoreCase("C")) {
			return "Cancelado";
		} else if (flag.equalsIgnoreCase("")) {
			return "Todas";
		}

		return "";
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

	public static String returnDistrTiposPedido(String flag_pedido_ret_entre, String flag_modoentrega) { // , flag_entre_ret

		if (flag_pedido_ret_entre.equalsIgnoreCase("L")) {
			return "Retirada no local";
		} else if (flag_pedido_ret_entre.equalsIgnoreCase("T") && flag_modoentrega.equalsIgnoreCase("T")) {
			return "Tele-Entrega";
		} else if (flag_pedido_ret_entre.equalsIgnoreCase("T") && flag_modoentrega.equalsIgnoreCase("A")) {
			return "Agendamento";
		}

		return "";
	}

	public static String returnDistrTiposServicoMob(String flag) { // , flag_entre_ret

		if (flag.equalsIgnoreCase("L")) {
			return "Retirada no local";
		} else if (flag.equalsIgnoreCase("T")) {
			return "Tele-Entrega";
		} else if (flag.equalsIgnoreCase("A")) {
			return "Agendamento";
		}

		return "";
	}

	public static String returntipoPedido(String flag) { // , FLAG_PEDIDO_RET_ENTRE

		if (flag.equalsIgnoreCase("L")) {
			// return "Somente retirada no local";
			return "Retirada no local";
		} else if (flag.equalsIgnoreCase("T")) {
			// return "Somente tele-entrega";
			return "Tele-entrega";
		} else if (flag.equalsIgnoreCase("A")) {
			return "Agendamento";
		} else if (flag.equalsIgnoreCase("")) {
			return "Todos";
		}

		return "";
	}

	//

	public static JSONArray returnJsonStatusPedidoFlag() {

		JSONArray retornoarray = new JSONArray();

		JSONObject obj = new JSONObject();

		obj = new JSONObject();
		obj.put("id", "");
		obj.put("desc", "Escolha uma situação");
		retornoarray.add(obj);

		obj = new JSONObject();
		obj.put("id", "A");
		obj.put("desc", "Aberto");
		retornoarray.add(obj);

		obj = new JSONObject();
		obj.put("id", "E");
		obj.put("desc", "Aceito");
		retornoarray.add(obj);

		obj = new JSONObject();
		obj.put("id", "F");
		obj.put("desc", "Finalizado");
		retornoarray.add(obj);

		obj = new JSONObject();
		obj.put("id", "R");
		obj.put("desc", "Recusado");
		retornoarray.add(obj);

		return retornoarray;
	}

	@Deprecated
	public static String returnModoPagamento(String flag) {

		if (flag.equalsIgnoreCase("D")) {
			return "Dinheiro";
		} else if (flag.equalsIgnoreCase("C")) {
			return "Cartão Créd.";
		} else if (flag.equalsIgnoreCase("A")) {
			return "Ambos";
		} else if (flag.equalsIgnoreCase("")) {
			return "Todos";
		} else if (flag.equalsIgnoreCase("DC")) { // esse valor é pra display soh no mobile, nao existe de fato no sistema
			return "Dinheiro e Cartão Cred.";

		}

		return "";

	}

	public static String returnTipoPagamentoFlag(String flag) {

		if (flag.equalsIgnoreCase("D")) {
			return "Dinheiro";
		} else if (flag.equalsIgnoreCase("CC")) {
			return "Cartão Créd.";
		} else if (flag.equalsIgnoreCase("CD")) {
			return "Cartão Débito";
		} else if (flag.equalsIgnoreCase("V")) {
			return "Vale alimentação";
		} else if (flag.equalsIgnoreCase("C")) { // esse valor é pra display soh no mobile, nao existe de fato no sistema
			return "Cheque";

		}

		return "";

	}

	public static String returnDescPagamento(Connection conn, int id_modopagamento) throws Exception {

		StringBuffer sql2 = new StringBuffer();
		sql2.append(" select * from modo_pagamento   ");
		sql2.append(" where modo_pagamento.id_modo_pagamento = ? ");

		PreparedStatement st2 = conn.prepareStatement(sql2.toString());
		st2.setInt(1, id_modopagamento);

		ResultSet rs2 = st2.executeQuery();
		String desc = "";
		if (rs2.next()) {
			return rs2.getString("desc_modo");
		} else
			return desc;
	}

	public static String returnModoPagamentoDisponiveis(int loja, Connection conn, int id_modopagamento) throws Exception {

		StringBuffer sql2 = new StringBuffer();
		sql2.append(" select * from distribuidora_pagamento   ");
		sql2.append(" inner join modo_pagamento  ");
		sql2.append(" on distribuidora_pagamento.ID_MODO_PAGAMENTO  =   modo_pagamento.ID_MODO_PAGAMENTO ");
		sql2.append(" where distribuidora_pagamento. id_distribuidora = ?");

		if (id_modopagamento != 0) {
			sql2.append(" and modo_pagamento.id_modo_pagamento = ? ");
		}

		PreparedStatement st2 = conn.prepareStatement(sql2.toString());
		st2.setInt(1, loja);
		if (id_modopagamento != 0) {
			st2.setInt(2, id_modopagamento);
		}

		ResultSet rs2 = st2.executeQuery();
		String desc = "";
		while (rs2.next()) {
			desc = desc + ", " + rs2.getString("desc_modo") + " -> ";
			boolean tem = false;
			if (rs2.getString("flag_entrega").equalsIgnoreCase("S")) {
				tem = true;
				desc = desc + "Entrega";
			}

			if (rs2.getString("flag_retiradalocal").equalsIgnoreCase("S")) {
				if (tem)
					desc = desc + " e ";

				desc = desc + "Retirada";

			}

			desc = desc + " \n ";

		}

		desc = desc.replaceAll(",", "");

		return desc;
	}

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

	public static Integer diaSemana(Connection conn, int distribuidora) throws Exception {

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

		String varname1 = " select flag_custom from distribuidora where id_distribuidora = ? ";
		int dia = 0;
		PreparedStatement st = conn.prepareStatement(varname1);
		st.setInt(1, distribuidora);
		ResultSet rs2 = st.executeQuery();
		if (rs2.next()) {
			if (rs2.getString("FLAG_CUSTOM").equalsIgnoreCase("S")) {
				dia = 8;// se o flag custom ta ativo, retorna dia feriado/custom.

			} else {
				// ex: se day of week é 4, WEDNESDAY , o retorno vai ser day of week - 1 =3 Qarta feira.
				dia = new GregorianCalendar().get(Calendar.DAY_OF_WEEK) == 1 ? 7 : new GregorianCalendar().get(Calendar.DAY_OF_WEEK) - 1;
			}
		} else {
			throw new Exception("Distribuidora não existe.");
		}
		return dia;
	}

	public static int getNextNumpad(Connection conn, int distribuidora) throws Exception {

		String varname1 = " select coalesce(max(num_ped),0)+1 as num_ped from  pedido where id_distribuidora = ?  ";
		PreparedStatement st = conn.prepareStatement(varname1);
		st.setInt(1, distribuidora);
		ResultSet rs2 = st.executeQuery();
		if (rs2.next()) {
			return rs2.getInt("NUM_PED");
		}

		return 0;
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

	public static String getDescDiaSemana(Connection conn, int cod_dia, boolean tratadia) throws Exception {
		if (tratadia) {
			if (cod_dia == 1) {
				cod_dia = 7;
			} else {
				cod_dia = cod_dia - 1;
			}
		}

		String varname1 = " select * from  dias_semana where cod_dia = ? ";
		PreparedStatement st = conn.prepareStatement(varname1);
		st.setInt(1, cod_dia);
		ResultSet rs2 = st.executeQuery();
		if (rs2.next()) {
			return rs2.getString("DESC_DIA");
		} else {
			throw new Exception("Dia não existe.");
		}

	}

	public static String getNomeBairro(Connection conn, int cod_bairro, int ID_DISTR_BAIRRO) throws Exception {

		String desc_bairro = "";

		if (cod_bairro != 0) {

			String varname1 = " select * from bairros where cod_bairro =  " + cod_bairro;
			PreparedStatement st = conn.prepareStatement(varname1);
			ResultSet rs2 = st.executeQuery();
			if (rs2.next()) {
				desc_bairro = rs2.getString("DESC_BAIRRO");
			} else {
				throw new Exception("Bairro não existe.");
			}

		} else if (ID_DISTR_BAIRRO != 0) {

			String varname1 = " select * from bairros inner join distribuidora_bairro_entrega where ID_DISTR_BAIRRO = " + ID_DISTR_BAIRRO + " limit 1";
			PreparedStatement st = conn.prepareStatement(varname1);
			ResultSet rs2 = st.executeQuery();
			if (rs2.next()) {
				desc_bairro = rs2.getString("DESC_BAIRRO");
			} else {
				throw new Exception("Bairro não existe.");
			}

		}

		return desc_bairro;
	}

	public static String getNomeProd(Connection conn, long id_prod, boolean abreviado) throws Exception {

		String desc_produto = "";
		String varname1 = " select * from produtos where id_prod = ?";

		PreparedStatement st = conn.prepareStatement(varname1);
		st.setLong(1, id_prod);
		ResultSet rs2 = st.executeQuery();
		if (rs2.next()) {

			if (!abreviado) {
				desc_produto = rs2.getString("DESC_PROD");
			} else {
				desc_produto = rs2.getString("DESC_ABREVIADO");
			}
		} else {
			throw new Exception("Produto não existe.");
		}

		return desc_produto;
	}

	public static void getFullProdname(HttpServletRequest request, HttpServletResponse response, Connection conn) throws Exception {
		JSONObject retorno = new JSONObject();
		PrintWriter out = response.getWriter();

		String desc_produto = request.getParameter("param") == null ? "" : request.getParameter("param");
		String varname1 = " select * from produtos where desc_abreviado = ? ";
		PreparedStatement st = conn.prepareStatement(varname1);
		st.setString(1, desc_produto);
		ResultSet rs2 = st.executeQuery();
		if (rs2.next()) {
			retorno.put("name", rs2.getString("desc_prod"));
			retorno.put("nameabrev", rs2.getString("desc_abreviado"));
		}

		out.print(retorno.toJSONString());
	}

	public static String getNomeProdIdProdDistr(Connection conn, long ID_PROD_DIST, boolean abreviado) throws Exception {

		String desc_produto = "";
		String varname1 = " select desc_abreviado,desc_prod from produtos inner join produtos_distribuidora on produtos_distribuidora.id_prod = produtos.id_prod where id_prod_dist =  ? ";
		PreparedStatement st = conn.prepareStatement(varname1);
		st.setLong(1, ID_PROD_DIST);
		ResultSet rs2 = st.executeQuery();
		if (rs2.next()) {

			if (!abreviado) {
				desc_produto = rs2.getString("DESC_PROD");
			} else {
				desc_produto = rs2.getString("DESC_ABREVIADO");
			}
		} else {
			throw new Exception("Produto não existe.");
		}

		return desc_produto;
	}

	public static String getNomeDistr(Connection conn, long id_distribuidora, boolean abreviado) throws Exception {

		String desc_nome = "";
		String varname1 = " select * from distribuidora where id_distribuidora = ? ";
		PreparedStatement st = conn.prepareStatement(varname1);
		st.setLong(1, id_distribuidora);
		ResultSet rs2 = st.executeQuery();
		if (rs2.next()) {

			if (!abreviado) {
				desc_nome = rs2.getString("DESC_RAZAO_SOCIAL");
			} else {
				desc_nome = rs2.getString("DESC_NOME_ABREV");
			}
		} else {
			throw new Exception("Distribuidora não existe.");
		}

		return desc_nome;
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

	public static void oneSginal(Sys_parametros sys, String email, String msg, JSONObject data) throws Exception {

		String jsonResponse;

		URL url = new URL(sys.getOnesignal_url());
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setUseCaches(false);
		con.setDoOutput(true);
		con.setDoInput(true);

		con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
		con.setRequestProperty("Authorization", "Basic " + sys.getOnesignal_key());
		con.setRequestMethod("POST");

		JSONObject body = new JSONObject();
		JSONObject contents = new JSONObject();
		contents.put("en", msg);
		JSONArray filters = new JSONArray();
		JSONObject filterchild = new JSONObject();

		filterchild.put("field", "tag");
		filterchild.put("key", "email");
		filterchild.put("relation", "=");
		filterchild.put("value", email);
		filters.add(filterchild);

		body.put("app_id", sys.getOnesignal_appid());
		body.put("included_segments", "All");
		body.put("data", data);
		body.put("contents", contents);
		body.put("filters", filters);

		byte[] sendBytes = body.toJSONString().getBytes("UTF-8");
		con.setFixedLengthStreamingMode(sendBytes.length);

		OutputStream outputStream = con.getOutputStream();
		outputStream.write(sendBytes);

		int httpResponse = con.getResponseCode();
		// System.out.println("httpResponse: " + httpResponse);

		if (httpResponse >= HttpURLConnection.HTTP_OK && httpResponse < HttpURLConnection.HTTP_BAD_REQUEST) {
			Scanner scanner = new Scanner(con.getInputStream(), "UTF-8");
			jsonResponse = scanner.useDelimiter("\\A").hasNext() ? scanner.next() : "";
			scanner.close();
		} else {
			Scanner scanner = new Scanner(con.getErrorStream(), "UTF-8");
			jsonResponse = scanner.useDelimiter("\\A").hasNext() ? scanner.next() : "";
			scanner.close();
		}
		// System.out.println("jsonResponse:\n" + jsonResponse);

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

	private static void third() {

		// System.err.println("Stack trace of current thread using dumpStack() method");
		Thread.currentThread().dumpStack();

		// System.err.println("Printing stack trace using printStackTrace() method of Throwable ");
		new Throwable().printStackTrace();

		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace(); // Once you get StackTraceElement you can also print it to console System.err.println("displaying Stack trace from StackTraceElement in Java"); for(StackTraceElement st : stackTrace){ // System.err.println(st); }

		// System.err.println("displaying Stack trace from StackTraceElement in Java");
		for (StackTraceElement st : stackTrace) {
			System.err.println(st);
		}
	}

	private static String addCellXLS(Row row, int idx) throws Exception {
		String valor = "";
		try {
			int tipoCelula = row.getCell(idx).getCellType();
			switch (tipoCelula) {
			case Cell.CELL_TYPE_NUMERIC:
				DataFormatter formatter = new DataFormatter();
				valor = formatter.formatCellValue(row.getCell(idx));
				break;
			case Cell.CELL_TYPE_STRING:
				valor = row.getCell(idx).getStringCellValue();
				break;
			case Cell.CELL_TYPE_BOOLEAN:
				valor = row.getCell(idx).getBooleanCellValue() + "";
				break;
			case Cell.CELL_TYPE_BLANK:
				valor = "";
				break;

			default:
				break;
			}

		} catch (Exception ex) {
		}
		return valor;
	}

	public static void readTableprods(String file, int coddistr) {
		Connection conn = null;
		try {
			conn = Conexao.getConexao();
			conn.setAutoCommit(false);

			String sql = "";
			PreparedStatement st;

			FileInputStream fis = new FileInputStream(file);
			HSSFWorkbook myWorkBook = new HSSFWorkbook(fis);
			HSSFSheet sheet = myWorkBook.getSheetAt(0);

			Iterator<Row> rowIterator = sheet.iterator();
			PreparedStatement st3;
			while (rowIterator.hasNext()) {

				Row row = rowIterator.next();
				int nRowIndex = row.getRowNum();

				if (nRowIndex > 0) {
					String id_produto = addCellXLS(row, 0);

					if (id_produto.equalsIgnoreCase("gggg")) {
						break;
					}

					double val = Double.parseDouble(addCellXLS(row, 2));

					sql = "select * from produtos  left join produtos_distribuidora on produtos.id_prod = produtos_distribuidora.id_prod	 and id_distribuidora = ? where (produtos.flag_ativo = 's') and produtos.id_prod = ? ";

					st = conn.prepareStatement(sql);
					st.setInt(1, coddistr);
					st.setInt(2, Integer.parseInt(id_produto));
					ResultSet rs = st.executeQuery();
					if (rs.next()) {
						sql = "select * from produtos_distribuidora where id_distribuidora = ?  and id_prod = ?  ";

						PreparedStatement st2 = conn.prepareStatement(sql);
						st2.setInt(1, coddistr);
						st2.setInt(2, Integer.parseInt(id_produto));
						ResultSet rs2 = st2.executeQuery();
						if (!rs2.next()) {

							sql = "insert into produtos_distribuidora  (`ID_PROD`, `ID_DISTRIBUIDORA`, `VAL_PROD`, `FLAG_ATIVO`, data_modificacao) VALUES   (?, ?, ?, ?, now());   ";
							st3 = conn.prepareStatement(sql);
							st3.setInt(1, Integer.parseInt(id_produto));
							st3.setInt(2, coddistr);
							st3.setDouble(3, val);
							st3.setString(4, "S");
							st3.executeUpdate();
						} else {

							sql = "update  produtos_distribuidora set  VAL_PROD = ? , FLAG_ATIVO = ?, data_modificacao = now() where ID_DISTRIBUIDORA = ? and id_prod = ?";
							st3 = conn.prepareStatement(sql);
							st3.setInt(4, Integer.parseInt(id_produto));
							st3.setInt(3, coddistr);
							st3.setDouble(1, val);
							st3.setString(2, "S");
							st3.executeUpdate();

						}

					}

					System.out.println(id_produto);
				}
			}
			conn.commit();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			;
			try {
				conn.close();
			} catch (Exception e2) {
			}
		}

	}

	public static JSONObject getCidadeBairroGps(String latitude, String longitude, Connection conn, long id_usuario, Sys_parametros sys) throws Exception {
		return getCidadeBairroGps(latitude, longitude, conn, id_usuario, sys, false);
	}

	public static JSONObject getCidadeBairroGps(String latitude, String longitude, Connection conn, long id_usuario, Sys_parametros sys, boolean etapa1visitante) throws Exception {

		try {
			//
			// third();

			URL obj;
			String url = "";
			HttpURLConnection con;

			int responseCode;
			BufferedReader in;
			StringBuilder responsestr;
			String inputLine;
			JSONObject json = new JSONObject();
			JSONObject retorno = new JSONObject();

			if (sys.getSys_id_visistante() == id_usuario && etapa1visitante == false) {
				return null;
			}

			if (id_usuario != 0) {// se tem algo no carrinho, nao tem que sugerir porra nenhuma.
				StringBuffer sql = new StringBuffer();
				sql.append(" select 1 from carrinho where id_usuario = " + id_usuario);
				PreparedStatement st = conn.prepareStatement(sql.toString());
				ResultSet rs = st.executeQuery();
				if (rs.next()) {
					return null;
				}
			}

			if (latitude.equalsIgnoreCase("")) {

				return null;
			} else {
				url = "http://maps.googleapis.com/maps/api/geocode/json?latlng=" + latitude + "," + longitude + "&sensor=false";
				obj = new URL(url);
				con = (HttpURLConnection) obj.openConnection();
				con.setRequestProperty("Content-Type", "text/plain; charset=utf-8");
				con.setRequestProperty("Accept-Charset", "utf-8");

				con.setRequestMethod("GET");
				responseCode = con.getResponseCode();

				if (responseCode == 400) {
					throw new Exception("Erro 400 .");
				}

				in = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));

				responsestr = new StringBuilder();

				while ((inputLine = in.readLine()) != null) {
					responsestr.append(inputLine);
				}
				in.close();

				json = (JSONObject) new JSONParser().parse(responsestr.toString());

				JSONArray array = (JSONArray) json.get("results");
				json = (JSONObject) array.get(0);
				array = (JSONArray) json.get("address_components");
				JSONArray types;

				for (int i = 0; i < array.size(); i++) {
					json = (JSONObject) array.get(i);
					types = (JSONArray) json.get("types");
					for (int t = 0; t < types.size(); t++) {
						if (types.get(t).toString().equalsIgnoreCase("sublocality")) {
							retorno.put("bairro_short", json.get("short_name"));
							retorno.put("bairro_long", json.get("long_name"));
						}

						if (types.get(t).toString().equalsIgnoreCase("locality")) {
							retorno.put("cidade_short", json.get("short_name"));
							retorno.put("cidade_long", json.get("long_name"));
						}
					}

				}

				String sql = "select  * from cidade where desc_cidade like ? or desc_cidade like ?  ";

				PreparedStatement st = conn.prepareStatement(sql);
				st.setString(1, retorno.get("cidade_long").toString());
				st.setString(2, retorno.get("cidade_short").toString());
				ResultSet rs = st.executeQuery();
				int cidade = 0;
				if (rs.next()) {
					cidade = rs.getInt("cod_cidade");

				} else {
					return null;
				}

				sql = "select  * from  bairros where (desc_bairro like ? or desc_bairro like ? or desc_googlemaps = ? or desc_googlemaps = ? ) and cod_cidade =  " + cidade;

				st = conn.prepareStatement(sql);
				st.setString(1, retorno.get("bairro_short").toString());
				st.setString(2, retorno.get("bairro_long").toString());
				st.setString(3, retorno.get("bairro_short").toString());
				st.setString(4, retorno.get("bairro_long").toString());
				rs = st.executeQuery();
				long cod_bairro = 0;
				if (rs.next()) {
					cod_bairro = rs.getInt("cod_bairro");
					retorno.put("cod_bairro", cod_bairro);
				}

				retorno.put("cod_cidade", cidade);

				if (id_usuario != 0 && sys.getSys_id_visistante() != id_usuario) {

					sql = "update usuario set id_cidade_atual = ? where  id_usuario = ?  ";
					st = conn.prepareStatement(sql.toString());
					st.setInt(1, cidade);
					st.setLong(2, id_usuario);
					st.executeUpdate();

				}

				return retorno;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void main(String[] args) {
		// Connection conn = null;

		try {
			// conn = Conexao.getConexao();
			// Sys_parametros sys = new Sys_parametros(conn);

			// getCidadeBairroGps("-29.69579482872522", "-52.44530843952397", conn, 0, sys);

//			 readTableprods("D:/phonegap_projects/prods_listas/lista_uplen.xlt",6);

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
