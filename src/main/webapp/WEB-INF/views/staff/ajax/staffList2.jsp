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
			<th>직번</th>
			<th>부서</th>
			<th>이름</th>
			<th>주소</th>
			<th>전화번호</th>
			<th>이메일</th>
			<th>상태</th>
		</tr>
	</thead>
	<tbody>
		<c:set var="staffList" value="${paging.dataList }" />
		<c:if test="${empty staffList }">
			<tr>
				<td colspan="8">검색결과 없음.</td>
			</tr>
		</c:if>
		<c:if test="${not empty staffList }">
			<c:forEach items="${staffList }" var="staff">
				<c:url value="/staff/staffView.do" var="staffURL">
					<c:param name="who" value="${staff.tsCd }" />
				</c:url>
				<tr>
					<td>${staff.rnum }</td>
					<td><a href="${staffURL }">${staff.tsCd }</a></td>
					<td>${staff.tsDep }</td>
					<td>${staff.tsNm }</td>
					<td>${staff.tsAddr1 } ${staff.tsAddr2 }</td>
					<td>${staff.tsPh }</td>
					<td>${staff.tsEmail }</td>
					<td>${staff.tsStatus }</td>
				</tr>
			</c:forEach>
		</c:if>
	</tbody>
</table>
<div style="padding: 20px;">${paging.pagingHTML }</div>