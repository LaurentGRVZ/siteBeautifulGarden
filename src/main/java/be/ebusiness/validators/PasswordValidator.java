package be.ebusiness.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("PasswordValidator")
public class PasswordValidator implements Validator {

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {

        //Retrieve the value passed to this method
        String confirmPassword = (String) o;

        //Retrieve the temporary value from the password field
        UIInput passwordInput = (UIInput) uiComponent.findComponent("pwd");
        String password = (String) passwordInput.getLocalValue();

        //Check if the password and password confirmation match
        if (password == null || !password.equals(confirmPassword) || password.length() > 35 || password.length() < 8) {
            String message = facesContext.getApplication().evaluateExpressionGet(facesContext, "#{txt['form.errorPassword1']}", String.class);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);
            throw new ValidatorException(msg);
        }
    }
}
