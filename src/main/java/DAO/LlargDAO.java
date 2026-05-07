package DAO;

import Conexio.Conexio;
import Model.Llarg;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LlargDAO implements GenericDAO<Llarg> {
    private final Conexio gestorConexio = new Conexio();

    public void insertarLlarg(Llarg l, int idVia) {
        String sql = "INSERT INTO Llargs (numero, metres, grau, id_via) VALUES (?, ?, ?, ?)";
        try (Connection con = gestorConexio.getConexion();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, l.getNumero());
            pstmt.setInt(2, l.getMetres());
            pstmt.setString(3, l.getGrau());
            pstmt.setInt(4, idVia);
            pstmt.executeUpdate();
        } catch (SQLException ex) { ex.printStackTrace(); }
    }

    @Override
    public List<Llarg> listarTodos() {
        List<Llarg> lista = new ArrayList<>();
        String sql = "SELECT * FROM Llargs";
        try (Connection con = gestorConexio.getConexion();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Llarg(rs.getInt("numero"), rs.getInt("metres"), rs.getString("grau")));
            }
        } catch (SQLException ex) { ex.printStackTrace(); }
        return lista;
    }

    @Override public void insertar(Llarg l) {}
    @Override public void modificar(Llarg l) {}
    @Override public void eliminar(int id) {}
    @Override public Llarg buscarPorId(int id) { return null; }
}