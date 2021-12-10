package be.ebusiness.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * The persistent class for the supplier_orders_items database table.
 *
 * @author Laurent GRAVEZ
 */

@Entity
@Table(name = "supplier_orders_items", schema = "ebusiness")
public class SupplierOrderItem implements Serializable {

    //Properties

    private static final long serialVersionUID= 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name = "quantity")
    @NotNull
    private int quantity;

    @Column(name="created_at")
    private LocalDateTime createdAt;

    @Column(name="updated_at")
    private LocalDateTime updatedAt;

    //uni-directional many-to-one association to Supplier_order
    @ManyToOne
    @JoinColumn(name="id_supplier_order")
    private SupplierOrder supplierOrder;

    //uni-directional many-to-one association to Item
    @ManyToOne
    @JoinColumn(name="id_item")
    private Item item;


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

    public LocalDateTime getCreatedAt() { return createdAt; }

    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }

    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    public SupplierOrder getSupplierOrder() { return supplierOrder; }

    public void setSupplierOrder(SupplierOrder supplierOrder) { this.supplierOrder = supplierOrder; }

    public Item getItem() { return item; }

    public void setItem(Item item) { this.item = item; }


    //Methods

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SupplierOrderItem that = (SupplierOrderItem) o;
        return id == that.id &&
                quantity == that.quantity &&
                Objects.equals(createdAt, that.createdAt) &&
                Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quantity, createdAt, updatedAt);
    }

}
