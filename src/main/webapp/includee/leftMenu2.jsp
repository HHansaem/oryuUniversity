<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<style>
/* 	.sidebar-icon-only .navbar .navbar-brand-wrapper { */
/*     	background: #ffffff; */
/* 	    transition: width 0.25s ease, background 0.25s ease; */
/* 	    -webkit-transition: width 0.25s ease, background 0.25s ease; */
/* 	    -moz-transition: width 0.25s ease, background 0.25s ease; */
/* 	    -ms-transition: width 0.25s ease, background 0.25s ease; */
/* 	    width: 235px; */
/* 	    height: 60px;	 */
/* 	} */
	.navbar .navbar-brand-wrapper {
	    background: #ffffff;
	    transition: width 0.25s ease, background 0.25s ease;
	    -webkit-transition: width 0.25s ease, background 0.25s ease;
	    -moz-transition: width 0.25s ease, background 0.25s ease;
	    -ms-transition: width 0.25s ease, background 0.25s ease;
	    width: 235px;
	    height: 60px;
	}
	.sidebar2 {
	    min-height: calc(100vh - 60px);
	    background: #fff;
	    font-family: "Nunito", sans-serif;
	    font-weight: 500;
	    padding: 0;
	    width: 235px;
	    z-index: 11;
	    transition: width 0.25s ease, background 0.25s ease;
	    -webkit-transition: width 0.25s ease, background 0.25s ease;
	    -moz-transition: width 0.25s ease, background 0.25s ease;
	    -ms-transition: width 0.25s ease, background 0.25s ease;
	}
	.sidebar2 .nav:not(.sub-menu) {
    	margin-left: 1rem;
    	margin-right: 1rem;
    	margin-top: 15px;
    }
    .sidebar2 .nav {
	    overflow: hidden;
	    flex-wrap: nowrap;
	    flex-direction: column;
	    margin-bottom: 60px;
	}
	.sidebar2 .nav:not(.sub-menu) > .nav-item {
    	margin-top: 0.2rem;
    }
    
    .sidebar2 .nav .nav-item {
	    -webkit-transition-duration: 0.25s;
	    -moz-transition-duration: 0.25s;
	    -o-transition-duration: 0.25s;
	    transition-duration: 0.25s;
	    transition-property: background;
	    -webkit-transition-property: background;
	}
	.sidebar2 .nav:not(.sub-menu) > .nav-item > .nav-link {
    	margin: 0;
	}
	.sidebar2 .nav .nav-item .nav-link {
    	display: -webkit-flex;
	    display: flex;
	    -webkit-align-items: center;
	    align-items: center;
	    white-space: nowrap;
	    padding: 0.8125rem 1.937rem 0.8125rem 1rem;
	    color: #6C7383;
	    border-radius: 8px;
	    -webkit-transition-duration: 0.45s;
	    -moz-transition-duration: 0.45s;
	    -o-transition-duration: 0.45s;
	    transition-duration: 0.45s;
	    transition-property: color;
	    -webkit-transition-property: color;
	}
	.sidebar2 .nav .nav-item .collapse {
    	z-index: 999;
	}
	
	.sidebar2 .nav.sub-menu {
	    margin-bottom: 0;
	    margin-top: 0;
	    list-style: none;
	    padding: 0.25rem 0 0 3.07rem;
	    background: #154FA9;
	    padding-bottom: 12px;
	}
	
	.sidebar2 .nav.sub-menu .nav-item {
    	padding: 0;
	}
	
	.sidebar2 .nav .nav-item {
	    -webkit-transition-duration: 0.25s;
	    -moz-transition-duration: 0.25s;
	    -o-transition-duration: 0.25s;
	    transition-duration: 0.25s;
	    transition-property: background;
	    -webkit-transition-property: background;
	}
	
	.sidebar2 .nav.sub-menu .nav-item .nav-link {
	    color: #fff;
	    padding: 0.7rem 1rem;
	    position: relative;
	    font-size: 0.875rem;
	    line-height: 1;
	    height: auto;
	    border-top: 0;
	}
	.sidebar2 .nav:not(.sub-menu) > .nav-item > .nav-link[aria-expanded="true"] {
    	border-radius: 8px 8px 0 0;
    	background: #154FA9;
    	color: #fff;
	}
	.sidebar2 .nav .nav-item .nav-link i.menu-icon {
    font-size: 1rem;
    line-height: 1;
    margin-right: 1rem;
    color: #6C7383;
	}
	.sidebar2 .nav:not(.sub-menu) > .nav-item > .nav-link[aria-expanded="true"] {
    border-radius: 8px;
    background: #154FA9;
    color: #fff;
	}
	.sidebar2 .nav .nav-item.active{
    	border-radius: 8px;
	}
	.sidebar2 .nav:not(.sub-menu) > .nav-item.active{
    	background: #154FA9;
	}
	.sidebar2 .nav:not(.sub-menu) > .nav-item > .nav-link[aria-expanded="true"] {
    border-radius: 8px;
    background: #154FA9;
    color: #fff;
	}
 	.sidebar2 .nav .nav-item:hover > .nav-link i, .sidebar2 .nav .nav-item:hover > .nav-link .menu-title, .sidebar2 .nav .nav-item:hover > .nav-link .menu-arrow { 
     	color: #fff; 
 	}
 	.sidebar2 .nav:not(.sub-menu) > .nav-item:hover > .nav-link, .sidebar2 .nav:not(.sub-menu) > .nav-item:hover[aria-expanded="true"] {
    	background: #154FA9;
    	color: #fff;
	} 

}	

	
</style>

      <nav class="sidebar2 sidebar-offcanvas" id="sidebar2" style="border-left: 3px solid #f6f6f6;">
