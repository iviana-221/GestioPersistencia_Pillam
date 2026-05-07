package DAO;

import Conexio.Conexio;
import Model.Sector;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SectorDAO implements GenericDAO<Sector> {
    private final Conexio gestorConexio = new Conexio();

    @Override
    public void insertar(Sector s) {
        String sql = "INSERT INTO Sectors (nom, id_escola, latitud, longitud, aproximacio, popularitat, restriccions) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = gestorConexio.getConexion();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, s.getNom());
            pstmt.setInt(2, s.getIdEscola());
            pstmt.setDouble(3, s.getLatitud());
            pstmt.setDouble(4, s.getLongitud());
            pstmt.setString(5, s.getAproximacio());
            pstmt.setString(6, s.getPopularitat());
            pstmt.setString(7, s.getRestriccions());
            pstmt.executeUpdate();
            System.out.println("Sector guardat");
        } catch (SQLException ex) { ex.printStackTrace(); }
    }

    @Override
    public List<Sector> listarTodos() {
        List<Sector> lista = new ArrayList<>();
        String sql = "SELECT * FROM Sectors";
        try (Connection con = gestorConexio.getConexion();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Sector s = new Sector(
                        rs.getString("nom"), rs.getInt("id_escola"),
                        rs.getDouble("latitud"), rs.getDouble("longitud"),
                        rs.getString("aproximacio"), rs.getString("popularitat"),
                        rs.getString("restriccions")
                );
                s.setId(rs.getInt("id"));
                lista.add(s);
            }
        } catch (SQLException ex) { ex.printStackTrace(); }
        return lista;
    }

    @Override public void modificar(Sector s) {}
    @Override public void eliminar(int id) {}
    @Override public Sector buscarPorId(int id) { return null; }
}