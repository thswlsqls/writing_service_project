<!-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- 구글웹폰트 나눔명조 bold 700 -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Koulen&family=Nanum+Gothic+Coding:wght@400;700&family=Nanum+Myeongjo:wght@700&family=Roboto+Mono:ital@1&display=swap" rel="stylesheet">
  
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript" src="js/jquery-3.6.0.js"></script>

<script type="text/javascript">
 var idSpaceCheck = function(data) {
	var pattern = /\s/gi;
	data = data.replace(pattern, "");
	$("#id").val(data);
	return data;
}
 var pwSpaceCheck = function(data) {
	var pattern = /\s/gi;
	data = data.replace(pattern, "");
	$("#nickName").val(data);
	return data;
}
</script>

<style type="text/css">
	.korFontMain{
		font-family: 'Nanum Myeongjo', serif;
	}
</style>
 
<title>Insert title here</title>
</head>
<body>
	<div class="d-flex flex-column justify-content-center align-items-center viewContainer">
			  <form action="controller?cmd=addUserAction" class="submitForm" method="post">
		<div class="d-flex flex-column justify-content-center align-items-center">
			<div class="d-flex flex-column justify-content-center align-items-center">
				<h1><b class="korFontMain">회원가입</b></h1>
			</div>
			<div class="p-2 container mt-3 submitFormContainer">
			    <div class="d-flex mb-3 mt-3">
			      <label for="id">*ID</label>
			      <input type="text" class="form-control userInput" id="id" placeholder="8~15자 영,숫자 포함" name="id" pattern="[a-zA-Z0-9]{8,15}" autocomplete="off">
			      
			      <span id="checkResult1" style="width: 45%"></span>

			    </div>
			    <div class="d-flex mb-3 mt-3">
			      <label for="name" class="korFontMain">*이름</label>
			      <input type="text" class="form-control userInput" id="name" placeholder="2~10자 특수문자 불가" name="name" pattern="[[ㄱ-ㅎ|가-힣|a-z|A-Z|]]" autocomplete="off">
			    </div>
			    <div class="d-flex mb-3">
			      <label for="pwd">*PW </label>
			      <input type="password" class="form-control userInput" id="pw" placeholder="8~15자 영,숫자 필수 포함" name="pw" pattern="[a-zA-Z0-9]{8,15}" autocomplete="off">
			    </div>
			    <div class="d-flex mb-3">
			      <label for="pwdCheck" class="pwChkLabel ">PW check </label>
			      <input type="password" class="form-control userInput" id="pw1" placeholder="8~15자 영,숫자 필수 포함" name="pw1" pattern="[a-zA-Z0-9]{8,15}" autocomplete="off">
			    </div>
			    <div class="d-flex mb-3">
			      <label for="pwdCheck" class=" korFontMain">*필명 </label>
			      <input type="text" class="form-control userInput" id="nickName" placeholder="2~10자 특수문자 불가" name="nickName" pattern="{2,10}" autocomplete="off">
			      <span id="checkResult2" style="width: 45%"></span>
			    </div>
			    <div class="d-flex mb-3">
			      <label for="pwdCheck" class=" korFontMain">*이메일 </label>
			      <input type="text" class="form-control userInput"  placeholder="" id="emailId" name="emailId" autocomplete="off">
			      @
			      <select class="form-select userInput" name="domain">
					<option value="@naver.com">naver.com</option>
					<option value="@gmail.com">gmail.com</option>
				    <option value="@daum.net">daum.net</option>
				  </select>
			    </div>
			    <div class="d-flex mb-3">
			      <label for="pwdCheck" class=" korFontMain">전화번호 </label>
			      <input type="text" class="form-control userInput" id="tel" placeholder="-없이 숫자만 입력" name="tel" autocomplete="off">
			    </div>
			    <div class="d-flex form-check mb-3 desc">
			      <span class="" style="width: 100%; text-align:right; font-size: 2vw;">‘*’는 필수 입력사항입니다.</span>
			    </div>
			</div>
			<br>
			<div class="btnGroupRowBox">
				<input type="submit" id="reg_submit" class="btn btn-secondary submitBtn" value="가입완료">
				<input type="button" id="" class="btn btn-secondary cancelBtn" value="취소" onclick="history.back();">
			</div>
		</div>
		</form>
	</div>

 <script type="text/javascript">
