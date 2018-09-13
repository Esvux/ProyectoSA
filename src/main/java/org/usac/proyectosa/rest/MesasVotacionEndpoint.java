package org.usac.proyectosa.rest;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.MediaType;
import org.usac.proyectosa.models.MesaVotacion;

/**
 * REST Web Service
 *
 * @author esvux
 */
@Path("mesas-votacion")
@RequestScoped
public class MesasVotacionEndpoint {

    @Context
    private UriInfo context;

    /**
     * Retrieves representation of an instance of org.usac.proyectosa.rest.MesasVotacionEndpoint
     * @return an instance of org.usac.proyectosa.models.MesaVotacion
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public MesaVotacion getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of MesasVotacionEndpoint
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(MesaVotacion content) {
    }
}
