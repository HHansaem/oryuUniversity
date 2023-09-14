<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<script src="https://cdn.jsdelivr.net/npm/js-cookie@3.0.1/dist/js.cookie.min.js"></script>

<style>
	.custom-border{
		margin-top: 10px;
    	border: 1px solid #dadde0;
    	border-radius: 15px;
	}
	
</style>

<div class="card box-shadow d-flex m-4" style="min-height: 87%;">
	<div class="card-header" style="border-radius: 20px 20px 0 0; background-color:#154FA9; font-weight:bold; color:white; margin-bottom: 20px;">동영상/화상 강의</div>
	<div class="h-100 row d-flex justify-content-center">
		<div class="col-lg-5 stretch-card mt-2">
			<div class="card">
				<div class="card-body box-shadow" style="border-radius:15px;">
					<div class="d-flex">
						<sec:authorize access="hasRole('ROLE_ST')">
						<div class="w-100" style="padding-left: 10px;">
							<i class="mdi mdi-format-list-bulleted" style="color: green; "></i>
							동영상 강의
						</div>
						</sec:authorize>
						<sec:authorize access="hasRole('ROLE_PR')">
						<div class="w-100 d-flex align-items-end" style="padding-left: 10px;">
							<i class="mdi mdi-format-list-bulleted" style="color: green; "></i>
							동영상 강의
						</div>
						
						</sec:authorize>
						<div class="d-flex justify-content-end col-md-9">
							<sec:authorize access="hasRole('ROLE_PR')">
								<a
									href="<%=request.getContextPath()%>/lecture/videoLectureInsert.do?lecture=${lecCd}"
									class="btn btn-outline-info">동영상 등록</a>
							</sec:authorize>
						</div>
					</div>
					<hr style="border-color: black;">
					<div class="table-responsive custom-border mt-4">
						<table class="table">
<!-- 							<thead> -->
<!-- 								<tr> -->
<!-- 									<th style="background: #c2e2ff;; border-radius: 10px 10px 0 0; border: 1px solid #c2e2ff;;">동영상강의 목록</th> -->
<!-- 								</tr> -->
<!-- 							</thead> -->
							<tbody>
								<c:choose>
									<c:when test="${not empty videoList and videoList.size() > 0}">
										<c:forEach var="video" items="${videoList}" varStatus="cnt">
											<sec:authorize access="hasRole('ROLE_PR')">
												<tr data-id="${video.vlsCd}" data-check="true"
													class="clickable-row">
											</sec:authorize>
											<sec:authorize access="hasRole('ROLE_ST')">
												<tr data-id="${video.vlsCd}"
													data-check="${video.videoAvailable}" class="clickable-row">
											</sec:authorize>
											<td>
												<div class="d-flex align-items-center">
													<div class="custom-flex-item">${cnt.index+1}.
														${video.vlTitle}</div>
													<div class="justify-content-end">열람 마감일시:
														${video.endTime}</div>
												</div>
											</td>
											</tr>
										</c:forEach>
									</c:when>
									<c:otherwise>
										<tr>
											<td>등록된 동영상 강의가 존재하지 않습니다.</td>
										</tr>
									</c:otherwise>
								</c:choose>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
		<div class="col-lg-5 stretch-card mt-2">
			<div class="card">
				<div class="card-body box-shadow" style="border-radius:15px;">
					<div>
						<sec:authorize access="hasRole('ROLE_PR')">
							<div class="col-md-3" style="padding-top: 19.4px;">
								<i class="mdi mdi-format-list-bulleted" style="color: green; "></i>
								화상 강의
							</div>
						</sec:authorize>
						
						<sec:authorize access="hasRole('ROLE_ST')">
							<div class="col-md-3">
								<i class="mdi mdi-format-list-bulleted" style="color: green; "></i>
								화상 강의
							</div>
						</sec:authorize>
					</div>
					<hr style="border-color: black;">
					<div class="mt-4">
						<div class="card mb-4 rounded-3 shadow-sm" style="border: 1px solid #dadde0;">
<!-- 				          <div class="card-header py-3" style="background: #c2e2ff;"> -->
<!-- 				            <h5 class="my-0 fw-normal font-weight-bold">화상강의 정보</h5> -->
<!-- 				          </div> -->
				          <input type="hidden" id="lecture" value="${lecCd}"/>
				          <div class="card-body text-center">
				            <h1 class="card-title pricing-card-title">Zoom 화상강의</h1>
				            <ul class="list-unstyled mt-3 mb-4">
				              <li>수업명: </li>
				              <li>시작시간: 2023-09-13 10시 00분</li>
				              <li>종료시간: 2023-09-13 12시 00분</li>
				              <li>회의번호: 486 227 2535</li>
				            </ul>
				            <button type="button" class="w-100 btn-lg btn btn-outline-info" onclick="lectureStart()">화상강의 입장</button>
				          </div>
				        </div>
			        </div>
				</div>
			</div>
		</div>
		
		<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		  <div class="modal-dialog modal-lg" role="document">
		    <div class="modal-content" style="width: 70%; margin: 0 auto;">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel"></h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div id="modalBody" class="modal-body d-flex">
		      
		      </div>
		      <div class="modal-footer">
		      
		      </div>
		    </div>
		  </div>
		</div>
		
	</div>
</div>

<script>
    document.addEventListener("DOMContentLoaded", function() {
        var clickableRows = document.querySelectorAll(".clickable-row");
        clickableRows.forEach(function(row) {
            row.addEventListener("click", function() {
            	var flag = $(this).data("check");
            	if(flag){
                	var id = this.getAttribute("data-id");
                	window.location.href = "<%=request.getContextPath()%>/lecture/videoLectureDetail.do?vlsCd="+ id;
				} else {
					alert("열람하실 수 없습니다.");
				}
			});
		});
	});
    
    function setCookie(name, value, days) {
        var expires = "";
        if (days) {
            var date = new Date();
            date.setTime(date.getTime() + (days * 24 * 60 * 60 * 1000));
            expires = "; expires=" + date.toUTCString();
        }
        document.cookie = name + "=" + value + expires + "; path=/";
    }
    
    function lectureStart(){
    	var lectureCode = $("#lecture").val();
    	Cookies.remove("lecCd");
    	setCookie("lecCd",lectureCode,1);
    	var newWindow = window.open('<%=request.getContextPath()%>/zoom/startZoom', '_blank');
//     		$.ajax({
//     	        type: "GET", // 또는 GET 등 사용할 HTTP 메서드 선택
//     	        url: "${pageContext.request.contextPath}/zoom/startZoom",
//     	        success: function(response) {
    	        	
//     	        	$("#modalBody").html(response);
    	        	
// //     	        	$("#exampleModal").modal("show");
//     	        },
//     	        error: function(xhr, status, error) {
//     	            console.error(error);
//     	        }
//     	    });
    }
    
    
</script>