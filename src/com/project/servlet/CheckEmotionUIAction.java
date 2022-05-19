package com.project.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.project.model.EmotionDAO;

public class CheckEmotionUIAction implements Action {

	@Override
	public String action(HttpServletRequest request) throws ServletException, IOException {
		
		return "checkEmotion.jsp";
		
	}

}
