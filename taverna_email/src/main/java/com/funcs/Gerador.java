package com.funcs;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.DatabaseMetaData;

import com.configs.Conexao;

public class Gerador {

	// private static Logger log = LoggerFactory.getLogger(Gerador.class);

	public static void htmlFields(Connection conn, String databaseName, String path) throws Exception {

		ResultSet resultSet = conn.getMetaData().getCatalogs();
		ResultSet resultSet2;
		ResultSet resultSet3;
		BufferedWriter bw = null;
		FileWriter fw = null;
		Statement statement;
		ResultSetMetaData rsmd;
		int numOfCols = 0;
		String table_nameformated = "";
		DatabaseMetaData dm;
		while (resultSet.next()) {
			System.out.println("Schema Name = " + resultSet.getString("TABLE_CAT"));
		}
		resultSet.close();
		// --- LISTING DATABASE TABLE NAMES ---
		String[] types = { "TABLE" };
		resultSet = conn.getMetaData().getTables(databaseName, null, "%", types);
		String tableName = "";

		String column;
		String type;
		String namepk1 = "";
		String namepk2 = "";
		String pktype = "";
		boolean aux = true;
		boolean pk2 = true;
		while (resultSet.next()) {

			pk2 = false;
			aux = true;
			namepk1 = "";
			namepk2 = "";
			pktype = "";
			tableName = resultSet.getString(3).toLowerCase();
			table_nameformated = FCol(tableName);
			System.out.println("Table Name = " + tableName);

			dm = conn.getMetaData();
			resultSet2 = dm.getColumns(null, null, tableName, null);
			while (resultSet2.next()) {
				String columnName = resultSet2.getString("COLUMN_NAME");
				int nullable = resultSet2.getInt("NULLABLE");
				if (nullable == DatabaseMetaData.columnNullable) {
				} else {
					System.out.println(columnName + ": nullable false");
				}
			}

			dm = conn.getMetaData();
			resultSet2 = dm.getPrimaryKeys("", "", tableName);

			while (resultSet2.next()) {
				if (aux)
					namepk1 = resultSet2.getString("COLUMN_NAME").toLowerCase();
				else
					namepk2 = resultSet2.getString("COLUMN_NAME").toLowerCase();
				aux = false;
			}

			if (!namepk2.equalsIgnoreCase("")) {
				pk2 = true;
			}

			System.out.println("pk1: " + namepk1 + " pk2: " + namepk2);

			statement = conn.createStatement();
			resultSet3 = statement.executeQuery(" select * FROM " + tableName);
			rsmd = resultSet3.getMetaData();
			// Get number of columns returned
			numOfCols = rsmd.getColumnCount();

			fw = new FileWriter(path + "\\html_" + table_nameformated + ".html");
			bw = new BufferedWriter(fw);

			for (int i = 1; i <= numOfCols; ++i) {
				column = rsmd.getColumnName(i);
				type = rsmd.getColumnTypeName(i);

				bw.write("<div class=\"row\">");
				bw.write("<div class=\" col-xs-6 col-md-6 col-lg-6\">");
				bw.write("<div class=\"form-group\">");
				bw.write("<label>" + FLow(column) + "</label> <input type=\"text\" class=\"form-control \" id=\"" + FLow(column) + "\" />");
				bw.write("</div>");
				bw.write("</div>");
				bw.write("</div>");

			}

			resultSet3.close();

			if (bw != null)
				bw.close();

			if (fw != null)
				fw.close();

		}

	}

