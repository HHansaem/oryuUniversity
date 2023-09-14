<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<style>
.error {
	color: red;
}
.gradInfo {
	background-color: rgba(0, 0, 0, 0.03);
	margin: 10px;
	padding-right: 40px;
	font-family: 'Noto Sans KR', sans-serif;
}

.gradInfo-header {
	margin: 15px 0 11px 40px;
	font-size: 14px;
	font-weight: bold;
}
.gradInfo-body {
	margin: -13px 40px 5px 40px;
	font-size: 12px;
}
.circle {
    width: 4px;
    height: 4px;
    background-color: black;
    border-radius: 50%;
    display: inline-block;
    margin: 0 12px 3px 6px;
}
.narrow-modal-button {
	width: 100px; /* 원하는 가로폭을 지정 */
    padding: 7px; /* 원하는 패딩을 지정 */
    margin: -1px 10px 2px 10px;
    float: right;
}
</style>

<div class="card gradInfo">
	<div class="gradInfo-header">
		<i class="mdi mdi-check-circle" style="color: green;"></i> 교직원정보 등록
		<hr style="border-color: black; margin-bottom: 0.7rem; margin-top: 0.7rem;">
	</div>
	<div class="gradInfo-body">
		<button type="button" class="btn btn-outline-info narrow-modal-button" style="width: 110px;" onclick="registerStaffAndSubmitForm(event)">교직원 등록</button>
	    <div class="circle"></div> 오른쪽의 버튼을 통해 교직원정보를 등록할 수 있습니다.<br>
	    <div class="circle"></div> 하단의 리스트에서 교직원정보를 조회 및 관리할 수 있습니다.
	</div>
</div>

<form:form method="post" modelAttribute="staff"
	enctype="multipart/form-data"
	action="${pageContext.request.contextPath}/staff/staffInsert.do">
	<div class="container mt-3">
		<div class="row">
			<div class="col-md-4">
				<!-- 직번 입력 -->
				<div class="mb-3">
					<label class="form-label">직번</label>
					<form:input path="tsCd" class="form-control" oninput="hideErrorMessage('staffIdError')" />
					<form:errors path="tsCd" class="error" />
					<span id="staffIdError" class="error"></span>
				</div>
				<!-- 부서 선택 -->
				<div class="mb-3">
					<label class="form-label">부서</label>
					<form:select path="tsDep" id="tsDepSelect" class="form-select"
						style="height: 46px; width: -webkit-fill-available;" oninput="hideErrorMessage('tsDepNotSelect')">
						<form:option value="" label="부서선택" />
						<form:option value="행정" label="행정" />
						<form:option value="학사" label="학사" />
					</form:select>
					<form:errors path="tsDep" class="error" />
					<span id="tsDepNotSelect" class="error"></span>
				</div>
				<!-- 이름 입력 -->
				<div class="mb-3">
					<label class="form-label">이름</label>
					<form:input path="tsNm" class="form-control" oninput="hideErrorMessage('staffNmError')" />
					<form:errors path="tsNm" class="error" />
					<span id="staffNmError" class="error"></span>
				</div>
				<!-- 전화번호 입력 -->
				<div class="mb-3">
					<label class="form-label">전화번호</label>
					<form:input path="tsPh" class="form-control" oninput="hideErrorMessage('staffPhError')" />
					<form:errors path="tsPh" class="error" />
					<span id="staffPhError" class="error"></span>
				</div>
				<!-- 주민등록번호 입력 -->
				<div class="mb-3">
					<label class="form-label">주민등록번호</label>
					<div class="input-group">
						<form:input path="tsReg1" class="form-control" oninput="hideErrorMessage('staffRegError')" />
						<span class="input-group-text">-</span>
						<form:input path="tsReg2" class="form-control" />
					</div>
					<form:errors path="tsReg1" class="error" />
					<span id="staffRegError" class="error"></span>
					<form:errors path="tsReg2" class="error" />
				</div>
			</div>
			<div class="col-md-4">
				<!-- 이메일 입력 -->
				<div class="mb-3">
					<label class="form-label">이메일</label>
					<form:input path="tsEmail" type="email" class="form-control" oninput="hideErrorMessage('staffEmailError')" />
					<form:errors path="tsEmail" class="error" />
					<span id="staffEmailError" class="error"></span>
				</div>
				<!-- 주소 입력 -->
				<div class="mb-3">
					<label class="form-label">주소</label>
					<div class="input-group">
						<form:input path="tsAddr1" id="address" class="form-control" oninput="hideErrorMessage('staffAdd1Error')" />
						<button type="button" id="address_btn" class="btn btn-secondary">주소
							검색</button>
					</div>
					<form:errors path="tsAddr1" class="error" />
					<span id="staffAdd1Error" class="error"></span>
				</div>
				<!-- 상세주소 입력 -->
				<div class="mb-3">
					<label class="form-label">상세주소</label>
					<form:input path="tsAddr2" id="address_detail" class="form-control" oninput="hideErrorMessage('staffAdd2Error')" />
					<form:errors path="tsAddr2" class="error" />
					<span id="staffAdd2Error" class="error"></span>
				</div>
				<!-- 비밀번호 입력 -->
				<div class="mb-3">
					<label class="form-label">비밀번호</label>
					<form:input path="tsPass" id="tsPass" type="password"
						class="form-control" oninput="hideErrorMessage('staffPassError')" />
					<form:errors path="tsPass" class="error" />
					<span id="staffPassError" class="error"></span>
				</div>
				<!-- 비밀번호 확인 입력 -->
				<div class="mb-3">
					<label class="form-label">비밀번호 확인</label> <input id="tsPassConfirm"
						type="password" class="form-control" /> <span
						id="passwordMatchError" class="error"></span>
				</div>
			</div>
			<!-- 프로필사진 -->
			<div class="col-md-4">
				<label class="form-label">프로필사진</label>
				<div>
					<img id="imagePreview"
						src="<c:url value='/resources/images/user.jpg' />"
						style="max-width: 350px; max-height: 350px; border: 1px solid #ccc;">
				</div>
				<div class="mb-3">
					<input type="file" name="tsImage" accept="image/*"
						class="form-control" onchange="previewImage(event)"
						style="margin-top: 22px;">
					<form:errors path="tsFic" class="error" />
				</div>
			</div>
		</div>
	</div>
