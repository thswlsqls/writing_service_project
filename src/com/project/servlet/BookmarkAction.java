package com.project.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.google.gson.JsonObject;
import com.project.model.InteractionDAO;

public class BookmarkAction implements Action {

	@Override
	public String action(HttpServletRequest request) throws ServletException, IOException {
		String url = "home.jsp";
		String userId = request.getParameter("userId");
		String writeNo = request.getParameter("writeNo");
		
		JsonObject j=new JsonObject();
		try {
			if (new InteractionDAO().addBookmark(userId, writeNo)) {
				url = "isBookmarkedResult.jsp";
				
				j.addProperty("isAddSuccess", "true");
				request.setAttribute("result", j); 
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return url;
	}

}
