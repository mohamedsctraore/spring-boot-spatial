package com.mohamedsctraore.spatial.service;

import java.util.List;

/**
 * @author Mohamed Traore
 */
public interface CrudService<T, ID> {
    /**
     *
     * @param object
     * @return
     */
    T save(T object);

    /**
     *
     * @param object
     */
    void delete(T object);

    /**
     *
     * @param object
     * @return
     */
    T update(T object);

    /**
     *
     * @param id
     * @return
     */
    T findOne(ID id);

    /**
     *
     * @return
     */
    List<T> findAll();
}
