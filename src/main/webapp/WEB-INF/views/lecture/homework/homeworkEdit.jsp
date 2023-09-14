<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script
	src="${pageContext.request.contextPath }/resources/js/ckeditor/ckeditor.js"></script>

<style>
.form-control[readonly]{
	background-color:white;
}
</style>

<div class="card box-shadow d-flex m-4" style="min-height: 87%;">
	<div class="h-100">
		<div class="card">
			<div class="card-body">
				<form:form modelAttribute="homework" method="post"
					enctype="multipart/form-data" class="form" id="assignForm">

					<form:hidden path="lecCd" class="form-control" />
					<tr>
						<th>제목</th>
						<td><form:input path="assiNm" class="form-control"
								type="text" /> <form:errors path="assiNm" class="error" /></td>
					</tr>
					<tr>
						<th>내용</th>
						<td><form:textarea path="assiCont"
								class="form-control form-control-lg" rows="15" /> <form:errors
								path="assiCont" class="error" /></td>
					</tr>
					<tr>
						<th>마감기한</th>
						<td><form:input path="assiPeriod"
								class="form-control col-sm-3" type="datetime-local" /> <form:errors
								path="assiPeriod" class="error" /></td>
					</tr>
					<tr>
						<th>기존파일</th>
						<c:forEach var="fileDetail" items="${homework.fileGroup.detailList}">
						<td><input type="text" class="form-control col-sm-3" value="${fileDetail.orignlFileNm}" readonly></input></td>
						</c:forEach>
					</tr>
					<tr>
						<th>새파일</th>
						<td><form:input path="asFiles" class="form-control col-sm-3"
								type="file" multiple="multiple" /> <form:errors path="asFiles"
								class="error" /></td>
					</tr>
					<tr>
						<th>배점</th>
						<td><form:input path="assiScore" class="form-control"
								type="number" style="width: 10%;" /> <form:errors
								path="assiScore" class="error" /></td>
					</tr>
					<tr>
						<div class="d-flex justify-content-end">
							<td colspan="2"><input type="button"
								class="btn btn-primary mr-2" value="등록" id="homeworkModifyBtn"/> <a
								class="btn btn-secondary"
								href="${pageContext.request.contextPath}/lecture/homeworkList.do?lecCd=${homework.lecCd}">취소</a>
							</td>
						</div>
					</tr>
				</form:form>
			</div>
		</div>
	</div>
</div>

<script>
	CKEDITOR.replace('assiCont',
					{
						filebrowserImageUploadUrl : '${pageContext.request.contextPath }/uploadImage.do'
					});
	
	$("#homeworkModifyBtn").on("click",function () {
        Swal.fire({
          title: '과제를 수정하시겠습니까?',
          icon: 'info',
          showCancelButton: true,
          confirmButtonColor: '#3085d6',
          cancelButtonColor: '#d33',
          confirmButtonText: '확인',
          cancelButtonText: '취소',
          reverseButtons: true, // 버튼 순서 거꾸로
        }).then((result) => {
        	if (result.isConfirmed) {
	            Swal.fire({
	              title:'과제가 수정되었습니다.',
	              icon:'success',
	            }).then((result2) => {
	            	if(result2.isConfirmed){
	            		$(assignForm).submit();
	            	}
	            });
        	}
        });
	});
</script>