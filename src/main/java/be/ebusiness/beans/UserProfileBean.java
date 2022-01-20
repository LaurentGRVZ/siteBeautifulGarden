package be.ebusiness.beans;


import be.ebusiness.entities.User;
import be.ebusiness.enumerations.UserGenderEnum;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import java.io.Serializable;

import static be.ebusiness.tools.SessionTool.getSession;


/**
 * @author Gravez Laurent
 *
 */

@Named
@SessionScoped
public class UserProfileBean implements Serializable {

    private static final long serialVersionUID = 1L;
    HttpSession session = getSession();
    User user = (User) session.getAttribute("connectedUser");
    private String imgAvatar;


    @PostConstruct
    public void init(){
        if(user.getGender() == UserGenderEnum.MR){
            imgAvatar = "/resources/pictures/avatars/avatar1.jpg";
        }else if (user.getGender() == UserGenderEnum.MS){
            imgAvatar = "/resources/pictures/avatars/avatar2.jpg";
        }else{
            imgAvatar = "/resources/pictures/avatars/avatar3.jpg";
        }
    }


    //Getters and setters

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    public String getImgAvatar() { return imgAvatar; }

    public void setImgAvatar(String imgAvatar) { this.imgAvatar = imgAvatar; }

}
