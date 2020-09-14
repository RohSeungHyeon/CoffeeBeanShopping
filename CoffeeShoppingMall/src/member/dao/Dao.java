package member.dao;

import user.model.User;

public interface Dao {
	User select(String id);
}
