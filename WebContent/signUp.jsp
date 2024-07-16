<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Sign Up</title>
<link type = "text/css" rel="stylesheet" href="css/signup.css">
</head>
<body>
	<%@ include file="..\fragments\menu.jsp"%>

    <form name='registration' action="<%=request.getContextPath() + "/registrazione"%>" style="border:1px solid #ccc" id="signupForm" method = "post">
  			<div class="signupContainer">
    			<p>Compila i campi del form per creare un account.</p>
    
    			<hr>
    			
				<label for="user"><b>Username</b></label>&nbsp; &nbsp;<span id = "userspan" style = "color:red;"></span>
    			<input class = "valid" id = "username" type="text" placeholder="Inserisci Username" name="username">    		

				<input type = "hidden" name = "userErr" value ="">

    			<label for="password"><b>Password</b></label>&nbsp; &nbsp;<span id = "pswspan" style = "color:red;"></span>
    			<input class = "valid" type="password" placeholder="Inserisci Password" name="password" >
    			
    			<label for="fName"><b>Nome</b></label>&nbsp; &nbsp;<span id = "namespan" style = "color:red;"></span>
    			<input class = "valid" type="text" placeholder="Inserisci nome" name="nome" >
    			
    			<label for="lName"><b>Cognome</b></label>&nbsp; &nbsp;<span id = "lnamespan" style = "color:red;"></span>
    			<input class = "valid" type="text" placeholder="Inserisci cognome" name="cognome" >

    			<div class="clearfix">
    				<button type="submit" class="signupbtn">Sign Up</button>
      				<button type="reset" class="cancelbtn">Cancella</button>
    			</div>
  			</div>
		</form>
    <%@ include file="..\fragments\footer.jsp"%>
</body>
</html>