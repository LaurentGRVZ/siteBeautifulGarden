package be.ebusiness.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * The persistent class for the cities database table.
 *
 * @author Laurent GRAVEZ
 */

@Entity
@Table(name = "cities", schema = "ebusiness")
public class City implements Serializable {

    //Properties

    private static final long serialVersionUID= 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name = "label")
    @NotNull
    @Size(min=2, max = 100)
    private String label;

    @Column(name = "zip_code")
    @NotNull
    @Size(min=3, max=10)
    private String zipCode;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    //bi-directional many-to-one association to Country
    @ManyToOne
    @JoinColumn(name="id_country")
    private Country country;


    //Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() { return updatedAt; }

    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    public Country getCountry() { return country; }

    public void setCountry(Country country) { this.country = country; }


    //Methods

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return id == city.id &&
                Objects.equals(label, city.label) &&
                Objects.equals(zipCode, city.zipCode) &&
                Objects.equals(createdAt, city.createdAt) &&
                Objects.equals(updatedAt, city.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, label, zipCode, createdAt, updatedAt);
    }
}