	public static void javaAjax(Connection conn, String databaseName, String path) throws Exception {

		// --- LISTING DATABASE SCHEMA NAMES ---
		ResultSet resultSet = conn.getMetaData().getCatalogs();
		ResultSet resultSet2;
		ResultSet resultSet3;
		BufferedWriter bw = null;
		FileWriter fw = null;
		Statement statement;
		ResultSetMetaData rsmd;
		int numOfCols = 0;
		String table_nameformated = "";
		DatabaseMetaData dm;
		while (resultSet.next()) {
			System.out.println("Schema Name = " + resultSet.getString("TABLE_CAT"));
		}
		resultSet.close();
		// --- LISTING DATABASE TABLE NAMES ---
		String[] types = { "TABLE" };
		resultSet = conn.getMetaData().getTables(databaseName, null, "%", types);
		String tableName = "";

		String column;
		String type;
		String namepk1 = "";
		String namepk2 = "";
		String pktype = "";
		boolean aux = true;
		boolean pk2 = true;
		while (resultSet.next()) {
			pk2 = false;
			aux = true;
			namepk1 = "";
			namepk2 = "";
			pktype = "";
			tableName = resultSet.getString(3).toLowerCase();
			table_nameformated = FCol(tableName);
			System.out.println("Table Name = " + tableName);

			dm = conn.getMetaData();
			resultSet2 = dm.getColumns(null, null, tableName, null);
			while (resultSet2.next()) {
				String columnName = resultSet2.getString("COLUMN_NAME");
				int nullable = resultSet2.getInt("NULLABLE");
				if (nullable == DatabaseMetaData.columnNullable) {
				} else {
					System.out.println(columnName + ": nullable false");
				}
			}

			dm = conn.getMetaData();
			resultSet2 = dm.getPrimaryKeys("", "", tableName);

			while (resultSet2.next()) {
				if (aux)
					namepk1 = resultSet2.getString("COLUMN_NAME").toLowerCase();
				else
					namepk2 = resultSet2.getString("COLUMN_NAME").toLowerCase();
				aux = false;
			}

			if (!namepk2.equalsIgnoreCase("")) {
				pk2 = true;
			}

			System.out.println("pk1: " + namepk1 + " pk2: " + namepk2);

			statement = conn.createStatement();
			resultSet3 = statement.executeQuery(" select * FROM " + tableName);
			rsmd = resultSet3.getMetaData();
			// Get number of columns returned
			numOfCols = rsmd.getColumnCount();

			fw = new FileWriter(path + "\\Ajax_" + table_nameformated + ".java");
			bw = new BufferedWriter(fw);
			bw.write("package com.gerador; \n");
			bw.write("import com.funcs.Utilitario; \n");
			bw.write("import java.util.Date; \n");
			bw.write("import javax.servlet.http.HttpServletRequest; \n");
			bw.write("import javax.servlet.http.HttpServletResponse; \n");
			bw.write("import org.json.simple.JSONObject; \n");
			bw.write("import java.sql.Connection; \n");
			bw.write("import java.text.SimpleDateFormat; \n");
			bw.write("import java.io.PrintWriter; \n");
			bw.write("import org.json.simple.JSONArray; \n");

			bw.write("\n");
			bw.write("public class Ajax_" + table_nameformated + "{ \n");
			bw.write("\n");

			// **************************** CARREGAUNICO ***************************
			bw.write(" public void carregaUnicoAjax(HttpServletRequest request, HttpServletResponse response, Connection conn ) throws Exception{ ");

			bw.write(" JSONObject retorno = new JSONObject();	PrintWriter out = response.getWriter(); ");

			for (int i = 1; i <= numOfCols; ++i) {
				column = rsmd.getColumnName(i);
				type = rsmd.getColumnTypeName(i);

				if (column.equalsIgnoreCase(namepk1)) {
					bw.write(" String pk = request.getParameter(\"" + FLow(namepk1) + "\") == null ? \"\" : request.getParameter(\"" + FLow(namepk1) + "\");  ");
				} else if (column.equalsIgnoreCase(namepk2)) {
					bw.write(" String pk2 = request.getParameter(\"" + FLow(namepk2) + "\") == null ? \"\" : request.getParameter(\"" + FLow(namepk2) + "\");  ");
				}

			}

			bw.write(" 	if (!Utilitario.isNumeric(pk)) { throw new Exception(\"Parâmetro inválido!\"); }");

			if (pk2) {
				bw.write(" 	if (!Utilitario.isNumeric(pk2)) { throw new Exception(\"Parâmetro inválido!\"); }");
			}

			bw.write(" 	" + table_nameformated + " obj = new " + table_nameformated + "(conn); ");

			for (int i = 1; i <= numOfCols; ++i) {
				column = rsmd.getColumnName(i);
				type = rsmd.getColumnTypeName(i);

				if (column.equalsIgnoreCase(namepk1)) {

					if (returnType(type, 1).equalsIgnoreCase("Int")) {
						bw.write(" 	obj.set" + FCol(namepk1) + "( Integer.parseInt(pk) );");

					} else if (returnType(type, 1).equalsIgnoreCase("Long")) {
						bw.write(" 	obj.set" + FCol(namepk1) + "( Long.parseLong(pk) );");
					}

				}

				if (column.equalsIgnoreCase(namepk2)) {

					if (returnType(type, 1).equalsIgnoreCase("Int")) {
						bw.write(" 	obj.set" + FCol(namepk2) + "( Integer.parseInt(pk2) );");

					} else if (returnType(type, 1).equalsIgnoreCase("Long")) {
						bw.write(" 	obj.set" + FCol(namepk2) + "( Long.parseLong(pk2) );");
					}

				}

			}

			bw.write(" 	obj.lista();");
			bw.write(" 	if(obj.next()){");

			for (int i = 1; i <= numOfCols; ++i) {
				column = rsmd.getColumnName(i);
				type = rsmd.getColumnTypeName(i);


					if (returnType(type, 1).equalsIgnoreCase("Integer") || returnType(type, 1).equalsIgnoreCase("Long")) {
						bw.write("retorno.put(\"" + FLow(column) + "\", obj.getRs" + FCol(column) + "() == null ? 0 : obj.getRs" + FCol(column) + "() );");
					} else if (returnType(type, 1).equalsIgnoreCase("Double")) {
						bw.write("retorno.put(\"" + FLow(column) + "\", obj.getRs" + FCol(column) + "() == null ? 0 :Utilitario.df2.format( obj.getRs" + FCol(column) + "() ));");
					} else if (returnType(type, 3).equalsIgnoreCase("date")) {
						bw.write("retorno.put(\"" + FLow(column) + "\", obj.getRs" + FCol(column) + "() == null ? 0 :new SimpleDateFormat(\"dd/MM/yyyy HH:mm\").format(obj.getRs" + FCol(column) + "() ));");
					} else if (returnType(type, 3).equalsIgnoreCase("time")) {
						bw.write("retorno.put(\"" + FLow(column) + "\", obj.getRs" + FCol(column) + "() == null ? 0 :new SimpleDateFormat(\"HH:mm\").format(obj.getRs" + FCol(column) + "() ));");
					} else {
						bw.write("retorno.put(\"" + FLow(column) + "\", obj.getRs" + FCol(column) + "() == null ? \"\" : obj.getRs" + FCol(column) + "() );");
					}


			}

			bw.write(" 	}");

			bw.write(" 	retorno.put(\"msg\", \"\");");
			bw.write(" 	retorno.put(\"msgok\", \"ok\");");
			bw.write(" 	out.print(retorno.toJSONString());");

			bw.write(" }");

			// ****************Insert_update*******************
			bw.write(" public void SaveAjax(HttpServletRequest request, HttpServletResponse response, Connection conn ) throws Exception{ ");

			bw.write(" JSONObject retorno = new JSONObject();	PrintWriter out = response.getWriter(); ");

			for (int i = 1; i <= numOfCols; ++i) {
				column = rsmd.getColumnName(i);
				type = rsmd.getColumnTypeName(i);
				bw.write(" String " + FLow(column) + " = request.getParameter(\"" + FLow(column) + "\") == null ? \"\" : request.getParameter(\"" + FLow(column) + "\");  ");
			}

			for (int i = 1; i <= numOfCols; ++i) {
				column = rsmd.getColumnName(i);
				type = rsmd.getColumnTypeName(i);

				if (returnType(type, 1).equalsIgnoreCase("long") || returnType(type, 1).equalsIgnoreCase("double") || returnType(type, 1).equalsIgnoreCase("int")) {
					bw.write(" 	if (!Utilitario.isNumeric(" + FLow(column) + ")) { throw new Exception(\"Parâmetro inválido!\"); }");
				} else {
					bw.write(" if(" + FLow(column) + ".equalsIgnoreCase(\"\")){ throw new Exception(\"Campo " + FLow(column) + " esta em branco!\"); } ");
				}

			}

			bw.write(" 	" + table_nameformated + " obj = new " + table_nameformated + "(conn); ");

			for (int i = 1; i <= numOfCols; ++i) {
				column = rsmd.getColumnName(i);
				type = rsmd.getColumnTypeName(i);

				if (returnType(type, 1).equalsIgnoreCase("int")) {
					bw.write(" 	obj.set" + FCol(column) + "( Integer.parseInt(" + FLow(column) + ") );");
				} else if (returnType(type, 1).equalsIgnoreCase("Long")) {
					bw.write(" 	obj.set" + FCol(column) + "( Long.parseLong(" + FLow(column) + ") );");
				} else if (returnType(type, 1).equalsIgnoreCase("Double")) {
					bw.write(" 	obj.set" + FCol(column) + "( Double.parseDouble(" + FLow(column) + ") );");
				} else if (returnType(type, 3).equalsIgnoreCase("Date")) {
					bw.write(" 	obj.set" + FCol(column) + "(	Utilitario.getTimeStamp(new SimpleDateFormat(\"dd/MM/yyyy\").parse(" + FLow(column) + ")) );");
				} else if (returnType(type, 3).equalsIgnoreCase("Time")) {
					bw.write(" 	obj.set" + FCol(column) + "( Utilitario.getTimeStamp(new SimpleDateFormat(\"HH:mm\").parse(" + FLow(column) + ")) );");
				} else {
					bw.write(" 	obj.set" + FCol(column) + "( " + FLow(column) + " );");
				}

			}

			bw.write(" 	obj.insert();");
			bw.write(" 	obj.update();");

			bw.write(" 	retorno.put(\"msg\", \"\");");
			bw.write(" 	retorno.put(\"msgok\", \"ok\");");
			bw.write(" 	out.print(retorno.toJSONString());");

			bw.write(" }");

			// ********************LISTAGEM

			bw.write(" public void ListaAjax(HttpServletRequest request, HttpServletResponse response, Connection conn ) throws Exception{ ");

			bw.write(" JSONObject retorno = new JSONObject();JSONObject objjson = new JSONObject();	PrintWriter out = response.getWriter(); JSONArray array = new JSONArray();");

			for (int i = 1; i <= numOfCols; ++i) {
				column = rsmd.getColumnName(i);
				type = rsmd.getColumnTypeName(i);
				bw.write(" String " + FLow(column) + " = request.getParameter(\"" + FLow(column) + "\") == null ? \"\" : request.getParameter(\"" + FLow(column) + "\");  ");
			}

			for (int i = 1; i <= numOfCols; ++i) {
				column = rsmd.getColumnName(i);
				type = rsmd.getColumnTypeName(i);

				if (returnType(type, 1).equalsIgnoreCase("long") || returnType(type, 1).equalsIgnoreCase("double") || returnType(type, 1).equalsIgnoreCase("int")) {
					bw.write(" 	if (!Utilitario.isNumeric(" + FLow(column) + ")) { throw new Exception(\"Parâmetro inválido!\"); }");
				} else {
					bw.write(" if(" + FLow(column) + ".equalsIgnoreCase(\"\")){ throw new Exception(\"Campo " + FLow(column) + " esta em branco!\"); } ");
				}

			}

			bw.write(" 	" + table_nameformated + " obj = new " + table_nameformated + "(conn); ");

			for (int i = 1; i <= numOfCols; ++i) {
				column = rsmd.getColumnName(i);
				type = rsmd.getColumnTypeName(i);

				bw.write(" if(!" + FLow(column) + ".equalsIgnoreCase(\"\")){  ");

				if (returnType(type, 1).equalsIgnoreCase("int")) {
					bw.write(" 	obj.set" + FCol(column) + "( Integer.parseInt(" + FLow(column) + ") );");
				} else if (returnType(type, 1).equalsIgnoreCase("Long")) {
					bw.write(" 	obj.set" + FCol(column) + "( Long.parseLong(" + FLow(column) + ") );");
				} else if (returnType(type, 1).equalsIgnoreCase("Double")) {
					bw.write(" 	obj.set" + FCol(column) + "( Double.parseDouble(" + FLow(column) + ") );");
				} else if (returnType(type, 3).equalsIgnoreCase("Date")) {
					bw.write(" 	obj.set" + FCol(column) + "(	Utilitario.getTimeStamp(new SimpleDateFormat(\"dd/MM/yyyy\").parse(" + FLow(column) + ")) );");
				} else if (returnType(type, 3).equalsIgnoreCase("Time")) {
					bw.write(" 	obj.set" + FCol(column) + "( Utilitario.getTimeStamp(new SimpleDateFormat(\"HH:mm\").parse(" + FLow(column) + ")) );");
				} else {
					bw.write(" 	obj.set" + FCol(column) + "( " + FLow(column) + " );");
				}
				bw.write(" }");
			}

			bw.write(" 	obj.lista();");
			bw.write(" 	while(obj.next()){");
			bw.write("objjson = new JSONObject();");
			for (int i = 1; i <= numOfCols; ++i) {
				column = rsmd.getColumnName(i);
				type = rsmd.getColumnTypeName(i);

				if (returnType(type, 1).equalsIgnoreCase("Integer") || returnType(type, 1).equalsIgnoreCase("Long")) {
					bw.write("objjson.put(\"" + FLow(column) + "\", obj.getRs" + FCol(column) + "() == null ? 0 : obj.getRs" + FCol(column) + "() );");
				} else if (returnType(type, 1).equalsIgnoreCase("Double")) {
					bw.write("objjson.put(\"" + FLow(column) + "\", obj.getRs" + FCol(column) + "() == null ? 0 :Utilitario.df2.format( obj.getRs" + FCol(column) + "() ));");
				} else if (returnType(type, 3).equalsIgnoreCase("date")) {
					bw.write("objjson.put(\"" + FLow(column) + "\", obj.getRs" + FCol(column) + "() == null ? 0 :new SimpleDateFormat(\"dd/MM/yyyy HH:mm\").format(obj.getRs" + FCol(column) + "() ));");
				} else if (returnType(type, 3).equalsIgnoreCase("time")) {
					bw.write("objjson.put(\"" + FLow(column) + "\", obj.getRs" + FCol(column) + "() == null ? 0 :new SimpleDateFormat(\"HH:mm\").format(obj.getRs" + FCol(column) + "() ));");
				} else {
					bw.write("objjson.put(\"" + FLow(column) + "\", obj.getRs" + FCol(column) + "() == null ? \"\" : obj.getRs" + FCol(column) + "() );");
				}

			}
			bw.write("array.add(objjson);");
			bw.write(" 	}");
			bw.write(" 	retorno.put(\"lista\", array);");
			bw.write(" 	retorno.put(\"msg\", \"\");");
			bw.write(" 	retorno.put(\"msgok\", \"ok\");");
			bw.write(" 	out.print(retorno.toJSONString());");

			bw.write(" }");

			bw.write("\n \n }");// fim classe
			resultSet3.close();

			if (bw != null)
				bw.close();

			if (fw != null)
				fw.close();

		}

		resultSet.close();
	}
	// --- LISTING DATABASE COLUMN NAMES ---

