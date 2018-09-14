package org.usac.proyectosa.controllers;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.usac.proyectosa.models.Departamento;
import org.usac.proyectosa.models.QDepartamento;

/**
 *
 * @author esvux
 */
@Stateless
public class DepartamentoFacade {

    @PersistenceContext(unitName = "elecciones_pu")
    private EntityManager em;

    public List<Departamento> findAll() {
        QDepartamento _depto = QDepartamento.departamento;        
        JPAQueryFactory factory = new JPAQueryFactory(em);
        JPAQuery<Departamento> generalQuery = factory
            .select(
                Projections.constructor(
                    Departamento.class,
                    _depto.idDepartamento,
                    _depto.nombre
                )
            ).from(_depto);

        return generalQuery.fetch();
    }

}
