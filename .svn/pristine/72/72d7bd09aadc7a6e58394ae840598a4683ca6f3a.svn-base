<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<c:set var="noticeList" value="${paging.dataList }" />
<c:forEach items="${noticeList}" var="notice">
	<c:choose>
		<c:when test="${empty noticeList }">
			<a class="dropdown-item preview-item">
				<div class="preview-thumbnail">
					<div class="preview-icon bg-danger">
						<i class="ti-info-alt mx-0"></i>
					</div>
				</div>
				<div class="preview-item-content">
					<h6 class="preview-subject font-weight-normal">새로운 알람이 없습니다.</h6>
				</div>
			</a>
		</c:when>
		<c:otherwise>
			<a class="dropdown-item preview-item">
				<div class="preview-thumbnail">
					<div id="notiCd" hidden="" value="${notice.notiCd}"></div>
					<c:choose>
						<c:when test="${notice.notiType eq '1'}">
							<div class="preview-icon bg-success">
						</c:when>
						<c:when test="${notice.notiType eq '2'}">
							<div class="preview-icon bg-warning">
						</c:when>
						<c:when test="${notice.notiType eq '3'}">
							<div class="preview-icon bg-info">
						</c:when>
					</c:choose>
					<i class="ti-info-alt mx-0"></i>
				</div>
				</div>
				<div class="preview-item-content">
					<h6 class="preview-subject font-weight-normal">${notice.notiTitle}</h6>
					<p class="font-weight-light small-text mb-0 text-muted">${notice.notiDate}</p>
					${notice.notiStat}
				</div>
			</a>
		</c:otherwise>
	</c:choose>
</c:forEach>

<script type="text/javascript">
    $(".preview-item").on("click",function(){
    	var notiCd = document.getElementById("notiCd").getAttribute("value");
        $.ajax({
            type: "POST",
            url: "/oryuUniversity/notice/notificationView.do",
            data:{
            	notiCd: notiCd
            }
            ,success: function(data) {
                updateAlarm();
                updateMessageCount();
            },
            error: function(xhr, status, error) {
                console.error("AJAX 요청이 실패하였습니다.");
            }
        });
    });
</script>
