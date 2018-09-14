package org.usac.proyectosa.rest;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.usac.proyectosa.controllers.MunicipioFacade;
import org.usac.proyectosa.models.Municipio;

/**
 * REST Web Service
 *
 * @author esvux
 */
@Path("municipios")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MunicipioEndpoint {
    
    @Inject
    MunicipioFacade municipioService;

    @GET
    public Response listAll() {
        List<Municipio> municipios = municipioService.findAll(null);
        return Response.ok(municipios).build();
    }

    @GET
    @Path("/{deptoId:[0-9][0-9]*}")
    public Response listByDepto(@PathParam("deptoId") final Integer deptoId) {
        List<Municipio> municipios = municipioService.findAll(deptoId);
        return Response.ok(municipios).build();
    }   
    
}
