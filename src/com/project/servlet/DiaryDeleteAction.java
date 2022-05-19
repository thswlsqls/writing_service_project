package com.project.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.project.model.WriterDAO;

public class DiaryDeleteAction implements Action {

	@Override
	public String action(HttpServletRequest request) throws ServletException, IOException {
		
		
		WriterDAO wDAO = new WriterDAO();
		HttpSession session = request.getSession();
		
		String writerId = (String)session.getAttribute("userId");
		String writeNo = request.getParameter("writeNo");
		
		
		try {
			wDAO.diaryRemove(writerId, writeNo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return "controller?cmd=myPageUI";
	}

}
