package com.project.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.project.model.EmotionDAO;

public class RefreshSuggestionAction implements Action {

	@Override
	public String action(HttpServletRequest request) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		EmotionDAO eDao = new EmotionDAO();
		String userId = (String)session.getAttribute("userId");
		Gson g = new Gson();
		
		try {
			Collection<String> suggestions = eDao.selectSuggestion(userId);
			request.setAttribute("suggestions", g.toJson(suggestions));
			System.out.println(g.toJson(suggestions));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		return "checkSuggestionResult.jsp";
	}


}
