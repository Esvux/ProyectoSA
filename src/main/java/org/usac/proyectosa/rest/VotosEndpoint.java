package org.usac.proyectosa.rest;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.usac.proyectosa.controllers.VotoFacade;
import org.usac.proyectosa.rest.filters.SAException;
import org.usac.proyectosa.rest.requests.EmitirVotoRequest;
import org.usac.proyectosa.rest.responses.DefaultResponse;

/**
 *
 * @author esvux
 */
@Path("votos")
@RequestScoped
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class VotosEndpoint {
    
    @Inject
    VotoFacade votosService;
    
    @POST
    @Path("emitir-voto")
    public Response registrarVoto(EmitirVotoRequest votoEmitido) throws SAException {
        votosService.emitirVoto(votoEmitido);
        return Response.ok(new DefaultResponse<>("Voto emitido correctamente", false)).build();
    }
    
}
