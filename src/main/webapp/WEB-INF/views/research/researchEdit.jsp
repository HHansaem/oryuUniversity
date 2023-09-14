<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<script src="${pageContext.request.contextPath}/resources/js/ckeditor/ckeditor.js"></script>
<form:form method="post" modelAttribute="researchVO" enctype="multipart/form-data">
	<form:hidden path="reseCd"/>

<table class = "table">
   <tr><td><strong>연구 수정</strong><td></tr>
</table>
<table class="table table-bordered">

	
	<tr>
         <th>학술사업코드</th> 
         <td><form:input path="acBuCd" class="form-control"
               id="categoryInput" readonly="true" /><form:errors path="acBuCd"
               class="error" />
               <hr>
            <button type="button" class="btn btn-primary" data-bs-toggle="modal"
               data-bs-target="#exampleModal">사업코드선택</button> <!-- Modal -->
            <div class="modal fade" data-url="${viewURL }" id="exampleModal"
               tabindex="-1" aria-labelledby="exampleModalLabel"
               aria-hidden="true">
               <div class="modal-dialog">
                  <div class="modal-content">
                     <div class="modal-header">
                        <h1 class="modal-title fs-5" id="exampleModalLabel">학술사업코드선택</h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal"
                           aria-label="Close"></button>
                     </div>
                     <div class="modal-body">
                        <a href="#" onclick="selectCategory('A001');">경영(A001)
                        </a><br>
                        <hr />
                        <a href="#" onclick="selectCategory('B001');">예술(B001)
                        </a><br>
                        <hr />
                        <a href="#" onclick="selectCategory('C001');">의학(C001) 
                        </a><br>
                        <hr />
                        <a href="#" onclick="selectCategory('D001');">인문(D001)
                        </a><br>
                        <hr />
                        <a href="#" onclick="selectCategory('E001');">자연과학(E001)
                        </a><br>
                        <hr />
                        <a href="#" onclick="selectCategory('F001');">공학(F001)
                        </a><br>
                        <hr />
                        <a href="#" onclick="selectCategory('G001');">농수해양(G001)
                        </a><br>
                        <hr />
                        <a href="#" onclick="selectCategory('H001');">사회과학(H001)
                        </a><br>
                        <hr />
                        <a href="#" onclick="selectCategory('I001');">기초과학(I001)
                        </a><br>
                        <hr />                                                                                                                  
                        <pre>선택한 코드 : <input id="modalInput" disabled="disabled" />
                        </pre>
                     </div>
                     <div class="modal-footer">
                        <button type="button" class="btn btn-secondary"
                           data-bs-dismiss="modal">완료</button>
                     </div>
                  </div>
               </div>
            </div>
         </td>
      </tr>
	
	<tr>
		<th>연구명</th>
		<td>
			<form:input path="reseNm" class="form-control" />
			<form:errors path="reseNm" class="error"/>
		</td>
	</tr>
	
	<tr>
		<th>연구요약</th>
		<td>
			<form:input path="reseShortCont" class="form-control" />
			<form:errors path="reseShortCont" class="error"/>
		</td>
	</tr>
	
	<tr>
		<th>연구내용</th>
		<td>
			<form:input path="reseCont" class="form-control" />
			<form:errors path="reseCont" class="error"/>
		</td>
	</tr>
	<tr>
		<th>연구책임자</th>
		<td>
			<form:input path="reseAutNm" class="form-control" />
			<form:errors path="reseAutNm" class="error"/>
		</td>
	</tr>
      <tr>
         <th>기존 첨부파일</th>
         <td>
            <c:if test="${not empty researchVO.fileGroup and not empty researchVO.fileGroup.detailList }">
               <c:forEach items="${researchVO.fileGroup.detailList }" var="fileDetail">
                  <c:url value="/research/researchDownload.do" var="downloadURL">
                     <c:param name="atchFileId" value="${fileDetail.atchFileId }" />
                     <c:param name="fileSn" value="${fileDetail.fileSn }" />
                  </c:url>
                  <a href="${downloadURL }">${fileDetail.orignlFileNm }</a>
               </c:forEach>
            <img id="imageFastView" src="${downloadURL}" style="display: none;">
            </c:if>
         </td>
      </tr>
      
      <sec:authorize access="hasRole('ROLE_PR')">
      
      <tr>
         <th>새 첨부파일</th>
         <td>
            <input type="file" name="reseFiles" multiple />
         </td>
      </tr>
      
      </sec:authorize>
      <sec:authorize access="hasRole('ROLE_TS')">
	<tr>
		<th>연구상태</th>
		<td>
		        <label>
		            <input type="radio" name="documentType" value="Suitable" onclick="evDocumentType('적합')" >
		            적합
		        </label>
		        <label>
		            <input type="radio" name="documentType" value="Unsuitable" onclick="evDocumentType('부적합')" >
		            부적합
		        </label>
		        <label>
		            <input type="radio" name="documentType" value="Hold" onclick="evDocumentType('보류')" >
		            보류
		        </label>
		    <input type="hidden" id="reseStat" name="reseStat" />
		    </td>
	</tr>
	 </sec:authorize>
	<tr>
	      <c:url value='/research/researchList.do' var="ListURL">
            <c:param name="what" value="${researchVO.reseCd }" />
         </c:url>
		<td colspan="2">
			<input type="submit" value="수정">
			<input type="reset" value="취소">
			<input type="button" value="뒤로가기" 
				onclick="history.back();">
<%-- 			<a href="<c:url value='/research/researchList.do'/>">목록으로</a> --%>
		</td>
	</tr>
</table>
</form:form>

<script>
    CKEDITOR.replace('reseCont', {
          filebrowserImageUploadUrl: '${pageContext.request.contextPath }/uploadImage.do'
    });
</script>


<script>
   // 모달 창 열기 함수
   function openModal() {
      document.getElementById('myModal').style.display = 'flex';
   }

   // 모달 창 닫기 함수
   function closeModal() {
      document.getElementById('myModal').style.display = 'none';
   }

   // 선택한 카테고리를 입력 필드에 설정하는 함수
   function selectCategory(category) {
      document.getElementById('categoryInput').value = category;
      document.getElementById('modalInput').value = category;

      closeModal();
   }
</script>
<script>
    const imgFV = document.querySelector('#imageFastView');
    imgFV.style.display = 'block';
</script>

<script>
    function researchDocumentType(type) {
        var reseStatInput = document.getElementById('reseStat'); 
        console.log(type);
        if(type == '적합'){
        	reseStatInput.value = '적합';
        }else if(type == '부적합'){
        	reseStatInput.value = '부적합';
        }else if(type == '보류'){
        	reseStatInput.value = '보류';
        }else {
        	reseStatInput.value = '평가대기';
        }
    }
</script>