package user.dao;

import java.sql.*;

import user.model.*;
import user.model.enums.*;

public interface UserDao {
	// 사용자 정보 추가
	public int insert(User user);
	
	// 사용자 정보 삭제
	public int delete(User user);
	
	// 사용자 정보 수정
	public int update(User user, String userType);
	
	// 사용자 패스워드 수정
	public int updateUserPwd(String email, String pwd);
	
	// 사용자 닉네임 / 주소 / 전화번호 / 성별 / 생일 수정
	public int updateUserInfo(String email, String nickname, String address, String phone, Genders gender, Date date);
	
	// 사업자 유형 사용자의 정보 수정
	public int updateBuyerInfo(String email, String companyName, String companyAddr, String companyPhone, String rank);
	
	// 사용자 정보 선택
	public User select(String email);
	
	// 사업자 유형의 사용자의 사업지 정보 선택
	public User selectBuyerInfo(String email);
	
	// 사용자 패스워드 선택
	public String selectPwd(String email);
	
	// 사용자 Email 선택
	public String selectEmail(String email);
	
	// 사용자 Email 선택
	public String selectEmail(String userName, String phone);
	
	// 사용자 가입 일자 선택
	public String selectJoinDate(String email);
	
	// 사용자 유형 선택
	public String selectUserType(String email);

}
