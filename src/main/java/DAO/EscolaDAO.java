package DAO;

import Conexió.Conexio;
import Model.Escola;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EscolaDAO implements GenericDAO<Escola> {
    private final Conexio gestorConexio = new Conexio();

    @Override
    public void insertar(Escola e) {
        String sql = "INSERT INTO Escoles (nom, poblacio, aproximacio, popularitat) VALUES (?, ?, ?, ?)";
        try (Connection con = gestorConexio.getConexion();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, e.getNom());
            pstmt.setString(2, e.getPoblacio());
            pstmt.setString(3, e.getAproximacio());
            pstmt.setString(4, e.getPopularitat());
            pstmt.executeUpdate();
        } catch (SQLException ex) { ex.printStackTrace(); }
    }

    @Override
    public List<Escola> listarTodos() {
        List<Escola> lista = new ArrayList<>();
        String sql = "SELECT * FROM Escoles";
        try (Connection con = gestorConexio.getConexion();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Escola(
                        rs.getString("aproximacio"), rs.getInt("id"),
                        rs.getString("nom"), rs.getString("poblacio"),
                        rs.getString("popularitat")
                ));
            }
        } catch (SQLException ex) { ex.printStackTrace(); }
        return lista;
    }

    @Override public void modificar(Escola e) {}
    @Override public void eliminar(int id) {}
    @Override public Escola buscarPorId(int id) { return null; }
}