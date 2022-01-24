package be.ebusiness.services;


import be.ebusiness.connection.EntityFinder;
import be.ebusiness.connection.EntityFinderImpl;
import be.ebusiness.entities.ItemCategory;
import be.ebusiness.entities.ItemStorageLocation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Gravez Laurent
 *
 */

public class ItemStorageLocationService {

    public static ItemStorageLocation findItemStorageLocation(int id){

        List<ItemStorageLocation> itemStorageLocationList;
        EntityFinder<ItemStorageLocation> ef = new EntityFinderImpl<>();
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        itemStorageLocationList = ef.findByNamedQuery("ItemStorageLocation.findQuantityItem", new ItemStorageLocation(), map);
        return itemStorageLocationList.get(0);
    }
}
