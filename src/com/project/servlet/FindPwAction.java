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

public class FindPwAction implements Action {

   @Override
   public String action(HttpServletRequest request) throws ServletException, IOException {
      
      String url = "findUser.jsp";
      
      HttpSession httpSession = request.getSession();
      
      String searchEmail = (String) httpSession.getAttribute("searchEmail");
      UserDAO uDao = new UserDAO();
      String userId = request.getParameter("userId");
      System.out.println(userId);
      
      System.out.println(searchEmail);
//      String name = request.getParameter("name");
//      String email = request.getParameter("email");
//
//      String findPw = "";
//      
//      UserDAO uDao = (UserDAO) request.getServletContext().getAttribute("uDao");
//      
//      try {
//         findPw = uDao.findPw(name, email); 
//         request.setAttribute("findPw", findPw); 
//          url = "login.jsp";
//      } catch (SQLException e) {
//         e.printStackTrace();
//      }
      
      //보낼메일주소/비밀번호
//      final String user = "bmh2787@naver.com";
      final String user = "thswlsqls@naver.com";
//      final String password = "82465asdf!";
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
      
      String certNum = request.getParameter("certNum");
      
      if(certNum.equals("220513")) {
         MimeMessage message = new MimeMessage(session);
         try {
            message.setFrom(new InternetAddress(user));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(searchEmail)); 
            // 메일 제목 
            message.setSubject("[How Are You] 임시 비밀번호입니다."); // 메일 제목 
            message.setText("y3QvBPzJfP8I"); // 메일내용 
            Transport.send(message); 

            uDao.setTemporaryPw(userId,"y3QvBPzJfP8I");
            
            System.out.println("Success Message Send");
            url = "login.jsp";
         } catch (AddressException e) {
            e.printStackTrace();
         } catch (MessagingException e) {
            e.printStackTrace();
         } catch (SQLException e) {
            e.printStackTrace();
         }
      }
      return url;
   }
}