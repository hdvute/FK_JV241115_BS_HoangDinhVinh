package ra.bussiness.dao;

import java.util.List;

public interface IGenericDao<T,E> {
    List<T> findAll();
    T findById(E id);
    void save(T entity);
    void deleteById(E id);
}
