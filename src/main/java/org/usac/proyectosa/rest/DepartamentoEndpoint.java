package org.usac.proyectosa.rest;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.usac.proyectosa.controllers.DepartamentoFacade;
import org.usac.proyectosa.models.Departamento;

/**
 * REST Web Service
 *
 * @author esvux
 */
@Path("departamentos")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DepartamentoEndpoint {
    
    @Inject
    DepartamentoFacade departamentoService;

    @GET
    public Response listAll() {
        List<Departamento> departamentos = departamentoService.findAll();
        return Response.ok(departamentos).build();
    }
    
}
