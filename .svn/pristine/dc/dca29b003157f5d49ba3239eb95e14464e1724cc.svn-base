<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="card">
	<div class="card-body">
		<table class="table table-border">
			<tr>
				<th>이름</th>
				<td>${clubMemberView.stNm }</td>
				<th>학번</th>
				<td>${clubMemberView.stCd }</td>
			</tr>
			<tr>
				<th>학과</th>
				<td>${clubMemberView.dtNm }</td>
				<th>전화번호</th>
				<td>${clubMemberView.stPh }</td>
			</tr>
			<tr>
				<th>이메일</th>
				<td>${clubMemberView.stEmail }</td>
				<th>신청일자</th>
				<td>${clubMemberView.clubAppDate }</td>
			</tr>
		</table>
	</div>
</div>

<div class="card">
	<div class="card-body">
		<form:form modelAttribute="clubMem" method="post"
			enctype="multipart/form-data" class="form">

			<table class="table table-border">
				<tr>
					<th>신청한 이유</th>
					<td>${clubMemberView.clubAppCon }</td>
				</tr>
				<tr>
					<th>활동 계획</th>
					<td>${clubMemberView.clubMemPlan }</td>
				</tr>
				
				<tr>
					<td colspan="2">
						<div class="d-flex justify-content-left">
							<input type= button class="btn btn-outline-success" value="승인" id="pa" > 
							<input class="btn btn-outline-danger" type=button value="거절" id="noPa">
							<input class="btn btn-outline-secondary" type="reset" value="뒤로가기" onclick="history.back();">
						</div>
					</td>
				</tr>
			</table>
		</form:form>
	</div>
</div>

<script>
$(pa).on("click",function(e){
    e.preventDefault();
    Swal.fire({
       title: '${clubMemberView.stNm } 학생을 입부시키겠습니까?',
       //text: '다시 되돌릴 수 없습니다. 신중하세요.',
       icon: 'question',
       
       showCancelButton: true, // cancel버튼 보이기. 기본은 원래 없음
       confirmButtonColor: '#3085d6', // confrim 버튼 색깔 지정
       cancelButtonColor: '#d33', // cancel 버튼 색깔 지정
       confirmButtonText: '확인', // confirm 버튼 텍스트 지정
       cancelButtonText: '취소', // cancel 버튼 텍스트 지정
       
       reverseButtons: false, // 버튼 순서 거꾸로
       
    }).then(result => {
       // 만약 Promise리턴을 받으면,
       if (result.isConfirmed) { // 만약 모달창에서 confirm 버튼을 눌렀다면
          Swal.fire('입부 처리되었습니다.', '', 'success').then(()=>{
        	  pass();
          });
       }
    });
	});
	
	$(noPa).on("click",function(e){
        e.preventDefault();
        Swal.fire({
           title: '${clubMemberView.stNm } 학생을 입부 거절시키겠습니까?',
           //text: '다시 되돌릴 수 없습니다. 신중하세요.',
           icon: 'question',
           
           showCancelButton: true, // cancel버튼 보이기. 기본은 원래 없음
           confirmButtonColor: '#3085d6', // confrim 버튼 색깔 지정
           cancelButtonColor: '#d33', // cancel 버튼 색깔 지정
           confirmButtonText: '확인', // confirm 버튼 텍스트 지정
           cancelButtonText: '취소', // cancel 버튼 텍스트 지정
           
           reverseButtons: false, // 버튼 순서 거꾸로
           
        }).then(result => {
           // 만약 Promise리턴을 받으면,
           if (result.isConfirmed) { // 만약 모달창에서 confirm 버튼을 눌렀다면
              Swal.fire('입부 거절 처리되었습니다.', '', 'success').then(()=>{
            	  noPass();
              });
           }
        });
  	});

function pass(){
	window.location.href = "${pageContext.request.contextPath}/clubMember/clubMemberInsertPass.do?who=${clubMemberView.stCd}&club=${clubMemberView.clubCd}";  
}

function noPass(){
	window.location.href = "${pageContext.request.contextPath}/clubMember/clubMemberInsertNoPass.do?who=${clubMemberView.stCd}&club=${clubMemberView.clubCd}";  
}

if(message)
{
	alert(message);
	}
</script>