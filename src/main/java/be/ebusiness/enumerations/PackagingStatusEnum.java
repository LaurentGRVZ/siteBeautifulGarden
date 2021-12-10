package be.ebusiness.enumerations;

/**
 * Enum for the Packaging class.
 *
 * @author Laurent GRAVEZ
 */

public enum PackagingStatusEnum {

    WAITING("WAITING"),
    VALIDATED("VALIDATED");

    private final String label;

    PackagingStatusEnum(String label) { this.label = label; }

    public String getLabel() {
        return label;
    }
}
