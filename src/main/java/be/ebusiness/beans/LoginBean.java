package be.ebusiness.beans;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import java.io.Serializable;

/**
 * @author Gravez Laurent
 *
 */

@Named
@SessionScoped
public class LoginBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String login;
    private String pwd;

   /* public void checkUser(){
        if(BCrypt.checkpw(candidate, hashed))
        {

        }else{
            
        }
    }*/

    //Getters and setters

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    /*public String returnAction() {
        return getLogin().equals( "James" ) ? "success" : "failed";
    }*/
}
