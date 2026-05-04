package Conexió;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        // 1. Usamos la Interface (IConexio) para apuntar al objeto (Conexio)
        // Esto es "Polimorfismo" y "Desacoplamiento".
        IConexio gestor = new Conexio();

        System.out.println("--- PROVA DE CONNEXIÓ ---");

        // 2. Usamos try-with-resources para que la conexión se cierre SOLA
        // Esto es lo que el profe llama "Conexión por operación"
        try (Connection prueba = gestor.getConexion()) {

            if (prueba != null && !prueba.isClosed()) {
                System.out.println("Estat: Connectat correctament!");
                System.out.println("Base de dades: " + prueba.getCatalog());
            }

        } catch (SQLException e) {
            // 3. Si el MySQL está apagado o la contraseña mal, saltará aquí
            System.out.println("Error de connexió " + e.getMessage());
            // El e.printStackTrace() es útil para ver la línea exacta del error
            e.printStackTrace();
        }

        System.out.println("--- FI DE LA PROVA ---");
    }
}