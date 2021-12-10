package be.ebusiness.enumerations;

/**
 * Enum for the StorageLocation class.
 *
 * @author Laurent GRAVEZ
 */

public enum StorageLocationTypeLocationEnum {

    SHOP("SHOP"),
    WAREHOUSE("WAREHOUSE");

    private final String label;

    StorageLocationTypeLocationEnum(String label) { this.label = label; }

    public String getLabel() {
        return label;
    }
}
