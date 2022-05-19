<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% if(session.getAttribute("userId")!=null && session.getAttribute("emotionName")!=null){
	response.sendRedirect("afterEmotion.jsp");	
}
else if(session.getAttribute("userId")!=null && session.getAttribute("emotionName")==null){
	response.sendRedirect("afterLogin.jsp");	
}

else if(session.getAttribute("userId")==null){
	
	response.sendRedirect("login.jsp");
}
%>