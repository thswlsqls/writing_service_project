package com.project.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LogoutAction implements Action {

	@Override
	public String action(HttpServletRequest request) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		if(session.getAttribute("loginOK")!=null)
			session.invalidate();
		return "login.jsp";
	}

}
