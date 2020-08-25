package member.dao;

import model.Member;

public interface Dao {
	Member select(String id);
}