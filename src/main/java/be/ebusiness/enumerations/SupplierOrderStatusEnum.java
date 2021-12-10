package be.ebusiness.enumerations;

/**
 * Enum for the SupplierOrder class.
 *
 * @author Laurent GRAVEZ
 */

public enum SupplierOrderStatusEnum {

    WAITING("WAITING"),
    DELIVERED("DELIVERED"),
    CANCELLED("CANCELLED");

    private final String label;

    SupplierOrderStatusEnum(String label) { this.label = label; }

    public String getLabel() {
        return label;
    }
}
