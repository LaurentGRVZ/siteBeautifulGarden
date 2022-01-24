package be.ebusiness.enumerations;

/**
 * Enum for the ItemStorageLocation class.
 *
 * @author Laurent GRAVEZ
 */

public enum ItemStorageLocationAlertEnum {

    OK("OK"),
    ALERT("ALERT");

    private final String label;

    ItemStorageLocationAlertEnum(String label) { this.label = label; }

    public String getLabel() {
        return label;
    }
}
