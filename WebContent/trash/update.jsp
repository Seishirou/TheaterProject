<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link href="../css/layout.css" rel="stylesheet" type="text/css">
<title>My Page</title>
</head>
<body>
<div class="container">

<header>
   <h1>Movie Gallery</h1>
</header>

<nav>
 	<%@ include file="header.jsp"%>
</nav>

<article>
  <h3>My Page</h3>
	<br>
	 <form action="../MemberServlet" method="post">
	 <input type="hidden" name="command" value="update">
	  <table border="1" cellspacing="1" width="60%">
				  <tr>
					<td width=30%>사용자 아이디</td>
					<td width=70%>	
						<input type="hidden" name="id" value="${param.id}"/>
						${param.id}		
					</td>
				  </tr>
				  <tr>
					<td width="30%">이름</td>
					<td width="70%">
						<input type="text" name="name" value="${param.name}"/>
					</td>
				  </tr>
				  <tr>
					<td width="30%">비밀번호</td>
					<td width="70%">
						<input type="password" name="password" value="${param.password}">
					</td>
				  </tr>			  
				  <tr>
					<td width="30%">이메일</td>
					<td width="70%">
						<input type="email" name="email" value="${param.email}">
					</td>		  
				  <tr>
					<td width="30%">전화번호</td>
					<td width="70%">
						<input type="text" name="phone" value="${param.phone}">
					</td>		  
				  <tr>				  
			</table>
	  <br>	  

		<input type="submit" value="확인">&nbsp;
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