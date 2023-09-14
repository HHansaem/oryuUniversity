<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<table class="table">
<tr><td><h4><br>학사 일정 목록</h4></td></tr>
</table>
<table class="table">
	<tr>
		<th>일정명</th>
		<td>${acaSchedule.asNm }</td>
	</tr>
	<tr>
		<th>구분</th>
		<td>${acaSchedule.asDistinction }</td>
	</tr>
	<tr>
		<th>시작일시</th>
		<td>${acaSchedule.asStart }</td>
	</tr>
	<tr>
		<th>종료일시</th>
		<td>${acaSchedule.asEnd }</td>
	</tr>
	<tr>
		<th>내용</th>
		<td>${acaSchedule.asCont }</td>
	</tr>
	<tr>
		<th>권한</th>
		<td>${acaSchedule.asAccePerm }</td>
	</tr>
	
	<tr>
	<c:url value='/schedule/acaScheduleUpdate.do' var="updateURL">
		<c:param name="what" value="${acaSchedule.asCd }" />
	</c:url>
	<c:url value='/schedule/acaScheduleDelete.do' var="deleteURL">
		<c:param name="what" value="${acaSchedule.asCd }" />
	</c:url>
	<c:url value='/schedule/acaScheduleList.do' var="listURL" />
         <td colspan="2">
               <a class="btn btn-primary" href="${updateURL }">수정</a>
               <a class="btn btn-danger" href="${deleteURL }">삭제</a>
               <a class="btn btn-success" href="${listURL }">목록</a>
         </td>
   </tr>
</table>







