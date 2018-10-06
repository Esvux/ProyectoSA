package org.usac.proyectosa.controllers;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.constraints.NotNull;
import org.usac.proyectosa.models.CentroVotacion;
import org.usac.proyectosa.models.Departamento;
import org.usac.proyectosa.models.MesaVotacion;
import org.usac.proyectosa.models.Municipio;
import org.usac.proyectosa.models.QCentroVotacion;
import org.usac.proyectosa.models.QDepartamento;
import org.usac.proyectosa.models.QElector;
import org.usac.proyectosa.models.QMesaVotacion;
import org.usac.proyectosa.models.QMunicipio;
import org.usac.proyectosa.rest.responses.MesaResponse;

/**
 *
 * @author esvux
 */
@Stateless
public class MesaVotacionFacade extends AbstractFacade<MesaVotacion> {

    @PersistenceContext(unitName = "elecciones_pu")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MesaVotacionFacade() {
        super(MesaVotacion.class);
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
