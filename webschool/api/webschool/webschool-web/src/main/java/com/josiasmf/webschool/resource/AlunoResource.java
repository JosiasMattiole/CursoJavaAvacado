package com.josiasmf.webschool.resource;

import com.josiasmf.webschool.model.Aluno;
import com.josiasmf.webschool.service.AlunoService;
import java.util.Optional;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
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
    private AlunoService service;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        return Response.ok(service.findAll()).build();
    }

    @GET
    @Path("/{id:[0-9][0-9]*}")
    @Produces(MediaType.APPLICATION_JSON)
    public Aluno findById(@PathParam("id") long id) {
        Aluno aluno = service.findById(id);
        if (aluno == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return aluno;
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Aluno aluno) throws Exception {
        service.create(aluno);
        return Response.status(Response.Status.CREATED).entity(aluno).build();
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(Aluno aluno) throws Exception {
        service.update(aluno);
        return Response.status(Response.Status.OK).entity(aluno).build();
    }

    @DELETE
    @Path("/{id:[0-9][0-9]*}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") long id) {
        Aluno aluno = Optional.ofNullable(id)
                .map(idAluno -> service.findById(idAluno))
                .orElseThrow(WebApplicationException::new);
        
        service.delete(aluno);
        return Response.status(Response.Status.OK).entity(aluno).build();
    }
}
