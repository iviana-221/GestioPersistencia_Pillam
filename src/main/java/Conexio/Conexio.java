package Conexio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexio implements IConexio {
    private static final String URL = "jdbc:mysql://localhost:3306/pillam_db";
    private static final String USER = "root";
    private static final String PASS = "P@ssw0rd";

    @Override
    public Connection getConexion() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}