package com.project.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

public class AddUserUIAction implements Action {

	@Override
	public String action(HttpServletRequest request) throws ServletException, IOException {
		
		return "addUser.jsp";
	}

}
