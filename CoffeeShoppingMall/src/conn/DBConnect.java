package conn;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	private static DBConnect db = new DBConnect();
	private Connection conn = null;
	String dri = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String id = "c##coffee";
	String pw = "coffee";
	private DBConnect() {
	}
	public static DBConnect getInstance() {
		return db;
	}
	
	public Connection getConnection() {
		try {
			Class.forName(dri);
			conn = DriverManager.getConnection(url,id,pw);
		}catch(Exception e) {
			
		}
		return conn;
	}
	
}
