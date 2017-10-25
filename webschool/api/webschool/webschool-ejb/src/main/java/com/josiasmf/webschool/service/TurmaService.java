package com.josiasmf.webschool.service;

import com.josiasmf.webschool.model.Turma;
import com.josiasmf.webschool.repository.GenericRepository;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.validation.Valid;

/**
 *
 * @author Josias
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class TurmaService {

    @Inject
    private Logger log;

    @Inject
    private GenericRepository<Turma> repository;

    public List<Turma> findAll(){
        return repository.findAll();
    }
    
    public Turma findById(Long id){
        return repository.find(id);
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void create(@Valid Turma turma) {
        log.warning("Adicionando turma ".concat(turma.getDescricao()));
        repository.insert(turma);
        log.warning("Turma ".concat(turma.getDescricao()).concat(" adicionada com sucesso!"));
    }

    public void update(@Valid Turma turma) {
        log.warning("Atualizando turma ".concat(turma.getDescricao()));
        repository.update(turma);
        log.warning("Turma ".concat(turma.getDescricao()).concat(" atualizada com sucesso!"));
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void delete(@Valid Turma turma) {
        log.warning("Excluindo turma ".concat(turma.getDescricao()));
        repository.delete(turma.getId());
        log.warning("Turma ".concat(turma.getDescricao()).concat(" removida com sucesso!"));
    }
}
