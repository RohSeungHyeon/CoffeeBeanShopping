package conn;

import java.sql.*;

public class DBConnect {

	private static DBConnect db = new DBConnect();
	private Connection conn = null;
	
	private String jdbc_driver = "oracle.jdbc.driver.OracleDriver";
	private String jdbc_url = "jdbc:oracle:thin:@localhost:1521:xe";

	private DBConnect() {
		// TODO Auto-generated constructor stub

	}

	public static DBConnect getInstance() {
		return db;
	}

	public Connection getConnection() {
		
		try {
			Class.forName(jdbc_driver);

			conn = DriverManager.getConnection(jdbc_url, "c##webproject", "wjdxor04");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}

}
