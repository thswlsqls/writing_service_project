<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
  	<!-- navbar 
<ul class="nav nav-pills nav-justified fixed-top">
  <li class="nav-item">
    <a class="nav-link" aria-current="page" href="#">친구</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="#">실시간추천</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="#">새로운</a>
  </li>
  <li class="nav-item">
    <a class="nav-link">트렌트</a>
  </li>
</ul>-->
<%@include file="howAreYouHeader.jsp" %>
    
      
 		<div class="container d-flex flex-column justify-content-center align-items-center">
 			<div class="text title">
 				<h5><b>지금 다른 사람들은</b></h5>
 			</div>
 			 <div class="text title thirdKeyword">
		      	<a href='controller?cmd=trendAction&emotionName=${trendlist[2] }' >${trendlist[2] }</a>
		      </div>
		      <div class="text contents firstKeyword">
		      	<a href='controller?cmd=trendAction&emotionName=${trendlist[0] }' >${trendlist[0] }</a>
		      </div>
		      <div class="text writer secondKeyword">
		        <a href='controller?cmd=trendAction&emotionName=${trendlist[1] }' > ${trendlist[1] }</a>
		      </div>
 		</div>
        
    <!-- <div class="carousel-item">
      <img src="img/2.jpg" class="d-block " alt="...">
    </div>
    
    <div class="carousel-item">
      <img src="img/3.jpg" class="d-block " alt="..." >
    </div> 
    
  </div>
  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Previous</span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Next</span>
  </button>
</div>-->
<%@include file="menu.jsp" %>
    <!-- Optional JavaScript; choose one of the two! -->

    <!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

    <!-- Option 2: Separate Popper and Bootstrap JS -->
    <!--
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
    -->
<!-- 구글웹폰트 Raleway Rehular 400 -->

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Koulen&family=Nanum+Gothic+Coding:wght@400;700&family=Nanum+Myeongjo:wght@700&family=Raleway:ital@0;1&family=Roboto+Mono:ital@1&display=swap" rel="stylesheet">

<!-- 구글웹폰트 Nanum Myeongjo Resular 400  -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Koulen&family=Nanum+Gothic+Coding:wght@400;700&family=Nanum+Myeongjo:wght@400;700&family=Raleway:ital@0;1&family=Roboto+Mono:ital@1&display=swap" rel="stylesheet">
   <style type="text/css">
	body{
	background-image: url("img/mainback.png");
	background-attachment: fixed;
	}
    img{
    width: 100vw;
    height: 100vh;
    }
    a{
	text-decoration: none;
	color : white;
}
    .image{
    position: relative;
    
    }
    .text{
   	 position: absolute;
     text-align: center;
     color: black;
     font-size:18pt;
     font-weight: border;
     
    }
    .contents{
		top: 50%;
		left: 50%;
		transform: translate(-50%,-50% );
    }
    .title{
	    top: 20%;
		left: 50%;
		transform: translate(-50%,-50% );
     color: white;
     font-weight:border;
     font-size: 1rem;
    }
    .writer{
	    top: 80%;
		left: 50%;
		transform: translate(-50%,-50% );
    }
    .firstKeyword{
   		width: 50%;
    	height: 25%;
    	transform: translate(-80%,-50% );
    	border-radius: 150px;
    	background: linear-gradient(to right, #F8DC7C, #FDFFA9);
    	background-color: #F8DC7C;
    	display: flex;
    	justify-content: center;
    	align-items: center;
    }
    .secondKeyword{
    	width: 30%;
    	height: 15%;
    	margin-top:-50px;
    	border-radius: 120px;
    	background: linear-gradient(to right, #C4DDFF, #7FB5FF);
    	background-color: #82E5FB;
    	display: flex;
    	justify-content: center;
    	align-items: center;
    }
    .thirdKeyword{
  		 top: 30%;
	left: 50%;
	transform: translate(50%,-50% );
	margin-top : 50px;
   	width: 20%;
   	height: 10%;
   	border-radius: 50px;
   	background: linear-gradient(to right, #F9CEEE, #F9F3EE);
   	background-color: #FFD7D7;
   	display: flex;
   	justify-content: center;
   	align-items: center;
    }
</style>
<style type="text/css">
	.container{
		font-family: 'Nanum Myeongjo', serif;
	}
	
    a{
    	text-decoration : none;
    	color: #8983a9;
    	
    }
</style>
   
   
  </body>
</html>