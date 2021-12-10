package be.ebusiness.enumerations;

/**
 * Enum for the Message class.
 *
 * @author Laurent GRAVEZ
 */

public enum MessageStatusEnum {

    WAITING("WAITING"),
    ANSWERED("ANSWERED");

    private final String label;

    MessageStatusEnum(String label) { this.label = label; }

    public String getLabel() {
        return label;
    }
}
