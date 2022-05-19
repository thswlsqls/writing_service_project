<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
<meta HTTP-EQUIV="Page-Enter" ConTENT="BlendTrans(Duration=0.5)"> 
<meta HTTP-EQUIV="Page-exit" ConTENT="BlendTrans(Duration=0.5)">
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
 <script type="text/javascript" src="js/jquery-3.6.0.js"></script>
 <script type="text/javascript">
 var searchList = function(){
	 var search_name=$("select[name=searchName] option:selected").val();
	 var search_text=$("#searchText").val();
	 var date = $("#date").val();
	 var user_id = $("#searchId").val();
	 if (date.length == 0) {
		date = "no";
	}
	 $.ajax({
		url : "controller?cmd=searchAction",
		type : "post",
	 	data : {
	 		searchName : search_name,	 	
	 		searchText : search_text,
	 		date : date},
	 	success : function(resp){
	 		var jsonResponse = JSON.parse(resp);
			
			$("#searchedList").empty();
			$.each(jsonResponse, function(index, value){
				
				$("#searchedList").append(
						"<div class='row mypage-text fontcss' style='text-align: center;'> "+
						"<div class='col-4' >"+value.writeDate+"</div>"+
						"<div class='col-4' >"+value.penName+"</div>"+
						"<div class='col-4' >"+
						"<a class='aTag' href='controller?cmd=boardDetailUI"+"&writeNo="+value.writeNo+"'>"+
								value.suggestionName+"</a>"+"</div>"+
					"</div><br>"
						);
			
			});
	 	},error:function(){
			alert("통신실패");
		}
	 });
 };
 </script>
<style type="text/css">
	body{
	background-image: url("img/mainback.png");
	background-attachment: fixed;
	font-weight:bolder;
  	color: white;		
	}
	.aTag{
		text-decoration: none;
		color : white;
	}
    .contents{
    position:absolute;
	top: 60%;
	left: 50%;
	transform: translate(-50%,-50% );
    }
    .writer_name{
    position:absolute;
	top: 50%;
	left: 70%;
	transform: translate(-50%,-50% );
	font-size: 15pt;
	font-weight: bolder;
    }
    .mypage-text{
    font-size: 3.5vw;
    }
        .fontcss{
    font-weight:bolder;
  	color: white;
    }
</style>
</head>
<body>
<%@ include file="howAreYouHeader.jsp" %>
<br><br>
<div class="container">
	
	<div class="row">
		<div class="col-12 searchSelectContainer" style="text-align: center;"> <br>
			 <select class="penNameSelectBox" name="searchName" id="searchName"> 
			 	<option selected="selected" value="penName">필명으로 검색</option>
			 	<option class="dateSelectBox" value="suggestionName">제시어로 검색</option>
			 </select> 
			 <input class="dateSelectBox" type="date" name="date" id=date value="yyyy-mm-dd">
		</div>
	</div>
	<br>
	<div style="text-align: center;">
		<input class="searchInput" type="text" name="searchText" id = "searchText" size=30>
		<input class="searchBtn w-btn w-btn-pos" type="button" value="검색" onclick="searchList()">
	</div>
	
</div>
<div class="container searchContainer">
	
	<hr color="black" width="100%">
	
	<div class="row fontcss" style="text-align: center;">
		<div class="col-12" ><strong>검색결과</strong></div>
	</div>
	<div style="text-align: center;">
	
	</div>
	<div class="container fontcss searchItemsContainer" style="width: 90%"><br>
		<div class="row" style="text-align: center;">
			<div class="col-4" >날짜</div>
			<div class="col-4" >필명</div>
			<div class="col-4" >제시어</div>
		</div>
	</div>
	
	
	<hr color="black" width="100%">
	
	
	<div class="container" id="searchedList" style="width: 90%">
	
	<br>	
	</div>
</div>

<%@include file="menu.jsp" %>

<!-- 구글웹폰트 Nanum Myeongjo Resular 400  -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Koulen&family=Nanum+Gothic+Coding:wght@400;700&family=Nanum+Myeongjo:wght@400;700&family=Raleway:ital@0;1&family=Roboto+Mono:ital@1&display=swap" rel="stylesheet">
<style type="text/css">
	.searchItemsContainer{
		font-family: 'Nanum Myeongjo', serif;
	}
	.searchContainer{
		font-family: 'Nanum Myeongjo', serif;
	}
	.searchInput{
		font-family: 'Nanum Myeongjo', serif;
		width: 80%;	
		border-radius: 15px;
		border: none;
		opacity: 0.8;
	}
	.searchBtn{
		font-family: 'Nanum Myeongjo', serif;
	}
	.searchSelectContainer{
		font-family: 'Nanum Myeongjo', serif;
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
.penNameSelectBox{
	border-radius: 15px;
	border: none;
	opacity: 0.8;
}
.dateSelectBox{
border-radius: 15px;
	border: none;
	opacity: 0.8;
}

</style>

</body>
</html>
