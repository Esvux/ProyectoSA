package org.usac.proyectosa.controllers;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.constraints.NotNull;
import org.usac.proyectosa.models.CentroVotacion;
import org.usac.proyectosa.models.MesaVotacion;
import org.usac.proyectosa.models.QCentroVotacion;
import org.usac.proyectosa.models.QDepartamento;
import org.usac.proyectosa.models.QElector;
import org.usac.proyectosa.models.QMesaVotacion;
import org.usac.proyectosa.models.QMunicipio;
import org.usac.proyectosa.rest.filters.SAException;
import org.usac.proyectosa.rest.filters.SAMultipleException;
import org.usac.proyectosa.rest.responses.MesaResponse;

/**
 *
 * @author esvux
 */
@Stateless
public class MesaVotacionFacade extends AbstractFacade<MesaVotacion> {

    @PersistenceContext(unitName = "elecciones_pu")
    private EntityManager em;

    @Inject
    private CentroVotacionFacade centroService;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MesaVotacionFacade() {
        super(MesaVotacion.class);
    }

    public long createMassivly(List<MesaVotacion> entities) throws SAException, SAMultipleException {
        if (entities == null || entities.isEmpty()) {
            throw new SAException("La lista de mesas no puede ser nula o vacía");
        }
        List<String> messages = new ArrayList<>();
        long records = 0L;
        for(MesaVotacion mesa : entities) {
            try {
                createWithValidations(mesa);
                records++;
            } catch(SAException e) {
                messages.add(e.getMessage());
            }
        }
        if (!messages.isEmpty()) {
            throw new SAMultipleException(messages);
        }
        return records;
    }
    
    public void createWithValidations(MesaVotacion entity) throws SAException {
        QMesaVotacion _mesa = QMesaVotacion.mesaVotacion;
        JPAQueryFactory factory = new JPAQueryFactory(em);
        
        Integer idMunicipio = entity.getIdMunicipio();
        if (idMunicipio != null) {
            CentroVotacion centroByMuniId = centroService.findByMunicipio(idMunicipio);
            entity.setCentroVotacion(centroByMuniId);
        }
        
        CentroVotacion centro = entity.getCentroVotacion();
        if(centro == null) {
            throw new SAException(String.format("La mesa número %d no tiene centro de votación asignado", entity.getNumMesa()));
        }
        
        Integer numMesa = entity.getNumMesa();
        long countMesa = factory
                .selectFrom(_mesa)
                .where(
                        _mesa.numMesa.eq(numMesa),
                        _mesa.centroVotacion.eq(entity.getCentroVotacion())
                ).fetchCount();

        if (countMesa > 0) {
            throw new SAException(String.format("La mesa %d ya ha sido registrada en el centro de votacion %d", numMesa, centro.getIdCentro()));
        }
        
        this.create(entity);
    }


    public List<MesaVotacion> findAll(Integer centroId) {
        QMesaVotacion _mesa = QMesaVotacion.mesaVotacion;
        JPAQueryFactory factory = new JPAQueryFactory(em);
        JPAQuery<MesaVotacion> query = factory.selectFrom(_mesa);

        if (centroId != null) {
            query.where(_mesa.centroVotacion.idCentro.eq(centroId));
        }

        return query.fetch();
    }

    public MesaVotacion getByDPI(@NotNull String dpi) {
        QMesaVotacion _mesa = QMesaVotacion.mesaVotacion;
        JPAQueryFactory factory = new JPAQueryFactory(em);
        MesaVotacion mesa = factory
                .selectFrom(_mesa)
                .where(_mesa.electores.any().dpi.eq(dpi.trim()))
                .fetchOne();
        return mesa;
    }

    public MesaResponse findByDPI(@NotNull String dpi) {
        QDepartamento _departamento = QDepartamento.departamento;
        QMunicipio _municipio = QMunicipio.municipio;
        QCentroVotacion _centro = QCentroVotacion.centroVotacion;
        QMesaVotacion _mesa = QMesaVotacion.mesaVotacion;
        QElector _elector = QElector.elector;

        JPAQueryFactory factory = new JPAQueryFactory(em);
        JPAQuery<MesaResponse> query = factory
                .from(_elector, _mesa, _centro, _municipio, _departamento)
                .select(
                        Projections.constructor(
                                MesaResponse.class,
                                _departamento.idDepartamento,
                                _municipio.idMunicipio,
                                _centro.idCentro,
                                _centro.direccion,
                                _mesa.numMesa,
                                _elector.numPadron
                        )
                )
                .where(
                        _elector.mesa.eq(_mesa),
                        _mesa.centroVotacion.eq(_centro),
                        _centro.municipio.eq(_municipio),
                        _municipio.departamento.eq(_departamento),
                        _elector.dpi.eq(dpi)
                );

        return query.fetchFirst();
    }

}
