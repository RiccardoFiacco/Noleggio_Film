package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import java.util.Properties;

public class DbManager {
    private Connection connection;

    public DbManager() throws SQLException { 
        try {           
            //String JDBC_DRIVER ="com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/movie_rental";
            String user = "root";
            String password = "";          
			//Class.forName(JDBC_DRIVER);
			connection=DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            throw new SQLException("Errore di connessione al database", e);
        }
    }

    public Connection getConnection() { 
        return connection;
    }

    public void close() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
