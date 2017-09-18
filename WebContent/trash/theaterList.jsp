<%@ page language="java" 
contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page import="util.Util"%>
<% request.setCharacterEncoding("EUC-KR"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>극장 검색</title>
</head>
<!--  <meta name="viewport" content="width=device-width, initial-scale=1">
 -->
<link rel="stylesheet" href="css/w3.css">
<body>
<center>  
<h3>극장명/지역으로 검색</h3>
<c:if test="${sessionScope.FOR_RESERVE}">
	<h4>영화 제목 : ${param.movieNm}</h4>
</c:if> 

<%
	request.getAttribute("list");
%>
<div class="w3-container">
<table class="w3-table-all w3-hoverable"  width="50%">
	<tr class=class="w3-light-grey">
		<th width="20%">극장명</th>
		<th width="10%">지역</th>
		<th width="5%">좌석수</th>
		<c:if test="${sessionScope.FOR_RESERVE}">
			<th width="15%">상영기간</th>
			<th width="5%">선택</th>
		</c:if>
	</tr>	
	<c:forEach items="${requestScope.list}" var="data">
		<tr>
	 		<td>${data.thtrNm}</td>
	 		<td align="center">${data.loc1} ${data.loc2}</td>
	 		<td align="right"><fmt:formatNumber value="${data.thtrSeatCnt}" groupingUsed="true"/></td>
			<c:if test="${sessionScope.FOR_RESERVE}">
				<td>
					${Util.dateForm(data.playStrtDt)} ~ ${Util.dateForm(data.playEndDt)}
				<td>
 					<input type="button" value="선택" Onclick="location.href='makeSchedule.jsp?thtrCd=${data.thtrCd}&thtrNm=${data.thtrNm}&movieCd=${param.movieCd}&movieNm=${param.movieNm}'">	 
				</td>
			</c:if>
		</tr>
		
	</c:forEach>
</table>
<p>
<a href="index.html">메인으로 이동</a>
</center>
</div>
</body>
</html>
