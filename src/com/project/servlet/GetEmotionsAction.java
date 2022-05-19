package com.project.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.project.model.EmotionDAO;

public class GetEmotionsAction implements Action {

	@Override
	public String action(HttpServletRequest request) throws ServletException, IOException {

		EmotionDAO eDao = new EmotionDAO();
		Collection<String> emotions;
		try {
			emotions = eDao.getEmotionName();
			request.setAttribute("emotions", emotions);			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String url="checkEmotion.jsp";
		
		return url;
	}

}
