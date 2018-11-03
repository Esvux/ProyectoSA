package org.usac.proyectosa.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.usac.proyectosa.controllers.MesaVotacionFacade;
import org.usac.proyectosa.rest.filters.SAException;
import org.usac.proyectosa.rest.requests.MesaDPIRequest;
import org.usac.proyectosa.rest.responses.DefaultResponse;
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
    public Response findMesaByDPI(@QueryParam("dpi") String DPI) throws SAException {
        MesaResponse mesa = mesaVotacionService.findByDPI(DPI);
        return Response.ok(mesa).build();
    }
    
    @GET
    @Path("/ESB/mesa")
    public Response ESBfindMesaByDPI(@QueryParam("dpi") String DPI) throws SAException {
        MesaResponse mesa = mesaVotacionService.findByDPI(DPI);
        DefaultResponse<MesaResponse> response = new DefaultResponse<>(mesa.toString(), false, mesa);
        return Response.ok(response).build();
    }
    
    @POST
    @Path("/ESB/mesa")
    public Response ESBfindMesaByDPI(MesaDPIRequest request) throws SAException {
        return this.ESBfindMesaByDPI(request.getDpi());
    }

}
