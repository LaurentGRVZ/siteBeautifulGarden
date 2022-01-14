package be.ebusiness.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.regex.Pattern;

import static be.ebusiness.services.UserService.findUserByCompanyNumber;

@FacesValidator("CompanyNbrValidator")
public class CompanyNbrValidator implements Validator {

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {

        //Retrieve the value passed to this method
        String companyNbr = (String) o;

        //Check if the company number is valid
            if (!Pattern.matches("^[0-9]{6,30}$", companyNbr)) {
            String message = facesContext.getApplication().evaluateExpressionGet(facesContext, "#{txt['form.errorCompanyNbr1']}", String.class);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);
            throw new ValidatorException(msg);
        }

        //Check if the company number already exist
            if (!(findUserByCompanyNumber(companyNbr) == null)) {
            String message = facesContext.getApplication().evaluateExpressionGet(facesContext, "#{txt['form.errorCompanyNbr2']}", String.class);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);
            throw new ValidatorException(msg);
        }
    }
}
