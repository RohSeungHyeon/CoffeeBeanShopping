package qna.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conn.DBConnect;
import model.Qna;

public class DaoImpl implements Dao{
	private DBConnect db;
	
	public DaoImpl() {
		// TODO Auto-generated constructor stub
		db=DBConnect.getInstance();
	}
	@Override
	public void insert(Qna q) {
		// TODO Auto-generated method stub
Connection conn = null;
		
		String sql = "insert into qna values(seq_qna.nextval,?,?,sysdate,?)";
		
		PreparedStatement pstmt = null;
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, q.getQnaTitle());
			pstmt.setString(2, q.getQnaWriter());
			pstmt.setString(3, q.getQnaContent());
			
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
	public Qna select(int num) {
		// TODO Auto-generated method stub
		Connection conn = null;
		ResultSet rs = null;
		Qna q = null;
		
		String sql="select * from qna where qnaID=?";
		PreparedStatement pstmt = null;
		try {
			conn=db.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, num);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return new Qna(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDate(4),rs.getString(5));
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
		ArrayList<Qna> list = new ArrayList<Qna>();
		
		String sql = "select * from qna order by qnaID";
		PreparedStatement pstmt = null;
		try {
			conn = db.getConnection();
			
			pstmt=conn.prepareStatement(sql);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(new Qna(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDate(4),rs.getString(5)));
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
	public void update(Qna q) {
		// TODO Auto-generated method stub
		Connection conn = null;
		
		String sql = "update qna set qnaDate = sysdate,qnaTitle=?,qnaContent=? where qnaID=?";
		PreparedStatement pstmt = null;
		
		try {
			conn = db.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, q.getQnaTitle());
			pstmt.setString(2, q.getQnaContent());
			pstmt.setInt(3, q.getQnaID());
			
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
		
		String sql = "delete qna where qnaID=?";
		
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