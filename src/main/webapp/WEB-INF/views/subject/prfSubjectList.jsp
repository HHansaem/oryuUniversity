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
<div class="card box-shadow d-flex m-4" style="min-height: 87%;">
	<div class="h-100">
		<div class="custom-card">
			<div class="card-header"
				style="border-radius: 20px 20px 0 0; background-color: #154FA9; font-weight: bold; color: white;">과목목록</div>
			<div class="card-body">
				<div class="card gradInfo">
					<div class="gradInfo-header">
						<i class="mdi mdi-check-circle" style="color: green;"></i> 과목 목록 페이지
						<hr style="border-color: black;">
					</div>
					<div class="gradInfo-body">
						<span class="span-title">검색자</span>
						|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;단대,학과,이수구분 선택하고 검색버튼을 눌러주세요.
					</div>
					<div class="gradInfo-body" id="gradeStudents"></div>
			    </div>
				<div class="row justify-content-center">
					<div class="col-2">
						<select name="college" class="form-select">
							<option value>단대선택</option>
							<c:forEach items="${collegeList }" var="college">
								<option value="${college.colgeCd }">${college.colgeNm }</option>
							</c:forEach>
						</select>
					</div>
					<div class="col-2">
						<select name="dtCd" class="form-select">
							<option value>학과선택</option>
							<c:forEach items="${departmentList }" var="department">
								<option value="${department.dtCd }"
									class="${department.colgeCd }">${department.dtNm }</option>
							</c:forEach>
						</select>
					</div>
					<div class="col-2">
						<select name="classfication" class="form-select">
							<option value>이수구분선택</option>
							<c:forEach items="${classificationList }" var="classification">
								<option value="${classification.cfCode }">${classification.cfName }</option>
							</c:forEach>
						</select>
					</div>
						<div id="searchUI" class="col-1">
							<form:select path="simpleCondition.searchType"
								class="form-select">
								<form:option value="" label="전체" />
								<form:option value="code" label="과목코드" />
								<form:option value="name" label="과목명" />
							</form:select>
						</div>
						<div id="searchUI" class="col-2">
							<form:input path="simpleCondition.searchWord"
								class="form-control" />
						</div>
						<div class="col-1">
							<input type="button" value="검색" id="searchBtn"
								class="btn btn-success" />
						</div>
				</div>
				<div class="row justify-content-center">
					<div class="col-7">
						<table class="table">
							<thead class="table-light">
								<tr>
									<th><input  id="toggleCheckBoxes" type="checkbox" name="checkBox"></th>
									<th>과목코드</th>
									<th>과목명</th>
									<th>학과명(학과코드)</th>
									<th>이수구분</th>
								</tr>
							</thead>
							<tbody>
								<c:set var="subjectList" value="${paging.dataList }" />
								<c:choose>
									<c:when test="${empty subjectList }">
										<tr>
											<td class="col-7">조건에 맞는 과목이 없음.</td>
										</tr>
									</c:when>
									<c:otherwise>
										<c:forEach items="${subjectList }" var="subject">
											<tr>
												<td class="col-1"><input type="checkbox" name="checkBox"></td>
												<td class="col-1 subjCd">${subject.subjCd}</td>
												<td class="col-2">${subject.subjNm}</td>
												<td class="col-2">${subject.department.dtNm}(${subject.dtCd})</td>
												<td class="col-1"><c:choose>
														<c:when test="${subject.subjComType eq '1'}">
															<span class="badge badge-primary"> <c:out
																	value="전공필수" />
															</span>
														</c:when>
														<c:when test="${subject.subjComType eq '2'}">
															<span class="badge badge-info"> <c:out
																	value="전공선택" />
															</span>
														</c:when>
														<c:when test="${subject.subjComType eq '3'}">
															<span class="badge badge-secondary"> <c:out
																	value="교양필수" />
															</span>
														</c:when>
														<c:when test="${subject.subjComType eq '4'}">
															<span class="badge badge-light"> <c:out
																	value="교양선택" />
															</span>
														</c:when>
													</c:choose></td>
											</tr>
										</c:forEach>
									</c:otherwise>
								</c:choose>
							</tbody>
							<tfoot>
								<tr>
									<td colspan="7">
										<div class="d-flex justify-content-center mb-3">
											${paging.pagingHTML }</div>
									</td>
								</tr>
							</tfoot>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- 검색조건 받기 -->
<form:form id="searchForm" modelAttribute="simpleCondition" method="get">
	<input type="hidden" name="college" id="college"
		value="${detail.college }" />
	<input type="hidden" name="dtCd" id="dtCd" value="${detail.dtCd }" />
	<input type="hidden" name="classfication" id="classfication"
		value="${detail.classfication }" />
	<form:hidden path="searchType" />
	<form:hidden path="searchWord" />
	<input type="hidden" name="page" />
</form:form>
<!-- 검색조건내에 조건걸기 -->
<script>
 	let $dtCd = $('[name="dtCd"]');
 	$('[name="college"]').on("change", function(event){
 		let colgeCd = $(this).val();
		if(colgeCd){
			$dtCd.find("option").hide();
			$dtCd.find(`option:first`).show();
 			$dtCd.find(`option.\${colgeCd}`).show();
 		}else{
 			$dtCd.find("option").show();
 		}
 	}).trigger("change");
 	
<!-- pagination -->
	function fn_paging(page){
		searchForm.page.value = page;
		searchForm.requestSubmit();
	}
	$(searchBtn).on("click", function(event){
		$(searchUI).find(":input[name]").each(function(idx, input){
			let name = input.name;
			let value = $(input).val();
			$(searchForm).find(`[name=\${name}]`).val(value);
			
			console.log("name : " + name + ", value : " + value);
		});
		
		let college = $("select[name='college']").val();
		let dtCd = $("select[name='dtCd']").val();
		let classfication = $("select[name='classfication']").val();

		$("#searchForm input[name='college']").val(college);
    	$("#searchForm input[name='dtCd']").val(dtCd);
		$("#classfication").val(classfication);
		
		$(searchForm).submit();
	});
</script>