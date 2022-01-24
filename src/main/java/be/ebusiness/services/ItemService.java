package be.ebusiness.services;


import be.ebusiness.connection.EntityFinder;
import be.ebusiness.connection.EntityFinderImpl;
import be.ebusiness.entities.Item;

/**
 * @author Gravez Laurent
 *
 */

public class ItemService {

    public static Item findItemById(int id) {
        Item item;
        EntityFinder<Item> ef = new EntityFinderImpl<>();
        item = ef.findOne(new Item(), id);
        return item;
    }
}
