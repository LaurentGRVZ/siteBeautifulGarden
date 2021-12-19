package be.ebusiness.beans;

import be.ebusiness.entities.ItemCategory;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

import static be.ebusiness.services.ItemCategoryService.findAllItemByCategory;

/**
 * @author Gravez Laurent
 *
 */

@Named
@SessionScoped
public class DecorationBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private List<ItemCategory> itemCategoryList = findAllItemByCategory(1);



    //Getters and setters

    public List<ItemCategory> getItemCategoryList() {
        return itemCategoryList;
    }

    public void setItemCategoryList(List<ItemCategory> itemCategoryList) {
        this.itemCategoryList = itemCategoryList;
    }
}
