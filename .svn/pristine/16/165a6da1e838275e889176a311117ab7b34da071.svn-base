<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<form:form method="post" modelAttribute="lecture" enctype="multipart/form-data">
  <div class="form-group row">
    <label for="exampleInputUsername2" class="col-sm-3 col-form-label">강의코드</label>
    <div class="col-sm-9">
      <input type="text" class="form-control" id="exampleInputUsername2" placeholder="Username">
    </div>
  </div>
  <div class="form-group row">
    <label for="exampleInputEmail2" class="col-sm-3 col-form-label">Email</label>
    <div class="col-sm-9">
      <input type="email" class="form-control" id="exampleInputEmail2" placeholder="Email">
    </div>
  </div>
  <div class="form-group row">
    <label for="exampleInputMobile" class="col-sm-3 col-form-label">Mobile</label>
    <div class="col-sm-9">
      <input type="text" class="form-control" id="exampleInputMobile" placeholder="Mobile number">
    </div>
  </div>
  <div class="form-group row">
    <label for="exampleInputPassword2" class="col-sm-3 col-form-label">Password</label>
    <div class="col-sm-9">
      <input type="password" class="form-control" id="exampleInputPassword2" placeholder="Password">
    </div>
  </div>
  <div class="form-group row">
    <label for="exampleInputConfirmPassword2" class="col-sm-3 col-form-label">Re Password</label>
    <div class="col-sm-9">
      <input type="password" class="form-control" id="exampleInputConfirmPassword2" placeholder="Password">
    </div>
  </div>
  <div class="form-check form-check-flat form-check-primary">
    <label class="form-check-label">
      <input type="checkbox" class="form-check-input">
      Remember me
    <i class="input-helper"></i></label>
  </div>
  <button type="submit" class="btn btn-primary mr-2">Submit</button>
  <button class="btn btn-light">Cancel</button>
