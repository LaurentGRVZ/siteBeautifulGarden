package be.atc.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "cities", schema = "stockmanagement", catalog = "")
public class City {
    private int id;
    private String label;
    private String zipCode;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "label", nullable = false, length = 100)
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Basic
    @Column(name = "zip_code", nullable = false, length = 10)
    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return id == city.id &&
                Objects.equals(label, city.label) &&
                Objects.equals(zipCode, city.zipCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, label, zipCode);
    }
}
