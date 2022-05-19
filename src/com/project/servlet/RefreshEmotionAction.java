package com.project.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;
import com.project.model.EmotionDAO;

public class RefreshEmotionAction implements Action {

	@Override
	public String action(HttpServletRequest request) throws ServletException, IOException {
		EmotionDAO eDao = new EmotionDAO();		
		Gson g = new Gson();
		try {
			Collection<String> emotions = eDao.getEmotionName();
			
			request.setAttribute("emotions", g.toJson(emotions));
			System.out.println(g.toJson(emotions));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		return "checkEmotionResult.jsp";
	}

}
