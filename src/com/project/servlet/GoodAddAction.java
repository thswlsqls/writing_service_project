package com.project.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.google.gson.JsonObject;
import com.project.model.InteractionDAO;

public class GoodAddAction implements Action {

	@Override
	public String action(HttpServletRequest request) throws ServletException, IOException {
		
		String url = "addReactionResult.jsp";
		String userId = request.getParameter("userId");
		String writeNo = request.getParameter("writeNo");
		
		InteractionDAO iDao = (InteractionDAO) request.getServletContext().getAttribute("iDao");
		JsonObject j=new JsonObject();
		
		try {
			if(iDao.addReaction(userId, writeNo)) {
				url = "addReactionResult.jsp";
				j.addProperty("isAddSuccess", "true");
				request.setAttribute("result", j); 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return url;
	}
}
