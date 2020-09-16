package user.controller;

import java.io.*;
import java.util.*;

import javax.mail.*;
import javax.mail.internet.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import org.json.simple.*;

import mail.*;

@WebServlet("/sendmail.do")
public class SendEmailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("MainController");
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		String from = (String)request.getAttribute("from");
		String to = (String)request.getAttribute("to");
		String userName = (String)request.getAttribute("userName");
		String pwd_temp = (String)request.getAttribute("pwd_temp");
		
		JSONObject result = new JSONObject();
		
		Properties p = new Properties();
		
		p.put("mail.smtp.user", to);
		p.put("mail.smtp.host","smtp.naver.com");
		p.put("mail.smtp.port", "465");
		p.put("mail.smtp.starttls.enable", "true");
		p.put("mail.smtp.auth", "true");
		p.put("mail.smtp.debug", "true");
		p.put("mail.smtp.socketFactory.port", "465");
		p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");


		try{
		    Authenticator auth = new SMTPAuthenticatior();
		    Session ses = Session.getInstance(p, auth);
		     
		    ses.setDebug(true);
		     
		    MimeMessage msg = new MimeMessage(ses); // 메일의 내용을 담을 객체
		    String subject =
		    		"CoffeeShoppingMall에서 요청하신 패스워드 초기화 정보입니다";
		    msg.setSubject(subject); // 제목
		     
		    Address fromAddr = new InternetAddress(from);
		    msg.setFrom(fromAddr); // 보내는 사람
		     
		    Address toAddr = new InternetAddress(to);
		    msg.addRecipient(Message.RecipientType.TO, toAddr); // 받는 사람
		     
		    msg.setContent(pwd_temp, "text/html;charset=UTF-8"); // 내용과 인코딩
		     
		    Transport.send(msg); // 전송
		} catch(Exception e){
		    e.printStackTrace();
		  
		    result.put("result", false);
		    result.put("message", "처리 중 예외 발생");
		    out.print(result.toString());
		    
		    out.close();
		    return;
		}
		 
		result.put("result", true);
	    result.put("message", "지정하신  메일로 임시 비밀번호를 보내드렸습니다");
	    out.print(result.toString());
	    
	    out.close();
	    
	}

}