	public static void jsFuncs(Connection conn, String databaseName, String path) throws Exception {

		// --- LISTING DATABASE SCHEMA NAMES ---
		ResultSet resultSet = conn.getMetaData().getCatalogs();
		ResultSet resultSet2;
		ResultSet resultSet3;
		BufferedWriter bw = null;
		FileWriter fw = null;
		Statement statement;
		ResultSetMetaData rsmd;
		int numOfCols = 0;
		String table_nameformated = "";
		DatabaseMetaData dm;
		while (resultSet.next()) {
			System.out.println("Schema Name = " + resultSet.getString("TABLE_CAT"));
		}
		resultSet.close();
		// --- LISTING DATABASE TABLE NAMES ---
		String[] types = { "TABLE" };
		resultSet = conn.getMetaData().getTables(databaseName, null, "%", types);
		String tableName = "";

		String column;
		String type;
		String namepk1 = "";
		String namepk2 = "";
		String pktype = "";
		boolean aux = true;
		boolean pk2 = true;
		while (resultSet.next()) {
			pk2 = false;
			aux = true;
			namepk1 = "";
			namepk2 = "";
			pktype = "";
			tableName = resultSet.getString(3).toLowerCase();
			table_nameformated = FCol(tableName);
			System.out.println("Table Name = " + tableName);

			dm = conn.getMetaData();
			resultSet2 = dm.getPrimaryKeys("", "", tableName);

			while (resultSet2.next()) {
				if (aux)
					namepk1 = resultSet2.getString("COLUMN_NAME").toLowerCase();
				else
					namepk2 = resultSet2.getString("COLUMN_NAME").toLowerCase();
				aux = false;
			}

			if (!namepk2.equalsIgnoreCase("")) {
				pk2 = true;
			}

			System.out.println("pk1: " + namepk1 + " pk2: " + namepk2);

			statement = conn.createStatement();
			resultSet3 = statement.executeQuery(" select * FROM " + tableName);
			rsmd = resultSet3.getMetaData();
			// Get number of columns returned
			numOfCols = rsmd.getColumnCount();

			fw = new FileWriter(path + "\\" + table_nameformated + "_funcs.js");
			bw = new BufferedWriter(fw);
			// ************salvar***********
			bw.write("function salvar" + table_nameformated + "() {");
			bw.write("var data = {} \n");
			bw.write("data[\"cmd\"] =''; \n");

			for (int i = 1; i <= numOfCols; ++i) {

				column = rsmd.getColumnName(i);
				type = rsmd.getColumnTypeName(i);

				if (returnType(type, 0).equalsIgnoreCase("Double") || returnType(type, 0).equalsIgnoreCase("Integer") || returnType(type, 0).equalsIgnoreCase("Long")) {
					bw.write("data[\"" + FLow(column) + "\"] =  $(\"#" + FLow(column) + "\").autoNumeric('get'); \n");
				} else {
					bw.write("data[\"" + FLow(column) + "\"] =  $(\"#" + FLow(column) + "\").val(); \n");
				}

			}

			bw.write("$.blockUI({message : 'Salvando...'});");
			bw.write("$.ajax({");
			bw.write("type : \"POST\",");
			bw.write("	url : \"?acao=ajax\",");
			bw.write("	dataType : \"json\",");
			bw.write("async : true,");
			bw.write("	data : data,");
			bw.write("	success : function(data) {");
			bw.write("if (data.msgok == 'ok') { sysMsg(data.msg,'M'); setTimeout(function() { $.unblockUI();}, 3000);} else {$.unblockUI();sysMsg(data.erro, 'E');}");
			bw.write("	$.unblockUI();");
			bw.write("}, error : function(msg) {$.unblockUI();}});");
			bw.write("}");

			// ************ready***********
			bw.write("	$(document).ready(function() {");
			bw.write("	$(\"#btn_salvar\").click(function() {");
			bw.write(" salvar" + tableName + "(); ");
			bw.write("});");

			for (int i = 1; i <= numOfCols; ++i) {

				column = rsmd.getColumnName(i);
				type = rsmd.getColumnTypeName(i);

				if (returnType(type, 0).equalsIgnoreCase("Double")) {
					bw.write(" $(\"#" + FLow(column) + "\").autoNumeric('init',numerico); \n");
				}

				if (returnType(type, 0).equalsIgnoreCase("Integer") || returnType(type, 0).equalsIgnoreCase("Long")) {
					bw.write(" $(\"#" + FLow(column) + "\").autoNumeric('init',inteiro); \n");
				}

			}

			bw.write("});");

			// ************lista***********
			bw.write("function lista" + table_nameformated + "() {");
			bw.write("var data = {} \n");
			bw.write("data[\"cmd\"] =''; \n");

			for (int i = 1; i <= numOfCols; ++i) {

				column = rsmd.getColumnName(i);
				type = rsmd.getColumnTypeName(i);

				if (column.equalsIgnoreCase(namepk1) || column.equalsIgnoreCase(namepk2)) {
					bw.write("data[\"" + FLow(column) + "\"] =  $(\"#" + FLow(column) + "\").autoNumeric('get'); \n");
				}

			}

			bw.write("$.blockUI({message : 'Carregando...'});");
			bw.write("$.ajax({");
			bw.write("type : \"POST\",");
			bw.write("	url : \"?acao=ajax\",");
			bw.write("	dataType : \"json\",");
			bw.write("async : true,");
			bw.write("	data : data,");
			bw.write("	success : function(data) {");
			bw.write("if (data.msgok == 'ok') {");

			for (int i = 1; i <= numOfCols; ++i) {

				column = rsmd.getColumnName(i);
				type = rsmd.getColumnTypeName(i);

				if (returnType(type, 0).equalsIgnoreCase("Double") || returnType(type, 0).equalsIgnoreCase("Integer") || returnType(type, 0).equalsIgnoreCase("Long")) {
					bw.write(" $(\"#" + FLow(column) + "\").autoNumeric('set',data." + FLow(column) + "); \n");
				} else {
					bw.write("$(\"#" + FLow(column) + "\").val(data." + FLow(column) + "); \n");
				}

			}

			bw.write("} else {$.unblockUI();sysMsg(data.erro, 'E');}");
			bw.write("	$.unblockUI();");
			bw.write("}, error : function(msg) {$.unblockUI();}});");
			bw.write("}");

			if (bw != null)
				bw.close();

			if (fw != null)
				fw.close();

			resultSet3.close();
		}
		resultSet.close();
		// --- LISTING DATABASE COLUMN NAMES ---

	}

