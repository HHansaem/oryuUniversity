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
.table-padding {
	padding: 0 50px 0 50px;
}
.header-label{
	font-weight: bold;
	margin: 17px 0 -17px 2px;
	font-size: 16px;
}
.header-span{
	font-weight: normal;
	font-size: 13px;
}
#searchUI{
/* 	float: right; */
}
.gradInfo {
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
.gradInfo-list {
	margin-top: 26px;
    width: 100%;
    padding-right: 40px;
    background-color: white;
}
#noticeImg{
    width: 3%;
    margin-right: 6px;
}
</style>
<div class="card box-shadow d-flex m-4" style="min-height: 87%;">
	<div class="h-100">
		<div class="card-header"
			style="border-radius: 20px 20px 0 0; background-color: #154FA9; font-weight: bold; color: white;">
			학사 공지사항</div>
		<div class="table-padding">
		<div class="header-label"><img id="noticeImg" alt="notice" src="<%=request.getContextPath()%>/resources/images/file-icons/noticeImg.png">NOTICE&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;
			<span class="header-span">오류대의 새소식을 알립니다.</span>
		</div>

<div class="card gradInfo-list box-shadow">
	<div class="gradInfo-header">
			<div id="searchUI" class="row justify-content-center">
		<div  class="col-auto">
			<form:select path="simpleCondition.searchType" class="form-select" style="height: 45px;">
				<form:option value="" label="전체" />
				<form:option value="writer" label="작성자" />
				<form:option value="title" label="제목" />
				<form:option value="content" label="내용" />
			</form:select>
		</div>
		<div  class="col-auto">
			<form:input path="simpleCondition.searchWord" class="form-control" placeholder="검색어를 입력해 주세요." aria-label="검색어를 입력해 주세요."/>
		</div>
		<div  class="col-auto" style="margin-left: -22px;">
			<input type="button" value="검색" id="searchBtn" class="btn btn-success"/>
			<c:if test="${paging.detailCondition.role == 'ROLE_TS'}">
		        <a href="<c:url value='/academic/acaNoticeInsert.do'/>" class="btn btn-outline-info" style="margin-left: 10px;">새공지사항</a>
		    </c:if>
		</div>
	</div>
        <p style="font-weight: normal; font-size: 13px; margin-top: 17px;">
        	<i class="mdi mdi-check-circle" style="color: green; margin-right: 10px"></i>
        	총 ${totalRecord}건의 게시물이 있습니다.
        </p>
	</div>
<table class="table" style="width: 90%; margin-left: 94px; margin-top: 6px;">
	<thead class="table-light">
		<tr>
			<th style="padding-left: 50px;">번호</th>
			<th style="padding-left: 200px;">제목</th>
			<th>작성자</th>
			<th style="padding-left: 3px;">첨부파일</th>
			<th style="padding-left: 35px;">게시일</th>
			<th style="padding-left: 5px;">조회수</th>
		</tr>
	</thead>
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
						<td style="padding-left: 50px; width: 11%;">${acaNotice.rnum }</td>
						<td style="width: 50%"><a href="${viewURL }">${acaNotice.anTitle }</a></td>
						<td style="width: 11%">${acaNotice.anWriter }</td>
						<td>
							<c:choose>
								<c:when test="${not empty acaNotice.atchFileId }">
									<i class="mdi mdi-paperclip" style="color: slategray; transform: rotate(140deg);  display: inline-block;"></i>
								</c:when>
								<c:otherwise>
<!-- 									첨부파일 없을 때  -->
								</c:otherwise>
							</c:choose>
						</td>
						<td>${acaNotice.anPostDate }</td>
						<td>${acaNotice.anViews }</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</tbody>
</table>
<div class="d-flex justify-content-center mb-3 mt-4">
				${paging.pagingHTML }</div>
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
</script>




