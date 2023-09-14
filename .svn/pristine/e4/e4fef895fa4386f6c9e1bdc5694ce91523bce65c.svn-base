<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="container">
	<table class="table" style="width: 95%; height: 370px;" >
		<thead class="table-light">
			<tr>
				<th>연도</th>
				<th>단대</th>
				<th>학과</th>
				<th>취업인원</th>
				<th>졸업자수</th>
				<th>취업률</th>
			</tr>
		</thead>
		<tbody>
			<c:set var="depart" value="${paging2.dataList }" />
			<c:choose>
				<c:when test="${empty depart }">
					<tr>
						<td colspan="6">조건에 맞는 학과가 없음.</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach items="${depart }" var="dept">
						<tr>
							<td class="col-sm-1">${dept.stGrad}</td>
							<td class="col-sm-1">${dept.colgeNm}</td>
							<td class="col-sm-1">${dept.dtNm}</td>
							<td class="col-sm-1">총${dept.employed}명</td>
							<td class="col-sm-1">총${dept.total}명</td>
							<td class="col-sm-1">${dept.ratio}%</td>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</tbody>
		<tfoot>
		</tfoot>
	</table>
	<div class="text-center mt-3 d-flex justify-content-center"
		id="pagination">${paging2.pagingHTML2 }</div>
</div>