<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<style>
.narrow-modal-button {
	width: 140px;
	height: 40px;
}

#staffList {
	display: flex;
	flex-direction: column;
	align-items: center;
}

.form-select {
	width: auto;
}

#staffList {
	background-color: white;
}

.table th {
	text-align: center;
}

.table td {
	text-align: center;
}
</style>

<div class="card box-shadow d-flex m-4" style="min-height: 30%;">
	<div class="h-100">
		<div class="card-header"
			style="border-radius: 20px 20px 0 0; background-color: #154FA9; font-weight: bold; color: white;">교직원계정
			등록 및 조회</div>
		<div id="tsForm" style="display: none;">
			<div id="staffForm"></div>
			<div class="gradInfo-header" style="padding: 20px 60px 0px 20px;">
				<i class="mdi mdi-check-circle" style="color: green;"></i> 교직원정보 조회
				<hr
					style="border-color: black; margin-bottom: 0.7rem; margin-top: 0.7rem;">
			</div>
		</div>
		<table style="margin-bottom: 10px;">
			<td
				style="padding-left: 470px; padding-top: 30px; padding-bottom: 15px"><select
				name="tsDep" class="form-select" id="selectDepartment">
					<option value>부서선택</option>
					<option value="행정">행정</option>
					<option value="학사">학사</option>
			</select></td>
			<td
				style="padding-left: 10px; padding-top: 30px; padding-bottom: 15px"><select
				name="tsStatus" class="form-select" id="selecttsStatus">
					<option value="재직">재직</option>
					<option value="탈퇴">탈퇴</option>
			</select></td>
			<td
				style="padding-left: 10px; padding-top: 30px; padding-bottom: 15px">
				<div id="searchUI" class="form-inline">
					<form:select class="form-select mr-2"
						path="simpleCondition.searchType">
						<form:option value="name" label="이름" />
						<form:option value="tsnum" label="직번" />
					</form:select>
					<form:input class="form-control mr-2"
						path="simpleCondition.searchWord" style="height: 37px" />
					<input type="button" value="검색" id="searchBtn"
						class="btn btn-success text-center"
						style="height: 40px; line-height: 0;" /> <input type="button"
						value="교직원 등록" id="showFormButton"
						class="btn btn-outline-info text-center"
						style="height: 40px; line-height: 0; margin-left: 230px;">
				</div>
			</td>
		</table>
		<div id="staffList" style="border-radius: 20px;"></div>
	</div>
</div>
<!-- 검색조건 받기 -->
<form:form id="searchForm" modelAttribute="simpleCondition" method="get">
	<input type="hidden" name="page" id="page" />
</form:form>

<script>
$(document).ready(function() {
    // 페이지 처음 로딩
    fetchstaff();
    fetchstaffForm();
    // 검색 조건 변경 이벤트 처리
    $("#selectDepartment").on("change", function() {
    	$("#page").val(1); // 검색 조건이 변경되면 페이지 번호 초기화
    	fetchstaff(); // 검색 조건이 변경 되면 학생 현황을 업데이트
    });
    
    $("#selecttsStatus").on("change", function() {
    	$("#page").val(1); // 검색 조건이 변경되면 페이지 번호 초기화
    	fetchstaff(); // 검색 조건이 변경 되면 학생 현황을 업데이트
    });
    
    $("#searchBtn").on("click", function() {
    	fetchstaff(); // 검색 버튼 클릭 시 학생 현황 업데이트
    });
    
});
//교직원목록 불러오기
function fetchstaff() {
    const selectedDepartment = $("#selectDepartment").val();
    const selectedPage = $("#page").val();
    const selectedSearchType = $("#searchType").val();
    const selectedSearchWord = $("#searchWord").val();
    const selectedTsStatus = $("#selecttsStatus").val();

    $.ajax({
		url : "/oryuUniversity/staff/staffList.do",
		method : "get",
		dataType : "html",
		data: {
				tsDep: selectedDepartment,
	            page: selectedPage,
	            searchType: selectedSearchType,
	            searchWord: selectedSearchWord,
	            tsStatus: selectedTsStatus
        },
		success : function(data) {
			$("#staffList").html(data); // 수정된 부분
		},
		error : function(jqXHR, status, error) {
			console.log(jqXHR);
			console.log(status);
			console.log(error);
		},
	});
}
// 교직원폼 불러오기
function fetchstaffForm() {
	
	$.ajax({
		url : "/oryuUniversity/staff/staffInsert.do",
		method : "get",
		dataType : "html",
		 data: {},
		success : function(data) {
			$("#staffForm").html(data); // 수정된 부분
			
			$("#address_btn").on("click", function() {
				 new daum.Postcode({
		            oncomplete: function(data) {
		                document.getElementById("address").value = data.address;
		                document.getElementById("staffAdd1Error").innerText = "";
		                document.getElementById("address_detail").focus();
		            }
		        }).open();
			});
			
			 $("#tsPassConfirm").on("keyup", function() {
				 var password = document.getElementById("tsPass").value;
		        var passwordConfirm = this.value;

		        if (password !== passwordConfirm) {
		            document.getElementById("passwordMatchError").innerText = "비밀번호가 일치하지 않습니다.";
		            document.getElementById("passwordMatchError").style.color = "red";
		        } else {
		            document.getElementById("passwordMatchError").innerText = "비밀번호가 일치합니다.";
		            document.getElementById("passwordMatchError").style.color = "blue";
		        }
			 });
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
	fetchstaff();
}

$("#showFormButton").on("click", function() {
    $("#tsForm").show(); // 폼을 나타나게 함
    $("#showFormButton").hide();
});
</script>

<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
