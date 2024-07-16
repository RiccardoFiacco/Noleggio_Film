package mv.servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import mv.bean.Film;
import mv.bean.Noleggio;
import mv.bean.Utente;
import mv.dao.FilmDAO;
import mv.dao.NoleggioDAO;
import util.DbManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CatalogoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private FilmDAO filmDAO;
	private NoleggioDAO nDAO;

	public void init() throws ServletException { //appena usi la servlet viene utilizzato (chiami doGet ma prima va nell'init)
		try {
			DbManager dbManager = new DbManager();
			filmDAO = new FilmDAO(dbManager.getConnection());
			nDAO = new NoleggioDAO(dbManager.getConnection());
		} catch (SQLException e) {
			throw new ServletException(e);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			//con le altre non serviva la sessione, qui se andiamo nel catalogo ci serve perche abbiamo bisogno di capire se l'utente è loggato
			//in modo tale che puo noleggiare modificare o eliminare
			HttpSession s = request.getSession(false); //si mette false perche se non esiste non voglio crearla
			Utente u = null;
			ArrayList<Film> films = null;
			String ricerca = request.getParameter("ricerca") != null ? request.getParameter("ricerca") : "";

			if (s != null) { //se la sessione non esiste non creo neanche l'utente
				u = (Utente) s.getAttribute("currentSessionUser");
			}
			films = filmDAO.readFilmByRicerca(ricerca); //inserisci in films tutti i film filtrati
			
			if (u != null) {
				List<Integer> film_noleggiati = new ArrayList<Integer>();
				List<Noleggio> noleggi = null;

				//per ogni film di films controlla se quel film fa parte dei film noleggiati dagli utenti
	            for (Film f : films) 
	            {
					noleggi = nDAO.readNoleggioFilmUtente(f.getId_f(), u.getId_u());
					if (noleggi != null ) 
					{
						//se esiste noleggio film utente vado a vedere per ogni noleggio se l'utente ha restituito quel film
						for(Noleggio n : noleggi)
						{
							if(!n.isRestituito())
							{
								//se non resistuito lo mette nella lista film noleggiati 
								//nel catalogo.jsp mi fara apparire restituisci
								film_noleggiati.add(f.getId_f());
								System.out.println(f.getTitolo());
							}
						}
					}
				}
				request.setAttribute("filmNoleggiati", film_noleggiati);
			} 
			else 
			{
				films = filmDAO.readFilmByRicerca(ricerca);
			}
			request.setAttribute("films", films);//setti "films" con i films e questo andra in catalogo jsp
			request.getRequestDispatcher("catalogo.jsp").forward(request, response);
			//se usiamo response sendRedirect la request viene eliminata e nella list non avremmo film, 
			//se devi inviare qualcosa si usa la sessione o forward
			//request dispatcher invia la richiesta ad una nuova servlet o jsp
		} catch (SQLException e) {
			throw new ServletException(e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
