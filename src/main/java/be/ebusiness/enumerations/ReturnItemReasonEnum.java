package be.ebusiness.enumerations;

/**
 * Enum for the Packaging class.
 *
 * @author Laurent GRAVEZ
 */

public enum ReturnItemReasonEnum {

    GUARANTEE("GUARANTEE"),
    REJECTED("REJECTED"),
    CANCELLED("CANCELLED");

    private final String label;

    ReturnItemReasonEnum(String label) { this.label = label; }

    public String getLabel() {
        return label;
    }
}
