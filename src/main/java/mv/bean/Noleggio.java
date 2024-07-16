package mv.bean;
import java.sql.Date;

public class Noleggio {
	private int id_utente;
	private int id_film;
	private Date data_noleggio;
	private boolean restituito;
	
	public Noleggio() {
		super();
	}
	public Noleggio(int id_utente, int id_film, Date data_noleggio, boolean restituito) {
		super();
		this.id_utente = id_utente;
		this.id_film = id_film;
		this.data_noleggio = data_noleggio;
		this.restituito = restituito;
	}
	public int getId_utente() {
		return id_utente;
	}
	public void setId_utente(int id_utente) {
		this.id_utente = id_utente;
	}
	public int getId_film() {
		return id_film;
	}
	public void setId_film(int id_film) {
		this.id_film = id_film;
	}
	public Date getData_noleggio() {
		return data_noleggio;
	}
	public void setData_noleggio(Date data_noleggio) {
		this.data_noleggio = data_noleggio;
	}
	public boolean isRestituito() {
		return restituito;
	}
	public void setRestituito(boolean restituito) {
		this.restituito = restituito;
	}
	
	
}
