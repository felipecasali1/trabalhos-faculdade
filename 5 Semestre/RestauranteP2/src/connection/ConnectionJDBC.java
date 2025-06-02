package connection;

import java.sql.*;

public class ConnectionJDBC {
    private static Connection connection;
    private static ConnectionJDBC instance;
    private static final String URL = "jdbc:postgresql://localhost:5432/bancorestaurante";
    private static final String USER = "postgres";
    private static final String PASSWORD = "1234";

    private ConnectionJDBC() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static synchronized ConnectionJDBC getInstance() {
        if (instance == null) {
            instance = new ConnectionJDBC();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
                instance = null;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
