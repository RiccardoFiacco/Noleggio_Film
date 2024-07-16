<%@ page language="java"
    pageEncoding="ISO-8859-1" import="mv.bean.*"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta content="width=device-width, initial-scale=1.0">
		<link type="text/css" rel= "stylesheet" href= "css/menu.css">
	</head>

	<nav>
		<%
			Utente currUser = (Utente) session.getAttribute("currentSessionUser"); //currentUser se non mi loggo si crea ma è un'istanza vuota
		%>
		<div class = "dropdownMenu">
  				<img class = "dropimgMenu" src="img/iconMenu.png" alt="Menu Icon">
  				<div class = "dropdown-content-menu">
  					<a href = "catalogo">CATALOGO</a>
  					<%
						if(currUser != null && currUser.isRuolo())
						{
					%>
							<a href = "aggiungiFilm.jsp">AGGIUNGI FILM</a>
					<%
						}
					%>
					<a href= "ContactPage.jsp">CONTATTI</a>
  					<%
  						if(currUser == null)
						{
					%>
							<a href = "login.jsp">LOGIN</a>
							<a href = "signUp.jsp">SIGN UP</a>
					<%
						}
						else
						{
					%>
							<a href = "UserPage.jsp"><%= "Ciao, " + currUser.getNome()%></a>
							<a href = "Logout">LOGOUT</a>
					<% 
						}
  					%>			
  				</div>
		</div>
		
		<ul id="navMenu">
			
			<li><a href = "home.jsp">HOME</a></li>
			<li><a href = "catalogo">CATALOGO</a></li>
			
			<%
				if(currUser != null && currUser.isRuolo())
				{
			%>
			<li><a href = "aggiungiFilm.jsp">AGGIUNGI FILM</a></li>
			<%
				}

  				if(currUser == null)
				{
			%>
			<li><a href = "login.jsp">LOGIN</a></li>
			<li><a href = "signUp.jsp">SIGN UP</a></li>
			<%
				}
				else
				{
			%>
			<li><a href = "userPage.jsp"><%= "Ciao, " +  currUser.getNome()%></a></li>
			<li><a href = "logout">LOGOUT</a></li>
			<% 
				}
  			%>			
			<li><a href= "contactPage.jsp">CONTATTI</a></li>
			<li class="search-container">
    			<form action="catalogo">
      				<input type="text"  name="ricerca" autocomplete = off>
    			</form>
  			</li>
  			
		</ul>
	</nav>
</html>