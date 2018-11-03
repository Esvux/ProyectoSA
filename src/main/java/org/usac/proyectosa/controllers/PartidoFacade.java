package org.usac.proyectosa.controllers;

import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.Objects;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.usac.proyectosa.models.Partido;
import org.usac.proyectosa.models.QPartido;
import org.usac.proyectosa.rest.filters.SAException;

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

    public Partido findByIdWithNullAndBlank(Integer code) {
        if (Objects.equals(code, NULL_VOTE)) {
            return null;
        }
        if (Objects.equals(code, BLANK_VOTE)) {
            Partido partido = new Partido();
            partido.setIsBlank(Boolean.TRUE);
            return partido;
        }
        Partido partido;
        try {
            partido = findById(code);
        } catch (SAException ex) {
            ex.printStackTrace();
            partido = null;
        }
        return partido;
    }

    public static final Integer NULL_VOTE = 7;
    public static final Integer BLANK_VOTE = 6;

}
