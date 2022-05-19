<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">


<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript" src="js/jquery-3.6.0.js"></script>

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Koulen&family=Nanum+Gothic+Coding:wght@400;700&family=Roboto+Mono:ital@1&display=swap" rel="stylesheet">

<title>Insert title here</title>
<style type="text/css">
   .nav { 
      background-color: #D1C7C5;
      font-size: 9.5pt;
      font-weight: bolder;
      z-index: 1000
    }
   .nav-link{
      color: #4D4948;  
      font-family: 'Roboto Mono', monospace;    
      font-weight: bold;
   }
   .bottom{
      position: fixed;
       right: 0;
       bottom: 0;
       left: 0;
       z-index: 100;
   }
   
   .robotoMonofont{
      display: block;
       padding: 0.5rem 1rem;
      color: #4D4948;  
      font-family: 'Roboto Mono', monospace;   
      text-decoration: none;
      transition: color .15s ease-in-out,background-color .15s ease-in-out,border-color .15s ease-in-out;
   	font-weight: bolder;
   }
</style>
</head>
<body>
   <div class="bottom">
       <!-- <ul class="nav nav-pills nav-justified">
        <li class="nav-item">
          <a class="nav-link" href="controller?cmd=homeUI" >홈</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="controller?cmd=searchUI">검색</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="controller?cmd=myPageUI">MY</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="controller?cmd=diaryWriteUI">글쓰기</a>
        </li>
      </ul> -->
        <ul class="nav nav-tabs nav-justified">
          <li class="nav-item " onclick="checkHome()">
            <a class="robotoMonofont nav-home robotoMonofont" href="controller?cmd=homeUI">HOME</a>
          </li>
          <li class="nav-item nav-search" onclick="checkSearch()">
            <a class="robotoMonofont nav-search robotoMonofont" href="controller?cmd=searchUI">SEARCH</a>
          </li>
          <li class="nav-item nav-my" onclick="checkMy()">
            <a class="robotoMonofont nav-my robotoMonofont" href="controller?cmd=myPageUI">MY</a>
          </li>
          <li class="nav-item nav-write" onclick="checkWrite()">
            <a class="robotoMonofont nav-write robotoMonofont" href="controller?cmd=diaryWriteUI">WRITE</a>
          </li>
        </ul>
    </div>
<script type="text/javascript">
   
   function checkHome(){
      $(".nav-search").removeClass("active");
      $(".nav-my").removeClass("active");
      $(".nav-write").removeClass("active");
      
      $(".nav-home").addClass("active");
   }
   function checkSearch(){
      $(".nav-home").removeClass("active");
      $(".nav-my").removeClass("active");
      $(".nav-write").removeClass("active");
      
      $(".nav-search").addClass("active");
   }
   function checkMy(){
      $(".nav-home").removeClass("active");
      $(".nav-search").removeClass("active");
      $(".nav-write").removeClass("active");
      
      $(".nav-my").addClass("active");
   }
   function checkWrite(){
      $(".nav-home").removeClass("active");
      $(".nav-search").removeClass("active");
      $(".nav-my").removeClass("active");
      
      $(".nav-write").addClass("active");
   }
   
</script>  
<style type="text/css">
	li{
		text-decoration:none;
		color: white;
	}
	a:active{
		text-decoration:none;
		color: white;
	}
	a:link{
		text-decoration:none;
		color: white;
	}
	a:hover{
		text-decoration:none;
		color: white;
	}
</style>
 
</body>
</html>