<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>aggiungi</title>
</head>
<body>
	<%@ include file="..\fragments\menu.jsp"%>
	<!-- con questo form, andiamo poi a richiamare la servlet aggiungi
	(get passa i valori nell'url)
	metti il metodo post per non far passare i dati nell'url -->
    <form action="<%=request.getContextPath() + "/aggiungi"%>" method="post">
            <label for="img">Locandina</label>
            <input type="text" id="img" name="img" required>
            <br>
            <label for="titolo">Titolo</label>
            <input type="text" id="titolo" name="titolo" required>
            <br>
            <label for="genere">Genere</label>
            <input type="text" id="genere" name="genere" required>
            <br>
            <label for="titolo">Descrizione</label>
            <input type="text" id="descrizione" name="descrizione" required>
            <br>
            <label for="prezzo">Prezzo</label>
            <input type="text" id="prezzo" name="prezzo" required>
            <br>
            <label for="disp">Disponibilità</label>
            <select class="dropdown" name="disp" id="disp">
                <option value="true">Disponibile</option>
                <option value="false">Non Disponibile</option>
            </select>
            <button type="submit">Aggiungi</button>
        </form>
        <%@ include file="..\fragments\footer.jsp"%>
</body>
</html>