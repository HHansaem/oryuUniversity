<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<script src="${pageContext.request.contextPath}/resources/js/ckeditor/ckeditor.js"></script>
<form:form method="post" modelAttribute="acBuDocVO" enctype="multipart/form-data">




<div class="card box-shadow d-flex m-4" style="min-height: 87%;">
      <div class="h-100">
<div class="card-header" style="border-radius: 20px 20px 0 0; background-color: #154FA9; font-weight: bold; color: white;">${acBuDocVO.buDocNm} 상세 내용</div>
<table class="table table-bordered" style="margin: 0 auto;">
<tr>
			<th>학술사업코드</th>
			<td> 
			<form:input path="acBuCd" class="form-control" readonly="true" /> 
			<form:errors path="acBuCd" class="error" />
			</td>
		</tr>
      
      	<tr>
		    <th>분류 선택</th>
			<td><form:input path="buDocClass" class="form-control" readonly="true"/> 
			<form:errors path="buDocClass" class="error" /></td>
		</tr>
      
      	<tr>
			<th>제목</th>
			<td><form:input path="buDocNm" class="form-control" readonly="true"/> 
			<form:errors path="buDocNm" class="error" /></td>
		</tr>
      
      <tr>
         <th>작성자</th>
         <td>
            <form:input path="buDocAutNm" class="form-control" readonly="true"/>
            <form:errors path="buDocAutNm" class="error" />
         </td>
      </tr>
      <tr>
         <th>내용(요약)</th>
         <td>
            <form:textarea path="buDocShortCont" class="form-control" readonly="true"/>
            <form:errors path="buDocShortCont" class="error" />
         </td>
      </tr>
      <tr>
         <th>내용</th>
         <td>
            <form:textarea path="buDocCont" class="form-control" readonly="true"/>
            <form:errors path="buDocCont" class="error" />
         </td>
      </tr>
      
      <tr>
         <th>기존 첨부파일</th>
         <td>
            <c:if test="${not empty acBuDocVO.fileGroup and not empty acBuDocVO.fileGroup.detailList }">
               <c:forEach items="${acBuDocVO.fileGroup.detailList }" var="fileDetail">
                  <c:url value="/acBuDoc/acBuDocDownload.do" var="downloadURL">
                     <c:param name="atchFileId" value="${fileDetail.atchFileId }" />
                     <c:param name="fileSn" value="${fileDetail.fileSn }" />
                  </c:url>
                  <a href="${downloadURL }">${fileDetail.orignlFileNm }</a>
               </c:forEach>
            <img id="imageFastView" src="${downloadURL}" style="display: none;">
            </c:if>
         </td>
      </tr>
	   </table>
	   <div class="card-header" style="border-radius: 20px 20px 0 0; background-color: lightgray; font-weight: bold; color: white;">${acBuDocVO.buDocNm} 평가</div>
	   <table class="table table-bordered">
	 <sec:authorize access="hasRole('ROLE_TS')">
		    <th>분류 선택</th>
		    <td>
		        <label>
		            <input type="radio" name="documentType" value="Suitable" onclick="evDocumentType('적합')">
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
		    <input type="hidden" id="buDocEvNm" name="buDocEvNm" />
		    </td>
	      <tr>
	         <th>평가내용</th>
	         <td>
	            <form:textarea path="buDocEvCont" class="form-control" />
	            <form:errors path="buDocEvCont" class="error" />
	         </td>
	      </tr>
	      <tr>
	      <th>평가작성자</th>
	         <td>
	            <form:input path="buDocEvAutNm" class="form-control" />
	            <form:errors path="buDocEvAutNm" class="error" />
	         </td>
	      </tr>
	      
	      
	 </sec:authorize>
	 
	 	 <sec:authorize access="hasRole('ROLE_PR')">
	         <th>평가명</th>
	         <td>
	            <form:textarea path="buDocEvNm" class="form-control" readonly="true" />
	            <form:errors path="buDocEvNm" class="error"  />
	         </td>
	      <tr>
	         <th>평가내용</th>
	         <td>
	            <form:textarea path="buDocEvCont" class="form-control" readonly="true" />
	            <form:errors path="buDocEvCont" class="error"  />
	         </td>
	      </tr>
	      <tr>
	      <th>평가작성자</th>
	         <td>
	            <form:textarea path="buDocEvAutNm" class="form-control" readonly="true"/>
	            <form:errors path="buDocEvAutNm" class="error"  />
	         </td>
	      </tr>
	      
	 </sec:authorize>


      
      <sec:authorize access="hasRole('ROLE_PR')">
      
      <tr>
         <th>새 첨부파일</th>
         <td>
            <input type="file" name="acBuDocFiles" multiple />
         </td>
      </tr>
      
      </sec:authorize>
      
      <tr>
         <c:url value='/acBuDoc/acBuDocList.do' var="ListURL">
            <c:param name="what" value="${acBuDocVO.buDocCd }" />
         </c:url>
         
         <td colspan="2">
            <input type="submit" class="btn btn-primary" value="수정">
<!--             <input type="reset" class="btn btn-danger" value="취소"> -->
            <a class="btn btn-danger" href="${ListURL }">취소</a>
         </td>
      </tr>
      
      
      
   </table>
   <br>
         </div>
   </div>
   
   
</form:form>

<script>
    function evDocumentType(type) {
        var buDocEvNmInput = document.getElementById('buDocEvNm'); 
        console.log(type);
        if(type == '적합'){
        	buDocEvNmInput.value = '적합';
        }else if(type == '부적합'){
        	buDocEvNmInput.value = '부적합';
        }else if(type == '보류'){
        	buDocEvNmInput.value = '보류';
        }else {
        	buDocEvNmInput.value = '평가대기';
        }
    }
</script>

<script>
    const imgFV = document.querySelector('#imageFastView');
    imgFV.style.display = 'block';
</script>

<script>
    function updateDocumentType(type) {
        var buDocClassInput = document.getElementById('buDocClass');
        var errorText = document.getElementById('errorText');
        
        if (type == '학술사업계획서') {
            buDocClassInput.value = '학술사업계획서';
        } else if (type == '학술사업계획서') {
            buDocClassInput.value = '학술사업보고서';
        } else {
            buDocClassInput.value = '선택하지않음';
        }
        
        // 라디오버튼을 선택했을 경우
        if (document.querySelector('input[name="documentType"]:checked') === null) {
            errorText.style.display = 'block';
        } else {
            errorText.style.display = 'none';
        }
    }
</script>
