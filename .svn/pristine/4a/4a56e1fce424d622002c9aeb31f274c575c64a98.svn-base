<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<style>
.gradInfo {
	background-color: rgba(0, 0, 0, 0.03);
	margin: 20px;
	padding-right: 40px;
	font-family: 'Noto Sans KR', sans-serif;
}
.gradInfo-header {
	margin: 20px 0 20px 40px;
	font-size: 14px;
	font-weight: bold;
}
.gradInfo-list {
    margin: 22px 0 22px 32px;
    width: 96%;
    padding-right: 40px;
    background-color: white;
}
.btnInfo{
	display: flex;
    justify-content: end;
	margin-bottom: 17px;
}
</style>
<script src="${pageContext.request.contextPath}/resources/js/ckeditor/ckeditor.js"></script>
<form:form method="post" modelAttribute="acaNotice" enctype="multipart/form-data">
<form:hidden path="anNum"/>
<div class="card box-shadow d-flex m-4" style="min-height: 87%;">
	<div class="h-100">
		<div class="card-header"
			style="border-radius: 20px 20px 0 0; background-color: #154FA9; font-weight: bold; color: white;">
			학사 공지사항</div>
	<div class="card gradInfo-list box-shadow">
		<div class="gradInfo-header">
			<i class="mdi mdi-lead-pencil" style="color: green;"></i> 
				공지사항 수정란 
		</div>
	<table class="table table-bordered" style="width: 98%; margin: 0 0 23px 35px;">
		<tr>
			<th style="padding-left: 50px;">제목</th>
			<td>
				<form:input path="anTitle" class="form-control" />
				<form:errors path="anTitle" class="error" />
			</td>
		</tr>
		<tr>
			<th style="padding-left: 50px;">내용</th>
			<td>
				<form:textarea path="anCont" class="form-control" />
				<form:errors path="anCont" class="error" />
			</td>
		</tr>
		<tr>
			<th style="padding-left: 50px;">기존 첨부파일</th>
			<td>
				<c:if test="${not empty acaNotice.fileGroup and not empty acaNotice.fileGroup.detailList }">
					<c:forEach items="${acaNotice.fileGroup.detailList }" var="fileDetail">
						<c:url value="/academic/download.do" var="downloadURL">
							<c:param name="atchFileId" value="${fileDetail.atchFileId }" />
							<c:param name="fileSn" value="${fileDetail.fileSn }" />
						</c:url>
						<a href="${downloadURL }">${fileDetail.orignlFileNm }</a>
					</c:forEach>
				</c:if>
			</td>
		</tr>
		<tr>
			<th style="padding-left: 50px;">새 첨부파일</th>
			<td>
				<input type="file" name="acaNoticeFiles" multiple />
			</td>
		</tr>
	</table>
	<div class="btnInfo">
			<c:url value='/academic/acaNoticeList.do' var="ListURL">
				<c:param name="what" value="${acaNotice.anNum }" />
			</c:url>
				<input type="submit" id="updateBtn" class="btn btn-outline-info" value="수정">
				<a class="btn btn-outline-secondary" style="margin-left: 5px;" href="${ListURL }">취소</a>
		</div>
	</div>
	</div>
	</div>
</form:form>
<script>
 	CKEDITOR.replace('anCont', {
       	filebrowserImageUploadUrl: '${pageContext.request.contextPath }/academic/uploadImage.do',
       	height: '300px'
 	});
 	
 	$(updateBtn).on("click",function(e){
        e.preventDefault();
        Swal.fire({
           title: '공지사항을 수정하시겠습니까?',
           //text: '다시 되돌릴 수 없습니다. 신중하세요.',
           icon: 'question',
           
           showCancelButton: true, // cancel버튼 보이기. 기본은 원래 없음
           confirmButtonColor: '#3085d6', // confrim 버튼 색깔 지정
           cancelButtonColor: '#d33', // cancel 버튼 색깔 지정
           confirmButtonText: '수정', // confirm 버튼 텍스트 지정
           cancelButtonText: '취소', // cancel 버튼 텍스트 지정
           
           reverseButtons: false, // 버튼 순서 거꾸로
           
        }).then(result => {
           // 만약 Promise리턴을 받으면,
           if (result.isConfirmed) { // 만약 모달창에서 confirm 버튼을 눌렀다면
              Swal.fire('공지사항이 수정되었습니다.', '', 'success').then(()=>{
	              $(acaNotice).submit();
              });
           }
        });
  	})
</script>
