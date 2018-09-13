package org.usac.proyectosa.rest;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.usac.proyectosa.controllers.ElectorFacade;
import org.usac.proyectosa.models.Elector;

/**
 * REST Web Service
 *
 * @author esvux
 */
@Path("electores")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ElectorEndpoint {

    @Context
    private UriInfo context;
    
    @Inject
    ElectorFacade electorService;

    @GET
    public Response listAll() {
        //TODO return proper representation object
        return Response.ok("\"Mensaje de ok\"").build();
    }
    
    @POST
    public Response create(Elector elector) {
        electorService.create(elector);
        return Response.ok().build();
    }
    

    @PUT
    @Path("/{id:[0-9]+}")
    public void updateElector(@PathParam("id") Long idElector, Elector elector) {
        
    }
}
