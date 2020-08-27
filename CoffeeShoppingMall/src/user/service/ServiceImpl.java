package user.service;
 
import user.dao.*;
import user.model.*;

public class ServiceImpl implements Service{
	
	private UserDao dao = new UserDaoImpl();
	
	@Override
	public int createUser(User user) {
		return dao.insert(user);
	}
	
	@Override
	public boolean isRegisterd(String email) {
		/*if(dao.selectEmail(email) != null) {
			return true;
		} else {
			return false;
		}*/
		
		return false;
	}

}
