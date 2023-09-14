<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<link rel="stylesheet"
	href="path/to/mdi/css/materialdesignicons.min.css">
<style>
html {
	overflow: hidden;
}

html, body {
	display: block;
	width: 100%;
	height: 100%;
	margin: 0;
}
body {
    margin: 0;
}
.section {
 	width: 100%; 
 	height: 100%; 
	position: relative;
    width: 100vw;
/*     height: 100vh; */
	
}

#section1 {
	background-image:
		url("${pageContext.request.contextPath}/resources/images/collegeImage/공과대학배너.jpg");
	background-size: cover;
	background-repeat: no-repeat;
}
#section2 {
	background-image:
		url("${pageContext.request.contextPath}/resources/images/collegeImage/인문대학배너.png");
	background-size: cover;
	background-repeat: no-repeat;
}
#section3 {
	background-image:
		url("${pageContext.request.contextPath}/resources/images/collegeImage/생명과학대학배너.jpg");
	background-size: cover;
	background-repeat: no-repeat;
}
#section4 {
	background-image:
		url("${pageContext.request.contextPath}/resources/images/collegeImage/자연과학대학배너.jpg");
	background-size: cover;
	background-repeat: no-repeat;
}
#section5 {
	background-image:
		url("${pageContext.request.contextPath}/resources/images/collegeImage/예술대학배너.jpg");
	background-size: cover;
	background-repeat: no-repeat;
}
#section6 {
	background-image:
		url("${pageContext.request.contextPath}/resources/images/collegeImage/사범대학배너.jpg");
	background-size: cover;
	background-repeat: no-repeat;
}
#section7 {
	background-image:
		url("${pageContext.request.contextPath}/resources/images/collegeImage/사회과학대학배너.jpg");
	background-size: cover;
	background-repeat: no-repeat;
}
#section8 {
	background-image:
		url("${pageContext.request.contextPath}/resources/images/collegeImage/경상대학배너.jpg");
	background-size: cover;
	background-repeat: no-repeat;
}
#section9 {
	background-image:
		url("${pageContext.request.contextPath}/resources/images/collegeImage/약학대학배너.png");
	background-size: cover;
	background-repeat: no-repeat;
}
#section10 {
	background-image:
		url("${pageContext.request.contextPath}/resources/images/collegeImage/의과대학배너.jpg");
	background-size: cover;
	background-repeat: no-repeat;
}
.video-banner {
	position: relative;
	width: 100%;
	height: 10%; /* 필요에 따라 높이 조정 */
	overflow: hidden;
	margin: 0 auto; /* 컨테이너를 수평으로 가운데 정렬 */
}

video {
	width: 100%; /* 비디오 너비를 컨테이너에 맞게 조정 */
	height: auto; /* 비디오의 종횡비를 유지 */
	object-fit: contain; /* 비디오를 잘라내지 않고 컨테이너 내에 맞게 조정 */
	opacity: 0.9; /* 투명도 */
}

.changing-text {
	position: absolute;
	top: 90%;
	left: 50%;
	transform: translate(-50%, -50%);
	text-align: center;
	width: 100%;
	color: rgba(255, 255, 255, 1);
	font-size: 24px;
	opacity: 1;
}

.header {
	/* 	background-color: #F5F7FF; */
	display: flex;
	flex-direction: column;
	/* Change to column layout */
	align-items: center;
	/* Center horizontally */
	margin: 0px 0;
	border: 1px solid transparent;
}

.logo {
	border: 1px solid #e6e6e6;
	width: 100px;
	height: 100px;
	margin-bottom: 10px;
	/* Add margin at the bottom */
}

.card {
	width: calc(20% - 5px);
	display: inline-block;
	border: 1px solid #ccc;
	border-radius: 5px;
	padding: 10px;
	text-align: center;
}

.card img {
	transition: transform 0.8s ease-in-out;
	width: 200px;
	height: 200px;
	display: block;
	margin: 0 auto 10px;
}

.card button {
	background-color: #e0e0e0;
	color: black;
	border: 1px;
	border-radius: 5px;
	padding: 10px 20px;
	cursor: pointer;
}

.card-container {
	display: flex;
	flex-wrap: wrap;
	justify-content: center; /* 카드를 수평으로 가운데로 정렬 */
	gap: 20px; /* 카드 간격 추가 */
	transition: transform 0.8s ease-in-out;
}

.image-container:hover img {
	transform: scale(1.5); /* 마우스 호버 시 이미지 확대 */
}

.image-text {
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	font-size: 18px;
	color: white;
	text-align: center;
	display: none; /* 처음에 텍스트 숨김 */
}

.image-container:hover .image-text {
	display: block; /* 호버 시 텍스트 표시 */
}

.card .image-container .image-text {
	font-size: 300% !important;
	line-height: 1.5 !important;
	vertical-align: bottom;
}

.college-info {
	display: flex;
	flex-direction: column;
	align-items: center; /* Center horizontally */
}

.collegesidebar {
	position: fixed;
	top: 50%;
	right: 30px;
	transform: translateY(-50%);
	background-color: rgba(0, 130, 252, 0.486);
	color: white;
	padding: 10px;
	display: flex;
	flex-direction: column;
	align-items: center;
	border: 1px solid white; /* Add border */
	border-radius: 15px;
	border-color: white;
}

.collegesidebar a {
	color: black;
	text-decoration: none;
	display: rgba(255, 255, 255, 0.01);
	margin: 5px 0;
}

.image-container {
	position: relative;
	overflow: hidden;
}

.image-container img {
	display: block;
	width: 100%; /* Set width to fill the container */
	height: 200px; /* Set a fixed height for all images */
	object-fit: cover; /* Maintain aspect ratio and cover container */
}

