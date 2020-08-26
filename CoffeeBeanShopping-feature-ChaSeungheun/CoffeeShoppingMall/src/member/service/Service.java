package member.service;

import model.User;

public interface Service {
	User getMember(String id);
	void join(User m);
}
