package com.josiasmf.webschool.model.turma;

import com.josiasmf.webschool.model.turma.Turma;
import com.josiasmf.webschool.model.turma.TurmaRepository;
import com.josiasmf.webschool.model.turma.TurmaService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author Josias
 */
@Path("turmas")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TurmaResource {

    @Inject
    private TurmaService service;

    @Inject
    private TurmaRepository repository;

    @GET
    public Response findAll() {
        return Response.ok(repository.findAll()).build();
    }

    @GET
    @Path("/{id:[0-9][0-9]*}")
    public Turma findById(@PathParam("id") final long id) {
        Turma turma = repository.find(id);
        if (turma == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return turma;
    }

    @POST
    public Response create(final Turma turma) {
        service.persist(turma);
        return Response.status(Response.Status.CREATED).entity(turma).build();
    }

    @PUT
    public Response update(final Turma turma) {
        service.persist(turma);
        return Response.status(Response.Status.OK).entity(turma).build();
    }

    @DELETE
    @Path("/{id:[0-9][0-9]*}")
    public Response delete(@PathParam("id") final long id) {
        service.remove(repository.find(id));
        return Response.status(Response.Status.OK).entity(id).build();
    }
}
