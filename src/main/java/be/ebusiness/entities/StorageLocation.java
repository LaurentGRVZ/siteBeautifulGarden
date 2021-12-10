package be.ebusiness.entities;


import be.ebusiness.enumerations.StorageLocationTypeLocationEnum;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * The persistent class for the storage_locations database table.
 *
 * @author Laurent GRAVEZ
 */

@Entity
@Table(name = "storage_locations", schema = "ebusiness")
public class StorageLocation implements Serializable {

    //Properties

    private static final long serialVersionUID= 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name = "label")
    @NotNull
    @Size(max = 100)
    private String label;

    @Column(name = "type_location")
    @NotNull
    private StorageLocationTypeLocationEnum storageLocationTypeLocationEnum;

    @Column(name="created_at")
    private LocalDateTime createdAt;

    @Column(name="updated_at")
    private LocalDateTime updatedAt;

    //uni-directional many-to-one association to Address
    @ManyToOne
    @JoinColumn(name="id_address")
    private Address address;


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

    public StorageLocationTypeLocationEnum getStorageLocationTypeLocationEnum() { return storageLocationTypeLocationEnum; }

    public void setStorageLocationTypeLocationEnum(StorageLocationTypeLocationEnum storageLocationTypeLocationEnum) { this.storageLocationTypeLocationEnum = storageLocationTypeLocationEnum; }

    public LocalDateTime getCreatedAt() { return createdAt; }

    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }

    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    public Address getAddress() { return address; }

    public void setAddress(Address address) { this.address = address; }


    //Methods

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StorageLocation that = (StorageLocation) o;
        return id == that.id &&
                Objects.equals(label, that.label) &&
                Objects.equals(storageLocationTypeLocationEnum, that.storageLocationTypeLocationEnum) &&
                Objects.equals(createdAt, that.createdAt) &&
                Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, label, storageLocationTypeLocationEnum, createdAt, updatedAt);
    }


}
