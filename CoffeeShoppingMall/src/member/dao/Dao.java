package member.dao;

import model.User;

public interface Dao {
	User select(String id);
}
