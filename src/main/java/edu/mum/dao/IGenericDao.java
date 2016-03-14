package edu.mum.dao;

import java.util.List;

public interface IGenericDao<T, PK> {
    List<T> findAll(Class<T> entityClass);

    T findById(PK id, Class<T> entityClass);

    T create(T t);

    T update(T t);

    void delete(T t);
    
    T load(PK id, Class<T> entityClass);
}
