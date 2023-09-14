<%@ page import="kr.or.ddit.thesis.vo.ThesisVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<style>
.paging-info {
        display: flex;
        justify-content: space-between;
        align-items: center;
    }
.paging-info p {
        margin: 0;
    }
    
#videoContainer {
        display: flex;
        justify-content: center;
        align-items: center;
        height: 300px; /* Adjust the height as needed */
    }

#videoContainer video {
        max-width: 100%;
        max-height: 100%;
    }
    
video {
    width: 100%; 
    height: auto; 
  }


    
</style>

<%-- <a href="<c:url value='/thesis/thesisInsert.do'/>">논문등록</a> --%>

<div class="card box-shadow d-flex m-4" style="min-height: 87%;">
      <div class="h-100">
<div class="card-header" style="border-radius: 20px 20px 0 0; background-color: #154FA9; font-weight: bold; color: white;">논문/연구 상세보기</div>
<div style="margin-left:10px;margin-top:10px;">
	<h3>${thesisVO.thesNm } 상세조회</h3>
	<p>순번 : ${thesisVO.thesSn } | 학술사업코드 : ${thesisVO.acBuCd } | 분류 : ${thesisVO.thesClNm } </p>
	<p>작성자 : ${thesisVO.thesAutNm1 } | 발행처 : ${thesisVO.thesAutNm2 } | 작성일 : ${thesisVO.thesModDate }</p>
</div>
 <div style="overflow-x: auto;">

<table class="table" >

	<tr>
		<th style="background-color: rgba(0, 0, 0, 0.03); width: 150px; text-align: center;">요약</th>
		<td>${thesisVO.thesShortCont }</td>
	</tr>
	<tr>
		<th style="background-color: rgba(0, 0, 0, 0.03); width: 150px; text-align: center;">내용</th>
		<td style="white-space: pre-line;">${thesisVO.thesCont}</td>
	</tr>

	<tr>
		<th style="background-color: rgba(0, 0, 0, 0.03); width: 150px; text-align: center;">첨부파일</th>
		<td>
<%-- 		<img id="imageFastView" src="${downloadURL}" style="display: none;"> --%>
			<c:forEach items="${thesisVO.fileGroup.detailList}" var="fileDetail">
			    <c:url value="/download.do" var="downloadURL">
			        <c:param name="atchFileId" value="${fileDetail.atchFileId}" />
			        <c:param name="fileSn" value="${fileDetail.fileSn}" />
			    </c:url>		
			    <a href="${downloadURL}">${fileDetail.orignlFileNm}</a>
			</c:forEach>
		</td>
	</tr>

<tr>
	<c:url value='/thesis/thesisUpdate.do' var="updateURL">
		<c:param name="what" value="${thesisVO.thesSn }" />
	</c:url>
	<c:url value='/thesis/thesisDelete.do' var="deleteURL">
		<c:param name="what" value="${thesisVO.thesSn }" />
	</c:url>
	<c:url value='/thesis/thesisList.do' var="listURL" />
		<sec:authorize access="hasRole('ROLE_PR')">
         <td colspan="2">
               <a class="btn btn-primary" href="${updateURL }">수정</a>
				<button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#deleteModal">
				    삭제
				</button>
				
					<div class="modal fade" id="deleteModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
					    <div class="modal-dialog">
					        <div class="modal-content">
					            <div class="modal-header">
					                <h5 class="modal-title" id="exampleModalLabel">삭제하기</h5>
					                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
					            </div>
					            <div class="modal-body">
					                <form id="deleteForm" action="${deleteURL}" method="get">

					                    <div class="mb-3">
					                        <label for="password" class="form-label">비밀번호</label>
					                        <input type="password" class="form-control" id="password" name="password">
					                    </div>
					                </form>
					            </div>
					            <div class="modal-footer">
					                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
					                <button type="button" class="btn btn-danger" onclick="submitDeleteForm()">삭제하기</button>
					            </div>
					        </div>
					    </div>
					</div>
		            
               <a class="btn btn-success" href="${listURL }">목록</a>
         </td>
         </sec:authorize>
         <sec:authorize access="hasRole('ROLE_TS')">
         <td colspan="2">
         	<a class="btn btn-success" href="${listURL }">목록</a>
         </td>
         </sec:authorize>
   </tr>

</table>
  </div>
      </div>
   </div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<script>
    function submitDeleteForm() {
        var password = document.getElementById("password").value;

        if (password === "java") {
            var xhr = new XMLHttpRequest();
            xhr.open("GET", "${deleteURL}", true);
            xhr.onreadystatechange = function () {
                if (xhr.readyState === 4 && xhr.status === 200) {
                    closeModal();
                } else if (xhr.readyState === 4 && xhr.status !== 200) {
                    console.log("Error: 삭제할 수 없습니다.");
                }
            };
            xhr.send("${deleteURL}");
            alert("삭제되었습니다.");
            window.location.href = "${listURL}"; // 리스트로 이동
        } else {
            alert("비밀번호가 틀렸습니다.");
            closeModal();
        }
    }

    function closeModal() {
        var deleteModal = new bootstrap.Modal(document.getElementById('deleteModal'));
        deleteModal.hide();
    }
</script>

<script>
    document.addEventListener("DOMContentLoaded", function () {
        const imgFV = document.querySelector('#imageFastView');
        const downloadURL = "${downloadURL}"; // Replace with your actual variable or value

        if (!downloadURL || downloadURL.trim() === "") {
            // Check if downloadURL is null or empty
            imgFV.style.display = 'none'; // Hide the img element
        } else {
            imgFV.style.display = 'block'; // Show the img element
        }
    });
</script>