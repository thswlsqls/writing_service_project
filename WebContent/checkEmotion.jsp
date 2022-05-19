 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- 구글웹폰트 나눔명조 bold 700 -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Koulen&family=Nanum+Gothic+Coding:wght@400;700&family=Nanum+Myeongjo:wght@700&family=Roboto+Mono:ital@1&display=swap" rel="stylesheet">


<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript" src="js/jquery-3.6.0.js"></script>
<!-- 부트스트랩 아이콘 -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">


<script type="text/javascript">

var sendEmotionName = function(e){
   
   var emotionName = $(e).val();
   
   window.location.href="controller?cmd=insertEmpathy" + "&emotionName=" + emotionName;
      
}
$( document ).ready( function(){
   $("#refresh").click(function(){
      
      $.ajax({
         url : "controller?cmd=refreshEmotionAction",
         type : "post",
          success : function(resp){
             
             var jsonResponse = JSON.parse(resp);
             var key = Object.values(jsonResponse);
            $("#btn0").val(key[0]);
            $("#btn1").val(key[1]);
            $("#btn2").val(key[2]);
            $("#btn3").val(key[3]);
            $("#btn4").val(key[4]);
            $("#btn5").val(key[5]);
            $("#btn6").val(key[6]);
            $("#btn7").val(key[7]);
            
          },error:function(){
            alert("통신실패");
         }
       });
   });   
   
});


   
</script>

<title>Insert title here</title>
<style type="text/css">
@import url("https://fonts.googleapis.com/css?family=Poppins:200,300,400,500,600,700,800,900&display=swap");
.w-btn {
    position: relative;
    border: none;
    display: inline-block;
    padding: 15px 20px;
    border-radius: 15px;
    font-family: "paybooc-Light", sans-serif;
    box-shadow: 0 15px 35px rgba(0, 0, 0, 0.2);
    text-decoration: none;
    font-weight: 600;
    transition: 0.25s;
    
    width: 35vw;
    
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

</style>
</head>
<body>
<a href="controller?cmd=logoutAction" class="logout">logout</a>

<div class="d-flex flex-column justify-content-center align-items-center viewImgContainer">
   <div class="d-flex p-3 justify-content-center align-items-center ">
      <h4 class="p-2 chooseEmotionH2">당신의 오늘은 어땠나요?</h4>
      <i class="bi bi-arrow-clockwise" id = "refresh" style="color:#6B6967; font-weight: bold;"> </i>
      
      <!-- <button type="button" class="btn btn-renew" id = "refresh">새로고침</button> -->
   </div>

   <div class="d-flex flex-column justify-content-around  align-content-around chooseBtnContainer">
      <div class="d-flex p-3 justify-content-between align-items-center text-white chooseBtnFlexRow">
         <div class="d-flex p-3 justify-content-center align-items-center   chooseBtnFlexBox"><!-- **** -->               
            <!--  <input name = "emotionName" type="button" class="btn btn-info chooseBtnPos" value="${emotions[0]}" onclick="sendEmotionName(this)" id="btn0"> -->
            <input name = "emotionName" class="w-btn w-btn-pos" type="button" value="${emotions[0]}" onclick="sendEmotionName(this)" id="btn0" />
         </div>
           <div class="d-flex p-3 justify-content-center align-items-center   chooseBtnFlexBox">
              <input  type="button" class="w-btn w-btn-pos" value="${emotions[1]}" onclick="sendEmotionName(this)" id="btn1">
           </div>
      </div>
      <div class="d-flex p-3 justify-content-between align-items-center text-white chooseBtnFlexRow">
         <div class="d-flex p-3 justify-content-center align-items-center   chooseBtnFlexBox">
            <input type="button" class="w-btn w-btn-pos" value="${emotions[2]}" onclick="sendEmotionName(this)" id="btn2">
         </div>
           <div class="d-flex p-3 justify-content-center align-items-center   chooseBtnFlexBox">
              <input type="button" class="w-btn w-btn-pos" value="${emotions[3]}" onclick="sendEmotionName(this)" id="btn3">
           </div>
        </div>
      <div class="d-flex p-3 justify-content-between align-items-center text-white chooseBtnFlexRow">
         <div class="d-flex p-3 justify-content-center align-items-center   chooseBtnFlexBox">
            <input type="button" class="w-btn w-btn-nag" value="${emotions[4]}" onclick="sendEmotionName(this)" id="btn4">
         </div>
           <div class="d-flex p-3 justify-content-center align-items-center   chooseBtnFlexBox">
            <input type="button" class="w-btn w-btn-nag" value="${emotions[5]}" onclick="sendEmotionName(this)" id="btn5">
         </div>
      </div>
      <div class="d-flex p-3 justify-content-between align-items-center text-white chooseBtnFlexRow">
         <div class="d-flex p-3 justify-content-center align-items-center   chooseBtnFlexBox">
            <input type="button" class="w-btn w-btn-nag" value="${emotions[6]}" onclick="sendEmotionName(this)" id="btn6">
         </div>
           <div class="d-flex p-3 justify-content-center align-items-center   chooseBtnFlexBox">
            <input type="button" class="w-btn w-btn-nag" value="${emotions[7]}" onclick="sendEmotionName(this)" id="btn7">
         </div>
      </div>
   
   </div>
</div>

</body>
<style>
   .viewImgContainer{
      width: 100vw;
      height: 100vh;
      background-image: url('https://t1.daumcdn.net/cfile/tistory/99FF67355F6CD15C02');
      background-image: url('img/checkEmotionBack.png');
   }
   .chooseBtnContainer{
      width: 90vw;
      height: 80vh;
   }
   .chooseEmotionH2{
      color: #6B6967;
      font-size: 5vw;
      font-family: 'Nanum Myeongjo', serif;
   }
   .btn-renew{
      font-size: smaller;
      height: 50%;
      padding-top: 2px;
      color: black;
      text-align: center;
      background-color: #FEB7FF;
   }
   .chooseBtnFlexRow{
      padding:0px;
      width: 100%;
      min-height:20%; 
   }
   .chooseBtnFlexBox{
      padding:0px;
      min-width: 50%;
      height: 100%;
   }
   .chooseBtnPos{
      width:100%;
      height:100%;
      color: black;
      /*background-color: #82E5FB;*/
      background-color: #FFF8EB;
      border-color: #FFF8EB;
   }
   .chooseBtnNag{
      width:100%;
      height:100%;
      color: black;
      /*background-color: #FFC7C7;*/
      background-color: #FFF8EB;
      border-color: #FFF8EB;
   }
   .homeBtn{
      width: 40%;
      color: black;
      background-color: #C4C4C4;
   }
   .logout{
   	  position: absolute;
   	  top: 15px;
   	  right: 20px;
   	  text-decoration: none;
   	  color: #4D4948;
   }
   .logout:hover{
   	letter-spacing: 2px;
    transform: scale(1.2);
    cursor: pointer;
   }
   
</style>
</html>