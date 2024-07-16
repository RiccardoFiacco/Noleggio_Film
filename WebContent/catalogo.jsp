<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="mv.bean.*" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
		<meta charset="UTF-8">
		<title>Catalogo</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link type="text/css" rel="stylesheet" href="css/catalog.css">
</head>
<body>
	<%@ include file="..\fragments\menu.jsp"%>
   <div class = "catalog-container">
		
		<h1 align = "center">Catalogo</h1>
		
     	<%
     		Collection<?> films = (Collection<?>) request.getAttribute("films");
     		Utente currentUser = (Utente) session.getAttribute("currentSessionUser");
     		
			if(films != null)
			{
				Iterator<?> it = films.iterator();
				Film f;

				while(it.hasNext())
				{	
            		f = (Film) it.next();
            		if (!f.isDisponibile() && (currentUser == null || !currentUser.isRuolo()))
            		{
            			continue;
            		}
     	%>

            	
                <div class = "travel-container"> 
                <div class = "travel-img"><img class = "hover-shadow" src= "<%=f.getImg() %>" alt = "<%= f.getTitolo() %>"></div>
				<div class = "travel-resptitle"><h2><b><%= f.getTitolo() %></b></h2></div>
				<div class = "travel-respdescription"><%= f.getDescrizione() %></div>
				<div class = "travel-info">
					<div class = "travel-respdDate"><b>Genere</b> <%= f.getGenere() %> </div>
					<div class = "travel-respdisp"><%=f.isDisponibile() ? "Disponibile" : "Non Disponibile"%> </div>
					<div class = "travel-respprice"><b>Prezzo:</b><span id = "resp-price"><%= f.getPrezzo()%> €</span></div>
				</div>
				<div class = "travel-detail">
					<div class = "travel-title"><b><%= f.getTitolo() %></b></div>
					<div class = "travel-description"><%= f.getDescrizione() %></div>
					<div class = "travel-dDate"><b>Genere</b> <%= f.getGenere() %> </div>
					<div class = "travel-price"><b>Prezzo:</b> <%= f.getPrezzo()%> €</div>
					<div class = "travel-disp"><%=f.isDisponibile() ? "Disponibile" : "Non Disponibile"%> </div>
				</div>
				</div>
                <%
                    if (currentUser != null )
                    {
                    	Collection<?> film_nol = (Collection<?>) request.getAttribute("filmNoleggiati");
                    	if(film_nol == null || (film_nol != null && !film_nol.contains(f.getId_f())))
                    	{
                %>
                <form action="<%=request.getContextPath() + "/noleggia" %>" method="POST">
                    <input type="hidden" id="id_f" name="id_f" value="<%=f.getId_f()%>">
                    <input type="hidden" id="id_u" name="id_u" value="<%=currentUser.getId_u()%>">
                    <div class="clearfix">
                    <button type="submit">Noleggia</button>
                    </div>
                </form> 
                <%
                    	}
                		else
                		{
                %>
                
                <form action="<%=request.getContextPath() + "/restituisci" %>" method="POST">
                	<input type="hidden" id="id_f" name="id_f" value="<%=f.getId_f()%>">
                    <input type="hidden" id="id_u" name="id_u" value="<%=currentUser.getId_u()%>">
                    <div class="clearfix">
                    <button type="submit">Restituisci</button>
                    </div>
                </form>  

                <%			
                		}
                    }
                    else
                    {
                    	
                %>         
                <form action="<%=request.getContextPath() + "/login.jsp" %>" method="POST">
                <div class="clearfix">
                    <button type="submit">Noleggia</button>
                </div>
                </form>            
                <% 
                    }if(currentUser != null && currentUser.isRuolo()){
                %>
				<div class="clearfix">
                <form action="<%=request.getContextPath() + "/elimina" %>" method="POST">
                    <input type="hidden" id="id" name="id" value="<%=f.getId_f() %>">
                    <button type="submit" class="cancelbtn">Elimina</button>
                </form>
				 <form action="<%=request.getContextPath() + "/update.jsp" %>" method="POST">
                    <input type="hidden" id="id" name="id" value="<%=f.getId_f() %>">
                    <button type="submit" class="signupbtn">Aggiorna</button>
                </form>	
             	</div>

                <%
                	}
                }
     		}
                %>
            </div>
</body>
</html>