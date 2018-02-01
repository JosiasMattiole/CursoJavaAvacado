package com.josiasmf.webschool.util;

import com.josiasmf.webschool.model.Entidade;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author Josias
 * @param <T>
 */
public class GenericRepository<T extends Entidade> {

    private final EntityManager em;
    private final Class<T> type;

    public GenericRepository(EntityManager em, Class<T> type) {
        this.em = em;
        this.type = type;
    }

    public List<T> findAll() {
        return em.createQuery(createCriteriaQuery()).getResultList();
    }

    private CriteriaQuery<T> createCriteriaQuery() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<T> query = cb.createQuery(type);
        query.from(type);
        return query;
    }

    public T find(Long id) {
        return em.find(type, id);
    }
}