	public static void javaHC(Connection conn, String databaseName, String path) throws Exception {

		// --- LISTING DATABASE SCHEMA NAMES ---
		ResultSet resultSet = conn.getMetaData().getCatalogs();
		ResultSet resultSet2;
		ResultSet resultSet3;
		BufferedWriter bw = null;
		FileWriter fw = null;
		Statement statement;
		ResultSetMetaData rsmd;
		int numOfCols = 0;
		String table_nameformated = "";
		DatabaseMetaData dm;
		while (resultSet.next()) {
			System.out.println("Schema Name = " + resultSet.getString("TABLE_CAT"));
		}
		resultSet.close();
		// --- LISTING DATABASE TABLE NAMES ---
		String[] types = { "TABLE" };
		resultSet = conn.getMetaData().getTables(databaseName, null, "%", types);
		String tableName = "";

		String column;
		String type;
		String namepk1 = "";
		String namepk2 = "";
		String pktype = "";
		boolean aux = true;
		boolean pk2 = true;
		while (resultSet.next()) {
			pk2 = false;
			aux = true;
			namepk1 = "";
			namepk2 = "";
			pktype = "";
			tableName = resultSet.getString(3).toLowerCase();
			table_nameformated = FCol(tableName);
			System.out.println("Table Name = " + tableName);

			dm = conn.getMetaData();
			resultSet2 = dm.getColumns(null, null, tableName, null);
			while (resultSet2.next()) {
				String columnName = resultSet2.getString("COLUMN_NAME");
				int nullable = resultSet2.getInt("NULLABLE");
				if (nullable == DatabaseMetaData.columnNullable) {
				} else {
					System.out.println(columnName + ": nullable false");
				}
			}

			dm = conn.getMetaData();
			resultSet2 = dm.getPrimaryKeys("", "", tableName);

			while (resultSet2.next()) {
				if (aux)
					namepk1 = resultSet2.getString("COLUMN_NAME").toLowerCase();
				else
					namepk2 = resultSet2.getString("COLUMN_NAME").toLowerCase();
				aux = false;
			}

			if (!namepk2.equalsIgnoreCase("")) {
				pk2 = true;
			}

			System.out.println("pk1: " + namepk1 + " pk2: " + namepk2);

			statement = conn.createStatement();
			resultSet3 = statement.executeQuery(" select * FROM " + tableName);
			rsmd = resultSet3.getMetaData();
			// Get number of columns returned
			numOfCols = rsmd.getColumnCount();

			File f = new File(path + "\\HM_" + table_nameformated + ".java");
			if (!f.exists()) {

				fw = new FileWriter(path + "\\HM_" + table_nameformated + ".java");
				bw = new BufferedWriter(fw);
				bw.write("package com.gerador; \n");
				bw.write("import java.sql.Connection; \n");
				bw.write("\n");
				bw.write("public class HM_" + table_nameformated + " extends " + table_nameformated + " { \n");
				bw.write("\n");

				bw.write("public HM_" + table_nameformated + "(Connection conn) {super(conn);}");

				bw.write("\n \n }");// fim classe
				resultSet3.close();

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			}
		}
		resultSet.close();

	}

