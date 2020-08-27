package user.service;

import user.model.*;

public interface Service {
	public int createUser(User user);
	
	public boolean isRegisterd(String email);
	
}
