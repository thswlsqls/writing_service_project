<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 부트스트랩 아이콘 -->
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">

<title>Hello, world!</title>
</head>
<body>

<%@include file="howAreYouHeader.jsp" %>
 
 <!-- <div class="d-flex flex-column justify-content-center align-items-center viewImgContainer">
	<div class="d-flex p-3 justify-content-center align-items-center ">
	</div>
	<div class="d-flex flex-column justify-content-around  align-content-around chooseBtnContainer">
	
	<c:forEach var="r" items="${rankList}">
		<div class="d-flex p-3 justify-content-between align-items-center text-white chooseBtnFlexRow">
			<div class="d-flex p-3 justify-content-center align-items-center   chooseBtnFlexBox">
				<button type="button" class="btn btn-info chooseBtn1" onclick="location.href='controller?cmd=rankingAction&writeNo=${r.getWriteNo()}'">
				${r.getContents()}<br>
				${r.getWriteDate() } ${r.getPenName() }<br><br>
				${r.getrCnt() }
				</button>
			</div>
		</div>
	</c:forEach>
	
	</div>
</div> -->

<div class="boardListContainer d-flex flex-column">

	<c:forEach var="v" items="${rankList}" varStatus="status">
	
		<div class=" mt-3 p-2 boardcontainer" >
		
	      <button class="clickableBackground" type="button" onclick="location.href='controller?cmd=boardDetailUI&writeNo=${v.writeNo}'" >
			<div class="card img-fluid boardBtnInner">
			         <div class="boradHeader">
			    		A board receive the reaction most : rank ${status.index+1}
			   		 </div>
			    <img class="card-img-top boardImg" src="img/${status.index+1}.jpg" alt="Card image" style="width:100%">
			    <div class="card-img-overlay cardInner">

			      <h4 class="card-title boardTitle text">${v.suggestionName}</h4>
			     <!-- <p class="card-text">${v.contents}</p>  --> 
			      <br>
			      <span class="boradWriter text">${v.penName}</span>
			      <br>
			      <span class="boradDate text">${v.writeDate}</span>
			      <span class="boradDate text"><i class="bi bi-suit-heart-fill red" >${v.rCnt}</i></span>
			      <br>
			    </div>
			  </div>
		  </button>
		  
		</div>
		
	</c:forEach>
	
</div>

<%@include file="menu.jsp" %>
  </body>
  <style>
	.chooseBtnContainer{
		width: 90vw;
		height: 80vh;
	}
	.chooseBtnFlexRow{
		padding:0px;
		width: 100%;
		min-height:35%; 
	}
	.chooseBtnFlexBox{
		padding:0px;
		min-width: 100%;
		height: 100%;
	}
	.chooseBtn1{
		width:100%;
		height:100%;
		background-image: url('img/mad1.png');
		background-repeat: no-repeat;
	}
</style>

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
    	text-shadow: none;
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