<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="util.Util"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<style>
table {
    width:30%;
}
table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
}
th{
	text-align : center;
	colspan :"2";
}
th, td {
    padding: 5px;
    text-align: left;
}
table#t01 tr:nth-child(even) {
    background-color: #eee;
}
table#t01 tr:nth-child(odd) {
   background-color:#fff;
}
table#t01 th {
    background-color: black;
    color: white;
}
</style>
</head>
<body>
	예매 성공
 	<%
 		request.getAttribute("list");
	%>
	<c:forEach items="${requestScope.list}" var="data">
		<table id="t01">
			<tr><td align="center" colspan="2">입장권</td></tr>
			<tr><td>티켓 번호 : </td><td>${data.bookCode}</td></tr>
			<tr><td>회원 성명 : </td><td>${data.memberNm}</td></tr>
			<tr><td>극장 명칭 : </td><td>${data.thtrNm}</td></tr>
			<tr><td>영화 제목 : </td><td>${data.movieNm}</td></tr>
			<tr><td>관람 일자 : </td><td>${Util.dateForm(data.watchDate)}</td></tr>
			<tr><td>상영 차수 : </td><td>${data.playSeq} 회차</td></tr>
			<tr><td>좌석 번호 : </td><td>${data.seatNo} 번 좌석</td></tr>
		</table>	
	</c:forEach>
	

</body>
</html>