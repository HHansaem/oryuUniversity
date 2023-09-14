<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Dongle:wght@700&display=swap" rel="stylesheet">
<style>
	.inner-style{
		width: 16%;
		height: 100%;
		display:flex;
		align-items: center;
		justify-content: center;
		border-right: 1px solid #dddddd;
		border-bottom: 1px solid #dddddd;
		font-weight: bold;
		font-size: 13px;
	}
	.inner-height{
		height: 9.09%;
	}
	.time-style{
		width: 6%;
		height: 100%;
		display:flex;
		align-items: center;
		justify-content: center;
		border: 1px solid #dddddd;
	}
	.custom-font{
/* 		font-family: 'Dongle', sans-serif;  */
/* 		margin-left: 90px; */
	    font-size: 1.3rem;
    	font-weight: bold;
	}
	.week-style{
		width: 16%;
		height: 100%;
		display:flex;
		align-items: center;
		justify-content: center;
		border: 1px solid #dddddd;
	}
	.remove-bottom{
		width: 16%;
		height: 100%;
		display:flex;
		align-items: end;
		justify-content: center;
		border-right: 1px solid #dddddd;
		border-left: 1px solid #dddddd;
		font-weight: bold;
		font-size: 13px;
	}
	.back{
		background: #e4e4e4;
	}
	
	.lecT-border{
		border-radius: 20px 20px 0 0;
		border: 1px solid #dddddd;
		background: aliceblue;
		font-weight: bold;
		height: 35px;
		margin-top: 20px;
	}
	.lecB-border{
		font-size: 14px;
		border-right: 1px solid #dddddd;
		border-left: 1px solid #dddddd;
		border-bottom: 1px solid #dddddd;
		border-radius: 0 0 20px 20px;
	    padding: 10px 4px 4px 15px;
	}
	.btn{
		margin: 0 5px 5px 0;
		padding: 0.5rem 1.2rem;
	}
	.p-ml{
		margin-left: 15px;
		margin-top: 5px;
	}
	.span-ml{
		margin-left: 10px;
	}
#timeTableImg{
 	    margin: -2px 10px 0px -52px;
    width: 5%;
}
#underLine{
	margin: 0px -154px 0px -49px;
    width: 202px;
    height: 130px;
}
.gradInfo {
    width: 44%;
    margin: 20px 0 27px -20px;
    font-family: 'Noto Sans KR', sans-serif;
}

.gradInfo-header {
	padding-right: 40px;
	margin: 20px 0 11px 40px;
	font-size: 14px;
	font-weight: bold;
}
</style>
<div class="card box-shadow d-flex m-4" style="min-height: 87%;">
	<div class="h-100">
	<div class="card-header" style="border-radius: 20px 20px 0 0; background-color:#154FA9; font-weight:bold; color:white; margin-bottom: 20px;">현재학기 강의</div>
		<div class="row" style="height:90%;">
			<div class="col-md-6 h-100" style="margin-left: 20px;">
				<div class="d-flex w-100 h-100 text-center flex-column" style="margin-top: -7px;">
					<div class="w-100 inner-height d-flex align-items-center justify-content-center mb-1">
						<span class="custom-font">
							<img id="timeTableImg" alt="notice" src="<%=request.getContextPath()%>/resources/images/file-icons/timeTableIcon.png">
