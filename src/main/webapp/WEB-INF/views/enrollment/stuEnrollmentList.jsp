<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<style>
.gradInfo {
	margin-top: 3px;
	background-color: rgba(0, 0, 0, 0.03);
	padding-right: 40px;
	font-family: 'Noto Sans KR', sans-serif;
}

.gradInfo-header {
	margin: 20px 0 11px 40px;
	font-size: 14px;
	font-weight: bold;
}

.gradInfo-header2 {
	padding-right: 40px;
	margin: 20px 0 11px 40px;
	font-size: 14px;
	font-weight: bold;
}

.gradInfo-body {
	margin: -13px 11px 20px 40px;
	font-size: 12px;
}

.span-title {
	font-weight: bold;
	color: #248AFD;
	margin-right: 12px;
}

select {
	padding: 0; /* 위 아래 여백을 없애는 스타일 */
	display: inline-block; /* 셀렉트 박스를 인라인 블록 요소로 표시하여 텍스트 흐름을 방해하지 않도록 함 */
	vertical-align: middle; /* 수직 정렬을 가운데로 설정 */
}

button {
	margin-left: 10px;
}

.row {
	margin: 10px;
}

th {
	text-align: center;
}

td {
	text-align: center;
}

</style>
<div class="card box-shadow d-flex m-4" style="min-height: 87%;">
	<div class="h-100">
		<div class="custom-card">
			<div class="card-header"
				style="border-radius: 20px 20px 0 0; background-color: #154FA9; font-weight: bold; color: white;">수강신청</div>
			<div class="card-body">
				<div class="row justify-content-center">
					<div class="col-2">
						<select name="college" class="form-select">
							<option value>단대선택</option>
							<c:forEach items="${collegeList }" var="college">
								<option value="${college.colgeCd }">${college.colgeNm }</option>
							</c:forEach>
						</select>
					</div>
					<div class="col-2">
						<select name="dtCd" class="form-select">
							<option value>학과선택</option>
							<c:forEach items="${departmentList }" var="department">
								<option value="${department.dtCd }"
									class="${department.colgeCd }">${department.dtNm }</option>
							</c:forEach>
						</select>
					</div>
					<div class="col-2">
						<select name="classfication" class="form-select">
							<option value>이수구분선택</option>
							<c:forEach items="${classificationList }" var="classification">
								<option value="${classification.cfCode }">${classification.cfName }</option>
							</c:forEach>
						</select>
					</div>
					<div class="col-2">
						<select name="grade" class="form-select">
							<option value>학년선택</option>
							<option value="1">1학년</option>
							<option value="2">2학년</option>
							<option value="3">3학년</option>
							<option value="4">4학년</option>
						</select>
					</div>
					<div id="searchUI" class="col-1">
						<form:select path="simpleCondition.searchType" class="form-select">
							<form:option value="" label="전체" />
							<form:option value="" label="전체" />
							<form:option value="lCode" label="강의코드" />
							<form:option value="lName" label="강의명" />
							<form:option value="sCode" label="과목코드" />
							<form:option value="sName" label="과목명" />
							<form:option value="pName" label="교수명" />
						</form:select>
					</div>
					<div id="searchUI" class="col-2">
						<form:input path="simpleCondition.searchWord" class="form-control" />
					</div>
					<div class="col-1">
						<input type="button" value="검색" id="searchBtn"
							class="btn btn-success" />
					</div>
				</div>
				<div class="card box-shadow">
					<div class="gradInfo-header2">
						<i class="mdi mdi-chart-line" style="color: green;"></i>현학기 개설 강의 목록
					</div>
					<div id="lecture"></div>
					<div class="row">
						<div class="col-11"></div>
						<div class="col-1">
							<button id="submitRow" class="btn btn-outline-info mb-3"
								style="padding: 12px; border-radius: 10px;"button">수강신청</button>
						</div>
					</div>
				</div>
				<div class="card box-shadow">
					<div class="gradInfo-header2">
						<i class="mdi mdi-chart-line" style="color: green;"></i>수강 신청 목록
					</div>
					<div id="enroll"></div>
					<div class="row">
						<div class="col-11"></div>
						<div class="col-1">
							<button id="cancelRow" class="btn btn-outline-info mb-3"
								style="padding: 12px; border-radius: 10px;"button">수강취소</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<form:form id="searchForm" modelAttribute="simpleCondition" method="get">
	<input type="hidden" name="college" id="college" />
	<input type="hidden" name="dtCd" id="dtCd" />
	<input type="hidden" name="classfication" id="classfication" />
	<input type="hidden" name="lecStat" id="lecStat" />
	<input type="hidden" name="grade" id="grade" />
	<input type="hidden" name="semester" id="semester" />

	<form:hidden path="searchType" />
	<form:hidden path="searchWord" />
	<input type="hidden" name="page" id="page" />
