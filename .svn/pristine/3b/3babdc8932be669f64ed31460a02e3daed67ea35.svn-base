<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<div class="container">
	<div class="row" style="margin: 20px -460px 0 -180px;">
   <div class="col-lg-5 stretch-card">
      <div class="card box-shadow" >
         <div class="card-body" style="padding:0;">
         	<div class="card-header py-3" style="border-radius: 20px 20px 0 0;">과제 목록 조회</div>
            <div class="table-responsive p-3">
               <table class="table">
                  <thead>
                     <tr class="table-primary">
                        <th>진행중인 과제</th>
                     </tr>
                  </thead>
                  <tbody>
                     	<c:choose>
                     		<c:when test="${openAssign.size() > 0}">
	                     	<c:forEach var="openAssign" items="${openAssign}" varStatus="cnt">
	                        <tr>
	                           <td>
	                              <div class="d-flex align-items-center">
	                                 <div class="custom-flex-item">${cnt.index+1}.
	                                    ${openAssign.assiNm}</div>
	                                 <div class="justify-content-end">
	                                 	<input type="button" class="btn btn-primary btn-sm" onclick=assignView(${openAssign.assiCd}) value="상세조회"/>
<!-- 	                                    <a -->
<%-- 	                                       href="<%=request.getContextPath()%>/lecture/homeworkDetail.do?assiCd=${openAssign.assiCd}" --%>
<!-- 	                                       class="btn btn-primary btn-sm">상세조회</a> -->
	                                 </div>
	                              </div>
	                           </td>
	                        </tr>
	                        <tr>
	                           <td>
	                              <div class="d-flex align-items-center">
	                                 <div class="custom-flex-item">진행중</div>
	                                 <div class="justify-content-end">제출 마감일시:
	                                    ${openAssign.endTime}</div>
	                              </div>
	                           </td>
	                        </tr>
	                     </c:forEach>
	                     </c:when>
	                     <c:otherwise>
	                     	<tr>
	                     		<td>
	                     			<div class="d-flex align-items-center" style="font-weight:bold;">
		                     			진행중인 과제가 존재하지 않습니다.
	                     			</div>
	                     		</td>
	                     	</tr>
	                     </c:otherwise>
                     </c:choose>

                  </tbody>
               </table>
            </div>
            <div class="table-responsive p-3">
               <table class="table">
                  <thead>
                     <tr class="table-primary">
                        <th>마감된 과제</th>
                     </tr>
                  </thead>
                  <tbody>
                  	 <c:choose>
                  	 	<c:when test="${closedAssign.size() > 0}">
	                     <c:forEach var="closedAssign" items="${closedAssign}" varStatus="cnt">
	                        <tr>
	                           <td>
	                              <div class="d-flex align-items-center">
	                                 <div class="custom-flex-item">${cnt.index+1}.
	                                    ${closedAssign.assiNm}</div>
	                                 <div class="justify-content-end">
	                                 	<input type="button" class="btn btn-primary btn-sm" onclick=assignView(${closedAssign.assiCd}) value="상세조회"/>
<!-- 	                                    <a -->
<%-- 	                                       href="<%=request.getContextPath()%>/lecture/homeworkDetail.do?assiCd=${closedAssign.assiCd}" --%>
<!-- 	                                       class="btn btn-primary btn-sm">상세조회</a> -->
	                                 </div>
	                              </div>
	                           </td>
	                        </tr>
	                        <tr>
	                           <td>
	                              <div class="d-flex align-items-center">
	                                 <div class="custom-flex-item">마감</div>
	                                 <div class="justify-content-end">제출 마감일시:
	                                    ${closedAssign.endTime}</div>
	                              </div>
	                           </td>
	                        </tr>
	                     </c:forEach>
	                     </c:when>
	                     <c:otherwise>
	                     	<tr>
                     			<td>
	                     			<div class="d-flex align-items-center" style="font-weight:bold;">
		                     			진행중인 과제가 존재하지 않습니다.
	                     			</div>
	                     		</td>
	                     	</tr>
	                     </c:otherwise>
                     </c:choose>
                  </tbody>
               </table>
            </div>
         </div>
      </div>
   </div>
   <div id="homeworkSub" class="col-lg-5 stretch-card" style="left: 58%; position: fixed; height: 85%;">
      <div class="card right-align box-shadow">
      	<div class="card-header py-3" style="border-radius: 20px 20px 0 0;">과제 상세 조회</div>
         <div class="" id="cardBody">
         </div>
      </div>
   </div>
   </div>
</div>

<script>
	function assignView(assiCd){
		
		var data = 
		{
			assiCd : assiCd	
		}
		$.ajax({
	        type: "POST", // 또는 GET 등 사용할 HTTP 메서드 선택
	        data: data,
	        url: "${pageContext.request.contextPath}/lecture/homeworkStDetail.do",
	        success: function(response) {
	        	$("#cardBody").html(response);
	        },
	        error: function(xhr, status, error) {
	            console.error(error);
	        }
	    });
	}
	



</script>