package com.project.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.google.gson.JsonObject;
import com.project.model.InteractionDAO;
import com.project.model.UserDAO;

public class FindIdAction implements Action {

	@Override
	public String action(HttpServletRequest request) throws ServletException, IOException {
	
		String url = "findUser.jsp";
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		//보낼메일주소/비밀번호
//		final String user = "bmh2787@naver.com";
		final String user = "thswlsqls@naver.com";
//		final String password = "82465asdf!";
		final String password = "NAVaorqnrwhgdk1!";
		Properties prop =new Properties();
		
		//프로퍼티설정
		prop.put("mail.smtp.host", "smtp.naver.com");
		prop.put("mail.smtp.port", 587);
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.ssl.trust", "smtp.naver.com");
		
		Session session = Session.getDefaultInstance(prop, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        });
		
		String findId = "";
		UserDAO uDao = (UserDAO) request.getServletContext().getAttribute("uDao");
		
		try {
			findId = uDao.findId(name, email); 
			System.out.println(findId);
			if(findId != null) {
				MimeMessage message = new MimeMessage(session);

				//String certificationCode = "abcde";
				try {
					message.setFrom(new InternetAddress(user));
					message.addRecipient(Message.RecipientType.TO, new InternetAddress(email)); 
					// 메일 제목 
					message.setSubject("[How Are You] 아이디 찾기 결과입니다."); // 메일 제목 
					//message.setText("< How Are You 아이디찾기 결과>"); // 메일내용 
					message.setText("조회하신 아이디는 "+findId+" 입니다."); // 메일내용 
					Transport.send(message); 
					System.out.println("Success Message Send");
				
				} catch (AddressException e) {
					e.printStackTrace();
				} catch (MessagingException e) {
					e.printStackTrace();
				}
			}
			request.setAttribute("findId", findId); 
			 url = "login.jsp";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return url;
	}

}
