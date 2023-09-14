<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!-- 소속된 동아리가 있을시 동아리 개설 막기 -->
<h2>현재 소속된 동아리가 존재합니다.</h2>

<sec:authorize access="hasRole('ROLE_ST')"><!-- 학생 -->
<a href="${pageContext.request.contextPath}/club/clubInsertRequestListView.do">신청내역보기</a>
</sec:authorize>



