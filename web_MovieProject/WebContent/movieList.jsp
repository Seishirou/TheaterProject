<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta charset="EUC-KR">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/w3.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/fonts/css?family=Raleway">
	
<title>Movie List</title>
<style>
body, h1, h5 {
	font-family: "Raleway", sans-serif
}

body, html {
	height: 100%
}

.bgimg {
	background-image:
		url('${pageContext.request.contextPath}/img/hollywood.jpg');
	min-height: 100%;
	background-position: center;
	background-size: cover;
}
</style>

<body>
	<div class="bgimg w3-display-container w3-text-white">
		<div class="w3-display-middle w3-jumbo">
			<p>
				<a href="index.jsp" style="text-decoration: none">Movie Gallery</a>
			</p>
		</div>
		<c:if test="${not empty sessionScope.mem.name}">
			<div
				class="w3-display-topright w3-text-black w3-large w3-margin-right w3-padding-16">
				<b>${sessionScope.mem.name}</b>
				<button
					onclick="location.href='MemberServ?command=logout&id=${sessionScope.mem.id}'"
					class="w3-grey w3-border w3-border-white w3-hover-blue-grey w3-medium w3-text-white w3-round-large">로그아웃</button>
			</div>
		</c:if>
		<div class="w3-display-middle">
			<div class="w3-modal-content w3-animate-zoom">
				<div class="w3-container w3-black">
					<span onclick="location.href='loginSuccess.jsp'"
						class="w3-button w3-display-topright w3-large">x</span>
					<div style="width: 100%; height: 670px; overflow: auto;">
						<center>
							<h3 align="center">영화 목록</h3>
							<table align="center" border="1" width="90%">
								<tr>
									<th width="25%">영화 제목</th>
									<th width="10%">장르</th>
									<th width="10%">국가</th>
									<th width="10%">감독</th>
									<th width="10%">상영 시간</th>
									<c:if test="${sessionScope.FOR_RESERVE}">
										<th width="10%">선택</th>
									</c:if>
								</tr>
								<c:choose>
									<c:when test="${not empty list}">
										<c:forEach items="${list}" var="data">
											<tr align="center">
												<td>${data.movieNm}</td>
												<td>${data.repGenreNm}</td>
												<td>${data.repNationNm}</td>
												<td>${data.director}</td>
												<td><fmt:formatNumber value="${data.movieRuntime}"
														groupingUsed="true" />분</td>
												<c:if test="${sessionScope.FOR_RESERVE}">
													<td><input type="button" value="선택"
														class="w3-btn w3-grey w3-border w3-border-white w3-hover-blue-grey w3-medium w3-text-white"
														onclick="location.href='${pageContext.request.contextPath}/TheaterServ?command=searchTheaterByMovie&movieCd=${data.movieCd}&movieNm=${data.movieNm}'">
													</td>
												</c:if>
											</tr>
										</c:forEach>
									</c:when>
									<c:otherwise>목록이 없습니다. 다시 검색하세요.</c:otherwise>
								</c:choose>
							</table>
						</center>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>