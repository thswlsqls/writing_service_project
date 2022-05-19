package com.project.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.project.model.BoardVO;
import com.project.model.EmotionDAO;

public class TrendAction implements Action {

	@Override
	public String action(HttpServletRequest request) throws ServletException, IOException {
		String emotionName = request.getParameter("emotionName");
		String url ="trend.jsp";
		Collection<BoardVO> list = null;
		System.out.println(emotionName);
		try {
			list = new EmotionDAO().getTrendWrite(emotionName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(list.size() != 0) {
			url="trendList.jsp";
			request.setAttribute("list", list);
		}
		return url;
	}

}
