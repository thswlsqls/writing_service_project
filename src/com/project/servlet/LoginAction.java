package com.project.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.project.model.EmotionDAO;
import com.project.model.UserDAO;

public class LoginAction implements Action {

	@Override
	public String action(HttpServletRequest request) throws ServletException, IOException {
		//����checkEmotion.jsp
		//����login.jsp
		HttpSession session = request.getSession();
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		//�α��� ���� ���� üũ�ߴ��� ����
		String rememberCheck = request.getParameter("rememberCheck");
		session.setAttribute("rememberCheck", rememberCheck);
		System.out.println(rememberCheck);
		String url="login.jsp";
		

		try {
			UserDAO dao = (UserDAO)(request.getServletContext().getAttribute("uDao"));
			String penName;
			penName = dao.login(id,pw);
			
			if(penName != null) {
				
				session.setAttribute("userId", id);
				session.setAttribute("penName", penName);
				
			
				EmotionDAO eDao = new EmotionDAO();
				
				
				try {
				Collection<String> emotions = eDao.getEmotionName();
					request.setAttribute("emotions", emotions);
					url="checkEmotion.jsp";
				} catch (SQLException e) {
					e.printStackTrace();
				}
				//�������� �ߴ��� ���ߴ��� ����
				if (new EmotionDAO().getMyEmotionName(id) == false) {
					url = "controller?cmd=homeUI";
				}
			
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}		

		return url;
	}

}
