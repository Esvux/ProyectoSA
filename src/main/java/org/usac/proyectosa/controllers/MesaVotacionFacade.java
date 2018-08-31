package org.usac.proyectosa.controllers;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.usac.proyectosa.models.MesaVotacion;

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
    
}
