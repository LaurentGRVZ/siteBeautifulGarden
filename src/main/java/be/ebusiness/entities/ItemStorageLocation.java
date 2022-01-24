package be.ebusiness.entities;

import be.ebusiness.enumerations.ItemStorageLocationAlertEnum;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * The persistent class for the items_storage_locations database table.
 *
 * @author Laurent GRAVEZ
 */

@Entity
@Table(name = "items_storage_locations", schema = "ebusiness")
@NamedQuery(name = "ItemStorageLocation.findQuantityItem", query = "SELECT i FROM ItemStorageLocation i WHERE i.item.id = :id")

public class ItemStorageLocation implements Serializable {

    //Properties

    private static final long serialVersionUID= 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name = "quantity")
    @NotNull
    private int quantity;

    @Column(name = "critical_stock")
    @NotNull
    private int criticalStock;

    @Column(name= "alert")
    @Enumerated(EnumType.STRING)
    @NotNull
    private ItemStorageLocationAlertEnum itemStorageLocationAlertEnum;

    @Column(name="created_at")
    private LocalDateTime createdAt;

    @Column(name="updated_at")
    private LocalDateTime updatedAt;

    //uni-directional many-to-one association to Item
    @ManyToOne
    @JoinColumn(name="id_item")
    private Item item;

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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCriticalStock() { return criticalStock; }

    public void setCriticalStock(int criticalStock) { this.criticalStock = criticalStock; }

    public ItemStorageLocationAlertEnum getItemStorageLocationAlertEnum() { return itemStorageLocationAlertEnum; }

    public void setItemStorageLocationAlertEnum(ItemStorageLocationAlertEnum itemStorageLocationAlertEnum) { this.itemStorageLocationAlertEnum = itemStorageLocationAlertEnum; }

    public LocalDateTime getCreatedAt() { return createdAt; }

    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }

    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    public Item getItem() { return item; }

    public void setItem(Item item) { this.item = item; }

    public StorageLocation getStorageLocation() { return storageLocation; }

    public void setStorageLocation(StorageLocation storageLocation) { this.storageLocation = storageLocation; }


    //Methods

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemStorageLocation that = (ItemStorageLocation) o;
        return id == that.id &&
                quantity == that.quantity &&
                Objects.equals(itemStorageLocationAlertEnum, that.itemStorageLocationAlertEnum) &&
                Objects.equals(createdAt, that.createdAt) &&
                Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quantity, itemStorageLocationAlertEnum, createdAt, updatedAt);
    }

}
