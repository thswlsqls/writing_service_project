<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
   <!-- Required meta tags -->
   <meta charset="utf-8">
   <meta name="viewport" content="width=device-width, initial-scale=1">

   <!-- Bootstrap CSS -->
   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

   <title>Hello, world!</title>
  </head>
  <body>
  
<%@ include file="howAreYouHeader.jsp" %>
  <form action="controller?cmd=diaryModifyAction" method="post">
   <div class="container d-flex flex-column justify-content-center align-items-center" style=" text-align: center; ">
      <div class="row-md-6">
      <br><br><br>
       <h2><strong>${suggestionName}</strong></h2>
      </div>
   <textarea name="contents">${contents}</textarea><br>
   <div style="display: inline-block;">
   <input class="w-btn w-btn-pos" type="submit" value="수정완료">&nbsp;
   <input class="w-btn w-btn-nag" type="button" value="취소" onclick="location.href='controller?cmd=myPageUI'">
   </div>  <input class="fade" value="${writeNo}" name="writeNo">
</div>
</form>


    <!-- Optional JavaScript; choose one of the two! -->

    <!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

    <!-- Option 2: Separate Popper and Bootstrap JS -->
    <!--
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
    -->
  </body>
  <%@include file="menu.jsp" %>
  <!-- 구글웹폰트 Nanum Myeongjo Resular 400  -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Koulen&family=Nanum+Gothic+Coding:wght@400;700&family=Nanum+Myeongjo:wght@400;700&family=Raleway:ital@0;1&family=Roboto+Mono:ital@1&display=swap" rel="stylesheet">
  
</style>
     <style type="text/css">
     strong{
        font-family: 'Nanum Myeongjo', serif;
        color: white;
        line-height: 20%;
     }
     form{
        font-family: 'Nanum Myeongjo', serif;
     }
   body{
   background-image: url("img/mainback.png");   
   }
   textarea {
    width: 80vw;
    height: 70vh;
    border: none;
    resize: none;
    font-size: 15pt;
    /*text-align: center;*/
    border-radius: 15px;
    opacity: 0.8;
    
  }
  .suggestioncheck{
     font-size: 5vw;
  }
  .suggestionRefreshBtn{
      background-color: #FFF8EB;
     border-color: #FFF8EB;
  }
  
   @import url("https://fonts.googleapis.com/css?family=Poppins:200,300,400,500,600,700,800,900&display=swap");
.w-btn {
    position: relative;
    border: none;
    display: inline-block;
    padding: 5px 10px;
    border-radius: 15px;
    font-family: "paybooc-Light", sans-serif;
    box-shadow: 0 15px 35px rgba(0, 0, 0, 0.2);
    text-decoration: none;
    font-weight: 600;
    transition: 0.25s;
    
    opacity: 0.8
}
.w-btn-indigo {
    background-color: aliceblue;
    color: #1e6b7b;
} 
.w-btn-pos {
    background-color: #E6D8CC;
    color: #7e7c79;
} 
.w-btn-nag {
    background-color: #a9c5c9;
    color: #55747a;
} 
.w-btn:hover {
    letter-spacing: 2px;
    transform: scale(1.2);
    cursor: pointer;
}
  
   </style>
</html>