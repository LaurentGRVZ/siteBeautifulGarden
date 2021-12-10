package be.ebusiness.enumerations;

/**
 * Enum for the StorageArea class.
 *
 * @author Laurent GRAVEZ
 */

public enum StorageAreaStatusEnum {

    AVAILABLE("AVAILABLE"),
    UNVAILABLE("UNVAILABLE");

    private final String label;

    StorageAreaStatusEnum(String label) { this.label = label; }

    public String getLabel() {
        return label;
    }
}
