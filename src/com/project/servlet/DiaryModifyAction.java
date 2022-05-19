package com.project.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.project.model.WriterDAO;

public class DiaryModifyAction implements Action {

	@Override
	public String action(HttpServletRequest request) throws ServletException, IOException {
		String url = "diaryModify.jsp";
		
		WriterDAO wDAO = new WriterDAO();
		HttpSession session = request.getSession();
		
		String writerId = (String)session.getAttribute("userId");
		String writeNo = request.getParameter("writeNo");
		String contents = request.getParameter("contents");
		System.out.println(writeNo);
		
		try {
			if(wDAO.diaryModify(writerId, writeNo, contents))
				url = "controller?cmd=myPageUI";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		return url;
	}

}
