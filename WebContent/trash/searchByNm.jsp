<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<% request.setCharacterEncoding("EUC-KR"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>극장 검색</title>
</head>
<body>
	<table>
		<tr>
			<td><button onclick="location.href='searchByNm.jsp'">극장명으로 검색</td>
			<td><button onclick="location.href='searchByRegion.jsp'">지역으로 검색</td>
		</tr>
	</table>
	<br><hr><br>
	
	<form action="TheaterServ" method="post">
		<input type="text" name="thtrNm" placeholder="극장명"><br>
		<input type="text" name="loc1" placeholder="시/도"><br>
		<input type="text" name="loc2" placeholder="시/군/구"><br>
		<input type="submit" value="검색">
		<input type="hidden" name="command" value="searchByThtrNm">	
	</form>
</body>
</html>