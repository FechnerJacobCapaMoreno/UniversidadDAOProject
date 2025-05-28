package dao;

import java.util.List;

public interface IBaseDAO<T> {
    void insertar(T obj);
    void actualizar(T obj);
    void eliminar(int id);
    T obtenerPorId(int id);
    List<T> obtenerTodos();
}
