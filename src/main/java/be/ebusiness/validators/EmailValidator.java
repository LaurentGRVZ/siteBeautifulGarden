package be.ebusiness.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.regex.Pattern;

import static be.ebusiness.services.UserService.findUserByMail;

@FacesValidator("EmailValidator")
public class EmailValidator implements Validator {

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {

        //Retrieve the value passed to this method
        String email = (String) o;

        //Check if the email is valid
        if (!Pattern.matches("^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$", email)) {
            String message = facesContext.getApplication().evaluateExpressionGet(facesContext, "#{txt['form.errorEmail1']}", String.class);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);
            throw new ValidatorException(msg);
        }

        //Check if the email already exist
        if (!(findUserByMail(email) == null)) {
            String message = facesContext.getApplication().evaluateExpressionGet(facesContext, "#{txt['form.errorEmail2']}", String.class);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);
            throw new ValidatorException(msg);
        }
    }
}
