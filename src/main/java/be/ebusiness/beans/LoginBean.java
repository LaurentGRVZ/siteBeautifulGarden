package be.ebusiness.beans;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class LoginBean implements Serializable {
    /*private static final long serialVersionUID = 1L;

    private String login;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String returnAction() {
        return getLogin().equals( "James" ) ? "success" : "failed";
    }*/
}
