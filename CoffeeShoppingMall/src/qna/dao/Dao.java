package qna.dao;

import java.util.List;


import model.Qna;

public interface Dao {
	void insert(Qna q);
	Qna select(int num);
	List selectAll();
	void update(Qna q);
	void delete(int num);
}
