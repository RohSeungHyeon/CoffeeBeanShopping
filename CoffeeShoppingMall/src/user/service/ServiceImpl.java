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
	public int deleteUser(String email) {
		return -1;
	}
	
	@Override
	public boolean modifyUserInfo(User user) {
		return false;
	}
	
	@Override
	public boolean isRegisterdUser(String email) {
		if(dao.selectEmail(email) != null)
			return true;
		else 
			return false;
	}
	
	@Override
	public String getUserType(String email) {
		if(dao.selectEmail(email) == null) 
			return null;
		else {
			String userType = dao.selectUserType(email);
			
			if(userType != null)
				return userType;
			else 
				return null;
		}
	}
	
	@Override
	public String getUserJoinDate(String email) {
		if(dao.selectEmail(email) == null) 
			return null;
		else {
			String joinDate = dao.selectJoinDate(email);
			
			if(joinDate != null)
				return joinDate;
			else {
				return null;
			}
		}
		
	}
	
	
	

}
