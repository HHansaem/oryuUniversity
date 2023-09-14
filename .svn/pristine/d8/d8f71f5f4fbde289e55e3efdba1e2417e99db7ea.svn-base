<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<style>
	.error {
		color: red;
	}
</style>
<div class="card box-shadow d-flex m-4" style="min-height: auto;">
      <div class="h-100">
      <div class="card-header" style="border-radius: 20px 20px 0 0; background-color:#154FA9; font-weight:bold; color:white;">Mypage (수정)</div>
<form:form method="post" modelAttribute="student"
	enctype="multipart/form-data"
	action="${pageContext.request.contextPath}/mypage/studentUpdate.do">
	<div class="container mt-5">
		<div class="row">
			<div class="col-md-4">
				<!-- 학번 입력 -->
				<div class="mb-3">
					<label class="form-label">학번</label>
					<form:input path="stCd" class="form-control" oninput="hideErrorMessage('studentIdError')" readonly="true" />
					<form:errors path="stCd" class="error" />
					<span id="studentIdError" class="error"></span>
				</div>
				<!-- 학과 선택 -->
				<div class="mb-3">
					<label class="form-label">단과 / 학과</label>
					<label class="form-control" readonly="true">${student.colgeNm } / ${student.dtNm }</label>
					<form:input path="dtNm" class="form-control" readonly="true" type="hidden" />
					<form:errors path="dtCd" class="error" />
					<input type="hidden" name="dtCd" value="${student.dtCd }">
					<span id="dtCdNotSelect" class="error"></span>
				</div>
				<!-- 이름 입력 -->
				<div class="mb-3">
					<label class="form-label">이름</label>
					<form:input path="stNm" class="form-control" oninput="hideErrorMessage('studentNmError')" readonly="true" />
					<form:errors path="stNm" class="error" />
					<span id="studentNmError" class="error"></span>
				</div>
				<!-- 주민등록번호 입력 -->
				<div class="mb-3">
					<label class="form-label">주민등록번호</label>
					<div class="input-group">
						<form:input path="stReg1" class="form-control" oninput="hideErrorMessage('studentRegError')" readonly="true" />
						<span class="input-group-text" style="background-color: white;">-</span>
						<form:input path="stReg2" class="form-control" readonly="true" />
					</div>
					<form:errors path="stReg1" class="error" />
					<span id="studentRegError" class="error"></span>
					<form:errors path="stReg2" class="error" />
				</div>
				<!-- 전화번호 입력 -->
				<div class="mb-3">
					<label class="form-label">전화번호</label>
					<form:input path="stPh" class="form-control" oninput="hideErrorMessage('studentPhError')" />
					<form:errors path="stPh" class="error" />
					<span id="studentPhError" class="error"></span>
				</div>
				<div class="mb-3" style="display: flex; margin-top: -11px; margin-bottom: 5px !important;">
					<div style="padding: 13.5px; display: flex; align-items: center;">
						<!-- 학생정보수정 버튼 -->
						<button type="button"
							class="btn btn-outline-info narrow-modal-button ml-2"
							style="margin-right: 20px;"
							onclick="updateStudentAndSubmitForm(event)">수정</button>
						<input type="button" value="뒤로" class="btn btn-outline-secondary"
							onclick="history.back();">
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<!-- 이메일 입력 -->
				<div class="mb-3">
					<label class="form-label">이메일</label>
					<form:input path="stEmail" type="email" class="form-control" oninput="hideErrorMessage('studentEmailError')" />
					<form:errors path="stEmail" class="error" />
					<span id="studentEmailError" class="error"></span>
				</div>
				<!-- 주소 입력 -->
				<div class="mb-3">
					<label class="form-label">주소</label>
					<div class="input-group">
						<form:input path="stAddr1" id="address" class="form-control" oninput="hideErrorMessage('studentAdd1Error')" />
						<button type="button" id="address_btn" class="btn btn-secondary">주소
							검색</button>
					</div>
					<form:errors path="stAddr1" class="error" />
					<span id="studentAdd1Error" class="error"></span>
				</div>
				<!-- 상세주소 입력 -->
				<div class="mb-3">
					<label class="form-label">상세주소</label>
					<form:input path="stAddr2" id="address_detail" class="form-control" oninput="hideErrorMessage('studentAdd2Error')" />
					<form:errors path="stAddr2" class="error" />
					<span id="studentAdd2Error" class="error"></span>
				</div>
				<!-- 비밀번호 입력 -->
				<div class="mb-3">
					<label class="form-label">비밀번호</label>
					<input id="stPass" name="stPass"  type="password"
						class="form-control" oninput="hideErrorMessage('studentPassError')" />
					<form:errors path="stPass" class="error" />
					<span id="studentPassError" class="error"></span>
				</div>
				<!-- 비밀번호 확인 입력 -->
				<div class="mb-3">
					<label class="form-label">비밀번호 확인</label> <input id="stPassConfirm"
						type="password" class="form-control" /> <span
						id="passwordMatchError" class="error"></span>
				</div>
			</div>
			<!-- 프로필사진 -->
			<div class="col-md-4">
				<label class="form-label">프로필사진</label>
				<div>
					<img id="imagePreview"
						src="<c:url value='/resources/profileImages/${student.stFic }'/>"
						style="max-width: 350px; max-height: 350px; border: 1px solid #ccc;">
				</div>
				<div class="mb-3">
					<input type="file" name="stImage" accept="image/*"
						class="form-control" onchange="previewImage(event)"
						style="margin-top: 22px;">
					<form:errors path="stFic" class="error" />
				</div>
			</div>	
		</div>
	</div>
