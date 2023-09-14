<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!-- 동아리 개설 신청서 작성 -->
<style>
th {
	width: 10%;
}
</style>

<div class="card box-shadow d-flex m-4" style="min-height: 87%;">
	<div class="h-100">
		<div class="custom-card">
			<div class="card-header"
				style="border-radius: 20px 20px 0 0; background-color: #154FA9; font-weight: bold; color: white;">동아리
				개설 신청서 작성</div>
			<div class="card-body">
				<form:form method="post" modelAttribute="club">
					<table class="table table-border"
						style="margin-left: 109px; width: 84%;">
						<!-- 학생 -->
						<tr>
							<th>동아리 대표 성명</th>
							<td><input type="hidden" name="clubCd" value="${info.stNm}"
								readonly> ${info.stNm}</td>
							<th>동아리 대표 학번</th>
							<td><input type="hidden" name="StCd" value="${info.stCd}"
								readonly> ${info.stCd}</td>
						</tr>
						<tr>
							<th>동아리명</th>
							<td style="width: 30px;"><input style="width: 85%;"
								class="form-control" type="text" name="clubNm"
								value="${clubNm }" /><span class="error">${errors["clubNm"]}</span></td>
							<th>동아리 지도 교수</th>
							<td style="width: 20px;">
								<div class="row">
									<button type="button" style="width: 25%;"
										class="btn btn-primary narrow-modal-button" id="openModalBtn"
										data-bs-toggle="modal" data-bs-target="#exampleModal"
										data-bs-whatever="@getbootstrap">동아리 지도 교수 검색</button>
									<input style="width: 39%; margin-left: 13px;"
										class="form-control" type="text" name="professorVO.prNm"
										value="${professorVO.prNm }" readonly /><span class="error">${errors["professorVO.prNm"]}</span>
								</div>
							</td>
						</tr>
						<tr>
							<th>동아리 계획서</th>
							<td colspan="3"><textarea
									class="form-control form-control-lg" rows="5" id="clubPlan"
									name="clubPlan">${clubPlan }</textarea> <span class="error">${errors["clubPlan"]}</span></td>
						</tr>

						<tr>
							<th>동아리 설명</th>
							<td colspan="3">
							<textarea class="form-control form-control-lg" rows="5" id="clubDetail" name="clubDetail">${clubDetail }</textarea>
							<span class="error">${errors["clubDetail"]}</span></td>
						</tr>

<!-- 						<tr> -->
<!-- 							<th>동아리 상태</th> -->
<!-- 							<td colspan="3"> -->
							<input type="hidden" name="clubStatus" value="신청">
<!-- 							<select name="clubStatus"> <option value="신청">개설신청</option> -->
<!-- 							</select> -->
<!-- 							</td> -->
<!-- 						</tr> -->
						<tr>
							<td colspan="4">
							<input class="btn btn-outline-success" type="submit" id="clubReqInsert" value="확인"> 
							<input class="btn btn-outline-danger" type="reset" value="취소" onclick="history.back();"></td>
						</tr>
					</table>
				</form:form>
			</div>
		</div>
	</div>
</div>
<c:url value="/club/profeSearch.do" var="viewURL" />

<div class="modal fade" data-url="${viewURL }" id="exampleModal"
	tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">

	<div
		class="modal-dialog custom-modal-size modal-dialog-scrollable modal-xl">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">동아리 담당 가능한 교수 찾기</h5>
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<div class="modal-body"></div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary"
					id="confirmProfessorBtn" data-bs-dismiss="modal">확인</button>
				<button type="button" class="btn btn-secondary"
					data-bs-dismiss="modal">취소</button>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">

$(clubReqInsert).on("click",function(e){
    e.preventDefault();
    Swal.fire({
       title: '동아리개설 신청을 하시겠습니까?',
       //text: '다시 되돌릴 수 없습니다. 신중하세요.',
       icon: 'question',
       
       showCancelButton: true, // cancel버튼 보이기. 기본은 원래 없음
       confirmButtonColor: '#3085d6', // confrim 버튼 색깔 지정
       cancelButtonColor: '#d33', // cancel 버튼 색깔 지정
       confirmButtonText: '신청', // confirm 버튼 텍스트 지정
       cancelButtonText: '취소', // cancel 버튼 텍스트 지정
       
       reverseButtons: false, // 버튼 순서 거꾸로
       
    }).then(result => {
       // 만약 Promise리턴을 받으면,
       if (result.isConfirmed) { // 만약 모달창에서 confirm 버튼을 눌렀다면
          Swal.fire('동아리개설 신청이 완료되었습니다.', '', 'success').then(()=>{
             $(club).submit();
          });
       }
    });
 })


$(document).ready(function() {
    $(exampleModal).on("show.bs.modal", function(event) {
        let $modalBody = $(this).find(".modal-body");
        let viewURL = this.dataset['url'];

        let settings = {
            url: viewURL,
            dataType: "html",
            success: function(resp) {
                $modalBody.html(resp);

                // 모달 내부에서 교수 선택 시 해당 교수 이름을 변수에 저장
                let selectedProfessorName = "";
                $modalBody.on("click", ".professor-select", function() {
                    selectedProfessorName = $(this).data("professor-name");
                });

                // 모달 내부의 "확인" 버튼이 클릭되었을 때 처리
                $(document).on("click", "#confirmProfessorBtn", function() {
                    if (selectedProfessorName !== "") {
                    	$("[name=professorVO.prNm]")=$("#professorNameDisplay").text(selectedProfessorName);
                    }
                    console.log("들어온지 확인 : " + $("#professorNameDisplay").text());
                	console.log("교수 이름 확인 : "+$("input[name='professorVO.prNm']").val($("#professorNameDisplay").text()));
                	
                });
            }
        };

        $.ajax(settings);
    }).on("hidden.bs.modal", function(event) {
        let $modalBody = $(this).find(".modal-body");
        $modalBody.empty();
    });
});


</script>

