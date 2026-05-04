package DAO;

import Conexió.Conexio;
import Conexió.IConexio;
import Model.Via;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ViaDAO implements GenericDAO<Via> {
    private final IConexio gestorConexio = new Conexio();

    @Override
    public void insertar(Via v) {
        String sql = "INSERT INTO vies (nom, dificultat, sector_id) VALUES (?, ?, ?)";
        try (Connection con = gestorConexio.getConexion();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, v.getNom());
            pstmt.setString(2, v.getDificultat());
            pstmt.setInt(3, v.getSectorId());
            pstmt.executeUpdate();
            System.out.println("✅ Via registrada!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Via> listarTodos() {
        List<Via> lista = new ArrayList<>();
        String sql = "SELECT * FROM vies";
        try (Connection con = gestorConexio.getConexion();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Via(rs.getInt("id"), rs.getString("nom"), rs.getString("dificultat"), rs.getInt("sector_id")));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    @Override public void modificar(Via v) {}
    @Override public void eliminar(int id) {}
    @Override public Via buscarPorId(int id) { return null; }
}