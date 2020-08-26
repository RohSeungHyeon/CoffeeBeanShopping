package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import conn.DBConnect;
import model.Indivisual;
import model.User;

public class DaoImpl implements Dao{
	private DBConnect db;
	
	public DaoImpl() {
		db= DBConnect.getInstance();
	}
	
	@Override
	public User select(String id) {
		Connection conn = null;
		ResultSet rs = null;
		String sql = "select * from member where id = ?";
		PreparedStatement pstmt = null;
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return new Indivisual(rs.getString(1),rs.getString(2),
						rs.getString(4),rs.getString(5),
						rs.getString(8),rs.getString(6),
						rs.getString(7)
						);
			}
		}catch(Exception e) {
			
		}finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch(Exception e) {
				
			}
		}
		
		return null;
	}

}
