package user.service;
 
import java.util.*;

import user.dao.*;
import user.model.*;


public class ServiceImpl implements Service{
	
	private UserDao dao = new UserDaoImpl();

	// 사용자 생성
	@Override
	public int createUser(User user) {
		return dao.insert(user);
	}
	
	// 사용자 삭제
	@Override
	public int deleteUser(String email) {
		return -1;
	}
	
	//사용자 정보 획득
	@Override
	public User getUserInfo(String email) {
		return dao.select(email);
	}
	
	// 사업자 유형의 사용자 추가 정보 획득
	@Override
	public Business getBuyerInfo(String email) {
		return (Business)dao.selectBuyerInfo(email);
	}
	
	// 사용자 정보 수정
	@Override
	public boolean modifyUserInfo(User user, String userType) {
		UserDao dao = new UserDaoImpl();
		
		int result1 = 0;
		int result2 = 0;
		int result3 = 0;
		
		if(!user.getPassword().equals(""))
			result1 = dao.updateUserPwd(user.getEmail(), user.getPassword());
		else 
			result1 = 1;
		
		
		result2 = dao.updateUserInfo(user.getEmail(), user.getUserNickName(), user.getAddress(),
				user.getPhone(), user.getGender(), user.getBirth());
		
		if(userType.equals("사업자")) {
			Business buyer = (Business)user;
			
			result3 = dao.updateBuyerInfo(buyer.getEmail(), buyer.getCompanyName(), 
					buyer.getCompanyAddress(), buyer.getCompanyPhone(), buyer.getRank());
		} else
			result3 = 1;
			
		if(result1 + result2 + result3 == 3)
			return true;
		else {
			return false;
		}
	}
	
	// 사용자 등록 여부 조회
	@Override
	public boolean isRegisterdUser(String email) {
		if(dao.selectEmail(email) != null)
			return true;
		else 
			return false;
	}
	
	// 사용자 이메일 조회
	@Override
	public String getUserEmail(String email) {
		String result = null;
		
		dao.selectEmail(email);
		
		return result;
	}
	
	//사용자 이메일 조회
	@Override
	public String findUserAccount(String userName, String phone) {
		String email = null;
		
		email = dao.selectEmail(userName, phone);
		
		return email;
	}

	@Override
	public List<User> getAllUser() {
		return dao.getAll();
	}
	
	// 사용자 패스워드 조회
	@Override
	public String getUserPwd(String email) {
		String pwd = null;
		
		pwd = dao.selectPwd(email);
		
		return pwd;
	}
	
	@Override
	// 사용자 패스워드 변경
	public boolean setUserPwd(String email, String password) {
		if(dao.updateUserPwd(email, password) == 1 )
			return true;
		else 
			return false;
	}
	
	
	// 사용자 유형 확인
	@Override
	public String getUserType(String email) {
		if(dao.selectEmail(email) == null) 
			return null;
		else {
			String userType = dao.selectUserType(email);
			
			if(userType != null)
				return userType;
			else 
				return null;
		}
	}
	
	// 사용자 가입 일자 조회
	@Override
	public String getUserJoinDate(String email) {
		if(dao.selectEmail(email) == null) 
			return null;
		else {
			String joinDate = dao.selectJoinDate(email);
			
			if(joinDate != null)
				return joinDate;
			else {
				return null;
			}
		}
		
	}
	
	// 사용자의 OAuth id 확인
	@Override
	public String getUserOauthId(String email) {
		String result = null;
		
		User user = getUserInfo(email);
		if(user != null) result = user.getOauth_user_id();
		
		return result;
	}
}
