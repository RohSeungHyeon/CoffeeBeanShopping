package user.dao;

import java.util.List;

import user.model.*;

public interface UserDao {
	// 사용자 정보 추가
	public int insert(User user);
	
	// 사용자 정보 삭제
	public int delete(User user);
	
	// 사용자 정보 수정
	public int update(User user);
	
	// 사용자 정보 선택
	public User select(String email);
	
	// 사용자 패스워드 선택
	public String selectPwd(String email);
	
	// 사용자 Email 선택
	public String selectEmail(String emailTxt);
	
	// 사용자 가입 일자 선택
	public String selectJoinDate(String email);
	
	// 사용자 유형 선택
	public String selectUserType(String email);

	// 사용자 목록 불러오기
	public List<User> getAll();

}
