package org.usac.proyectosa.controllers;

import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.core.Response;
import org.usac.proyectosa.models.Elector;
import org.usac.proyectosa.models.QElector;
import org.usac.proyectosa.rest.filters.SAException;

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

    public void createWithValidations(Elector entity) throws SAException {
        QElector _elector = QElector.elector;
        JPAQueryFactory factory = new JPAQueryFactory(em);
        
        long countDPI = factory.selectFrom(_elector).where(_elector.dpi.eq(entity.getDpi().trim())).fetchCount();
        if(countDPI > 0) {
            throw new SAException("El DPI ya existe", Response.Status.BAD_REQUEST);
        }

        Instant birthDay = Instant.ofEpochMilli(entity.getFechaNacimiento().getTime());
        Instant limitDate = Instant.now().minus(18, ChronoUnit.YEARS);
        if(birthDay.isAfter(limitDate)) {
            throw new SAException("El elector debe ser mayor de edad", Response.Status.BAD_REQUEST);
        }
        this.create(entity);
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
