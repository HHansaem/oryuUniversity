<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<style>
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
				style="border-radius: 20px 20px 0 0; background-color: #154FA9; font-weight: bold; color: white;">알림목록</div>
			<div class="card-body">
					<div class="row justify-content-center">
						<div id="searchUI" class="col-1">
							<form:select path="simpleCondition.searchType"
								class="form-select">
								<form:option value="" label="전체" />
								<form:option value="title" label="제목" />
								<form:option value="sender" label="빌산자" />
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
				</div>
				<div class="row justify-content-center">
					<div class="col-8">
						<table class="table">
							<thead class="table-light">
								<tr>
									<th>게시글번호</th>
									<th>발신자</th>
									<th>제목</th>
									<th>내용</th>
									<th>작성일자</th>
									<th>상태</th>
								</tr>
							</thead>
							<tbody>
								<c:set var="noticeList" value="${paging.dataList }" />
								<c:choose>
									<c:when test="${empty noticeList }">
										<tr data-id="${notice.notiCd}" class="clickable-row">
											<td class="col-8">조건에 맞는 알림이 없음.</td>
										</tr>
									</c:when>
									<c:otherwise>
										<c:forEach items="${noticeList }" var="notice">
											<tr data-id="${notice.notiCd}" class="clickable-row">
												<td class="col-1">${notice.rnum}</td>
												<td class="col-1">${notice.sender}</td>
												<td class="col-1">${notice.notiTitle}</td>
												<td class="col-1">${notice.notiCont}</td>
												<td class="col-1">${notice.notiDate}</td>
												<td class="col-1">
													<c:choose>
														<c:when test="${notice.notiStat eq '1'}">
															<span class="badge badge-success"> <c:out value="읽음" />
															</span>
														</c:when>
														<c:when test="${notice.notiStat eq '2'}">
															<span class="badge badge-danger"> <c:out value="안읽음" />
															</span>
														</c:when>
													</c:choose>
												</td>
											</tr>
										</c:forEach>
									</c:otherwise>
								</c:choose>
							</tbody>
							<tfoot>
								<tr>
									<td colspan="8">
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
<!-- 검색조건 받기 -->
<form:form id="searchForm" modelAttribute="simpleCondition" method="get">
	<form:hidden path="searchType" />
	<form:hidden path="searchWord" />
	<input type="hidden" name="page" />
</form:form>
<!-- modal body -->
<div class="modal" data-url="${viewURL}" id="staticBackdrop"
	tabindex="-1">
	<div
		class="modal-dialog modal-xl modal-dialog-centered modal-fullscreen-sm-down">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">강의 등록</h5>
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<div class="modal-body"></div>

		</div>
	</div>
</div>
<div class="modal" data-url="${viewURL}" id="staticBackdrop"
	tabindex="-1">
	<div
		class="modal-dialog modal-xl modal-dialog-centered modal-fullscreen-sm-down">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">알림 등록</h5>
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<div class="modal-body"></div>

		</div>
	</div>
</div>
<div class="modal" data-url="${viewURL}" id="staticBackdrop2"
	tabindex="-1">
	<div class="modal-dialog modal-xl modal-dialog-centered modal-fullscreen-sm-down">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">알림 상세</h5>
				<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			</div>
			<div class="modal-body"></div>
		</div>
	</div>
</div>		
<!-- 검색조건 받기 -->
<form:form id="searchForm" modelAttribute="simpleCondition" method="get">
<form:hidden path="searchType" />
<form:hidden path="searchWord" />
<input type="hidden" name="page" />
</form:form>
<script>
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
		$(searchForm).submit();
	});
//알림 등록
$(staticBackdrop).on('show.bs.modal',function(event){
       let $modalBody = $(this).find(".modal-body");
          let setting = {
            url : `${pageContext.request.contextPath}/notice/noticeInsert.do`,
            success : function(resp) {
               $modalBody.html(resp);
            }
         };
         $.ajax(setting);
}).on('hidden.bs.modal',function(){
   let $modalBody = $(this).find(".modal-body");
   $modalBody.empty();
});
</script>
<script>
document.addEventListener("DOMContentLoaded", function() {
    $(".clickable-row").on("click", function() {
        var id = $(this).data("id");
        // 모달 열기
        $("#staticBackdrop2").modal("show");
        // 모달 내용 로드
        let $modalBody = $("#staticBackdrop2").find(".modal-body");
        let setting = {
            url: `${pageContext.request.contextPath}/notice/notificationView.do`,
            data : {
            	notiCd : id
            },
            success: function(resp) {
                $modalBody.html(resp);
            }
        };
        $.ajax(setting);
    })
})
</script>





