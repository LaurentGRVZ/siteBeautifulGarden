package be.ebusiness.beans;

import be.ebusiness.entities.ItemCategory;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

import static be.ebusiness.services.ItemCategoryService.findAllItemByIdCategory;

/**
 * @author Gravez Laurent
 *
 */

@Named
@SessionScoped

public class LawnmowerBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private List<ItemCategory> itemCategoryList = findAllItemByIdCategory(6);


    //Getters and setters

    public List<ItemCategory> getItemCategoryList() {
        return itemCategoryList;
    }

    public void setItemCategoryList(List<ItemCategory> itemCategoryList) {
        this.itemCategoryList = itemCategoryList;
    }
}
