<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="model.Reserve"%>
<%@ page import="util.Util"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%
	request.setCharacterEncoding("EUC-KR");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta charset="EUC-KR">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/w3.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/fonts/css?family=Raleway">

<title>TimeTable</title>
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

table#t01 {
	border: 1px solid #ccc;
	border-collapse: collapse;
	border-left: 0px;
	border-right: 0px;
}


</style>

<body>
	<div class="bgimg w3-display-container w3-text-white">
		<c:if test="${not empty mem.name}">
			<div
				class="w3-display-topright w3-text-black w3-large w3-margin-right w3-padding-16">
				<b>${mem.name}</b>
				<button
					onclick="location.href='MemberServ?command=logout&id=${mem.id}'"
					class="w3-grey w3-border w3-border-white w3-hover-blue-grey w3-medium w3-text-white w3-round-large">로그아웃</button>
			</div>
		</c:if>
		<div class="w3-modal-content w3-animate-zoom w3-display-middle"
			style="max-width: 30%">
			<div class="w3-container w3-black">
				<span onclick="location.href='loginSuccess.jsp'"
					class="w3-button w3-display-topright w3-large">x</span>
				<c:if test="${sessionScope.FOR_RESERVE}">
					<center>
						<h4>영화 제목 : ${param.movieNm}</h4>
						<h4>극장명 : ${param.thtrNm}</h4>
						<hr>
						<%
							request.getAttribute("list");
							String thtrCd = request.getParameter("thtrCd");
							String movieCd = request.getParameter("movieCd");
							String watchDay = request.getParameter("userDate"); 
							Reserve r = new Reserve();
							r.setThtrCd(thtrCd);
							r.setMovieCd(movieCd);
							r.setWatchDate(watchDay.replace("-", ""));
							r.setMemberId("user9"); 
							session.setAttribute("reserve", r);
						%>
						<form action="TheaterServ">
							<table>
								<tr>
									<td>상영 일자 :</td>
									<td>${param.userDate}</td>
								</tr>
								<tr>
									<td valign="top"><label>상영 시간 : </label></td>
									<td><c:forEach items="${requestScope.list}" var="data">
											<input type="radio" name="seq" value=${data.playSeq} >
											<label>${data.playSeq}회
												${Util.timeForm(data.playStrtTm)}</label>
											<br>
										</c:forEach></td>
								</tr>
								<tr>
									<td align="center">인원 :</td>
									<td><input type="number" name="qntty" placeholder="인원수"
										width="30px" value="1"></td>
								</tr>
							</table>
							<input type="hidden" name="command" value="reserveMovie">
							<input type="hidden" name="id" value="${sessionScope.mem.id}">
							<input
								class="w3-bar w3-grey w3-border w3-border-white w3-hover-blue-grey w3-small w3-text-white"
								type="submit" value="예매 신청">
						</form>
					</center>
					<br>
				</c:if>
			</div>
		</div>
	</div>
</body>
</html>