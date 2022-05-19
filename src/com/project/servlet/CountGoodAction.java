package com.project.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.google.gson.JsonObject;
import com.project.model.InteractionDAO;

public class CountGoodAction implements Action {

	@Override
	public String action(HttpServletRequest request) throws ServletException, IOException {
		String url = "countReactionResult.jsp";
		
		String writeNo = request.getParameter("writeNo");
		
		InteractionDAO iDao = (InteractionDAO) request.getServletContext().getAttribute("iDao");
		
		int cnt = 0;
		
		JsonObject j=new JsonObject();
		try {
			cnt = iDao.countReactions(writeNo); 
			url = "countReactionResult.jsp";
			j.addProperty("reactionCnt", cnt);
			request.setAttribute("result", j); 	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return url;
	}

}
