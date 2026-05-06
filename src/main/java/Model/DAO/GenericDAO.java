package Model.DAO;

import java.util.List;

public interface GenericDAO<T> {
    void insertar(T objeto);
    void modificar(T objeto);
    void eliminar(int id);
    T buscarPorId(int id);
    List<T> listarTodos();
}