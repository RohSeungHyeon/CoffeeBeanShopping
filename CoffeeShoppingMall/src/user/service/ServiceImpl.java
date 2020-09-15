package user.service;
 
import java.util.List;

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
	
	// 사용자 정보 수정
	@Override
	public boolean modifyUserInfo(User user) {
		return false;
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
		
		result = dao.selectEmail(email);
		
		return result;
	}
	
	// 사용자 패스워드 조회
	@Override
	public String getUserPwd(String email) {
		String pwd = null;
		
		pwd = dao.selectPwd(email);
		
		return pwd;
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

	@Override
	public List<User> getAllUser() {
		return dao.getAll();
	}
	
}
