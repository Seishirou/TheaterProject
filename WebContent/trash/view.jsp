<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR" import="model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
<title>Member</title>
<body>
	<h3>���� ȸ�� ���� ����</h3>
	<br>
	<form action="update.jsp" method="post">
		<table border="1" cellspacing="1" width="60%">
			<tr>
				<td width=30%>����� ���̵�</td>
				<td width=70%><input type="hidden" name="id"
					value="${requestScope.mem.id}" /> ${requestScope.mem.id}</td>
			</tr>
			<tr>
				<td width="30%">��й�ȣ</td>
				<td width="70%"><input type="hidden" name="password"
					value="${requestScope.mem.pw}" /> ${requestScope.mem.pw}</td>
			</tr>
			<tr>
				<td width="30%">�̸�</td>
				<td width="70%"><input type="hidden" name="name"
					value="${requestScope.mem.name}" /> ${requestScope.mem.name}</td>
			</tr>
			<tr>
				<td width="30%">��ȭ��ȣ</td>
				<td width="70%"><input type="hidden" name="name"
					value="${requestScope.mem.phone}" /> ${requestScope.mem.phone}</td>
			</tr>
			<tr>
				<td width="30%">�̸��� �ּ�</td>
				<td width="70%"><input type="hidden" name="email"
					value="${requestScope.mem.email}" /> ${requestScope.mem.email}</td>
			</tr>
		</table>
		<br> <br> <input type="submit" value="update">&nbsp;
		<input type="button" value="allView"
			onclick="location.href='update.jsp?command=allView'"> <input
			type="hidden" name="command" value="allView">
	</form>



</body>
</html>
