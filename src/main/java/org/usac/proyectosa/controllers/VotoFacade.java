package org.usac.proyectosa.controllers;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.CaseBuilder;
import com.querydsl.core.types.dsl.Wildcard;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.core.Response;
import org.usac.proyectosa.models.Elector;
import org.usac.proyectosa.models.MesaVotacion;
import org.usac.proyectosa.models.Partido;
import org.usac.proyectosa.models.QElector;
import org.usac.proyectosa.models.QMesaVotacion;
import org.usac.proyectosa.models.QPartido;
import org.usac.proyectosa.models.QVoto;
import org.usac.proyectosa.models.Voto;
import org.usac.proyectosa.rest.filters.SAException;
import org.usac.proyectosa.rest.requests.EmitirVotoRequest;
import org.usac.proyectosa.rest.responses.ResultadoResponse;

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
        if (elector == null) {
            throw new SAException("Imposible emitir voto, el elector no existe");
        }
        if (elector.getVotoEmitido()) {
            throw new SAException("Imposible emitir voto, el elector ya voto");
        }

        MesaVotacion mesa = mesaVotacionService.getByDPI(request.getDpi());
        if (mesa == null) {
            throw new SAException("Imposible emitir voto, mesa de votacion no registrada");
        }

        elector.setVotoEmitido(Boolean.TRUE);
        electorService.edit(elector.getIdElector(), elector);

        String partidoStr = request.getPartido();

        if (partidoStr == null) {
            mesa.increaseNulos();
            mesaVotacionService.edit(mesa.getIdMesa(), mesa);
            return;
        }

        if (partidoStr.isEmpty()) {
            mesa.increaseBlancos();
            mesaVotacionService.edit(mesa.getIdMesa(), mesa);
            return;
        }

        Partido partido = partidoService.findByName(request.getPartido());
        if (partido == null) {
            mesa.increaseNulos();
            mesaVotacionService.edit(mesa.getIdMesa(), mesa);
            return;
        }

        Voto voto = new Voto();
        voto.setMesa(mesa);
        voto.setPartido(partido);
        this.create(voto);
    }

    public List<ResultadoResponse> getResults() {
        QVoto _voto = QVoto.voto;
        QPartido _partido = QPartido.partido;
        QMesaVotacion _mesa = QMesaVotacion.mesaVotacion;
        QElector _elector = QElector.elector;
        
        JPAQueryFactory factory = new JPAQueryFactory(em);
        List<ResultadoResponse> result = factory.select(
                        Projections.constructor(
                                ResultadoResponse.class,
                                _partido.nombre
                                ,new CaseBuilder()
                                        .when(_voto.idVoto.count().isNotNull())
                                        .then(_voto.idVoto.count())
                                        .otherwise(0L)
                        )
                )
                .from(_partido)
                .leftJoin(_voto).on(_voto.partido.eq(_partido))
                .groupBy(_partido.nombre)
                .fetch();
        
        Long nulos = factory.select(_mesa.cantNulos.sum())
                .from(_mesa).fetchOne().longValue();
        Long blancos = factory.select(_mesa.cantBlancos.sum())
                .from(_mesa).fetchOne().longValue();
        Long total = factory.select(_elector.count())
                .from(_elector).where(_elector.votoEmitido.isTrue()).fetchOne();
        result.add(new ResultadoResponse("Nulos", nulos));
        result.add(new ResultadoResponse("Blancos", blancos));
        result.add(new ResultadoResponse("Total", total));
        return result;
    }

}
