<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<table class="table table-hover" style="max-width: 1500px; margin: 0 auto;">
	<thead class="table-light">
		<tr>
			<th>년도</th>
			<th>학기</th>
			<th>학번</th>
			<th>학과</th>
			<th>이름</th>
			<th>장학종류</th>
			<th>신청날짜</th>
			<th>상태</th>
		</tr>
	</thead>
	<tbody>
		<c:set var="tuitionList" value="${paging.dataList }" />
		<c:if test="${empty tuitionList }">
			<tr>
				<td colspan="9">검색결과 없음.</td>
			</tr>
		</c:if>
		<c:if test="${not empty tuitionList }">
			<c:forEach items="${tuitionList }" var="tuition">
				<tr>
					<td>${tuition.semesterCd.substring(0, 4) }</td>
					<td>${tuition.semesterCd.substring(4, 5) }</td>
					<td><a href="#" class="scholarship-link" data-bs-toggle="modal" data-bs-target="#exampleModal" data-stcd="${tuition.stCd}" data-semestercd="${tuition.semesterCd}" data-tuschsta="${tuition.tuSchSta}">${tuition.stCd }</a></td>
					<td>${tuition.dtNm }</td>
					<td>${tuition.stNm }</td>
					<td>${tuition.tuSchType }</td>
					<td>${tuition.tuSchDate }</td>
					<c:if test="${tuition.tuSchSta eq '반려'}">
					    <td><button class="btn btn-danger" disabled style="opacity: 1;">${tuition.tuSchSta}</button></td>
					</c:if>
					<c:if test="${tuition.tuSchSta eq '승인'}">
					    <td><button class="btn btn-info" disabled style="opacity: 1;">${tuition.tuSchSta}</button></td>
					</c:if>
					<c:if test="${tuition.tuSchSta eq '대기'}">
					    <td><button class="btn btn-secondary" disabled style="opacity: 1;">${tuition.tuSchSta}</button></td>
					</c:if>
				</tr>
			</c:forEach>
		</c:if>
	</tbody>
</table>
<div style="padding: 20px; display: flex; justify-content: center;">${paging.pagingHTML }</div>

<script>

