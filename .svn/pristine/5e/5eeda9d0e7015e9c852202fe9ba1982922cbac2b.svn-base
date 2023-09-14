<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<style>
.mb-3 {
		margin-bottom: 1.6rem !important;
	}
</style>
<div class="card box-shadow d-flex m-4" style="min-height: auto;">
      <div class="h-100">
      <div class="card-header" style="border-radius: 20px 20px 0 0; background-color:#154FA9; font-weight:bold; color:white;">Mypage</div>
<form:form method="post" modelAttribute="professor"
	enctype="multipart/form-data" >
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
					<form:input path="dtNm" class="form-control" readonly="true" />
					<form:errors path="dtCd" class="error" />
					<span id="dtCdNotSelect" class="error"></span>
				</div>
				<!-- 이름 입력 -->
				<div class="mb-3">
					<label class="form-label">이름</label>
					<form:input path="prNm" class="form-control" oninput="hideErrorMessage('professorNmError')" readonly="true" />
					<form:errors path="prNm" class="error" />
					<span id="professorNmError" class="error"></span>
				</div>
				<!-- 전화번호 입력 -->
				<div class="mb-3">
					<label class="form-label">전화번호</label>
					<form:input path="prPh" class="form-control" oninput="hideErrorMessage('professorPhError')" readonly="true" />
					<form:errors path="prPh" class="error" />
					<span id="professorPhError" class="error"></span>
				</div>
				<div class="mb-3" style="display: flex; margin-top: -17px; margin-bottom: 5px !important;">
					<div style="padding: 13.5px; display: flex; align-items: center;">
						<!-- 교수정보수정 버튼 -->
						<button type="button" data-bs-toggle="modal" data-bs-target="#exampleModal"
							class="btn btn-outline-info narrow-modal-button ml-2"
							style="margin-right: 20px;">수정</button>
						<input type="button" value="뒤로" class="btn btn-outline-secondary"
							onclick="history.back();">
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
					<form:input path="prEmail" type="email" class="form-control" oninput="hideErrorMessage('professorEmailError')" readonly="true" />
					<form:errors path="prEmail" class="error" />
					<span id="professorEmailError" class="error"></span>
				</div>
				<!-- 주소 입력 -->
				<div class="mb-3">
					<label class="form-label">주소</label>
					<div class="input-group">
						<form:input path="prAddr1" id="address" class="form-control" oninput="hideErrorMessage('professorAdd1Error')" readonly="true" />
					</div>
					<form:errors path="prAddr1" class="error" />
					<span id="professorAdd1Error" class="error"></span>
				</div>
				<!-- 상세주소 입력 -->
				<div class="mb-3">
					<label class="form-label">상세주소</label>
					<form:input path="prAddr2" id="address_detail" class="form-control" oninput="hideErrorMessage('professorAdd2Error')" readonly="true" />
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
			</div>
		</div>
	</div>
</form:form>
</div></div>

<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog custom-modal-size">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">비밀번호 입력</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body" style="padding-bottom: 0px; padding-top: 25px;">
        <form>
          <div class="mb-3">
          	<input id="pass" class="form-control" type="password" >
          </div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-outline-info" id="confirm">확인</button>
        <button type="button" class="btn btn-outline-secondary" data-bs-dismiss="modal">취소</button>
      </div>
    </div>
  </div>
</div>

<script>
$(document).ready(function() {
    $("#confirm").click(function() {
        // 모달 내의 입력 값을 가져오기
        var password = $("#pass").val();
		var prCd = $("#prCd").val();
        
        // AJAX 요청 보내기
        $.ajax({
            type: "POST",
            url: "${pageContext.request.contextPath}/mypage/professorUpdateCheck.do",
            data: {
            	who: prCd,
                password: password
            },
            success: function(response) {
            	if(response.result === "일치") {
            		Swal.fire({
        			      icon: 'success',
        			      title: '비밀번호가 확인되었습니다.',
        			      
        			      confirmButtonColor: '#3085d6',
        			      confirmButtonText: '확인'
        			    }).then(result => {
        			    	if(result.isConfirmed) {
            					window.location.href = "${pageContext.request.contextPath}/mypage/professorMypageEdit.do?who=" + prCd;
        			    	}
        			    })
            	}else {
            		Swal.fire({
        			      icon: 'error',
        			      title: '비밀번호가 일치하지 않습니다.',
        			      
        			      confirmButtonColor: '#3085d6',
        			      confirmButtonText: '확인'
        			    });
            		$("#pass").val(""); // 입력란 비우기
            	}
            },
            error: function(jqXHR, textStatus, errorThrown) {
                console.error("AJAX 오류: " + errorThrown);
            }
        });
    });
});
</script>