</form:form>
<script>
var $prCd = $('[name="prCd"]');
// 폼 제출 전에 비율의 합이 100인지 검증하는 함수
document.querySelector("form").addEventListener("submit", function (event) {
    const grMid = parseInt(document.querySelector('input[name="grMid"]').value);
    const grFinal = parseInt(document.querySelector('input[name="grFinal"]').value);
    const grAttend = parseInt(document.querySelector('input[name="grAttend"]').value);
    const grAssi = parseInt(document.querySelector('input[name="grAssi"]').value);

    const totalRatio = grMid + grFinal + grAttend + grAssi;
    if (totalRatio !== 100) {
        event.preventDefault(); // 폼 제출 막기
        alert("중간고사 비율, 기말고사 비율, 출석비율, 과제비율의 합은 100이어야 합니다.");
    }
});
// 강의요청
$("#submitBtn").click(function() {
	event.preventDefault();
	
	const subjCd = $("select[name='subjCd']").val(); // 과목코드
	const prCd = $prCd.val();// 교번
	const lecLectTitle = $("input[name='lecLectTitle']").val(); // 강의명
	const lecGraCd = $("select[name='lecGraCd']").val(); // 학년코드
	const lecSemeCd = $("select[name='lecSemeCd']").val(); // 학기코드
	const lecLectCred = $("select[name='lecLectCred']").val(); // 강의학점
	const lecEnroLimit = $("input[name='lecEnroLimit']").val(); // 제한인원
	const lecLectDivision = $("input[name='lecLectDivision']").val(); // 강의분반
	const grMid = $("input[name='grMid']").val(); // 중간고사비율
	const grFinal = $("input[name='grFinal']").val(); // 기말고사비율
	const grAttend = $("input[name='grAttend']").val(); // 참석비율
	const grAssi = $("input[name='grAssi']").val(); // 과제비율
	const lectureFiles = document.querySelector('input[name="lectureFiles"]').files[0]; // 강의계획서 파일

    if (!subjCd) {
        errorMessage += "과목코드를 선택해주세요.\n";
    }
    if (!prCd) {
        errorMessage += "교번을 선택해주세요.\n";
    }
    if (!lecLectTitle) {
        errorMessage += "강의명을 입력해주세요.\n";
    }
    if (!lecGraCd) {
        errorMessage += "학년을 선택해주세요.\n";
    }
    if (!lecSemeCd) {
        errorMessage += "학기를 선택해주세요.\n";
    }
    if (!lecLectCred) {
        errorMessage += "강의학점을 선택해주세요.\n";
    }
    if (!lecEnroLimit) {
        errorMessage += "제한인원을 입력해주세요.\n";
    }
    if (!lecLectDivision) {
        errorMessage += "강의분반을 입력해주세요.\n";
    }
    if (!grMid) {
        errorMessage += "중간고사 비율을 입력해주세요.\n";
    }
    if (!grFinal) {
        errorMessage += "기말고사 비율을 입력해주세요.\n";
    }
    if (!grAttend) {
        errorMessage += "출석 비율을 입력해주세요.\n";
    }
    if (!grAssi) {
        errorMessage += "과제 비율을 입력해주세요.\n";
    }
    if (!lectureFiles) {
        errorMessage += "강의계획서 파일을 선택해주세요.\n";
    }
    
	const formData = new FormData();
	
	formData.append("subjCd", subjCd);
	formData.append("prCd", prCd);
	formData.append("lecLectTitle", lecLectTitle);
	formData.append("lecGraCd", lecGraCd);
	formData.append("lecSemeCd", lecSemeCd);
	formData.append("lecLectCred", lecLectCred);
	formData.append("lecEnroLimit", lecEnroLimit);
	formData.append("lecLectDivision", lecLectDivision);
	formData.append("grMid", grMid);
	formData.append("grFinal", grFinal);
	formData.append("grAttend", grAttend);
	formData.append("grAssi", grAssi);
	formData.append("lectureFiles", lectureFiles);
	
	$.ajax({
		url: "/oryuUniversity/lecture/lectureRequest.do",
		type: "post",
		data: formData,
		contentType: false,
		processData: false,
		success: function(response) {
		    if (response === "ok") {
		    	alert("강의요청 완료, 강의목록으로 돌아갑니다.")
		        window.location.href = "<%=request.getContextPath()%>/lecture/prfLectureList.do";
			} else {
				alert("강의등록 실패")
			}
		},
	error : function(error) {
		alert(error);
	}
	});
});
// 강의수정
$("#submitBtn2").click(function(event) {
    event.preventDefault();

    const lecCd = "${lecture.lecCd}"; // 강의코드
    const subjCd = $("select[name='subjCd']").val(); // 과목코드
    const prCd = $prCd.val(); // 교번
    const lecLectTitle = $("input[name='lecLectTitle']").val(); // 강의명
    const lecGraCd = $("select[name='lecGraCd']").val(); // 학년코드
    const lecSemeCd = $("select[name='lecSemeCd']").val(); // 학기코드
    const lecLectCred = $("select[name='lecLectCred']").val(); // 강의학점
    const lecEnroLimit = $("input[name='lecEnroLimit']").val(); // 제한인원
    const lecLectDivision = $("input[name='lecLectDivision']").val(); // 강의분반
    const grMid = $("input[name='grMid']").val(); // 중간고사비율
    const grFinal = $("input[name='grFinal']").val(); // 기말고사비율
    const grAttend = $("input[name='grAttend']").val(); // 참석비율
    const grAssi = $("input[name='grAssi']").val(); // 과제비율
    const lectureFiles = document.querySelector('input[name="lectureFiles"]').files[0]; // 강의계획서 파일

    // 에러 메시지 출력을 위한 변수
    let errorMessage = "";

    // 필수 조건 검사
    if (!lecCd) {
        errorMessage += "강의코드가 없습니다.\n";
    }
    if (!subjCd) {
        errorMessage += "과목코드를 선택해주세요.\n";
    }
    if (!prCd) {
        errorMessage += "교번을 선택해주세요.\n";
    }
    if (!lecLectTitle) {
        errorMessage += "강의명을 입력해주세요.\n";
    }
    if (!lecGraCd) {
        errorMessage += "학년을 선택해주세요.\n";
    }
    if (!lecSemeCd) {
        errorMessage += "학기를 선택해주세요.\n";
    }
    if (!lecLectCred) {
        errorMessage += "강의학점을 선택해주세요.\n";
    }
    if (!lecEnroLimit) {
        errorMessage += "제한인원을 입력해주세요.\n";
    }
    if (!lecLectDivision) {
        errorMessage += "강의분반을 입력해주세요.\n";
    }
    if (!grMid) {
        errorMessage += "중간고사 비율을 입력해주세요.\n";
    }
    if (!grFinal) {
        errorMessage += "기말고사 비율을 입력해주세요.\n";
    }
    if (!grAttend) {
        errorMessage += "출석 비율을 입력해주세요.\n";
    }
    if (!grAssi) {
        errorMessage += "과제 비율을 입력해주세요.\n";
    }
    if (!lectureFiles) {
        errorMessage += "강의계획서 파일을 선택해주세요.\n";
    }

    // 모든 조건을 검사해서 에러가 있으면 메시지 출력 후 폼 제출 막음
    if (errorMessage) {
        alert(errorMessage);
    } else {
        const formData = new FormData();
        formData.append("lecCd", lecCd); // 강의코드 추가
        formData.append("subjCd", subjCd);
        formData.append("prCd", prCd);
        formData.append("lecLectTitle", lecLectTitle);
        formData.append("lecGraCd", lecGraCd);
        formData.append("lecSemeCd", lecSemeCd);
        formData.append("lecLectCred", lecLectCred);
        formData.append("lecEnroLimit", lecEnroLimit);
        formData.append("lecLectDivision", lecLectDivision);
        formData.append("grMid", grMid);
        formData.append("grFinal", grFinal);
        formData.append("grAttend", grAttend);
        formData.append("grAssi", grAssi);
        formData.append("lectureFiles", lectureFiles);

        $.ajax({
            url: "/oryuUniversity/lecture/lectureUpdate.do",
            type: "post",
            data: formData,
            contentType: false,
            processData: false,
            success: function(response) {
                if (response === "ok") {
                    alert("강의수정 완료, 강의목록으로 돌아갑니다.");
                    window.location.href = "<%=request.getContextPath()%>/lecture/prfLectureList.do";
                } else {
                    alert("강의수정 실패");
                }
            },
            error: function(error) {
                alert("강의수정 중 오류가 발생했습니다.");
                console.error(error);
            }
        });
    }
});
</script>
