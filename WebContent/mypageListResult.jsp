<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
     <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" src="js/jquery-3.6.0.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
    <script type="text/javascript">
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
    
    
<c:forEach var="l" items = "${list}" varStatus="status">

   
	   <div class="row mypage-text fontcss" style="text-align: center;">
	      <div class="col-5 aa" >${l.writeDate}</div>
	      <div class="col-4 aa" ><a class="aTag" href='controller?cmd=boardDetailUI&writeNo=${l.getWriteNo()}'>${l.suggestionName}</a></div>
	      <div class="col-3 aa"><button type="button" id='btn${status.index}' value="${l.getWriteNo()}" name="${l.getWriteNo()}" class="btn btn-primary btn-sm modalBtn" data-bs-toggle="modal" data-bs-target="#myModal">-</button>
	      	<span class="status" id='spn${status.index}' title="spn${status.index}">A</span>
	      </div>					
	   </div>
	   <br>   
   

</c:forEach>
