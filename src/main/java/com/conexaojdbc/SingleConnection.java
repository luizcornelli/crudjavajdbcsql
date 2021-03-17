package com.conexaojdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnection {
	
	private static String url = "jdbc:postgresql://localhost:5432/crudjavajdbcsql";
	private static String password = "admin"; 
	private static String user = "postgres"; 
	private static Connection connection = null; 
	
	static { // Qualquer lugar que invocar o SingleConnection vai chamar o conectar --
		
		conectar();
	}
	
	public SingleConnection() {
		
		conectar();
	}
	
	private static void conectar() {
		
		try {
			
			if(connection == null) { // Numa aplicação a conexão só deve ser gerada uma vez --
				
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection(url, user, password);
				connection.setAutoCommit(false);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		return connection;
	}
	
}
