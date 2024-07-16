package mv.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mv.dao.FilmDAO;
import util.DbManager;

import java.io.IOException;
import java.sql.SQLException;

public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FilmDAO filmDAO;
	
    public UpdateServlet() {
        super();
    }

    public void init() throws ServletException {
        try 
        {
           DbManager dbManager = new DbManager();
           filmDAO = new FilmDAO(dbManager.getConnection());
        }
        catch (SQLException e) 
        {
            throw new ServletException(e);
        }
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		int id_f = Integer.parseInt(request.getParameter("id"));
		String titolo = request.getParameter("titolo");
		String descizione = request.getParameter("descrizione");
		String genere = request.getParameter("genere");
		double prezzo = Double.parseDouble(request.getParameter("prezzo"));
		String img = "img/" + request.getParameter("img") + ".jpg";
		boolean disp = Boolean.parseBoolean(request.getParameter("disp"));
		
		try {
			filmDAO.updateFilm(id_f, titolo, descizione, genere, prezzo, img, disp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("catalogo");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}


