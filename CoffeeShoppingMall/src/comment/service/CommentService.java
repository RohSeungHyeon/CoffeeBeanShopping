package comment.service;

import java.util.ArrayList;

import model.Comment;

public interface CommentService {
	void addCom(Comment com);
	void updateCom(Comment com);
	void deleteCom(Comment com);
	ArrayList<Comment> getComList(int ComQnaid);
	Comment getComment(int comId,int comQnaId);
}
