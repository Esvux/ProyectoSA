package org.usac.proyectosa.controllers;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.usac.proyectosa.models.CentroVotacion;
import org.usac.proyectosa.models.QCentroVotacion;

/**
 *
 * @author esvux
 */
@Stateless
public class CentroVotacionFacade extends AbstractFacade<CentroVotacion> {

    @PersistenceContext(unitName = "elecciones_pu")
    private EntityManager em;

    public CentroVotacionFacade() {
        super(CentroVotacion.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public List<CentroVotacion> findAll(Integer deptoId, Integer muniId) {
        QCentroVotacion _centro = QCentroVotacion.centroVotacion;
        JPAQueryFactory factory = new JPAQueryFactory(em);
        JPAQuery<CentroVotacion> query = factory.select(
                Projections.constructor(
                        CentroVotacion.class,
                        _centro.idCentro,
                        _centro.nombre,
                        _centro.direccion,
                        _centro.extraDireccion
                )
        ).from(_centro);

        if (deptoId != null) {
            // Filter by depto
            query.where(_centro.municipio.departamento.idDepartamento.eq(deptoId));
        } else if (muniId != null) {
            // Filter by muni
            query.where(_centro.municipio.idMunicipio.eq(muniId));
        }

        return query.fetch();
    }
}
