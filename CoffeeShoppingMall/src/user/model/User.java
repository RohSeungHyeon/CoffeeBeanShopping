package user.model;

import user.model.enums.*;

public abstract class User {
	
	// 필수 기입 정보
	private String id;
	private String password;
	private String userName;
	private String userNickName;
	private String email;
	private String phone;
	
	// 선택 기입 정보
	private String gender;
	private AgeGroup ageGroup;
	private String address;
	
	
	public User() {} 
	
	public User(String id, String password, String userName, String userNickName, String email, String phone) {
		this.id = id;
		this.password = password;
		this.userName = userName;
		this.userNickName = userNickName;
		this.email = email;
		this.phone = phone;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

}
