<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!-- module page -->
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/js/bootstrap5/css/bootstrap.min.css">

<style>
  .custom-flex-item {
    flex: 9;
  }
</style>

<script src="<%=request.getContextPath() %>/resources/js/jquery-3.7.0.min.js"></script>

<script>
	
	$(document).on('ready',function(){
		<c:if test="${not empty message}">
		Swal.fire({
	      icon: 'success',
	      title: '${message}',
	    });
		<%session.removeAttribute("message");%>
		</c:if>
	});
	

	$(document).on("ajaxError", function(jqXHR, settings, errorText){
		console.log("XMLHttpRequest : ", jqXHR);
		console.log("settings : ", settings);
		console.log("error : ", errorText);
	});
</script>