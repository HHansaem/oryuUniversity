<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!-- 받거나 신청한 동아리 목록 -->

<style>
th{
width: 10%;
}

</style>

<div class="card box-shadow d-flex m-4" style="min-height: 87%;">
   <div class="h-100">
      <div class="custom-card">
         <div class="card-header" style="border-radius: 20px 20px 0 0; background-color:#154FA9; font-weight:bold; color:white;">개설신청한 동아리 목록</div>
         <div class="card-body">
<table class="table table-border" style="margin-left: 109px; width: 84%;">
	<thead>
		<tr>
			<th>학번</th>
			<th>학생이름</th>
			<th>당당교수</th>
			<th>동아리이름</th>
			<th>동아리상태</th>
		</tr>
	</thead>
<c:if test="${empty club }">
	<sec:authorize access="hasRole('ROLE_ST')"><!-- 학생 -->
    <tr>
        <td colspan="5">개설 신청한 동아리 없음</td>
    </tr>
	</sec:authorize>
<sec:authorize access="hasRole('ROLE_TS')"><!-- 교직원 -->
    <tr>
        <td colspan="5">개설신청 받은 동아리 없음</td>
    </tr>
</sec:authorize>
<sec:authorize access="hasRole('ROLE_PR')"><!-- 교수 -->
    <tr>
        <td colspan="5">개설신청 받은 동아리 없음</td>
    </tr>
</sec:authorize>
</c:if>
	<c:if test="${not empty club }">
		<c:forEach items="${club }" var="club"><!-- club이 비어있지 않는다면 리스트 출력 -->
			<tr>
				<!-- 선택한 club으로 이동 -->
				<td><a href="${pageContext.request.contextPath}/club/clubInsertRequestView.do?who=${club.clubCd}" data-who="${club.clubCd}">${club.stCd}</a></td>
				<td>${club.studentVO.stNm }</td>
				<td>${club.professorVO.prNm }</td>
				<td>${club.clubNm }</td>
				<td>
				<c:choose>
							<c:when test="${club.clubStatus eq '신청'}">
								<span class="badge badge-primary"> <c:out
												value="신청" />
								</span>
							</c:when>
							<c:when test="${club.clubStatus eq '확인'}">
								<span class="badge badge-info"> <c:out value="확인" />
								</span>
							</c:when>
							<c:when test="${club.clubStatus eq '승인'}">
								<span class="badge badge-success"> <c:out value="승인" />
								</span>
							</c:when>
							<c:when test="${club.clubStatus eq '거절'}">
								<span class="badge badge-danger"> <c:out
									value="거절" />
								</span>
							</c:when>
						</c:choose>
				
				</td>
			</tr>
		</c:forEach>
	</c:if>
</table>
</div>
</div>
</div>
</div>

<script type="text/javascript">

if ("${message}")
{
        Swal.fire({
           title: "${message}",
           //text: '다시 되돌릴 수 없습니다. 신중하세요.',
           icon: 'warning',
           
           confirmButtonColor: '#3085d6', // confrim 버튼 색깔 지정
           confirmButtonText: '확인', // confirm 버튼 텍스트 지정
        })
     
  }

</script>
