package com.josiasmf.webschool.service;

import static javax.ejb.TransactionAttributeType.REQUIRED;
import static javax.ejb.TransactionAttributeType.SUPPORTS;

import com.josiasmf.webschool.model.Aluno;
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
public class AlunoService {
    
    @Inject
    private GenericService<Aluno> service;
    
    @TransactionAttribute(REQUIRED)
    public Aluno insert(@Valid Aluno aluno) {
        return service.insert(aluno);
    }
    
    @TransactionAttribute(REQUIRED)
    public Aluno update(@Valid Aluno aluno) {
        return service.update(aluno);
    }
    
    @TransactionAttribute(REQUIRED)
    public void delete(@Valid Long id) {
        service.delete(id);
    }
}
