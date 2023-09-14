<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<div class="card box-shadow d-flex m-4" style="min-height: 87%;">
   <div class="h-100">
      <div class="custom-card">
         <div class="card-header" style="border-radius: 20px 20px 0 0; background-color:#154FA9; font-weight:bold; color:white;">신청서 작성</div>
         <div class="card-body">
<form:form method="post" modelAttribute="internAPC" enctype="multipart/form-data">
	<table class="table table-border" style="margin-left: 109px;
    width: 84%;">	
			<c:if test="${not empty internAPC.inteCd }">
				<tr hidden="true">
					<th>신청한 인턴십 코드</th>
				<td><input type="hidden" name="inteCd" value="${internAPC.inteCd}" readonly>${intern.inteCd}</td>
			</tr>
			</c:if>
			
			<c:if test="${not empty internAPC.iaCd }">
			<tr hidden="true">
				<th>신청코드</th>
			<td><input type="text" name="iaCd" value="${internAPC.iaCd}" readonly></td>
			</tr>
			</c:if>
			<tr>
				<th>프로필사진</th>
				<td><img src="<c:url value='/resources/profileImages/${internAPC.studentVO.stFic }'/>" /></td>
			</tr>
			<tr>
				<th>학번</th>
				<td><input type="hidden" name="stCd" value="${internAPC.studentVO.stCd }" readonly>${internAPC.studentVO.stCd }</td>
			</tr>
			<tr>
				<th>학과</th>
				<td>${internAPC.departmentVO.dtNm }</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>${internAPC.studentVO.stNm }</td>
			</tr>
			<tr>
				<th>주민등록번호</th>
				<td>${internAPC.studentVO.stReg1 } - ${internAPC.studentVO.stReg2 }</td>
			</tr>
			<tr>
				<th>주소</th>
				<td>${internAPC.
				studentVO.stAddr1 } ${internAPC.studentVO.stAddr2 }</td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td>${internAPC.studentVO.stPh }</td>
			</tr>
			<tr>
				<th>이메일</th>
				<td>${internAPC.studentVO.stEmail }</td>
			</tr>
			
			
			<tr>
				<th>지원 목적 및 동기</th>
			<td><form:textarea path="iaPur" id="iaPur" class="form-control" />
				<form:errors path="iaPur" class="error" /></td>
			</tr>
			
			<tr>
				<th>졸업 후 계획</th>
			<td><form:textarea path="iaCou" id="iaCou" class="form-control" />
				<form:errors path="iaCou" class="error" /></td>
			</tr>
			<tr>
			<td colspan="2">
				<input id="auto" class="btn btn-outline-info" style=" border-radius: 10px;" type="button" value="자동완성기능">
				<input class="btn btn-outline-success" id="internshipAPC" type="submit" value="작성완료"> 
				<input class="btn btn-outline-danger" type="reset"value="취소" onclick="history.back();">
			</td>
		</tr>
		</table>
</form:form>
</div>
</div>
</div>
</div>
<script>
$(document).ready(function () {
$(internshipAPC).on("click",function(e){
    e.preventDefault();
    Swal.fire({
       title: '인턴십 신청서를 등록하시겠습니까?',
       //text: '다시 되돌릴 수 없습니다. 신중하세요.',
       icon: 'question',
       
       showCancelButton: true, // cancel버튼 보이기. 기본은 원래 없음
       confirmButtonColor: '#3085d6', // confrim 버튼 색깔 지정
       cancelButtonColor: '#d33', // cancel 버튼 색깔 지정
       confirmButtonText: '등록', // confirm 버튼 텍스트 지정
       cancelButtonText: '취소', // cancel 버튼 텍스트 지정
       
       reverseButtons: false, // 버튼 순서 거꾸로
       
    }).then(result => {
       // 만약 Promise리턴을 받으면,
       if (result.isConfirmed) { // 만약 모달창에서 confirm 버튼을 눌렀다면
          Swal.fire('신청서가 등록되었습니다.', '', 'success').then(()=>{
             $(internAPC).submit();
          });
       }
    });
 })
$("#auto").on("click", function(){
	        const iaPur = document.getElementById('iaPur');
	        const iaCou = document.getElementById('iaCou');
	        
	        iaPur.value = "환경 문제에 대한 관심과 열정으로 인해 한온시스템에서 일하고자 합니다. 회사의 지속 가능한 에너지 솔루션을 통해 지구 환경을 보호하고 개선하는데 기여하고 싶습니다.";
	        iaCou.value="장기적으로는 한온시스템에서의 경험을 토대로 에너지 분야에서의 전문가로 성장하고 국제적으로 활동할 수 있는 기회를 모색하고 있습니다. 한온시스템은 그런 목표를 이루기 위한 충분한 플랫폼과 성장 환경을 제공할 것으로 생각합니다.";
	    });
}); 
</script>
