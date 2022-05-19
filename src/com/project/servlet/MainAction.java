package com.project.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class MainAction implements Action {

	@Override
	public String action(HttpServletRequest request) throws ServletException, IOException {
		//∏ﬁ¿Œ
		String url = "login.jsp";
		HttpSession session = request.getSession();
		String rememberCheck = session.getAttribute("rememberCheck").toString();
		
		if (rememberCheck.equals("true")) {
			url = "isUserIdSession.jsp";
		}
		
		return url;
	}

}
