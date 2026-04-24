package Conexió;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Dos tipos de conexiones necesarias(mysql y otra como postgres)
//Menús
//Conexion por operacion.


public class JDBC {
    private static final String URL = "jdbc:mysql://localhost:3306/pillam_db";
    private static final String USER = "root";
    private static final String PASS = "P@ssw0rd";

    public static Connection conectar() {
        try {
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            System.out.println("Error ");
            e.printStackTrace();
            return null;
        }
    }
}