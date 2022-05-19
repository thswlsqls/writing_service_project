package com.project.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.google.gson.JsonObject;
import com.project.model.InteractionDAO;

public class GoodDeleteAction implements Action {

	@Override
	public String action(HttpServletRequest request) throws ServletException, IOException {
		
		String url = "deleteReactionResult.jsp";
		String userId = request.getParameter("userId");
		String writeNo = request.getParameter("writeNo");
		
		InteractionDAO iDao = (InteractionDAO) request.getServletContext().getAttribute("iDao");
		
		JsonObject j=new JsonObject();
		
		try {
			if(iDao.deleteReaction(userId, writeNo)) {
				url = "deleteReactionResult.jsp";
				j.addProperty("isDeleteSuccess", "true");
				request.setAttribute("result", j); 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return url;
	}

}
