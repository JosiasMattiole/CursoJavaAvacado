package com.josiasmf.webschool.model.aluno;

import com.josiasmf.webschool.model.util.AbstractEntity;
import com.josiasmf.webschool.model.turma.Turma;
import com.josiasmf.webschool.model.util.AbstractBuilder;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *
 * @author Josias
 */
@Entity
@Table(name = "ALUNOS", schema = "webschool")
public class Aluno implements AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @NotNull
    @Size(min = 1, max = 25)
    @Pattern(regexp = "[^0-9]*", message = "Não é permitido números")
    @Column(name = "NOME", length = 80, nullable = false)
    private String nome;

    @NotNull
    @Column(name = "MATRICULA", length = 15, nullable = false)
    private String matricula;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "turma_id")
    private Turma turma;

    @Override
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public Turma getTurma() {
        return turma;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.id);
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
        final Aluno other = (Aluno) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public static class Builder extends AbstractBuilder<Aluno, Builder> {

        private Builder(final Aluno aluno) {
            super(aluno);
        }

        public static Builder create() {
            return new Builder(new Aluno());
        }

        public static Builder from(final Aluno aluno) {
            return new Builder(aluno);
        }

        public Builder id(final Long id) {
            entity.id = id;
            return this;
        }

        public Builder nome(final String nome) {
            entity.nome = nome;
            return this;
        }

        public Builder matricula(final String matricula) {
            entity.matricula = matricula;
            return this;
        }

        public Builder turma(final Turma turma) {
            entity.turma = turma;
            return this;
        }
    }
}
