package org.usac.proyectosa.controllers;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.usac.proyectosa.models.Municipio;
import org.usac.proyectosa.models.QMunicipio;

/**
 *
 * @author esvux
 */
@Stateless
public class MunicipioFacade {

    @PersistenceContext(unitName = "elecciones_pu")
    private EntityManager em;

    public List<Municipio> findAll(Integer deptoId) {
        QMunicipio _muni = QMunicipio.municipio;
        JPAQueryFactory factory = new JPAQueryFactory(em);
        JPAQuery<Municipio> generalQuery = factory
                .select(
                        Projections.constructor(
                                Municipio.class,
                                _muni.idMunicipio,
                                _muni.nombre
                        )
                )
                .from(_muni);
        
        if(deptoId != null) {
            generalQuery.where(_muni.departamento.idDepartamento.eq(deptoId));
        }
        return generalQuery.fetch();
    }
    
}
