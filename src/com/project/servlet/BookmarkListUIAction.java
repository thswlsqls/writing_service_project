package com.project.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.project.model.BoardVO;
import com.project.model.BookmarkVO;
import com.project.model.InteractionDAO;

public class BookmarkListUIAction implements Action {

	@Override
	public String action(HttpServletRequest request) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String url = "bookmarkList.jsp";
		String userId = session.getAttribute("userId").toString();
		Collection<BoardVO> list;
		String selectOpt = "date";
		try {
			list = new InteractionDAO().getBookmarkList(userId,selectOpt);
			if (list.size()!=0) {
				request.setAttribute("list",list);
				System.out.println(list);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return url;
	}

}
