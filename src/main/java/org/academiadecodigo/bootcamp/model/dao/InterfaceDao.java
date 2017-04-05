package org.academiadecodigo.bootcamp.model.dao;


import java.sql.ResultSet;
import java.util.List;

/**
 * Created by Renato on 24/03/17.
 */
public interface InterfaceDao<T> {

    String getName();

    void create (T type);

    T readById(Integer id);

    void update(T type);

    void delete(T type);

    List<T> findAll();


    int count();
}
