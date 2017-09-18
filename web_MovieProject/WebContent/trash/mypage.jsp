<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
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
 	<%@ include file="header.jsp" %>
  
</nav>


<h1>My Page</h1>
	 <form action="../MemberServlet" method="post">
	  <input type="hidden" name="command" value="update">
	   <table border="1" cellspacing="1" width="60%">
		  <tr>
			<td width=30% align=center>사용자 아이디</td>
			<td width=70%>
			<input type="hidden" name="id" value="${sessionScope.mem.id}"/>
			  ${sessionScope.mem.id}
			</td>
		  </tr>
		  <tr>
			<td width="30%" align=center>비밀번호</td>
			<td width="70%">
			<input type="password" name="password" placeholder="${sessionScope.mem.pw}" value="${sessionScope.mem.pw}"/>
			</td>
		  </tr>
		  <tr>
			<td width="30%" align=center>이름</td>
			<td width="70%">
			<input type="text" name="name" placeholder="${sessionScope.mem.name}" value="${sessionScope.mem.name}"/>
			</td>
		  </tr>
		  <tr>
			<td width="30%" align=center>이메일</td>
			<td width="70%">
			<input type="text" name="email" placeholder="${sessionScope.mem.email}" value="${sessionScope.mem.email}"/>
			</td>
		  </tr>		  
		  <tr>
			<td width="30%" align=center>전화번호</td>
			<td width="70%">
			<input type="text" name="phone" placeholder="${sessionScope.mem.phone}" value="${sessionScope.mem.phone}"/>
			</td>
		  </tr>		  
	   </table>	
	  <br>	  
		<input type="submit" value="수정">&nbsp;
		<input type="button" value="탈퇴" Onclick='location.href="delete.jsp?command=delete?id=${sessionScope.mem.id}"'>
		<input type="button" value="메인으로 이동" Onclick="location.href='main/defaultLoginSuc.jsp'">
	 </form>


<footer>
	<%@include file="footer.jsp"%>
</footer>
</div>
</body>
</html>