//아이디 유효성 검사
	$("#id").blur(function() {
		var user_id = idSpaceCheck($("#id").val());//공백제거
		
		$.ajax({
			url : "controller?cmd=checkIdAction",
			type: "post",
			data : {userId : user_id},
			success : function(resp) {
				
				jsonResponse = JSON.parse(resp);
				
				if (jsonResponse == false) {
					// 중복아이디
					$("#checkResult1").html("사용불가");
					$("#checkResult1").css("color", "red");
					$("#checkResult1").css("font-size", "12pt");
					$("#checkResult1").css("font-weight", "bold");
					$("#reg_submit").attr("disabled", true);
					
				}else if(jsonResponse==true){
					if (user_id.length ==0) {
						$("#checkResult1").html("ID입력");
						$("#checkResult1").css("color", "red");
						$("#checkResult1").css("font-size", "12pt");
						$("#checkResult1").css("font-weight", "bold");
						$("#reg_submit").attr("disabled", true);
					}else{
						$("#checkResult1").html("사용가능");
						$("#checkResult1").css("color", "green");
						$("#checkResult1").css("font-size", "12pt");
						$("#checkResult1").css("font-weight", "bold");
						$("#reg_submit").attr("disabled", false);
					}
				}
			},
			error:function(){
				alert("통신실패");
			}
		});
	});

</script>

<script type="text/javascript">
//필명 유효성 검사
	$("#nickName").blur(function() {
		var nickName = pwSpaceCheck($("#nickName").val());//공백제거
		
		$.ajax({
			url : "controller?cmd=checkPenNameAction",
			type: "post",
			data : {penName : nickName},
			success : function(resp) {
				
				jsonResponse = JSON.parse(resp);
				
				if (jsonResponse == false) {
					// 중복아이디
					$("#checkResult2").html("사용불가");
					$("#checkResult2").css("color", "red");
					$("#checkResult2").css("font-size", "12pt");
					$("#checkResult2").css("font-weight", "bold");
					$("#reg_submit").attr("disabled", true);
					
				}else if(jsonResponse==true){
					if (nickName.length ==0) {
						$("#checkResult2").html("필명입력");
						$("#checkResult2").css("color", "red");
						$("#checkResult2").css("font-size", "12pt");
						$("#checkResult2").css("font-weight", "bold");
						$("#reg_submit").attr("disabled", true);
					}else{
						$("#checkResult2").html("사용가능");
						$("#checkResult2").css("color", "green");
						$("#checkResult2").css("font-size", "12pt");
						$("#checkResult2").css("font-weight", "bold");
						$("#reg_submit").attr("disabled", false);
					}
				}
			},
			error:function(){
				alert("통신실패");
			}
		});
	});

</script>
	
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
		text-align:center;
		min-width: 24%;
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
		opacity: 0.8;
	}
	.submitForm{
		margin: 10px 20px;
	}
	.userInput{
		background-color: #D1C7C5;
		border-color: #D1C7C5;
		font-size: 3vw;
		font-weight: bold;
		font-family: 'Koulen', cursive;
		font-family: 'Nanum Gothic Coding', monospace;
		font-family: 'Roboto Mono', monospace;
	}
	.viewContainer{
		width: 100vw;
		height: 100vh;
		background-color: #FFF8EB;
		background-image: url("img/addUser.png");
		background-size: cover;
	}
	.submitFormContainer{
		opacity: 0.8;
		background-color: #FFFFFF;
		width: 90vw;
		border-radius: 20px;
	}
	.checkDuplBtn{
		background-color: #C4C4C4;
		border-color: #C4C4C4;
		color: black;
		font-weight: bolder;
		margin-left: 10px;
		font-size: 2vw;
		min-width: 25%;
	}
	.pwChkLabel{
		text-align:center;
		font-size: smaller;
	}
	.cancelBtn{
		background-color: #D1C7C5;
		opacity: 0.8;
		border: #D1C7C5;
		color: #473F3C;
		font-weight: bold;
	}
	.btnGroupRowBox{
		display: flex;
		width: 100%;
		justify-content: space-around;
		
	}
	.desc{
		font-weight: bold;
	}
</style>
</html>