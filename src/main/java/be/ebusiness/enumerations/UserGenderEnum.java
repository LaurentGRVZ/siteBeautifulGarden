package be.ebusiness.enumerations;

/**
 * Enum for the User class.
 *
 * @author Laurent GRAVEZ
 */

public enum UserGenderEnum {

    MR("MR"),
    MS("MS"),
    MX("MX");

    private final String label;

    UserGenderEnum (String label) { this.label = label; }

    public String getLabel() {
        return label;
    }
}
