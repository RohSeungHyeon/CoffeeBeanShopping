package user.dao;

import java.sql.*;
import java.sql.Date;
import java.util.*;

import conn.*;
import user.model.*;
import user.model.enums.*;


public class UserDaoImpl implements UserDao {

	private DBConnect db;
	private Connection conn;

	public UserDaoImpl() {
		db = DBConnect.getInstance();
	}
	
	// 사용자 정보 선택
	@Override
	public User select(String email) {

		/*
		 * conn = db.getConnection(); PreparedStatement pstmt_member = null;
		 * PreparedStatement pstmt_buyerInfo = null; PreparedStatement pstmt_oauth =
		 * null;
		 * 
		 * User user = null; Business business = null;
		 * 
		 * String memberId = null; String email = null; String password = null; String
		 * userType = null; String name = null; String nickName = null; String phone =
		 * null; String address = null;
		 * 
		 * String gender = null; Date birth = null;
		 * 
		 * String rank = null; String company_name = null; String company_addr = null;
		 * String company_phone = null;
		 * 
		 * String oauth_rserver = null; String oauth_user_id = null;
		 * 
		 * 
		 * try { String sql_memberInfo =
		 * "SELECT id, email, password, usertype, name, nickname, phone, address, gender, birth FROM member WHERE email=?"
		 * ; String sql_buyerInfo =
		 * "SELECT rank, company_name, company_addr, company_phone FROM buyer_info WHERE id=?"
		 * ; String sql_oauth =
		 * "SELECT oauth_rserver, oauth_user_id FROM member_oauth WHERE id=?";
		 * 
		 * 
		 * // 사용자 정보 pstmt_member = conn.prepareStatement(sql_memberInfo);
		 * pstmt_member.setString(1, emailTxt);
		 * 
		 * ResultSet rs_member = pstmt_member.executeQuery();
		 * 
		 * while(rs_member.next()) { memberId = rs_member.getString("id"); email =
		 * rs_member.getString("email"); password = rs_member.getString("password");
		 * userType = rs_member.getString("usertype"); name =
		 * rs_member.getString("name"); nickName = rs_member.getString("nickname");
		 * phone = rs_member.getString("phone"); address =
		 * rs_member.getString("address"); gender = rs_member.getString("gender"); birth
		 * = rs_member.getDate("birth"); }
		 * 
		 * if(userType == "개인") { user = new Indivisual(); } else { user = new
		 * Business();
		 * 
		 * pstmt_buyerInfo = conn.prepareStatement(sql_buyerInfo);
		 * pstmt_buyerInfo.setString(1, memberId);
		 * 
		 * ResultSet rs_buyer = pstmt_buyerInfo.executeQuery();
		 * 
		 * while(rs_buyer.next()) { rank = rs_buyer.getString("rank"); company_name =
		 * rs_buyer.getString("company_name"); company_addr =
		 * rs_buyer.getString("company_addr"); company_phone =
		 * rs_buyer.getString("company_phone");
		 * 
		 * } }
		 * 
		 * user.setEmail(email); user.setPassword(password); user.setUserName(name);
		 * user.setUserNickName(nickName); user.setPhone(phone);
		 * user.setAddress(address);
		 * 
		 * if(gender != null) user.setGender(gender.equals("M") ? Genders.M :
		 * Genders.F);
		 * 
		 * if(birth != null) user.setBirth(birth);
		 * 
		 * if(user instanceof Business) { business = (Business)user;
		 * 
		 * business.setRank(rank); business.setCompanyName(company_name);
		 * business.setCompanyAddress(company_addr); business.setPhone(company_phone); }
		 * 
		 * 
		 * // OAuth를 이용한 서비스 이용 시 가지고 올 정보 pstmt_oauth =
		 * conn.prepareStatement(sql_oauth); pstmt_oauth.setString(1, memberId);
		 * 
		 * ResultSet rs_oauth = pstmt_oauth.executeQuery();
		 * 
		 * while(rs_oauth.next()) { oauth_rserver = rs_oauth.getString("oauth_rserver");
		 * oauth_user_id = rs_oauth.getString("oauth_user_id"); }
		 * 
		 * if(oauth_rserver.equals("없음") && oauth_user_id.equals("없음")) {
		 * user.setOauth_rserver(oauth_rserver); user.setOauth_user_id(oauth_user_id); }
		 * 
		 * 
		 * } catch (SQLException e) { e.printStackTrace();
		 * 
		 * } catch (Exception e) { e.printStackTrace(); } finally { try {
		 * pstmt_member.close(); pstmt_buyerInfo.close(); pstmt_oauth.close();
		 * 
		 * } catch (SQLException e2) { e2.printStackTrace(); } }
		 * 
		 * return user;
		 */
		
		/* JOIN을 이용한 쿼리 재작성 */
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		User user = null;
		
		try {
			String sql = "select A.id, A.email, A.password, A.usertype, A.name, A.nickname, A.phone, A.address, A.gender, A.birth, A.joindate, A.oauth_rserver, A.oauth_user_id, A.usertype, buyer_info.rank, buyer_info.company_name, buyer_info.company_addr, buyer_info.company_phone " + 
					"from (select member.id, member.email, member.password, member.usertype, member.name, member.nickname, member.phone, member.address, member.gender, member.birth, member.joindate, member_oauth.oauth_rserver, member_oauth.oauth_user_id " + 
					"from member, member_oauth where member.id = member_oauth.member_id) A left outer join buyer_info ON A.id = buyer_info.id where email=? order by A.id desc";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			
			ResultSet resultSet = pstmt.executeQuery();
			
			while(resultSet.next()) {
				if(resultSet.getString("usertype").equals("개인"))
					user = new Indivisual();
				else 
					user = new Business();
				
				user.setEmail(resultSet.getString("email"));
				user.setPassword(resultSet.getString("password"));
				user.setUserName(resultSet.getString("name"));
				user.setUserNickName(resultSet.getString("nickname"));
				user.setAddress(resultSet.getString("address"));
				user.setPhone(resultSet.getString("phone"));
				user.setGender((resultSet.getString("gender") == null) ? Genders.N : 
						(resultSet.getString("gender").equals("M") ? Genders.M : Genders.F));
				user.setBirth(resultSet.getDate("birth"));
				user.setOauth_rserver(resultSet.getString("oauth_rserver"));
				user.setOauth_user_id(resultSet.getString("oauth_user_id"));
				user.setUserType(resultSet.getString("usertype"));
				
				if(user instanceof Business) {
					Business business = (Business)user;
					business.setCompanyName(resultSet.getString("company_name"));
					business.setCompanyAddress(resultSet.getString("company_addr"));
					business.setCompanyPhone(resultSet.getString("company_phone"));
					business.setRank(resultSet.getString("rank"));
				}
				
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return user;
	}
	
	// 사업자 유형의 사용자의 사업지 정보 선택
	@Override
	public User selectBuyerInfo(String email) {
		conn = db.getConnection();
		PreparedStatement pstmt = null;
		User user = null;
		
		try {
			String sql = "SELECT company_name, company_addr, company_phone, rank FROM "
					+ "buyer_info NATURAL JOIN member "
					+ "WHERE email=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			
			ResultSet rSet = pstmt.executeQuery();
			
			while(rSet.next()) {
				String company_name = rSet.getString("company_name");
				String company_addr = rSet.getString("company_addr");
				String company_phone = rSet.getString("company_phone");
				String rank = rSet.getString("rank");
				
				user = new Business(company_name, company_addr, company_phone, rank);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return user;
	}
		
	// 사용자 Email 선택
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
	
	// 사용자 Email 선택
	@Override
	public String selectEmail(String userName, String phone) {
		conn = db.getConnection();
		PreparedStatement pstmt = null;
		
		String email = null;
		
		try {
			String sql = "SELECT email FROM member WHERE name=? AND phone=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userName);
			pstmt.setString(2, phone);
			
			ResultSet resultSet = pstmt.executeQuery();
			
			while(resultSet.next()) {
				email = resultSet.getString("email");
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
	
	// 사용자 패스워드 선택
	@Override
	public String selectPwd(String email) {
		String pwd = null;
		
		PreparedStatement pstmt = null;
		Connection conn = db.getConnection();
		try {
			String sql = "SELECT password FROM MEMBER WHERE EMAIL=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			
			ResultSet rSet = pstmt.executeQuery();
			
			if(rSet.next()) {
				pwd = rSet.getString("password");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		
		return pwd;
	}
	
	// 사용자 유형 선택
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
	
	// 사용자 가입 일자 선택
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

	// 사용자 정보 추가
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
		String userType = user.getUserType();
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

		if (user instanceof Business) {
			businessUser = (Business) user;

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

			if (!(oauth_rserver.equals("없음") && oauth_user_id.equals("없음"))
					|| !(oauth_rserver.equals("불명") && oauth_user_id.equals("불명"))) {
				pstmt3.setString(1, oauth_rserver);
				pstmt3.setString(2, oauth_user_id);

				result_pstmt3 = pstmt3.executeUpdate();
			}

		} catch (SQLException e) {
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

		int userInfoResult = (user instanceof Indivisual) ? result_pstmt1
				: ((result_pstmt1 == 1 && result_pstmt2 == 1) ? 1 : 0);

		return userInfoResult & result_pstmt3;
	}

	// 사용자 정보 삭제
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

	public int update(User user, String userType) {
		
		return 0;
	}

	@Override
	public List<User> getAll() {
		List<User> list = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select A.id, A.email, A.password, A.usertype, A.name, A.nickname, A.phone, A.address, A.gender, A.birth, A.joindate, A.oauth_rserver, A.oauth_user_id, buyer_info.rank, buyer_info.company_name, buyer_info.company_addr, buyer_info.company_phone from (select member.id, member.email, member.password, member.usertype, member.name, member.nickname, member.phone, member.address, member.gender, member.birth, member.joindate, member_oauth.oauth_rserver, member_oauth.oauth_user_id from member, member_oauth where member.id = member_oauth.member_id) A left outer join buyer_info ON A.id = buyer_info.id order by A.id desc";
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			list = new ArrayList<>();
			while (rs.next()) {
				User user = null;
				Business business = null;
				if (rs.getString("usertype").equals("사업자")) {
					user = new Business();
				} else {
					user = new Indivisual();
				}
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setUserName(rs.getString("name"));
				user.setUserNickName(rs.getString("nickname"));
				user.setPhone(rs.getString("phone"));
				user.setAddress(rs.getString("address"));
				user.setOauth_rserver(rs.getString("oauth_rserver"));
				user.setOauth_user_id(rs.getString("oauth_user_id"));

				if (rs.getString("gender") != null)
					user.setGender(rs.getString("gender").equals("M") ? Genders.M : Genders.F);

				if (rs.getDate("birth") != null)
					user.setBirth(rs.getDate("birth"));
				
				if (user instanceof Business) {
					business = (Business) user;

					business.setRank(rs.getString("rank"));
					business.setCompanyName(rs.getString("company_name"));
					business.setCompanyAddress(rs.getString("company_addr"));
					business.setPhone(rs.getString("company_phone"));
				}
				list.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return list;
	}
	
	// 사용자 패스워드 수정
	public int updateUserPwd(String email, String pwd) {
		
		conn = db.getConnection();
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			String sql = "UPDATE member SET password=? WHERE email=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pwd);
			pstmt.setString(2, email);
			
			result = pstmt.executeUpdate();
			
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
		
		return result;
	}

	// 사용자 닉네임 / 주소 / 전화번호 / 성별 / 생일 수정
	public int updateUserInfo(String email, String nickname, String address, String phone, Genders gender, Date date) {
		
		conn = db.getConnection();
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			String sql = "UPDATE member "
					+ "SET nickname=?, address=?, phone=?, gender=?, birth=? "
					+ "WHERE email=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nickname);
			pstmt.setString(2, address);
			pstmt.setString(3, phone);
			pstmt.setString(4, gender.toString());
			pstmt.setDate(5, date);
			pstmt.setString(6, email);
			
			result = pstmt.executeUpdate();
					
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
		return result;
	}
	
	// 사업자 유형 사용자의 정보 수정
	public int updateBuyerInfo(String email, String companyName, String companyAddr, String companyPhone, String rank) {
		conn = db.getConnection();
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			String sql = "update (SELECT email, company_name, company_addr, company_phone, rank " +
					"FROM buyer_info LEFT JOIN member on buyer_info.id = member.id) " +
					"set company_name=?, company_addr=?, company_phone=?, rank=? " +
					"where email=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, companyName);
			pstmt.setString(2, companyAddr);
			pstmt.setString(3, companyPhone);
			pstmt.setString(4, rank);
			pstmt.setString(5, email);
			
			result = pstmt.executeUpdate();
			
			
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
		return result;
	}

	
}
