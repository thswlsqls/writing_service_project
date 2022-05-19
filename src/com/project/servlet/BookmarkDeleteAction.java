package com.project.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.google.gson.JsonObject;
import com.project.model.InteractionDAO;

public class BookmarkDeleteAction implements Action {

	@Override
	public String action(HttpServletRequest request) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String url = "home.jsp";
		String userId = session.getAttribute("userId").toString();
		String writeNo = request.getParameter("writeNo");
		
		JsonObject j=new JsonObject();
		try {
			if (new InteractionDAO().deleteBookmark(userId, writeNo)) {
				url = "isBookmarkedResult.jsp";
				j.addProperty("isDeleteSuccess", "true");
				request.setAttribute("result", j); 
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return url;
	}

}
