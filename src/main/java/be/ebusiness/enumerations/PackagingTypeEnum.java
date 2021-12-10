package be.ebusiness.enumerations;

/**
 * Enum for the Packaging class.
 *
 * @author Laurent GRAVEZ
 */

public enum PackagingTypeEnum {

    PACKAGE("PACKAGE"),
    PALLET("PALLET");

    private final String label;

    PackagingTypeEnum(String label) { this.label = label; }

    public String getLabel() {
        return label;
    }
}
