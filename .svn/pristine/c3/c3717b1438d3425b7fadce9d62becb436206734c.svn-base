<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<form:form method="post" modelAttribute="subject" style="margin-top: -36px;">
	<table class="table">
		<tr>
			<th>과목코드</th>
			<c:if test="${empty subject.subjCd }">
				<td>과목코드는 자동으로 입력됩니다.</td>
			</c:if>
			<td>${subject.subjCd }</td>
		</tr>
		<tr>
			<th>단대</th>
			<td><select id="cl" name="college" class="form-select">
					<option value>단대선택</option>
					<c:forEach items="${collegeList }" var="college">
						<option value="${college.colgeCd }">${college.colgeNm }</option>
					</c:forEach>
			</select> <span class="error">${errors["college"]}</span></td>
		</tr>
		<tr>
			<th>학과</th>
			<td><form:select id="dt" path="dtCd" class="form-select">
					<form:option value="" label="학과선택" />
					<c:forEach items="${departmentList}" var="department">
						<form:option value="${department.dtCd }"
							class="${department.colgeCd }" label="${department.dtNm }" />
					</c:forEach>
				</form:select></td>
		</tr>
		<tr>
			<th>과목명</th>
			<td><form:input id="subjNm" path="subjNm" class="form-control"
					type="text" value="${subject.subjNm }" /> <form:errors
					path="subjNm" class="error" /></td>
		</tr>
		<tr>
			<th>이수구분</th>
			<td><form:select id="subjComType" path="subjComType"
					class="form-select">
					<form:option value="" label="이수구분선택" />
					<form:options items="${classificationList }" itemLabel="cfName"
						itemValue="cfCode" />
				</form:select> <form:errors path="subjComType" class="error" />
			</td>
		</tr>
	</table>
	<div class="row justify-content-center">
		<div class="col-6"></div>
		<c:if test="${empty subject.subjCd }">
		<div class="col">
			<input id="submitBtn" class="btn btn-outline-success" style="border-radius: 10px;" type="button" value="등록">
		</c:if> 
		<c:if test="${not empty subject.subjCd }">
		<div class="col">
			<input id="submitBtn2" class="btn btn-outline-success" style="border-radius: 10px;" type="button" value="수정">
		</c:if>
		<c:url value='/subject/mngSubjectList.do' var="ListURL" />
		 <a class="btn btn-outline-danger" style=" border-radius: 10px;" href="${ListURL }">취소</a>
		</div>
</div>	 	 
</form:form>
<script>
 	let $dt = $('#dt');
 	$('#cl').on("change", function(event){
 		let colgeCd = $(this).val();
		if(colgeCd){
			$dt.find("option").hide();
			$dt.find(`option:first`).show();
 			$dt.find(`option.\${colgeCd}`).show();
 		}else{
 			$dtCd.find("option").show();
 		}
 	}).trigger("change");
</script>
<script>
// 등록버튼에 스윗 알람
$('#submitBtn').on('click', function () {
        Swal.fire({
            title: '과목을 등록하시겠습니까?',
            icon: 'info',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: '등록',
            cancelButtonText: '취소',
        }).then(result => {
            if (result.isConfirmed) {
            	insertSubject();
            }
        });
});
// 등록 펑션
function insertSubject() {
	event.preventDefault();
    const dtc = $dt.val(); // 학과코드
    const subjNm = $("#subjNm").val(); // 과목명
    const subjComType = $("#subjComType").val(); // 이수구분
    console.log(subjComType);
    
    if (dtc === "") {
    	Swal.fire({
    		  title:'학과를 선택 해주세요.',
    		  icon: 'info',
   		});
        return;
    }
    if (subjNm === "") {
    	Swal.fire({
  		  title:'과목명을 입력 해주세요.',
  		  icon: 'info',
 		});
        return;
    }
    if (subjComType === "") {
        Swal.fire({
    		  title:'이수구분을 선택 해주세요.',
    		  icon: 'info',
   		});
        return;
    }
    const postData = {
        dtCd: dtc,
        subjNm: subjNm,
        subjComType: subjComType
    };

    $.ajax({
        url: "/oryuUniversity/subject/subjectInsert.do",
        type: "post",
        data: JSON.stringify(postData),
        contentType: "application/json",
        success: function(response) {
        	Swal.fire({
        		  title:response,
        		  icon: 'success',
       		}).then(result => {
				if (result.isConfirmed) { // 만약 모달창에서 confirm 버튼을 눌렀다면
					window.location.href="<%=request.getContextPath()%>/subject/mngSubjectList.do";
				}
	     	})
        },
        error: function(error) {
        	Swal.fire({
      		  title:error,
      		  icon: 'error',
     		});
        }
    });
};
// 수정버튼 스윗알람
$('#submitBtn2').on('click', function () {
    Swal.fire({
        title: '과목을 수정하시겠습니까?',
        icon: 'info',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: '수정',
        cancelButtonText: '취소',
    }).then(result => {
        if (result.isConfirmed) {
        	updateSubject();
        }
    });
});
// 수정 펑션
function updateSubject() {
	event.preventDefault();
	const subjCd = "${subject.subjCd}"; // 강의 코드
    const dtc = $dt.val(); // 학과코드
    const subjNm = $("#subjNm").val(); // 과목명
    const subjComType = $("#subjComType").val(); // 이수구분
    console.log(subjComType);
    
    if (dtc === "") {
    	Swal.fire({
    		  title:'학과를 선택 해주세요.',
    		  icon: 'info',
   		});
        return;
    }
    if (subjNm === "") {
    	Swal.fire({
  		  title:'과목명을 입력 해주세요.',
  		  icon: 'info',
 		});
        return;
    }
    if (subjComType === "") {
        Swal.fire({
    		  title:'이수구분을 선택 해주세요.',
    		  icon: 'info',
   		});
        return;
    }

    const postData = {
    	subjCd: subjCd,
        dtCd: dtc,
        subjNm: subjNm,
        subjComType: subjComType
    };

	$.ajax({
        url: "/oryuUniversity/subject/subjectUpdate.do",
        type: "post",
        data: JSON.stringify(postData),
        contentType: "application/json",
        success: function(response) {
        	Swal.fire({
      		  title:response,
      		  icon: 'success',
     		}).then(result => {
				if (result.isConfirmed) { // 만약 모달창에서 confirm 버튼을 눌렀다면
					window.location.href="<%=request.getContextPath()%>/subject/mngSubjectList.do";
				}
			})
		},
		error : function(error) {
			Swal.fire({
	      		  title:error,
	      		  icon: 'error',
     		});
		}
	});
};
</script>