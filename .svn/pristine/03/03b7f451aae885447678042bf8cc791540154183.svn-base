<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<script
	src="${pageContext.request.contextPath }/resources/js/ckeditor/ckeditor.js"></script>

<div class="card box-shadow d-flex m-4" style="min-height: 87%;">
	<div class="h-100">
		<div class="card">
			<div class="card-body">
				<form:form modelAttribute="homework" method="post"
					enctype="multipart/form-data" class="form" id="homeworkForm">

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
						<th>파일</th>
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
							<td colspan="3">
							<input type="button" class="btn btn-outline-primary mr-2" id="auto" value="자동완성"></input>
							<input type="submit" class="btn btn-outline-primary mr-2" value="등록" id="insertBtn"/> 
							<a class="btn btn-outline-secondary" href="${pageContext.request.contextPath}/lecture/homeworkList.do?lecCd=${homework.lecCd}">취소</a>
							</td>
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
					'assiCont',
					{
						// 현재 보내는 주소 설정
						filebrowserImageUploadUrl : '${pageContext.request.contextPath }/uploadImage.do'
					});
	$(insertBtn).on("click",function(e){
			e.preventDefault();
			Swal.fire({
			   title: '과제를 등록하시겠습니까?',
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
				      	$(homeworkForm).submit();
			    	  }
			      });
			   }
			});
		
	});
	
	$(document).ready(function(){
			$("#auto").on("click",function(){
				var editor = CKEDITOR.instances.assiCont;
				$("#assiNm").val("파이썬프로그래밍 16주차 과제");
				$("#assiPeriod").val("2023-09-15T12:00");
				$("#assiScore").val(10);
				editor.setData("수강생들은 파일을 다운받아서 파이썬 문제를 풀고 정답을 작성해서 한글파일로 15일까지 제출해주세요.");
			});
	});
</script>
