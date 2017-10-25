package com.josiasmf.webschool.repository;

import com.josiasmf.webschool.model.Turma;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Josias
 */
@RequestScoped
public class TurmaRepository extends GenericRepository<Turma>{
    
    @Inject
    private EntityManager em;

    public TurmaRepository(EntityManager em) {
        super(em, Turma.class);
    }
    
    public Turma findById(Long id){
        return super.find(id);
    }

    public List<Turma> findAllByDescricao(){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Turma> criteria = cb.createQuery(Turma.class);
        Root<Turma> turma = criteria.from(Turma.class);
        criteria.select(turma).orderBy(cb.asc(turma.get("descricao")));
        return em.createQuery(criteria).getResultList();
    }
}
