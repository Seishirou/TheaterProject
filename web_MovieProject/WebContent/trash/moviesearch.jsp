<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>��ȭ �˻�</title>
<meta charset="EUC-KR">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/w3.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/fonts/css?family=Raleway">
<style>
body, h1, h5 {
	font-family: "Raleway", sans-serif
}

body, html {
	height: 100%
}

.bgimg {
	background-image: url('${pageContext.request.contextPath}/img/hollywood.jpg');
	min-height: 100%;
	background-position: center;
	background-size: cover;
}
</style>
<body>

<div id="search" class="w3-modal">
		<div class="w3-modal-content w3-animate-zoom" style="max-width: 400px">
			<div class="w3-container w3-black">
				<span
					onclick="document.getElementById('search').style.display='none'"
					class="w3-button w3-display-topright w3-large">x</span>
				<center>
					<h1>��ȭ �˻�</h1>
					<form action="../TheaterServ" method="post">
						1. �������� �˻�<br> 
						<input type="hidden" name="command"	value="title"> 
						<input type="text" name="title"	placeholder="����" size="49"><br>
						<button type="submit" class="w3-bar w3-black w3-border w3-border-white w3-hover-grey w3-medium w3-text-white">
						<b>�˻�</b>
						</button>
					</form>
					<br>
					<form action="../TheaterServ" method="post">
						2. �����Ⱓ���� �˻�<br> 
						<input type="hidden" name="command" value="period"> 
						<input type="text" name="periodStart" placeholder="���۳�¥" size="21"> ~ 
						<input type="text" name="periodEnd"	placeholder="���ᳯ¥" size="22"> <br>
						<button type="submit" class="w3-bar w3-black w3-border w3-border-white w3-hover-grey w3-medium w3-text-white">
						<b>�˻�</b>
						</button>
					</form>
					<br>
					<form action="../TheaterServ" method="post">
						3. �������� �˻�<br> 
						<input type="hidden" name="command" value="searchByThtrNm"> 
						<input type="text" name="thtrNm" placeholder="�����" size="49"><br> 
						<input type="text" name="loc1" placeholder="��/��" size="49"><br> 
						<input type="text" name="loc2" placeholder="��/��/��" size="49"><br>
						<button type="submit" class="w3-bar w3-black w3-border w3-border-white w3-hover-grey w3-medium w3-text-white">
						<b>�˻�</b>
						</button>
					</form>
					<br>
				</center>
			</div>
		</div>
	</div>

</body>
</html>