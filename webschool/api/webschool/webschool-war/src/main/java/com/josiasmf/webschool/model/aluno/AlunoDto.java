package com.josiasmf.webschool.model.aluno;

import com.josiasmf.webschool.model.turma.Turma;
import com.josiasmf.webschool.model.util.AbstractBuilder;
import com.josiasmf.webschool.model.util.AbstractRepresentationBuilder;
import java.util.LinkedHashMap;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Josias
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class AlunoDto {

    private Long id;
    private String nome;
    private String matricula;
    private Turma turma;
    private LinkedHashMap<String, String> links;

    protected AlunoDto() {
    }

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

    public LinkedHashMap<String, String> getLinks() {
        return links;
    }

    public static class Builder extends AbstractBuilder<AlunoDto, Builder> {

        private Builder(final AlunoDto dto) {
            super(dto);
        }

        public static Builder create() {
            return new Builder(new AlunoDto());
        }

        public static Builder from(final AlunoDto dto) {
            return new Builder(dto);
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

        public Builder links(final LinkedHashMap<String, String> links) {
            entity.links = links;
            return this;
        }
    }

    public static class RepresentationBuilder extends AbstractRepresentationBuilder<Aluno, AlunoDto, Aluno.Builder> {

        @Override
        public Aluno fromRepresentation(final AlunoDto dto, Aluno.Builder builder) {
            return builder
                    .id(dto.getId())
                    .nome(dto.getNome())
                    .matricula(dto.getMatricula())
                    .turma(dto.getTurma())
                    .build();
        }

        @Override
        public AlunoDto toRepresentation(final Aluno aluno) {
            return AlunoDto.Builder.create()
                    .id(aluno.getId())
                    .nome(aluno.getNome())
                    .matricula(aluno.getMatricula())
                    .turma(aluno.getTurma())
//                    .links()
                    .build();
        }
    }
}