$(document).ready(function() {
    // 장학금 링크에 클릭 이벤트 핸들러 부착
    $(".scholarship-link").off("click").on("click", function(e) {
        e.preventDefault(); // 기본 링크 동작 방지

        // 데이터 속성에서 값 추출
        var stCd = $(this).data("stcd");
        var semesterCd = $(this).data("semestercd");
        var tuSchSta = $(this).data("tuschsta");
        
        // AJAX 요청 보내기
        $.ajax({
            type: "GET",
            url: "${pageContext.request.contextPath}/scholarship/scholarshipApplyView.do",
            data: {
                when: semesterCd,
                who: stCd
            },
            success: function(response) {
            	var year = response.tuition['semesterCd'].substring(0, 4);
                var semester = response.tuition['semesterCd'].substring(4, 5);
                var tuSchType = response.tuition['tuSchType'];
                var tuSchCon = response.tuition['tuSchCon'];
                
             	// 모달 내의 입력 필드에 값을 넣어줌.
                $("input[name='semesterCd1']").val(year);
                $("input[name='semesterCd2']").val(semester);
                $("input[name='tuSchType']").val(tuSchType);
                $("textarea[id='message-text']").val(tuSchCon);
                
             	// 첨부파일 관련 처리
                var fileInput = $("input[name='file']");
                var fileContainer = $("#file-download");
                
             	// 기존 첨부파일 링크들 제거
                fileContainer.empty();
             	
             	// 파일 다운로드 링크 생성 및 추가
             	if(response.tuition.fileGroup && response.tuition.fileGroup.detailList) {
             		var fileDetails = response.tuition.fileGroup['detailList'];
	                for (var i = 0; i < fileDetails.length; i++) {
	                    var downloadURL = "${pageContext.request.contextPath}/download.do?atchFileId=" + fileDetails[i].atchFileId + "&fileSn=" + fileDetails[i].fileSn;
	                    var link = $("<a>").attr("href", downloadURL).addClass("file-link").text(fileDetails[i].orignlFileNm);
	                    fileContainer.append(link);
	                }
             	}
             	
            },
            error: function(error) {
                console.error("AJAX 요청 보내는 중 에러:", error);
            }
        });
        
        $("#approveButton").off("click").on("click", function() {
        	
        	$('#exampleModal').modal('hide'); // 모달 창 닫기
        	
            // AJAX 요청을 생성합니다.
            $.ajax({
                url: "${pageContext.request.contextPath}/scholarship/scholarshipAccept.do",
                type: "POST", // 요청 방식 (POST)
                data: {
                	semesterCd: semesterCd,
                    stCd: stCd
                },
                success: function(response) {
                	if(response.result === "이미승인") {
                		Swal.fire({
          			      icon: 'info',
          			      title: '이미 승인요청이 완료되었습니다.',
          			      
          			      confirmButtonColor: '#3085d6',
          			      confirmButtonText: '확인'
          			    });
                	}else {
	                     setTimeout(function() {
	                    	 Swal.fire({
	             			      icon: 'success',
	             			      title: '승인이 완료되었습니다.',
	             			      
	             			      confirmButtonColor: '#3085d6',
	             			      confirmButtonText: '확인'
	             			    });
	    			     }, 100);
	                	 fetchTuition();
	                	 // window.location.href = "${pageContext.request.contextPath}/scholarship/scholarshipApplyRetrieve.do";
                	}
                },
                error: function(jqXHR, textStatus, errorThrown) {
                    // 요청에 대한 실패 처리를 진행합니다.
                    Swal.fire({
        			      icon: 'error',
        			      title: '승인 요청 도중 에러가 발생했습니다.',
        			      
        			      confirmButtonColor: '#3085d6',
        			      confirmButtonText: '확인'
        			    });
                }
            });
        });
        
        $("#rejectButton").off("click").on("click", function() {
        	
        	if(tuSchSta === "반려") {
        		$('#exampleModal').modal('hide');
        		setTimeout(function(){
        			Swal.fire({
        			      icon: 'info',
        			      title: '이미 반려 요청이 완료되었습니다.',
        			      
        			      confirmButtonColor: '#3085d6',
        			      confirmButtonText: '확인'
        			    });
            	}, 100);
        		return;
        	}
        	
            $("#exampleModal2").modal("show");
            $('#exampleModal').modal('hide');
            
            // "Send message" 버튼 클릭 시의 처리
            $("#sendMessageButton").off("click").on("click", function() {
                var tuRea = $("#message-text2").val();
                // AJAX 요청을 생성합니다.
                $.ajax({
                    url: "${pageContext.request.contextPath}/scholarship/scholarshipReject.do",
                    type: "POST", // 요청 방식 (POST)
                    data: {
                        semesterCd: semesterCd,
                        stCd: stCd,
                        tuRea: tuRea
                    },
                    success: function(response) {
                    	if(response.result === "이미반려") {
                    		$("#exampleModal2").modal("hide");
                    		setTimeout(function(){
                    			Swal.fire({
                  			      icon: 'info',
                  			      title: '이미 반려 요청이 완료되었습니다.',
                  			      
                  			      confirmButtonColor: '#3085d6',
                  			      confirmButtonText: '확인'
                  			    });
	                    	}, 100);
                    	}else {
                    		$("#exampleModal2").modal("hide");
	                    	setTimeout(function(){
	                    		Swal.fire({
	              			      icon: 'success',
	              			      title: '반려 요청이 완료되었습니다.',
	              			      
	              			      confirmButtonColor: '#3085d6',
	              			      confirmButtonText: '확인'
	              			    });
	                    	}, 100);
	                        fetchTuition();
	                        //window.location.href = "${pageContext.request.contextPath}/scholarship/scholarshipApplyRetrieve.do";
                    	}
                    },
                    error: function(jqXHR, textStatus, errorThrown) {
                        // 요청에 대한 실패 처리를 진행합니다.
                        Swal.fire({
        			      icon: 'error',
        			      title: '반려 요청 도중 에러가 발생했습니다.',
        			      
        			      confirmButtonColor: '#3085d6',
        			      confirmButtonText: '확인'
        			    });
                    }
                });
            });
        });
    });
});

</script>