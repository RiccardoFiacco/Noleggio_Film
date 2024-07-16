package mv.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mv.dao.FilmDAO;
import util.DbManager;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Servlet implementation class EliminaServlet
 */
public class EliminaServlet extends HttpServlet 
{
	 private static final long serialVersionUID = 1L;
	    private FilmDAO filmDAO;

	    public void init() throws ServletException {
	        try {
	           DbManager dbManager = new DbManager();
	           filmDAO = new FilmDAO(dbManager.getConnection());
	        }catch (SQLException e) {
	            throw new ServletException(e);
	        }
	    }


	    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	    		throws ServletException, IOException 
	    {
	        int id = Integer.parseInt(request.getParameter("id")); 
	        try {
	            filmDAO.deleteFilm(id);
	            response.sendRedirect("catalogo");
	        }catch (SQLException e) {
	            throw new ServletException(e);
	        }
	    }


	    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	    		throws ServletException, IOException 
	    {
	        // TODO Auto-generated method stub
	        doGet(request, response);
	    }

}
