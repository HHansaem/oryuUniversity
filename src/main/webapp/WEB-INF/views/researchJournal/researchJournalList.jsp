<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

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


<table class="table">
<tr><td><h4><br>연구 일지</h4></td></tr>
</table>

<table class="table">
	<tr>
	<td>
	<div id="searchUI" class="row justify-content-center">
		<div  class="col-auto">
			<form:select path="simpleCondition.searchType" class="form-select">
				<form:option value="" label="전체" />
				<form:option value="writer" label="작성자" />
				<form:option value="title" label="제목" />
				<form:option value="content" label="내용" />
			</form:select>
		</div>
		<div  class="col-auto">
			<form:input path="simpleCondition.searchWord" class="form-control"/>
		</div>
		<div  class="col-auto">
			<input type="button" value="검색" id="searchBtn" class="btn btn-success"/>
			<a href="<c:url value='/researchJournal/researchJournalInsert.do'/>" class="btn btn-primary">연구일지등록</a>
		</div>
	</div>
	</td>
	</tr>
</table>

<table class="table">
     <tr>
        <td>
            <div class="paging-info">
                <p>총 ${totalRecord}건의 게시물이 있습니다.</p>
                <p>페이지 ${paging.currentPage}/${paging.endPage}</p>
            </div>
        </td>
    </tr>
</table>

<table class="table">

	<thead class="table-ligth">
			<tr>
				<td>순번</td>
				<td>연구코드</td>
				<td>연구일지명</td>
				<td>작성자</td>
				<td>연구일지첨부파일</td>
				<td>연구일지작성일</td>
			</tr>
	</thead>
	
	<tbody>
		<c:set var="researchJournalList" value="${paging.dataList }" />
		<c:if test="${empty researchJournalList }">
			<tr>
				<td colspan="7">등록된 연구일지가 없습니다.</td>
			</tr>
		</c:if>
		<c:if test="${not empty researchJournalList }">
			<c:forEach items="${researchJournalList }" var="researchJournal">
				<c:url value="/researchJournal/researchJournalView.do" var="researchJournalURL">
					<c:param name="who" value="${researchJournal.rjSn }" />
				</c:url>
				<tr>
					<td>${researchJournal.rnum }</td>
					<td><a href="${researchJournalURL }">${researchJournal.rjSn }</a></td>
					<td>${researchJournal.rjNm }</td>
					<td>${researchJournal.rjNm }</td>
					<td>${researchJournal.atchFileId }</td>
					<td>${researchJournal.rjDate }</td>
				</tr>
			</c:forEach>
		</c:if>
	</tbody>
</table>

	<tbody>
		<c:set var="acaNoticeList" value="${paging.dataList }" />
		<c:choose>
			<c:when test="${empty acaNoticeList }">
				<tr>
					<td colspan="5">조건에 맞는 게시글 없음.</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${acaNoticeList }" var="acaNotice">
					<tr>
						<c:url value="/academic/acaNoticeView.do" var="viewURL">
							<c:param name="what" value="${acaNotice.anNum }"></c:param>
							
						</c:url>
						<td>${acaNotice.rnum }</td>
						<td><a href="${viewURL }">${acaNotice.anTitle }</a></td>
						<td>${acaNotice.anWriter }</td>
						<td>${acaNotice.anPostDate }</td>
						<td>${acaNotice.anViews }</td>
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
