package member.service;

import member.dao.Dao;
import member.dao.DaoImpl;
import model.Member;

public class ServiceImpl implements Service{
	private Dao dao;
	public ServiceImpl() {
		dao = new DaoImpl();
	}
	@Override
	public void join(Member m) {
		
	}

	@Override
	public Member getMember(String id) {
		return dao.select(id);
	}

}