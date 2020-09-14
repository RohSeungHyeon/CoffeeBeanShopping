package qna.service;


import java.util.List;

import model.Qna;
import qna.dao.Dao;
import qna.dao.DaoImpl;


public class QnaServiceImpl implements QnaService{
	private Dao dao;
	public QnaServiceImpl() {
		dao=new DaoImpl();
	}


	@Override
	public void writeQna(Qna q) {
		// TODO Auto-generated method stub
		dao.insert(q);
	}

	@Override
	public Qna getQna(int num) {
		// TODO Auto-generated method stub
		return dao.select(num);
	}

	@Override
	public List getAll() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}

	@Override
	public void editQna(Qna q) {
		// TODO Auto-generated method stub
		dao.update(q);
	}

	@Override
	public void delQna(int num) {
		// TODO Auto-generated method stub
		dao.delete(num);
	}

}
