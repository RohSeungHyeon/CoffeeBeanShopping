package member.service;

import user.model.User;

public interface Service {
	User getMember(String id);
	void join(User m);
}
