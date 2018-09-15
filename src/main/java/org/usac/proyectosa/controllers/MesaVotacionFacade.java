package org.usac.proyectosa.controllers;

import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.usac.proyectosa.models.MesaVotacion;
import org.usac.proyectosa.models.QMesaVotacion;

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

}
