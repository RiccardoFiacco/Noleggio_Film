package mv.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import mv.bean.Utente;

public class UtenteDAO {
	private Connection connection;

	public UtenteDAO(Connection connection) {
		this.connection = connection;
	}

	public void createUtente(String nome, String cognome, String username, String password, boolean ruolo)
			throws SQLException {
		String query = "INSERT INTO utente (nome, cognome, username, passw, ruolo) VALUES (?, ?, ?, ?, ?)";
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setString(1, nome);
			stmt.setString(2, cognome);
			stmt.setString(3, username);
			stmt.setString(4, password);
			stmt.setBoolean(5, ruolo);
			stmt.executeUpdate();
		}
	}

	public List<Utente> readUtenti() throws SQLException {
		List<Utente> utenti = new ArrayList<>();
		String query = "SELECT * FROM utente";
		try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
			while (rs.next()) {
				Utente utente = new Utente();
				utente.setId_u(rs.getInt("id_u"));
				utente.setNome(rs.getString("nome"));
				utente.setCognome(rs.getString("cognome"));
				utente.setUsername(rs.getString("username"));
				utente.setPassword(rs.getString("password"));
				utente.setRuolo(rs.getBoolean("ruolo"));
				utenti.add(utente);
			}
		}

		return utenti;
	}

	public void updateUtente(int id, String nome, String cognome, String username, String password, boolean ruolo)
			throws SQLException {
		String query = "UPDATE utente SET nome = ?, cognome = ?, username = ?, passw = ?, ruolo = ? WHERE id_u = ?";
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setString(1, nome);
			stmt.setString(2, cognome);
			stmt.setString(3, username);
			stmt.setString(4, password);
			stmt.setBoolean(5, ruolo);
			stmt.executeUpdate();
		}
	}

	public void deleteUtente(int id) throws SQLException {
		String query = "DELETE FROM utente WHERE id_u = ?";
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setInt(1, id);
			stmt.executeUpdate();
		}
	}

	public Utente readUtente(Utente u) throws SQLException {
		String query = "SELECT * FROM utente WHERE username = ? and passw = ?  ";
		ResultSet rs = null;
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setString(1, u.getUsername());
			stmt.setString(2, u.getPassword());
			rs = stmt.executeQuery();

			if (!rs.next()) {// da il primo risultato disponibile nel risultato, se vuoto allora non c'è
								// niente
				u.setValid(false);
			} else {
				u.setId_u(rs.getInt("Id_u"));
				u.setNome(rs.getString("nome"));
				u.setCognome(rs.getString("cognome"));
				u.setRuolo(rs.getBoolean("ruolo"));
				u.setValid(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rs.close();
		}

		return u;
	}
}
