package be.ebusiness.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * The persistent class for the items database table.
 *
 * @author Laurent GRAVEZ
 */

@Entity
@Table(name = "items", schema = "ebusiness")
public class Item implements Serializable {

    //Properties

    private static final long serialVersionUID= 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name = "designation")
    @NotNull
    @Size(max = 255)
    private String designation;

    @Column(name = "description")
    @NotNull
    @Lob
    @Size(max = 512)
    private String description;

    @Column(name = "url_picture")
    @NotNull
    @Size(max = 255)
    private String urlPicture;

    @Column(name = "barcode")
    @NotNull
    private long barcode;

    @Column(name = "price")
    @NotNull
    private float price;

    @Column(name = "weight")
    @NotNull
    private float weight;

    @Column(name = "volume")
    @NotNull
    private float volume;

    @Column(name = "guarantee")
    @NotNull
    private int guarantee;

    @Column(name = "active")
    @NotNull
    private boolean active;

    @Column(name="created_at")
    private LocalDateTime createdAt;

    @Column(name="updated_at")
    private LocalDateTime updatedAt;

    //uni-directional many-to-one association to Brand
    @ManyToOne
    @JoinColumn(name="id_brand")
    private Brand brand;


    //Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrlPicture() {
        return urlPicture;
    }

    public void setUrlPicture(String urlPicture) {
        this.urlPicture = urlPicture;
    }

    public long getBarcode() {
        return barcode;
    }

    public void setBarcode(long barcode) {
        this.barcode = barcode;
    }

    public float getPrice() { return price; }

    public void setPrice(float price) { this.price = price; }

    public float getWeight() { return weight; }

    public void setWeight(float weight) { this.weight = weight; }

    public float getVolume() { return volume; }

    public void setVolume(float volume) { this.volume = volume; }

    public int getGuarantee() {
        return guarantee;
    }

    public void setGuarantee(int guarantee) {
        this.guarantee = guarantee;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public LocalDateTime getCreatedAt() { return createdAt; }

    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }

    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    public Brand getBrand() { return brand; }

    public void setBrand(Brand brand) { this.brand = brand; }


    //Methods

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return id == item.id &&
                barcode == item.barcode &&
                Double.compare(item.price, price) == 0 &&
                Double.compare(item.weight, weight) == 0 &&
                Double.compare(item.volume, volume) == 0 &&
                guarantee == item.guarantee &&
                active == item.active &&
                Objects.equals(designation, item.designation) &&
                Objects.equals(description, item.description) &&
                Objects.equals(urlPicture, item.urlPicture) &&
                Objects.equals(createdAt, item.createdAt) &&
                Objects.equals(updatedAt, item.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, designation, description, urlPicture, barcode, price, weight, volume, guarantee, active, createdAt, updatedAt);
    }

}
