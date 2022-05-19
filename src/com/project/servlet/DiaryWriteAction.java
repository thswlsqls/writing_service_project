package com.project.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.project.model.EmotionDAO;
import com.project.model.WriterDAO;

public class DiaryWriteAction implements Action {

	@Override
	public String action(HttpServletRequest request) throws ServletException, IOException {

		
		HttpSession session = request.getSession();
		String contents = request.getParameter("contents");
		
		String writerId = (String)session.getAttribute("userId");
		String suggestionName = request.getParameter("suggestionName");
		
		
		
		
		String url = "diaryWrite.jsp";
		WriterDAO wDao = new WriterDAO();
		EmotionDAO eDao = new EmotionDAO();
		
		try {
			String suggestionCode = eDao.getSuggestionCode(suggestionName);
			if(wDao.diaryWrite(contents, writerId, suggestionCode)) 
			session.setAttribute("suggestionCode", suggestionCode);	
			url = "controller?cmd=myPageUI";
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return url;
	}
	

}
