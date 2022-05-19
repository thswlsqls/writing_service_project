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
		
		//���������ּ�/��й�ȣ
//		final String user = "bmh2787@naver.com";
		final String user = "thswlsqls@naver.com";
//		final String password = "82465asdf!";
		final String password = "NAVaorqnrwhgdk1!";
		Properties prop =new Properties();
		
		//������Ƽ����
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
					// ���� ���� 
					message.setSubject("[How Are You] ���̵� ã�� ����Դϴ�."); // ���� ���� 
					//message.setText("< How Are You ���̵�ã�� ���>"); // ���ϳ��� 
					message.setText("��ȸ�Ͻ� ���̵�� "+findId+" �Դϴ�."); // ���ϳ��� 
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
