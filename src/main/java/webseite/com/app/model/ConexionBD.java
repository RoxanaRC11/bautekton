package webseite.com.app.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
	public String username = "root";
	public String password="";
	public String driver="com.mysql.jdbc.Driver";
	public String database="empresarevilla";
	public String hostname="localhost";
	public String port="3306";
	public String url="jdbc:mysql://" + hostname + ":" + port + "/" + database+ "?useSSL=false";
	
	public Connection Conectar() { 
		Connection conn = null;
		try { 
			Class.forName(driver);
			conn = DriverManager.getConnection(url, username, password);
		}
		catch(ClassNotFoundException | SQLException e)	{
			e.printStackTrace();
		}
		return conn;
		
	}
}
