<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<script src="${pageContext.request.contextPath}/resources/js/ckeditor/ckeditor.js"></script>
<form:form method="post" modelAttribute="aBRVO" enctype="multipart/form-data">
<form:hidden path="buReSn"/>

<table class="table">
<tr><td><h4><br>학술사업보고서</h4></td></tr>
</table>

	<table class="table table-bordered">
	
	<tr>
			<th>학술사업코드</th>
			<td><form:input path="acBuCd" class="form-control"
					id="categoryInput" readonly="true" /> <form:errors path="acBuCd"
					class="error" />
				<button type="button" class="btn btn-primary" data-bs-toggle="modal"
					data-bs-target="#exampleModal">사업코드변경</button> <!-- Modal -->
				<div class="modal fade" data-url="${viewURL }" id="exampleModal"
					tabindex="-1" aria-labelledby="exampleModalLabel"
					aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<h1 class="modal-title fs-5" id="exampleModalLabel">학술사업코드선택</h1>
								<button type="button" class="btn-close" data-bs-dismiss="modal"
									aria-label="Close"></button>
							</div>
							<div class="modal-body">
								<a href="#" onclick="selectCategory('A001');">신기술연구사업(A001)
									: 신기술을 연구하는 사업</a><br>
								<hr />
								<a href="#" onclick="selectCategory('B001');">기초과학사업(B001) :
									기초과학을 연구하는 사업</a><br>
								<hr />
								<a href="#" onclick="selectCategory('C001');">교육발전사업(C001) :
									교육 산업 발전을 연구하는 사업</a><br>
								<hr />
								<a href="#" onclick="selectCategory('D001');">사회조사분석사업(D001)
									: 사회의 현황 등을 조사하고 분석하는 사업</a><br>
								<hr />
								<pre>선택한 코드 : <input id="modalInput" disabled="disabled" />
								</pre>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-secondary"
									data-bs-dismiss="modal">완료</button>
							</div>
						</div>
					</div>
				</div>
			</td>
		</tr>
	
	
		<tr>
			<th>제목</th>
			<td>
				<form:input path="buReNm" class="form-control" />
				<form:errors path="buReNm" class="error" />
			</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>
				<form:input path="buReAutNm" class="form-control" />
				<form:errors path="buReAutNm" class="error" />
			</td>
		</tr>
		<tr>
			<th>내용(요약)</th>
			<td>
				<form:textarea path="buReShortCont" class="form-control" />
				<form:errors path="buReShortCont" class="error" />
			</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>
				<form:textarea path="buReCont" class="form-control" />
				<form:errors path="buReCont" class="error" />
			</td>
		</tr>
		<tr>
			<th>기존 첨부파일</th>
			<td>
				<c:if test="${not empty aBRVO.fileGroup and not empty aBRVO.fileGroup.detailList }">
					<c:forEach items="${aBRVO.fileGroup.detailList }" var="fileDetail">
						<c:url value="/academicBusinessReport/download.do" var="downloadURL">
							<c:param name="atchFileId" value="${fileDetail.atchFileId }" />
							<c:param name="fileSn" value="${fileDetail.fileSn }" />
						</c:url>
						<a href="${downloadURL }">${fileDetail.orignlFileNm }</a>
					</c:forEach>
				</c:if>
			</td>
		</tr>
		<tr>
			<th>새 첨부파일</th>
			<td>
				<input type="file" name="aBRFiles" multiple />
			</td>
		</tr>
		<tr>
			<c:url value='/academicBusinessReport/aBRList.do' var="ListURL">
				<c:param name="what" value="${aBRVO.buReSn }" />
			</c:url>
			
			<td colspan="2">
				<input type="submit" class="btn btn-primary" value="저장">
<!-- 				<input type="reset" class="btn btn-danger" value="취소"> -->
				<a class="btn btn-danger" href="${ListURL }">취소</a>
			</td>
		</tr>
	</table>
</form:form>
<script>
 	CKEDITOR.replace('buReCont', {
       	filebrowserImageUploadUrl: '${pageContext.request.contextPath }/uploadImage.do'
 	});
</script>

<script>
	// 모달 창 열기 함수
	function openModal() {
		document.getElementById('myModal').style.display = 'flex';
	}

	// 모달 창 닫기 함수
	function closeModal() {
		document.getElementById('myModal').style.display = 'none';
	}

	// 선택한 카테고리를 입력 필드에 설정하는 함수
	function selectCategory(category) {
		document.getElementById('categoryInput').value = category;
		document.getElementById('modalInput').value = category;

		closeModal();
	}
</script>