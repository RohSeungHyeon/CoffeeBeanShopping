package user.model;

import java.sql.*;

import user.model.enums.*;

public class Indivisual extends User {
	
	public Indivisual() { super(); }

	public Indivisual(String oauth_rserver, String oauth_user_id, String email, String password, String userName,
			String userNickName, String address, String phone, Genders gender, Date birth, String userType) {
		super(oauth_rserver, oauth_user_id, email, password, userName, userNickName, address, phone, gender, birth, userType);

	}	
}
