package com.josiasmf.webschool.model.util;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @param <T>
 * @author Josias
 */
public abstract class AbstractService<T> {

    @PersistenceContext
    protected EntityManager em;

    public void persist(T t) {
        em.persist(t);
    }

    public T merge(T t) {
        return em.merge(t);
    }

    public void remove(T t) {
        em.remove(t);
    }
}
