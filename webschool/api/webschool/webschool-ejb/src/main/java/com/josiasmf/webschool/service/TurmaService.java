package com.josiasmf.webschool.service;

import static javax.ejb.TransactionAttributeType.REQUIRED;
import static javax.ejb.TransactionAttributeType.SUPPORTS;

import com.josiasmf.webschool.model.Turma;
import com.josiasmf.webschool.util.GenericService;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.inject.Inject;
import javax.validation.Valid;

/**
 *
 * @author Josias
 */
@Stateless
@TransactionAttribute(SUPPORTS)
public class TurmaService {
    
    @Inject
    private GenericService<Turma> service;
    
    @TransactionAttribute(REQUIRED)
    public Turma insert(@Valid Turma turma) {
        return service.insert(turma);
    }
    
    @TransactionAttribute(REQUIRED)
    public Turma update(@Valid Turma turma) {
        return service.update(turma);
    }
    
    @TransactionAttribute(REQUIRED)
    public void delete(@Valid Long id) {
        service.delete(id);
    }
}
