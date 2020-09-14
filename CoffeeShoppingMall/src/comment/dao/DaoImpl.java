package comment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conn.DBConnect;
import model.Comment;

public class DaoImpl implements Dao{
	private Connection conn;
	private PreparedStatement pstmt = null;
	
	public DaoImpl() {
		// TODO Auto-generated constructor stub
		DBConnect dbconn = DBConnect.getInstance();
		conn=dbconn.getConnection();
	}
	@Override
	public ArrayList<Comment> getcomlist(int comQnaid) {
		// TODO Auto-generated method stub
		ResultSet rs = null;
		ArrayList<Comment> com = new ArrayList<Comment>();
		String sql = "select * from comments where comqnaid=? order by comID";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,comQnaid);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				com.add(new Comment(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDate(4),rs.getInt(5)));
			}
			pstmt.close();
			rs.close();
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return com;
	}

	@Override
	public void insert(Comment com) {
		// TODO Auto-generated method stub
		String sql = "insert into comments(COMID, COMWRITER, COMCONTENT, COMDATE, COMQNAID) "+"values(seq_com.nextval,?,?,sysdate,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, com.getComWriter());
			pstmt.setString(2, com.getComContent());
			pstmt.setInt(3, com.getComQnaid());
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public void update(Comment com) {
		// TODO Auto-generated method stub
		String sql = "update comments set comdate=sysdate, comContent=? where comid=? and comqnaid=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, com.getComContent());
			pstmt.setInt(2, com.getComID());
			pstmt.setInt(3, com.getComQnaid());
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Comment com) {
		// TODO Auto-generated method stub
		String sql = "delete from comments where comid=? and comqnaid=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,com.getComID());
			pstmt.setInt(2,com.getComQnaid());
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@Override
	public Comment getComment(int comId, int comQnaId) {
		// TODO Auto-generated method stub
		ResultSet rs = null;
		Comment com = null;
		String sql = "select * from comments where comid=? and comqnaid=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,comId);
			pstmt.setInt(2,comQnaId);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				com = new Comment(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDate(4),rs.getInt(5));
				break;
			}
			pstmt.close();
			rs.close();
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return com;
	}

}
