package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {
	
	private static final String url = "jdbc:mysql://localhost:3306/examesdb?useTimezone=true&serverTimezone=UTC";
	private static final String username = "root";
	private static final String password = "Gabriel1996";
	private static Connection con = null;
	private static String driverName = "com.mysql.cj.jdbc.Driver";
	
	public static Connection connect() {
		
		try {
			Class.forName(driverName);
			con = DriverManager.getConnection(url, username, password);
			System.out.println("Conexão bem-sucedida!");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Conexão falhou!");
			e.printStackTrace();
		}
		
		return con;
	}
}
