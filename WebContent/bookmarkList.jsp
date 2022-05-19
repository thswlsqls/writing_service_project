<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script type="text/javascript" src="js/jquery-3.6.0.js"></script>
<script type="text/javascript">
var changeSelect = function(){
	 var selectOpt=$("select[name=selectbox] option:selected").val();
	
	 $.ajax({
		url : "controller?cmd=bookmarkListUI2",
		type : "post",
	 	data : {selectOpt : selectOpt},
	 	success : function(resp){
	 		
	 		var jsonResponse = JSON.parse(resp);
			
			$("#bookmarkList").empty();
			$.each(jsonResponse, function(index, value){
				
				$("#bookmarkList").append(
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
}
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
  .profile-user-img{
    width: 80px;
    height: 80px;
    border-radius: 70%;
    overflow: hidden; 
  }

  .profile-user-img-img{
    width: 100%;
    height: 100%;
    object-fit: cover;
  }

    .contents{
    position:absolute;
	top: 60%;
	left: 48%;
	font-size:10pt;
	transform: translate(-50%,-50% );
    }
    .writer_name{
    position:absolute;
	top: 50%;
	left: 70%;
	transform: translate(-50%,-50% );
	font-size: 4vw;
	font-weight: bolder;
    }
    .mypage-text{
    font-size: 4vw;
    
    }
    .fontcss{
    font-weight:bolder;
  	color: white;
  	padding-left: -10px;
    }
    ul{
    font-size: 3.2vw;
    line-height: 200%;
    }
</style>
</head>
<body>
<%@ include file="howAreYouHeader.jsp" %>
<br><br>
<div class="container">
	<div class="row">
	<div class="col-6" style="position: relative;"> <br>
		 <div class="profile-user-img">
		 <img src="img/profile.png" alt="profile-user-img" class="profile-user-img-img">
		 
		 </div>
		  <div class="writer_name fontcss">
		  	${penName}
		  </div>
		 <br>
	</div>
	<div class="col-6" style="position: relative;">
	<div class="contents fontcss" >
		<ul>
		<li><a href="controller?cmd=myPageUI" class="aTag">마이페이지</a></li>
		<li><a href="controller?cmd=friendListUI" class="aTag">팔로우목록</a></li>
		<li><a href="controller?cmd=logoutAction" class="aTag">로그아웃</a></li>
		</ul>
		</div>
	 </div>
	</div>
</div>
<div class="container">
	
	<hr color="black" width="100%">
	
	<div class="row fontcss" style="text-align: center;">
		<div class="col-6" ><strong>나의 즐겨찾기 목록</strong></div>
		<div class="col-6" >
			<select class="orderBySelect" id="selectbox" name="selectbox" onchange="changeSelect()">
				<option selected="selected" value = "date" id="date">날짜순</option>
				<option value = "word" id="word">제시어순</option>
				<option value = "name" id="name">필명 순</option>
			</select>
		</div>
	
	</div>
	<div class="container fontcss" style="width: 100%"><br>
	<div class="row" style="text-align: center;">
		<div class="col-4" >날짜</div>
		<div class="col-4" >필명</div>
		<div class="col-4" >제시어</div>
	</div>
	</div>
	
	<hr color="black" width="100%">
	
	<div class="container" style="width: 100%" id="bookmarkList">
	<c:forEach items="${list}" var = "l">
		<div class="row mypage-text fontcss" style="text-align: center;">
		<div class="col-4" >${l.getWriteDate()}</div>
		<div class="col-4" >${l.getPenName()}</div>
		<div class="col-4" ><a class="aTag" href='controller?cmd=boardDetailUI&writeNo=${l.getWriteNo()}'>${l.getSuggestionName()}</a></div>
	</div>
	<br>
	</c:forEach>
	</div>
</div>

<%@include file="menu.jsp" %>
<!-- 구글웹폰트 Nanum Myeongjo Resular 400  -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Koulen&family=Nanum+Gothic+Coding:wght@400;700&family=Nanum+Myeongjo:wght@400;700&family=Raleway:ital@0;1&family=Roboto+Mono:ital@1&display=swap" rel="stylesheet">

<!-- 구글웹폰트 Roboto mono regular 400 italic -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Koulen&family=Nanum+Gothic+Coding:wght@400;700&family=Nanum+Myeongjo:wght@400;700&family=Raleway:ital@0;1&family=Roboto+Mono:ital@1&display=swap" rel="stylesheet">
<style type="text/css">

	.container{
		 font-family: 'Nanum Myeongjo', serif;
	}
	.orderBySelect{
		border-radius: 15px;
		border: none;
		opacity: 0.8;
	}

</style>
</body>
</html>
