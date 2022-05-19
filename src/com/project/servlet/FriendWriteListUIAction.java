package com.project.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.project.model.BoardVO;
import com.project.model.WriterDAO;

public class FriendWriteListUIAction implements Action {

   @Override
   public String action(HttpServletRequest request) throws ServletException, IOException {
      String url = "friendWriteList.jsp";
      
      HttpSession session = request.getSession();
      
      String followerId = (String) session.getAttribute("userId");
      
      WriterDAO wDao = (WriterDAO) request.getServletContext().getAttribute("wDao");
      
      Collection<BoardVO> list = new ArrayList();
      
//      JsonObject j=new JsonObject();
//      Gson gson = new Gson();
      
      try {
         list = wDao.getFriendWriteList(followerId);
         System.out.println(list);
         //String json = gson.toJson(list);
         //request.setAttribute("fList", json);
         request.setAttribute("fwList", list);
//         url = "friendListResult.jsp";
         url = "friendWriteList.jsp";
      } catch (SQLException e) {
         e.printStackTrace();
      }
      
      return url;
   }

}