</form:form>
<!-- 검색조건내에 조건걸기 -->
<script>
let $dtCd = $('[name="dtCd"]');
$('[name="college"]').on("change", function (event) {
   let colgeCd = $(this).val();
   if (colgeCd) {
      $dtCd.find("option").hide();
      $dtCd.find(`option:first`).show();
      $dtCd.find(`option.\${colgeCd}`).show();
   } else {
      $dtCd.find("option").show();
   }
}).trigger("change");
<!-- pagination -->
function fn_paging(page) {
   searchForm.page.value = page;
   searchForm.requestSubmit();
}
$(searchBtn).on("click", function (event) {
   $(searchUI).find(":input[name]").each(function (idx, input) {
      let name = input.name;
      let value = $(input).val();
      $(searchForm).find(`[name=\${name}]`).val(value);
   });

   let college = $("select[name='college']").val();
   let dtCd = $("select[name='dtCd']").val();
   let lecStat = $("select[name='lecStat']").val();
   let classfication = $("select[name='classfication']").val();
   let grade = $("select[name='grade']").val();
   let semester = $("select[name='semester']").val();

   fetchLectures(college, dtCd, lecStat, classfication, grade, semester);
   fetchEnrollments();
});
</script>
<script>
// 페이지 들어오자마자 동작하는 레디 펑션
$(document).ready(function() {
	fetchLectures();
    fetchEnrollments();
//     setInterval(function() {
//     	console.log($("#enroll").find('tr'));
//    	}, 1000);
});
// 강의 목록을 불러오는 펑션
function fetchLectures(college, dtCd, lecStat, classfication, grade, semester) {
	
	$("#college").val(college);
	$("#dtCd").val(dtCd);
	$("#lecStat").val(lecStat);
	$("#classfication").val(classfication);
	$("#grade").val(grade);
	$("#semester").val(semester);
	var data = $(searchForm).serializeArray();
	
    $.ajax({
        url: "/oryuUniversity/enrollment/lectureList.do",
        method: "get",
        data: data,
        dataType: "html",
        success: function (data) {
            $('#lecture').html(data);
        },
        error: function (jqXHR, status, error) {
            console.log(jqXHR);
            console.log(status);
            console.log(error);
        }
    });
}

// 본인 신청 목록을 불러오는 펑션
function fetchEnrollments() {
    $.ajax({
        url: "/oryuUniversity/enrollment/fetchEnrollments.do",
        method: "get",
        dataType: "html",
        success: function (data) {
        	
            $('#enroll').html(data);
            var $trs = $("#enroll").find("tr");
            $trs.each(function(idx,element){
            	var id = $(element).data('id');
            	setTimeout(function() {
            	    $(lecture).find(`tr[data-id='\${id}']`).remove();
            	}, 100); 
            });
        },
        error: function (jqXHR, status, error) {
            console.log(jqXHR);
            console.log(status);
            console.log(error);
        }
    });
}
</script>


