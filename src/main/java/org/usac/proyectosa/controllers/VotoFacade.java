package org.usac.proyectosa.controllers;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.core.Response;
import org.usac.proyectosa.models.Elector;
import org.usac.proyectosa.models.MesaVotacion;
import org.usac.proyectosa.models.Partido;
import org.usac.proyectosa.models.Voto;
import org.usac.proyectosa.rest.filters.SAException;
import org.usac.proyectosa.rest.requests.EmitirVotoRequest;

/**
 *
 * @author esvux
 */
@Stateless
public class VotoFacade extends AbstractFacade<Voto> {

    @PersistenceContext(unitName = "elecciones_pu")
    private EntityManager em;
    
    @Inject
    ElectorFacade electorService;
    
    @Inject
    MesaVotacionFacade mesaVotacionService;

    @Inject
    PartidoFacade partidoService;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VotoFacade() {
        super(Voto.class);
    }
    
    public void emitirVoto(EmitirVotoRequest request) throws SAException {
        Elector elector = electorService.findByDPI(request.getDpi());
        if(elector==null)
            throw new SAException("Imposible emitir voto, el elector no existe");
        if(elector.getVotoEmitido())
            throw new SAException("Imposible emitir voto, el elector ya voto");

        MesaVotacion mesa = mesaVotacionService.getByDPI(request.getDpi());
        if(mesa==null)
            throw new SAException("Imposilbe emitir voto, mesa de votacion no registrada");
        
        Partido partido = partidoService.findByName(request.getPartido());
        if(partido==null)
            throw new SAException("Imposible emitir voto, el partido no existe");

        elector.setVotoEmitido(Boolean.TRUE);
        electorService.edit(elector.getIdElector(), elector);
        
        Voto voto = new Voto();
        voto.setMesa(mesa);
        voto.setPartido(partido);
        this.create(voto);
    }
    
}
