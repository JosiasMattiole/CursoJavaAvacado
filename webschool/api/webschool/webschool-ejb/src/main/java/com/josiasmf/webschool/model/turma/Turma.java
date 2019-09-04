package com.josiasmf.webschool.model.turma;

import com.josiasmf.webschool.model.util.AbstractEntity;
import com.josiasmf.webschool.model.aluno.Aluno;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static javax.persistence.CascadeType.ALL;

/**
 *
 * @author Josias
 */
@Entity
@Table(name = "TURMAS", schema = "webschool")
public class Turma implements AbstractEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;
    
    @NotNull
    @Column(name = "ANO_ESCOLAR", nullable = false)
    private int anoEscolar;
    
    @NotNull
    @Column(name = "DESCRICAO", length = 100, nullable = false)
    private String descricao;
    
    @OneToMany(cascade = ALL, mappedBy = "turma", fetch = FetchType.LAZY)
    private List<Aluno> alunos = new ArrayList<>();
    
    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAnoEscolar() {
        return anoEscolar;
    }

    public void setAnoEscolar(int anoEscolar) {
        this.anoEscolar = anoEscolar;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Turma other = (Turma) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
