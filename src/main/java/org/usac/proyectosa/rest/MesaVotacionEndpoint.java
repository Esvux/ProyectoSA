package org.usac.proyectosa.rest;

import com.fasterxml.jackson.annotation.JsonView;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import org.usac.proyectosa.controllers.MesaVotacionFacade;
import org.usac.proyectosa.models.MesaVotacion;
import org.usac.proyectosa.rest.filters.SAException;

/**
 * REST Web Service
 *
 * @author esvux
 */
@Path("mesas-votacion")
@RequestScoped
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MesaVotacionEndpoint {

    @Inject
    MesaVotacionFacade mesaVotacionService;
    
    @POST
    public Response create(MesaVotacion mesa) {
        mesaVotacionService.create(mesa);
        return Response.ok().build();
    }

    @GET
    @JsonView(View.Search.class)
    public Response listAll(@QueryParam("centro") Integer idCentro) {
        List<MesaVotacion> mesas = mesaVotacionService.findAll(idCentro);
        return Response.ok(mesas).build();
    }

    @GET
    @Path("/{id:[0-9]+}")
    public Response findById(@PathParam("id") Integer idMesa)
            throws SAException {
        MesaVotacion mesa = mesaVotacionService.findById(idMesa);
        return Response.ok(mesa).build();
    }

    @PUT
    @Path("/{id:[0-9]+}")
    public Response edit(@PathParam("id") Integer idMesa, MesaVotacion mesa)
            throws SAException {
        mesaVotacionService.edit(idMesa, mesa);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id:[0-9]+}")
    public Response delete(@PathParam("id") Integer idMesa)
            throws SAException {
        mesaVotacionService.remove(idMesa);
        return Response.ok().build();
    }

}
