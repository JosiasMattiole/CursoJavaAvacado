package com.josiasmf.webschool.service;

import com.josiasmf.webschool.model.Aluno;
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
public class AlunoService {
    
    @Inject
    private Logger log;
    
    @Inject
    private GenericRepository<Aluno> repository;

    public List<Aluno> findAll(){
        return repository.findAll();
    }
    
    public Aluno findById(Long id){
        return repository.find(id);
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void create(@Valid Aluno aluno) {
        log.warning("Adicionando aluno ".concat(aluno.getNome()));
        repository.insert(aluno);
        log.warning("Aluno ".concat(aluno.getNome()).concat(" adicionado com sucesso!"));
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void update(@Valid Aluno aluno) {
        log.warning("Atualizando aluno ".concat(aluno.getNome()));
        repository.update(aluno);
        log.warning("Aluno ".concat(aluno.getNome()).concat(" atualizado com sucesso!"));
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void delete(@Valid Aluno aluno) {
        log.warning("Excluindo aluno ".concat(aluno.getNome()));
        repository.delete(aluno.getId());
        log.warning("Aluno ".concat(aluno.getNome()).concat(" removido com sucesso!"));
    }
}
