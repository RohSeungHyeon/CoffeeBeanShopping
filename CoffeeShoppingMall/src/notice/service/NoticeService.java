package notice.service;

import java.util.List;

import model.Notice;

public interface NoticeService {
	void writeNotice(Notice n);
	Notice getNotice(int num);
	List getAll();
	void editNotice(Notice n);
	void delNotice(int num);
}
