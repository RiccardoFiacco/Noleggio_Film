<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Contatti</title>
		
		<style type="text/css">
			a#return-home:link, a#return-home:visited{
				color: #0D47A1;
			}
			
			a#return-home:active, a#return-home:hover{
				color: #90E0EF;
			}
		</style>
		
	</head>

	<body>
		<%@include file="..\fragments\menu.jsp" %>
		
		<h1 align = "center">Contatti </h1>
		
		<div align = "center">
			<h2>Attilio Gismondi</h2>
			<div>Email: agismondi@gmail.com</div>
			<div>Telefono: 342-3167214</div>
		</div>
		
		<div align = "center">
			<h2>Riccardo Fiacco</h2>
			<div>Email: rfiacco@gmail.com</div>
			<div>Telefono: 342-2356241</div>
		</div>
		
		<div align = "center">
			<h2>Lorenzo Giannanti</h2>
			<div>Email: lgiannanti@gmail.com</div>
			<div>Telefono: 345-2356412</div>
		</div>
		
		<div align = "center">
			<h2>Gerardo Pisciotta</h2>
			<div>Email: gpisciotta@gmail.com</div>
			<div>Telefono: 345-2356412</div>
		</div>
		
		<%@ include file="../fragments/footer.jsp" %>
	</body>
</html>