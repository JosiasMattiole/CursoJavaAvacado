package com.josiasmf.webschool.service;

import com.josiasmf.webschool.model.Aluno;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author Josias
 */
@Stateless
public class AlunoService {
    
    @Inject
    private Logger log;

    @Inject
    private EntityManager em;
    
    public void persist(Aluno aluno) throws Exception {
        log.warning("Adicionando aluno ".concat(aluno.getNome()));
        em.merge(aluno);
        log.warning("Aluno ".concat(aluno.getNome()).concat(" adicionado com sucesso!"));
    }
}
