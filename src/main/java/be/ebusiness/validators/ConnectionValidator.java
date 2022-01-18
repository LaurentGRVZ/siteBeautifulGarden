package be.ebusiness.validators;

import be.ebusiness.entities.User;
import org.mindrot.jbcrypt.BCrypt;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpSession;

import static be.ebusiness.services.UserService.findUserByMail;
import static be.ebusiness.tools.SessionTool.getSession;

@FacesValidator("ConnectionValidator")
public class ConnectionValidator implements Validator {

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {

        //Retrieve the value passed to this method
        String pwd = (String) o;

        //Retrieve the temporary value from the email field
        UIInput emailInput = (UIInput) uiComponent.findComponent("login");
        String email = (String) emailInput.getLocalValue();

        User user = findUserByMail(email);

        if((user != null) && (BCrypt.checkpw(pwd, user.getPassword()))){

            HttpSession session = getSession();
            session.setAttribute("connectedUser", user);

        }else{
            String message = facesContext.getApplication().evaluateExpressionGet(facesContext, "#{txt['form.errorConnection']}", String.class);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);
            throw new ValidatorException(msg);

        }
    }
}