<script>
<!--수강신청 버튼-->
$('#submitRow').on('click', function () {

    event.preventDefault();
    let $checkLecCd = $("input:checked").parent('td').siblings('.lecCd');
    let $checkEnroll = $("input:checked").parent('td').parent('tr');
    let lecCds = [];

    for (let i = 0; i < $checkLecCd.length; i++) {
       lecCds.push($checkLecCd[i].innerText);
    }
    if (lecCds.length == 0) {
       Swal.fire({
          title: '선택된 강의가 없습니다.',
          icon: 'info',
       });
       event.preventDefault();
       return;
    } else {
       Swal.fire({
          title: '수강신청 하시겠습니까?',
          icon: 'info',
          showCancelButton: true, // cancel버튼 보이기. 기본은 원래 없음
          confirmButtonColor: '#3085d6', // confrim 버튼 색깔 지정
          cancelButtonColor: '#d33', // cancel 버튼 색깔 지정
          confirmButtonText: '수강', // confirm 버튼 텍스트 지정
          cancelButtonText: '취소', // cancel 버튼 텍스트 지정
       }).then(result => {
          if (result.isConfirmed) { // 만약 모달창에서 confirm 버튼을 눌렀다면
             let setting = {
                url: "/oryuUniversity/enrollment/submitEnrollment.do",
                method: "post",
                dataType: "text",
                traditional: true,
                data: {
                   lecCds: lecCds
                },
                success: function (resp) {
                   Swal.fire({
                      title: resp,
                      icon: 'success',
                   }).then(result => {
                      if (result.isConfirmed) { // 만약 모달창에서 confirm 버튼을 눌렀다면
<%--                          window.location.href = "<%=request.getContextPath()%>/enrollment/stuEnrollmentList.do"; --%>
                         fetchLectures();
                         fetchEnrollments();
                         $checkEnroll.each(function(idx,element){
                        	 $(element).remove();
                         });
                      }
                   })

                },
                error: function (error) {
                   Swal.fire({
                      title: error,
                      icon: 'error',
                   })
                }
             }
             $.ajax(setting);
          }
       })
    }
 })
 <!--수강취소 버튼-->
$('#cancelRow').on('click', function () {
    event.preventDefault();
    let $checkLecCd = $("input:checked").parent('td').siblings('.lecCd');
    let lecCds = [];

    for (let i = 0; i < $checkLecCd.length; i++) {
       lecCds.push($checkLecCd[i].innerText);
    }
    if (lecCds.length == 0) {
       Swal.fire({
          title: '선택된 강의가 없습니다.',
          icon: 'info',
       });
       event.preventDefault();
       return;
    } else {
       Swal.fire({
          title: '수강신청을 취소 하시겠습니까?',
          icon: 'info',
          showCancelButton: true, // cancel버튼 보이기. 기본은 원래 없음
          confirmButtonColor: '#3085d6', // confrim 버튼 색깔 지정
          cancelButtonColor: '#d33', // cancel 버튼 색깔 지정
          confirmButtonText: '확인', // confirm 버튼 텍스트 지정
          cancelButtonText: '취소', // cancel 버튼 텍스트 지정
       }).then(result => {
          if (result.isConfirmed) { // 만약 모달창에서 confirm 버튼을 눌렀다면
             let setting = {
                url: "/oryuUniversity/enrollment/cancelEnrollment.do",
                method: "post",
                dataType: "text",
                traditional: true,
                data: {
                   lecCds: lecCds
                },
                success: function (resp) {

                   Swal.fire({
                      title: resp,
                      icon: 'success',
                   }).then(result => {
                      if (result.isConfirmed) { // 만약 모달창에서 confirm 버튼을 눌렀다면
<%--                          window.location.href = "<%=request.getContextPath()%>/enrollment/stuEnrollmentList.do"; --%>
                         fetchLectures();
                         fetchEnrollments();
                      }
                   })
                },
                error: function (error) {
                   Swal.fire({
                      title: error,
                      icon: 'error',
                   })
                }
             }
             $.ajax(setting);
          }
       });
    }
 })
</script>
