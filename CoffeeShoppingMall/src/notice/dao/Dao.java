package notice.dao;


import java.util.List;

import model.Notice;

public interface Dao {
	void insert(Notice n);
	Notice select(int num);
	List<Notice> selectAll();
	void update(Notice n);
	void delete(int num);
}
