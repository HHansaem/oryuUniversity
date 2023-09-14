<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div class="container">
<table class="table table-border">
	<form:form method="post" modelAttribute="student">
		<tr>
			<th>학생코드</th>
			<td class="col-sm-1">
				<form:input id="stCd" path="stCd"/>
			</td>
			<th>취업연도</th>
			<td class="col-sm-1">
			     <select id="empYear" name="empYear"  class="form-select">
						<option value=>연도선택</option>
						<option value="2019">2019</option>
						<option value="2020">2020</option>
						<option value="2021">2021</option>
						<option value="2022">2022</option>
	            </select>
			</td>
		</tr>
		<tr>
			<th>취업상태</th>
			<td class="col-sm-1">
				<form:radiobutton id="empStat" class="form-check-label" path="empStat" value="취업"/>취업
				<form:radiobutton id="empStat" path="empStat" value="미취업"/>미취업
			</td>
			<th>취업분야</th>
			<td class="col-sm-1">
				<form:radiobutton id="empField" path="empField" value="공기업"/>공기업
				<form:radiobutton id="empField" path="empField" value="사기업"/>사기업
			</td>
		</tr>
		<tr>
			<th>취업지역</th>
			<td class="col-sm-1">
			     <select id="empLoc" name="empLoc"  class="form-select">
						<option value=>지역선택</option>
						<option value="서울">서울</option>
						<option value="강원도">강원도</option>
						<option value="경기도">경기도</option>
						<option value="충청남도">충청남도</option>
						<option value="충청북도">충청북도</option>
						<option value="경상남도">경상남도</option>
						<option value="경상북도">경상북도</option>
						<option value="전라남도">전라남도</option>
						<option value="전라북도">전라북도</option>
	            </select>
			</td>
			<td>
				<input id="submitBtn" class="btn btn-outline-success" style="border-radius: 10px;" type="button" value="등록">
			</td>
			<td colspan="2">
				<button id="modifyRow" class="btn btn-outline-info" style="border-radius: 10px;"" type="button" data-bs-toggle="modal" data-bs-target="#staticBackdrop">일괄등록</button>
        	</td>
		</tr>
	</form:form>
</table>
</div>
<!-- modal body -->
<div class="modal" data-url="${viewURL}" id="staticBackdrop" tabindex="-1">
   <div class="modal-dialog modal-fullscreen-sm-down">
      <div class="modal-content">
         <div class="modal-header">
         <h5 class="modal-title">취업현황등록</h5>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
         </div>
         <div class="modal-body">
         	<form action="${pageContext.request.contextPath}/Excel/insert2.do" method="post" enctype="multipart/form-data">
                <input type="file" name="file" accept=".xlsx, .xls">
      		<button type="submit" class="btn btn-outline-success" style="border-radius: 10px;">등록</button>
	        </form>
      	</div>
      	<div class="modal-footer">
         </div>
      </div>
   </div>
</div>
<script>
//수정버튼에 스윗 알람
$('#submitBtn').on('click', function () {
        Swal.fire({
            title: '취업현황을 등록하시겠습니까?',
            icon: 'info',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: '등록',
            cancelButtonText: '취소',
        }).then(result => {
            if (result.isConfirmed) {
            	insertStatus();
            }
        });
});

function insertStatus() {
    event.preventDefault();
    let stCd = $("#stCd").val(); // 학생코드
    let empYear = $("#empYear").val(); // 취업연도
    let empStat = $("input[name='empStat']:checked").val(); // 취업상태 선택
    let empField = $("input[name='empField']:checked").val(); // 취업분야 선택
    let empLoc = $("input[name='empLoc']:checked").val(); // 취업분야 선택

    if(empStat=="미취업"){
    	empField = "미등록";
    	empYear = "미등록";
    	empLoc = "미등록";
    }

    if (stCd === "") {
        Swal.fire({
  		  title:'학생코드를 입력해주세요',
  		  icon: 'info',
 		});
        return;
    }
    if (!empStat) {
    	Swal.fire({
    		  title:'취업상태를 선택해주세요.',
    		  icon: 'info',
   		});
        return;
    }
    if (!empField) {
    	Swal.fire({
    		  title:'취업분야를 선택해주세요.',
    		  icon: 'info',
   		});
        return;
    }
    if (empYear === "") {
    	Swal.fire({
    		  title:'취업연도를 선택해주세요.',
    		  icon: 'info',
   		});
        return;
    }
    if (empLoc === "") {
    	Swal.fire({
    		  title:'취업지역을 선택해주세요.',
    		  icon: 'info',
   		});
        return;
    }

    const postData = {
        stCd: stCd,
        empStat: empStat,
        empField: empField,
        empYear: empYear,
        empLoc: empLoc
    };

    $.ajax({
        url: "/oryuUniversity/student/updateStatus.do",
        type: "post",
        data: JSON.stringify(postData),
        contentType: "application/json",
        success: function(response) {
        	Swal.fire({
      		  title:response,
      		  icon: 'success',
     		}).then(result => {
				if (result.isConfirmed) { // 만약 모달창에서 confirm 버튼을 눌렀다면
					fetchStudent();
		            fetchDepartment();
		            fetchUpdateForm();
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
</script>


