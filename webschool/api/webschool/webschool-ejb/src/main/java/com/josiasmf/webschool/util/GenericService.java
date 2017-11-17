package com.josiasmf.webschool.util;

import com.josiasmf.webschool.model.Entidade;
import javax.persistence.EntityManager;

/**
 *
 * @author Josias
 * @param <T>
 */
public class GenericService<T extends Entidade> {
    
    private final EntityManager em;
    private final Class<T> type;

    public GenericService(EntityManager em, Class<T> type) {
        this.em = em;
        this.type = type;
    }

    public T insert(T bean) {
        em.persist(bean);
        return bean;
    }

    public T update(T bean) {
        return em.merge(bean);
    }

    public void delete(Long id) {
        T bean = em.getReference(type, id);
        em.remove(bean);
    }
}
