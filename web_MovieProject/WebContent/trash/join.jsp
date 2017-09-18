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
	<!-- �ܺ� html ������ �� ������ �����ϴ� include ������ tag -->
 	<%@ include file="header.jsp" %>
</nav>
<article>
	<h1>Join</h1>
	<form action="../MemberServlet" method="post">
	 <input type="hidden" name="command" value="insert">
	  <table border="1" cellspacing="1" width="60%">
		  <tr>
			<td width=30% align=center >����� ���̵�</td>
			<td width=70%>
				<input type="text" name="id">
			</td>
		  </tr>
		  <tr>
			<td width=30% align=center >��й�ȣ</td>
			<td width=70%>
				<input type="password" name="password">
			</td>
		  </tr>
		  <tr>
			<td width=30% align=center>�̸�</td>
			<td width=70% >
				<input type="text" name="name">
			</td>
		  </tr>
		  <tr>
			<td width=30% align=center >�̸���</td>
			<td width=70% >
				<input type="email" name="email" size="50">
			</td>
		  </tr>		  
		  <tr>
			<td width=30% align=center >��ȭ��ȣ</td>
			<td width=70% >
				<input type="text" name="phone" size="50">
			</td>
		  </tr>		  
	  </table>
	 <br>
	 <input type="submit" value="ȸ������">&nbsp;
	 <input type="reset" value="���">&nbsp;
	 <input type="button" value="�������� �̵�" Onclick="location.href='index.html'">
	 </form>
</article>
<footer>
	<%@include file="footer.jsp" %>
</footer>
</div>
</body>
</html>

