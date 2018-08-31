package org.usac.proyectosa.controllers;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.usac.proyectosa.models.CentroVotacion;

/**
 *
 * @author esvux
 */
@Stateless
public class CentroVotacionFacade extends AbstractFacade<CentroVotacion> {

    @PersistenceContext(unitName = "elecciones_pu")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CentroVotacionFacade() {
        super(CentroVotacion.class);
    }
    
}
