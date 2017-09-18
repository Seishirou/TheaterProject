<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "model.Member"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${not empty mem.name}">
${mem.name} <input type="button" value="Logout" Onclick="location.href='../MemberServlet?command=logout&id=${mem.id}'">
</c:if>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Welcome</title>
</head>
<body>
	 <ul>
	 	<li><a href="index.jsp">Home</a></li>
	    <li><a href="join.jsp">Join</a></li>
	    <li><a href="login.jsp">Login</a></li>
	    <li><a href="mypage.jsp">My Page</a></li>
	    <li><a href="moviesearch.jsp">Movie Search</a></li>
	  </ul>
</body>
</html>