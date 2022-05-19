package com.project.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.google.gson.JsonObject;
import com.project.model.InteractionDAO;

public class CheckFollowAction implements Action {

	@Override
	public String action(HttpServletRequest request) throws ServletException, IOException {
		String url = "addFllowResult.jsp";
		String followeePenName = request.getParameter("followeePenName");
		String followerPenName = request.getParameter("followerPenName");
		
		InteractionDAO iDao = (InteractionDAO) request.getServletContext().getAttribute("iDao");
		JsonObject j=new JsonObject();
		String followeeId = iDao.getFolloweeId(followeePenName);
		String followerId = iDao.getFollowerId(followerPenName);
		
		if (iDao.checkFollow(followeeId, followerId)) {
			j.addProperty("isFollowChecked", "true");
			request.setAttribute("result", j); 
			System.out.println(j);
		}else {
			j.addProperty("isFollowChecked", "false");
			request.setAttribute("result", j); 
			System.out.println(j);
		}
		
		return url;
	}

}
