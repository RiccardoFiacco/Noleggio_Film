<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="util.*" import ="mv.dao.*" import="mv.bean.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Aggiorna Film</title>
</head>
<body>
	<%@ include file="..\fragments\menu.jsp"%>
	<%
		DbManager dm = new DbManager();
		FilmDAO fDAO = new FilmDAO(dm.getConnection());
		int id = Integer.parseInt(request.getParameter("id"));
		Film f = fDAO.readFilmById(id);
		String img = f.getImg().substring(4);
		img = img.substring(0, img.length() - 4);
	%>
	<form action="<%=request.getContextPath() + "/update"%>" method="post">
			<label for="img">Locandina</label>
			<input type="hidden" id="id" name="id" value="<%= f.getId_f() %>">
            <input type="text" id="img" name="img" value="<%= img %>" required>
			<br>
            <label for="titolo">Titolo</label>
            <input type="text" id="titolo" name="titolo" value="<%= f.getTitolo() %>"required>
			<br>
            <label for="genere">Genere</label>
            <input type="text" id="genere" name="genere" value="<%= f.getGenere() %>" required>
			<br>
            <label for="titolo">Descrizione</label>
            <input type="text" id="descrizione" name="descrizione" value="<%= f.getDescrizione() %>" required>
            <br>
            <label for="prezzo">Prezzo</label>
            <input type="text" id="prezzo" name="prezzo" value="<%= f.getPrezzo() %>" required>
			<br>
			<label for="disp">Disponibilit�</label>
            <select class="dropdown" name="disp" id="disp">
                <option value="true">Disponibile</option>
                <option value="false">Non Disponibile</option>
            </select>
			<button type="submit">Aggiorna</button>
		</form>
		<%@ include file="..\fragments\footer.jsp"%>
</body>
</html>