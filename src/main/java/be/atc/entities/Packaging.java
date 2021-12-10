package be.atc.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "packagings", schema = "stockmanagement", catalog = "")
public class Packaging {
    private int id;
    private Object packagingType;
    private double volume;
    private double weight;
    private Object status;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "packaging_type", nullable = false)
    public Object getPackagingType() {
        return packagingType;
    }

    public void setPackagingType(Object packagingType) {
        this.packagingType = packagingType;
    }

    @Basic
    @Column(name = "volume", nullable = false, precision = 0)
    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    @Basic
    @Column(name = "weight", nullable = false, precision = 0)
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Basic
    @Column(name = "status", nullable = false)
    public Object getStatus() {
        return status;
    }

    public void setStatus(Object status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Packaging packaging = (Packaging) o;
        return id == packaging.id &&
                Double.compare(packaging.volume, volume) == 0 &&
                Double.compare(packaging.weight, weight) == 0 &&
                Objects.equals(packagingType, packaging.packagingType) &&
                Objects.equals(status, packaging.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, packagingType, volume, weight, status);
    }
}
