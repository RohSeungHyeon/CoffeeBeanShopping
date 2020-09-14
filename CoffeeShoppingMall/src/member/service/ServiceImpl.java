package member.service;

import member.dao.Dao;
import member.dao.DaoImpl;
import user.model.User;

public class ServiceImpl implements Service{
	private Dao dao;
	public ServiceImpl() {
		dao = new DaoImpl();
	}
	@Override
	public void join(User u) {
		
	}

	@Override
	public User getMember(String id) {
		return dao.select(id);
	}

}
