<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<div class="card">
		<div class="card-body">
			<h4 class="card-title">강의 상세조회</h4>
			<form class="form-sample">
				<div class="row">
					<div class="col-md-6">
						<div class="form-group row">
							<label class="col-sm-3 col-form-label">강의명</label>
							<div class="col-sm-9">
								<input type="text" class="form-control" readonly
									value="${lecture.lecLectTitle}" />
							</div>
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group row">
							<label class="col-sm-3 col-form-label">담당교수</label>
							<div class="col-sm-9">
								<input type="text" class="form-control" readonly
									value="${lecture.professor.prNm}" />
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-6">
						<div class="form-group row">
							<label class="col-sm-3 col-form-label">강의계획서</label>
							<div class="col-sm-9">
								<c:choose>
								<c:when test="${not empty lecture.fileGroup and not empty lecture.fileGroup.detailList }">
               						<c:forEach items="${lecture.fileGroup.detailList}" var="fileDetail">
                 					<c:url value="/download.do" var="downloadURL">
                    					<c:param name="atchFileId"  value="${fileDetail.atchFileId }"/>
                    					<c:param name="fileSn" value="${fileDetail.fileSn }"/>
                 					</c:url>
                 					<a href="${downloadURL }">${fileDetail.orignlFileNm }</a>
             						</c:forEach>
            					</c:when>
            					<c:otherwise>
            						<input type="text" class="form-control" readonly
									value="강의계획서가 존재하지 않습니다." />
            					</c:otherwise>
								</c:choose>
							</div>
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group row">
							<label class="col-sm-3 col-form-label">강의상태</label>
							<div class="col-sm-9">
								<input type="text" class="form-control" readonly
									value="${lecture.lecStat}" />
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-6">
						<div class="form-group row">
							<label class="col-sm-3 col-form-label">학과</label>
							<div class="col-sm-9">
								<input type="text" class="form-control" readonly
									value="${lecture.professor.department.dtNm}" />
							</div>
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group row">
							<label class="col-sm-3 col-form-label">단대</label>
							<div class="col-sm-9">
								<input type="text" class="form-control" readonly
									value="${lecture.professor.department.college.colgeNm}" />
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-6">
						<div class="form-group row">
							<label class="col-sm-3 col-form-label">학년</label>
							<div class="col-sm-9">
								<input type="text" class="form-control" readonly
									value="${lecture.lecGraCd}학년" />
							</div>
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group row">
							<label class="col-sm-3 col-form-label">학기</label>
							<div class="col-sm-9">
								<c:choose>
									<c:when
										test="${lecture.lecSemeCd == 1 or lecture.lecSemeCd == 3}">
										<input type="text" class="form-control" readonly
											value="${lecture.lecSemeCd}학기" />
									</c:when>
									<c:when test="${lecture.lecSemeCd == 2}">
										<input type="text" class="form-control" readonly
											value="여름계절학기" />
									</c:when>
									<c:when test="${lecture.lecSemeCd == 4}">
										<input type="text" class="form-control" readonly
											value="겨울계절학기" />
									</c:when>
								</c:choose>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-6">
						<div class="form-group row">
							<label class="col-sm-3 col-form-label">학점</label>
							<div class="col-sm-9">
								<input type="text" class="form-control" readonly
									value="${lecture.lecLectCred}학점" />
							</div>
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group row">
							<label class="col-sm-3 col-form-label">제한인원</label>
							<div class="col-sm-9">
								<input type="text" class="form-control" readonly
									value="${lecture.lecEnroLimit}명" />
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-6">
						<div class="form-group row">
							<label class="col-sm-3 col-form-label">강의실</label>
							<div class="col-sm-9">
								<input type="text" class="form-control"  readonly
									value="${lecture.lectureScheduleList[0].classroom.clasNm}" />
							</div>
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group row">
							<label class="col-sm-3 col-form-label">강의시간</label>
							<div class="col-sm-9">
								<input type="text" class="form-control" readonly
									value="${schedule}"/>
							</div>
						</div>
					</div>
				</div>
				<div class="d-flex justify-content-end">
					<c:url value='/lecture/lectureUpdate.do' var="updateURL">
						<c:param name="lecCd" value="${lecture.lecCd}" />
					</c:url>
				<a href="${updateURL }" class="btn btn-primary" >수정</a>
				<a href="<%=request.getContextPath()%>/lecture/videoLectureInsert.do?lecture=${lecture.lecCd}"
					class="btn btn-primary">삭제</a>	
			</div>
			</form>
		</div>
	</div>

