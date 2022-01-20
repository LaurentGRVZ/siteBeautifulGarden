package be.ebusiness.beans;

import be.ebusiness.entities.Address;
import be.ebusiness.entities.City;
import be.ebusiness.entities.Role;
import be.ebusiness.entities.User;
import be.ebusiness.enumerations.UserGenderEnum;
import org.mindrot.jbcrypt.BCrypt;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import static be.ebusiness.services.CityService.findAllCities;
import static be.ebusiness.services.CityService.findOneCity;
import static be.ebusiness.services.RoleService.findAllRoles;
import static be.ebusiness.tools.SessionTool.getSession;
import static be.ebusiness.tools.TransactionTool.saveUser;

/**
 * @author Gravez Laurent
 *
 */

@Named
@SessionScoped
public class RegistrationBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private String displayFieldCustomerPro;
    private String title;
    User user = new User();
    UserGenderEnum userGenderEnum;
    private List<Role> roleList = findAllRoles();
    private List<City> cityList= findAllCities();
    private String idCity;
    private Address address = new Address();

    //Methods

    public UserGenderEnum managementGender(){

        //I use a title variable because i can display enum in three languages
        switch(title){
            case "1":
                userGenderEnum = UserGenderEnum.MR;
                break;
            case "2":
                userGenderEnum = UserGenderEnum.MS;
                break;
            case "3":
                userGenderEnum = UserGenderEnum.MX;
                break;
        }
        return userGenderEnum;
    }

    public String addUserInDb(){

        boolean userCreated;

        //Add user role
        if(displayFieldCustomerPro.equals("1")){
            user.setRole(roleList.get(1));
        }else{
            user.setRole(roleList.get(2));
        }

        //Add user info
        user.setGender(managementGender());
        user.setActive(true);
        user.setCreatedAt(LocalDateTime.now());
        hashPwd();

        //Add address
        address.setCity(findOneCity(Integer.parseInt(idCity)));
        address.setCreatedAt(LocalDateTime.now());
        user.setAddress(address);

        //Save user
        userCreated = saveUser(user, address);

        //Create session
        if(userCreated){
            HttpSession session = getSession();
            session.setAttribute("connectedUser", user);
        }

        //Reset the form
        user = new User();
        address = new Address();
        roleList = findAllRoles();
        cityList= findAllCities();

        return userCreated ? "success" : "failed";
    }

    public void hashPwd(){
        //I use jBcrypt because it is a hash function and not a hash algorithm
        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
    }


    //Getters and setters

    public String getDisplayFieldCustomerPro() { return displayFieldCustomerPro; }

    public void setDisplayFieldCustomerPro(String displayFieldCustomerPro) { this.displayFieldCustomerPro = displayFieldCustomerPro; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    public List<City> getCityList() { return cityList; }

    public void setCityList(List<City> cityList) { this.cityList = cityList; }

    public String getIdCity() { return idCity; }

    public void setIdCity(String idCity) { this.idCity = idCity; }

    public Address getAddress() { return address; }

    public void setAddress(Address address) { this.address = address; }
}
