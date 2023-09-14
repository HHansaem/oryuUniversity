<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> 
<div class="card box-shadow d-flex m-4" style="min-height: 87%;">
   <div class="h-100">
      <div class="custom-card">
         <div class="card-header" style="border-radius: 20px 20px 0 0; background-color:#154FA9; font-weight:bold; color:white;">동아리 상세보기</div>
         <div class="card-body">
<table class="table table-border">
	<!-- 동아리 상세 보기 -->

	<tr>
		<th>동아리 대표 성명</th>
		<td>${club.studentVO.stNm}</td>
	</tr>
	<tr>
		<th>동아리 대표 학번</th>
		<td>${club.stCd }</td>
	</tr>
	<tr>
		<th>동아리명</th>
		<td>${club.clubNm }</td>
	</tr>
	<tr>
		<th>동아리 지도 교수</th>
		<td>${club.professorVO.prNm }</td>
	</tr>
	<tr>
		<th>동아리 상태</th>
		<td>${club.clubStatus }</td>
	</tr>
	<tr>
		<th>동아리 설명</th>
		<td>${club.clubDetail }</td>
	</tr>
	<tr>
		<th>동아리 계획서</th>
		<td><pre style="background-color: white;">${club.clubPlan }</pre></td>
	</tr>
	


	<tr>
		<td colspan="2">
		<sec:authorize access="hasRole('ROLE_ST')" >
		<input class="btn btn-outline-success" type=button value="입부신청" id="ClubMemInsert"> 
		</sec:authorize>
		<input class="btn btn-outline-secondary" type=button value="뒤로가기" onclick="history.back();"></td>
	</tr>
</table>
</div>
</div>
</div>
</div>

<script>
$(ClubMemInsert).on("click",function(e){
    e.preventDefault();
    Swal.fire({
       title: '입부신청 하시겠습니까?',
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
         
        	  stuClubInsert();
       }
    });
 })




	function stuClubInsert() {
		window.location.href = "${pageContext.request.contextPath}/clubMember/clubInsertOn.do?what=${club.clubCd}";
	}
</script>

