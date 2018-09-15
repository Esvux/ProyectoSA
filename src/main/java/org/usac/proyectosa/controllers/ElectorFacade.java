package org.usac.proyectosa.controllers;

import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.usac.proyectosa.models.Elector;
import org.usac.proyectosa.models.QElector;

/**
 *
 * @author esvux
 */
@Stateless
public class ElectorFacade extends AbstractFacade<Elector> {

    @PersistenceContext(unitName = "elecciones_pu")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ElectorFacade() {
        super(Elector.class);
    }
    
    public List<Elector> findAll(Integer mesaId) {
        QElector _elector = QElector.elector;
        JPAQueryFactory factory = new JPAQueryFactory(em);
        JPAQuery<Elector> query = factory.selectFrom(_elector);

        if (mesaId != null) {
            query.where(_elector.mesa.idMesa.eq(mesaId));
        }

        return query.fetch();
    }
    
}
