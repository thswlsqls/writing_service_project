package com.project.servlet;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.project.model.BoardVO;
import com.project.model.WriterDAO;

public class MyPageUIAction implements Action {

   @Override
   public String action(HttpServletRequest request) throws ServletException, IOException {

      
      HttpSession session = request.getSession();
      
      
      Collection<BoardVO> list;
      String userId = (String)session.getAttribute("userId");
      WriterDAO wDao = new WriterDAO();
      
      list = wDao.myWriting(userId);
      request.setAttribute("list", list);
      
      
      
      return "mypage.jsp";
   }

}