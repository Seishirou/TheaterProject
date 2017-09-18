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
	���� ����
 	<%
 		request.getAttribute("list");
	%>
	<c:forEach items="${requestScope.list}" var="data">
		<table id="t01">
			<tr><td align="center" colspan="2">�����</td></tr>
			<tr><td>Ƽ�� ��ȣ : </td><td>${data.bookCode}</td></tr>
			<tr><td>ȸ�� ���� : </td><td>${data.memberNm}</td></tr>
			<tr><td>���� ��Ī : </td><td>${data.thtrNm}</td></tr>
			<tr><td>��ȭ ���� : </td><td>${data.movieNm}</td></tr>
			<tr><td>���� ���� : </td><td>${Util.dateForm(data.watchDate)}</td></tr>
			<tr><td>�� ���� : </td><td>${data.playSeq} ȸ��</td></tr>
			<tr><td>�¼� ��ȣ : </td><td>${data.seatNo} �� �¼�</td></tr>
		</table>	
	</c:forEach>
	

</body>
</html>