	public static void javaClasse(Connection conn, String databaseName, String path) throws Exception {

		// --- LISTING DATABASE SCHEMA NAMES ---
		ResultSet resultSet = conn.getMetaData().getCatalogs();
		ResultSet resultSet2;
		ResultSet resultSet3;
		BufferedWriter bw = null;
		FileWriter fw = null;
		Statement statement;
		ResultSetMetaData rsmd;
		int numOfCols = 0;
		String table_nameformated = "";
		DatabaseMetaData dm;
		while (resultSet.next()) {
			System.out.println("Schema Name = " + resultSet.getString("TABLE_CAT"));
		}
		resultSet.close();
		// --- LISTING DATABASE TABLE NAMES ---
		String[] types = { "TABLE" };
		resultSet = conn.getMetaData().getTables(databaseName, null, "%", types);
		String tableName = "";

		String column;
		String type;
		String namepk1 = "";
		String namepk2 = "";
		String pktype = "";
		boolean aux = true;
		boolean pk2 = true;
		while (resultSet.next()) {
			pk2 = false;
			aux = true;
			namepk1 = "";
			namepk2 = "";
			pktype = "";
			tableName = resultSet.getString(3).toLowerCase();
			table_nameformated = FCol(tableName);
			System.out.println("Table Name = " + tableName);

			dm = conn.getMetaData();
			resultSet2 = dm.getColumns(null, null, tableName, null);
			while (resultSet2.next()) {
				String columnName = resultSet2.getString("COLUMN_NAME");
				int nullable = resultSet2.getInt("NULLABLE");
				if (nullable == DatabaseMetaData.columnNullable) {
				} else {
					System.out.println(columnName + ": nullable false");
				}
			}

			dm = conn.getMetaData();
			resultSet2 = dm.getPrimaryKeys("", "", tableName);

			while (resultSet2.next()) {
				if (aux)
					namepk1 = resultSet2.getString("COLUMN_NAME").toLowerCase();
				else
					namepk2 = resultSet2.getString("COLUMN_NAME").toLowerCase();
				aux = false;
			}

			if (!namepk2.equalsIgnoreCase("")) {
				pk2 = true;
			}

			System.out.println("pk1: " + namepk1 + " pk2: " + namepk2);

			statement = conn.createStatement();
			resultSet3 = statement.executeQuery(" select * FROM " + tableName);
			rsmd = resultSet3.getMetaData();
			// Get number of columns returned
			numOfCols = rsmd.getColumnCount();

			fw = new FileWriter(path + "\\" + table_nameformated + ".java");
			bw = new BufferedWriter(fw);
			bw.write("package com.phpdao.domain; \n");
			bw.write("import java.sql.Connection; \n");
			bw.write("import java.sql.PreparedStatement; \n");
			bw.write("import java.sql.ResultSet; \n");
			bw.write("import com.funcs.Utilitario; \n");
			bw.write("import java.util.Date; \n");
			bw.write("import java.sql.Timestamp; \n");

			bw.write("\n");
			bw.write("public class " + table_nameformated + " { \n");
			bw.write("\n");

			bw.write("private PreparedStatement st; \n");
			bw.write("private StringBuffer sql; \n");
			bw.write("private ResultSet rs; \n");
			bw.write("private Connection conn; \n");
			bw.write("private String Where; \n");
			bw.write("private String Join; \n");
			bw.write("private String LastSentence; \n");
			bw.write("private String Select; \n");

			bw.write("public " + FCol(tableName) + "(Connection conn) { super();this.conn = conn;} \n");

			for (int i = 1; i <= numOfCols; ++i) {

				column = rsmd.getColumnName(i);
				type = rsmd.getColumnTypeName(i);

				bw.write(" private " + returnType(rsmd.getColumnTypeName(i), 0) + " " + FCol(rsmd.getColumnName(i)) + "; \n");
				bw.write(" private " + returnType(rsmd.getColumnTypeName(i), 0) + " rs" + FCol(rsmd.getColumnName(i)) + "; \n");
				if (!column.equalsIgnoreCase(namepk1) && !column.equalsIgnoreCase(namepk2)) {
					bw.write(" private  boolean  null" + FCol(rsmd.getColumnName(i)) + " = false; \n");
				}

			}

			bw.write("public PreparedStatement getSt() ");
			bw.write("{		return st; ");
			bw.write("	} ");
			bw.write("\n ");
			bw.write("public void setSt(PreparedStatement st) ");
			bw.write("{		this.st = st; ");
			bw.write("	} ");
			bw.write("\n ");
			bw.write("public StringBuffer getSql() ");
			bw.write("{		return sql; ");
			bw.write("	} ");
			bw.write("\n ");
			bw.write("public void setSql(StringBuffer sql) ");
			bw.write("{		this.sql = sql; ");
			bw.write("	} ");
			bw.write("\n ");
			bw.write("public ResultSet getRs() ");
			bw.write("{		return rs; ");
			bw.write("	} ");
			bw.write("\n ");
			bw.write("public void setRs(ResultSet rs) ");
			bw.write("{		this.rs = rs; ");
			bw.write("	} ");
			bw.write("\n ");
			bw.write("public Connection getConn() ");
			bw.write("{		return conn; ");
			bw.write("	} ");
			bw.write("\n ");
			bw.write("public void setConn(Connection conn) ");
			bw.write("{		this.conn = conn; ");
			bw.write("	}");
			bw.write("\n ");

			bw.write("public String getWhere() { return this.Where; }");
			bw.write("public void setWhere(String where) { this.Where = where; }");
			bw.write("public String getJoin() {return this.Join;}");
			bw.write("public void setJoin(String join) {this.Join = join;}");
			bw.write("public String getLastSentence() {return this.LastSentence;}");
			bw.write("public void setLastSentence(String last) {this.LastSentence = last;}");
			bw.write("public String getSelect() { return this.Select; }");
			bw.write("public void setSelect(String select) { this.Select = select; }");

			// **************************** GET AND SETTER ***************************
			for (int i = 1; i <= numOfCols; ++i) {
				column = rsmd.getColumnName(i);
				type = rsmd.getColumnTypeName(i);

				bw.write("public " + returnType(type, 0) + " get" + FCol(column) + "() ");
				bw.write("{		return " + FCol(column) + " ; ");
				bw.write("	} ");
				bw.write("\n ");
				bw.write("public void set" + FCol(column) + "(" + returnType(type, 0) + " var) ");
				bw.write("{		this." + FCol(column) + " = var; ");
				bw.write("	} ");
				bw.write("\n ");

				bw.write("public " + returnType(type, 0) + " getRs" + FCol(column) + "() ");
				bw.write("{		return rs" + FCol(column) + " ; ");
				bw.write("	} ");
				bw.write("\n ");
				bw.write("public void setRs" + FCol(column) + "(" + returnType(type, 0) + " var) ");
				bw.write("{		this.rs" + FCol(column) + " = var; ");
				bw.write("	} ");
				bw.write("\n ");

				if (!column.equalsIgnoreCase(namepk1) && !column.equalsIgnoreCase(namepk2)) {

					bw.write("public boolean getNull" + FCol(column) + "() ");
					bw.write("{		return null" + FCol(column) + " ; ");
					bw.write("	} ");
					bw.write("\n ");
					bw.write("public void setNull" + FCol(column) + "(boolean var) ");
					bw.write("{		this.null" + FCol(column) + " = var; ");
					bw.write("	} ");
					bw.write("\n ");
				}

			}

			// **************************** posicionaRs ***************************
			bw.write(" public void posicionaRs() throws Exception{ ");

			bw.write("if ( getSelect() == null ) {   ");

			for (int i = 1; i <= numOfCols; ++i) {
				column = rsmd.getColumnName(i);
				type = rsmd.getColumnTypeName(i);
				bw.write(" try {  ");
				bw.write(" rs" + FCol(column) + " = rs.get" + returnType(type, 1) + "(\"" + column.toLowerCase() + "\");");
				bw.write(" } catch (Exception e) { e.printStackTrace();  } ");
			}
			bw.write("}  }  ");

			// **************************** NEXT ***************************
			bw.write(" public boolean next(){  ");
			bw.write("  boolean resultado; ");
			bw.write("  resultado = false; ");
			bw.write("   try{ limpaRs(); ");
			bw.write("   resultado = rs.next(); ");
			bw.write("   if (resultado){ posicionaRs(); } ");
			bw.write("  } catch (Exception e){    e.printStackTrace(); } ");
			bw.write("    return resultado; }");

			// **************************** LIMPARS ***************************
			bw.write(" public void limpaRs() throws Exception{ ");
			for (int i = 1; i <= numOfCols; ++i) {
				column = rsmd.getColumnName(i);
				type = rsmd.getColumnTypeName(i);
				bw.write(" rs" + FCol(column) + "=  null ; ");
			}
			bw.write("  }  ");

			// **************************** LISTA ***************************
			bw.write("public ResultSet lista() throws Exception { ");
			bw.write("sql = new StringBuffer();");

			bw.write(" if(getSelect()!=null){ ");
			bw.write("sql.append(\" select \"+getSelect()+\" \");");
			bw.write(" }else {");
			bw.write("sql.append(\" select *   \");");
			bw.write(" }");

			bw.write(" if(getJoin()!=null){ ");
			bw.write("sql.append(\" from \"+getJoin()+\" where  1=1 \");");
			bw.write(" }else {");
			bw.write("sql.append(\" from " + tableName + " where  1=1 \");");
			bw.write(" }");

			for (int i = 1; i <= numOfCols; ++i) {
				column = rsmd.getColumnName(i);
				type = rsmd.getColumnTypeName(i);

				bw.write(" if( get" + FCol(column) + "() != null ) {");
				bw.write(" sql.append(\" and " + tableName + " ." + column.toLowerCase() + " = ? \"); }");
			}

			bw.write(" if(getWhere()!=null){ sql.append(\" and \"+ getWhere()+\" \"); }       ");

			bw.write(" if(getLastSentence()!=null){ sql.append(\" \"+ getLastSentence()+\"\"); }       ");

			bw.write(" st = conn.prepareStatement(sql.toString()); ");
			bw.write(" int contparam = 1; ");

			for (int i = 1; i <= numOfCols; ++i) {
				column = rsmd.getColumnName(i);
				type = rsmd.getColumnTypeName(i);

				bw.write(" if( get" + FCol(column) + "() != null ){");

				bw.write(" st.set" + returnType(type, 1) + "(contparam,get" + FCol(column) + "());");
				bw.write(" contparam++;} ");
			}

			bw.write(" 	rs = st.executeQuery(); ");

			bw.write(" 	return rs; }");

			// **************************** UPDATE ***************************
			bw.write("public void update() throws Exception { ");
			bw.write("sql = new StringBuffer();");
			bw.write("sql.append(\" update " + tableName + " set " + namepk1 + " =  \" + get" + FCol(namepk1) + "() + \"  \");");

			for (int i = 1; i <= numOfCols; ++i) {
				column = rsmd.getColumnName(i);
				type = rsmd.getColumnTypeName(i);
				if (!column.equalsIgnoreCase(namepk1) && !column.equalsIgnoreCase(namepk2)) {
					bw.write(" if( get" + FCol(column) + "() != null ) {");
					bw.write(" sql.append(\" ,  " + column.toLowerCase() + " = ? \"); }");
				}
				if (!column.equalsIgnoreCase(namepk1) && !column.equalsIgnoreCase(namepk2)) {
					bw.write(" if( getNull" + FCol(column) + "()) {");
					bw.write(" sql.append(\" ,  " + column.toLowerCase() + " = null \"); }");
				}

			}

			bw.write(" sql.append(\" where " + namepk1 + " =  \" + get" + FCol(namepk1) + "() + \"  \");");
			if (pk2) {
				bw.write(" sql.append(\" and " + namepk2 + " =  \" + get" + FCol(namepk2) + "() + \"  \");");
			}

			bw.write(" if(getWhere()!=null){ sql.append(\" and \"+ getWhere()+\" \"); }       ");

			bw.write(" st = conn.prepareStatement(sql.toString()); ");
			bw.write(" int contparam = 1; ");

			for (int i = 1; i <= numOfCols; ++i) {
				column = rsmd.getColumnName(i);
				type = rsmd.getColumnTypeName(i);
				if (!column.equalsIgnoreCase(namepk1) && !column.equalsIgnoreCase(namepk2)) {
					bw.write(" if( get" + FCol(column) + "() != null ){");

					bw.write(" st.set" + returnType(type, 1) + "(contparam,get" + FCol(column) + "());");
					bw.write(" contparam++;} ");
				}
			}

			bw.write(" 		st.executeUpdate() ;} ");

			// **************************** DELETE ***************************
			bw.write("public void delete() throws Exception { ");
			bw.write("sql = new StringBuffer();");
			bw.write("sql.append(\" delete from " + tableName + " \");");

			bw.write(" sql.append(\" where " + namepk1 + " =  \" + get" + FCol(namepk1) + "() + \"  \");");
			if (pk2) {
				bw.write(" sql.append(\" and " + namepk2 + " =  \" + get" + FCol(namepk2) + "() + \"  \");");
			}

			bw.write(" st = conn.prepareStatement(sql.toString()); ");
			bw.write(" 		st.executeUpdate() ;} ");

			// **************************** INSERT ***************************
			bw.write("public void insert() throws Exception { ");
			bw.write("sql = new StringBuffer();");
			bw.write("StringBuffer values = new StringBuffer();");

			if (!pk2) {
				bw.write("sql.append(\" insert into " + tableName + "  (" + namepk1 + " \" );");
				bw.write("values.append(\" value (? \");");

			} else {
				bw.write("sql.append(\" insert into " + tableName + "  (" + namepk1 + "," + namepk2 + " \" );");
				bw.write("values.append(\" value (?,? \");");
			}

			for (int i = 1; i <= numOfCols; ++i) {
				column = rsmd.getColumnName(i);
				type = rsmd.getColumnTypeName(i);

				bw.write(" if( get" + FCol(column) + "() != null ) {");
				bw.write("sql.append(\" , " + column.toLowerCase() + " \");");
				bw.write("values.append(\", ? \");");
				bw.write(" } ");

			}
			bw.write("sql.append(\" ) \");");
			bw.write("values.append(\" ) \");");
			bw.write("sql.append( values.toString()); ");

			bw.write("	st = conn.prepareStatement(sql.toString()); ");

			for (int i = 1; i <= numOfCols; ++i) {
				column = rsmd.getColumnName(i);
				type = rsmd.getColumnTypeName(i);

				if (pk2) {
					if (column.equalsIgnoreCase(namepk2)) {
						pktype = type;
					}
				} else {
					if (column.equalsIgnoreCase(namepk1)) {
						pktype = type;
					}
				}

			}

			bw.write("  " + returnType(pktype, 2) + " id = ");

			if (!pk2) {
				if (returnType(pktype, 2).equalsIgnoreCase("long")) {
					bw.write("	 Utilitario.retornaIdinsertLong");
				} else {
					bw.write("	 Utilitario.retornaIdinsert ");
				}
				bw.write("	 (\"" + tableName + "\", \"" + namepk1 + "\", conn);");
			} else {
				if (returnType(pktype, 2).equalsIgnoreCase("long")) {
					bw.write("	 Utilitario.retornaIdinsertChaveSecundariaLong");
				} else {
					bw.write("	 Utilitario.retornaIdinsertChaveSecundaria ");
				}

				bw.write("	(\"" + tableName + "\", \"" + namepk1 + "\", get" + FCol(namepk1) + "()+\"\", \"" + namepk2 + "\", conn); ");
			}

			bw.write(" int contparam = 1; ");

			for (int i = 1; i <= numOfCols; ++i) {
				column = rsmd.getColumnName(i);
				type = rsmd.getColumnTypeName(i);
					if(pk2){
						if (column.equalsIgnoreCase(namepk1)) {
							bw.write(" st.set" + returnType(type, 1) + "(contparam, get"+FCol(namepk1)+"());");
							bw.write(" contparam++; ");
						}
						
					}else{
						if (column.equalsIgnoreCase(namepk1)) {
							bw.write(" st.set" + returnType(type, 1) + "(contparam, id);");
							bw.write(" contparam++; ");
						}
					}
				
			}

			if (pk2) {

				for (int i = 1; i <= numOfCols; ++i) {
					column = rsmd.getColumnName(i);
					type = rsmd.getColumnTypeName(i);

					if (column.equalsIgnoreCase(namepk2)) {
						bw.write(" st.set" + returnType(type, 1) + "(contparam,id);");
						bw.write(" contparam++; ");
					}
				}

			}

			for (int i = 1; i <= numOfCols; ++i) {
				column = rsmd.getColumnName(i);
				type = rsmd.getColumnTypeName(i);

				if (!column.equalsIgnoreCase(namepk1) && !column.equalsIgnoreCase(namepk2)) {
					bw.write(" if( get" + FCol(column) + "() != null ){");

					bw.write(" st.set" + returnType(type, 1) + "(contparam,get" + FCol(column) + "());");
					bw.write(" contparam++; ");
					bw.write(" } ");
				}
			}

			bw.write(" 		if (st.executeUpdate() == 1) { ");
			if (!pk2) {
				bw.write("set" + FCol(namepk1) + "(id);");
			} else {
				bw.write("set" + FCol(namepk2) + "(id);");
			}
			bw.write("} else { throw new Exception(\"Erro, contate suporte. Inserção de " + tableName + ".\");}}");

			// **************************** INSERT2 *************************** nao funfa com notnull
			

			bw.write("\n \n }");// fim classe

			if (bw != null)
				bw.close();

			if (fw != null)
				fw.close();

			resultSet3.close();
		}
		resultSet.close();
		// --- LISTING DATABASE COLUMN NAMES ---

	}

