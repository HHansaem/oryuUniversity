<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<style>
.paging-info {
        display: flex;
        justify-content: space-between;
        align-items: center;
    }
.paging-info p {
        margin: 0;
    }
    .table-kw{
    width:80;
    }
</style>
<div class="card box-shadow d-flex m-4" style="min-height: 87%;">
   <div class="h-100">
      <div class="custom-card">
         <div class="card-header" style="border-radius: 20px 20px 0 0; background-color:#154FA9; font-weight:bold; color:white;">인턴십 목록</div>
         <div class="card-body">




	
	<div id="searchUI" class="row justify-content-center">
		<div  class="col-auto">
			<form:select path="simpleCondition.searchType" class="form-select">
				<form:option value="" label="전체" />
				<form:option value="inteTitle" label="제목" />
				<form:option value="inteRegion" label="근무지역" />
				<form:option value="inteCompNm" label="기업명" />
			</form:select>
		</div>
		<div  class="col-auto">
			<form:input path="simpleCondition.searchWord" class="form-control"/>
		</div>
		<div  class="col-auto">
			<input type="button" value="검색" id="searchBtn" class="btn btn-success"/>
		</div>
	</div>
	
<br>

<!-- style="width: 80%; -->
<table class="table" style="margin-left: 109px;
    width: 84%;">
	<thead class="table-light">
	
		<tr>
			<th>기업명</th>
			<th width="400px">제목</th>
			<th>근무지역</th>
			<th>담당자명</th>
			<th>전화번호</th>
			<th>조회수</th>
			<th>신청자수</th>
		</tr>
	</thead>
	<tbody>
		<c:set var="internList" value="${paging.dataList }" />
		<c:choose>
			<c:when test="${empty internList }">
				<tr>
					<td colspan="6">조건에 맞는 게시글 없음.</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${internList }" var="intern">
					<tr>
						<c:url value="/internship/internshipView.do" var="viewURL">
							<c:param name="what" value="${intern.inteCd }"></c:param>
						</c:url>
						<td>${intern.inteCompNm }</td>
						<td><a href="${viewURL }">${intern.inteTitle }</a></td>
						<td>${intern.inteRegion }</td>
						<td>${intern.inteContPerson }</td>
						<td>${intern.intePh }</td>
						<td>${intern.inteViews }</td>
						<td>${intern.reqCont }</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</tbody>
	
	<tfoot>
		<tr>
			<td colspan="7">
				<div class="d-flex justify-content-center mb-3">
				${paging.pagingHTML }
				</div>
				<sec:authorize access="hasRole('ROLE_TS')"><!-- 교직원 -->
			    	<input class="btn btn-success" type="button" value="인턴십 등록하기" onclick="internshipInsert()">
    </sec:authorize>
			</td>
		</tr>
	</tfoot>
	
</table>
   </div>
   </div>
 </div>
   </div>
 <form:form id="searchForm" modelAttribute="simpleCondition" method="get">
	<form:hidden path="searchType" />
	<form:hidden path="searchWord" />
	<input type="hidden" name="page" />
</form:form>   
    
 <script>
 function fn_paging(page){
		searchForm.page.value = page;
		searchForm.requestSubmit();
	}

	$(searchBtn).on("click", function(event){
	      $(searchUI).find(":input[name]").each(function(idx, input){
	         let name = input.name;
	         let value = $(input).val();
	         $(searchForm).find(`[name=\${name}]`).val(value);
	      });
	      $(searchForm).submit();
	   });
	
    $(document).ready(function() {
        var message = message;/* 서버에서 받은 메시지 */
        
        if (message) {
            alert(message);
        }
    });
</script>
<script>
function internshipInsert() {
	window.location.href = "${pageContext.request.contextPath}/internship/internshipInsert.do";
}
</script>