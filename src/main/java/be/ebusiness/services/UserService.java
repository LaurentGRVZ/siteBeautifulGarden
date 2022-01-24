package be.ebusiness.services;

import be.ebusiness.connection.EntityFinder;
import be.ebusiness.connection.EntityFinderImpl;
import be.ebusiness.entities.User;

import javax.persistence.EntityManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Gravez Laurent
 *
 */

public class UserService {

    public static void addUser(EntityManager em, User newUser){ em.persist(newUser); }

    public static User findUserByMail(String mail) {

        List<User> userList;
        Map<String, Object> map = new HashMap<>();
        map.put("userMail", mail);
        EntityFinder<User> ef = new EntityFinderImpl<>();
        userList = ef.findByNamedQuery("User.findByMail", new User(), map);

        if (!userList.isEmpty() && userList.get(0).getMail().equals(mail)) {
            return userList.get(0);
        }
        return null;
    }

    public static User findUserByVatNumber(String vatNumber){

        List<User> userList;
        Map<String, Object> map = new HashMap<>();
        map.put("vatNumber", vatNumber);
        EntityFinder<User> ef = new EntityFinderImpl<>();
        userList = ef.findByNamedQuery("User.findByVatNumber", new User(), map);

        if(!userList.isEmpty() && userList.get(0).getVatNumber().equals(vatNumber)){
            return userList.get(0);
        }
        return null;
    }

    public static User findUserByCompanyNumber(String companyNbr){

        List<User> userList;
        Map<String, Object> map = new HashMap<>();
        map.put("companyNbr", companyNbr);
        EntityFinder<User> ef = new EntityFinderImpl<>();
        userList = ef.findByNamedQuery("User.findByCompanyNbr", new User(), map);

        if(!userList.isEmpty() && userList.get(0).getCompanyNumber().equals(companyNbr)){
            return userList.get(0);
        }
        return null;
    }
}
