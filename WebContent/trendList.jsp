<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	
	<!-- 부트스트랩 아이콘 -->
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
	
    <title>Hello, world!</title>
  </head>
  <body>
  	<!-- navbar -->
<%@include file="howAreYouHeader.jsp" %>

<div class=" d-flex flex-column boardListContainer">

	<c:forEach var="v" items="${list}" varStatus="status">
	
		<div class=" mt-3 p-2 boardcontainer" >
		
	      <button class="clickableBackground" type="button" onclick="location.href='controller?cmd=boardDetailUI&writeNo=${v.writeNo}'" >
			<div class="card img-fluid boardBtnInner">
			         <div class="boradHeader">
			    		A board matched with trend
			   		 </div>
			    <img class="card-img-top boardImg" src="img/${status.index+1}.jpg" alt="Card image" style="width:100%">
			    <div class="card-img-overlay cardInner">

			      <h4 class="card-title boardTitle text">${v.suggestionName}</h4>
			     <!-- <p class="card-text">${v.contents}</p>  --> 
			      <br>
			      <span class="boradWriter text">${v.penName}</span>
			      <br>
			      <span class="boradDate text">${v.writeDate}</span>
			      <br>
			    </div>
			  </div>
		  </button>
		  
		</div>
		
	</c:forEach>
	
</div>
<%@include file="menu.jsp" %>
    <!-- Optional JavaScript; choose one of the two! -->

    <!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

    <!-- Option 2: Separate Popper and Bootstrap JS -->
    <!--
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
    -->
  </body>
  <!-- 구글웹폰트 Raleway Rehular 400 -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Koulen&family=Nanum+Gothic+Coding:wght@400;700&family=Nanum+Myeongjo:wght@700&family=Raleway:ital@0;1&family=Roboto+Mono:ital@1&display=swap" rel="stylesheet">

<!-- 구글웹폰트 Nanum Myeongjo Resular 400  -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Koulen&family=Nanum+Gothic+Coding:wght@400;700&family=Nanum+Myeongjo:wght@400;700&family=Raleway:ital@0;1&family=Roboto+Mono:ital@1&display=swap" rel="stylesheet">
   
<style type="text/css">

    img{
    width: 100vw;
    height: 20vh;
    }
    .image{
    position: relative;
    
    }

    .text{
     text-align: center;
     color: black;
     font-weight: bolder;
     text-shadow: -1px 0 #FFFFFF;, 0 1px #FFFFFF;, 1px 0 #FFFFFF;, 0 -1px #FFFFFF;;
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
    }
    .writer{
    top: 80%;
   left: 50%;
   transform: translate(-50%,-50% );
    }
    .boardListContainer{
    	padding: 12vh 0vh;
    	
    	display: flex;
    	
	     animation: fadein 0.3s;
	    -moz-animation: fadein 0.3s;
	    -webkit-animation: fadein 0.3s;
	    -o-animation: fadein 0.3s;
    }
    .boardcontainer{
   		max-height:35vh;
   		display: flex;
   		justify-content: center;
   		align-items: center;
   		padding-bottom: 20px;
   		
	     animation: fadein 0.7s;
	    -moz-animation: fadein 0.7s;
	    -webkit-animation: fadein 0.7s;
	    -o-animation: fadein 0.7s;
    }
    .clickableBackground{
		width:90%;
		height:100%;
		background-color: transparent;
		background-repeat: no-repeat;
		border: none;
		
		padding: 0px;
	    border-radius: 15px;
	    font-family: "paybooc-Light", sans-serif;
	    box-shadow: 0 15px 35px rgba(0, 0, 0, 0.2);
		
	}
	
	.themasBtn{
	}
	.boardBtnInner{
		width:100%;
		max-height:20vh;
		height: 100%;
		border: none;
		background: transparent;
	}
	.boardImg{
		max-height:17vh;
		border-radius: 0px 0px 9px 9px;
		box-shadow: 2px 2px 3px 2px rgba(0, 0, 0, 0.2);
		opacity: 0.8;
	}
	.boradHeader{
		min-height: 4vh ;
		background-color: #D1C7C5;
	    font-size: 4vw;
	    z-index: 1024;
	    text-align: left;
	    border-radius: 9px 9px 0px 0px;
	    box-shadow: 2px 2px 3px 2px rgba(0, 0, 0, 0.2);
	    line-height: 4vh;
	    padding-left: 2vw;
	    color: #f9fafb;
	    color: #4D4948;
	    font-weight:bold;
	    font-family: 'Raleway', sans-serif;
	}
	.cardInner{
		padding-top: 5vh;
		max-height: 24vh;
		height: 100%;
	}
	.boardTitle{
		font-family: 'Nanum Myeongjo', serif;
	}
	.boradWriter{
		font-family: 'Nanum Myeongjo', serif;
	}
	.boradDate{
		font-family: 'Nanum Myeongjo', serif;
	}
	
	@keyframes fadein {
    from {
        opacity:0.1;
    }
    to {
        opacity:1;
    }
	}
	@-moz-keyframes fadein {
	    from {
	        opacity:0.1;
	    }
	    to {
	        opacity:1;
	    }
	}
	@-webkit-keyframes fadein {
	    from {
	        opacity:0.1;
	    }
	    to {
	        opacity:1;
	    }
	}
	@-o-keyframes fadein {
	    from {
	        opacity:0.1;
	    }
	    to {
	        opacity: 1;
	    }

   </style>
</html>