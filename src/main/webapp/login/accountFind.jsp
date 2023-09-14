<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/js/bootstrap5/css/bootstrap.min.css">
<script src="<%=request.getContextPath() %>/resources/js/jquery-3.7.0.min.js"></script>
<style>
	.btn-custom{
		font-size: small;
		margin-left: 10px;
	}
</style>
</head>
<body>
	<div class="p-2">
		<p class="h3" style="padding-left:10px;">비밀번호 찾기</p>
		<form class="form-control" id="checkForm">
			<label class="form-label">아이디</label>
			<input type="text" class="form-control" name="userId"/>
			<label class="form-label">전화번호</label>
			<div class="d-flex align-items-center justify-content-end">
				<div style="width:65%">
					<input type="text" class="form-control" name="userPH"/>
				</div>
				<div class="d-flex justify-content-end" style="width:35%">
					<button type="button" class="btn btn-outline-primary btn-custom" onclick="checkUser()">인증번호전송</button>
				</div>	
			</div>
			<div style="display:none;" id="authCheck">
				<label class="form-label">인증번호</label>
				<input type="text" class="form-control" name="authNum"/>
			</div>
		</form>
		<div class="d-flex justify-content-end align-items-center mt-2">
			<span style="display:none;margin-right:10px;color:#0d6efd;" id="check">존재하지 않는 사용자입니다.</span>
		</div>
	</div>
</body>
</html>
<script>
	function checkUser(){
		var info = $("#checkForm").serializeArray();
		var url = "${pageContext.request.contextPath}/userFind.do";
		 $.ajax({
             type: "POST", // 또는 GET 등 사용할 HTTP 메서드 선택
             data: info,
             url: url,
             success: function(response) {
            	 if(response=='성공'){
            		 $("#check").text("인증번호가 전송되었습니다.");
            		 $("#authCheck").css("display","block");
            		 $("#check").css("display","inline");
            		 setTimeout(function() {
            			    $("#check").css("display", "none");
            		 }, 3000);
            		 
            	 }else if(response=='실패'){
            		 $("#check").css("display","inline");
            		 setTimeout(function() {
            			    $("#check").css("display", "none");
            		 }, 3000);
            	 }
             },
             error: function(xhr, status, error) {
                 console.error(error);
             }
         });
		
		
	}
	
</script>