package com.project.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

public class FindUserUIAction implements Action {

	@Override
	public String action(HttpServletRequest request) throws ServletException, IOException {
		
		
		return "findUser.jsp";
	}

}
