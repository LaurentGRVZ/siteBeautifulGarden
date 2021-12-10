package be.atc.services;

import be.atc.connection.EntityFinder;
import be.atc.connection.EntityFinderImpl;
import be.atc.entities.Brand;
import be.atc.entities.ItemElement;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

public class BrandService implements Serializable {

    public static void addBrand (EntityManager em, Brand newBrand){
        em.persist(newBrand);
    }

    public static List<Brand> findAllBrand() {
        List<Brand> brandList;
        EntityFinder<Brand> ef = new EntityFinderImpl<>();
        brandList = ef.findByNamedQuery("Brand.findAll", new Brand(), null);
        return brandList;
    }

}
