package com.josiasmf.webschool.dto;

import java.util.LinkedHashMap;

/**
 *
 * @author Josias
 */
public class AlunoDto {
    
    private Long id;
    private String nome;
    private String matricula;
    private LinkedHashMap<String, String> links;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    
//    public class Builder extends Bui
}
