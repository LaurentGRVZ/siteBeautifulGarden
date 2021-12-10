package be.ebusiness.enumerations;

/**
 * Enum for the Rma class.
 *
 * @author Laurent GRAVEZ
 */

public enum RmaStatusEnum {

    WAITING("WAITING"),
    CONFIRMATED("CONFIRMATED");

    private final String label;

    RmaStatusEnum(String label) { this.label = label; }

    public String getLabel() {
        return label;
    }
}
