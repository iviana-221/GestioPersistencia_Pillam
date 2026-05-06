package Model.DAO;

import Conexió.Conexio;
import Model.Escalador;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EscaladorDAO implements GenericDAO<Escalador> {
    private final Conexio gestorConexio = new Conexio();

    @Override
    public void insertar(Escalador e) {
        String sql = "INSERT INTO Escaladors (nom, alias, edat, nivell_maxim, nacionalitat) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = gestorConexio.getConexion();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, e.getNom());
            pstmt.setString(2, e.getAlias());
            pstmt.setInt(3, e.getEdat());
            pstmt.setString(4, e.getNivellMaxim());
            pstmt.setString(5, e.getNacionalitat());
            pstmt.executeUpdate();
            System.out.println("Escalador guardat!");
        } catch (SQLException ex) { ex.printStackTrace(); }
    }

    @Override
    public List<Escalador> listarTodos() {
        List<Escalador> lista = new ArrayList<>();
        String sql = "SELECT * FROM Escaladors";
        try (Connection con = gestorConexio.getConexion();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Escalador e = new Escalador(
                        rs.getString("alias"), rs.getInt("edat"),
                        rs.getString("nivell_maxim"), rs.getString("nom"),
                        rs.getString("nacionalitat")
                );
                e.setId(rs.getInt("id"));
                lista.add(e);
            }
        } catch (SQLException ex) { ex.printStackTrace(); }
        return lista;
    }

    @Override public void modificar(Escalador e) {



    }
    @Override public void eliminar(int id) {  }
    @Override public Escalador buscarPorId(int id) { return null; }
}