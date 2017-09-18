<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="util.Util"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta charset="EUC-KR">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/w3.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/fonts/css?family=Raleway">

<title>Reserve Success</title>
<style>
body, h1, h5 {
	font-family: "Raleway", sans-serif
}

body, html {
	height: 100%;
}

.bgimg {
	background-image:
		url('${pageContext.request.contextPath}/img/hollywood.jpg');
	min-height: 100%;
	background-position: center;
	background-size: cover;
}
</style>

<body>
	<div class="bgimg w3-display-container w3-text-black">
		<c:if test="${not empty sessionScope.mem.name}">
			<div
				class="w3-display-topright w3-text-black w3-large w3-margin-right w3-padding-16">
				<b>${sessionScope.mem.name}</b>
				<button
					onclick="location.href='MemberServ?command=logout&id=${sessionScope.mem.id}'"
					class="w3-grey w3-border w3-border-white w3-hover-blue-grey w3-medium w3-text-white w3-round-large">�α׾ƿ�</button>
			</div>
		</c:if>
		<div class="w3-modal-content w3-animate-zoom" style="width: 50%">
			<div class="w3-container w3-black">
				<span onclick="location.href='loginSuccess.jsp'"
					class="w3-button w3-display-topright w3-large">x</span>
				<%
					request.getAttribute("list");
				%>
				<center>
				<h3>���� ����</h3>
				<c:forEach items="${requestScope.list}" var="data">
					<table class="w3-table w3-striped w3-border w3-centered w3-grey" style="width: 50%">
						<tr align="center" style="background-color: grey">�����</tr>
						<tr><td>Ƽ�� ��ȣ : </td><td>${data.bookCode}</td></tr>
						<tr><td>ȸ�� ���� : </td><td>${mem.name}</td></tr>
						<tr><td>���� ��Ī : </td><td>${data.thtrNm}</td></tr>
						<tr><td>��ȭ ���� : </td><td>${data.movieNm}</td></tr>
						<tr><td>���� ���� : </td><td>${Util.dateForm(data.watchDate)}</td></tr>
						<tr><td>�� ���� : </td><td>${data.playSeq} ȸ��</td></tr>
						<tr><td>�¼� ��ȣ : </td><td>${data.seatNo} �� �¼�</td></tr>
					</table>	
				</c:forEach>
				</center>
				<br> 
				<br>
				<div class="w3-display-bottommiddle w3-container">
					<button type="submit"
						onclick="location.href='${pageContext.request.contextPath}/toBeContinue.jsp'"
						class="w3-btn w3-grey w3-border w3-border-white w3-hover-blue-grey w3-medium w3-text-white">
						<b>Ƽ�����</b>
					</button>
					<button type="reset"
						onclick="location.href='${pageContext.request.contextPath}/loginSuccess.jsp'"
						class="w3-btn w3-grey w3-border w3-border-white w3-hover-blue-grey w3-medium w3-text-white">
						<b>����ȭ��</b>
					</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>