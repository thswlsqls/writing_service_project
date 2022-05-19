package com.project.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.project.model.BoardVO;
import com.project.model.BookmarkVO;
import com.project.model.InteractionDAO;

public class BookmarkListUI2Action implements Action {

	@Override
	public String action(HttpServletRequest request) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String url = "searchResult.jsp";
		String userId = session.getAttribute("userId").toString();
		String selectOpt = request.getParameter("selectOpt");
		Collection<BoardVO> list = null;
		System.out.println(selectOpt);
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		
		try {
			list = new InteractionDAO().getBookmarkList(userId , selectOpt);
			request.setAttribute("searchList", gson.toJson(list));
			System.out.println(list);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return url;
	}

}
