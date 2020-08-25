package member.service;

import model.Member;

public interface Service {
	Member getMember(String id);
	void join(Member m);
}
