<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
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
     <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" src="js/jquery-3.6.0.js"></script>
<!-- 부트스트랩 아이콘 -->
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<style type="text/css">
	body{
	background-image: url("img/mainback.png");
	background-attachment: fixed;
	
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
    font-size: 4.6vw;
   
    }
    
    .fontcss{
    font-weight:bolder;
    text-align:center;
  	color: white;
    }
        ul{
    font-size: 3.2vw;
    line-height: 200%;
    }
</style>
<script type="text/javascript">
var searchBtn = function(){
	var date = $("#today").val();
	
	$.ajax({
		url : "controller?cmd=myPageAction",
		type : "post",
	 	data : {date : date},
	 	success : function(resp){
	 		$("#mypageList").empty();
			$(".aa").empty();
	 		
	 		$("#mypageList").html(resp);
			
	 	},error:function(){
			alert("통신실패");
		}
	 });
	
}
$(document).ready(function () {
	var btns = document.querySelectorAll(".modalBtn");
	var spn = document.querySelectorAll(".status");
	var num = 0;
	var id
	for (const btn of btns) {
		id = spn[num].id;
		$.ajax({
			url : "controller?cmd=checkStatusAction",
			data : {userId: '<%=session.getAttribute("userId") %>'
			  		,  writeNo: btn.value
					},
			async: false,
			success : function(response){
				
				jsonresponse = JSON.parse(response);
				
				if(jsonresponse.isStatusLocked=="true"){
					$('#'+id).html('<i class="bi bi-unlock-fill"></i>');
				}else if(jsonresponse.isStatusLocked=="false"){
					$('#'+id).html('<i class="bi bi-lock-fill"></i>');
				}
			}
		})
		num += 1;
		btn.addEventListener('click', function(e) {
			$("#modify").click(function(){
				location.href="controller?cmd=diaryModifyUI&writeNo="+btn.value;
			})
			
			$("#delete").click(function(){
				location.href="controller?cmd=diaryDeleteAction&writeNo="+btn.value;
			})
			
			$("#shareStatus").change(function(){
				var selectOpt=$("select[id=shareStatus] option:selected").val();
				
				$.ajax({
					url : "controller?cmd=setShareStatusAction",
					data : {userId: '<%=session.getAttribute("userId") %>'
					  		,  writeNo: btn.value,
					  		shareStatus:selectOpt
							},
					success : function(response){
						
						jsonresponse = JSON.parse(response);
						if (jsonresponse.isStatusLocked == "true") {
							location.reload();
						}else if(jsonresponse.isStatusLocked == "false"){
							alert("공유상태 설정이 잘못되었습니다.");
						}
					}
				})
				

			})

		});
	}
})

</script>
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
	      <li><a href="controller?cmd=bookmarkListUI" class="aTag">즐겨찾기</a></li>
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
      <div class="col-4" ><strong>나의 글 앨범</strong></div>
      <div class="col-8" >
         <input class="dateSelectBox" type="date" value="날짜" id="today">
         <input class="w-btn w-btn-pos " type="button" value="조회" id="search" onclick="searchBtn()">
      </div>
   
   </div>
   <div class="container fontcss" style="width: 80%"><br>
   <div class="row" style="text-align: center;">
      <div class="col-5" >날짜</div>
      <div class="col-4" >제시어</div>
      <div class="col-3" ></div>
   </div>
   </div>
   

   <hr color="black" width="100%">
   
   <c:forEach var="l" items = "${list}" varStatus="status">
	   <div class="container" style="width: 100%" id="mypageList">
		   <div class="row mypage-text fontcss" style="text-align: center;">
		      <div class="col-5 aa" >${l.writeDate}</div>
		      <div class="col-4 aa" ><a class="aTag" href='controller?cmd=boardDetailUI&writeNo=${l.getWriteNo()}'>${l.suggestionName}</a></div>
		      <div class="col-3 aa"><button type="button" id='btn${status.index}' value="${l.getWriteNo()}" name="${l.getWriteNo()}" class="btn btn-primary btn-sm modalBtn" data-bs-toggle="modal" data-bs-target="#myModal">-</button>
		      	<span class="status" id='spn${status.index}' title="spn${status.index}">A</span>
		      </div>					
		   </div>
		   <br>   
	   </div>
	</c:forEach>

</div>
<!-- The Modal -->

<div class="modal fade modalContainer" id="myModal">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title modalTitle" style="text-align: center;">Menu</h4>
        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
      </div>

      <!-- Modal body -->
      <div class="modal-body" style="text-align: center;">
        <input type="button" class="w-btn w-btn-pos" value="글 수정" id="modify">
        <input type="button" class="w-btn w-btn-nag" value="글 삭제" id="delete">
        <select class="shareStatusSelect" id="shareStatus">
        	<option selected="selected">공유상태</option>
        	<option value="전체">전체보기</option>
        	<option value="나만">나만보기</option>
        </select>	
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger w-btn" data-bs-dismiss="modal">Close</button>
      </div>

    </div>
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
.dateSelectBox{
border-radius: 15px;
	border: none;
	opacity: 0.8;
}
.modalContainer{
	opacity: 0.95;
	 font-family: 'Nanum Myeongjo', serif;
}
.shareStatusSelect{
	border-radius: 5px;
	border-color: #55747a;
}
.modalTitle{
	font-family: 'Roboto Mono', monospace;
}

</style>

</body>
</html>