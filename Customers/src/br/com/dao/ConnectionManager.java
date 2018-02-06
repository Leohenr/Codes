package br.com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class ConnectionManager {
	private static ConnectionManager instance;
	
	private ConnectionManager() throws ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
	}

	public static ConnectionManager getInstance() throws SQLException{
		try{
			if (instance == null) {
				instance = new ConnectionManager();
			}
		}
		catch(ClassNotFoundException e){
			throw new SQLException("O Driver JDBC nao foi encontrado!");
		}
		return instance;
	}
	
	public Connection getConnection() throws SQLException {

		String usuario = "usuario";
		String senha = "senha";
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:XE";
		
		try{
			return DriverManager.getConnection(jdbcUrl, usuario, senha);
		}
		catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("Erro ao abrir a conexão com banco de dados", e);

		}
	}
}