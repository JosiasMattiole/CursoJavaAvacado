package com.josiasmf.landpage.repository;

import com.josiasmf.landpage.model.Cliente;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Josias
 */
@RequestScoped
public class ClienteRepository {

    @Inject
    private EntityManager em;

    public Cliente findById(Long id) {
        return em.find(Cliente.class, id);
    }

    public List<Cliente> findAll() {
        TypedQuery<Cliente> query = em.createQuery("select c from Cliente c", Cliente.class);
        return query.getResultList();
    }
}
