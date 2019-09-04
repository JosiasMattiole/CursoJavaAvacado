package com.josiasmf.webschool.model.aluno;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author Josias
 */
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AlunoResource {

    @Inject
    private AlunoRepository repository;

    @Inject
    private AlunoService service;

    @GET
    public Response findAll() {
        return Response.ok().entity(repository.findAll()).build();
    }

    @GET
    @Path("/{id:[0-9][0-9]*}")
    public Response findById(@PathParam("id") final long id) {
        final Aluno aluno = repository.find(id);
        if (aluno == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return Response.ok().entity(aluno).build();
    }

    @POST
    public Response create(final Aluno aluno) {
        service.persist(aluno);
        return Response.status(Response.Status.CREATED).entity(aluno).build();
    }

    @PUT
    public Response update(@PathParam("id") final long id, final Aluno aluno) {
        service.persist(aluno);
        return Response.status(Response.Status.ACCEPTED).entity(aluno).build();
    }

    @DELETE
    @Path("/{id:[0-9][0-9]*}")
    public Response delete(@PathParam("id") final Long id) {
        service.remove(repository.find(id));
        return Response.noContent().build();
    }
}
