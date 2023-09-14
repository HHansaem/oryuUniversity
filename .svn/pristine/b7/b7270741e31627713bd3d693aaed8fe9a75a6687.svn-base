<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<style>
     #empty-cell {
        background-color: #ffffff;
    }
    
    #full-cell {
        background-color: rgba(245,245,245);
    }
    
    #choice-cell {
        background-color: #fff8cc;
    }
    #my-cell {
        background-color: #dcf2e9;
    }
    th{
    text-align: center;
    }
    td{
    text-align: center;
    }
</style>
<form:form method="post" modelAttribute="lecture" enctype="multipart/form-data" style="margin-top: -36px;">
	<table class="table table-border">
	<form:hidden path="lecCd" />
	<tr>
		<th>강의명</th>
		<td class="col-auto" id="title">${lecture.lecLectTitle }</td>
		<th>학점</th>
		<td class="col-auto">${lecture.lecLectCred }학점</td>
	</tr>
		<c:if test="${not empty lecture.clasCd }">
			<tr>
				<th>강의실</th>
					<td class="col-auto">${lecture.clasNm}</td>
				<th>강의시간</th>
					<td class="col-auto">${lecture.scheCds }</td>
			</tr>
		</c:if>
	<tr>
		<th>강의실 선택</th> 
		<td class="col-auto">
		<div>
			<select name="building" class="form-select">
	               <option value>건물 선택</option>
	               <c:forEach items="${buildingList }" var="building">
	                  <option value="${building.builCd }" >${building.builNm }</option>
	               </c:forEach>
			</select>
		</div>
		</td>
		<td class="col-auto">
		<div>
			<select name="room" class="form-select">
	               <option value>호 선택</option>
	                  <option value="01" >1호</option>
	                  <option value="02" >2호</option>
	                  <option value="03" >3호</option>
	                  <option value="04" >4호</option>
	                  <option value="05" >5호</option>
	                  <option value="06" >6호</option>
	                  <option value="07" >7호</option>
	                  <option value="08" >8호</option>
	                  <option value="09" >9호</option>
	                  <option value="10" >10호</option>
			</select>
		</div>
		</td>
	</tr>
	<tr>
		<th>강의실</th>
		<td>
			<form:select  id="classroomSelect" path="clasCd" class="form-select">
				<form:option value="" label="강의실선택" />
				<form:options items="${classRoomList }" itemLabel="clasNm" itemValue="clasCd"/>
			</form:select>
			<form:errors path="clasCd" class="error" />
		</td>
		<td colspan="2">
			<input id="submitBtn"class="btn btn-outline-success" style=" border-radius: 10px;" type="button" value="등록">
			<input class="btn btn-outline-danger" style="border-radius: 10px;" type="button" value="취소" data-bs-dismiss="modal">
		</td>
	</tr>
	<table id="data-table" class="table table-border">
	    <thead>
	        <tr>
	            <th></th>
	            <th>월</th>
	            <th>화</th>
	            <th>수</th>
	            <th>목</th>
	            <th>금</th>
	        </tr>
	    </thead>
	    <tbody>
	    </tbody>
	</table>
</table>
</form:form>
<script>
$(function(){
    $("#classroomSelect").change(function(){
        loadTimeTable();
    });
    $("select[name='building'], select[name='room']").change(function(){
        const buildingValue = $("select[name='building']").val();
        const roomValue = $("select[name='room']").val();
        if (buildingValue && roomValue) {
            const classroomValue = buildingValue + roomValue;
            $("#classroomSelect").val(classroomValue).change();
        }
    });
	
    $('#submitBtn').on('click', function () {
        Swal.fire({
            title: '강의실과 강의시간을 등록을 진행하시겠습니까?',
            icon: 'info',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: '등록',
            cancelButtonText: '취소',
        }).then(result => {
            if (result.isConfirmed) {
            	insertLectureSchedule();
            }
        });
	});
	function insertLectureSchedule() {
		event.preventDefault();
        const lecCd = "${lecture.lecCd}"; // 강의 코드
        const clasCd = $("#classroomSelect").val(); // 강의실 코드
        
        if (combinedValues.length === 0) {
			Swal.fire({
				  title:'강의 시간을 선택해주세요.',
				  icon: 'info',
			});
			return;
        }

        const postData = {
            lecCd: lecCd,
            clasCd: clasCd,
            combinedValues: combinedValues
        };

        $.ajax({
            url: "/oryuUniversity/lectureSchedule/lectureScheduleInsert.do",
            type: "post",
            data: JSON.stringify(postData),
            contentType: "application/json",
            success: function(response) {
            	Swal.fire({
          		  title:response,
          		  icon: 'success',
         		}).then(result => {
	  				if (result.isConfirmed) { // 만약 모달창에서 confirm 버튼을 눌렀다면
		                window.location.href="<%=request.getContextPath()%>/lecture/prfLectureList.do";
  					}
  	     		})
            },
            error: function(error) {
            	Swal.fire({
          		  title:error,
          		  icon: 'error',
         		})
            }
        });
    };
});

</script>