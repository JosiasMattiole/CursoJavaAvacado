package com.josiasmf.landpage.service;

import com.josiasmf.landpage.model.Cliente;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author Josias
 */
@Stateless
public class ClienteService {
    
    @Inject
    private Logger log;

    @Inject
    private EntityManager em;
    
    public void persist(Cliente cliente) throws Exception {
        log.warning("Adicionando cliente ".concat(cliente.getNome()));
        em.merge(cliente);
        log.warning("Cliente ".concat(cliente.getNome()).concat(" adicionado com sucesso!"));
    }
}
