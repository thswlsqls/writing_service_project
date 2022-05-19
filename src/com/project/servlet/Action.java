package com.project.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
//JavaBean - 순수 자바 문법으로 사용자 필요에 의해서 개발
public interface Action {
	//서블릿 (공통 코드를 처리)--> Action(업무별 내용) 리턴 (결과 이동할 페이지 주소(String)) 
	String action(HttpServletRequest request) throws ServletException, IOException ;
}
