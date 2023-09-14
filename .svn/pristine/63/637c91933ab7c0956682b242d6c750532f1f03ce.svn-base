<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<table class="table">
<tr>
	<td>
		<h4><br>학술사업보고서</h4>
	</td>
</tr>
</table>

<table class="table">
	<tr>
		<td><h3>${aBRVO.buReNm }</h3></td>
	</tr>
	<tr>
		<th>보고서번호</th>
		<td>${aBRVO.rnum }</td>
		<th>학술사업코드</th>
		<td>${aBRVO.acBuCd }</td>
		<th>학술사업보고서명</th>
		<td>${aBRVO.buReSn }</td>
		<th>작성자</th>
		<td>${aBRVO.buReAutNm }</td>
		<th>요약내용</th>
		<td>${aBRVO.buReShortCont }</td>
	</tr>
	<tr>
		<th>내용</th>
		<td>${aBRVO.buReCont }</td>
	</tr>
	<tr>
		<th>첨부파일</th>
		<td>
			<c:if test="${not empty aBRVO.fileGroup and not empty aBRVO.fileGroup.detailList }">
				<c:forEach items="${aBRVO.fileGroup.detailList }" var="fileDetail">
					<c:url value="/academicBusinessReport/aBPDownload.do" var="downloadURL">
						<c:param name="atchFileId" value="${fileDetail.atchFileId }" />
						<c:param name="fileSn" value="${fileDetail.fileSn }" />
					</c:url>
					<a href="${downloadURL }">${fileDetail.orignlFileNm }</a>
				</c:forEach>
			</c:if>
		</td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
	</tr>
	
	<tr>
	<c:url value='/academicBusinessReport/aBRUpdate.do' var="updateURL">
		<c:param name="what" value="${aBRVO.buReSn }" />
	</c:url>
	<c:url value='/academicBusinessReport/aBRDelete.do' var="deleteURL">
		<c:param name="what" value="${aBRVO.buReSn }" />
	</c:url>
	<c:url value='/academicBusinessReport/aBRList.do' var="listURL" />
         <td colspan="2">
               <a class="btn btn-primary" href="${updateURL }">수정</a>
               <a class="btn btn-danger" href="${deleteURL }">삭제</a>
               <a class="btn btn-success" href="${listURL }">목록</a>
         </td>
   </tr>
</table>
















