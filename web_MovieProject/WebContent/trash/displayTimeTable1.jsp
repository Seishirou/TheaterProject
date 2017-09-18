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
	background-image: url('${pageContext.request.contextPath}/img/hollywood.jpg');
	min-height: 100%;
	background-position: center;
	background-size: cover;
}

</style>
</head>
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
			<div class="w3-modal-content w3-animate-zoom w3-display-middle" style="max-width: 30%">
				<div class="w3-container w3-black">
				<span
					onclick="location.href='loginSuccess.jsp'"
					class="w3-button w3-display-topright w3-large">x</span>
					<c:if test="${sessionScope.FOR_RESERVE}">
					<center>
						<h4>영화제목 : ${param.movieNm}</h4>
						<h4>극장명 : ${param.thtrNm}</h4>
						<h4>일시 : ${param.userDate}</h4>
						<hr>
						<%
							request.getAttribute("list");
								String thtrCd = request.getParameter("thtrCd");
								String movieCd = request.getParameter("movieCd");
								String watchDay = request.getParameter("userDate"); // debug

								Reserve r = new Reserve();

								r.setThtrCd(thtrCd);
								r.setMovieCd(movieCd);
								r.setWatchDate(watchDay.replace("-", ""));
								r.setSeatNo(3);
								session.setAttribute("reserve", r);
						%>
						<table width="90%" border="1">
							<tr>
								<th>차수</th>
								<th>시각</th>
								<th>선택</th>
							</tr>
							<c:forEach items="${requestScope.list}" var="data">
								<tr align="center">
									<td width="10%">${data.playSeq}</td>
									<td width="10%">${Util.timeForm(data.playStrtTm)}</td>
									<td width="5%">
									<input class="w3-btn w3-grey w3-border w3-border-white w3-hover-blue-grey w3-medium w3-text-white" 
									type="button" value="선택"
									onclick="location.href='${pageContext.request.contextPath}/TheaterServ?command=reserveMovie&seq=${data.playSeq}'">
									</td>
								</tr>
							</c:forEach>
						</table>
					</center>	
					</c:if>
				</div>
			</div>
		</div>
	</div>
</body>
</html>