package mv.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import mv.bean.Utente;
import mv.dao.UtenteDAO;
import util.DbManager;

import java.io.IOException;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {
        
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		try
		{
			DbManager dm = new DbManager();
			Utente utente = new Utente();
			UtenteDAO uDAO = new UtenteDAO(dm.getConnection());
			request.setCharacterEncoding("UTF-8");
			
			utente.setUsername(request.getParameter("user"));
			utente.setPassword(request.getParameter("password"));
			uDAO.readUtente(utente);
			
			if(utente.isValid()){
				HttpSession session = request.getSession();//se la sessione è stata create te la mette in session, se no la crea e la mette in session
				session.setAttribute("currentSessionUser", utente);//viene messo in ogni current session user i dettagli di utente(id, nome, cognome ecc)
				response.sendRedirect("home.jsp");
				
			}else{
				HttpSession session = request.getSession();
				session.setAttribute("invalidLogin", true);
				response.sendRedirect("login.jsp");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
