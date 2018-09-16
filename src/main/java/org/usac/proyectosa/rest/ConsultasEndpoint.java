package org.usac.proyectosa.rest;

import com.fasterxml.jackson.annotation.JsonView;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.usac.proyectosa.controllers.MesaVotacionFacade;
import org.usac.proyectosa.rest.responses.MesaResponse;

/**
 * REST Web Service
 *
 * @author esvux
 */
@Path("consultas")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ConsultasEndpoint {
    
    @Inject
    MesaVotacionFacade mesaVotacionService;

    @GET
    @Path("mesa")
    public Response findMesaByDPI(@QueryParam("dpi") String DPI) {
        MesaResponse mesa = mesaVotacionService.findByDPI(DPI);
        return Response.ok(mesa).build();
    }
    
}
