package com.project.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.project.model.BoardVO;
import com.project.model.InteractionDAO;
import com.project.model.WriterDAO;

public class BoardDetailUIAction implements Action {

	@Override
	public String action(HttpServletRequest request) throws ServletException, IOException {
		String url = "details.jsp";
		
		String writeNo = request.getParameter("writeNo");
		BoardVO v = null;
		
		WriterDAO wDao = (WriterDAO) request.getServletContext().getAttribute("wDao");
		try {
			v = wDao.getWriteDetail(writeNo);
			request.setAttribute("board", v);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return url;
	}

}
