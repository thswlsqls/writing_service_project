<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

<!-- 구글웹폰트 나눔명조 bold 700 -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Koulen&family=Nanum+Gothic+Coding:wght@400;700&family=Nanum+Myeongjo:wght@700&family=Roboto+Mono:ital@1&display=swap" rel="stylesheet">

<style type="text/css">
	.korFontMain{
		font-family: 'Nanum Myeongjo', serif;
	}
</style>

<title>Insert title here</title>
</head>
<body>
<script>
	
</script>
	<div class="d-flex flex-column justify-content-center align-items-center viewContainer">
		<div class="d-flex flex-column justify-content-center align-items-center">
			<div class="d-flex flex-column justify-content-center align-items-center">
				<h1><b class="korFontMain">아이디 찾기</b></h1>
			</div>
			
			<div class="p-2 container mt-3 submitFormContainer">
			
			  <form action="controller?cmd=findId" class="submitForm" method="post">
			    <div class="d-flex mb-3 mt-3">
			      <label class="searchLabel korFontMain">이름</label>
			      <input type="text" class="form-control userInput" id="name" 
			      placeholder="" name="name">
			    </div>
			    <div class="d-flex mb-3">
			      <label class="searchLabel korFontMain">이메일</label>
			      <input type="text" class="form-control userInput" id="email" 
			      placeholder="" name="email">
			    </div>
			    <button type="submit" class="btn btn-primary w-100 submitBtn " >
			    	아이디 찾기
			    </button>
			  </form>
			<!-- onclick="location.href='controller?cmd=findId'" -->
			</div>
			<div class="d-flex justify-content-around w-100" >
				<span class="descSpan">* 아이디가 이메일로 전송 됩니다.</span>
			</div>
			
			
			<hr />
			
			
			<div class="d-flex flex-column justify-content-center align-items-center">
				<h1><b class="korFontMain">비밀번호 찾기</b></h1>
			</div>
				<div class="p-2 container mt-3 submitFormContainer" >
			 	<form action="controller?cmd=sendPwMailAction" method="post"class="submitForm">
				    <div class="d-flex mb-3 mt-3">
				      <label class="searchLabel korFontMain">아이디</label>
				      <input type="text" class="form-control userInput" id="userId" placeholder="" name="userId">
				    </div>
				    <div class="d-flex mb-3">
				      <label class="searchLabel korFontMain" for="pwd">이메일</label>
				      <input type="text" class="form-control userInput" id="email" placeholder="" name="email">
				    </div>
				     <div class="d-flex mb-3">
				     	<button type="submit"  class="btn btn-primary w-100 submitBtn">인증번호 요청</button><br>
				     </div>
			    </form>
			    <form action="controller?cmd=findPw" class="submitForm" method="post">
			       <div class="d-flex mb-3 mt-3">
                   	 <label class="searchLabel korFontMain">아이디</label>
                  	 <input type="text" class="form-control userInput" id="userId" placeholder="" name="userId">
                	</div>
				    <div class="d-flex mb-3">
				      <label class="searchLabel korFontMain" for="pwd">인증번호 </label>
				      <input type="text" class="form-control userInput" id="certNum" placeholder="" name="certNum">
				    </div>
			    <button type="submit" class="btn btn-primary w-100 submitBtn">비밀번호 찾기</button>
			  </form>
			</div>
			<div class="d-flex justify-content-around w-100" >
				<span class="descSpan">* 무작위 비밀번호가 이메일로 전송됩니다.</span>
			</div>
			<div class="d-flex justify-content-around w-100" >
				<input type="button" id="" class="btn btn-secondary cancelBtn" value="취소" onclick="history.back();">
			</div>
		</div>
	</div>
</body>
<style type="text/css">
	h1{
		text-align:center;
		min-width: 24%;
		font-family: 'Koulen', cursive;
		font-family: 'Nanum Gothic Coding', monospace;
		font-family: 'Roboto Mono', monospace;
	}
	label{
		min-width: 35%;
		text-align:center;
		font-size: 2vw;
		font-family: 'Koulen', cursive;
		font-family: 'Nanum Gothic Coding', monospace;
		font-family: 'Roboto Mono', monospace;
	}
	.submitBtn{
		background-color: #F1CDC1;
		border-color: #F1CDC1;
		font-weight: bolder;
		color: black;
		text-align:center;
		min-width: 24%;
		/***font-family: 'Koulen', cursive;
		font-family: 'Nanum Gothic Coding', monospace;
		font-family: 'Roboto Mono', monospace; */
		font-family: 'Nanum Myeongjo', serif;
	}
	.submitForm{
		margin: 10px 20px;
	}
	.userInput{
		background-color: #D1C7C5;
		border-color: #D1C7C5;
		font-size: 2vw;
		font-family: 'Koulen', cursive;
		font-family: 'Nanum Gothic Coding', monospace;
		font-family: 'Roboto Mono', monospace;
	}
	.viewContainer{
		width: 100vw;
		height: 100vh;
		background-color: #FFF8EB;
		background-image: url("img/findUser.png");
		background-size: cover;
	}
	.submitFormContainer{
		opacity: 0.8;
		background-color: #FFFFFF;
		width: 90vw;
		border-radius: 20px;
	}
	.descSpan{
		margin-top: 10px;
		font-size: 4vw;
	}
	.searchLabel{
		text-align:center;
		font-size: smaller;
	}
	hr{
		width: 90vw;
		border: 2px solid #000000;
	}
	.cancelBtn{
		background-color: #D1C7C5;
		opacity: 0.8;
		border: #D1C7C5;
		color: #473F3C;
		font-weight: bold;
		
	}
	
</style>
</html>