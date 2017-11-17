package com.josiasmf.webschool.util;

import com.josiasmf.webschool.model.Entidade;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.logging.Logger;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Josias
 */
public class Producers {

    @Produces
    @PersistenceContext
    private EntityManager em;

    @Produces
    public Logger produceLog(InjectionPoint injectionPoint) {
        return Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
    }

    @Produces
    public <T extends Entidade> GenericRepository<T> produceRepository(InjectionPoint injectionPoint, EntityManager em) {
        Type[] args = ((ParameterizedType) injectionPoint.getType()).getActualTypeArguments();
        if (args.length == 0) {
            throw new IllegalArgumentException("O GenericRepository precisa de um tipo");
        }
        Class<T> type = (Class<T>) args[0];
        return new GenericRepository(em, type);
    }

    @Produces
    public <T extends Entidade> GenericService<T> produceService(InjectionPoint injectionPoint, EntityManager em) {
        Type[] args = ((ParameterizedType) injectionPoint.getType()).getActualTypeArguments();
        if (args.length == 0) {
            throw new IllegalArgumentException("O GenericService precisa de um tipo");
        }
        Class<T> type = (Class<T>) args[0];
        return new GenericService(em, type);
    }
}
