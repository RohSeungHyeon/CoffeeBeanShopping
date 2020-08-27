package user.dao;

import java.sql.*;

import conn.*;
import user.model.*;

public class UserDaoImpl implements UserDao {
	
	private DBConnect db;
	private Connection conn;
	
	public UserDaoImpl() {
		db = DBConnect.getInstance();
	}
	
	@Override
	public int insert(User user) {
		
		int result_pstmt1 = 0;
		int result_pstmt2 = 0;
		int result_error = 0;
		
		conn = db.getConnection();
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		
		Business businessUser = null;
		
		String password = user.getPassword();
		String userType = (user instanceof Indivisual) ? "개인" : "사업자";
		String userName = user.getUserName();
		String userNickName = user.getUserNickName();
		String userEmail = user.getEmail();
		String address = user.getAddress();
		String phone = user.getPhone();
		String gender = user.getGender().toString();
		Date birth = user.getBirth();
		
		String companyName = "";
		String companyAddress = "";
		@SuppressWarnings("unused")
		String companyPhone = "";
		String rank = "";
		
		if(user instanceof Business) {
			businessUser = (Business)user;
			
			companyName = businessUser.getCompanyName();
			companyAddress = businessUser.getCompanyAddress();
			companyPhone = businessUser.getCompanyPhone();
			rank = businessUser.getRank();
			
		}
		
		try {
			String sql_member = 
				"INSERT INTO member(id, password, usertype, name, nickname, email, phone, address, gender, birth) "
					+"VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			String sql_buyer =
					"INSERT INTO buyer_info(id, rank, company_name, company_addr) "
					+ "VALUES(?, ?, ?, ?)";
			
			pstmt1 = conn.prepareStatement(sql_member);
			pstmt2 = conn.prepareStatement(sql_buyer);
			
			pstmt1.setString(1, id);
			pstmt1.setString(2, password);
			pstmt1.setString(3, userType);
			pstmt1.setString(4, userName);
			pstmt1.setString(5, userNickName);
			pstmt1.setString(6, userEmail);
			pstmt1.setString(7, phone);
			pstmt1.setString(8, address);
			pstmt1.setString(9, gender);
			pstmt1.setDate(10, birth);
			
			result_pstmt1 = pstmt1.executeUpdate();
			
			if(user instanceof Business) {
				pstmt2.setString(1, id);
				pstmt2.setString(2, rank);
				pstmt2.setString(3, companyName);
				pstmt2.setString(4, companyAddress);
				result_pstmt2 = pstmt2.executeUpdate();
			}
				
		} catch(SQLException e) {
			e.printStackTrace();
			return result_error;
			
		} catch (Exception e) {
			e.printStackTrace();
			return result_error;
		} finally {
			try {
				pstmt1.close();
				pstmt2.close();
				conn.close();
		
			} catch (SQLException e2) {
				e2.printStackTrace();
				return result_error;
			}
		}
		
		return (user instanceof Indivisual) ? result_pstmt1 : ((result_pstmt1 == 1 && result_pstmt2 == 1) ? 1 : 0) ;
	}
	
	@Override
	public int delete(User user) {
		
//		conn = db.getConnection();
//		PreparedStatement pstmt;
//		
//		try {
//			
//			
//			
//		} catch(SQLException e) {
//			e.printStackTrace();
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				pstmt.close();
//				conn.close();
//		
//			} catch (SQLException e2) {
//				e2.printStackTrace();
//			}
//		}
		return 0;
	}
	
	@Override
	public int update(User user) {
		
//		conn = db.getConnection();
//		PreparedStatement pstmt;
//		
//		try {
//			
//			
//			
//		} catch(SQLException e) {
//			e.printStackTrace();
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				pstmt.close();
//				conn.close();
//		
//			} catch (SQLException e2) {
//				e2.printStackTrace();
//			}
//		}
		
		return 0;
	}
	
	@Override
	public User select(String email) {

		conn = db.getConnection();
		PreparedStatement pstmt = null;
		User user = null;
		
		/*
		 * try { String sql = "SELECT id, "
		 * 
		 * } catch (SQLException e) { e.printStackTrace();
		 * 
		 * } catch (Exception e) { e.printStackTrace(); } finally { try { pstmt.close();
		 * conn.close();
		 * 
		 * } catch (SQLException e2) { e2.printStackTrace(); } }
		 */
		return user;
	}
}
