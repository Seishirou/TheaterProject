<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
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

<title>Login Fail</title>
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
		<div class="w3-display-middle">
			<div class="w3-modal-content w3-animate-zoom"
				style="max-width: 500px">
				<div class="w3-container w3-black">
					<div style="width: 100%; height: 200px;">
						<span onclick="location.href='index.jsp'"
							class="w3-button w3-display-topright w3-large">x</span>
						<center>
							<table class="w3-padding w3-display-middle" border="1"
								cellspacing="1" width="80%" height="50%">
								<tr>
									<td><b>비밀번호가 틀렸거나 없는 아이디입니다.</b><br> 다시 시도하세요.<b></td>
								</tr>
							</table>
							<div class="w3-display-bottommiddle w3-container">
								<button type="reset"
									onclick="document.getElementById('login').style.display='block'"
									class="w3-btn w3-grey w3-border w3-border-white w3-hover-blue-grey w3-medium w3-text-white">
									<b>다시시도</b>
								</button>
								<button type="reset" onclick="location.href='index.jsp'"
									class="w3-btn w3-grey w3-border w3-border-white w3-hover-blue-grey w3-medium w3-text-white">
									<b>취소</b>
								</button>
							</div>
						</center>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!--Login Modal-->
	<div id="login" class="w3-modal">
		<div class="w3-modal-content w3-animate-zoom" style="max-width: 450px">
			<div class="w3-container w3-black w3-display-container">
				<span
					onclick="document.getElementById('login').style.display='none'"
					class="w3-button w3-display-topright w3-large">x</span>
				<center>
					<h1>로그인</h1>
					<form action="MemberServ" method="post">
						<input type="hidden" name="command" value="login">
						<table border="1" cellspacing="1" width="60%">
							<tr>
								<td width=45% align=center>아이디</td>
								<td width=55%><input type="text" name="id"></td>
							</tr>
							<tr>
								<td width=45% align=center>비밀번호</td>
								<td width=55%><input type="password" name="password">
								</td>
							</tr>
						</table>
						<br> <br>
						<div class="w3-display-bottommiddle w3-container">
							<button type="submit"
								class="w3-btn w3-black w3-border w3-border-white w3-hover-grey w3-medium w3-text-white">
								<b>로그인</b>
							</button>
							<button type="reset" onclick="location.href='index.jsp'"
								class="w3-btn w3-black w3-border w3-border-white w3-hover-grey w3-medium w3-text-white">
								<b>취소</b>
							</button>
						</div>
					</form>
				</center>
			</div>
		</div>
	</div>
</body>
</html>