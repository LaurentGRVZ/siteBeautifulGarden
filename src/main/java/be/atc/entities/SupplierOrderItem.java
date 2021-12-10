package be.atc.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "suppliers_orders_items", schema = "stockmanagement", catalog = "")
public class SupplierOrderItem {
    private int id;
    private Integer quantity;
    private SupplierOrder suppliersOrdersByIdSupplierOrder;
    private Item itemsByIdItem;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "quantity", nullable = true)
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SupplierOrderItem that = (SupplierOrderItem) o;
        return id == that.id &&
                Objects.equals(quantity, that.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quantity);
    }

    @ManyToOne
    @JoinColumn(name = "id_supplier_order", referencedColumnName = "id")
    public SupplierOrder getSuppliersOrdersByIdSupplierOrder() {
        return suppliersOrdersByIdSupplierOrder;
    }

    public void setSuppliersOrdersByIdSupplierOrder(SupplierOrder suppliersOrdersByIdSupplierOrder) {
        this.suppliersOrdersByIdSupplierOrder = suppliersOrdersByIdSupplierOrder;
    }

    @ManyToOne
    @JoinColumn(name = "id_item", referencedColumnName = "id")
    public Item getItemsByIdItem() {
        return itemsByIdItem;
    }

    public void setItemsByIdItem(Item itemsByIdItem) {
        this.itemsByIdItem = itemsByIdItem;
    }
}
