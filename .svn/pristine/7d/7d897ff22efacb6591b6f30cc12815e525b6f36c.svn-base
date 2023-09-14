<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<table class="table text-center">
	<thead class="table-light">
		<tr>
		<th colspan="6">시험 제출 목록</th>
		</tr>
		<tr>
			<th>학번</th>
			<th>이름</th>
			<th>학과</th>
			<th>제출시간</th>
			<th>점수</th>
			<th>제출체크</th>
		</tr>
	</thead>
	<tbody>
		<c:choose>
			<c:when test="${empty examSubmitList}">
				<tr>
					<td colspan="6">제출된 시험결과가 없습니다.</td>
				</tr>	
			</c:when>
			<c:otherwise>
				<c:forEach items="${examSubmitList}" var="examSubmit">
					<tr class="clickable-row">
						<td class="col-sm-0.5 stCd">${examSubmit.stCd}</td>
						<td class="col-sm-0.5 stName">${examSubmit.stNm}</td>
						<td class="col-sm-0.5 dtNm">${examSubmit.dtNm}</td>
						<td class="col-sm-0.5">${examSubmit.submitTime}</td>
						<td class="col-sm-0.5 stScore" id="${examSubmit.stCd}Score">${examSubmit.esScore}/${examSubmit.examScore}</td>
						<td>
							<button type="button" class="btn btn-primary stSubmitView" data-st="${examSubmit.stCd}" data-exam="${examSubmit.examCd}">
  								확인하기
  							</button>
  						</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</tbody>
</table>