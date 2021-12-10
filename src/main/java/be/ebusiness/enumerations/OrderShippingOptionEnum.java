package be.ebusiness.enumerations;


/**
 * Enum for the Order class.
 *
 * @author Laurent GRAVEZ
 */


public enum OrderShippingOptionEnum {

    NORMAL("NORMAL"),
    REPOINT("RELAY POINT"),
    EXPRESS("EXPRESS"),
    CASH("CASH");

    private final String label;

    OrderShippingOptionEnum(String label) { this.label = label; }

    public String getLabel() {
        return label;
    }
}
