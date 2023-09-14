<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
				<form:form modelAttribute="videoLecture" method="post"
					enctype="multipart/form-data" class="form" id="videoForm">

					<form:hidden path="lecCd" class="form-control" />
					<tr>
						<th>제목</th>
						<td><form:input path="vlTitle" class="form-control"
								type="text" /> <form:errors path="vlTitle" class="error" /></td>
					</tr>
					<tr>
						<th>내용</th>
						<td><form:textarea path="vlCont"
								class="form-control form-control-lg" rows="15" /> <form:errors
								path="vlCont" class="error" /></td>
					</tr>
					<tr class="mt-2">
						<th>마감기한</th>
						<td><form:input path="vlEndTime"
								class="form-control col-sm-3" type="datetime-local" /> <form:errors
								path="vlEndTime" class="error" /></td>
					</tr>
					<tr class="mt-2">
						<c:forEach var="fileDetail" items="${videoLecture.fileGroup.detailList}">
						<th>기존파일</th>
						<td><input type="text" class="form-control col-sm-3" value="${fileDetail.orignlFileNm}" readonly></input></td>
						</c:forEach>
					</tr>
					<tr class="mt-2">
						<th>파일</th>
						<td><form:input path="vlFile" class="form-control col-sm-3"
								type="file" accept="video/*" /> 
							<form:errors path="vlFile" class="error" /></td>
					</tr>
					<tr>
						<div class="d-flex justify-content-end">
								<input type="button" class="btn btn-outline-primary mr-2" id="auto" value="자동완성"></input>
								<input type="button" class="btn btn-outline-primary mr-2" id="insertBtn" value="등록"></input> 
								<a class="btn btn-outline-secondary" href="<%=request.getContextPath()%>/lecture/videoLectureList.do?lecCd=${lecCd}">목록</a>
						</div>
					</tr>
				</form:form>
			</div>
		</div>
	</div>
</div>

<script>
	CKEDITOR
			.replace(
					'vlCont',
					{
						// 현재 보내는 주소 설정
						filebrowserImageUploadUrl : '${pageContext.request.contextPath }/uploadImage.do'
					});
	
	$(insertBtn).on("click",function(e){
		e.preventDefault();
		Swal.fire({
		   title: '동영상 강의를 등록하시겠습니까?',
		   icon: 'info',
		   
		   showCancelButton: true, // cancel버튼 보이기. 기본은 원래 없음
		   confirmButtonColor: '#3085d6', // confrim 버튼 색깔 지정
		   cancelButtonColor: '#d33', // cancel 버튼 색깔 지정
		   confirmButtonText: '등록', // confirm 버튼 텍스트 지정
		   cancelButtonText: '취소', // cancel 버튼 텍스트 지정
		   
		   reverseButtons: true, // 버튼 순서 거꾸로
		   
		}).then(result => {
		   // 만약 Promise리턴을 받으면,
		   if (result.isConfirmed) { // 만약 모달창에서 confirm 버튼을 눌렀다면
		   
		      Swal.fire('등록이 완료되었습니다.', '', 'success').then((result2)=>{
		    	  if(result2.isConfirmed){
			      	$(videoForm).submit();
		    	  }
		      });
		   }
		});
	})
	
	$(document).ready(function(){
			$("#auto").on("click",function(){
				var editor = CKEDITOR.instances.vlCont;
				$("#vlTitle").val("파이썬프로그래밍 16주차 동영상강의입니다.");
				$("#vlEndTime").val("2023-09-15T12:00");
				editor.setData("파이썬프로그래밍 16주차 동영상강의입니다. 수강생들은 정해진 기한내에 끝까지 시청해주시기 바랍니다.");
			});
	})
</script>