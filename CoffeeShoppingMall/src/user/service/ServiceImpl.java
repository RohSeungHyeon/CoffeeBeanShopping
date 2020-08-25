package user.service;

import user.dao.*;
import user.model.*;

public class ServiceImpl implements Service{
	
	private UserDao dao = new UserDaoImpl();
	
	@Override
	public int createUser(User user) {
		return dao.insert(user);
	}

}
