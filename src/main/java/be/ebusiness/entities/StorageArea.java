package be.ebusiness.entities;


import be.ebusiness.enumerations.StorageAreaStatusEnum;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * The persistent class for the storage_areas database table.
 *
 * @author Laurent GRAVEZ
 */

@Entity
@Table(name = "storage_areas", schema = "ebusiness")
public class StorageArea implements Serializable {

    //Properties

    private static final long serialVersionUID= 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name = "label")
    @NotNull
    @Size(max = 100)
    private String label;

    @Column(name = "status")
    @NotNull
    private StorageAreaStatusEnum storageAreaStatusEnum;

    @Column(name="created_at")
    private LocalDateTime createdAt;

    @Column(name="updated_at")
    private LocalDateTime updatedAt;

    //uni-directional many-to-one association to StorageLocation
    @ManyToOne
    @JoinColumn(name="id_storage_location")
    private StorageLocation storageLocation;


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

    public StorageAreaStatusEnum getStorageAreaStatusEnum() { return storageAreaStatusEnum; }

    public void setStorageAreaStatusEnum(StorageAreaStatusEnum storageAreaStatusEnum) { this.storageAreaStatusEnum = storageAreaStatusEnum; }

    public LocalDateTime getCreatedAt() { return createdAt; }

    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }

    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    public StorageLocation getStorageLocation() { return storageLocation; }

    public void setStorageLocation(StorageLocation storageLocation) { this.storageLocation = storageLocation; }


    //Methods

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StorageArea that = (StorageArea) o;
        return id == that.id &&
                Objects.equals(label, that.label) &&
                Objects.equals(storageAreaStatusEnum, that.storageAreaStatusEnum) &&
                Objects.equals(createdAt, that.createdAt) &&
                Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, label, storageAreaStatusEnum, createdAt, updatedAt);
    }
}
