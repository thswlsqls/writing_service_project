package com.project.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.project.model.BoardVO;
import com.project.model.FollowListVO;
import com.project.model.InteractionDAO;

public class sortedfriendListUIAction implements Action {

	@Override
	public String action(HttpServletRequest request) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String url = "sortedFollowListResult.jsp";
		String followerId = session.getAttribute("userId").toString();
		String selectOpt = request.getParameter("selectOpt");
		
		Collection<FollowListVO> list = null;
		Gson gson = new GsonBuilder().setDateFormat("yyyy.MM.dd").create();
		
		try {
			if(selectOpt.equals("penName")) {
				list = new InteractionDAO().getSortedByPenNameFollowList(followerId);
			}else {
				list = new InteractionDAO().getSortedByDateFollowList(followerId);
			}
			request.setAttribute("sortedFList", gson.toJson(list));
			System.out.println(list);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return url;
	}
}
