package mv.bean;

public class Utente {
	private int id_u;
	private String nome;
	private String cognome;
	private String username;
	private String password;
	private boolean ruolo;
	private boolean valid; //usato per vedere se l'utente esiste nel db
	public Utente() {
		super();
	}

	public Utente(int id_u, String nome, String cognome, String username, String password, boolean ruolo) {
		super();
		this.id_u = id_u;
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		this.password = password;
		this.ruolo = ruolo;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isRuolo() {
		return ruolo;
	}
	public void setRuolo(boolean ruolo) {
		this.ruolo = ruolo;
	}

	public int getId_u() {
		return id_u;
	}

	public void setId_u(int id_u) {
		this.id_u = id_u;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}
	
}
