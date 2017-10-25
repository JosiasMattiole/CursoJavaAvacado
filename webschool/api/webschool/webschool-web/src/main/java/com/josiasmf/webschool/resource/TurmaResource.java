package com.josiasmf.webschool.resource;

import com.josiasmf.webschool.model.Turma;
import com.josiasmf.webschool.service.TurmaService;
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
@Path("turmas")
public class TurmaResource {

    @Inject
    private TurmaService service;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        return Response.ok(service.findAll()).build();
    }

    @GET
    @Path("/{id:[0-9][0-9]*}")
    @Produces(MediaType.APPLICATION_JSON)
    public Turma findById(@PathParam("id") long id) {
        Turma turma = service.findById(id);
        if (turma == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return turma;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Turma turma) throws Exception {
        service.create(turma);
        return Response.status(Response.Status.CREATED).entity(turma).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(Turma turma) throws Exception {
        service.update(turma);
        return Response.status(Response.Status.OK).entity(turma).build();
    }

    @DELETE
    @Path("/{id:[0-9][0-9]*}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") long id) {
        Turma turma = Optional.ofNullable(id)
                .map(idTurma -> service.findById(idTurma))
                .orElseThrow(WebApplicationException::new);

        service.delete(turma);
        return Response.status(Response.Status.OK).entity(turma).build();
    }
}
