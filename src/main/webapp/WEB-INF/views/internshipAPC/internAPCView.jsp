<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<style>
.mb-3 {
		margin-bottom: 1.6rem !important;
	}
</style>


<div class="card box-shadow d-flex m-4" style="min-height: 87%;">
   <div class="h-100">
      <div class="custom-card">
         <div class="card-header" style="border-radius: 20px 20px 0 0; background-color:#154FA9; font-weight:bold; color:white;">인턴십 신청서 상세정보</div>
         <div class="card-body">
<form:form method="post" modelAttribute="internAPC" enctype="multipart/form-data">
	<table class="table table-border" style="margin-left: 109px;
    width: 84%;">	
			<c:if test="${not empty internAPC.inteCd }">
				<tr hidden="true">
					<th>신청한 인턴십 코드</th>
				<td><input type="hidden" name="inteCd" value="${internAPC.inteCd}" readonly>${intern.inteCd}</td>
			</tr>
			</c:if>
			
			<c:if test="${not empty internAPC.iaCd }">
			<tr hidden="true">
				<th>신청코드</th>
			<td><input type="text" name="iaCd" value="${internAPC.iaCd}" readonly></td>
			</tr>
			</c:if>
	</table>
			<div class="card box-shadow d-flex m-4" style="height: 765px;">
		<div class="container mt-5">
		<div class="row">
			<div class="col-md-4">
				<div class="mb-3">
					<label class="form-label">회사명</label>
					<form:input path="inteCompNm" class="form-control"  readonly="true" />
				</div>
				<div class="mb-3">
					<label class="form-label">학번</label>
					<form:input path="stCd" class="form-control" readonly="true" />
				</div>
				<div class="mb-3">
					<label class="form-label">이름</label>
					<form:input path="studentVO.stNm" class="form-control"  readonly="true" />
				</div>
				<div class="mb-3">
					<label class="form-label">학과</label>
					<form:input path="departmentVO.dtNm" class="form-control"  readonly="true" />
				</div>
			</div>
			<div class="col-md-4">
				<div class="mb-3">
					<label class="form-label">이메일</label>
					<form:input path="studentVO.stEmail" type="email" class="form-control"  readonly="true" />
				</div>
				<div class="mb-3">
					<label class="form-label">주소</label>
					<div class="input-group">
						<form:input path="studentVO.stAddr1" id="address" class="form-control" readonly="true" />
					</div>
				</div>
				<!-- 상세주소 입력 -->
				<div class="mb-3">
					<label class="form-label">상세주소</label>
					<form:input path="studentVO.stAddr2"  class="form-control"  readonly="true" />
				</div>
				<div class="mb-3">
					<label class="form-label">전화번호</label>
					<form:input path="studentVO.stPh" class="form-control" readonly="true" />
				</div>
			</div>
			<div class="col-md-4">
				<label class="form-label">프로필사진</label>
				<div>
					<img 
						src="<c:url value='/resources/profileImages/${internAPC.studentVO.stFic }'/>"
						style="max-width: 350px; max-height: 350px; border: 1px solid #ccc;">
				</div>
			</div>	
			</div>
			<div>
			<label class="form-label">지원 목적 및 동기</label>
				<textarea class="form-control" style="height: 100px; width: 1050px;" readonly="true">${internAPC.iaPur }</textarea>
			</div>
			<div>
			<label class="form-label">졸업 후 계획</label>
				<textarea class="form-control" style="height: 100px; width: 1050px;" readonly="true">${internAPC.iaCou }</textarea>
			</div>
		</div>
	</div>
	<div style="margin-left: 200px;">
				<sec:authorize access="hasRole('ROLE_ST')"><!-- 학생 -->
					<input class="btn btn-secondary" type="reset"value="뒤로가기" onclick="history.back();">				
					<c:if test="${internAPC.iaStat eq '신청'}">
					<input class="btn btn-primary" type="button" value="수정하기" onclick="internshipAPCUpdate()">
					</c:if>
				</sec:authorize>
				<sec:authorize access="hasRole('ROLE_TS')"><!-- 교직원 -->
			    	<c:if test="${internAPC.iaStat eq '신청'}">
			    	<input class="btn btn-success" type="button" value="합격" onclick="internshipAPCPass()">
			    	<input class="btn btn-danger" type="button" value="불합격" onclick="internshipAPCNopass()">
			    	</c:if>
			    	<input class="btn btn-secondary" type="button" value="뒤로가기" onclick="history.back();">
    			</sec:authorize>
	</div>
		
</form:form>
  </div>
   </div>
   </div>
   </div>
   
   
   
   
   
   
   
<script>
var internAPCInteDelete = "${internAPC.inteDelete}";
console.log("확인" + internAPCInteDelete);

function internshipAPCUpdate() {
    if (internAPCInteDelete.trim() === '삭제') {
    	Swal.fire({
    		  title: '삭제된 게시물입니다.',
    		  icon: 'error',
    		  confirmButtonColor: '#3085d6',
    		  confirmButtonText: '확인'
    		});
    } else {
          
    	Swal.fire({
            title: '수정 하시겠습니까?',
            icon: 'question',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: '합격',
            cancelButtonText: '취소',
            reverseButtons: false
        }).then(result => {
            if (result.isConfirmed) {
                Swal.fire('수정되었습니다.', '', 'success').then(() => {
                    // 페이지를 다시로드
                     window.location.href = `${pageContext.request.contextPath}/internshipAPC/internshipAPCUpdate.do?what=${internAPC.iaCd}`;;
                });
            }
        });
    	
    	
    	
                	 
    }
}

function internshipAPCPass() {
    if (internAPCInteDelete.trim() === '삭제') {
    	Swal.fire({
    		  title: '삭제된 게시물입니다.',
    		  icon: 'error',
    		  confirmButtonColor: '#3085d6',
    		  confirmButtonText: '확인'
    		});
    } else {
    	
    	Swal.fire({
            title: '합격 시키겠습니까?',
            icon: 'question',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: '합격',
            cancelButtonText: '취소',
            reverseButtons: false
        }).then(result => {
            if (result.isConfirmed) {
                Swal.fire(`${internAPC.studentVO.stNm}학생이 ${internAPC.inteCompNm}회사의 인턴십에 합격되었습니다.`, '', 'success').then(() => {
                    // 페이지를 다시로드
                    window.location.href = `${pageContext.request.contextPath}/internshipAPC/internshipAPCPass.do?what=${internAPC.iaCd}&stat=${internAPC.iaStat}`;
                });
            }
        });
    }
}

function internshipAPCNopass() {
    if (internAPCInteDelete.trim() === '삭제') {
    	Swal.fire({
    		  title: '삭제된 게시물입니다.',
    		  icon: 'error',
    		  confirmButtonColor: '#3085d6',
    		  confirmButtonText: '확인'
    		});
    } else {
    	Swal.fire({
            title: '불합격 시키겠습니까?',
            icon: 'question',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: '불합격',
            cancelButtonText: '취소',
            reverseButtons: false
        }).then(result => {
            if (result.isConfirmed) {
                Swal.fire("불합격 처리 되엇습니다", '', 'success').then(() => {
                    // 페이지를 다시로드
                   window.location.href = `${pageContext.request.contextPath}/internshipAPC/internshipAPCNopass.do?what=${internAPC.iaCd}&stat=${internAPC.iaStat}`;;
                });
            }
        });
        
    } 
}




	</script>