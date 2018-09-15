package org.usac.proyectosa.controllers;

import javax.persistence.EntityManager;
import javax.ws.rs.core.Response;
import org.usac.proyectosa.rest.filters.SAException;

/**
 *
 * @author esvux
 */
public abstract class AbstractFacade<T> {

    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public void create(T entity) {
        getEntityManager().persist(entity);
    }

    public void edit(Integer id, T entity) throws SAException {
        T oldEntity = find(id);
        if(oldEntity == null)
            throw new SAException("Error al editar, el recurso no existe", Response.Status.NOT_FOUND);
        getEntityManager().merge(entity);
    }

    public void remove(Integer id) throws SAException {
        T entity = find(id);
        if(entity == null)
            throw new SAException("Imposible eliminar, el recurso no existe", Response.Status.NOT_FOUND);
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    private T find(Integer id) {
        T entity = getEntityManager().find(entityClass, id);
        return entity;
    }

    public T findById(Integer id) throws SAException {
        T entity = getEntityManager().find(entityClass, id);
        if(entity == null)
            throw new SAException("El recurso no existe");
        return entity;
    }
    
    protected abstract EntityManager getEntityManager();

}
