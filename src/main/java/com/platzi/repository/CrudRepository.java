package com.platzi.repository;

import java.util.List;

public interface CrudRepository<T> {
    List<T> findAll();

    T getById(Integer id);

    void save(T t);

    void delete(Integer id);

    void update(T t, Integer id);
}
