package be.ebusiness.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.regex.Pattern;

import static be.ebusiness.services.UserService.findUserByVatNumber;

@FacesValidator("VatValidator")
public class VatValidator implements Validator {

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {

        //Later I will do the modulo validation 97

        //Retrieve the value passed to this method
        String vat = (String) o;

        //Check if the vat number is valid in intracommunity
        if (!Pattern.matches("^((AT)?U[0-9]{8}|(BE)?0[0-9]{9}|(BG)?[0-9]{9,10}|(CY)?[ 0-9]{8}L|↵\n" +
                "(CZ) ?[0-9]{8,10}|(DE) ?[0-9]{9}|(DK) ?[0-9]{8}|(EE) ?[0-9] {9}|↵\n" +
                "(EL|GR) ?[0-9]{9}|(ES) ?[0-9A-Z][0-9]{7}[0-9A-Z]|(FI) ?[0-9 ]{8}|↵\n" +
                "(FR) ?[0-9A-Z]{2}[0-9]{9}|(GB) ?([0-9]{9}([0-9]{3}) ?|[AZ ]{2}[0-9]{3})|↵\n" +
                "(HU) ?[0-9]{8}|(IE) ?[0-9]S[0-9]{5}L|(IT) ?[0-9]{11}|↵\n" +
                "(LT) ?([0-9]{9}|[0-9]{12})|(LU) ?[0-9]{8}|(LV) ?[0-9]{11}| (MT) ?[0-9]{8}|↵\n" +
                "(NL) ?[0-9]{9}B[0-9]{2}|(PL) ?[0-9]{10}|(PT) ?[0-9]{9}|(RO )?[0-9]{2,10}|↵\n" +
                "(SE) ?[0-9]{12}|(SI) ?[0-9]{8}|(SK) ?[0-9]{10})$", vat)) {
            String message = facesContext.getApplication().evaluateExpressionGet(facesContext, "#{txt['form.errorVat1']}", String.class);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);
            throw new ValidatorException(msg);
        }

        //Check if the vat number already exist
        if (!(findUserByVatNumber(vat) == null)) {
            String message = facesContext.getApplication().evaluateExpressionGet(facesContext, "#{txt['form.errorVat2']}", String.class);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);
            throw new ValidatorException(msg);
        }
    }
}
