package be.ebusiness.connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Class to get a connection to the database
 *
 *
 */
public final class EMF {

    private static EntityManagerFactory emfInstance =
            Persistence.createEntityManagerFactory("ebusiness"); // Nom de ton persistence-unit (persistence.xml)

    private EMF() {}

    public static EntityManagerFactory getEMF() {
        return emfInstance;
    }

    public static EntityManager getEM() {
        return emfInstance.createEntityManager();
    }

    /*	Create EntityManager in others classes
     * EntityManager em = EMF.get().createEntityManager();
     * try {
     *     // ... do stuff with em ...
     * } finally {
     *     em.close();
     * }
     */
}