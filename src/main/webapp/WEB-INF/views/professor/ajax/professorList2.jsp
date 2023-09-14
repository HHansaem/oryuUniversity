<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<table class="table table-hover"
	style="max-width: 1400px; margin: 0 auto;">
	<thead class="table-light">
		<tr>
			<th>번호</th>
			<th>교번</th>
			<th>학과</th>
			<th>이름</th>
			<th>주소</th>
			<th>전화번호</th>
			<th>이메일</th>
			<th>상태</th>
		</tr>
	</thead>
	<tbody>
		<c:set var="professorList" value="${paging.dataList }" />
		<c:if test="${empty professorList }">
			<tr>
				<td colspan="8">검색결과 없음.</td>
			</tr>
		</c:if>
		<c:if test="${not empty professorList }">
			<c:forEach items="${professorList }" var="professor">
				<c:url value="/professor/professorView.do" var="professorURL">
					<c:param name="who" value="${professor.prCd }" />
				</c:url>
				<tr>
					<td>${professor.rnum }</td>
					<td><a href="${professorURL }">${professor.prCd }</a></td>
					<td>${professor.dtNm }</td>
					<td>${professor.prNm }</td>
					<td>${professor.prAddr1 } ${professor.prAddr2 }</td>
					<td>${professor.prPh }</td>
					<td>${professor.prEmail }</td>
					<td>${professor.prStatus }</td>
				</tr>
			</c:forEach>
		</c:if>
	</tbody>
</table>
<div style="padding: 20px;">${paging.pagingHTML }</div>