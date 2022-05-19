package com.project.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.project.model.WriterDAO;

public class NewListUIAction implements Action {

	@Override
	public String action(HttpServletRequest request) throws ServletException, IOException {
		
		try {
			request.setAttribute("list", new WriterDAO().getNewBoardList());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "newList.jsp";
	}

}
