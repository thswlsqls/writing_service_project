<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
  <head>
  <script type="text/javascript" src="js/jquery-3.6.0.js"></script>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

	<!-- 부트스트랩 아이콘 -->
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
	
    <title>Hello, world!</title>
	<style type="text/css">

    img{
    width: 100vw;
    height: 100vh;
    }
    .image{
    position: relative;
    
    }
    .red{
    	color:red;
    }
    .green{
    	color: green;
    }
    .yellow{
    	color : yellow;
    }
	.bi-person-plus-fill{
		font-size: 18pt;
	}
	.bi-person-check-fill{
		font-size: 18pt;
	}
    .text{
   	 position: absolute;
     text-align: center;
     color: white;
     
     font-weight: bolder;
    }
    .contents{
    font-size:5vw;
	top: 50%;
	left: 50%;
	transform: translate(-50%,-50% );
	font-family: 'Nanum Myeongjo', serif;
	word-break:keep-all;
    }
    .title{
    top: 20%;
	left: 50%;
	font-size : 2rem;
	transform: translate(-50%,-50% );
	font-family: 'Nanum Myeongjo', serif;
    }
	.icon{
    text-align: center;
     color: white;
	font-weight: bolder;
    }
    .writer{
    top: 80%;
	left: 50%;
	background:  rgba(0,0,0,0.5);
	transform: translate(-50%,-50% );
    }
    .clickableBackground{
		width:100%;
		height:100%;
		background-color: transparent;
		background-repeat: no-repeat;
		border: none;
	}
	.flexRowBox{
		display:flex;
		flex-direction: row;
		justify-content: center;
		align-items: center;
	}
	</style>
  </head>
  <body>
<script type="text/javascript">
var followee_pen_name = "${board.getPenName()}";
var follower_pen_name = "${penName}";
	$(document).ready(function(){
		
		$.ajax({
			url : "controller?cmd=checkGoodAction",
			data : {userId: '<%=session.getAttribute("userId") %>'
			  		,  writeNo: '<%=request.getParameter("writeNo")%>'
					},
			success : function(response){
				jsonresponse = JSON.parse(response);
				if(jsonresponse.isReacted=="true"){
					$('.reaction').append('<i class="bi bi-suit-heart-fill red" onclick="deleteReaction();"></i>');
				}else if(jsonresponse.isReacted=="false"){
					$('.reaction').append('<i class="bi bi-suit-heart" onclick="addReaction();" ></i>');
				}
			}
		})
		$.ajax({
			url : "controller?cmd=checkBookmarkAction",
			data : {userId: '<%=session.getAttribute("userId") %>'
			  		,  writeNo: '<%=request.getParameter("writeNo")%>'
					},
			success : function(response){
				jsonresponse = JSON.parse(response);
				if(jsonresponse.isBookmarked=="true"){
					$('.bookmark').append('<i class="bi bi-star-fill yellow" onclick="deleteBookmark()"></i>');
				}else if(jsonresponse.isBookmarked=="false"){
					$('.bookmark').append('<i class="bi bi-star" onclick="addBookmark()"></i>');
				}
			}
		})
		// 좋아요 총 개수 조회
		$.ajax({
			url : "controller?cmd=countGoodAction",
			data : {writeNo: '<%=request.getParameter("writeNo")%>'},
			success : function(response){
				jsonresponse = JSON.parse(response);
				let cnt = jsonresponse.reactionCnt
				$('.reactionCnt').append(cnt);
			}
		})
		// 팔로우 여부
		
		if (follower_pen_name != followee_pen_name) {
			
			$.ajax({
				url : "controller?cmd=checkFollowAction",
				data : {followeePenName: followee_pen_name
				  		,  followerPenName: follower_pen_name},
				success : function(response){
					jsonresponse = JSON.parse(response);
					$('.friend').empty;
					if(jsonresponse.isFollowChecked=="true"){
						$('.friend').append('<i class="bi bi-person-check-fill green" onclick="deleteFollow()"></i>');
					}else if(jsonresponse.isFollowChecked=="false"){
						$('.friend').append('<i class="bi bi-person-plus-fill red" onclick="addFollow()"></i>');
					}
				}
			});
		}
		
		
	});
	
	
	function addReaction(){
		$.ajax({
			url : "controller?cmd=goodAddAction",
			data : {userId: '<%=session.getAttribute("userId") %>'
		  		,  writeNo: '<%=request.getParameter("writeNo")%>'
				},
			success : function(response){
				jsonresponse = JSON.parse(response);
				if(jsonresponse.isAddSuccess=="true"){
					location.reload();
				}else if(jsonresponse.isAddSuccess=="false"){
					alert("좋아요 등록에 실패했습니다.");
				}
			}
		})
	}
	function deleteReaction(){
		$.ajax({
			url : "controller?cmd=goodDeleteAction",
			data : {userId: '<%=session.getAttribute("userId") %>'
		  		,  writeNo: '<%=request.getParameter("writeNo")%>'
				},
			success : function(response){
				jsonresponse = JSON.parse(response);
				if(jsonresponse.isDeleteSuccess=="true"){
					location.reload();
				}else if(jsonresponse.isDeleteSuccess=="false"){
					alert("좋아요 삭제에 실패했습니다.");
				}
			}
		})
	}
	
	function addBookmark(){
		$.ajax({
			url : "controller?cmd=bookmarkAction",
			data : {userId: '<%=session.getAttribute("userId") %>'
		  		,  writeNo: '<%=request.getParameter("writeNo")%>'
				},
			success : function(response){
				jsonresponse = JSON.parse(response);
				if(jsonresponse.isAddSuccess=="true"){
					location.reload();
				}else if(jsonresponse.isAddSuccess=="false"){
					alert("즐겨찾기 등록에 실패했습니다.");
				}
			}
		})
	}
	function deleteBookmark(){
		$.ajax({
			url : "controller?cmd=bookmarkDeleteAction",
			data : {userId: '<%=session.getAttribute("userId") %>'
		  		,  writeNo: '<%=request.getParameter("writeNo")%>'
				},
			success : function(response){
				jsonresponse = JSON.parse(response);
				if(jsonresponse.isDeleteSuccess=="true"){
					location.reload();
				}else if(jsonresponse.isDeleteSuccess=="false"){
					alert("즐겨찾기 삭제에 실패했습니다.");
				}
			}
		})
	}
	
	function addFollow(){
		$.ajax({
			url : "controller?cmd=friendFollowAction",
			data : {followeePenName: followee_pen_name
		  		,  followerPenName: follower_pen_name},
			success : function(response){
				jsonresponse = JSON.parse(response);
				if(jsonresponse.isFollowSuccess=="true"){
					location.reload();
				}else if(jsonresponse.isFollowSuccess=="false"){
					alert("팔로우 등록에 실패했습니다.");
				}
			}
		})
	}

	function deleteFollow(){
		$.ajax({
			url : "controller?cmd=deleteFollowAction",
			data : {followeePenName: followee_pen_name
		  		,  followerPenName: follower_pen_name},
			success : function(response){
				jsonresponse = JSON.parse(response);
				if(jsonresponse.isFollowDelete=="true"){
					location.reload();
				}else if(jsonresponse.isFollowDelete=="false"){
					alert("팔로우 삭제에 실패했습니다.");
				}
			}
		})
	}