	public static String FCol(String col) {
		col = col.toLowerCase();
		StringBuffer res = new StringBuffer();
		String[] strArr = col.split("_");
		for (String str : strArr) {
			char[] stringArray = str.trim().toCharArray();
			stringArray[0] = Character.toUpperCase(stringArray[0]);
			str = new String(stringArray);

			res.append(str).append("");
		}

		col = res.toString().trim();

		// col = col.replaceAll("_", "");
		// col = col.substring(0, 1).toUpperCase() + col.substring(1);

		return col;
	}

	public static String FLow(String col) {
		col = col.toLowerCase();

		col = col.toString().trim();

		// col = col.replaceAll("_", "");
		// col = col.substring(0, 1).toUpperCase() + col.substring(1);

		return col;
	}

	public static String returnType(String tipo, int op) {
		String retorno = "";

		if (op == 0) {
			if (tipo.equalsIgnoreCase("DECIMAL")) {
				retorno = "Double";
			} else if (tipo.equalsIgnoreCase("FLOAT")) {
				retorno = "Double";
			} else if (tipo.equalsIgnoreCase("INT")) {
				retorno = "Integer";
			} else if (tipo.equalsIgnoreCase("BIGINT")) {
				retorno = "Long";
			} else if (tipo.equalsIgnoreCase("CHAR")) {
				retorno = "String";
			} else if (tipo.equalsIgnoreCase("VARCHAR")) {
				retorno = "String";
			} else if (tipo.equalsIgnoreCase("DATETIME")) {
				retorno = "Timestamp";
			} else if (tipo.equalsIgnoreCase("TIME")) {
				retorno = "Timestamp";
			}
		} else if (op == 1) {
			if (tipo.equalsIgnoreCase("DECIMAL")) {
				retorno = "Double";
			} else if (tipo.equalsIgnoreCase("FLOAT")) {
				retorno = "Double";
			} else if (tipo.equalsIgnoreCase("INT")) {
				retorno = "Int";
			} else if (tipo.equalsIgnoreCase("BIGINT")) {
				retorno = "Long";
			} else if (tipo.equalsIgnoreCase("CHAR")) {
				retorno = "String";
			} else if (tipo.equalsIgnoreCase("VARCHAR")) {
				retorno = "String";
			} else if (tipo.equalsIgnoreCase("DATETIME")) {
				retorno = "Timestamp";
			} else if (tipo.equalsIgnoreCase("TIME")) {
				retorno = "Timestamp";
			}
		} else if (op == 2) {
			if (tipo.equalsIgnoreCase("INT")) {
				retorno = "int";
			} else if (tipo.equalsIgnoreCase("BIGINT")) {
				retorno = "long";
			}
		} else if (op == 3) {

			if (tipo.equalsIgnoreCase("DATETIME")) {
				retorno = "date";
			} else if (tipo.equalsIgnoreCase("TIME")) {
				retorno = "time";
			}
		}

		return retorno;
	}

