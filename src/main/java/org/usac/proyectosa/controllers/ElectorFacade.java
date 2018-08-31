package org.usac.proyectosa.controllers;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.usac.proyectosa.models.Elector;

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
    
}
