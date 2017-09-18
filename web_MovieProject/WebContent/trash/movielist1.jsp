<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link href="../css/layout.css" rel="stylesheet" type="text/css">
<title>Movie List</title>
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
	<h3>Movie List</h3>
	<table border="1"  width="70%">
	<tr>
		<th width="20%">��ȭ ����</th>
		<th width="10%">�帣</th>
		<th width="10%">����</th>
		<th width="10%">����</th>
		<th width="10%">�� �ð�</th>
		<th width="10%">����</th>
	</tr>
	<c:forEach items="${requestScope.list}" var="data">
	<tr>
		<td>${data.movieNm}</td>
	 	<td align="center">${data.repGenreNm}</td>
	 	<td align="center">${data.repNationNm}</td>
	 	<td align="center">${data.director}</td>
	 	<td align="right"><fmt:formatNumber value="${data.movieRuntime}" groupingUsed="true"/></td>
	 	<td align="center"> <input type="button" value="����" Onclick="location.href='../TheaterServ?command=searchTheaterByMovie&movieCd=${data.movieCd}'"> </td>
	</tr>
	</c:forEach>
</table>
<a href="index.html">�������� �̵�</a>
</article>

<footer>
	<%@include file="footer.jsp" %>
</footer>

</div>
</body>
</html>