<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="util.Util"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta charset="EUC-KR">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/w3.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/fonts/css?family=Raleway">
<title>Reserve Success</title>
<style>
body, h1, h5 {
	font-family: "Raleway", sans-serif
}

body, html {
	height: 100%;
}

.bgimg {
	background-image: url('${pageContext.request.contextPath}/img/hollywood.jpg');
	min-height: 100%;
	background-position: center;
	background-size: cover;
}

table {
	width: 600px;
	height: 100%;
}

table, th, td {
	border-collapse: collapse;
}

th {
	colspan: "2";
}

th, td {
	padding: 5px;
	text-align: left;
	color: black;
	font-size: 20px;
}

table#t01 th {
	background-color: rgba(255, 255, 255, 0);
	color: white;
}
</style>

<body>
	<div class="bgimg w3-display-container w3-text-white">
		<div class="w3-display-middle" style="height: 100%">
		<c:if test="${not empty sessionScope.mem.name}">
			<div
				class="w3-display-topright w3-text-black w3-large w3-margin-right w3-padding-16">
				<b>${sessionScope.mem.name}</b>
				<button
					onclick="location.href='MemberServ?command=logout&id=${sessionScope.mem.id}'"
					class="w3-grey w3-border w3-border-white w3-hover-blue-grey w3-medium w3-text-white w3-round-large">�α׾ƿ�</button>
			</div>
		</c:if>
			<div class="w3-modal-content w3-animate-zoom" style="max-width: 100%">
				<img src="${pageContext.request.contextPath}/img/ticket.jpg" style="max-width: 100%">
				<div class="w3-container w3-black">
					<span onclick="location.href='loginSuccess.jsp'" class="w3-button w3-display-topright w3-large">x</span>
					<%
						session.getAttribute("reserve");
					%>
					<br>
					<table class="w3-display-middle w3-padding-16" width="100%">
						<br>
						<br>
						<tr>
							<td>Ƽ�� ��ȣ : ${reserve.bookCode}</td>
							<td>ȸ�� ���� : ${mem.name}</td>
						</tr>
						<tr>
							<td>���� ��Ī : ${reserve.thtrNm}</td>
							<td>��ȭ ���� : ${reserve.movieNm}</td>
						</tr>
						<tr>
							<td>���� ���� : ${Util.dateForm(reserve.watchDate)}</td>
							<td>�� ���� : ${reserve.playSeq}ȸ��</td>
						</tr>
					</table>
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
	</div>
</body>
</html>