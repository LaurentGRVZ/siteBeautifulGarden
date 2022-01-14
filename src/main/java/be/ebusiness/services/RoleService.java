package be.ebusiness.services;

import be.ebusiness.connection.EntityFinder;
import be.ebusiness.connection.EntityFinderImpl;
import be.ebusiness.entities.Role;

import java.util.List;

/**
 * @author Gravez Laurent
 *
 */

public class RoleService {

    public static List<Role> findAllRoles(){
        List<Role> rolesList;
        EntityFinder<Role> ef = new EntityFinderImpl<>();
        rolesList = ef.findByNamedQuery("Role.findAll", new Role(), null);
        return rolesList;
    }
}
