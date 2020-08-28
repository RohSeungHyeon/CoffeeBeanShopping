package user.dao;

import java.sql.*;

import conn.*;
import user.model.*;
import user.model.enums.*;

public class UserDaoImpl implements UserDao {
	
	private DBConnect db;
	private Connection conn;
	
	public UserDaoImpl() {
		db = DBConnect.getInstance();
	}
	
	@Override
	public User select(String emailTxt) {

		conn = db.getConnection();
		PreparedStatement pstmt_member = null;
		PreparedStatement pstmt_buyerInfo = null;
		PreparedStatement pstmt_oauth = null;
		
		User user = null;
		Business business = null;
		
		String memberId = null;
		String email = null;
		String password = null;
		String userType = null;
		String name = null;
		String nickName = null;
		String phone = null;
		String address = null;
		
		String gender = null;
		Date birth = null;
		
		String rank = null;
		String company_name = null;
		String company_addr = null;
		String company_phone = null;
		
		String oauth_rserver = null;
		String oauth_user_id = null;


		try {
			String sql_memberInfo = "SELECT id, email, password, usertype, name, nickname, phone, address, gender, birth FROM member WHERE email=?";
			String sql_buyerInfo = "SELECT rank, company_name, company_addr, company_phone FROM buyer_info WHERE id=?";
			String sql_oauth = "SELECT oauth_rserver, oauth_user_id FROM member_oauth WHERE id=?";
			
			
			// 사용자 정보
			pstmt_member = conn.prepareStatement(sql_memberInfo);
			pstmt_member.setString(1, emailTxt);
			
			ResultSet rs_member = pstmt_member.executeQuery();
			
			while(rs_member.next()) {
				memberId = rs_member.getString("id");
				email = rs_member.getString("email");
				password = rs_member.getString("password");
				userType = rs_member.getString("usertype");
				name = rs_member.getString("name");
				nickName = rs_member.getString("nickname");
				phone = rs_member.getString("phone");
				address = rs_member.getString("address");
				gender = rs_member.getString("gender");
				birth = rs_member.getDate("birth");
			}
			
			if(userType == "개인") {
				user = new Indivisual();
			} else {
				user = new Business();
				
				pstmt_buyerInfo = conn.prepareStatement(sql_buyerInfo);
				pstmt_buyerInfo.setString(1, memberId);
				
				ResultSet rs_buyer = pstmt_buyerInfo.executeQuery();
				
				while(rs_buyer.next()) {
					rank = rs_buyer.getString("rank");
					company_name = rs_buyer.getString("company_name");
					company_addr = rs_buyer.getString("company_addr");
					company_phone = rs_buyer.getString("company_phone");
	
				}
			} 
			
			user.setEmail(email);
			user.setPassword(password);
			user.setUserName(name);
			user.setUserNickName(nickName);
			user.setPhone(phone);
			user.setAddress(address);
			
			if(gender != null)
				user.setGender(gender.equals("M") ? Genders.M : Genders.F);
			
			if(birth != null)
				user.setBirth(birth);
			
			if(user instanceof Business) {
				business = (Business)user;
				
				business.setRank(rank);
				business.setCompanyName(company_name);
				business.setCompanyAddress(company_addr);
				business.setPhone(company_phone);
			}
			
			
			// OAuth를 이용한 서비스 이용 시 가지고 올 정보
			pstmt_oauth = conn.prepareStatement(sql_oauth);
			pstmt_oauth.setString(1, memberId);
			
			ResultSet rs_oauth = pstmt_oauth.executeQuery();
			
			while(rs_oauth.next()) {
				oauth_rserver = rs_oauth.getString("oauth_rserver");
				oauth_user_id = rs_oauth.getString("oauth_user_id");
			}
			
			if(oauth_rserver.equals("없음") && oauth_user_id.equals("없음")) {
				user.setOauth_rserver(oauth_rserver);
				user.setOauth_user_id(oauth_user_id);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt_member.close();
				pstmt_buyerInfo.close();
				pstmt_oauth.close();

			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}

		return user;
	}
	
	@Override
	public String selectEmail(String emailTxt) {
		conn = db.getConnection();
		PreparedStatement pstmt = null;
		
		String email = null;
		
		try {
			String sql = "SELECT EMAIL FROM MEMBER WHERE EMAIL=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, emailTxt);
			
			ResultSet resultSet = pstmt.executeQuery();
			
			while(resultSet.next()) {
				
				email = resultSet.getString("EMAIL");
				
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
		
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		
		return email;
	}
	
	@Override
	public String selectUserType(String email) {
		conn = db.getConnection();
		PreparedStatement pstmt = null;
		
		String userType = null;
		
		try {
			String sql = "SELECT USERTYPE FROM MEMBER WHERE EMAIL=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			
			ResultSet resultSet = pstmt.executeQuery();
			
			while(resultSet.next()) {
				
				userType = resultSet.getString("USERTYPE");
				
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
		
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		
		return userType;
	}
	
	@Override
	public String selectJoinDate(String email) {
		conn = db.getConnection();
		PreparedStatement pstmt = null;
		
		String joinDate = null;
		
		try {
			String sql = "SELECT JOINDATE FROM MEMBER WHERE EMAIL=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			
			ResultSet resultSet = pstmt.executeQuery();
			
			while(resultSet.next()) {
				joinDate = resultSet.getString("JOINDATE");
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
		
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		
		return joinDate;
	}
	
	@Override
	public int insert(User user) {
		
		int result_pstmt1 = 0;
		int result_pstmt2 = 0;
		int result_pstmt3 = 0;
		int result_error = 0;
		
		conn = db.getConnection();
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		
		Business businessUser = null;
		
		String userEmail = user.getEmail();
		String password = user.getPassword();
		String userType = (user instanceof Indivisual) ? "개인" : "사업자";
		String userName = user.getUserName();
		String userNickName = user.getUserNickName();
		String phone = user.getPhone();
		String address = user.getAddress();
		
		@SuppressWarnings("unused")
		String oauth_rserver = user.getOauth_rserver();
		String oauth_user_id = user.getOauth_user_id();
		
		@SuppressWarnings("unused")
		String companyName = "";
		String companyAddress = "";
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
				"INSERT INTO member(id, email, password, usertype, name, nickname, phone, address, gender, birth, joindate) "
				+ "VALUES(member_id_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate)";
			
			String sql_buyer =
					"INSERT INTO buyer_info(id, rank, company_name, company_addr, company_phone) "
					+ "VALUES(member_id_seq.currval, ?, ?, ?, ?)";
			
			String sql_member_oauth =
					"INSERT INTO member_oauth(id, member_id, oauth_rserver, oauth_user_id) "
					+ "VALUES(member_oauth_id_seq.nextval, member_id_seq.currval, ?, ?)";
			
			pstmt1 = conn.prepareStatement(sql_member);
			pstmt2 = conn.prepareStatement(sql_buyer);
			pstmt3 = conn.prepareStatement(sql_member_oauth);
			
			pstmt1.setString(1, userEmail);
			pstmt1.setString(2, password);
			pstmt1.setString(3, userType);
			pstmt1.setString(4, userName);
			pstmt1.setString(5, userNickName);
			pstmt1.setString(6, phone);
			pstmt1.setString(7, address);
			
			if(user.getGender() != null)
				pstmt1.setString(8, user.getGender().toString());
			else {
				pstmt1.setNull(8, java.sql.Types.VARCHAR);
			}
			if(user.getBirth() != null)
				pstmt1.setDate(9, user.getBirth());
			else {
				pstmt1.setNull(9, java.sql.Types.DATE);
			}
			
			result_pstmt1 = pstmt1.executeUpdate();
			
			if(user instanceof Business) {
				pstmt2.setString(1, rank);
				pstmt2.setString(2, companyName);
				pstmt2.setString(3, companyAddress);
				pstmt2.setString(4, companyPhone);
				
				result_pstmt2 = pstmt2.executeUpdate();
			}
			
			if(!(oauth_rserver.equals("없음") && oauth_user_id.equals("없음"))
					|| !(oauth_rserver.equals("불명") && oauth_user_id.equals("불명"))) {
				pstmt3.setString(1, oauth_rserver);
				pstmt3.setString(2, oauth_user_id);
				
				result_pstmt3 = pstmt3.executeUpdate();
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
				pstmt3.close();
				conn.close();
		
			} catch (SQLException e2) {
				e2.printStackTrace();
				return result_error;
			}
		}
		
		int userInfoResult = (user instanceof Indivisual) ? result_pstmt1 : ((result_pstmt1 == 1 && result_pstmt2 == 1) ? 1 : 0) ;
		
		return userInfoResult & result_pstmt3;
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
	
	
	
}
