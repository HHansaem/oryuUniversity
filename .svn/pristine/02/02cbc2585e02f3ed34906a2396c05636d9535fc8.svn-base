<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div class="container">
	<table class="table table-hover">
		<thead>
			<tr>
				<th>회사명</th>
				<th>채용정보</th>
				<th>상세조건</th>
			</tr>
		</thead>
		<tbody>
			<c:set var="jobList" value="${paging2.dataList }" />
			<c:choose>
				<c:when test="${empty jobList }">
					<tr>
						<td colspan="3">내용없음</td>
					</tr>
					<tr></tr>
					<tr></tr>
					<tr></tr>
					<tr></tr>
				</c:when>
				<c:otherwise>
					<c:forEach items="${jobList}" var="job">
						<tr>
							<td class="col-1"><i class="mdi mdi-star"></i><a
								href="${job.jobLink}"
								onclick="window.open('${job.jobLink}', 'newWindow', 'width=1024,height=1024'); return false;">${job.jobName}</a>
							</td>
							<td class="col-2">${job.jobTitle}<br>${job.jobSector}</td>
							<td class="col-1"><i class="mdi mdi-compass-outline"></i>${job.jobPlace}<br>
								<i class="mdi mdi-briefcase"></i>${job.jobReq}<br> <i
								class="mdi mdi-school"></i>${job.jobReq2}</td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>
	<div class="text-center mt-3 d-flex justify-content-center">${paging2.pagingHTML }</div>
</div>