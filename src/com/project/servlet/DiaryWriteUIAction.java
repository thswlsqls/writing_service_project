package com.project.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.project.model.EmotionDAO;

public class DiaryWriteUIAction implements Action {

	@Override
	public String action(HttpServletRequest request) throws ServletException, IOException {

		HttpSession session = request.getSession();
		
		String writerId = (String)session.getAttribute("userId");
		EmotionDAO eDao = new EmotionDAO();
		
		try {
			Collection<String> suggestions = eDao.selectSuggestion(writerId);
			request.setAttribute("suggestions", suggestions);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "diaryWrite.jsp";
	}

}
