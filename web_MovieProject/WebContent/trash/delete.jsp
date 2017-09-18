<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta charset="EUC-KR">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/w3.css">
<link rel="stylesheet" href="fonts/css?family=Raleway">
<title>Welcome</title>
<style>
body, h1, h5 {
	font-family: "Raleway", sans-serif
}

body, html {
	height: 100%
}

.bgimg {
	background-image: url('img/hollywood.jpg');
	min-height: 100%;
	background-position: center;
	background-size: cover;
}
</style>

<body>
	<div id="delete" class="w3-modal">
		<div class="w3-modal-content w3-animate-zoom">
			<div class="w3-container w3-black w3-display-container">
				<span
					onclick="document.getElementById('delete').style.display='none'"
					class="w3-button w3-display-topright w3-large">x</span>
				<h1>Delete</h1>
				정말 탈퇴하시겠습니까? <input type="button" value="확인"
					Onclick="location.href='MemberServlet?command=delete&id=${sessionScope.mem.id}'">&nbsp;
				<input type="button" value="취소"
					Onclick="location.href='defaultLoginSuc.jsp'">
			</div>
		</div>
	</div>
<body>
	<div class="container"></div>
</body>
</html>