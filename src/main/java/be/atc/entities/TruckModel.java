package be.atc.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "trucks_models", schema = "stockmanagement", catalog = "")
public class TruckModel {
    private int id;
    private String label;
    private double maxWeight;
    private double maxVolume;
    private boolean active;

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
    @Column(name = "max_weight", nullable = false, precision = 0)
    public double getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    @Basic
    @Column(name = "max_volume", nullable = false, precision = 0)
    public double getMaxVolume() {
        return maxVolume;
    }

    public void setMaxVolume(double maxVolume) {
        this.maxVolume = maxVolume;
    }

    @Basic
    @Column(name = "active", nullable = false)
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TruckModel that = (TruckModel) o;
        return id == that.id &&
                Double.compare(that.maxWeight, maxWeight) == 0 &&
                Double.compare(that.maxVolume, maxVolume) == 0 &&
                active == that.active &&
                Objects.equals(label, that.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, label, maxWeight, maxVolume, active);
    }
}
