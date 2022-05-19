package com.project.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.project.model.FollowListVO;
import com.project.model.InteractionDAO;

public class FriendListUIAction implements Action {

   @Override
   public String action(HttpServletRequest request) throws ServletException, IOException {
      String url = "friendList.jsp";
      
      HttpSession session = request.getSession();
      
      
      String followerId = (String) session.getAttribute("userId");
      
      InteractionDAO iDao = (InteractionDAO) request.getServletContext().getAttribute("iDao");
      
      Collection<FollowListVO> list = new ArrayList();
      
//      JsonObject j=new JsonObject();
//      Gson gson = new Gson();
      
      try {
         list = iDao.getFollowList(followerId);
         System.out.println(list);
         //String json = gson.toJson(list);
         //request.setAttribute("fList", json);
         request.setAttribute("fList", list);
//         url = "friendListResult.jsp";
         url = "friendList.jsp";
      } catch (SQLException e) {
         e.printStackTrace();
      }
      
      return url;
   }

}