</form:form>
</div></div>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>

function updateStudentAndSubmitForm(event) {
	
	var password = document.getElementById("stPass").value;
	var passwordConfirm = document.getElementById("stPassConfirm").value;
	var studentPh = document.getElementById("stPh").value;
	var studentEmail = document.getElementById("stEmail").value;
	var studentAdd1 = document.getElementById("address").value;
	var studentAdd2 = document.getElementById("address_detail").value;

	if (!studentPh) {
		document.getElementById("studentPhError").innerText = "번호를 입력해주세요." }
	if (!studentEmail) {
		document.getElementById("studentEmailError").innerText = "이메일을 입력해주세요." }
	if (!studentAdd1) {
		document.getElementById("studentAdd1Error").innerText = "주소를 입력해주세요." }
	if (!studentAdd2) {
		document.getElementById("studentAdd2Error").innerText = "상세주소를 입력해주세요." }
	if (!password) {
		document.getElementById("studentPassError").innerText = "비밀번호를 입력해주세요." }
	
	if (password !== passwordConfirm) {
		Swal.fire({
		      icon: 'warning',
		      title: '비밀번호가 일치하지 않습니다',
		      
		      confirmButtonColor: '#3085d6',
		      confirmButtonText: '확인'
		    });
		return;
		}
	
	if (studentPh && studentEmail &&
			studentAdd1 && studentAdd2 && password) {
        var form = $("form");
        var formData = new FormData(form[0]);

        $.ajax({
            type: "POST",
            url: form.attr("action"),
            data: formData,
            processData: false,
            contentType: false,
            success: function(response) {
            	if(response.result=='수정완료'){
            		Swal.fire({
      			      icon: 'success',
      			      title: '수정이 완료되었습니다.',
      			      
      			      confirmButtonColor: '#3085d6',
      			      confirmButtonText: '확인'
      			    }).then(result => {
      			    	if(result.isConfirmed) {
            				window.location.href = "${pageContext.request.contextPath}/mypage/studentView.do";
      			    	}
      			    })
            	}else {
            		Swal.fire({
      			      icon: 'error',
      			      title: '정보 수정 중 오류가 발생했습니다.',
      			      
      			      confirmButtonColor: '#3085d6',
      			      confirmButtonText: '확인'
      			    });
            	}
            },
            error: function(xhr) {
            	Swal.fire({
  			      icon: 'error',
  			      title: '정보 수정 중 오류가 발생했습니다.',
  			      
  			      confirmButtonColor: '#3085d6',
  			      confirmButtonText: '확인'
  			    });
            }
        });
    }
}

//이미지 미리보기 함수
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
    
    document.getElementById("stPassConfirm").addEventListener("keyup", function() {
        var password = document.getElementById("stPass").value;
        var passwordConfirm = this.value;

        if (password !== passwordConfirm) {
            document.getElementById("passwordMatchError").innerText = "비밀번호가 일치하지 않습니다.";
        } else {
            document.getElementById("passwordMatchError").innerText = "비밀번호가 일치합니다.";
            document.getElementById("passwordMatchError").style.color = "blue";
        }
    });
}
</script>