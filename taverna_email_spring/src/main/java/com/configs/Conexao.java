package com.configs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	//
	 public final static String url = "jdbc:mysql://localhost:3306/";
	 public final static String dbName = "mtosdados?characterEncoding=UTF-8";
	 public final static String driver = "com.mysql.jdbc.Driver";
	 public final static String userName = "root";
	 public final static String password = "root";
	

	
//	teste
//	public final static String url = "jdbc:mysql://mysql05-farm68.kinghost.net/";
//	public final static String dbName = "tragoaqui?characterEncoding=UTF-8";
//	public final static String driver = "com.mysql.jdbc.Driver";
//	public final static String userName = "tragoaqui";
//	public final static String password = "m3t4alupy0ur4ass";
//	//
	
	
//	teste_fit
//	public final static String url = "jdbc:mysql://mysql05-farm68.kinghost.net/";
//	public final static String dbName = "tragoaqui03?characterEncoding=UTF-8";
//	public final static String driver = "com.mysql.jdbc.Driver";
//	public final static String userName = "tragoaqui03";
//	public final static String password = "m3t4alupy0ur4ass";
	//
	
	
	//fit
//	public final static String url = "jdbc:mysql://mysql.tragoaqui.com.br/";
//	public final static String dbName = "tragoaqui02?characterEncoding=UTF-8";
//	public final static String driver = "com.mysql.jdbc.Driver";
//	public final static String userName = "tragoaqui02";
//	public final static String password = "m3t4alupy0ur4ass";

	//tragoaquidrink
//	public final static String url = "jdbc:mysql://mysql05-farm68.kinghost.net/"; 
//	public final static String dbName = "tragoaqui01?characterEncoding=UTF-8";
//	public final static String driver = "com.mysql.jdbc.Driver";
//	public final static String userName = "tragoaqui01";
//	public final static String password = "m3t4alupy0ur4ass";
//	
	
	
	
	//fit_integrator teste
//	public final static String url = "jdbc:mysql://tragoaqui.com.br:3306/";
//	public final static String dbName = "tragoaq_fit_teste?characterEncoding=UTF-8";
//	public final static String driver = "com.mysql.jdbc.Driver";
//	public final static String userName = "tragoaq_admin";
//	public final static String password = "m3t4alupy0ur4ass";
//	
	//fit_integrator quente
//		public final static String url = "jdbc:mysql://tragoaqui.com.br:3306/";
//		public final static String dbName = "tragoaq_fit?characterEncoding=UTF-8";
//		public final static String driver = "com.mysql.jdbc.Driver";
//		public final static String userName = "tragoaq_admin";
//		public final static String password = "m3t4alupy0ur4ass";
////	
//	
	
	public static Connection getConexao() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		Class.forName(driver).newInstance();
		Connection conn = DriverManager.getConnection(url + dbName, userName, password);
		return conn;
	}

}