</script>
  	<!-- navbar -->
<%@include file="howAreYouHeader.jsp" %>
<div >
  <div class="d-flex flex-column">
    
      <div class="carousel-item active image col-md-12" style="padding: 0px;" >
      
      <img src="img/detail.png" class="d-block" alt="...">
      
      <div class="text title">
      	${board.getSuggestionName()}
      </div>
      <div class="text contents" style="width: 80%;">
      	${board.getContents()}
      </div>
      <div class="text writer">
      	${board.getPenName()}<span class="friend"></span><br>
      	${board.getWriteDate()} <br>
      	
      	<button class="clickableBackground" type="button" onclick="console.log('좋아요클릭')" >
      		<div class="flexRowBox">
   		  		<div class="reaction icon">
	      			like
	      		</div>	
	      		<div class="reactionCnt icon">
	      			&nbsp;
	      		</div>	
      		</div>
      	</button>
      	<button class="clickableBackground" type="button" onclick="console.log('북마크클릭')" >
      		<div class="flexRowBox">
		      	<div class="bookmark icon">
		      	    bookmark 
		      	</div>
		    </div>
   		</button>
      </div>
      
    </div>
  </div>
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
    <!-- 구글웹폰트 Raleway Rehular 400 -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Koulen&family=Nanum+Gothic+Coding:wght@400;700&family=Nanum+Myeongjo:wght@700&family=Raleway:ital@0;1&family=Roboto+Mono:ital@1&display=swap" rel="stylesheet">

<!-- 구글웹폰트 Nanum Myeongjo Resular 400  -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Koulen&family=Nanum+Gothic+Coding:wght@400;700&family=Nanum+Myeongjo:wght@400;700&family=Raleway:ital@0;1&family=Roboto+Mono:ital@1&display=swap" rel="stylesheet">
<style type="text/css">

	.reaction{
		font-family: 'Raleway', sans-serif;
	}
	.bookmark{
		font-family: 'Raleway', sans-serif;
	}
	.writer{
		font-family: 'Raleway', sans-serif;
	}
	
</style>  
  
  
  </body>
</html>