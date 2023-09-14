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
<form:form method="post" modelAttribute="notice" enctype="multipart/form-data">
<form:hidden path="lnNum"/>
<div class="card box-shadow d-flex m-4" style="min-height: 87%;">
	<div class="h-100">
		<div class="card-header"
			style="border-radius: 20px 20px 0 0; background-color: #154FA9; font-weight: bold; color: white;">
			강의 공지사항</div>
			<div class="card gradInfo-list box-shadow">
		<div class="gradInfo-header">
			<i class="mdi mdi-lead-pencil" style="color: green;"></i> 
				새 공지사항 작성란
		</div>
	<table class="table table-bordered" style="width: 98%; margin: 0 0 23px 35px;">
		<tr>
			<th style="padding-left: 50px;">제목</th>
			<td>
				<form:input path="lnTitle" class="form-control" />
				<form:errors path="lnTitle" class="error"/>
			</td>
		</tr>
		<tr>
			<th style="padding-left: 50px;">내용</th>
			<td>
				<form:textarea path="lnCont" class="form-control "/>
				<form:errors path="lnCont" class="error" />
			</td>
		</tr>
		<tr>
			<th style="padding-left: 50px;">첨부파일</th>
			<td>
				<input type="file" name="noticeFiles" multiple />
			</td>
		</tr>
	</table>
		<div class="btnInfo">
			<input type="submit" id="insertBtn" class="btn btn-outline-info" value="저장" >
			<a class="btn btn-outline-secondary" href="${pageContext.request.contextPath}/lecture/noticeList.do?lecCd=${lecCd }">취소</a>
		</div>
	</div>
	</div>
	</div>
</form:form>
<script>
	CKEDITOR.replace('lnCont', {
   		filebrowserImageUploadUrl: '${pageContext.request.contextPath }/uploadImage.do',
   		height: '300px'
	});
	
	$(insertBtn).on("click",function(e){
        e.preventDefault();
        Swal.fire({
           title: '공지사항을 등록하시겠습니까?',
           icon: 'question',
           
           showCancelButton: true, // cancel버튼 보이기. 기본은 원래 없음
           confirmButtonColor: '#3085d6', // confrim 버튼 색깔 지정
           cancelButtonColor: '#d33', // cancel 버튼 색깔 지정
           confirmButtonText: '등록', // confirm 버튼 텍스트 지정
           cancelButtonText: '취소', // cancel 버튼 텍스트 지정
           
           reverseButtons: false, // 버튼 순서 거꾸로
           
        }).then(result => {
           if (result.isConfirmed) { 
              Swal.fire('공지사항이 등록되었습니다.', '', 'success').then(()=>{
	              $(notice).submit();
              });
           }
        });
  	})
</script>

