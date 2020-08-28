package notice.service;

import java.util.List;

import model.Notice;
import notice.dao.Dao;
import notice.dao.DaoImpl;

public class NoticeServiceImpl implements NoticeService{
	private Dao dao;
	public NoticeServiceImpl() {
		// TODO Auto-generated constructor stub
		dao=new DaoImpl();
	}
	@Override
	public void writeNotice(Notice n) {
		// TODO Auto-generated method stub
		dao.insert(n);
	}

	@Override
	public Notice getNotice(int num) {
		// TODO Auto-generated method stub
		return dao.select(num);
	}

	@Override
	public List<Notice> getAll() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}

	@Override
	public void editNotice(Notice n) {
		// TODO Auto-generated method stub
		dao.update(n);
	}

	@Override
	public void delNotice(int num) {
		// TODO Auto-generated method stub
		dao.delete(num);
	}

}
