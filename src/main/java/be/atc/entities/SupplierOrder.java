package be.atc.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "suppliers_orders", schema = "stockmanagement", catalog = "")
public class SupplierOrder {
    private int id;
    private Timestamp orderDate;
    private Supplier suppliersByIdSupplier;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "order_date", nullable = false)
    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SupplierOrder that = (SupplierOrder) o;
        return id == that.id &&
                Objects.equals(orderDate, that.orderDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderDate);
    }

    @ManyToOne
    @JoinColumn(name = "id_supplier", referencedColumnName = "id", nullable = false)
    public Supplier getSuppliersByIdSupplier() {
        return suppliersByIdSupplier;
    }

    public void setSuppliersByIdSupplier(Supplier suppliersByIdSupplier) {
        this.suppliersByIdSupplier = suppliersByIdSupplier;
    }
}
