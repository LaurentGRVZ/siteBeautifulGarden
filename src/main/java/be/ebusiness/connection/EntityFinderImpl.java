package be.ebusiness.connection;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.Serializable;
import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.Query;


/**
 * Class to perform entity CRUD with the database
 *
 *
 */
public class EntityFinderImpl<T> implements EntityFinder<T>, Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Default constructor
     */
    public EntityFinderImpl() {
        super();
    }

    // Log4j
    private static Logger log = LogManager.getLogger(EntityFinderImpl.class);

    @Override
    public T findOne(T t, int id) {

        EntityManager em = EMF.getEM();
        Class<? extends Object> ec = t.getClass();
        try {

            t = (T) em.find(ec, id);

            em.clear();

           log.debug("Bean " + t + " find from database: Ok");
        } finally {
            em.close();
           log.debug("Close em : Ok");
        }

        return t;
    }

    @Override
    public <K, V> List<T> findByNamedQuery(String namedQuery, T t, Map<K, V> param) {

        List<T> listT;
        Class<? extends Object> ec = t.getClass();

        EntityManager em = EMF.getEM();
        try {
            Query query = em.createNamedQuery(namedQuery, ec);

            if (param != null) {

                setParameters(query, param);
            }
            listT = (List<T>) query.getResultList();

            log.debug("List " + t + " size: " + listT.size());
            log.debug("Named query " + namedQuery + " find from database: Ok");
        } finally {

            em.clear();
            em.close();
        }
        return listT;
    }

    @Override
    public <K, V> List<T> findByCustomQuery(String customQuery, T t, Map<K, V> param) {

        List<T> listT;
        Class<? extends Object> ec = t.getClass();

        EntityManager em = EMF.getEM();
        try {
            Query query = em.createQuery(customQuery, ec);
            if (param != null) {

                setParameters(query, param);
            }
            listT = (List<T>) query.getResultList();

            log.debug("List " + t + " size: " + listT.size());
            log.debug("Custom query " + customQuery + " find from database: Ok");
        } finally {

            em.clear();
            em.close();
        }
        return listT;
    }

    /**
     * @param query
     * @param param
     * @return the query with parameters
     */
    private <K, V> void setParameters(Query query, Map<K, V> param) {

        Set<Map.Entry<K, V>> entries = param.entrySet();
        Iterator<Map.Entry<K, V>> itr = entries.iterator();
        while (itr.hasNext()) {
            Map.Entry<K, V> entry = itr.next();
            query.setParameter((String) entry.getKey(), entry.getValue());
           // log.debug("entry.getValue: " + entry.getValue());
        }
    }

}