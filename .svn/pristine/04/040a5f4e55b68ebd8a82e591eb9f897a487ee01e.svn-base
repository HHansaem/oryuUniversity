<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!-- Google Charts 라이브러리 불러오기 -->
<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
<style>
.gradInfo {
	margin-top: 3px;
	background-color: rgba(0, 0, 0, 0.03);
	margin: 20px;
	padding-right: 40px;
	font-family: 'Noto Sans KR', sans-serif;
}
.gradInfo {
	margin-top: 3px;
	background-color: rgba(0, 0, 0, 0.03);
	margin: 20px;
	padding-right: 40px;
	font-family: 'Noto Sans KR', sans-serif;
}

.gradInfo-header {
	padding-right: 40px;
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
	text-align: center;
}
</style>
<!-- 그래프를 표시할 요소 -->
<div class="card box-shadow d-flex m-4" style="min-height: 87%;">
	<div class="h-100">
		<div class="custom-card">
			<div class="card-header"
				style="border-radius: 20px 20px 0 0; background-color: #154FA9; font-weight: bold; color: white;">취업현황</div>
			<div class="card-body">
				<div class="card gradInfo">
					<div class="gradInfo-header">
						<i class="mdi mdi-check-circle" style="color: green;"></i> 취업 현황
						조회(차트)
						<hr style="border-color: black;">
					</div>
					<div class="gradInfo-body">
						<span class="span-title">검색자</span>|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						졸업연도, 단대, 학과 를 선택하여 취업 현황 차트를 조회하세요.(원형차트,지도차트에 동시 적용됩니다.)
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12">
					<div class="row">
						<div class="col-2">
							<select id="selectYear" name="year" value="" class="form-select">
								<option value=>전체</option>
								<option value="2019">2019</option>
								<option value="2020">2020</option>
								<option value="2021">2021</option>
								<option value="2022">2022</option>
							</select>
						</div>
						<div class="col-2">
							<select id="selectCollege" name="college" class="form-select" id="selectCollege">
								<option value>단대</option>
								<c:forEach items="${collegeList }" var="college">
									<option value="${college.colgeCd }">${college.colgeNm }</option>
								</c:forEach>
							</select>
						</div>
						<div class="col-2">
							<select name="dtCd" class="form-select" id="selectDepartment">
								<option value>학과</option>
								<c:forEach items="${departmentList }" var="department">
									<option value="${department.dtCd }"
										class="${department.colgeCd }">${department.dtNm }</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="row">
						<div class="col-6">
							<div class="card box-shadow gradInfo2">
								<div class="gradInfo-header">
									<i class="mdi mdi-chart-line" style="color: green;"></i>
									취업률/미취업률
									<hr style="border-color: black;">
									<div id="pieChart" style="margin-left: 70px;"></div>
								</div>
							</div>
						</div>
						<div class="col-6">
							<div class="card box-shadow gradInfo2">
								<div class="gradInfo-header">
									<i class="mdi mdi-chart-line" style="color: green;"></i> 지역별
									취업인원
									<hr style="border-color: black;">
									<div id="mapChart" style="margin: 0px 0 0 -7px;"></div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<script>
	let $dtCd2 = $('[name="dtCd"]');
	$('[name="college"]').on("change", function(event) {
		let colgeCd = $(this).val();
		if (colgeCd) {
			$dtCd2.find("option").hide();
			$dtCd2.find(`option:first`).show();
			$dtCd2.find(`option.\${colgeCd}`).show();
		} else {
			$dtCd2.find("option").show();
		}
	}).trigger("change");
</script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#selectYear, #selectCollege, #selectDepartment").on("change", function() {
			drawCircle();
			drawMap();
		});
	})

	google.charts.load("current", {
		packages : [ "corechart" ]
	});
	google.charts.setOnLoadCallback(drawCircle);
	google.charts.load('current', {
		'packages' : [ 'geochart' ]
	});
	google.charts.setOnLoadCallback(drawMap);

	function drawCircle() {
		const selectedYear = $("#selectYear").val();
		const selectCollege = $("#selectCollege").val();
		const selectedDepartment = $("#selectDepartment").val();
		let info;
		$.ajax({
			url : "/oryuUniversity/job/circle.do",
			method : "get",
			dataType : "json",
			data : {
				year : selectedYear,
				colg : selectCollege,
				dept : selectedDepartment
			},
			success : function(info) {
				console.log(info);
				console.log(info.circle.emp);
				var employedValue = parseFloat(info.circle.employed);
				var unEmployedValue = parseFloat(info.circle.unEmployed);

				var data = new google.visualization.DataTable();
				data.addColumn('string', 'Topping');
				data.addColumn('number', 'Slices');

				data.addRows([ [ '취업률', employedValue ],
						[ '미취업률', unEmployedValue ] ]);

				var options = {
					'title' : '취업률',
					backgroundColor: 'transparent',
					slices: {
                        0: {color: '#FFC952'},
                        1: {color: '#FF7473'}
                     },
					'height':390
				};

				var chart = new google.visualization.PieChart(document
						.getElementById('pieChart'));
				chart.draw(data, options);
			},
			error : function(jqXHR, status, error) {
				console.log(jqXHR);
				console.log(status);
				console.log(error);
			},
		});
	}

	function drawMap() {

		const selectedYear = $("#selectYear").val();
		const selectCollege = $("#selectCollege").val();
		const selectedDepartment = $("#selectDepartment").val();

		$.ajax({
			url : "/oryuUniversity/job/map.do",
			method : "get",
			dataType : "json",
			data : {
				year : selectedYear,
				colg : selectCollege,
				dept : selectedDepartment
			},
			success : function(data) {
				var employedArray = [];

				for (var i = 0; i < data.loc.length; i++) {
					var item = data.loc[i];
					employedArray.push(item.employed);
				}
				var data = google.visualization.arrayToDataTable([
						[ 'Region', 'Popularity' ],
						[ '서울', parseInt(employedArray[5]) ], // 인덱스 5
						[ '강원도', parseInt(employedArray[0]) ], // 인덱스 0
						[ '경기도', parseInt(employedArray[1]) ], // 인덱스 1
						[ '충청남도', parseInt(employedArray[8]) ], // 인덱스 8 
						[ '충청북도', parseInt(employedArray[9]) ], // 인덱스 9
						[ '경상남도', parseInt(employedArray[2]) ], // 인덱스 2
						[ '경상북도', parseInt(employedArray[3]) ], // 인덱스 3
						[ '전라남도', parseInt(employedArray[6]) ], // 인덱스 6
						[ '전라북도', parseInt(employedArray[7]) ], // 인덱스 7
				]);

				var options = {
					region : 'KR', // 한국 지도로 설정
					displayMode : 'regions',
					resolution : 'provinces', // 한국의 지역을 표시
					colorAxis : {
						colors : [ 'yellow', 'red' ]
					}
				};

				var chart = new google.visualization.GeoChart(document
						.getElementById('mapChart'));

				chart.draw(data, options);

			},
			error : function(jqXHR, status, error) {
				console.log(jqXHR);
				console.log(status);
				console.log(error);
			},
		});

	};
</script>