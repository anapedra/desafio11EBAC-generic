package org.anasantana.dao;

import java.util.List;
import java.util.Optional;

public interface GenericDAO<T, ID> {
    List<T> findAll();
    Optional<T> findById(ID id);
    T save(T entity);
    List<T> saveAll(List<T> entities);
    void deleteById(ID id);
    void delete(T entity);
    void deleteAll();
    boolean existsById(ID id);
    long count();
}
