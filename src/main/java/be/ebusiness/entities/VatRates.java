package be.ebusiness.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * The persistent class for the vat_rates database table.
 *
 * @author Laurent GRAVEZ
 */

@Entity
@Table(name = "vat_rates", schema = "ebusiness")
public class VatRates implements Serializable {

    //Properties

    private static final long serialVersionUID= 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name = "rate")
    @NotNull
    private float rate;

    @Column(name="created_at")
    private LocalDateTime createdAt;

    @Column(name="updated_at")
    private LocalDateTime updatedAt;


    //Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getRate() { return rate; }

    public void setRate(float rate) { this.rate = rate; }

    public LocalDateTime getCreatedAt() { return createdAt; }

    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }

    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }


    //Methods

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VatRates vatRates = (VatRates) o;
        return id == vatRates.id &&
                Double.compare(vatRates.rate, rate) == 0 &&
                Objects.equals(createdAt, vatRates.createdAt) &&
                Objects.equals(updatedAt, vatRates.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rate, createdAt, updatedAt);
    }
}
