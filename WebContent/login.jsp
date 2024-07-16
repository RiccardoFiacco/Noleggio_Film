<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link type="text/css" rel= "stylesheet" href= "css/login.css">
<title>Login</title>
<link rel="stylesheet" href="./style.css">
</head>
<body>
	<%@ include file="..\fragments\menu.jsp"%>
	
	<h1 align = "center">Login</h1>
		
		<form action="<%=request.getContextPath() + "/login"%>" method="post" id = "loginForm">

  			<div class="containerLogin">
    			<label for="uname"><b>Username</b></label>
    			<input type="text" placeholder="Enter Username" name="user" required>
	
    			<label for="psw"><b>Password</b></label>
    			<input type="password" placeholder="Enter Password" name="password" required>
        
    			<button type="submit">Login</button>
    			
    			<p>
				Se non sei ancora registrato, <a href = "signUp.jsp">Clicca qui</a>
				</p>
  			</div>
		</form>
		
		<% 
			Boolean invalidLogin = (Boolean) session.getAttribute("invalidLogin");
			if(invalidLogin != null && invalidLogin)
			{
		%>
		<h2 align = center>
			I dati non sono corretti oppure non sei ancora registrato, registrati prima!
		</h2>
		<%
			session.setAttribute("invalidLogin", false);
			}
			else
			{
				session.setAttribute("invalidLogin", false);
			}
		%>
	<%@ include file="..\fragments\footer.jsp"%>
</body>
</html>