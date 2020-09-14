package member.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conn.DBConnect;
import user.model.Business;
import user.model.Indivisual;
import user.model.User;
import user.model.enums.Genders;

public class DaoImpl implements Dao{
	private DBConnect db;
	
	public DaoImpl() {
		db= DBConnect.getInstance();
	}
	
	@Override
	public User select(String emailTxt) {
		Connection conn = null;

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

}
