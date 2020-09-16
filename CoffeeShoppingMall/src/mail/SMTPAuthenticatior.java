package mail;

import javax.mail.*;

public class SMTPAuthenticatior extends Authenticator {

	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication("jjk3470@naver.com", "D6VDT5Y5THV6");
		
	}
}
