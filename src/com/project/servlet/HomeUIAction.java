package com.project.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.project.model.BoardVO;
import com.project.model.EmotionDAO;
import com.project.model.WriterDAO;

public class HomeUIAction implements Action {

	@Override
	public String action(HttpServletRequest request) throws ServletException, IOException {

		System.out.println("µµÂø");
		HttpSession session = request.getSession();
		
		WriterDAO wDao = new WriterDAO();
		
		String userId = session.getAttribute("userId").toString();
		String emotionName = (String)session.getAttribute("emotionName");
		String emotionCode;
		if (emotionName == null) {
			try {
				emotionName = new EmotionDAO().getEmotionNameByEympathy(userId);
				session.setAttribute("emotionName",emotionName);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		Collection<BoardVO> list; 
		
		String url = "home.jsp";
		try {
			emotionCode = wDao.getEmotionCode(emotionName);
			session.setAttribute("emotionCode", emotionCode);
			list = wDao.getHomeBoardList(emotionCode, userId);
			request.setAttribute("list", list);
			url = "home.jsp";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
				
		return url;
	}

}
