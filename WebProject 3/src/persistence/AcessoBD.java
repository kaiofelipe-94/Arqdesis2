package persistence;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class AcessoBD 
{ 
	// ----------------------------------------------------------- 
	// Carrega driver JDBC 
	// 
	static 
	{ 
		try 
		{ 
			Class.forName("com.mysql.jdbc.Driver"); 
		} 
		catch (ClassNotFoundException e) 
		{ 
			throw new RuntimeException(e); 
		} 
	} 
	// ----------------------------------------------------------- 
	// Obtém conexão com o banco de dados 
	public Connection obtemConexao() throws SQLException 
	{ 
		return (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/projeto1?user=root&password=2577"); 
	} 
} 
