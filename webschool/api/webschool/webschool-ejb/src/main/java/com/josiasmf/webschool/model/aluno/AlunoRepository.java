package com.josiasmf.webschool.model.aluno;

import com.josiasmf.webschool.model.util.AbstractRepository;

public class AlunoRepository extends AbstractRepository<Aluno> {

    public AlunoRepository(final Aluno aluno) {
        super(Aluno.class);
    }
}
