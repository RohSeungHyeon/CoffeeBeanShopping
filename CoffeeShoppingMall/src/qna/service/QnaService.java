package qna.service;


import java.util.List;

import model.Qna;

public interface QnaService {
	void writeQna(Qna q);
	Qna getQna(int num);
	List getAll();
	void editQna(Qna q);
	void delQna(int num);

}
