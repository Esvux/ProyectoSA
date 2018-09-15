package org.usac.proyectosa.controllers;

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

    public List<CentroVotacion> findAll(Integer muniId) {
        QCentroVotacion _centro = QCentroVotacion.centroVotacion;
        JPAQueryFactory factory = new JPAQueryFactory(em);
        JPAQuery<CentroVotacion> query = factory.selectFrom(_centro);

        if (muniId != null) {
            query.where(_centro.municipio.idMunicipio.eq(muniId));
        }

        return query.fetch();
    }
}