<%-- 							<img id="underLine" alt="notice" src="<%=request.getContextPath()%>/resources/images/file-icons/underline.png"> --%>
							강의시간표</span>
					</div>
					<div class="w-100 d-flex align-items-center justify-content-center" style="height:5%;">
						<div class="time-style back"></div>
						<div class="week-style back">월</div>
						<div class="week-style back">화</div>
						<div class="week-style back">수</div>
						<div class="week-style back">목</div>
						<div class="week-style back">금</div>
					</div>
					<c:forEach begin="9" end="17" varStatus="cnt">
						<div class="w-100 d-flex inner-height align-items-center justify-content-center" id="lecSche">
							<c:choose>
								<c:when test="${cnt.index<12}">
									<div class="time-style">${cnt.index}:00</div>
								</c:when>
								<c:otherwise>
									<div class="time-style">${cnt.index+1}:00</div>
								</c:otherwise>
							</c:choose>
							<c:forEach items="${week}" var="dayofweek">
								<div class="inner-style" id="${dayofweek}${cnt.index-8}"></div>
							</c:forEach>
						</div>
					</c:forEach>
				</div>
			</div>
			<div class="card box-shadow gradInfo">
			<div class="gradInfo-header">
				<i class="mdi mdi-pencil-box" style="vertical-align: middle;font-size: 20px;margin-right: 8px;color: green;"></i>
				수업 컨텐츠 목록
				<hr style="border-color: black;">
			</div>
			<div class="p-2 col-md-6" style="max-width: 100%;">
				<div class="w-100 h-100" style="margin: -25px 0 0 28px;">
					<c:forEach items="${currentLec}" var="lecture" varStatus="lecCnt">
					<c:choose>
						<c:when test="${lecCnt.index == 0}">
						<div class="d-flex" style="width: 110%">
						</c:when>
						<c:when test="${lecCnt.index % 2 == 0 }">
							<div class="d-flex" style="width: 110%; margin-top: 10px; margin-bottom: 13px;">
						</c:when>
					</c:choose>
						<div class="col-md-5">
							<div class="d-flex justify-content-center align-items-center lecT-border">
								<span>${lecture.lecLectTitle}</span>
							</div>
							<div class="lecB-border">
								<p class="p-ml"><i class="mdi mdi-account" style="vertical-align: middle;"></i>
									<span class="span-ml">${lecture.prNm}</span></p>
								<p class="p-ml">강의시간:<span class="span-ml">
								<c:forEach items="${lecture.lectureScheduleList}" var="schedule">
									${schedule.scheCd}
								</c:forEach>
								</span></p>
								<p class="p-ml">강의실:<span class="span-ml">${lecture.lectureScheduleList[0].clasNm}</span></p>
								<div class="d-flex">
									<div class="col-sm-5">
										<span>학점:</span>
										<span style="margin-left:10px">${lecture.lecLectCred}학점</span>
									</div>
									<div class="col-sm-7 d-flex justify-content-end" style="padding:0;">
										<a class="btn btn-outline-secondary" href="${pageContext.request.contextPath}/lecture/noticeList.do?lecCd=${lecture.lecCd}"><span style="font-size: 1.2rem;">Go</span></a>
									</div>
								</div>
							</div>
						</div>
					<c:if test="${lecCnt.index+1 == currentLec.size() and currentLec.size() % 2 == 1}">
						<div class="col-md-5">
						</div>
					</c:if>	
					<c:if test="${lecCnt.index % 2 == 1 }">
						</div>
					</c:if>
					</c:forEach>

				</div>
			</div>
		</div>
	</div>
</div>
						
<script>
// 	var blackgroundColor = ["#dee8f6","#ffe9e9","#ffedda","#dcf2e9","#fff8cc","#eff9cc","#dceef2","#f2e8e8"];
	var blackgroundColor = ["#fcc3c1","#fddbab","#c5e7c2","#fbf1b4","#fbceb7","#a3e2d9","#ace8cf","#bcd999"];
	$(document).ready(function(){
		var colorCount = 0;
		<c:forEach items="${timeTable}" var="time">
			var schedule = ${time.scheCd};
			var title = '${time.lecLectTitle}';
			var nm = $(schedule).attr("id");
			var week = nm[0];
			var time = nm[1];
			var topTr = week+(time-1);
			var topTr2 = week+(time-2);
			$(schedule).addClass('${time.lecCd}');
			if($(lecSche).find("div.${time.lecCd}").text() != ""){
				var color = $(lecSche).find("div.${time.lecCd}").css("background-color");
				$(schedule).css("background-color", color);
				var topText = $("#"+topTr).text();
				var topText2 = $("#"+topTr2).text();
				if(title==topText){
					$("#"+topTr).removeClass("inner-style").addClass("remove-bottom");
				}else if(title==topText2){
					$("#"+topTr).removeClass("inner-style").addClass("remove-bottom");						
				}else{
					$(schedule).text(title);
				}
			}else{
				$(schedule).css("background-color", blackgroundColor[colorCount]);
				$(schedule).text(title);
				colorCount++;
			}
			
		</c:forEach>
	});
	
	$(".btn-outline-secondary").on("click",function(e){
		e.preventDefault();
		localStorage.removeItem('a');
		var aHref = $(this).attr("href");
		localStorage.setItem('a',aHref);
		window.location.href= aHref;
// 		setTimeout(function() {
//     	}, 100); 
	});
	
	
	
</script>