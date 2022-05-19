<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">  
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
</head>

<body>
	<div class="d-flex flex-column commonBackground justify-content-center align-items-center">
	  <button class="clickableBackground" type="button" onclick="location.href='controller?cmd=friendWriteListUI'">
		  <div class="card img-fluid  ">
		    <img class="card-img-top themeBtn" src="img/friend.jpg" alt="Card image" style="width:100%">
		    <div class="card-img-overlay flexRowBox">
		      <h4 class="card-title"><b>친구</b></h4>
		    </div>
		  </div>
	  </button>
	  <button class="clickableBackground" type="button" onclick="location.href='controller?cmd=rankingUI'">
		  <div class="card img-fluid  ">
		    <img class="card-img-top themeBtn" src="img/recommend.jpg" alt="Card image" style="width:100%">
		    <div class="card-img-overlay flexRowBox">
		      <h4 class="card-title"><b>실시간추천</b></h4>
		    </div>
		  </div>
	  </button>
	  <button class="clickableBackground" type="button" onclick="location.href='controller?cmd=newListUI'">
		  <div class="card img-fluid  ">
		    <img class="card-img-top themeBtn" src="img/new.jpg" alt="Card image" style="width:100%">
		    <div class="card-img-overlay flexRowBox">
		      <h4 class="card-title"><b>새로운</b></h4>
		    </div>
		  </div>
	  </button>
	  <button class="clickableBackground" type="button" onclick="location.href='controller?cmd=trendUI'">
		  <div class="card img-fluid  ">
		    <img class="card-img-top themeBtn" src="img/trend.jpg" alt="Card image" style="width:100%">
		    <div class="card-img-overlay flexRowBox">
		      <h4 class="card-title"><b>트렌드</b></h4>
		    </div>
		  </div>
	  </button>
	</div>

</body>
<style>
	body{
	background-image: url("img/mainback.png");
	background-attachment: fixed;
	}
    .clickableBackground{
		width:100%;
		height:100%;
		background-color: transparent;
		background-repeat: no-repeat;
		border: none;
		padding: 20px 10px;
	}	z
	.flexRowBox{
		display: flex;
		justify-content: center;
		align-items: center;
	}
	.commonBackground{
			background-image: url("img/mainback.png");
	background-attachment: fixed;
		height: 100vh;
		width: 100vw;
	}
	.themeBtn{
		width: 90vw;
		max-height: 20vh;
	}

</style>
</html>