.overlay-button {
	position: absolute;
	bottom: 1px; /* 버튼을 세로로 위치 조정 */
	left: 0;
	right: 0;
	margin: 0 auto; /* 버튼을 가로로 가운데 정렬 */
	padding: 0px 0; /* 필요에 따라서 패딩 조정 */
	background-color: rgb(125, 143, 255) !important;
	color: white;
	border: none;
	cursor: pointer;
	width: 100%; /* 버튼이 가로 길이를 채우도록 함 */
	box-sizing: border-box; /* 버튼의 패딩을 포함한 너비 계산 */
	text-align: center; /* 버튼의 텍스트를 중앙 정렬 */
}

.centered-text {
	display: block;
	text-align: center;
}

.colored-button:hover {
	background-color: rgba(123, 143, 255, 0.7) !important;
}

.collegesidebar a {
	color: black; /* Default link color */
	text-decoration: none; /* Remove underlines from links */
}

.collegesidebar a:hover {
	color: blue; /* Change color when hovered over */
}

.collegesidebar a:visited {
	color: black; /* Change color for visited links */
}

.collegesidebar a:focus, .collegesidebar a:active {
	color: red; /* Change color when focused or active */
}

.main-panel {
	backgound-color: white !important;
}

.modal {
	display: none;
	position: fixed;
	z-index: 1;
	left: 0;
	top: 0;
	width: 100%;
	height: 100%;
	overflow: auto;
	background-color: rgba(0, 0, 0, 0.5);
}

.modal-content {
	background-color: #fefefe;
	margin: 10% auto;
	padding: 20px;
	border: 1px solid #888;
	width: 60%;
}
.logo-overlay {
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    z-index: 1; /* Ensure the logo is on top */
    opacity: 0.3; /* 투명도 */
  }
</style>
</head>
<body>
	<div style="background-color: white; margin: 10px 10px;">

		<section id="section0">
<div class="card-header" style="border-radius: 20px 20px 0 0; background-color: #154FA9; font-weight: bold; color: white;"></div>
			<div class="video-banner">
				<video autoplay loop muted>
					<source
						src="${pageContext.request.contextPath}/resources/images/acBuDocDashBoardImages/단대영상.mp4"
						type="video/mp4">
					<!--       브라우저가 비디오 태그를 지원하지 않습니다. -->
				</video>
			<img class="logo-overlay" id="logoMianImage" src="${pageContext.request.contextPath}/resources/images/acBuDocDashBoardImages/오류대학교로고.png">
				<div class="changing-text" id="text-container">
					<div id="bottom-content">
						<p style="font-size: 50px;" id="text"></p>
					</div>
				</div>
			</div>
			<!-- 동영상 위의 자막 스크립트 코드 -->
			<script>
    const textElement = document.getElementById("text");
    const text1 = "꿈과 희망으로 가득한 대학.";
    const text2 = "이곳은 오류 대학교입니다.";
    let index = 0;
    let currentText = text1;
    let isFirstText = true;

    function typeText() {
        if (index < currentText.length) {
            textElement.innerHTML += currentText.charAt(index);
            index++;
            setTimeout(typeText, 250); // 타이핑 속도 조절 (밀리초)
        } else {
            if (currentText === text1) {
                setTimeout(() => {
                    currentText = text2;
                    index = 0;
                    textElement.innerHTML = ""; // 이전 텍스트 지우기
                    typeText();
                }, 3000); // 3초 후에 text2 출력
            } else if (currentText === text2 && isFirstText) {
                isFirstText = false;
                setTimeout(() => {
                    currentText = text1;
                    index = 0;
                    textElement.innerHTML = ""; // 이전 텍스트 지우기
                }, 3000); // 3초 후에 text1 출력
            } else {
                // 마지막 text2 출력 후 번갈아가기 중단
                setTimeout(() => {
                    index = 0;
                    textElement.innerHTML = "" // text2 표시
                }, 3000); // 계속해서 text2를 3초마다 표시
            } 
        } 
    } textElement.innerHTML = ""; 
    typeText();
