<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<form:form method="post" modelAttribute="researchJournal" enctype="multipart/form-data">

<table>
	<tr>
		<th>순번</th>
		<td> 
			<form:input path="rjSn"/>
			<form:errors path="rjSn" class="error" />
		</td>	
	</tr>
	<tr>
		<th>연구코드</th>
		<td> 
			<form:input path="reseCd" type="password"/>
			<form:errors path="reseCd" class="error" />
		</td>	
	</tr>
	<tr>
		<th>연구일지명</th>
		<td> 
			<form:input path="rjNm"/>
			<form:errors path="rjNm" class="error" />
		</td>	
	</tr>
	<tr>
		<th>작성자</th>
		<td> 
			<form:input path="rjAutNm"/>
			<form:errors path="rjAutNm" class="error" />
		</td>	
	</tr>
	<tr>
		<th>연구일지내용</th>
		<td> 
			<form:input path="rjContent"/>
			<form:errors path="rjContent" class="error" />
		</td>	
	</tr>
	<tr>
		<th>연구일지첨부파일</th>
		<td>
			<form:input path="rjFile" name="researchJournalFile"/>
			<form:errors path="rjFile" class="error"/>
		</td>
	</tr>
	<tr>
		<th>연구일지작성일</th>
		<td>
			<form:input path="${java.time.LocalDateTime.now()}"  />
			<form:errors path="rjDate" class="error"/>
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="submit" value="수정">
			<input type="reset" value="취소">
			<input type="button" value="뒤로가기" 
				onclick="history.back();">
			<a href="<c:url value='/researchJournal/researchJournalList.do'/>">목록으로</a>
		</td>
	</tr>
</table>
</form:form>