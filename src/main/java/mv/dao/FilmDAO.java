package mv.dao;

import java.sql.*;
import java.util.ArrayList;


import mv.bean.Film;

public class FilmDAO { 
	private Connection connection;

	public FilmDAO(Connection connection) { 											
		this.connection = connection;		
	}

	public void createFilm(String titolo, String descrizione, String genere, Double prezzo, String img, boolean disponibile)
			throws SQLException {
		String query = "INSERT INTO film (titolo, descrizione, genere, prezzo, img, disponibile) VALUES (?, ?, ?, ?, ?, ?)";
		try (PreparedStatement stmt = connection.prepareStatement(query)) { 		
			stmt.setString(1, titolo);
			stmt.setString(2, descrizione);
			stmt.setString(3, genere);
			stmt.setDouble(4, prezzo);
			stmt.setString(5, img);
			stmt.setBoolean(6, disponibile);
			stmt.executeUpdate();
		}
	}

	public ArrayList<Film> readFilm() throws SQLException {
		ArrayList<Film> films = new ArrayList<>();
		String query = "SELECT * FROM film";				
		try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
			while (rs.next()) {
				Film film = new Film();
				film.setId_f(rs.getInt("id_f"));
				film.setTitolo(rs.getString("titolo"));
				film.setDescrizione(rs.getString("descrizione"));
				film.setGenere(rs.getString("genere"));
				film.setPrezzo(rs.getDouble("prezzo"));
				film.setImg(rs.getString("img"));
				film.setDisponibile(rs.getBoolean("disponibile"));
				films.add(film);
			}
		}

		return films;
	}

	public Film readFilmById(int id) throws SQLException {
		Film film = null;
		String query = "SELECT * FROM film where id_f = ?";
		try (PreparedStatement stmt = connection.prepareStatement(query))
		{
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				film = new Film();
				film.setId_f(rs.getInt("id_f"));
				film.setTitolo(rs.getString("titolo"));
				film.setDescrizione(rs.getString("descrizione"));
				film.setGenere(rs.getString("genere"));
				film.setPrezzo(rs.getDouble("prezzo"));
				film.setImg(rs.getString("img"));
				film.setDisponibile(rs.getBoolean("disponibile"));
			}
		}

		return film;
	}
	
	public ArrayList<Film> readFilmByRicerca(String ricerca) throws SQLException{
		ArrayList<Film> films = new ArrayList<>();
		
		Film film = null;
		String query = "SELECT * FROM film where titolo like ? or genere like ?";
		String ricercaPattern = "%"+ricerca+"%";
		try(PreparedStatement stmt = connection.prepareStatement(query)){
			stmt.setString(1, ricercaPattern);
			stmt.setString(2, ricercaPattern);
			ResultSet rs= stmt.executeQuery();
			
			while(rs.next()) {
				film= new Film();
				film.setId_f(rs.getInt("id_f"));
				film.setTitolo(rs.getString("titolo"));
				film.setDescrizione(rs.getString("descrizione"));
				film.setGenere(rs.getString("genere"));
				film.setPrezzo(rs.getDouble("prezzo"));
				film.setImg(rs.getString("img"));
				film.setDisponibile(rs.getBoolean("disponibile"));
				films.add(film);
			}
		}
		return films;
	}
	
	
	
	
	public void updateFilm(int id, String titolo, String descrizione, String genere, Double prezzo, String img, boolean disponibile)
			throws SQLException {
		String query = "UPDATE film SET titolo = ?, descrizione = ?, genere = ?, prezzo = ?, img = ?, disponibile = ? WHERE id_f = ?";
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setString(1, titolo);
			stmt.setString(2, descrizione);
			stmt.setString(3, genere);
			stmt.setDouble(4, prezzo);
			stmt.setString(5, img);
			stmt.setBoolean(6, disponibile);
			stmt.setInt(7, id);
			stmt.executeUpdate();
		}
	}

	public void deleteFilm(int id) throws SQLException {
		String query = "UPDATE film SET disponibile = false WHERE id_f = ?"; 
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setInt(1, id);
			stmt.executeUpdate();
		}
	}
}