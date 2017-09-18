<%@ page language="java" 
contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>영화 검색</title>
</head>
<body>
<center>  
<h3>영화제목으로 검색한 결과</h3>

<%
	request.getAttribute("list");
%>

<table border="1"  width="70%">
	<tr>
		<th width="20%">영화 제목</th>
		<th width="10%">장르</th>
		<th width="10%">국가</th>
		<th width="10%">감독</th>
		<th width="10%">상영 시간</th>
	</tr>	
	<c:forEach items="${requestScope.list}" var="data">
		<tr>
	 		<td>${data.movieNm}</td>
	 		<td>${data.repGenreNm}</td>
	 		<td>${data.repNationNm}</td>
	 		<td>${data.director}</td>
	 		<td align="right"><fmt:formatNumber value="${data.movieRuntime}" groupingUsed="true"/></td>
		</tr>
		
	</c:forEach>
</table>
<p>
<a href="index.html">메인으로 이동</a>
</center>
</body>
</html>
