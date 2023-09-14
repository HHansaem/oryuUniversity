<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<script src="${pageContext.request.contextPath}/resources/js/ckeditor/ckeditor.js"></script>
<form:form method="post" modelAttribute="acaSchedule" enctype="multipart/form-data">
<form:hidden path="asCd"/>
	<table class="table table-bordered">
		<tr>
            <th>구분</th>
            <td>
                <form:select path="asDistinction" class="form-control">
                    <form:option value="전체" label="전체" />
                    <form:option value="등록/장학일정" label="등록/장학일정" />
					<form:option value="학적일정" label="학적일정" />
					<form:option value="수업일정" label="수업일정" />
					<form:option value="행사일정" label="행사일정" />
					<form:option value="학술사업일정" label="학술사업일정" />
					<form:option value="수강신청일정" label="수강신청일정" />
					<form:option value="기타" label="기타" />
                </form:select>
                <form:errors path="asDistinction" class="error" />
            </td>
        </tr>
		<tr>
			<th>일정명</th>
			<td>
				<form:input path="asNm" class="form-control" />
				<form:errors path="asNm" class="error" />
			</td>
		</tr>
		<tr>
			<th>시작일시</th>
			<td>
				<form:input path="asStart" type="date" class="form-control" />
    			<form:errors path="asStart" class="error" />
			</td>
		</tr>
		<tr>
			<th>종료일시</th>
			<td>
				<form:input path="asEnd" type="date" class="form-control" />
    			<form:errors path="asEnd" class="error" />
			</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>
				<form:input path="asCont" class="form-control" />
				<form:errors path="asCont" class="error" />
			</td>
		</tr>
		<tr>
		    <th>열람권한</th>
		    <td>
		        <c:choose>
		            <c:when test="${acaSchedule.asAccePerm == 'BOTH' || acaSchedule.asAccePerm == 'STUDENT'}">
		                <form:checkbox path="asAccePerm" value="student" label="학생" checked="true" />
		            </c:when>
		            <c:otherwise>
		                <form:checkbox path="asAccePerm" value="student" label="학생" />
		            </c:otherwise>
		        </c:choose>
		        <c:choose>
		            <c:when test="${acaSchedule.asAccePerm == 'BOTH' || acaSchedule.asAccePerm == 'PROFESSOR'}">
		                <form:checkbox path="asAccePerm" value="professor" label="교수" checked="true" />
		            </c:when>
		            <c:otherwise>
		                <form:checkbox path="asAccePerm" value="professor" label="교수" />
		            </c:otherwise>
		        </c:choose>
		        <button type="button" id="checkAllButton" class="btn btn-outline-light btn-sm">전체</button>
		    </td>
		</tr>

	<tr>

			<c:url value='/schedule/acaScheduleList.do' var="ListURL">
				<c:param name="what" value="${acaSchedule.asCd }" />
			</c:url>
			<td colspan="2">
				<input type="submit" class="btn btn-primary" value="저장">
				<a class="btn btn-danger" href="${ListURL }">취소</a>
			</td>
		</tr>
	</table>
</form:form>

<script>
    document.addEventListener('DOMContentLoaded', function () {
        const professorCheckbox = document.querySelector('input[value="professor"]');
        const studentCheckbox = document.querySelector('input[value="student"]');
        const checkAllButton = document.getElementById('checkAllButton');

        // '전체' 버튼 클릭 이벤트 처리
        checkAllButton.addEventListener('click', function () {
            const isChecked = professorCheckbox.checked && studentCheckbox.checked;
            professorCheckbox.checked = !isChecked;
            studentCheckbox.checked = !isChecked;
            updateCheckAllButton(); // '전체' 버튼 상태 업데이트
        });

        // 교수 또는 학생 체크박스 변경 시 '전체' 버튼 상태 업데이트
        professorCheckbox.addEventListener('change', updateCheckAllButton);
        studentCheckbox.addEventListener('change', updateCheckAllButton);

        // '전체' 버튼 상태 업데이트 함수
        function updateCheckAllButton() {
            const isChecked = professorCheckbox.checked && studentCheckbox.checked;
            checkAllButton.textContent = isChecked ? '전체 해제' : '전체';
        }
    });
</script>
