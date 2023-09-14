<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/researchJournal/researchJournalUpdate.do" var="updateURL">
	<c:param name="who" value="${researchJournal.rjSn }" />
</c:url>
<a href="${updateURL }">수정</a>
<table>
	<tr>
		<th>순번</th>
		<td>${researchJournal.rjSn }</td>
	</tr>
	<tr>
		<th>연구코드</th>
		<td>${researchJournal.reseCd }</td>
	</tr>
	<tr>
		<th>연구일지명</th>
		<td>${researchJournal.rjNm }</td>
	</tr>
	<tr>
		<th>작성자</th>
		<td>${researchJournal.rjAutNm }</td>
	</tr>
	<tr>
		<th>연구일지내용</th>
		<td>${researchJournal.rjContent }</td>
	</tr>
	<tr>
		<th>연구일지첨부파일</th>
		<td>${researchJournal.rjFile }</td>
	</tr>
	<tr>
		<th>연구일지작성일</th>
		<td>${researchJournal.rjDate }</td>
	</tr>

</table>