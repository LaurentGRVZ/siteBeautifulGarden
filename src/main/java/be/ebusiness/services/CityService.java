package be.ebusiness.services;

import be.ebusiness.connection.EntityFinder;
import be.ebusiness.connection.EntityFinderImpl;
import be.ebusiness.entities.City;

import java.util.List;

/**
 * @author Gravez Laurent
 *
 */

public class CityService {

    public static City findOneCity(int id) {
        City city;
        EntityFinder<City> ef = new EntityFinderImpl<>();
        city = ef.findOne(new City(), id);
        return city;
    }

    public static List<City> findAllCities(){
        List<City> rolesList;
        EntityFinder<City> ef = new EntityFinderImpl<>();
        rolesList = ef.findByNamedQuery("City.findAll", new City(), null);
        return rolesList;
    }

}
