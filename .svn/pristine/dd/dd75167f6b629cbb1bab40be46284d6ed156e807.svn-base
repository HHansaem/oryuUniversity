<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<style>
#studentList {
	display: flex;
	flex-direction: column;
	align-items: center;
}
.form-select {
	width: auto;
}
.table th {
	text-align: center;
}
.table td {
	text-align: center;
}
</style>
<div class="card box-shadow d-flex m-4" style="min-height: auto;">
      <div class="h-100">
      <div class="card-header" style="border-radius: 20px 20px 0 0; background-color:#154FA9; font-weight:bold; color:white;">학생 졸업 정보 조회</div>
      <table style="margin-bottom: 10px;">
			<td style="padding-left: 470px; padding-top:30px; padding-bottom:15px"><select name="dtCd" class="form-select"
				id="selectDepartment">
					<option value>학과선택</option>
					<c:forEach items="${departmentList }" var="department">
						<option value="${department.dtCd }">${department.dtNm }</option>
					</c:forEach>
			</select></td>
			<td style="padding-left: 10px; padding-top:30px; padding-bottom:15px"><select name="stStatus" class="form-select"
				id="selectstStatus">
					<option value="재학">재학</option>
					<option value="일반휴학">일반휴학</option>
					<option value="군휴학">군휴학</option>
					<option value="졸업">졸업</option>
					<option value="탈퇴">탈퇴</option>
			</select></td>
			<td style="padding-left: 10px; padding-top:30px; padding-bottom:15px">
				<div id="searchUI" class="form-inline">
					<form:select class="form-select mr-2" path="simpleCondition.searchType">
						<form:option value="name" label="이름" />
						<form:option value="stnum" label="학번" />
					</form:select>
					<form:input class="form-control mr-2" path="simpleCondition.searchWord" style="height: 37px" />
					<input type="button" value="검색" id="searchBtn" class="btn btn-success text-center" style="height: 40px; line-height: 0;" />
				</div>
			</td>
	</table>
<div id="studentList"></div>
</div></div>
<!-- 검색조건 받기 -->
<form:form id="searchForm" modelAttribute="simpleCondition" method="get">
	<input type="hidden" name="page" id="page" />
</form:form>

<script>
$(document).ready(function() {
    // 페이지 처음 로딩
    fetchStudent();
    // 검색 조건 변경 이벤트 처리
    $("#selectDepartment").on("change", function() {
    	$("#page").val(1); // 검색 조건이 변경되면 페이지 번호 초기화
        fetchStudent(); // 검색 조건이 변경 되면 학생 현황을 업데이트
    });
    
    $("#selectstStatus").on("change", function() {
    	$("#page").val(1); // 검색 조건이 변경되면 페이지 번호 초기화
        fetchStudent(); // 검색 조건이 변경 되면 학생 현황을 업데이트
    });
    
    $("#searchBtn").on("click", function() {
        fetchStudent(); // 검색 버튼 클릭 시 학생 현황 업데이트
    });
    
});
//학생목록 불러오기
function fetchStudent() {
    const selectedDepartment = $("#selectDepartment").val();
    const selectedPage = $("#page").val();
    const selectedSearchType = $("#searchType").val();
    const selectedSearchWord = $("#searchWord").val();
    const selectedStStatus = $("#selectstStatus").val();

    $.ajax({
		url : "/oryuUniversity/graduation/studentList.do",
		method : "get",
		dataType : "html",
		data: {
	            dtCd: selectedDepartment,
	            page: selectedPage,
	            searchType: selectedSearchType,
	            searchWord: selectedSearchWord,
	            stStatus: selectedStStatus
        },
		success : function(data) {
			$("#studentList").html(data); // 수정된 부분
		},
		error : function(jqXHR, status, error) {
			console.log(jqXHR);
			console.log(status);
			console.log(error);
		},
	});
}

<!-- pagination -->
function fn_paging(page) {
	searchForm.page.value = page;
	fetchStudent();
}
</script>