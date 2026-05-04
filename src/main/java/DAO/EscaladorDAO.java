package DAO;

import Conexió.Conexio;
import Conexió.IConexio;
import Model.Escalador;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EscaladorDAO implements GenericDAO<Escalador> {

    private final IConexio gestorConexio = new Conexio();

    @Override
    public void insertar(Escalador e) {
        String sql = "INSERT INTO escaladors (nom, edat) VALUES (?, ?)";

        try (Connection con = gestorConexio.getConexion();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setString(1, e.getNom());
            pstmt.setInt(2, e.getEdat());
            pstmt.executeUpdate();

            System.out.println("✅ Escalador guardat correctament!");

        } catch (SQLException ex) {
            System.out.println("❌ Error al insertar: " + ex.getMessage());
        }
    }

    @Override
    public List<Escalador> listarTodos() {
        List<Escalador> lista = new ArrayList<>();
        String sql = "SELECT * FROM escaladors";

        try (Connection con = gestorConexio.getConexion();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Escalador e = new Escalador(
                        rs.getString("alias"),rs.getInt("edat"), rs.getString("nivellMaxim"),rs.getString("nacionalitat")
                );
                lista.add(e);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    @Override public void modificar(Escalador e) {  }
    @Override public void eliminar(int id) { }
    @Override public Escalador buscarPorId(int id) { return null; }
}