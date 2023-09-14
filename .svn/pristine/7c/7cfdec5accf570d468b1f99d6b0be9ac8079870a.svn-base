<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!-- 학술사업보고서의 목록을 조회하는 페이지 -->
<style>
.paging-info {
        display: flex;
        justify-content: space-between;
        align-items: center;
    }
.paging-info p {
        margin: 0;
    }
</style>

<!-- 컨텐츠 제목! -->
<table class="table">
<tr><td><h4><br>학술사업보고서</h4></td></tr>
</table>

<!--  조건 검색 라인 -->

<table class="table">
	<tr>
	<td>
	<div id="searchUI" class="row justify-content-center">
		<div  class="col-auto">
			<form:select path="simpleCondition.searchType" class="form-select">
				<form:option value="" label="전체" />
				<form:option value="buReAutNm" label="작성자" />
				<form:option value="buReNm" label="제목" />
				<form:option value="buReCont" label="내용" />
			</form:select>
		</div>
		<div  class="col-auto">
			<form:input path="simpleCondition.searchWord" class="form-control"/>
		</div>
		<div  class="col-auto">
			<input type="button" value="검색" id="searchBtn" class="btn btn-success"/>
			<a href="<c:url value='/academicBusinessReport/aBRInsert.do'/>" class="btn btn-primary">학술사업보고서등록</a>
		</div>
	</div>
	</td>
	</tr>
     <tr>
        <td>
            <div class="paging-info">
                <p>총 ${totalRecord}건의 게시물이 있습니다.</p>
                <p>페이지 ${paging.currentPage}/${paging.endPage}</p>
            </div>
        </td>
    </tr>
</table>


<!--       <div class="search_bar"> -->
<!--         <input type="search" placeholder="Search job here..."> -->
<!--         <select name="" id=""> -->
<!--           <option>Category</option> -->
<!--           <option>Web Design</option> -->
<!--           <option>App Design</option> -->
<!--           <option>App Development</option> -->
<!--         </select> -->
<!--         <select class="filter"> -->
<!--           <option>Filter</option> -->
<!--         </select> -->
<!--       </div> -->


<table class="table">
	<thead class="table-light">
		<tr>
			<th>번호</th>
			<th>학술사업코드</th>
			<th>제목</th>
			<th>내용(요약)</th>
			<th>작성자</th>
			<th>평가명</th>
			<th>작성일</th>
		</tr>
	</thead>
	<tbody>
		<c:set var="aBRList" value="${paging.dataList }" />
		<c:choose>
			<c:when test="${empty aBRList }">
				<tr>
					<td colspan="5">조건에 맞는 게시글 없음.</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${aBRList }" var="aBRVO">
					<tr>
						<c:url value="/academicBusinessReport/aBRView.do" var="viewURL">
							<c:param name="what" value="${aBRVO.buReSn }"></c:param>
							
						</c:url>
						<td>${aBRVO.rnum }</td>
						<td>${aBRVO.acBuCd }</td>
						<td><a href="${viewURL }">${aBRVO.buReNm }</a></td>
						<td>${aBRVO.buReShortCont }</td>
						<td>${aBRVO.buReAutNm }</td>
						<td>${aBRVO.buReEvNm }</td>
						<td>${aBRVO.buReDate }</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</tbody>
	
	<tfoot>
		<tr>
			<td colspan="5">
				<div class="d-flex justify-content-center mb-3">
				${paging.pagingHTML }
				</div>
			</td>
		</tr>
	</tfoot>
</table>




<!-- serachForm은 검색하는 타입과 단어들을 받아서 검색하는 hidden된 코드들. -->
<form:form id="searchForm" modelAttribute="simpleCondition" method="get">
	<form:hidden path="searchType" />
	<form:hidden path="searchWord" />
	<input type="hidden" name="page" />
</form:form>
<!-- 페이징 펑션, click event -->
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
</script>

