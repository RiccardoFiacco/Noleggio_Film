<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="mv.bean.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>User Page</title>
<link type="text/css" rel="stylesheet" href="css/detail.css">
</head>

<body>
	<%@include file="..\fragments\menu.jsp"%>

	<%
	currUser = (Utente) session.getAttribute("currentSessionUser");
	if (currUser == null) {
		response.sendRedirect("LoginPage.jsp");
		return;
	}
	%>

	<div class="user-detail">

		<h1 align="center">
			Benvenuto
			<%=currUser.getNome() + " " + currUser.getCognome()%></h1>

		<h2>Informazioni personali</h2>

		<table id="user-table">
			<tr>
				<td class="user-info">Username</td>
				<td><%=currUser.getUsername()%></td>
			</tr>

			<%
			if (currUser.isRuolo()) {
			%>
			<tr>
				<td class="user-info">Tipo di utente</td>
				<td>Admin</td>
			</tr>
			<%
			} else {
			%>
			<tr>
				<td class="user-info">Tipo di utente</td>
				<td>Utente</td>
			</tr>
			<%
			}
			%>

			<tr>
				<td class="user-info">Nome</td>
				<td><%=currUser.getNome()%></td>
			</tr>

			<tr>
				<td class="user-info">Cognome</td>
				<td><%=currUser.getCognome()%></td>
			</tr>

		</table>
	</div>

	<p class="user-link">
		<a href="orderList">I miei ordini</a>
	</p>

	<%@ include file="../fragments/footer.jsp"%>
</body>
</html>