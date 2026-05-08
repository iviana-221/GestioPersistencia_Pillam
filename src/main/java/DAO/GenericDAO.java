package DAO;

import java.util.List;

public interface GenericDAO<T> {

    void registrar(T t);

    void modificar(T t);

    void eliminar(int id);

    T buscarPerId(int id);

    List<T> llistarTots();
}