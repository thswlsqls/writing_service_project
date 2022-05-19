package com.project.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.project.model.UserDAO;

public class AddUserAction implements Action {

	@Override
	public String action(HttpServletRequest request) throws ServletException, IOException {
		
		String url="addUser.jsp";
		
		String id= request.getParameter("id");
		String name = request.getParameter("name"); 
		String pw = request.getParameter("pw");
		String nickName = request.getParameter("nickName");
		String emailId = request.getParameter("emailId");
		String domain = request.getParameter("domain");
		String tel = request.getParameter("tel");
		
		emailId = emailId+domain;
			try {
				if(new UserDAO().addUser(id,name,nickName,pw,emailId, tel))
					url="login.jsp";
			} catch (SQLException e) {
				e.printStackTrace();
			}

	
		return url;
	}

}
