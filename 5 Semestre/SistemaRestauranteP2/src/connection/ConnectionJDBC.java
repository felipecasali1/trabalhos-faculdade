package connection;

import java.sql.*;

public class ConnectionJDBC {
    private final String url = "jdbc:postgresql://localhost:5432/bancorestaurante";
    private final String user = "postgres";
    private final String password = "1234";
    
    public Connection createConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}
