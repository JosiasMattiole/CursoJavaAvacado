package com.josiasmf.atividadearquetipo.api;

import com.josiasmf.atividadearquetipo.data.AlunoRepository;
import com.josiasmf.atividadearquetipo.model.Aluno;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
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
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll(@DefaultValue("0") @QueryParam("offset") Integer offset, 
                            @DefaultValue("50") @QueryParam("limit") int limit, 
                            @DefaultValue("+nome") @QueryParam("sort")String sort) {
        
        return Response.ok(repository.findAll(offset, limit, sort)).build();
    }
    
    @GET
    @Path("{id:[0-9][0-9]*}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") Long matricula) {
        Aluno aluno = repository.findById(matricula);
        if (aluno == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(aluno).build();
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Aluno aluno) {
        repository.insert(aluno);
        return Response.status(Response.Status.CREATED).entity(aluno).build();
    }
}
