package be.ebusiness.tools;


import be.ebusiness.entities.User;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author Laurent GRAVEZ
 *
 *
 */

public class SessionTool {

    public static HttpSession getSession() {
        return (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);
    }

    public static HttpServletRequest getRequest() {
        return (HttpServletRequest) FacesContext.getCurrentInstance()
                .getExternalContext().getRequest();
    }

    public static User getConnectedUser() {
        HttpSession session = getSession();
        if (session != null)
            return (User)session.getAttribute("connectedUser");
        else
            return null;
    }
}
