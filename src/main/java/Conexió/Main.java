package Conexió;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {

        Connection prueba = JDBC.conectar();

        if (prueba != null) {
            System.out.println("Conectado");
        } else {
            System.out.println("Nop");
        }
    }
}