</form:form>
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
	function registerStaffAndSubmitForm(event) {
		event.preventDefault();
		
		var department = document.getElementById("tsDepSelect").value;
		var password = document.getElementById("tsPass").value;
		var passwordConfirm = document.getElementById("tsPassConfirm").value;
		var staffId = document.getElementById("tsCd").value;
		var staffNm = document.getElementById("tsNm").value;
		var staffPh = document.getElementById("tsPh").value;
		var staffReg = document.getElementById("tsReg1").value;
		var staffEmail = document.getElementById("tsEmail").value;
		var staffAdd1 = document.getElementById("address").value;
		var staffAdd2 = document.getElementById("address_detail").value;

		if (!staffId) {
		    document.getElementById("staffIdError").innerText = "직번을 입력해주세요." }
		if (!department) {
			document.getElementById("tsDepNotSelect").innerText = "부서를 선택해주세요." }
		if (!staffNm) {
			document.getElementById("staffNmError").innerText = "이름을 입력해주세요." }
		if (!staffPh) {
			document.getElementById("staffPhError").innerText = "번호를 입력해주세요." }
		if (!staffReg) {
			document.getElementById("staffRegError").innerText = "주민번호를 입력해주세요." }
		if (!staffEmail) {
			document.getElementById("staffEmailError").innerText = "이메일을 입력해주세요." }
		if (!staffAdd1) {
			document.getElementById("staffAdd1Error").innerText = "주소를 입력해주세요." }
		if (!staffAdd2) {
			document.getElementById("staffAdd2Error").innerText = "상세주소를 입력해주세요." }
		if (!password) {
			document.getElementById("staffPassError").innerText = "비밀번호를 입력해주세요." }
		
		if (password !== passwordConfirm) {
			Swal.fire({
			      icon: 'warning',
			      title: '비밀번호가 일치하지 않습니다',
			      
			      confirmButtonColor: '#3085d6',
			      confirmButtonText: '확인'
			    });
			return;
			}
		
		if (staffId && department && staffNm && 
				staffPh && staffReg && staffEmail &&
				staffAdd1 && staffAdd2 && password) {
	        var form = $("form");
	        var formData = new FormData(form[0]);

	        $.ajax({
	            type: "POST",
	            url: form.attr("action"),
	            data: formData,
	            processData: false,
	            contentType: false,
	            success: function(response) {
	            	if(response.result=='중복'){
	            		Swal.fire({
		      			      icon: 'warning',
		      			      title: '직번이 중복됩니다.',
		      			      
		      			      confirmButtonColor: '#3085d6',
		      			      confirmButtonText: '확인'
		      			    });
	            	}else if(response.result=='성공'){
	            		fetchstaff();
	            		fetchstaffForm();
	            		setTimeout(function(){
	            			Swal.fire({
		          			      icon: 'success',
		          			      title: '교직원 정보가 등록되었습니다.',
		          			      
		          			      confirmButtonColor: '#3085d6',
		          			      confirmButtonText: '확인'
		          			    });
	            		}, 100);
	            	}else{
	            		Swal.fire({
	          			      icon: 'error',
	          			      title: '교직원 정보 등록에 실패했습니다.',
	          			      
	          			      confirmButtonColor: '#3085d6',
	          			      confirmButtonText: '확인'
	          			    });
	            	}
	            },
	            error: function(xhr) {
	            	Swal.fire({
        			      icon: 'error',
        			      title: '교직원 정보 등록에 실패했습니다.',
        			      
        			      confirmButtonColor: '#3085d6',
        			      confirmButtonText: '확인'
        			    });
	            }
	        });
	    }
	}
	
	// 이미지 미리보기 함수
	function previewImage(event) {
		var defaultProfileImageURL = "<c:url value='/resources/images/user.jpg' />";
		var imagePreview = document.getElementById("imagePreview");
		var file = event.target.files[0];

		if (file) {
			var reader = new FileReader();
			reader.onload = function(e) {
				imagePreview.src = e.target.result;
			};
			reader.readAsDataURL(file);
		} else {
			imagePreview.src = defaultProfileImageURL;
		}
	}
	
	function hideErrorMessage(elementId) {
	    document.getElementById(elementId).innerText = ""; // 오류 메시지 내용을 비움
	}
	
</script>