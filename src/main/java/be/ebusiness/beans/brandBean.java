package be.ebusiness.beans;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;


@Named
@SessionScoped
public class brandBean implements Serializable {

    /*private static final long serialVersionUID = 1L;

    private String brandForm;
    Brand brand = new Brand();

    private List<Brand> brandList = findAllBrand();*/




    /*public String createBrand(){

        EntityManager em = EMF.getEM();

        try{
            em.getTransaction().begin();
            brand.setLabel(brandForm);
            addBrand(em, brand);
            em.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();

            em.getTransaction().rollback();
        }finally {
            em.close();
        }

        return "success";

    }




    public String getBrandForm() {
        return brandForm;
    }

    public void setBrandForm(String brandForm) {
        this.brandForm = brandForm;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public List<Brand> getBrandList() {
        return brandList;
    }

    public void setBrandList(List<Brand> brandList) {
        this.brandList = brandList;
    }

*/
}
