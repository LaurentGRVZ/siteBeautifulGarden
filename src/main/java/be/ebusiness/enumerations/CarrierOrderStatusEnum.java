package be.ebusiness.enumerations;

/**
 * Enum for the CarrierOrder class.
 *
 * @author Laurent GRAVEZ
 */

public enum CarrierOrderStatusEnum {

    WAITING("WAITING"),
    DELIVERED("DELIVERED"),
    CANCELLED("CANCELLED"),
    OTHER("OTHER");

    private final String label;

    CarrierOrderStatusEnum(String label) { this.label = label; }

    public String getLabel() {
        return label;
    }
}
