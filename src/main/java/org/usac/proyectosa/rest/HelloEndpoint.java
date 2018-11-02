package org.usac.proyectosa.rest;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author esvux
 */
@Path("setup")
@RequestScoped
public class HelloEndpoint {
    
    @GET
    @Path("version")
    @Produces(MediaType.TEXT_PLAIN)
    public Response version() {
        return Response.ok("Version 0.3.2").build();
    }
    
}
