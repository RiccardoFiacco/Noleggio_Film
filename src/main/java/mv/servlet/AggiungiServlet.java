package mv.servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mv.dao.FilmDAO;
import util.DbManager;
import java.io.IOException;
import java.sql.SQLException;

public class AggiungiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AggiungiServlet() {
        super();    
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request, contiene tutto quello che abbiamo passato con il form
		String titolo = request.getParameter("titolo");
		String descrizione = request.getParameter("descrizione");
		String genere = request.getParameter("genere");
		double prezzo = Double.parseDouble(request.getParameter("prezzo"));
		String img = "img/" + request.getParameter("img") + ".jpg";
		boolean disp = Boolean.parseBoolean(request.getParameter("disp"));
		
		try{
			//crei un'istanza di dbmanager, crea la connessione e la passi all'istanza dao che la usera 
			//per i preparedstatement e statement
			DbManager dm = new DbManager();
			FilmDAO fDAO = new FilmDAO(dm.getConnection());
			fDAO.createFilm(titolo, descrizione, genere, prezzo, img, disp);
			response.sendRedirect("catalogo"); //vai a dire dove inviare la risposta e reindirizza a determinata pagina
		
		} catch (SQLException e) {
			throw new ServletException(e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
