package org.usac.proyectosa.rest;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.usac.proyectosa.controllers.CentroVotacionFacade;
import org.usac.proyectosa.models.CentroVotacion;
import org.usac.proyectosa.rest.filters.SAException;

/**
 * REST Web Service
 *
 * @author esvux
 */
@Path("centros-votacion")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CentrosVotacionEndpoint {

    @Inject
    CentroVotacionFacade centroVotacionService;

    @GET
    public Response listAll(@QueryParam("depto") Integer deptoId, @QueryParam("muni") Integer muniId) {
        List<CentroVotacion> centros = centroVotacionService.findAll(deptoId, muniId);
        return Response.ok(centros).build();
    }

    @POST
    public Response create(CentroVotacion centro) {
        centroVotacionService.create(centro);
        return Response.ok().build();
    }

    @PUT
    @Path("/{id:[0-9]+}")
    public Response edit(@PathParam("id") Integer idCentro, CentroVotacion centro) throws SAException {
        centroVotacionService.edit(idCentro, centro);
        return Response.ok().build();
    }
    
    @DELETE
    @Path("/{id:[0-9]+}")
    public Response delete(@PathParam("id") Integer idCentro) throws SAException {
        centroVotacionService.remove(idCentro);
        return Response.ok().build();
    }

}
