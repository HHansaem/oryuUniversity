<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<style>
	#contain{
		background: white;
		
	}
</style>

<div class="card box-shadow d-flex m-4" style="min-height: 87%;">
      <div class="h-100">
		<div class="album py-5 bg-light">
			<div id="contain" class="container p-3">
				<div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
					<sec:authorize access="hasRole('ROLE_PR')">
					<c:if test="${empty lectureList}">
							<div class="d-flex justify-content-center">
								<h4>배정된 강의가 존재하지 않습니다.</h4>
							</div>
					</c:if>
					<c:forEach var="lecture" items="${lectureList}">
						<div class="col">
							<div class="card shadow-sm">
								<svg class="bd-placeholder-img card-img-top" width="100%"
									height="225" xmlns="http://www.w3.org/2000/svg" role="img"
									aria-label="Placeholder: Thumbnail"
									preserveAspectRatio="xMidYMid slice" focusable="false">
								<title>Placeholder</title><rect width="100%" height="100%"
										fill="#CCCCFF" />
								<text x="50%" y="50%" fill="#00ff00" dy=".3em"></text></svg>
		
								<div class="card-body">
									<p class="card-text">${lecture.lecLectTitle}</p>
									<div class="d-flex justify-content-end align-items-center">
										<div class="btn-group">
											<button type="button" onclick="redirectLecture('${lecture.lecCd}')" class="btn btn-sm btn-outline-secondary">View</button>
										</div>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
					</sec:authorize>
					<sec:authorize access="hasRole('ROLE_ST')">
					<c:if test="${empty enrollmentList}">
							<div class="d-flex justify-content-center">
								<h4>수강중인 강의가 존재하지 않습니다.</h4>
							</div>
					</c:if>
					<c:forEach var="enrollment" items="${enrollmentList}">
						<div class="col">
							<div class="card shadow-sm">
								<svg class="bd-placeholder-img card-img-top" width="100%"
									height="225" xmlns="http://www.w3.org/2000/svg" role="img"
									aria-label="Placeholder: Thumbnail"
									preserveAspectRatio="xMidYMid slice" focusable="false">
								<title>Placeholder</title><rect width="100%" height="100%"
										fill="#CCCCFF" />
								<text x="50%" y="50%" fill="#00ff00" dy=".3em"></text></svg>
		
								<div class="card-body">
									<p class="card-text">${enrollment.lecture.lecLectTitle}</p>
									<div class="d-flex justify-content-end align-items-center">
										<div class="btn-group">
											<button type="button" onclick="redirectLecture('${enrollment.lecCd}')" class="btn btn-sm btn-outline-secondary">View</button>
										</div>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
					</sec:authorize>
				</div>
			</div>
		</div>
      </div>
   </div>
<script>
    function redirectLecture(lectureId) {
        // 강의 상세 정보 페이지 URL을 생성하고 리다이렉션합니다.
        var detailUrl = '${pageContext.request.contextPath}/lecture/noticeList.do?lecCd=' + lectureId; // 실제 URL에 맞게 수정해야 합니다.
        window.location.href = detailUrl;
    }
</script>