	public static void main(String[] args) {
		Connection conn = null;

		try {

//			String path = "D:\\phonegap_projects\\viralemail\\taverna_email\\src\\main\\java\\com\\phpdao\\domain";
			String path = "D:\\phonegap_projects\\geracoes";
			conn = Conexao.getConexao();
			javaClasse(conn, "taverna_email", path);
			jsFuncs(conn, "taverna_email", path);
			javaAjax(conn, "taverna_email", path);
//			javaHC(conn, "taverna_email", path);
			//
			//
//			htmlFields(conn, "taverna_email", path);

			// Cidade cid = new Cidade(conn);
			// cid.getCodCidade(pk);
			// cid.lista();
			// while (cid.next()) {
			//
			// }
			// // cid.setSelect(" count(desc_cidade) as qtd ");
			// String sql = "cidade inner join bairros on bairros.cod_cidade = cidade.cod_cidade ";
			// cid.setJoin(sql);
			// cid.setLastSentence(" group by desc_cidade ");
			// cid.setCodCidade(7);
			// cid.setNullMapsLatitude(true);
			// cid.update();

			// cid.lista();
			// while (cid.next()) {
			// System.out.println(cid.getRs().getString("qtd"));
			// }

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			try {
				conn.close();
			} catch (Exception es) { // TODO: handle exception } }
			}

		}
	}

}
