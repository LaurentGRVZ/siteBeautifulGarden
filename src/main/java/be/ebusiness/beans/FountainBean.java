package be.ebusiness.beans;

import be.ebusiness.entities.ItemCategory;
import be.ebusiness.tools.SortTool;

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
public class FountainBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private List<ItemCategory> itemCategoryList = findAllItemByIdCategory(2);
    private String selectTypeSort;
    SortTool sortTool = new SortTool();


    //Methods

    public void sortItem(String selectTypeSort, int id){ itemCategoryList = sortTool.sortItem(selectTypeSort, id); }



    //Getters and setters

    public String getSelectTypeSort() { return selectTypeSort; }

    public void setSelectTypeSort(String selectTypeSort) { this.selectTypeSort = selectTypeSort; }

    public List<ItemCategory> getItemCategoryList() {
        return itemCategoryList;
    }

    public void setItemCategoryList(List<ItemCategory> itemCategoryList) {
        this.itemCategoryList = itemCategoryList;
    }
}
