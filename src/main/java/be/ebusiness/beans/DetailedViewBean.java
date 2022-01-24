package be.ebusiness.beans;

import be.ebusiness.entities.Item;
import be.ebusiness.entities.ItemStorageLocation;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

import static be.ebusiness.services.ItemService.findItemById;
import static be.ebusiness.services.ItemStorageLocationService.findItemStorageLocation;

/**
 * @author Gravez Laurent
 *
 */

@Named
@SessionScoped
public class DetailedViewBean implements Serializable {

    private static final long serialVersionUID = 1L;
    Item item;
    private String quantityMax;
    private int quantitySelected;

    //Methods

    public String displayDetailedView(int id){
        item = findItemById(id);
        quantityMax = Integer.toString(findItemStorageLocation(id).getQuantity());
        return "detailed";
    }


    //Getters and setters

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getQuantityMax() {
        return quantityMax;
    }

    public void setQuantityMax(String quantityMax) {
        this.quantityMax = quantityMax;
    }

    public int getQuantitySelected() { return quantitySelected; }

    public void setQuantitySelected(int quantitySelected) { this.quantitySelected = quantitySelected; }
}
