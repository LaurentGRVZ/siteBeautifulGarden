package be.ebusiness.enumerations;

/**
 * Enum for the Order class.
 *
 * @author Laurent GRAVEZ
 */

public enum OrderStatusEnum {

    WAITING("WAITING"),
    VALIDATED("VALIDATED");

    private final String label;

    OrderStatusEnum(String label) { this.label = label; }

    public String getLabel() {
        return label;
    }
}
