package com.josiasmf.atividadearquetipo.data;

import com.josiasmf.atividadearquetipo.model.Aluno;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Josias
 */
public class AlunoRepository {
    
    private List<Aluno> alunos = new ArrayList<>();
    private long nextId = 0;
    
    
    public List<Aluno> findAll(int offset, int limit, String sort) {
        return alunos;
    }
    
    public Aluno findById(long matricula) {
        for (Aluno aluno : alunos) {
            if (aluno.getMatricula().equals(matricula))
                return aluno;
        }
        return null;
    }
    
    public void insert(Aluno aluno) {
        aluno.setMatricula(++nextId);
        alunos.add(aluno);
    }
    
    public void update(long matricula, Aluno aluno) {
        for (int i = 0; i < alunos.size(); i++) {
            if (alunos.get(i).getMatricula().equals(matricula)) {
                alunos.set(i, aluno);
                return;
            }
        }
    }
    
    public void delete(long matricula) {
        Aluno selecionado = null;
        for (int i = 0; i < alunos.size(); i++) {
            if (alunos.get(i).getMatricula().equals(matricula)) {
                selecionado = alunos.get(i);
                break;
            }
        }
        if (selecionado != null)
            alunos.remove(selecionado);
    }
}
