<!-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
  <script type="text/javascript" src="js/jquery-3.6.0.js"></script>
  
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Koulen&family=Roboto+Mono:ital,wght@1,300&display=swap" rel="stylesheet">
  <link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Koulen&family=Nanum+Gothic+Coding&family=Roboto+Mono:ital,wght@1,300&display=swap" rel="stylesheet">
<script type="text/javascript">

var rememberCheck = function(e){
	var rememberCheck = $('#remember').is(':checked');
	
	if ($('#remember').is(':checked')) {
		e.action="controller?cmd=loginAction&rememberCheck="+rememberCheck;
	}else{
		e.action="controller?cmd=loginAction&rememberCheck="+rememberCheck;
	}
}

</script>
<title>Insert title here</title>
</head>
<body>
	<div class="d-flex flex-column justify-content-center align-items-center viewContainer">
		<div class="d-flex flex-column justify-content-center align-items-center">
			<div class="d-flex flex-column justify-content-center align-items-center">
				<h1><b>How Are You?</b></h1>
				<h5>당신의 오늘은 어땠나요?</h5><br>
				<h1><b>Log-In</b></h1>
			</div>
			<div class="p-2 container mt-3 submitFormContainer">
			  <form action="controller?cmd=loginAction" class="submitForm" method="post" onsubmit="rememberCheck(this)" name="frm">	<!-- **** -->
			    <div class="d-flex mb-3 mt-3">
			      <!-- <label for="id">ID</label> -->
			      <input type="text" class="form-control userInput" id="id" placeholder="ID" name="id">
			    </div>
			    <div class="d-flex mb-3">
			      <!-- <label for="pwd">PW </label> -->
			      <input type="password" class="form-control userInput" id="pw" placeholder="PASSWORD" name="pw">
			    </div>
			    <!--<div class="d-flex form-check mb-3">
			      <label class="form-check-label">
			          <input class="form-check-input loginCheck" type="checkbox" name="remember" id="remember"> 로그인 상태 유지 
			      </label>
			    </div>-->
			    <button type="submit" class="btn btn-primary w-100 submitBtn">로그인</button>
			  </form>
			</div>
			<div class="d-flex justify-content-around w-100" >
				<button type="button" class="btn linkBtn linkBtnCustom" onclick="location.href='controller?cmd=addUserUI'">회원가입</button>
				<button type="button" class="btn linkBtn" onclick="location.href='controller?cmd=findUserUI'">ID/PW 찾기</button>
			</div>
		</div>
	</div>
</body>

<style type="text/css">
	
	h1{
		font-family: 'Koulen', cursive;
		font-family: 'Roboto Mono', monospace;
	}
	label{
		min-width: 24%;
		text-align:center;
		font-family: 'Koulen', cursive;
		font-family: 'Nanum Gothic Coding', monospace;
		font-family: 'Roboto Mono', monospace;
	}
	.submitBtn{
		background-color: #F1CDC1;
		border-color: #F1CDC1;
		font-weight: bolder;
		color: black;
		font-family: 'Koulen', cursive;
		font-family: 'Nanum Gothic Coding', monospace;
		font-family: 'Roboto Mono', monospace;
	}
	.submitForm{
		margin: 10px 20px;
	}
	.userInput{
		background-color: #D1C7C5;
		border-color: #D1C7C5;
	}
	.viewContainer{
		width: 100vw;
		height: 100vh;
		background-color: #FFF8EB;
		background-image: url("img/login.png");
		background-size: cover;
	}
	.submitFormContainer{
		border-radius: 20px;
		background-color: #FFFFFF;
		width: 90vw;
		opacity: 0.8;
		
	}
	.linkBtn{
		margin-top: 20px;
		background-color: #D1C7C5;
		border-color: #D1C7C5;
		opacity: 0.8;
		font-family: 'Koulen', cursive;
		font-family: 'Nanum Gothic Coding', monospace;
		font-family: 'Roboto Mono', monospace;
	}
</style>
</html>