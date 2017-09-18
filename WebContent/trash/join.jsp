<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link href="../css/layout.css" rel="stylesheet" type="text/css">
<title>Join</title>
</head>
<body>
<div class="container">
<header>
   <h1>Movie Gallery</h1>
</header>
<nav>
	<!-- 외부 html 파일을 이 영역에 포함하는 include 지시자 tag -->
 	<%@ include file="header.jsp" %>
</nav>
<article>
	<h1>Join</h1>
	<form action="../MemberServlet" method="post">
	 <input type="hidden" name="command" value="insert">
	  <table border="1" cellspacing="1" width="60%">
		  <tr>
			<td width=30% align=center >사용자 아이디</td>
			<td width=70%>
				<input type="text" name="id">
			</td>
		  </tr>
		  <tr>
			<td width=30% align=center >비밀번호</td>
			<td width=70%>
				<input type="password" name="password">
			</td>
		  </tr>
		  <tr>
			<td width=30% align=center>이름</td>
			<td width=70% >
				<input type="text" name="name">
			</td>
		  </tr>
		  <tr>
			<td width=30% align=center >이메일</td>
			<td width=70% >
				<input type="email" name="email" size="50">
			</td>
		  </tr>		  
		  <tr>
			<td width=30% align=center >전화번호</td>
			<td width=70% >
				<input type="text" name="phone" size="50">
			</td>
		  </tr>		  
	  </table>
	 <br>
	 <input type="submit" value="회원가입">&nbsp;
	 <input type="reset" value="취소">&nbsp;
	 <input type="button" value="메인으로 이동" Onclick="location.href='index.html'">
	 </form>
</article>
<footer>
	<%@include file="footer.jsp" %>
</footer>
</div>
</body>
</html>

