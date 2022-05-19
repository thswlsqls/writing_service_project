package com.project.servlet;

import java.io.IOException;
import java.sql.SQLException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.project.model.BoardVO;
import com.project.model.InteractionDAO;


public class BookmarkListAction implements Action {

	@Override
	public String action(HttpServletRequest request) throws ServletException, IOException {
		String url = "bookmarkList.jsp";
		HttpSession session = request.getSession();
		String userId = session.getAttribute("userId").toString();
		String writeNo = request.getParameter("writeNo");
		BoardVO list = null;
		
		try {
			list = new InteractionDAO().getBookmarkedWrite(userId,writeNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(list.getWriteNo());
		if (list.getWriteNo().length() != 0) {
			url = "bookmarkResult.jsp";
			request.setAttribute("list", list);
		}
		System.out.println(list);
		return url;
	}

}
