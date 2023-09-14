<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<script
	src="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
<link rel="stylesheet"
	href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css" />
<link rel="stylesheet"
	href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick-theme.css" />
<style>
.gradInfo {
	margin-top: 3px;
	background-color: rgba(0, 0, 0, 0.03);
	margin: 20px;
	padding-right: 40px;
	font-family: 'Noto Sans KR', sans-serif;
}

.gradInfo-header {
	margin: 20px 0 11px 40px;
	font-size: 14px;
	font-weight: bold;
}

.gradInfo-body {
	margin: -13px 11px 20px 40px;
	font-size: 12px;
}

.span-title {
	font-weight: bold;
	color: #248AFD;
	margin-right: 12px;
}

select {
	padding: 0; /* 위 아래 여백을 없애는 스타일 */
	display: inline-block; /* 셀렉트 박스를 인라인 블록 요소로 표시하여 텍스트 흐름을 방해하지 않도록 함 */
	vertical-align: middle; /* 수직 정렬을 가운데로 설정 */
}

button {
	margin-left: 10px;
}

.row {
	margin: 10px;
}

th {
	text-align: center;
}

td {
	text-align: left;
}

body {
	justify-content: center; /* 가로 중앙 정렬 */
}

/* .custom-card { */
/* 	border-radius: 15px; */
/* 	width: 1200px; */
/* 	margin: 0 auto; */
/* 	margin-top: 20px; */
/* 	background-color: white; */
/* } */
.content-wrapper {
	flex-direction: column;
	margin: 0 auto;
}

#adList, #jobList {
	width: 100%; /* 가로 길이 100%로 설정 */
}
</style>
<div class="card box-shadow d-flex m-4" style="min-height: 87%;">
	<div class="h-100">
		<div class="custom-card">
			<div class="card-header"
				style="border-radius: 20px 20px 0 0; background-color: #154FA9; font-weight: bold; color: white;">강의관리</div>
			<!-- 광고 목록 내용 -->
			<div class="row"></div>
			<div class="row"></div>
			<div id="adList"
				class="col-lg-12 stretch-card justify-content-center"></div>
			<div id="searchUI" class="row justify-content-center">
				<div class="col-auto">
					<form:select path="simpleCondition.searchType" class="form-select">
						<form:option value="" label="전체" />
						<form:option value="company" label="회사명" />
						<form:option value="location" label="지역" />
					</form:select>
				</div>
				<div class="col-auto">
					<form:input path="simpleCondition.searchWord" class="form-control" />
				</div>
				<div class="col-auto">
					<input type="button" value="검색" id="searchBtn"
						class="btn btn-success" />
				</div>
			</div>
			<div id="jobList" class="col-lg-12 stretch-card">
				<div class="card-body">
					<!-- 공고 목록 내용 -->
				</div>
			</div>
		</div>
	</div>
	<div class="position-absolute bottom-0 end-0 translate-middle-y"
		style="margin-right: 100px">
		<a
			href="https://saramin.co.kr/zf_user/event/check-in-promo?inner_source=saramin&amp;inner_medium=banner&amp;inner_campaign=pc_wigs&amp;inner_term=check-in&amp;_ga=2.235592196.401562868.1693719892-2134287400.1689939961"
			target="_blank" class="app-setup-btn"> <img
			src="https://www.saraminbanner.co.kr/mobile_sv/rbc/2023/08/rziiwa_flb2-2so1qt_3PC.jpg"
			alt="입사지원하고 호캉스 체크인" id="rightwing_banner_img">
		</a>
	</div>
	<div class="position-absolute top-50 end-0 translate-middle-y"
		style="margin-right: 100px">
		<a  target="_blank"
			href="https://googleads.g.doubleclick.net/pcs/click?xai=AKAOjssQqEHjpc_lI03sEzWaOw2QKDpa1gPLCXLswgtEiVHe1T3ogb9qSG4H4TciLOEi4TXCJxtlQGNbTtgmfgRViYDIWVzxj-HTgEUN4k96ZW9J39GqRLeiVIDRIlBrWgSntoZkXTOd5EViKO5ZTwzjGB3xh5KzgPdiIboTMd_6Vq3GK7c_jM1_ANzR9-gNRDMCblxqDKfc9erj3TAGNgsnMl1t5_AuzMb0t5qy-kL30XmLW1hZFMc-CU3wreuQLjlRSL1JYzeD3mnRNvDY05lx8U05-ZzjrjjXAO2kOMEbbQLXmovF85Shva5jJ5MeakvOWzOqEYKI-ucm&amp;sai=AMfl-YRMurph21wOmAAagIv4q3dXj-DFuC2F1jzNmFdSTG5qqKO_5aT5pK4ssDPxuHLM9UfnpFzOuNOCXKA6yuITsPo5_aEfm8cDpZf6eHO1MPp3bWktZey-HRHy86mRwdY1_dkEQTHe&amp;sig=Cg0ArKJSzPCMCaG6uQB4&amp;fbs_aeid=[gw_fbsaeid]&amp;adurl=https://www.saramin.co.kr/zf_user/jobs/theme/mss-incheon&amp;nm=4&amp;nx=83&amp;ny=-418&amp;mb=2"><img
			src="https://tpc.googlesyndication.com/simgad/1178940415673725092"
			border="0" width="120" height="600" alt="" class="img_ad"></a>
	</div>
</div>
<form:form id="searchForm" modelAttribute="simpleCondition" method="get">
	<form:hidden path="searchType" />
	<form:hidden path="searchWord" />
	<input type="hidden" name="page" value="1">
</form:form>
<script>
<!-- pagination -->
	function fn_paging(page) {
		searchForm.page.value = page;
		fetchJob(page);
	}
	$(searchBtn).on("click", function(event) {
		$(searchUI).find(":input[name]").each(function(idx, input) {
			let name = input.name;
			let value = $(input).val();
			$(searchForm).find(`[name=\${name}]`).val(value);
			fetchJob();
		});
	})
	$(document).ready(function() {
		var page = '1';
		fetchAd();
		fetchJob(page);
	});

	// 광고 목록을 불러오는 펑션
	function fetchAd() {
		$.ajax({
			url : "/oryuUniversity/job/jobAdList.do",
			method : "get",
			dataType : "html",
			success : function(data) {
				$('#adList').html(data);
			},
			error : function(jqXHR, status, error) {
				console.log(jqXHR);
				console.log(status);
				console.log(error);
			}
		});
	}

	// 공고 목록을 불러오는 펑션
	function fetchJob(page) {
		$(searchForm).find("input[name='page']").val(page);
		var data = $(searchForm).serializeArray();
		$.ajax({
			url : "/oryuUniversity/job/jobAdList2.do",
			method : "get",
			data : data,
			dataType : "html",
			success : function(data) {
				$('#jobList').html(data);
			},
			error : function(jqXHR, status, error) {
				console.log(jqXHR);
				console.log(status);
				console.log(error);
			}
		});
	}
</script>
