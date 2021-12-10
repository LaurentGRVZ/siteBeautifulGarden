package be.ebusiness.enumerations;

/**
 * Enum for the ContactPerson class.
 *
 * @author Laurent GRAVEZ
 */

public enum ContactPersonGenderEnum {

    MR("MR"),
    MS("MS"),
    MX("MX");

    private final String label;

    ContactPersonGenderEnum (String label) { this.label = label; }

    public String getLabel() {
        return label;
    }
}
