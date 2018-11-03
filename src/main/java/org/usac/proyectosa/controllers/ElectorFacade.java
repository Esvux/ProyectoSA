package org.usac.proyectosa.controllers;

import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.usac.proyectosa.models.Elector;
import org.usac.proyectosa.models.QElector;
import org.usac.proyectosa.rest.filters.SAException;
import org.usac.proyectosa.rest.filters.SAMultipleException;

/**
 *
 * @author esvux
 */
@Stateless
public class ElectorFacade extends AbstractFacade<Elector> {

    @PersistenceContext(unitName = "elecciones_pu")
    private EntityManager em;
    
    @Inject
    private MesaVotacionFacade mesasService;

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

    public Elector findByDPI(String dpi) {
        QElector _elector = QElector.elector;
        JPAQueryFactory factory = new JPAQueryFactory(em);
        Elector elector = factory
                .selectFrom(_elector)
                .where(_elector.dpi.eq(dpi.trim()))
                .fetchFirst();
        return elector;
    }

    public long createMassively(List<Elector> entities) throws SAException, SAMultipleException {
        if (entities == null || entities.isEmpty()) {
            throw new SAException("La lista de personas no puede ser nula o vacía");
        }
        List<String> messages = new ArrayList<>();
        long records = 0L;
        for(Elector elector : entities) {
            try {
                createWithValidations(elector);
                records++;
            } catch (SAException e) {
                messages.add(e.getMessage());
            }            
        }
        if (!messages.isEmpty()) {
            throw new SAMultipleException(messages);
        }
        return records;
    }

    public void createWithValidations(Elector entity) throws SAException {
        QElector _elector = QElector.elector;
        JPAQueryFactory factory = new JPAQueryFactory(em);
        String dpi = entity.getDpi().trim();
        long countDPI = factory.selectFrom(_elector).where(_elector.dpi.eq(dpi)).fetchCount();

        if (countDPI > 0) {
            throw new SAException(String.format("El DPI '%s' ya existe", dpi));
        }
        
        Integer idMesa = entity.getIdMesa();
        if (idMesa != null) {
            entity.setMesa(mesasService.findById(idMesa));
        }

        validateBirthday(dpi, entity.getFechaNacimiento());
        this.create(entity);
    }

    public void editWithValidations(Integer idElector, Elector entity) throws SAException {
        Elector oldEntity = findById(idElector);
        if (!idElector.equals(oldEntity.getIdElector()) || !idElector.equals(entity.getIdElector())) {
            throw new SAException("Error en los id de electores");
        }
        String dpi = entity.getDpi().trim();
        QElector _elector = QElector.elector;
        JPAQueryFactory factory = new JPAQueryFactory(em);
        long countDPI = factory.selectFrom(_elector)
                .where(
                        _elector.dpi.eq(dpi), //New value exist
                        _elector.dpi.ne(oldEntity.getDpi()) //But is not the same
                ).fetchCount();

        if (countDPI > 0) {
            throw new SAException(String.format("El DPI '%s' ya existe", dpi));
        }

        validateBirthday(dpi, entity.getFechaNacimiento());
        this.edit(idElector, entity);
    }

    private void validateBirthday(String dpi, Date birthday) throws SAException {
        Calendar calBirthday = Calendar.getInstance();
        calBirthday.setTime(birthday);
        Calendar calLimit = Calendar.getInstance();
        calLimit.add(Calendar.YEAR, -18);
        if (calBirthday.after(calLimit)) {
            throw new SAException(String.format("El elector con DPI '%s' debe ser mayor de edad", dpi));
        }
    }

}
