package com.josiasmf.landpage.resource;

import com.josiasmf.landpage.model.Cliente;
import com.josiasmf.landpage.repository.ClienteRepository;
import com.josiasmf.landpage.service.ClienteService;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Josias
 */
@Stateless
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("clientes")
public class ClienteResource {
    
    @Inject
    private ClienteRepository repository;
    
    @Inject
    private ClienteService service;
    
    @GET
    public Response listarTodos() {
        return Response.ok(repository.findAll()).build();
    }
    
    @POST
    public Response create(Cliente cliente) throws Exception {
        service.persist(cliente);
        return Response.status(Response.Status.CREATED).entity(cliente).build();
    }
}
