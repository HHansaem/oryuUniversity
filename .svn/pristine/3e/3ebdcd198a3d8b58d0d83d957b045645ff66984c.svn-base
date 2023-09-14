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
			<th>학과</th>
			<th>전화번호</th>
			<th>동아리직급</th>
			<th>탈퇴날짜</th>
		</tr>
	</thead>
	<tbody>
		<c:set var="clubMemberWthdrList" value="${paging.dataList }" />
		<c:choose>
			<c:when test="${empty clubMemberWthdrList }">
				<tr>
					<td colspan="5"> 동아리 탈퇴자가 없습니다.</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${clubMemberWthdrList }" var="clubMemberWthdrList">
					<tr>
						<td>${clubMemberWthdrList.stNm }</td>
						<td>${clubMemberWthdrList.dtNm }</td>
						<td>${clubMemberWthdrList.stPh }</td>
						<td>${clubMemberWthdrList.clubMemClass }</td>
						<td>${clubMemberWthdrList.clubSeReDate }</td>
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
