<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.nav { 
   background-color: #FFF8EB;
   font-size: 9.5pt;
   font-weight: bolder;
   
 }
.nav-link{
color: black;      
}
</style>
</head>
<body>
   <div class="fixed-bottom">
       <ul class="nav nav-pills nav-justified">
  <li class="nav-item">
    <a class="nav-link" href="controller?cmd=homeUI" >홈</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="controller?cmd=searchUI">검색</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="controller?cmd=myPageUI">마이페이지</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="controller?cmd=diaryWriteUI">글쓰기</a>
  </li>
</ul><br>
<ul class="nav nav-pills nav-justified">
	<li class="nav-item">
    <a class="nav-link" href="controller?cmd=diaryWriteUI">글쓰기</a>
  </li>
</ul>
    </div>
    
</body>
</html>