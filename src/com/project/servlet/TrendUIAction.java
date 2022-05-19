package com.project.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.project.model.EmotionDAO;

public class TrendUIAction implements Action {

	@Override
	public String action(HttpServletRequest request) throws ServletException, IOException {
		
		try {
			request.setAttribute("trendlist", new EmotionDAO().getTrendEmotion());
			System.out.println( new EmotionDAO().getTrendEmotion());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "trend.jsp";
	}

}
