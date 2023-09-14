<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<style>
	.error {
		color: red;
	}
	.mb-3 {
		margin-bottom: 1.6rem !important;
	}
</style>

<div class="card box-shadow d-flex m-4" style="min-height: auto;">
      <div class="h-100">
      <div class="card-header" style="border-radius: 20px 20px 0 0; background-color:#154FA9; font-weight:bold; color:white;">교수 정보 관리</div>
<form:form method="post" modelAttribute="professor"
	enctype="multipart/form-data"
	action="${pageContext.request.contextPath}/professor/professorUpdate.do">
	<div class="container mt-5">
		<div class="row">
			<div class="col-md-4">
				<!-- 교번 입력 -->
				<div class="mb-3">
					<label class="form-label">교번</label>
					<form:input path="prCd" class="form-control" oninput="hideErrorMessage('professorIdError')" readonly="true" />
					<form:errors path="prCd" class="error" />
					<span id="professorIdError" class="error"></span>
				</div>
				<!-- 학과 선택 -->
				<div class="mb-3">
					<label class="form-label">학과</label>
					<form:select path="dtCd" id="dtCdSelect" class="form-select"
						style="height: 46px; width: -webkit-fill-available;" oninput="hideErrorMessage('dtCdNotSelect')">
						<form:option value="" label="학과선택" />
						<form:options items="${departmentList }" itemLabel="dtNm"
							itemValue="dtCd" />
					</form:select>
					<form:errors path="dtCd" class="error" />
					<span id="dtCdNotSelect" class="error"></span>
				</div>
				<!-- 이름 입력 -->
				<div class="mb-3">
					<label class="form-label">이름</label>
					<form:input path="prNm" class="form-control" oninput="hideErrorMessage('professorNmError')" />
					<form:errors path="prNm" class="error" />
					<span id="professorNmError" class="error"></span>
				</div>
				<!-- 전화번호 입력 -->
				<div class="mb-3">
					<label class="form-label">전화번호</label>
					<form:input path="prPh" class="form-control" oninput="hideErrorMessage('professorPhError')" />
					<form:errors path="prPh" class="error" />
					<span id="professorPhError" class="error"></span>
				</div>
				<div class="mb-3" style="display: flex; margin-top: -17px; margin-bottom: 5px !important;">
					<div style="padding: 13.5px; display: flex; align-items: center;">
						<!-- 교수정보수정 버튼 -->
						<button type="submit"
							class="btn btn-outline-info narrow-modal-button ml-2"
							style="margin-right: 20px;"
							onclick="registerProfessorAndSubmitForm(event)">수정</button>
						<button type="button"
							class="btn btn-outline-danger narrow-modal-button ml-2"
							style="margin-right: 20px;"
							onclick="deleteProfessorAndSubmitForm(event)">삭제</button>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<!-- 주민등록번호 입력 -->
				<div class="mb-3">
					<label class="form-label">주민등록번호</label>
					<div class="input-group">
						<form:input path="prReg1" class="form-control" oninput="hideErrorMessage('professorRegError')" readonly="true" />
						<span class="input-group-text" style="background-color: white;">-</span>
						<form:input path="prReg2" class="form-control" readonly="true" />
					</div>
					<form:errors path="prReg1" class="error" />
					<span id="professorRegError" class="error"></span>
					<form:errors path="prReg2" class="error" />
				</div>
				<!-- 이메일 입력 -->
				<div class="mb-3">
					<label class="form-label">이메일</label>
					<form:input path="prEmail" type="email" class="form-control" oninput="hideErrorMessage('professorEmailError')" />
					<form:errors path="prEmail" class="error" />
					<span id="professorEmailError" class="error"></span>
				</div>
				<!-- 주소 입력 -->
				<div class="mb-3">
					<label class="form-label">주소</label>
					<div class="input-group">
						<form:input path="prAddr1" id="address" class="form-control" oninput="hideErrorMessage('professorAdd1Error')" />
						<button type="button" id="address_btn" class="btn btn-secondary">주소
							검색</button>
					</div>
					<form:errors path="prAddr1" class="error" />
					<span id="professorAdd1Error" class="error"></span>
				</div>
				<!-- 상세주소 입력 -->
				<div class="mb-3">
					<label class="form-label">상세주소</label>
					<form:input path="prAddr2" id="address_detail" class="form-control" oninput="hideErrorMessage('professorAdd2Error')" />
					<form:errors path="prAddr2" class="error" />
					<span id="professorAdd2Error" class="error"></span>
				</div>
			</div>
			<!-- 프로필사진 -->
			<div class="col-md-4">
				<label class="form-label">프로필사진</label>
				<div>
					<img id="imagePreview"
						src="<c:url value='/resources/profileImages/${professor.prPic }' />"
						style="max-width: 350px; max-height: 350px; border: 1px solid #ccc;">
				</div>
				<div class="mb-3">
					<input type="file" name="prImage" accept="image/*"
						class="form-control" onchange="previewImage(event)"
						style="margin-top: 22px;">
					<form:errors path="prPic" class="error" />
				</div>
			</div>
		</div>
	</div>
	<form:input path="prPass" type="hidden"/>
