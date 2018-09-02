package org.usac.proyectosa.rest;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.usac.proyectosa.models.Elector;

/**
 * REST Web Service
 *
 * @author esvux
 */
@Path("electores")
@RequestScoped
public class ElectorEndpoint {

    @Context
    private UriInfo context;

    /**
     * Retrieves representation of an instance of org.usac.proyectosa.rest.ElectorEndpoint
     * @return an instance of org.usac.proyectosa.models.Elector
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        //TODO return proper representation object
        return Response.ok("\"Mensaje de ok\"").build();
    }

    /**
     * PUT method for updating or creating an instance of ElectorEndpoint
     * @param idElector id for elector to update
     * @param elector representation for the resource
     */
    @PUT
    @Path("/{id:[0-9]+}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateElector(@PathParam("id") Long idElector, Elector elector) {
        
    }
}
