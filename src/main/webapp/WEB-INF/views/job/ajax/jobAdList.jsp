<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<style>
.slick-list {
	height: 230px;
}

.box-shadow {
	box-shadow: 6px 6px 6px 6px rgba(0.1, 0.1, 0.1, 0.1);
}
</style>
<div class="container">
	<div class="row slider">
		<c:set var="adList" value="${paging.dataList}" />
		<c:forEach items="${adList}" var="ad">
			<div class="col-md-4">
				<!-- 각 슬라이드에 4칼럼 크기를 할당 -->
				<div class="card boxSize box-shadow" style="margin-top:10px; overflow: hidden;">
					<a href="${ad.adDetail}"
						onclick="window.open('${ad.adDetail}', 'newWindow', 'width=1024,height=1024'); return false;">
						<img src="${ad.adImg}" class="card-img-top" alt="${ad.adTitle}"
						style="height: 100px; object-fit: contain;">
					</a>
					<div class="card-body">
						<strong class="poduct_tit">${ad.adTitle}</strong>
						<p class="card-text">${ad.adDesc}</p>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</div>
<script>
	$(document).ready(function() {
		$('.slider').slick({
			slidesToShow : 3, // 한 번에 보여줄 슬라이드 개수
			autoplay : true,
			autoplaySpeed : 2000,
			pauseOnHover : false,
			responsive : [ {
				breakpoint : 992, // 중간 크기에서는 2개씩
				settings : {
					slidesToShow : 2
				}
			}, {
				breakpoint : 768, // 작은 크기에서는 1개씩
				settings : {
					slidesToShow : 1
				}
			} ]

		});
	});
</script>