</form:form>
</div></div>
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
	function registerProfessorAndSubmitForm(event) {
		event.preventDefault();
		
		var department = document.getElementById("dtCdSelect").value;
		var professorId = document.getElementById("prCd").value;
		var professorNm = document.getElementById("prNm").value;
		var professorPh = document.getElementById("prPh").value;
		var professorReg = document.getElementById("prReg1").value;
		var professorEmail = document.getElementById("prEmail").value;
		var professorAdd1 = document.getElementById("address").value;
		var professorAdd2 = document.getElementById("address_detail").value;

		if (!professorId) {
		    document.getElementById("professorIdError").innerText = "교번을 입력해주세요." }
		if (!department) {
			document.getElementById("dtCdNotSelect").innerText = "학과를 선택해주세요." }
		if (!professorNm) {
			document.getElementById("professorNmError").innerText = "이름을 입력해주세요." }
		if (!professorPh) {
			document.getElementById("professorPhError").innerText = "번호를 입력해주세요." }
		if (!professorReg) {
			document.getElementById("professorRegError").innerText = "주민번호를 입력해주세요." }
		if (!professorEmail) {
			document.getElementById("professorEmailError").innerText = "이메일을 입력해주세요." }
		if (!professorAdd1) {
			document.getElementById("professorAdd1Error").innerText = "주소를 입력해주세요." }
		if (!professorAdd2) {
			document.getElementById("professorAdd2Error").innerText = "상세주소를 입력해주세요." }
		
		if (professorId && department && professorNm && 
				professorPh && professorReg && professorEmail &&
				professorAdd1 && professorAdd2) {
	        var form = $("form");
	        var formData = new FormData(form[0]);

	        $.ajax({
	            type: "POST",
	            url: form.attr("action"),
	            data: formData,
	            processData: false,
	            contentType: false,
	            success: function(response) {
	            	if(response == "ok") {
	            		Swal.fire({
	          			      icon: 'success',
	          			      title: '수정이 완료되었습니다.',
	          			      
	          			      confirmButtonColor: '#3085d6',
	          			      confirmButtonText: '확인'
	          			    });
	            	}else {
	            		Swal.fire({
	        			      icon: 'error',
	        			      title: '수정에 실패했습니다.',
	        			      
	        			      confirmButtonColor: '#3085d6',
	        			      confirmButtonText: '확인'
	        			    });
	            	}
	            },
	            error: function(xhr) {
	            	Swal.fire({
      			      icon: 'error',
      			      title: '수정에 실패했습니다.',
      			      
      			      confirmButtonColor: '#3085d6',
      			      confirmButtonText: '확인'
      			    });
	            }
	        });
	    }
	}
	
	function deleteProfessorAndSubmitForm(event) {
		event.preventDefault();
		var prCd = document.getElementById("prCd").value;
	
	    $.ajax({
	        type: "POST",
	        url: "${pageContext.request.contextPath}/professor/professorDelete.do",
	        data: {
	        	who: prCd
	        },
	        success: function(response) {
	            if (response.result == '삭제완료') {
	            	Swal.fire({
        			      icon: 'success',
        			      title: '삭제 처리가 완료되었습니다.',
        			      
        			      confirmButtonColor: '#3085d6',
        			      confirmButtonText: '확인'
        			    }).then(result => {
        			    	if(result.isConfirmed) {
	            				window.location.href = "${pageContext.request.contextPath}/professor/professorFrameList.do";
        			    	}
        			    })
	            }else {
	            	Swal.fire({
        			      icon: 'error',
        			      title: '삭제 처리 도중 오류가 발생했습니다.',
        			      
        			      confirmButtonColor: '#3085d6',
        			      confirmButtonText: '확인'
        			    });
	            }
	        },
	        error: function(xhr) {
	        	Swal.fire({
  			      icon: 'error',
  			      title: '삭제 처리 도중 오류가 발생했습니다.',
  			      
  			      confirmButtonColor: '#3085d6',
  			      confirmButtonText: '확인'
  			    });
	        }
	    });
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
	
	window.onload = function(){
	    document.getElementById("address_btn").addEventListener("click", function(){
	        new daum.Postcode({
	            oncomplete: function(data) {
	                document.getElementById("address").value = data.address;
	                document.getElementById("address_detail").focus();
	            }
	        }).open();
	    });
	}
	
</script>