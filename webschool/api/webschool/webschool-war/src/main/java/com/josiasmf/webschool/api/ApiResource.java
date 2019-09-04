package com.josiasmf.webschool.api;

import com.josiasmf.webschool.model.aluno.AlunoResource;

import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Path;
import javax.ws.rs.core.Application;

/**
 * @author Josias
 */
@ApplicationPath("api")
public class ApiResource extends Application {

    @Inject
    private AlunoResource alunoResource;

    @Path("alunos")
    public AlunoResource getAlunoResource() {
        return alunoResource;
    }
}
