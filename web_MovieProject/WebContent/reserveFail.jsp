<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta charset="EUC-KR">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/w3.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/fonts/css?family=Raleway">
	
<title>Reserve Fail</title>
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
					<div class="w3-container w3-black">
					<h1 align="center">예매 실패</h1>
					</div>
					<button type="button" onclick="location.href='index.jsp'"
						class="w3-btn w3-grey w3-border w3-border-white w3-hover-blue-grey w3-medium w3-text-white">
						<b>메인으로이동</b>
					</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>