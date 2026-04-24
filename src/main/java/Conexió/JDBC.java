package Conexió;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Dos tipos de conexiones necesarias(mysql y otra como postgres)
//Menús
//Conexion por operacion.
//DAO

//Sobre el readme:
//Descripcion del proyecto
//Como hemos planteado la estructura
//La arquitectura de como lo hemos montado
//Como hemos planteado las conexiones y el menú
//Contras o problemas que se han tenido

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