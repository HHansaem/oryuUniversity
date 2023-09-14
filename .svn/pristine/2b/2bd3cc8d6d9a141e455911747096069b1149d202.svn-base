<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" buffer="8kb"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>	
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %> 
<!DOCTYPE html>
<html lang="en">

<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>오류대학교</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/sweetalert2@11.4.10/dist/sweetalert2.min.css">
  <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.4.10/dist/sweetalert2.min.js"></script>
  <tiles:insertAttribute name="preScript"/>
  <!-- plugins:css -->
  
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/vendors/mdi/css/materialdesignicons.min.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/vendors/feather/feather.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/vendors/ti-icons/css/themify-icons.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/vendors/css/vendor.bundle.base.css">
  <!-- endinject -->
  <!-- Plugin css for this page -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/vendors/datatables.net-bs4/dataTables.bootstrap4.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/vendors/ti-icons/css/themify-icons.css">
  <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/js/select.dataTables.min.css">
  <!-- End plugin css for this page -->
  <!-- inject:css -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/vertical-layout-light/style.css">
  <!-- endinject -->
  <link rel="shortcut icon" href="<%=request.getContextPath()%>/resources/images/oryuLogo/oryuLogoMini.png" />
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/album.css">
<!--   font -->
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400&display=swap" rel="stylesheet">
  
  
  
   <style>
  .dropdown-menu .highlight {
    color: #154FA9; /* 원하는 색상으로 변경 */
    font-weight: bold; /* 원하는 스타일 적용 */
  }
  .font-style {
	font-family: 'Noto Sans KR', sans-serif;
  }
  .swal2-modal .swal2-icon, .swal2-modal .swal2-success-ring{
  	margin-bottom: 0;
  } 
  </style>
</head>
<body>
  <div class="container-scroller font-style">
   	<tiles:insertAttribute name="headerMenu" />
    <!-- partial -->
    <sec:authorize access="!hasRole('ROLE_TS')">
    <div class="container-fluid page-body-wrapper">
    </sec:authorize>
    <sec:authorize access="hasRole('ROLE_TS')">
    <div class="container-fluid page-body-wrapper" style="margin-top: -60px;">
    </sec:authorize>
    
      <!-- partial:partials/_settings-panel.html -->
      <div class="theme-setting-wrapper">
        <div id="theme-settings" class="settings-panel">
          <i class="settings-close ti-close"></i>
          <p class="settings-heading">SIDEBAR SKINS</p>
          <div class="sidebar-bg-options selected" id="sidebar-light-theme"><div class="img-ss rounded-circle bg-light border mr-3"></div>Light</div>
          <div class="sidebar-bg-options" id="sidebar-dark-theme"><div class="img-ss rounded-circle bg-dark border mr-3"></div>Dark</div>
          <p class="settings-heading mt-2">HEADER SKINS</p>
          <div class="color-tiles mx-0 px-4">
            <div class="tiles success"></div>
            <div class="tiles warning"></div>
            <div class="tiles danger"></div>
            <div class="tiles info"></div>
            <div class="tiles dark"></div>
            <div class="tiles default"></div>
          </div>
        </div>
      </div>
      <!-- partial -->
      <!-- partial:partials/_sidebar.html -->
      <tiles:insertAttribute name="leftMenu" />
<%--       <tiles:insertAttribute name="leftMenu2" /> --%>
      <!-- partial -->
      <div class="main-panel">
        <tiles:insertAttribute name="contentPage" />
        <!-- content-wrapper ends -->
        <!-- partial:partials/_footer.html -->
        <footer class="footer">
          <div class="d-sm-flex justify-content-center justify-content-sm-between">
            <span class="text-muted text-center text-sm-left d-block d-sm-inline-block">Copyright © 2021.  Premium <a href="https://www.bootstrapdash.com/" target="_blank">Bootstrap admin template</a> from BootstrapDash. All rights reserved.</span>
            <span class="float-none float-sm-right d-block mt-1 mt-sm-0 text-center">Hand-crafted & made with <i class="ti-heart text-danger ml-1"></i></span>
          </div>
          <div class="d-sm-flex justify-content-center justify-content-sm-between">
            <span class="text-muted text-center text-sm-left d-block d-sm-inline-block">Distributed by <a href="https://www.themewagon.com/" target="_blank">Themewagon</a></span> 
          </div>
        </footer> 
        <!-- partial -->
      </div>
      <!-- main-panel ends -->
    </div>   
    <!-- page-body-wrapper ends -->
  </div>
  <!-- container-scroller -->

  <!-- plugins:js -->
  <tiles:insertAttribute name="postScript"/>
</body>

</html>

















