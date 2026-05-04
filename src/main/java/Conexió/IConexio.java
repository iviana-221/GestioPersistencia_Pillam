package Conexió;

import java.sql.Connection;
import java.sql.SQLException;

public interface IConexio {
    Connection getConexion() throws SQLException;
}
