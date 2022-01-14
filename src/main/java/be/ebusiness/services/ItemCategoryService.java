package be.ebusiness.services;

import be.ebusiness.connection.EntityFinder;
import be.ebusiness.connection.EntityFinderImpl;
import be.ebusiness.entities.ItemCategory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Gravez Laurent
 *
 */

public class ItemCategoryService {

    //Methods

    public static List<ItemCategory> findAllItemByIdCategory(int id){
        List<ItemCategory> itemList;
        EntityFinder<ItemCategory> ef = new EntityFinderImpl<>();
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        itemList = ef.findByNamedQuery("ItemCategory.findAllItemByCategory", new ItemCategory(), map);
        return itemList;
    }

    public static List<ItemCategory> findAllItemByIdCategoryAndSortByPrice(int id){
        List<ItemCategory> itemList;
        EntityFinder<ItemCategory> ef = new EntityFinderImpl<>();
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        itemList = ef.findByNamedQuery("ItemCategory.findAllItemByIdCategoryAndSortByPrice", new ItemCategory(), map);
        return itemList;
    }

    public static List<ItemCategory> findAllItemByIdCategoryAndSortByBrand(int id){
        List<ItemCategory> itemList;
        EntityFinder<ItemCategory> ef = new EntityFinderImpl<>();
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        itemList = ef.findByNamedQuery("ItemCategory.findAllItemByIdCategoryAndSortByBrand", new ItemCategory(), map);
        return itemList;
    }

}
