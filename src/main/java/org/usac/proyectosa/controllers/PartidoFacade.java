package org.usac.proyectosa.controllers;

import com.querydsl.jpa.impl.JPAQueryFactory;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.usac.proyectosa.models.Partido;
import org.usac.proyectosa.models.QPartido;

/**
 *
 * @author esvux
 */
@Stateless
public class PartidoFacade extends AbstractFacade<Partido> {

    @PersistenceContext(unitName = "elecciones_pu")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PartidoFacade() {
        super(Partido.class);
    }
    
   public Partido findByName(String nombre) {
        QPartido _partido = QPartido.partido;
        JPAQueryFactory factory = new JPAQueryFactory(em);
        Partido partido = factory
                .selectFrom(_partido)
                .where(_partido.nombre.eq(nombre))
                .fetchFirst();
        return partido;
    }

    
}
