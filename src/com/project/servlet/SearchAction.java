package com.project.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.project.model.BoardVO;
import com.project.model.WriterDAO;

public class SearchAction implements Action {

	@Override
	public String action(HttpServletRequest request) throws ServletException, IOException {
		String searchName = request.getParameter("searchName");
		String writeDate = request.getParameter("date");
		String searchText = request.getParameter("searchText");
		String now = LocalDate.now().toString();
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		
		Collection<BoardVO> list = null;
		if (writeDate.equals("no")) {
			writeDate = now;
		}

		if (searchName.equals("penName")) {
			list = new WriterDAO().searchByPenName(searchText,writeDate);
		}else if(searchName.equals("suggestionName")) {
			list = new WriterDAO().searchBySuggestionName(searchText,writeDate);
		}
		request.setAttribute("searchList", gson.toJson(list));
		System.out.println(list+searchName);
		return "searchResult.jsp";
		
	}
	
}
