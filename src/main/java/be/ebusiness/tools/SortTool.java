package be.ebusiness.tools;

import be.ebusiness.entities.ItemCategory;

import java.util.List;

import static be.ebusiness.services.ItemCategoryService.*;

/**
 * @author Laurent GRAVEZ
 *
 *
 */

public class SortTool {

    public List<ItemCategory> sortItem(String sortList, int id){

        List<ItemCategory> itemCategoryList;

        if(sortList.equals("defaultSort")){
            itemCategoryList = findAllItemByIdCategory(id);
        }else if(sortList.equals(("price"))){
            itemCategoryList = findAllItemByIdCategoryAndSortByPrice(id);
        }else{
            itemCategoryList = findAllItemByIdCategoryAndSortByBrand(id);
        }
        return itemCategoryList;
    }
}

