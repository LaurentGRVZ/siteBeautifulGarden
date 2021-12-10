package be.atc.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "trucks", schema = "stockmanagement", catalog = "")
public class Truck {
    private int id;
    private String label;
    private double price;
    private Carrier carriersByIdCarrier;

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
    @Column(name = "price", nullable = false, precision = 0)
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Truck truck = (Truck) o;
        return id == truck.id &&
                Double.compare(truck.price, price) == 0 &&
                Objects.equals(label, truck.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, label, price);
    }

    @ManyToOne
    @JoinColumn(name = "id_carrier", referencedColumnName = "id")
    public Carrier getCarriersByIdCarrier() {
        return carriersByIdCarrier;
    }

    public void setCarriersByIdCarrier(Carrier carriersByIdCarrier) {
        this.carriersByIdCarrier = carriersByIdCarrier;
    }
}
