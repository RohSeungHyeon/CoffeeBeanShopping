package user.service;

import user.model.*;

public interface Service {
	public int createUser(User user);
	
	public int deleteUser(String email);
	
	public boolean modifyUserInfo(User user);
	
	public boolean isRegisterdUser(String email);
	
	public String getUserType(String email);
	
	public String getUserJoinDate(String email);
}
