<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<style>
.gradInfo {
	margin-top: 3px;
	background-color: rgba(0, 0, 0, 0.03);
	margin: 20px;
	padding-right: 40px;
	font-family: 'Noto Sans KR', sans-serif;
}

.gradInfo-header {
	margin: 20px 0 11px 40px;
	font-size: 14px;
	font-weight: bold;
}

.gradInfo-body {
	margin: -13px 11px 20px 40px;
	font-size: 12px;
}

.span-title {
	font-weight: bold;
	color: #248AFD;
	margin-right: 12px;
}

select {
    padding: 0; /* 위 아래 여백을 없애는 스타일 */
    display: inline-block; /* 셀렉트 박스를 인라인 블록 요소로 표시하여 텍스트 흐름을 방해하지 않도록 함 */
    vertical-align: middle; /* 수직 정렬을 가운데로 설정 */
}
button {
 	margin-left: 10px;
}
.row {
	margin: 10px;
}
th {
	text-align: center;
}

td {
	text-align: center;
}
</style>
<div style="overflow-y: auto; max-height: 300px;" >
<table class="table" style="width: 95%;">
	<thead class="table-light">
		<tr>
			<th>체크</th>
			<th>강의명(강의코드)</th>
			<th>교수명</th>
			<th>학년,학기</th>
			<th>강의학점</th>
			<th>강의실(강의실코드)</th>
			<th>강의시간</th>
			<th>수강인원</th>
			<th>제한인원</th>
			<!-- 			<th>강의분반</th> -->
			<th>강의계획서</th>
		</tr>
	</thead>
	<tbody>
		<c:set var="lectureList" value="${paging.dataList }" />
		<c:choose>
			<c:when test="${empty lectureList }">
				<tr>
					<td colspan="10">조건에 맞는 과목이 없음.</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${lectureList }" var="lecture">
					<tr data-id="${lecture.lecCd}" class="clickable-row">
						<td class="col-sm-1"><input type="checkbox" name="checkBox"></td>
						<td hidden="" class="col-sm-1 lecCd">${lecture.lecCd}</td>
						<td>${lecture.lecLectTitle}(${lecture.lecCd})</td>
						<td>${lecture.professor.prNm}</td>
						<td>${lecture.lecGraCd}학년,${lecture.lecSemeCd}학기</td>
						<td>${lecture.lecLectCred}학점</td>
						<c:if test="${empty lecture.clasNm}">
							<td class="col-1">미정</td>	
							<td class="col-1">미정</td>	
						</c:if>
						<c:if test="${not empty lecture.clasNm}">
							<td class="col-1">${lecture.clasNm}(${lecture.clasCd})</td>
							<td class="col-1">${lecture.scheCds}</td>
						</c:if>
						<td>${lecture.enroll}명</td>
						<td>${lecture.lecEnroLimit}명</td>
						<%-- 							<td>${lecture.lecLectDivision}</td> --%>
						<td><c:if
								test="${not empty lecture.fileGroup and not empty lecture.fileGroup.detailList }">
								<c:forEach items="${lecture.fileGroup.detailList }"
									var="fileDetail">
									<c:url value="/download.do" var="downloadURL">
										<c:param name="atchFileId" value="${fileDetail.atchFileId }" />
										<c:param name="fileSn" value="${fileDetail.fileSn }" />
									</c:url>
									<a href="${downloadURL }"> <i
										class="mdi mdi-briefcase-download menu-icon"></i>
									</a>
								</c:forEach>
							</c:if></td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</tbody>
</table>
</div>
