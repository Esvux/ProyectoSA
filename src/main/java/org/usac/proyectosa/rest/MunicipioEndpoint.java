package org.usac.proyectosa.rest;

import com.fasterxml.jackson.annotation.JsonView;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.usac.proyectosa.controllers.MunicipioFacade;
import org.usac.proyectosa.models.Municipio;
import org.usac.proyectosa.rest.filters.SAException;

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
    @JsonView(View.Search.class)
    public Response listAll(@QueryParam("departamento") Integer idDepto ) {
        List<Municipio> municipios = municipioService.findAll(idDepto);
        return Response.ok(municipios).build();
    }

    @GET
    @Path("/{id:[0-9][0-9]*}")
    public Response findById(@PathParam("id") final Integer idMuni) throws SAException {
        Municipio municipio = municipioService.findById(idMuni);
        return Response.ok(municipio).build();
    }   
    
}
