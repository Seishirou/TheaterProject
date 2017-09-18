<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="model.Member"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta charset="EUC-KR">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/w3.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/fonts/css?family=Raleway">
	
<title>Login Success</title>
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
		<div
			class="w3-display-bottommiddle w3-container w3-xlarge w3-padding-64">
			<button
				onclick="document.getElementById('mypage').style.display='block'"
				class="w3-button w3-black w3-round-large">나의 정보</button>
			<button
				onclick="document.getElementById('search').style.display='block'"
				class="w3-button w3-black w3-round-large">영화 검색</button>
			<button
				onclick="location.href='${pageContext.request.contextPath}/TheaterServ?command=reserve'"
				class="w3-button w3-black w3-round-large">영화 예매</button>
		</div>
		<div class="w3-display-bottomright w3-container">
			<p class="w3-xlarge"></p>
			<p class="w3-large"></p>
			<p>
				powered by <a
					href="${pageContext.request.contextPath}/css/w3css/default.asp"
					target="_blank">A.P</a>
			</p>
		</div>
	</div>

	<!-- My page Modal -->
	<div id="mypage" class="w3-modal">
		<div class="w3-modal-content w3-animate-zoom" style="max-width: 600px">
			<div class="w3-container w3-black">
				<span onclick="location.href='loginSuccess.jsp'"
					class="w3-button w3-display-topright w3-large">x</span>
				<center>
					<h1>나의 정보</h1>
					<form action="${pageContext.request.contextPath}/MemberServ"
						method="post">
						<input type="hidden" name="command" value="update">
						<table border="1" cellspacing="1" width="60%">
							<tr>
								<td width=45% align=center>아이디</td>
								<td width=55%><input type="hidden" name="id"
									value="${sessionScope.mem.id}" size="30" />
									${sessionScope.mem.id}</td>
							</tr>
							<tr>
								<td width="45%" align=center>비밀번호</td>
								<td width="55%"><input type="password" name="password"
									placeholder="${sessionScope.mem.pw}"
									value="${sessionScope.mem.pw}" size="30" /></td>
							</tr>
							<tr>
								<td width="45%" align=center>이름</td>
								<td width="55%"><input type="text" name="name"
									placeholder="${sessionScope.mem.name}"
									value="${sessionScope.mem.name}" size="30" /></td>
							</tr>
							<tr>
								<td width="45%" align=center>이메일</td>
								<td width="55%"><input type="text" name="email"
									placeholder="${sessionScope.mem.email}"
									value="${sessionScope.mem.email}" size="30" /></td>
							</tr>
							<tr>
								<td width="45%" align=center>전화번호</td>
								<td width="55%"><input type="text" name="phone"
									placeholder="${sessionScope.mem.phone}"
									value="${sessionScope.mem.phone}" size="30" /></td>
							</tr>
						</table>
						<br> <br>
						<div class="w3-display-bottommiddle w3-container">
							<button type="submit"
								class="w3-btn w3-grey w3-border w3-border-white w3-hover-blue-grey w3-medium w3-text-white">
								<b>수정</b>
							</button>
							<button type="button"
								onclick="location.href='MemberServ?command=delete&id=${sessionScope.mem.id}'"
								class="w3-btn w3-grey w3-border w3-border-white w3-hover-blue-grey w3-medium w3-text-white">
								<b>탈퇴</b>
							</button>
							<button type="reset" onclick="location.href='loginSuccess.jsp'"
								class="w3-btn w3-grey w3-border w3-border-white w3-hover-blue-grey w3-medium w3-text-white">
								<b>취소</b>
							</button>
						</div>
					</form>
				</center>
			</div>
		</div>
	</div>

	<!-- search Modal -->
	<div id="search" class="w3-modal">
		<div class="w3-modal-content w3-animate-zoom" style="max-width: 26%">
			<div class="w3-container w3-black">
				<span onclick="location.href='loginSuccess.jsp'"
					class="w3-button w3-display-topright w3-large">x</span>
				<center>
					<h1>영화 검색</h1>
					<form action="TheaterServ" method="post">
						1. 제목으로 검색<br> <input type="hidden" name="command"
							value="searchByTitle"> <input type="text" name="title"
							placeholder="제목" size="49"><br>
						<br>
						<button type="submit"
							class="w3-bar w3-grey w3-border w3-border-white w3-hover-blue-grey w3-medium w3-text-white">
							<b>검색</b>
						</button>
					</form>
					<br>
					<form action="TheaterServ" method="post">
						2. 개봉기간으로 검색<br> <input type="hidden" name="command"
							value="searchByPeriod"> <input type="text"
							name="periodStart" placeholder="시작날짜" size="21"> ~ <input
							type="text" name="periodEnd" placeholder="종료날짜" size="22"><br>
						<br>
						<button type="submit"
							class="w3-bar w3-grey w3-border w3-border-white w3-hover-blue-grey w3-medium w3-text-white">
							<b>검색</b>
						</button>
					</form>
					<br>
					<form action="TheaterServ" method="post">
						<h1>극장 검색</h1>
						<input type="hidden" name="command" value="searchByThtrNm">
						<input type="text" name="thtrNm" placeholder="극장명" size="49"><br>
						<input type="text" name="loc1" placeholder="시/도" size="49"><br>
						<input type="text" name="loc2" placeholder="시/군/구" size="49"><br>
						<br>
						<button type="submit"
							class="w3-bar w3-grey w3-border w3-border-white w3-hover-blue-grey w3-medium w3-text-white">
							<b>검색</b>
						</button>
					</form>
					<br>
				</center>
			</div>
		</div>
	</div>
</body>
</html>