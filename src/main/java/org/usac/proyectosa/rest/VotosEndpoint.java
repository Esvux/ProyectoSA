package org.usac.proyectosa.rest;

import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.usac.proyectosa.controllers.VotoFacade;
import org.usac.proyectosa.rest.filters.SAException;
import org.usac.proyectosa.rest.filters.SAMultipleException;
import org.usac.proyectosa.rest.requests.SingleVoteRequest;
import org.usac.proyectosa.rest.requests.SingleVoteRequestESB;
import org.usac.proyectosa.rest.responses.DefaultResponse;
import org.usac.proyectosa.rest.responses.ResultadoResponse;

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
    public Response register(@Valid SingleVoteRequest vote) throws SAException {
        votosService.issueVote(vote);
        return Response.ok(new DefaultResponse<>("Voto emitido correctamente", false)).build();
    }
    
    @POST
    @Path("ESB/emitir-voto")
    public Response ESBregister(@Valid SingleVoteRequestESB vote) throws SAException {
        votosService.issueVote(vote);
        return Response.ok(new DefaultResponse<>("Voto emitido correctamente", false)).build();
    }
    
    @POST
    @Path("carga")
    public Response massiveLoading(@Valid List<SingleVoteRequestESB> votes) throws SAException, SAMultipleException {
        long records = votosService.createMassively(votes);
        return Response.ok(
                DefaultResponse.getStringResponse(String.format("Se registraron correctamente %d votos", records))
        ).build();
    }
    
    @GET
    @Path("resultados")
    public Response obtainResults() {
        List<ResultadoResponse> results = votosService.getResults();
        return Response.ok(results).build();
    }

    @GET
    @Path("/ESB/resultados")
    public Response ESBobtainResults() {
        List<ResultadoResponse> results = votosService.getResults();
        return Response.ok(
                new DefaultResponse<>("Resultados al momento", false, results)
        ).build();
    }

    
}
