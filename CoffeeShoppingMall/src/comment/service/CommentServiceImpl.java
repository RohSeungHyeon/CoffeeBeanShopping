package comment.service;

import java.util.ArrayList;

import comment.dao.Dao;
import comment.dao.DaoImpl;
import model.Comment;

public class CommentServiceImpl implements CommentService{
	private Dao dao;
	public CommentServiceImpl() {
		// TODO Auto-generated constructor stub
		dao=new DaoImpl();
	}
	@Override
	public void addCom(Comment com) {
		// TODO Auto-generated method stub
		dao.insert(com);
	}

	@Override
	public void updateCom(Comment com) {
		// TODO Auto-generated method stub
		dao.update(com);
	}

	@Override
	public void deleteCom(Comment com) {
		// TODO Auto-generated method stub
		dao.delete(com);
	}

	@Override
	public ArrayList<Comment> getComList(int ComQnaid) {
		// TODO Auto-generated method stub
		return dao.getcomlist(ComQnaid);
	}
	@Override
	public Comment getComment(int comId, int comQnaId) {
		// TODO Auto-generated method stub
		return dao.getComment(comId,comQnaId);
	}
	
}
