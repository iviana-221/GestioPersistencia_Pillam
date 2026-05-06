package Model.DAO;

import Conexió.Conexio;
import Model.Via;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ViaDAO implements GenericDAO<Via> {
    private final Conexio gestorConexio = new Conexio();

    @Override
    public void insertar(Via v) {
        String sql = "INSERT INTO Vies (nom, grau, orientacio, estat, data_disponible, tipus_roca, restriccions, id_sector, id_creador) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = gestorConexio.getConexion();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, v.getNom());
            pstmt.setString(2, v.getGrau());
            pstmt.setString(3, v.getOrientacio());
            pstmt.setString(4, v.getEstat());
            pstmt.setTimestamp(5, Timestamp.valueOf(v.getData()));
            pstmt.setString(6, v.getTipusRoc());
            pstmt.setString(7, v.getRestriccions());
            pstmt.setInt(8, v.getIdSector());
            pstmt.setInt(9, v.getIdCreador());
            pstmt.executeUpdate();
        } catch (SQLException ex) { ex.printStackTrace(); }
    }

    @Override
    public List<Via> listarTodos() {
        List<Via> lista = new ArrayList<>();
        String sql = "SELECT * FROM Vies";
        try (Connection con = gestorConexio.getConexion();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                LocalDateTime fecha = rs.getTimestamp("data_disponible").toLocalDateTime();
                lista.add(new Via(
                        fecha, rs.getString("estat"), rs.getString("grau"),
                        rs.getInt("id_creador"), rs.getInt("id_sector"),
                        rs.getString("orientacio"), rs.getString("nom"),
                        rs.getString("restriccions"), rs.getString("tipus_roca")
                ));
            }
        } catch (SQLException ex) { ex.printStackTrace(); }
        return lista;
    }

    @Override public void modificar(Via v) {}
    @Override public void eliminar(int id) {}
    @Override public Via buscarPorId(int id) { return null; }
}