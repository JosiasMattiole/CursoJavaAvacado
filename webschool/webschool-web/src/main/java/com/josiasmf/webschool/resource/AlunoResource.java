package com.josiasmf.webschool.resource;

import com.josiasmf.webschool.model.Aluno;
import com.josiasmf.webschool.repository.AlunoRepository;
import com.josiasmf.webschool.service.AlunoService;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Josias
 */
@Path("alunos")
public class AlunoResource {
    
    @Inject
    private AlunoRepository repository;
    
    @Inject
    private AlunoService service;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        return Response.ok(repository.findAll()).build();
    }

    @GET
    @Path("/{id:[0-9][0-9]*}")
    @Produces(MediaType.APPLICATION_JSON)
    public Aluno findById(@PathParam("id") long id) {
        Aluno aluno = repository.findById(id);
        if (aluno == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return aluno;
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Aluno aluno) throws Exception {
        service.persist(aluno);
        return Response.status(Response.Status.CREATED).entity(aluno).build();
    }
}
