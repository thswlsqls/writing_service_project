package com.project.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.google.gson.JsonObject;
import com.project.model.InteractionDAO;

public class CheckStatusAction implements Action {

	@Override
	public String action(HttpServletRequest request) throws ServletException, IOException {
		String url = "isReactedResult.jsp";
		String userId = request.getParameter("userId");
		String writeNo = request.getParameter("writeNo");
		System.out.println(userId+writeNo);
		
		InteractionDAO iDao = (InteractionDAO) request.getServletContext().getAttribute("iDao");
		JsonObject j=new JsonObject();
		
		if (iDao.checkStatus(userId,writeNo)) {//전체 공개 일 경우 True
			url = "isReactedResult.jsp";
			j.addProperty("isStatusLocked", "true");
			request.setAttribute("result", j);
		}else {
			j.addProperty("isStatusLocked", "false");
			request.setAttribute("result", j);
		}
		
		return url;
	}

}
