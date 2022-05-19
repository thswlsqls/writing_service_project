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

    .text{
   	 position: absolute;
     text-align: center;
     color: white;
     font-weight: bolder;
    }
    .icon{
    text-align: center;
     color: white;
	font-weight: bolder;
    }
    .contents{
    font-size:15pt;
	top: 50%;
	left: 50%;
	transform: translate(-50%,-50% );
	
    }
    .title{
    top: 20%;
	left: 50%;
	transform: translate(-50%,-50% );
	font-size : 2rem;
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

	$(document).ready(function(){
		
		
		$.ajax({
			url : "controller?cmd=checkGoodAction",
			data : {userId: '<%=session.getAttribute("userId") %>'
			  		,  writeNo: '<%=request.getParameter("writeNo")%>'
					},
			success : function(response){
				jsonresponse = JSON.parse(response);
				if(jsonresponse.isReacted=="true"){
					$('.reaction').append('<i class="bi bi-suit-heart-fill" onclick="deleteReaction();"></i>');
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
					$('.bookmark').append('<i class="bi bi-star-fill" onclick="deleteBookmark()"></i>');
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

</script>
  	<!-- navbar -->
<%@include file="howAreYouBtn.jsp" %>
<div >
  <div class="d-flex flex-column">
    <div class="" >
      <img src="img/detail.jpg" class="d-block" alt="...">
      <div class="text title">
      	${list[0].getSuggestionName()}
      </div>
      <div class="text contents">
      	${list[0].getContents()}
      </div>
      <div class="text writer">
      	${list[0].getPenName()}<br>
      	${list[0].getWriteDate()} <br>
      	
      	<button class="clickableBackground" type="button" onclick="console.log('좋아요클릭')" >
      		<div class="flexRowBox">
   		  		<div class="reaction icon">
	      			좋아요
	      		</div>	
	      		<div class="reactionCnt icon">
	      			&nbsp;
	      		</div>	
      		</div>
      	</button>
      	<button class="clickableBackground" type="button" onclick="console.log('북마크클릭')" >
      		<div class="flexRowBox">
		      	<div class="bookmark icon">
		      	        즐겨찾기 
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
  </body>
</html>