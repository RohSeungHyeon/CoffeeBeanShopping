package user.model;

import java.sql.*;

import user.model.enums.*;

public abstract class User {

	// OAuth를 위한 서비스 이용
	// OAuth 인증 없이 자체 서비스 이용 시 두 필드 값 "없음"으로 db에 저장
	private String oauth_rserver;
	private String oauth_user_id;
	
	// 서비스 이용을 위한 필수 기입 정보
	private String email;
	private String password;
	private String userName;
	private String userNickName;
	private String address;
	private String phone;
	private String userType;
	
	// 선택 기입 정보
	// getter와 setter의 사용 유의
	private Genders gender = null;
	private Date birth = null;
	
	public User() {} 
		
	public User(String oauth_rserver, String oauth_user_id, String email, String password, String userName,
			String userNickName, String address, String phone, Genders gender, Date birth, String userType) {
		super();
		this.oauth_rserver = oauth_rserver;
		this.oauth_user_id = oauth_user_id;
		this.email = email;
		this.password = password;
		this.userName = userName;
		this.userNickName = userNickName;
		this.address = address;
		this.phone = phone;
		this.gender = gender;
		this.birth = birth;
		this.userType = userType;
	}



	public String getOauth_rserver() {
		return oauth_rserver;
	}

	public void setOauth_rserver(String oauth_rserver) {
		this.oauth_rserver = oauth_rserver;
	}

	public String getOauth_user_id() {
		return oauth_user_id;
	}

	public void setOauth_user_id(String oauth_user_id) {
		this.oauth_user_id = oauth_user_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserNickName() {
		return userNickName;
	}

	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Genders getGender() {
		return gender;
	}

	public void setGender(Genders gender) {
		this.gender = gender;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getUserType() {
		return userType;
	}
	
	public void setUserType(String userType) {
		this.userType = userType;
	}

	
	

}
