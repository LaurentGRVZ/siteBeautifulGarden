package be.ebusiness.services;

import be.ebusiness.entities.Address;

import javax.persistence.EntityManager;


/**
 * @author Gravez Laurent
 *
 */

public class AddressService {

    public static void addAddress(EntityManager em, Address newAddres){ em.persist(newAddres); }
}
