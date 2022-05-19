package com.project.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.project.model.EmotionDAO;

public class InsertEmpathyAction implements Action {

	@Override
	public String action(HttpServletRequest request) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String userId = session.getAttribute("userId").toString();
		String emotionName = request.getParameter("emotionName");
		
		String url = "controller?cmd=homeUI";
		
		try {
			if(new EmotionDAO().addEmpathy(userId, emotionName))
				session.setAttribute("emotionName", emotionName);
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return url;
	}

}
