package com.project.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.google.gson.JsonObject;
import com.project.model.WriterDAO;
import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

public class SetShareStatusAction implements Action {

	@Override
	public String action(HttpServletRequest request) throws ServletException, IOException {

		
		
		HttpSession session = request.getSession();
		WriterDAO wDAO = new WriterDAO();
		
		
		String shareStatus = request.getParameter("shareStatus");
		String writeNo = request.getParameter("writeNo");
		String userId = (String)session.getAttribute("userId");
		JsonObject j=new JsonObject();
		try {
			if(wDAO.setShareStatus(shareStatus, writeNo, userId)) {
				j.addProperty("isStatusLocked", "true");
				request.setAttribute("result", j);
			}	
			else {
				j.addProperty("isStatusLocked", "false");
				request.setAttribute("result", j);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "shareStatusResult.jsp";
	}

}
