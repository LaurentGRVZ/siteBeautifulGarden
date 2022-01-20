package be.ebusiness.beans;

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
public class LoginBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private String login;
    private String pwd;


    //Methods

    public String validateUser(){ return "connected"; }

    public String logout(){
        HttpSession session = getSession();
        session.invalidate();
        return "sessionOut";
    }


    //Getters and setters

    public String getLogin() { return login; }

    public void setLogin(String login) { this.login = login; }

    public String getPwd() { return pwd; }

    public void setPwd(String pwd) { this.pwd = pwd; }

}
