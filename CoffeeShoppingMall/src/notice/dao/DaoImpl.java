package notice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conn.DBConnect;
import model.Notice;

public class DaoImpl implements Dao {

	private DBConnect db;
	
	public DaoImpl() {
		db=DBConnect.getInstance();
	}
	@Override
	public void insert(Notice n) {
		// TODO Auto-generated method stub
		Connection conn = null;
		
		String sql = "insert into notice values(seq_not.nextval,?,?,sysdate,?)";
		
		PreparedStatement pstmt = null;
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, n.getNotTitle());
			pstmt.setString(2, n.getNotWriter());
			pstmt.setString(3, n.getNotContent());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}

	@Override
	public Notice select(int num) {
		// TODO Auto-generated method stub
		Connection conn = null;
		ResultSet rs = null;
		Notice n = null;
		
		String sql="select * from notice where notID=?";
		PreparedStatement pstmt = null;
		try {
			conn=db.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, num);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return new Notice(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDate(4),rs.getString(5));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return null;
	}
	
	@Override
	public List selectAll() {
		// TODO Auto-generated method stub
		Connection conn = null;
		ResultSet rs = null;
		ArrayList<Notice> list = new ArrayList<Notice>();
		
		String sql = "select * from notice order by notID";
		PreparedStatement pstmt = null;
		try {
			conn = db.getConnection();
			
			pstmt=conn.prepareStatement(sql);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(new Notice(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDate(4),rs.getString(5)));
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if(rs !=null) {
					rs.close();
				}
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return list;
	}



	@Override
	public void update(Notice n) {
		// TODO Auto-generated method stub
		Connection conn = null;
		
		String sql = "update notice set notDate = sysdate,notTitle=?,notContent=? where notID=?";
		PreparedStatement pstmt = null;
		
		try {
			conn = db.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, n.getNotTitle());
			pstmt.setString(2, n.getNotContent());
			pstmt.setInt(3, n.getNotID());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}

	@Override
	public void delete(int num) {
		// TODO Auto-generated method stub
		Connection conn = null;
		
		String sql = "delete notice where notID=?";
		
		PreparedStatement pstmt = null;
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}

}
