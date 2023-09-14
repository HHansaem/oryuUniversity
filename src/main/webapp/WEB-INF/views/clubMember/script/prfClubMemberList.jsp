<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<table class="table" style="margin-bottom: 20px; width: 80%;">
<tr>
	</tr>
	<tr>
        <td>
            <div class="paging-info">
                <p>총 ${paging.totalRecord}건의 게시물이 있습니다.</p>
            </div>
        </td>
    </tr>
</table>
<table class="table" style="margin-bottom: 20px; width: 80%;">
	<thead class="table-light">
		<tr>
			<th>이름</th>
			<th>학번</th>
			<th>학과</th>
			<th>전화번호</th>
			<th>신청유무</th>
			<th>신청날짜</th>
		</tr>
	</thead>
	<tbody>
		<c:set var="clubMemInsertList" value="${paging.dataList }" />
		<c:choose>
			<c:when test="${empty clubMemInsertList }">
				<tr>
					<td colspan="5"> 받은 동아리 신청서가 없습니다.</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${clubMemInsertList }" var="clubMemInsertList">
					<tr>
						<c:url value="/clubMember/prfClubMemberView.do" var="viewURL">
							<c:param name="what" value="${clubMemInsertList.stCd}"></c:param>
							<c:param name="club" value="${clubMemInsertList.clubCd }"></c:param>
						</c:url>
						<td>${clubMemInsertList.stNm }</td>
						<td><a href="${viewURL }">${clubMemInsertList.stCd }</a></td>
						<td>${clubMemInsertList.dtNm }</td>
						<td>${clubMemInsertList.stPh }</td>
						<td>${clubMemInsertList.clubEntSta }</td>
						<td>${clubMemInsertList.clubAppDate }</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</tbody>
<tfoot>
		<tr>
			<td colspan="6">
				<div class="d-flex justify-content-center mb-3">
				${paging.pagingHTML }
				</div>
			</td>
		</tr>
	</tfoot>
</table>

