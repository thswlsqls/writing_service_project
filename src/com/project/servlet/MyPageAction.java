package com.project.servlet;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.project.model.BoardVO;
import com.project.model.WriterDAO;

public class MyPageAction implements Action {

	@Override
	public String action(HttpServletRequest request) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String url = "mypageListResult.jsp";
		String userId = session.getAttribute("userId").toString();
		String date = request.getParameter("date");
		System.out.println(userId+date);
		//Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Collection<BoardVO> list = null;
		list = new WriterDAO().getMyPageSearch(userId, date);
		if (list.size() != 0) {
			url = "mypageListResult.jsp";
			request.setAttribute("list", list);
		}
		
		return url;
	}

}