</script>


		</section>

		<div class="collegesidebar">
			<!-- 섹션 리모컨 -->
			<a href="#section0"
				style="background-color: rgba(116, 193, 255, 0.05);"> <i
				class="mdi mdi-chevron-double-up"></i></a>
			<!-- 위로가기 -->
			<a href="#section1"
				style="background-color: rgba(116, 193, 255, 0.05);"> 공과대<i
				class="mdi mdi-ethernet-cable"></i></a> <a href="#section2"
				style="background-color: rgba(116, 193, 255, 0.05);"> 인문대<i
				class="mdi mdi-package"></i></a> <a href="#section3"
				style="background-color: rgba(116, 193, 255, 0.05);"> 생명과학대<i
				class="mdi mdi-flask-outline"></i></a> <a href="#section4"
				style="background-color: rgba(116, 193, 255, 0.05);"> 자연과학대<i
				class="mdi mdi-earth"></i></a> <a href="#section5"
				style="background-color: rgba(116, 193, 255, 0.05);"> 예술대<i
				class="mdi mdi-palette"></i></a> <a href="#section6"
				style="background-color: rgba(116, 193, 255, 0.05);"> 사범대<i
				class="mdi mdi-script"></i></a> <a href="#section7"
				style="background-color: rgba(116, 193, 255, 0.05);"> 사회과학대<i
				class="mdi mdi-human-handsup"></i></a> <a href="#section8"
				style="background-color: rgba(116, 193, 255, 0.05);"> 경상대<i
				class="mdi mdi-lan"></i></a> <a href="#section9"
				style="background-color: rgba(116, 193, 255, 0.05);"> 약학대<i
				class="mdi mdi-food-variant"></i></a> <a href="#section10"
				style="background-color: rgba(116, 193, 255, 0.05);"> 의과대<i
				class="mdi mdi-needle"></i></a> <a href="#section11"
				style="background-color: rgba(116, 193, 255, 0.05);"> <i
				class="mdi mdi-chevron-double-down"></i></a>
			<!-- 아래로가기 -->
		</div>
		<!-- 섹션 리모컨 끝 -->

		<br>
		<br>
		<br>

		<div class="border" style="border: 1px;">

			<section id="section1">
				<div class="header">
					<div class="college-info">
						<!-- 			<img class="logo" -->
						<%-- 				src="${pageContext.request.contextPath}/resources/images/acBuDocDashBoardImages/공과대학로고.png" --%>
						<!-- 				alt="공학대학 로고"> -->
						<br>
						<br>
						<div
							style="background: rgba(255, 255, 255, 0.5); border-radius: 10px;">
							<pre
								style="background: rgba(141, 143, 255, 0); border-radius: 10px;">
				<i class="centered-text" ><Strong style="font-size: 50px">공과대학</Strong> <br><br> College of Engineering</i>
			</pre>
							<div style="text-align: center;">
								<a href="#" id="print-link" style="align-items: center; color: black;">
								<i class="mdi mdi-printer">	자료출력 &nbsp; </i></a> 
								<a href="#" id="download-link" style="align-items: center; color: black;">
								<i class="mdi mdi-floppy"> 자료파일 &nbsp; </i></a> 
								<a href="#"	id="open-modal-link" style="align-items: center; color: black;">
								<i class="mdi mdi-message-video"> 소개영상</i></a>
							</div>
					<br>
						</div>
						<br> <br>
					</div>
				</div>
			</section>

			<div id="intro-video-modal" class="modal" style="top: 0;">
				<div class="modal-content" style="top: 0;">
					<video width="100%" controls style="top: 0;">
						<source
							src="${pageContext.request.contextPath}/resources/images/acBuDocDashBoardImages/오류대학교영상.mp4"
							type="video/mp4">
					</video>
					<br>
					<button id="close-modal-button" class="btn btn-danger">닫기</button>
				</div>
			</div>

			<br>
			<br>

			<div class="card-container">
				<div class="card">
					<div class="image-container">
						<img
							src="${pageContext.request.contextPath}/resources/images/acBuDocDashBoardImages/건축공학과이미지.jpg"
							alt="건축공학과이미지" style="height: 240px;">
						<div class="image-text"></div>
						<br> <a
							href="${pageContext.request.contextPath}/department/departmentPageView.do"
							class="overlay-button colored-button"
							style="height: 50px; line-height: 50px;">건축공학과</a>
					</div>
				</div>

				<div class="card">
					<div class="image-container">
						<img
							src="${pageContext.request.contextPath}/resources/images/acBuDocDashBoardImages/환경공학과이미지.jpg"
							alt="Image" style="height: 240px;">
						<div class="image-text"></div>
						<br> <a
							href="${pageContext.request.contextPath}/department/departmentPageView.do"
							class="overlay-button colored-button"
							style="height: 50px; line-height: 50px;">환경공학과</a>
					</div>
				</div>

				<div class="card">
					<div class="image-container">
						<img
							src="${pageContext.request.contextPath}/resources/images/acBuDocDashBoardImages/토목공학과이미지2.jpg"
							alt="Image" style="height: 240px;">
						<div class="image-text"></div>
						<br> <a
							href="${pageContext.request.contextPath}/department/departmentPageView.do"
							class="overlay-button colored-button"
							style="height: 50px; line-height: 50px;">토목공학과</a>
					</div>
				</div>

				<div class="card">
					<div class="image-container">
						<img
							src="${pageContext.request.contextPath}/resources/images/acBuDocDashBoardImages/전기공학과이미지2.jpg"
							alt="Image" style="height: 240px;">
						<div class="image-text"></div>
						<br> <a
							href="${pageContext.request.contextPath}/department/departmentPageView.do"
							class="overlay-button colored-button"
							style="height: 50px; line-height: 50px;">전기공학과</a>
					</div>
				</div>
				<div class="card">
					<div class="image-container">
						<img
							src="${pageContext.request.contextPath}/resources/images/acBuDocDashBoardImages/응용화학공학과이미지.jpg"
							alt="Image" style="height: 240px;"> <a
							href="${pageContext.request.contextPath}/department/departmentPageView.do"
							class="overlay-button colored-button"
							style="height: 50px; line-height: 50px;">응용화학공학과</a>
					</div>
				</div>
				<div class="card">
					<div class="image-container">
						<img
							src="${pageContext.request.contextPath}/resources/images/acBuDocDashBoardImages/전자공학과이미지.jpg"
							alt="Image" style="height: 240px;"> <a
							href="${pageContext.request.contextPath}/department/departmentPageView.do"
							class="overlay-button colored-button"
							style="height: 50px; line-height: 50px;">전자공학과</a>
					</div>
				</div>
				<div class="card">
					<div class="image-container">
						<img
							src="${pageContext.request.contextPath}/resources/images/acBuDocDashBoardImages/기계공학과이미지.jpg"
							alt="Image" style="height: 240px;"> <a
							href="${pageContext.request.contextPath}/department/departmentPageView.do"
							class="overlay-button colored-button"
							style="height: 50px; line-height: 50px;">기계공학과</a>
					</div>
				</div>
			</div>
			<br>
			<br>
		</div>


		<!-- 인문대학-->

		<div class="border" style="border: 1px;">

				<section id="section2">
			<div class="header">
				<br> <br>



				<div class="college-info">
					<!-- 			<img class="logo" -->
					<%-- 				src="${pageContext.request.contextPath}/resources/images/acBuDocDashBoardImages/인문대학로고.png" --%>
					<!-- 				alt="인문대학 로고"> -->
					<div
						style="background: rgba(255, 255, 255, 0.5); border-radius: 10px;">
						<pre
							style="background: rgba(141, 143, 255, 0); border-radius: 10px;">
				<i class="centered-text"><Strong style="font-size: 50px">인문대학</Strong> <br><br> College of Liberal Arts</i>
			</pre>
						<div style="text-align: center;">
							<a href="#" id="print-link" style="align-items: center; color: black;">
							<i class="mdi mdi-printer">	자료출력 &nbsp; </i></a> 
							<a href="#" id="download-link">
							<i class="mdi mdi-floppy" style="align-items: center; color: black;"> 자료파일 &nbsp; </i></a> 
							<a href="#"	id="open-modal-link">
							<i class="mdi mdi-message-video" style="align-items: center; color: black;">소개영상</i></a>
						</div>
						<br>
					</div>
				</div>
			</div>
			<br>
			<br>
				</section>
				<br><br>
			<div class="card-container">
				<div class="card">
					<div class="image-container">
						<img
							src="${pageContext.request.contextPath}/resources/images/acBuDocDashBoardImages/일어일문학과이미지.jpg"
							alt="Image"> <a
							href="${pageContext.request.contextPath}/department/departmentPageView.do"
							class="overlay-button colored-button"
							style="height: 50px; line-height: 50px;">일어일문학과</a>
					</div>
				</div>

				<div class="card">
					<div class="image-container">
						<img
							src="${pageContext.request.contextPath}/resources/images/acBuDocDashBoardImages/중어중문학과이미지.jpg"
							alt="Image"> <a
							href="${pageContext.request.contextPath}/department/departmentPageView.do"
							class="overlay-button colored-button"
							style="height: 50px; line-height: 50px;">중어중문학과</a>
					</div>
				</div>

				<div class="card">
					<div class="image-container">
						<img
							src="${pageContext.request.contextPath}/resources/images/acBuDocDashBoardImages/철학과이미지.jpg"
							alt="Image"> <a
							href="${pageContext.request.contextPath}/department/departmentPageView.do"
							class="overlay-button colored-button"
							style="height: 50px; line-height: 50px;">철학과</a>
					</div>
				</div>

				<div class="card">
					<div class="image-container">
						<img
							src="${pageContext.request.contextPath}/resources/images/acBuDocDashBoardImages/불어불문학과.jpg"
							alt="Image"> <a
							href="${pageContext.request.contextPath}/department/departmentPageView.do"
							class="overlay-button colored-button"
							style="height: 50px; line-height: 50px;">불어불문학과</a>
					</div>
				</div>
				<div class="card">
					<div class="image-container">
						<img
							src="${pageContext.request.contextPath}/resources/images/acBuDocDashBoardImages/사학과이미지.jpg"
							alt="Image"> <a
							href="${pageContext.request.contextPath}/department/departmentPageView.do"
							class="overlay-button colored-button"
							style="height: 50px; line-height: 50px;">사학과</a>
					</div>
				</div>
				<div class="card">
					<div class="image-container">
						<img
							src="${pageContext.request.contextPath}/resources/images/acBuDocDashBoardImages/영어영문학과이미지.jpg"
							alt="Image"> <a
							href="${pageContext.request.contextPath}/department/departmentPageView.do"
							class="overlay-button colored-button"
							style="height: 50px; line-height: 50px;">영어영문학과</a>
					</div>
				</div>
				<div class="card">
					<div class="image-container">
						<img
							src="${pageContext.request.contextPath}/resources/images/acBuDocDashBoardImages/국어국문학과이미지.jpg"
							alt="Image"> <a
							href="${pageContext.request.contextPath}/department/departmentPageView.do"
							class="overlay-button colored-button"
							style="height: 50px; line-height: 50px;">국어국문학과</a>
					</div>
				</div>
			</div>
			<br>
			<br>
		</div>


		<!-- 생명시스템과학대학 -->

		<div class="border" style="border: 1px;">

				<section id="section3">
				
			<div class="header">
				<br> <br>


				<div class="college-info">
					<!-- 			<img class="logo" -->
					<%-- 				src="${pageContext.request.contextPath}/resources/images/acBuDocDashBoardImages/생명시스템과학대학로고.png" --%>
					<!-- 				alt="생명시스템과학대학로고 로고"> -->
					<!-- 			<h1 class="college-name">생명과학대학</h1> -->
					<!-- 			<pre> -->
					<!-- 				<i class="centered-text">College of Life Science and Technology</i> -->
					<!-- 			</pre> -->

					<br>
					<br>
					<div
						style="background: rgba(255, 255, 255, 0.5); border-radius: 10px;">
						<pre
							style="background: rgba(141, 143, 255, 0); border-radius: 10px;">
            <i class="centered-text"><Strong style="font-size: 50px">생명과학대학</Strong> <br><br>College of Life Science and Technology</i>
         </pre>
						<div style="text-align: center;">
							<a href="#" id="print-link" style="align-items: center; color: black;">
							<i class="mdi mdi-printer">자료출력 &nbsp; </i></a> 
							<a href="#" id="download-link" style="align-items: center; color: black;">
							<i class="mdi mdi-floppy"> 자료파일 &nbsp; </i></a> 
							<a href="#"	id="open-modal-link" style="align-items: center; color: black;">
							<i class="mdi mdi-message-video">소개영상</i></a>
						</div>
						<br>
					</div>
				</div>
			</div>
			<br>
			<br>
				</section>
				<br><br>
			<div class="card-container">
				<div class="card">
					<div class="image-container">
						<img
							src="${pageContext.request.contextPath}/resources/images/acBuDocDashBoardImages/생물과학과이미지.jpg"
							alt="Image"> <a
							href="${pageContext.request.contextPath}/department/departmentPageView.do"
							class="overlay-button colored-button"
							style="height: 50px; line-height: 50px;">생물과학과</a>
					</div>
				</div>

				<div class="card">
					<div class="image-container">
						<img
							src="${pageContext.request.contextPath}/resources/images/acBuDocDashBoardImages/생명정보융합학과이미지.jpg"
							alt="Image"> <a
							href="${pageContext.request.contextPath}/department/departmentPageView.do"
							class="overlay-button colored-button"
							style="height: 50px; line-height: 50px;">생명정보융합학과</a>
					</div>
				</div>

				<div class="card">
					<div class="image-container">
						<img
							src="${pageContext.request.contextPath}/resources/images/acBuDocDashBoardImages/미생물분자생명과학과이미지.jpg"
							alt="Image"> <a
							href="${pageContext.request.contextPath}/department/departmentPageView.do"
							class="overlay-button colored-button"
							style="height: 50px; line-height: 50px;">미생물-분자생명과학과</a>
					</div>
				</div>
			</div>
			<br>
			<br>

			<div class="border" style="border: 1px;">
				<!-- 자연과학대학-->
					<section id="section4">
				<div class="header">
					<br> <br>


					<div class="college-info">
						<!-- 			<img class="logo" -->
						<%-- 				src="${pageContext.request.contextPath}/resources/images/acBuDocDashBoardImages/자연과학대학로고.png" --%>
						<!-- 				alt="자연과학대학 로고"> -->
						<!-- 			<h1 class="college-name">자연과학대학</h1> -->
						<!-- 			<pre> -->
						<!-- 				<i class="centered-text">College of Natural Sciences</i> -->
						<!-- 			</pre> -->
						<br>
						<br>
						<div
							style="background: rgba(255, 255, 255, 0.5); border-radius: 10px;">
							<pre
								style="background: rgba(141, 143, 255, 0); border-radius: 10px;">
            <i class="centered-text"><Strong style="font-size: 50px">자연과학대학</Strong> <br><br>College of Natural Sciences</i>
         </pre>
							<div style="text-align: center;">
								<a href="#" id="print-link" style="align-items: center; color: black;">
								<i class="mdi mdi-printer">	자료출력 &nbsp; </i></a> 
								<a href="#" id="download-link" style="align-items: center; color: black;">
								<i class="mdi mdi-floppy"> 자료파일 &nbsp; </i></a> 
								<a href="#"	id="open-modal-link" style="align-items: center; color: black;">
								<i class="mdi mdi-message-video">소개영상</i></a>
							</div>
							<br>
						</div>
					</div>
				</div>
				<br>
				<br>
					</section>
					<br><br>
				<div class="card-container">

					<div class="card">
						<div class="image-container">
							<img
								src="${pageContext.request.contextPath}/resources/images/acBuDocDashBoardImages/물리학과이미지.jpg"
								alt="Image"> <a
								href="${pageContext.request.contextPath}/department/departmentPageView.do"
								class="overlay-button colored-button"
								style="height: 50px; line-height: 50px;">물리학과</a>
						</div>
					</div>

					<div class="card">
						<div class="image-container">
							<img
								src="${pageContext.request.contextPath}/resources/images/acBuDocDashBoardImages/화학과이미지.jpg"
								alt="Image"> <a
								href="${pageContext.request.contextPath}/department/departmentPageView.do"
								class="overlay-button colored-button"
								style="height: 50px; line-height: 50px;">화학과</a>
						</div>
					</div>

					<div class="card">
						<div class="image-container">
							<img
								src="${pageContext.request.contextPath}/resources/images/acBuDocDashBoardImages/생물화학과이미지.jpg"
								alt="Image"> <a
								href="${pageContext.request.contextPath}/department/departmentPageView.do"
								class="overlay-button colored-button"
								style="height: 50px; line-height: 50px;">생물화학과</a>
						</div>
					</div>

					<div class="card">
						<div class="image-container">
							<img
								src="${pageContext.request.contextPath}/resources/images/acBuDocDashBoardImages/정보통계학과이미지.jpg"
								alt="Image"> <a
								href="${pageContext.request.contextPath}/department/departmentPageView.do"
								class="overlay-button colored-button"
								style="height: 50px; line-height: 50px;">정보통계학과</a>
						</div>
					</div>
					<div class="card">
						<div class="image-container">
							<img
								src="${pageContext.request.contextPath}/resources/images/acBuDocDashBoardImages/수학과이미지.jpg"
								alt="Image"> <a
								href="${pageContext.request.contextPath}/department/departmentPageView.do"
								class="overlay-button colored-button"
								style="height: 50px; line-height: 50px;">수학과</a>
						</div>
					</div>
				</div>
				<br> <br>
			</div>

			<div class="border" style="border: 1px;">
					<section id="section5">
				<div class="header">
					<br> <br>


					<div class="college-info">
						<!-- 			<img class="logo" -->
						<%-- 				src="${pageContext.request.contextPath}/resources/images/acBuDocDashBoardImages/예술대학로고.png" --%>
						<!-- 				alt="예술대학 로고"> -->
						<!-- 			<h1 class="college-name">예술대학</h1> -->
						<!-- 			<pre> -->
						<!-- 				<i class="centered-text">College of Arts</i> -->
						<!-- 			</pre> -->
						<br>
						<br>
						<div
							style="background: rgba(255, 255, 255, 0.5); border-radius: 10px;">
							<pre
								style="background: rgba(141, 143, 255, 0); border-radius: 10px;">
	            <i class="centered-text"><Strong
									style="font-size: 50px">예술대학</Strong> <br><br>College of Arts</i>
	         </pre>
							<div style="text-align: center;">
								<a href="#" id="print-link" style="align-items: center; color: black;">
								<i class="mdi mdi-printer">자료출력 &nbsp; </i></a> 
								<a href="#" id="download-link" style="align-items: center; color: black;">
								<i class="mdi mdi-floppy"> 자료파일 &nbsp; </i></a> 
								<a href="#"	id="open-modal-link" style="align-items: center; color: black;">
								<i class="mdi mdi-message-video">소개영상</i></a>
							</div>
							<br>
						</div>
					</div>
				</div>
				<br>
				<br>
					</section>
					<br><br>
				<div class="card-container">
					<div class="card">
						<div class="image-container">
							<img
								src="${pageContext.request.contextPath}/resources/images/acBuDocDashBoardImages/디자인창의학과이미지.jpg"
								alt="Image"> <a
								href="${pageContext.request.contextPath}/department/departmentPageView.do"
								class="overlay-button colored-button"
								style="height: 50px; line-height: 50px;">디지안창의학과</a>
						</div>
					</div>

					<div class="card">
						<div class="image-container">
							<img
								src="${pageContext.request.contextPath}/resources/images/acBuDocDashBoardImages/조소과이미지.jpg"
								alt="Image"> <a
								href="${pageContext.request.contextPath}/department/departmentPageView.do"
								class="overlay-button colored-button"
								style="height: 50px; line-height: 50px;">조소과</a>
						</div>
					</div>

					<div class="card">
						<div class="image-container">
							<img
								src="${pageContext.request.contextPath}/resources/images/acBuDocDashBoardImages/희화과이미지.jpg"
								alt="Image"> <a
								href="${pageContext.request.contextPath}/department/departmentPageView.do"
								class="overlay-button colored-button"
								style="height: 50px; line-height: 50px;">희화과</a>
						</div>
					</div>

					<div class="card">
						<div class="image-container">
							<img
								src="${pageContext.request.contextPath}/resources/images/acBuDocDashBoardImages/관현악과이미지.jpg"
								alt="Image"> <a
								href="${pageContext.request.contextPath}/department/departmentPageView.do"
								class="overlay-button colored-button"
								style="height: 50px; line-height: 50px;">관현악과</a>
						</div>
					</div>
					<div class="card">
						<div class="image-container">
							<img
								src="${pageContext.request.contextPath}/resources/images/acBuDocDashBoardImages/음악과이미지.jpg"
								alt="Image"> <a
								href="${pageContext.request.contextPath}/department/departmentPageView.do"
								class="overlay-button colored-button"
								style="height: 50px; line-height: 50px;">음악과</a>
						</div>
					</div>
				</div>
				<br> <br>
			</div>
			<div class="border" style="border: 1px;">
					<section id="section6">
				<div class="header">
					<br> <br>


					<div class="college-info">
						<!-- 			<img class="logo" -->
						<%-- 				src="${pageContext.request.contextPath}/resources/images/acBuDocDashBoardImages/사범대학로고.png" --%>
						<!-- 				alt="사범대학 로고"> -->
						<!-- 			<h1 class="college-name">사범대학</h1> -->
						<!-- 			<pre> -->
						<!-- 				<i class="centered-text">College of Education</i> -->
						<!-- 			</pre> -->
						<br>
						<br>
						<div
							style="background: rgba(255, 255, 255, 0.5); border-radius: 10px;">
							<pre
								style="background: rgba(141, 143, 255, 0); border-radius: 10px;">
	            <i class="centered-text"><Strong
									style="font-size: 50px">사범대학</Strong> <br><br>College of Education</i>
	         </pre>
							<div style="text-align: center;">
								<a href="#" id="print-link" style="align-items: center; color: black;">
								<i class="mdi mdi-printer">자료출력 &nbsp; </i></a> 
								<a href="#" id="download-link" style="align-items: center; color: black;">
								<i class="mdi mdi-floppy"> 자료파일 &nbsp; </i></a> 
								<a href="#"	id="open-modal-link" style="align-items: center; color: black;">
								<i class="mdi mdi-message-video"> 소개영상</i></a>
							</div>
							<br>
						</div>
					</div>
				</div>
				<br>
				<br>
					</section>
					<br><br>
				<div class="card-container">
					<div class="card">
						<div class="image-container">
							<img
								src="${pageContext.request.contextPath}/resources/images/acBuDocDashBoardImages/영어교육과이미지.jpg"
								alt="Image"> <a
								href="${pageContext.request.contextPath}/department/departmentPageView.do"
								class="overlay-button colored-button"
								style="height: 50px; line-height: 50px;">영어교육과</a>
						</div>
					</div>

					<div class="card">
						<div class="image-container">
							<img
								src="${pageContext.request.contextPath}/resources/images/acBuDocDashBoardImages/교육학과이미지.jpg"
								alt="Image"> <a
								href="${pageContext.request.contextPath}/department/departmentPageView.do"
								class="overlay-button colored-button"
								style="height: 50px; line-height: 50px;">교육학과</a>
						</div>
					</div>

					<div class="card">
						<div class="image-container">
							<img
								src="${pageContext.request.contextPath}/resources/images/acBuDocDashBoardImages/국어교육과이미지.jpg"
								alt="Image"> <a
								href="${pageContext.request.contextPath}/department/departmentPageView.do"
								class="overlay-button colored-button"
								style="height: 50px; line-height: 50px;">국어교육과</a>
						</div>
					</div>
				</div>
				<br> <br>
			</div>
			<div class="border" style="border: 1px;">
					<section id="section7">
				<div class="header">
					<br> <br>

					<!-- 		<div class="college-info"> -->
					<!-- 			<img class="logo" -->
					<%-- 				src="${pageContext.request.contextPath}/resources/images/acBuDocDashBoardImages/사회과학대로고.png" --%>
					<!-- 				alt="사회과학대 로고"> -->
					<!-- 			<h1 class="college-name">사회과학대학</h1> -->
					<!-- 			<pre> -->
					<!-- 				<i class="centered-text">College of Social Sciences</i> -->
					<!-- 			</pre> -->
					<br>
					<br>
					<div
						style="background: rgba(255, 255, 255, 0.5); border-radius: 10px;">
						<pre
							style="background: rgba(141, 143, 255, 0); border-radius: 10px;">
	            <i class="centered-text"><Strong
								style="font-size: 50px">사회과학대학</Strong> <br><br>College of Social Sciences</i>
	         </pre>
						<div style="text-align: center;">
							<a href="#" id="print-link" style="align-items: center; color: black;">
							<i class="mdi mdi-printer">자료출력 &nbsp; </i></a> 
							<a href="#" id="download-link" style="align-items: center; color: black;">
							<i class="mdi mdi-floppy"> 자료파일 &nbsp; </i></a> 
							<a href="#"	id="open-modal-link" style="align-items: center; color: black;">
							<i class="mdi mdi-message-video">소개영상</i></a>
						</div>
						<br>
					</div>
				</div>
				<br>
				<br>
					</section>
				<br><br>
			<div class="card-container">
				<div class="card">
					<div class="image-container">
						<img
							src="${pageContext.request.contextPath}/resources/images/acBuDocDashBoardImages/문헌정보학과.jpg"
							alt="Image"> <a
							href="${pageContext.request.contextPath}/department/departmentPageView.do"
							class="overlay-button colored-button"
							style="height: 50px; line-height: 50px;">문헌정보학과</a>
					</div>
				</div>

				<div class="card">
					<div class="image-container">
						<img
							src="${pageContext.request.contextPath}/resources/images/acBuDocDashBoardImages/사회학과이미지.png"
							alt="Image"> <a
							href="${pageContext.request.contextPath}/department/departmentPageView.do"
							class="overlay-button colored-button"
							style="height: 50px; line-height: 50px;">사회학과</a>
					</div>
				</div>

				<div class="card">
					<div class="image-container">
						<img
							src="${pageContext.request.contextPath}/resources/images/acBuDocDashBoardImages/심리학과이미지.jpg"
							alt="Image"> <a
							href="${pageContext.request.contextPath}/department/departmentPageView.do"
							class="overlay-button colored-button"
							style="height: 50px; line-height: 50px;">심리학과</a>
					</div>
				</div>

				<div class="card">
					<div class="image-container">
						<img
							src="${pageContext.request.contextPath}/resources/images/acBuDocDashBoardImages/행정학과이미지.png"
							alt="Image"> <a
							href="${pageContext.request.contextPath}/department/departmentPageView.do"
							class="overlay-button colored-button"
							style="height: 50px; line-height: 50px;">행정학과</a>
					</div>
				</div>
				<div class="card">
					<div class="image-container">
						<img
							src="${pageContext.request.contextPath}/resources/images/acBuDocDashBoardImages/정치외교학과.jpg"
							alt="Image"> <a
							href="${pageContext.request.contextPath}/department/departmentPageView.do"
							class="overlay-button colored-button"
							style="height: 50px; line-height: 50px;">정치외교학과</a>
					</div>
				</div>
			</div>
			<br>
			<br>
		</div>
		</div>
		<div class="border" style="border: 1px;">
				<section id="section8">
			<div class="header">
				<br> <br>


				<div class="college-info">
					<!-- 			<img class="logo" -->
					<%-- 				src="${pageContext.request.contextPath}/resources/images/acBuDocDashBoardImages/경상대학로고.png" --%>
					<!-- 				alt="경상대학 로고"> -->
					<!-- 			<h1 class="college-name">경상대학</h1> -->
					<!-- 			<pre> -->
					<!-- 				<i class="centered-text">College of Business and Commerce</i> -->
					<!-- 			</pre> -->
					<br>
					<br>
					<div
						style="background: rgba(255, 255, 255, 0.5); border-radius: 10px;">
						<pre
							style="background: rgba(141, 143, 255, 0); border-radius: 10px;">
		            <i class="centered-text"><Strong
								style="font-size: 50px">경상대학</Strong> <br><br>College of Business and Commerce</i>
		         </pre>
						<div style="text-align: center;"> 
							<a href="#" id="print-link" style="align-items: center; color: black;">
							<i class="mdi mdi-printer">	자료출력 &nbsp; </i></a> 
							<a href="#" id="download-link" style="align-items: center; color: black;">
							<i class="mdi mdi-floppy"> 자료파일 &nbsp; </i></a> 
							<a href="#"	id="open-modal-link" style="align-items: center; color: black;">
							<i class="mdi mdi-message-video">소개영상</i></a>
						</div>
						<br>
					</div>
				</div>
				<br>
				<br>
			</div>
			<br>
			<br>
				</section>
				<br><br>
			<div class="card-container">
				<div class="card">
					<div class="image-container">
						<img
							src="${pageContext.request.contextPath}/resources/images/acBuDocDashBoardImages/무역학과이미지.jpg"
							alt="Image"> <a
							href="${pageContext.request.contextPath}/department/departmentPageView.do"
							class="overlay-button colored-button"
							style="height: 50px; line-height: 50px;">무역학과</a>
					</div>
				</div>

				<div class="card">
					<div class="image-container">
						<img
							src="${pageContext.request.contextPath}/resources/images/acBuDocDashBoardImages/경영학과이미지.jpg"
							alt="Image"> <a
							href="${pageContext.request.contextPath}/department/departmentPageView.do"
							class="overlay-button colored-button"
							style="height: 50px; line-height: 50px;">경영학과</a>
					</div>
				</div>
				<div class="card">
					<div class="image-container">
						<img
							src="${pageContext.request.contextPath}/resources/images/acBuDocDashBoardImages/경제학과이미지.jpg"
							alt="Image"> <a
							href="${pageContext.request.contextPath}/department/departmentPageView.do"
							class="overlay-button colored-button"
							style="height: 50px; line-height: 50px;">경제학과</a>
					</div>
				</div>
			</div>
			<br>
			<br>
		</div>
		<div class="border" style="border: 1px;">
				<section id="section9">
			<div class="header">
				<br> <br>


				<div class="college-info">
					<!-- 			<img class="logo" -->
					<%-- 				src="${pageContext.request.contextPath}/resources/images/acBuDocDashBoardImages/약학대학로고.jpg" --%>
					<!-- 				alt="약학대학 로고"> -->
					<!-- 			<h1 class="college-name">약학대학</h1> -->
					<!-- 			<pre> -->
					<!-- 				<i class="centered-text">College of Pharmacy</i> -->
					<!-- 			</pre> -->
					<br>
					<br>
					<div
						style="background: rgba(255, 255, 255, 0.5); border-radius: 10px;">
						<pre
							style="background: rgba(141, 143, 255, 0); border-radius: 10px;">
	            <i class="centered-text"><Strong
								style="font-size: 50px">약학대학</Strong> <br><br>College of Pharmacy</i>
	         </pre>
						<div style="text-align: center;">
							<a href="#" id="print-link" style="align-items: center; color: black;">
							<i class="mdi mdi-printer">	자료출력 &nbsp; </i></a> 
							<a href="#" id="download-link" style="align-items: center; color: black;">
							<i class="mdi mdi-floppy"> 자료파일 &nbsp; </i></a> 
							<a href="#" id="open-modal-link" style="align-items: center; color: black;">
							<i class="mdi mdi-message-video"> 소개영상</i></a>
						</div>
						<br>
					</div>
				</div>
				<br>
				<br>
			</div>
			<br>
			<br>
				</section>
				<br><br>
			<div class="card-container">
				<div class="card">
					<div class="image-container">
						<img
							src="${pageContext.request.contextPath}/resources/images/acBuDocDashBoardImages/약학과이미지.jpg"
							alt="Image"> <a
							href="${pageContext.request.contextPath}/department/departmentPageView.do"
							class="overlay-button colored-button"
							style="height: 50px; line-height: 50px;">약학과</a>
					</div>
				</div>
			</div>
			<br>
			<br>
		</div>
		<div class="border" style="border: 1px;">
				<section id="section10">
			<div class="header">


				<div class="college-info">
					<!-- 			<img class="logo" -->
					<%-- 				src="${pageContext.request.contextPath}/resources/images/acBuDocDashBoardImages/의과대학로고.png" --%>
					<!-- 				alt="의과대학 로고"> -->
					<!-- 			<h1 class="college-name">의과대학</h1> -->
					<!-- 			<pre> -->
					<!-- 				<i class="centered-text">College of Medicine</i> -->
					<!-- 			</pre> -->
					<br>
					<br>
					<div
						style="background: rgba(255, 255, 255, 0.5); border-radius: 10px;">
						<pre
							style="background: rgba(141, 143, 255, 0); border-radius: 10px;">
	            <i class="centered-text"><Strong
								style="font-size: 50px">의과대학</Strong> <br><br>College of Medicine</i>
	         </pre>
						<div style="text-align: center;">
							<a href="#" id="print-link" style="align-items: center; color: black;">
							<i class="mdi mdi-printer">	자료출력 &nbsp; </i></a> 
							<a href="#" id="download-link" style="align-items: center; color: black;">
							<i class="mdi mdi-floppy"> 자료파일 &nbsp; </i></a> 
							<a href="#"	id="open-modal-link" style="align-items: center; color: black;">
							<i class="mdi mdi-message-video">소개영상</i></a>
						</div>
						<br>
					</div>
				</div>
			</div>
			<br>
			<br>
				</section>
				<br><br>
			<div class="card-container">
				<div class="card">
					<div class="image-container">
						<img
							src="${pageContext.request.contextPath}/resources/images/acBuDocDashBoardImages/의예과이미지.png"
							alt="Image"> <a
							href="${pageContext.request.contextPath}/department/departmentPageView.do"
							class="overlay-button colored-button"
							style="height: 50px; line-height: 50px;">의예과</a>
					</div>
				</div>
			</div>
			<br><br><br><br><br><br><br><br><br><br><br><br>
		</div>
	</div>
	<section id="section11">
	</section>

	<script>
        // Add smooth scrolling behavior to anchor links
