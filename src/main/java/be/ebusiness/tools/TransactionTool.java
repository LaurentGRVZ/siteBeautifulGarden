package be.ebusiness.tools;

import be.ebusiness.connection.EMF;
import be.ebusiness.entities.Address;
import be.ebusiness.entities.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.EntityManager;

import static be.ebusiness.services.AddressService.addAddress;
import static be.ebusiness.services.UserService.addUser;

/**
 * @author Laurent GRAVEZ
 *
 *
 */

public class TransactionTool {

    private static final Logger logger = LogManager.getLogger(TransactionTool.class);

    public static boolean saveUser(User user, Address address){

        EntityManager em = EMF.getEM();

        try{
            em.getTransaction().begin();
            addUser(em, user);
            addAddress(em,address);
            em.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            logger.debug("Error information: " + e.getMessage());
            em.getTransaction().rollback();
            return false;
        }finally {
            em.close();
        }
        return true;
    }
}
