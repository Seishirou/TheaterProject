<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link href="../css/layout.css" rel="stylesheet" type="text/css">
<title>Login</title>
</head>
<body>
<div class="container">
<header>
   <h1>Movie Gallery</h1>
</header>
<nav>
 	<%@ include file="header.jsp" %>
</nav>
<article>
	<h1>Login</h1>
	<form action="../MemberServlet" method="post">
	 <input type="hidden" name="command" value="login">
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
	  </table>
	 <br>
	 <input type="submit" value="로그인">&nbsp;
	 <input type="reset" value="취소">&nbsp;
	 <input type="button" value="메인으로 이동" Onclick="location.href='index.html'">
	 </form>
</article>
<footer>
	<%@include file="footer.jsp"%>
</footer>
</div>
</body>
</html>

