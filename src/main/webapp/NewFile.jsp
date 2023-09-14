<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<style>
.row{
	border: 2px;
}
</style> 
  <!--전체  -->
<!--    <div id="ihealth-layout" class="theme-tradewind"> -->
     <!-- main body area -->
     <div class="main px-lg-4 px-md-4">
   <!-- Body: Body -->
   <div class="body d-flex py-3">
       <div class="container-xxl">
           <!-- 1행 3열 카드 시작 -->
           <div class="row g-3 mb-3" style="height: 100vh;  margin-left:-300px; margin-right:-400px "> <!-- margin-left:-200px; margin-right:-200px-->
              <!-- 세로로 길게 배치된 card1 -->
              <div class="col-md-4 col-lg-4"
                 style="width: 20%; height: 100%; margin-right: 1%;">
                 <div class="card" style="height: 100%;">
                    <div
                       class="card-header py-3 d-flex justify-content-between bg-transparent border-bottom-0">
                       <h6 class="mb-0 fw-bold">Card 1</h6>
                    </div>
                    <div class="card-body">
                       <div id="#"></div>
                    </div>
                 </div>
              </div>
              <!-- 나머지 카드들 (2행부터) -->
              <div class="col-md-8 col-lg-8"
                 style="display: flex; flex-direction: column;  width: 50%;" >
                 <!-- 2행 1열 카드 시작 -->
                 <div class="row g-3 mb-3" style="flex: 1; display: flex; ">
                    <div class="col-md-4 col-lg-4"
                       style="width: 30%; margin-right: 1%; flex-grow: 1;">
                       <div class="card h-100">
                          <div
                             class="card-header py-3 d-flex justify-content-between bg-transparent border-bottom-0">
                             <h6 class="mb-0 fw-bold">Card 2</h6>
                          </div>
                          <div class="card-body">
                             <div id="#"></div>
                          </div>
                       </div>
                    </div>
                 </div>
                 <!-- 2행 1열 카드 종료 -->
                 <!-- 2행 2열 카드 시작 -->
                 <div class="row g-3 mb-3" style="flex: 1; display: flex; ">
                    <div class="col-md-4 col-lg-4"
                       style="width: 30%; margin-right: 1%; flex-grow: 1; ">
                       <div class="card h-100">
                          <div
                             class="card-header py-3 d-flex justify-content-between bg-transparent border-bottom-0">
                             <h6 class="mb-0 fw-bold">Card 3</h6>
                          </div>
                          <div class="card-body">
                             <div id="#"></div>
                          </div>
                       </div>
                    </div>
                 </div>

              </div> <!-- 2열 end -->
              <!-- 세로로 길게 배치된 card1 -->
              <div class="col-md-4 col-lg-4"
                 style="width: 20%; height: 100%; margin-right: 1%;">
                 <div class="card" style="height: 100%;">
                    <div
                       class="card-header py-3 d-flex justify-content-between bg-transparent border-bottom-0">
                       <h6 class="mb-0 fw-bold">Card 4</h6>
                    </div>
                    <div class="card-body">
                       <div id="#"></div>
                    </div>
                 </div>
              </div>
           </div>
           <!-- 1행 3열 카드 종료 -->
       </div>
   </div>
</div>