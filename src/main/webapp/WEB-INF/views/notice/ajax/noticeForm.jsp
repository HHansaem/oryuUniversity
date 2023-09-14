<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<form:form method="post" modelAttribute="notification">
	<table class="table table-border">
		<form:hidden id="notiSender" path="notiSender" class="form-control" value="${notification.notiSender}" />	
		<tr>
			<th>알림코드</th>
			<c:if test="${empty notification.notiCd }">
				<td> 알림코드는 자동으로 입력됩니다.</td>
			</c:if>
			<td>
			${notification.notiCd }
			</td>
		</tr>
		<tr>
			<th>발신자(코드)</th>
			<td>
				${notification.tsNm}(${notification.notiSender})
			</td>
		</tr> 
		<tr>
			<th>수신자</th>
			<td>
				<label><form:radiobutton path="notiReceiver" value="1" label="교직원" /></label>
                <label><form:radiobutton path="notiReceiver" value="2" label="교수" /></label>
                <label><form:radiobutton path="notiReceiver" value="3" label="학생" /></label>
                <form:errors path="notiReceiver" class="error"/>
			</td>
		</tr>
		<tr>
		<th>알림종류</th>
		    <td>
		        <form:select id="notiType" class="form-control" path="notiType">
		        	<form:option value="" label="-- 선택하세요 --" />
		            <form:option value="1" label="개인알림" />
		            <form:option value="2" label="학과알림" />
		            <form:option value="3" label="강의알림" />
		        </form:select>
		        <form:errors path="notiType" class="error" />
		    </td>
		<tr>
			<th>제목</th>
			<td>
				<form:input id="notiTitle" path="notiTitle" class="form-control" type="text"  value="${notification.notiTitle}" />
				<form:errors path="notiTitle" class="error"/>
			</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>
				<form:textarea id="notiCont" path="notiCont" class="form-control" type="text"  value="${notification.notiCont}" />
				<form:errors path="notiCont" class="error"/>
			</td>
		</tr>
		<tr>
			<td></td>
			<td>
				<input id="submitBtn" class="btn btn-success" type="submit" value="등록">
				<c:url value='/notice/mngNoticeList.do' var="ListURL"/>
				<a class="btn btn-danger" href="${ListURL }">취소</a>
			</td>
		</tr>
	</table>
</form:form>
<script>
$("#submitBtn").click(function() {
	event.preventDefault();
    
    const notiSender = $("#notiSender").val(); // 발신자
//     const notiReceiver = $("#notiReceiver").val(); // 수신자
    const notiType = $("#notiType").val(); // 알림 종류
	const notiTitle = $("#notiTitle").val(); // 제목
    const notiCont = $("#notiCont").val(); // 내용

    console.log(notiSender);
//     console.log(notiReceiver);
    console.log(notiType);
    console.log(notiTitle);
    console.log(notiCont);
    
    
    if (notiTitle === "") {
        alert("제목을 입력해주세요."); // Display an alert if combinedValues is empty
        return; // Exit the function without making the AJAX request
    }
    if (notiCont=== "") {
        alert("내용을 입력해주세요."); // Display an alert if combinedValues is empty
        return; // Exit the function without making the AJAX request
    }
//     if (notiReceiver=== "") {
//         alert("수신자를 입력해주세요."); // Display an alert if combinedValues is empty
//         return; // Exit the function without making the AJAX request
//     }
	const selectedReceiver = $("input[name='notiReceiver']:checked").val();
	if (!selectedReceiver) {
	   alert("수신자를 선택해주세요.");
	   return;
	}

    const postData = {
        notiSender : notiSender ,
        notiReceiver : selectedReceiver ,
        notiType : notiType ,
        notiTitle : notiTitle ,
        notiCont : notiCont
    };

    $.ajax({
        url: "/oryuUniversity/notice/noticeInsert.do",
        type: "post",
        data: JSON.stringify(postData),
        contentType: "application/json",
        success: function(response) {
            alert(response);
            if(response=="알림 전송 완료"){
            window.location.href="<%=request.getContextPath()%>/notice/mngNoticeList.do";
            }
            // 여기에서 원하는 동작 수행
        },
        error: function(error) {
            alert(error);
        }
    });
});
</script>