<!--           <div class="text-white d-flex align-items-center" style="background-color: #154FA9; height: 50px;"> -->
<!--             <i class="mdi mdi-lead-pencil font-weight-bold" style="margin-left: 20px;">강의</i> -->
<!--           </div> -->
          <ul class="nav">
            <li class="d-flex justify-content-center border-bottom">
              <a class="nav-link" href="#">
                <span class="menu-title">강의명</span>
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" aria-expanded="false" href="<%=request.getContextPath()%>/lecture/noticeList.do?lecCd=${lecCd}">
                <i class="icon-layout menu-icon"></i>
                <span class="menu-title">공지</span>
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" aria-expanded="false" href="<%=request.getContextPath()%>/lecture/videoLectureList.do?lecCd=${lecCd}">
                <i class="icon-head menu-icon"></i>
                <span class="menu-title">화상/동영상강의</span>
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" aria-expanded="false" href="<%=request.getContextPath()%>/lecture/homeworkList.do?lecCd=${lecCd}">
                <i class="icon-bar-graph menu-icon"></i>
                <span class="menu-title">과제</span>
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" aria-expanded="false" href="<%=request.getContextPath()%>/lecture/examList.do?lecCd=${lecCd}">
                <i class="icon-grid-2 menu-icon"></i>
                <span class="menu-title">시험</span>
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" aria-expanded="false" href="<%=request.getContextPath()%>/lecture/AttendanceView.do?lecCd=${lecCd}">
                <i class="icon-contract menu-icon"></i>
                <span class="menu-title">출석</span>
              </a>
            </li>
            <sec:authorize access="hasRole('ROLE_PR')">
            <li class="nav-item">
              <a class="nav-link" aria-expanded="false" href="<%=request.getContextPath()%>/enrollment/gradeList.do?lecCd=${lecCd}">
                <i class="icon-ban menu-icon"></i>
                <span class="menu-title">성적</span>
              </a>
            </li>
            </sec:authorize>
          </ul>
        </nav>
    
<script>
	$(document).ready(function(){
		var aHref = localStorage.getItem('a');
		$(`a[href='\${aHref}']`).attr("aria-expanded", "true");
	})
	
	$("#sidebar2 a").on("click",function(){
		localStorage.removeItem('a');
		var aHref = $(this).attr("href");
		localStorage.setItem('a',aHref);
	})
	$("#sidebar").on("mouseover",function(){
		$("#body").removeClass("sidebar-icon-only");
	})
	$("#sidebar").on("mouseout",function(){
		$("#body").addClass("sidebar-icon-only");
	})
</script>
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    