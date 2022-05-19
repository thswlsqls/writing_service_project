<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <meta charset="utf-8">
  
  <!-- 부트스트랩5버전, 일부 호환안됨 -->
  <!--  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
  -->
  
   <!-- 부트스트랩4버전 네비바로 대체함 -->
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
  
  </head>
<body>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>

<!-- 구글웹폰트 Roboto Mono Regular 400 Italic -->
<link href="https://fonts.googleapis.com/css2?family=Koulen&family=Nanum+Gothic+Coding&family=Roboto+Mono:ital,wght@1,300;1,400&display=swap" rel="stylesheet">

<!-- 구글웹폰트 Nanum Gothic Coding Bold 700 -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Koulen&family=Nanum+Gothic+Coding:wght@400;700&family=Roboto+Mono:ital,wght@1,300;1,400&display=swap" rel="stylesheet">


<style type="text/css"">
   .HAYheader{
      font-family: 'Roboto Mono', monospace;
      font-family: 'Koulen', cursive;
      font-family: 'Nanum Gothic Coding', monospace;
      font-family: 'Roboto Mono', monospace;
      background-color: #D1C7C5;
      color: #4D4948;
      
   }
   .linkText{
      font-family: 'Koulen', cursive;
      font-family: 'Nanum Gothic Coding', monospace;
      font-family: 'Roboto Mono', monospace;
      font-weight: bold;
      color: #4D4948;
   }
</style>

  <!-- 부트스트랩5버전, 일부 호환안됨 -->
<!-- <nav class=" navbar fixed-top navbar-expand-sm navbar-dark HAYheader ">
  <div class="container-fluid">
    <a class="navbar-brand" href="controller?cmd=homeUI">How Are You</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="collapsibleNavbar">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link linkText" href="controller?cmd=friendWriteListUI">FOLLOW</a>
        </li>
        <li class="nav-item">
          <a class="nav-link linkText" href="controller?cmd=rankingUI">RANKING</a>
        </li>
        <li class="nav-item">
          <a class="nav-link linkText" href="controller?cmd=newListUI">NEW</a>
        </li>  
        <li class="nav-item">
          <a class="nav-link linkText" href="controller?cmd=trendUI">TREND</a>
        </li>    
      </ul>
    </div>
  </div>
</nav> -->

  <!-- 부트스트랩4버전 네비바로 대체함 -->
<nav class="navbar navbar-expand-md  navbar-dark HAYheader fixed-top">
  <a class="navbar-brand" href="controller?cmd=homeUI">How Are You</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="collapsibleNavbar">
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link linkText" href="controller?cmd=friendWriteListUI">FOLLOW</a>
      </li>
      <li class="nav-item">
        <a class="nav-link linkText" href="controller?cmd=rankingUI">RANKING</a>
      </li>
      <li class="nav-item">
        <a class="nav-link linkText" href="controller?cmd=newListUI">NEW</a>
      </li>    
      <li class="nav-item">
        <a class="nav-link linkText" href="controller?cmd=trendUI">TREND</a>
      </li>    
    </ul>
  </div>  
</nav>


</body>
</html>