document.querySelectorAll('a[href^="#"]').forEach(anchor => {
    anchor.addEventListener('click', function (e) {
        e.preventDefault();

        document.querySelector(this.getAttribute('href')).scrollIntoView({
            behavior: 'smooth'
        });
    });
});

    </script>

	<!-- pdf print 스크립트 -->
	<script> 
        function printPDF(pdfPath) {
            var pdfWindow = window.open(pdfPath, "_blank");
            pdfWindow.onload = function() {
                pdfWindow.print();
            };
        }

        var printLink = document.getElementById("print-link");
        printLink.addEventListener("click", function(event) {
            event.preventDefault();
            printPDF("${pageContext.request.contextPath}/resources/images/acBuDocDashBoardImages/공과대학PDF.pdf");
        });
    </script>
	<!-- pdf print 스크립트 -->

	<!-- pdf 파일 다운로드 스크립트 -->

	<script>
        var downloadLink = document.getElementById("download-link");
        downloadLink.addEventListener("click", function(event) {
            event.preventDefault();
            downloadPDF("${pageContext.request.contextPath}/resources/images/acBuDocDashBoardImages/공과대학PDF.pdf");
        });

        function downloadPDF(pdfPath) {
            var link = document.createElement("a");
            link.href = pdfPath;
            link.target = "_blank";
            link.download = "공과대학안내"; // You can change the downloaded file name here
            link.click();
        }
    </script>
	<!-- 모달 스크립트 코드 -->
	<script>
        var openModalLink = document.getElementById("open-modal-link");
        var introVideoModal = document.getElementById("intro-video-modal");
        var closeModalButton = document.getElementById("close-modal-button");

        openModalLink.addEventListener("click", function(event) {
            event.preventDefault();
            introVideoModal.style.display = "block";
        });

        closeModalButton.addEventListener("click", function() {
            introVideoModal.style.display = "none";
        });
    </script>
    
    

</body>





