package be.atc.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "items", schema = "stockmanagement", catalog = "")
public class Item {
    private int id;
    private String designation;
    private String description;
    private String pictureUrl;
    private long barcode;
    private double price;
    private double volume;
    private double weight;
    private boolean active;
    private Brand brandsByIdBrand;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "designation", nullable = false, length = 100)
    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Basic
    @Column(name = "description", nullable = true, length = 255)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "picture_url", nullable = true, length = 255)
    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    @Basic
    @Column(name = "barcode", nullable = false)
    public long getBarcode() {
        return barcode;
    }

    public void setBarcode(long barcode) {
        this.barcode = barcode;
    }

    @Basic
    @Column(name = "price", nullable = false, precision = 0)
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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
        Item item = (Item) o;
        return id == item.id &&
                barcode == item.barcode &&
                Double.compare(item.price, price) == 0 &&
                Double.compare(item.volume, volume) == 0 &&
                Double.compare(item.weight, weight) == 0 &&
                active == item.active &&
                Objects.equals(designation, item.designation) &&
                Objects.equals(description, item.description) &&
                Objects.equals(pictureUrl, item.pictureUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, designation, description, pictureUrl, barcode, price, volume, weight, active);
    }

    @ManyToOne
    @JoinColumn(name = "id_brand", referencedColumnName = "id", nullable = false)
    public Brand getBrandsByIdBrand() {
        return brandsByIdBrand;
    }

    public void setBrandsByIdBrand(Brand brandsByIdBrand) {
        this.brandsByIdBrand = brandsByIdBrand;
    }
}
