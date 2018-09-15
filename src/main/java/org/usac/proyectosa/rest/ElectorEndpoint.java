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
import org.usac.proyectosa.controllers.ElectorFacade;
import org.usac.proyectosa.models.Elector;
import org.usac.proyectosa.rest.filters.SAException;

/**
 * REST Web Service
 *
 * @author esvux
 */
@Path("electores")
@RequestScoped
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ElectorEndpoint {

    @Inject
    ElectorFacade electorService;
    
    @POST
    public Response create(Elector elector) {
        electorService.create(elector);
        return Response.ok().build();
    }

    @GET
    @JsonView(View.Search.class)
    public Response listAll(@QueryParam("mesa") Integer idMesa) {
        List<Elector> electores = electorService.findAll(idMesa);
        return Response.ok(electores).build();
    }

    @GET
    @Path("/{id:[0-9]+}")
    public Response findById(@PathParam("id") Integer idElector)
            throws SAException {
        Elector elector = electorService.findById(idElector);
        return Response.ok(elector).build();
    }

    @PUT
    @Path("/{id:[0-9]+}")
    public Response edit(@PathParam("id") Integer idElector, Elector elector)
            throws SAException {
        electorService.edit(idElector, elector);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id:[0-9]+}")
    public Response delete(@PathParam("id") Integer idElector)
            throws SAException {
        electorService.remove(idElector);
        return Response.ok().build();
    }

}
