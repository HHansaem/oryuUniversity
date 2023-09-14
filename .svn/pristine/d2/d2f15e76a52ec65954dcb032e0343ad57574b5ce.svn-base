<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<table class="table table-hover" style="max-width: 1500px; margin: 0 auto;">
	<thead class="table-light">
		<tr>
			<th><input type="checkbox" id="selectAllCheckbox" /></th>
			<th>년도</th>
			<th>학기</th>
			<th>학번</th>
			<th>학과</th>
			<th>이름</th>
			<th>등록금액(원)</th>
			<th>장학금액(원)</th>
			<th>납부금액(원)</th>
			<th>납부여부</th>
			<th>명세서</th>
		</tr>
	</thead>
	<tbody>
		<c:set var="tuitionList" value="${paging.dataList }" />
		<c:if test="${empty tuitionList }">
			<tr>
				<td colspan="11">검색결과 없음.</td>
			</tr>
		</c:if>
		<c:if test="${not empty tuitionList }">
			<c:forEach items="${tuitionList }" var="tuition">
				<tr>
					<td><input type="checkbox" name="chkParam" value=${tuition.stCd }></td>
					<td>${tuition.semesterCd.substring(0, 4) }</td>
					<td>${tuition.semesterCd.substring(4, 5) }</td>
					<td>${tuition.stCd }</td>
					<td>${tuition.dtNm }</td>
					<td>${tuition.stNm }</td>
					<td>${tuition.tuAmount }</td>
					
					<c:choose>
			            <c:when test="${tuition.tuSchSta != '승인'}">
			                <td>0</td>
			            </c:when>
			            <c:otherwise>
			                <td>${tuition.tuSchAmo}</td>
			            </c:otherwise>
			        </c:choose>
					
					<td>${tuition.tuPay }</td>
					<td>${tuition.tuWhether }</td>
					<td>
						<input type="button" value="명세서" class="btn btn-info"
							style="padding-bottom: 6px; padding-top:6px;">
					</td>
				</tr>
			</c:forEach>
		</c:if>
	</tbody>
</table>
	<div id="pageVar" style="padding: 20px;">
		<input type="button" value="납부완료" id="regBtn" class="btn btn-primary"/>
		<div style="padding-right: 700px;">${paging.pagingHTML }</div>
	</div>
<script>
var selectAllCheckbox = document.getElementById("selectAllCheckbox");
var checkboxes = document.querySelectorAll("input[type='checkbox'][name='chkParam']");

selectAllCheckbox.addEventListener("click", function() {
    checkboxes.forEach(function(checkbox) {
        checkbox.checked = selectAllCheckbox.checked;
    });
});

var detailButtons = document.querySelectorAll("input[type='button'][value='명세서']");
detailButtons.forEach(function(button) {
    button.addEventListener("click", function() {
        var row = button.closest("tr");
        var stCd = row.querySelector("td:nth-child(4)").textContent;
        var semesterCd = row.querySelector("td:nth-child(2)").textContent + row.querySelector("td:nth-child(3)").textContent;
        sendToServer(stCd, semesterCd);
    });
});

$("#regBtn").click(function() {
	var checkedCheckboxes = $("input[name='chkParam']:checked");
	if (checkedCheckboxes.length === 0) {
		Swal.fire({
		      icon: 'info',
		      title: '등록금 납부 처리할 학생을 선택해주세요.',
		      
		      confirmButtonColor: '#3085d6',
		      confirmButtonText: '확인'
		    });
        return;
    }
	var selectedStudents = [];
	
	checkedCheckboxes.each(function() {
		var tuitionInfo = {
            stCd: $(this).val(),
            semesterCd: $(this).closest("tr").find("td:eq(1)").text()+$(this).closest("tr").find("td:eq(2)").text()
        };
        selectedStudents.push(tuitionInfo);
    });
	
	var jsonData = JSON.stringify(selectedStudents);
	
	$.ajax({
		type: "POST",
		url: "/oryuUniversity/tuition/staffTuitionList.do",
		contentType: "application/json",
		data: jsonData,
		success: function(response) {
			if(response.result == '성공') {
				fetchTuition();
				Swal.fire({
  			      icon: 'success',
  			      title: '등록금 납부 처리가 완료되었습니다.',
  			      
  			      confirmButtonColor: '#3085d6',
  			      confirmButtonText: '확인'
  			    });
			}else {
				Swal.fire({
	  			      icon: 'info',
	  			      title: '이미 등록금 납부 처리가 완료되었습니다.',
	  			      
	  			      confirmButtonColor: '#3085d6',
	  			      confirmButtonText: '확인'
	  			    });
			}
		},
		error: function(xhr, status, error) {
			Swal.fire({
			      icon: 'error',
			      title: '등록금 납부 중 오류가 발생했습니다.',
			      
			      confirmButtonColor: '#3085d6',
			      confirmButtonText: '확인'
			    });
			return;
		}
	});
});
</script>