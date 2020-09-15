package user.service;

import user.model.*;

public interface Service {
	// 사용자 생성
	public int createUser(User user);
	
	// 사용자 삭제
	public int deleteUser(String email);
	
	// 사용자 정보 획득
	public User getUserInfo(String email);
	
	// 사업자 유형의 사용자 추가 정보 획득
	public Business getBuyerInfo(String email);
	
	// 사용자 정보 수정
	public boolean modifyUserInfo(User user);
	
	// 사용자 등록 여부 조회
	public boolean isRegisterdUser(String email);
	
	// 사용자 이메일 조회
	public String getUserEmail(String email);
	
	// 사용자 패스워드 조회
	public String getUserPwd(String email);
	
	// 사용자 유형 확인
	public String getUserType(String email);
	
	// 사용자 가입 일자 확인
	public String getUserJoinDate(String email);
}
