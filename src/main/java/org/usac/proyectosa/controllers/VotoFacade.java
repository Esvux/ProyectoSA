package org.usac.proyectosa.controllers;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.CaseBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.usac.proyectosa.models.Elector;
import org.usac.proyectosa.models.MesaVotacion;
import org.usac.proyectosa.models.Partido;
import org.usac.proyectosa.models.QElector;
import org.usac.proyectosa.models.QMesaVotacion;
import org.usac.proyectosa.models.QPartido;
import org.usac.proyectosa.models.QVoto;
import org.usac.proyectosa.models.Voto;
import org.usac.proyectosa.rest.filters.SAException;
import org.usac.proyectosa.rest.filters.SAMultipleException;
import org.usac.proyectosa.rest.requests.SingleVoteRequest;
import org.usac.proyectosa.rest.requests.SingleVoteRequestESB;
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

    public long createMassively(List<SingleVoteRequestESB> entities) throws SAException, SAMultipleException {
        if (entities == null || entities.isEmpty()) {
            throw new SAException("La lista de votos no puede ser nula o vacía");
        }
        List<String> messages = new ArrayList<>();
        long records = 0L;
        for (SingleVoteRequestESB voto : entities) {
            try {
                issueVote(voto);
                records++;
            } catch (SAException e) {
                messages.add(e.getMessage());
            }
        }
        if (!messages.isEmpty()) {
            throw new SAMultipleException(messages);
        }
        return records;
    }

    public void issueVote(SingleVoteRequest vote) throws SAException {
        issueVote(vote.getDpi(), vote.getPartido(), null);
    }

    public void issueVote(SingleVoteRequestESB vote) throws SAException {
        issueVote(vote.getDpi(), null, vote.getPartido());
    }
    
    private void issueVote(String dpi, String nombrePartido, Integer idPartido) throws SAException {
        Elector elector = electorService.findByDPI(dpi);
        if (elector == null) {
            throw new SAException("Imposible emitir voto, el elector no existe");
        }
        if (elector.getVotoEmitido()) {
            throw new SAException(String.format("El elector '%s' ya votó", dpi));
        }

        MesaVotacion mesa = mesaVotacionService.getByDPI(dpi);
        if (mesa == null) {
            throw new SAException("Imposible emitir voto, mesa de votacion no registrada");
        }

        elector.setVotoEmitido(Boolean.TRUE);
        electorService.edit(elector.getIdElector(), elector);

        Partido partido = null;
        if (nombrePartido != null) {
            partido = partidoService.findByName(nombrePartido);
        }

        if (idPartido != null) {
            partido = partidoService.findByIdWithNullAndBlank(idPartido);
        }

        if (partido == null) {
            mesa.increaseNulos();
            mesaVotacionService.edit(mesa.getIdMesa(), mesa);
            return;
        }

        if (partido.getIsBlank()) {
            mesa.increaseBlancos();
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
                        _partido.idPartido,
                        _partido.nombre, 
                        new CaseBuilder()
                            .when(_voto.idVoto.count().isNotNull())
                            .then(_voto.idVoto.count())
                            .otherwise(0L)
                )
        )
                .from(_partido)
                .leftJoin(_voto).on(_voto.partido.eq(_partido))
                .groupBy(_partido.idPartido, _partido.nombre)
                .fetch();

        Long nulos = factory.select(_mesa.cantNulos.sum())
                .from(_mesa).fetchOne().longValue();
        Long blancos = factory.select(_mesa.cantBlancos.sum())
                .from(_mesa).fetchOne().longValue();
        Long total = factory.select(_elector.count())
                .from(_elector).where(_elector.votoEmitido.isTrue()).fetchOne();
        result.add(new ResultadoResponse(PartidoFacade.NULL_VOTE, "Nulos", nulos));
        result.add(new ResultadoResponse(PartidoFacade.BLANK_VOTE, "Blancos", blancos));
        result.add(new ResultadoResponse(-1, "Total", total));
        return result;
    }

}
