package comment.dao;

import java.util.ArrayList;

import model.Comment;

public interface Dao {
	public ArrayList<Comment> getcomlist(int comQnaid);
	public Comment getComment(int comId, int comQnaId);
	void insert(Comment com);
	void update(Comment com);
	void delete(Comment com);
}
