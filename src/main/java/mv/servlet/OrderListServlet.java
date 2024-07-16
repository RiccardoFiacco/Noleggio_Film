package mv.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import mv.bean.*;
import mv.dao.NoleggioDAO;
import util.DbManager;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

public class OrderListServlet extends HttpServlet { //prende 
	private static final long serialVersionUID = 1L;
	private NoleggioDAO noleggioDAO;
	 
	public void init() throws ServletException {
        try {
            DbManager dbManager = new DbManager();
            noleggioDAO = new NoleggioDAO(dbManager.getConnection());
         }catch (SQLException e) {
             throw new ServletException(e);
         }
   }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		Utente currentUser = (Utente) session.getAttribute("currentSessionUser");
		
		try
		{
			List<Noleggio> noleggi = null;
			
			noleggi = noleggioDAO.readNoleggioUtente(currentUser.getId_u());			
			request.setAttribute("noleggi", noleggi);
	
			RequestDispatcher dispatcher = request.getRequestDispatcher("orderListView.jsp");
			dispatcher.forward(request, response);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
