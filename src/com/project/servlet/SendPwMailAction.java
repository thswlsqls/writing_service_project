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
import javax.servlet.http.HttpSession;

import com.google.gson.JsonObject;
import com.project.model.UserDAO;

public class SendPwMailAction implements Action {

	@Override
	public String action(HttpServletRequest request) throws ServletException, IOException {

		String userId = request.getParameter("userId");
		String email = request.getParameter("email");
		
		// ������ȣ ������ ���� �����ּҸ� ������, �������̵�� ��й�ȣ ��ȸ�ϱ� ���� ���̵� ������
		HttpSession httpSession = request.getSession();
		httpSession.setAttribute("searchUserId", userId);
		httpSession.setAttribute("searchEmail", email);
		
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
		
		UserDAO uDao = new UserDAO();
		
		JsonObject j = new JsonObject();
		j.addProperty("userId", userId);
		j.addProperty("email", email);
		request.setAttribute("userInfo", j);
		
		try {
			if(uDao.checkIdEmail(userId, email).length()!=0) {
				MimeMessage message = new MimeMessage(session);
				String certificationCode = "220513";
				try {
					message.setFrom(new InternetAddress(user));
					message.addRecipient(Message.RecipientType.TO, new InternetAddress(email)); 
					// ���� ���� 
					message.setSubject("[How Are You] ������ȣ�Դϴ�."); // ���� ���� 
					message.setText("certificationCode�� "+certificationCode+" �Դϴ�."); // ���ϳ��� 
					Transport.send(message); 
					System.out.println("Success Message Send");
				
				} catch (AddressException e) {
					e.printStackTrace();
				} catch (MessagingException e) {
					e.printStackTrace();
				}
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	
		return "findUser.jsp";
	}

}
