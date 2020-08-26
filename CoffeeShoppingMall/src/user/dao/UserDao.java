package user.dao;

import user.model.*;

public interface UserDao {
	public int insert(User user);
	
	public int delete(User user);
	
	public int update(User user);
	
	public User select(String id);

}
