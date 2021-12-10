package be.ebusiness.entities;


import be.ebusiness.enumerations.SupplierOrderStatusEnum;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;


/**
 * The persistent class for the supplier_orders database table.
 *
 * @author Laurent GRAVEZ
 */

@Entity
@Table(name = "supplier_orders", schema = "ebusiness")
public class SupplierOrder implements Serializable {

    //Properties

    private static final long serialVersionUID= 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name = "status")
    @NotNull
    private SupplierOrderStatusEnum supplierOrderStatusEnum;

    @Column(name="created_at")
    private LocalDateTime createdAt;

    @Column(name="updated_at")
    private LocalDateTime updatedAt;

    //uni-directional many-to-one association to User
    @ManyToOne
    @JoinColumn(name="id_user")
    private User user;

    //uni-directional many-to-one association to Supplier
    @ManyToOne
    @JoinColumn(name="id_supplier")
    private Supplier supplier;


    //Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SupplierOrderStatusEnum getSupplierOrderStatusEnum() { return supplierOrderStatusEnum; }

    public void setSupplierOrderStatusEnum(SupplierOrderStatusEnum supplierOrderStatusEnum) { this.supplierOrderStatusEnum = supplierOrderStatusEnum; }

    public LocalDateTime getCreatedAt() { return createdAt; }

    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }

    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    public Supplier getSupplier() { return supplier; }

    public void setSupplier(Supplier supplier) { this.supplier = supplier; }


    //Methods

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SupplierOrder that = (SupplierOrder) o;
        return id == that.id &&
                Objects.equals(supplierOrderStatusEnum, that.supplierOrderStatusEnum) &&
                Objects.equals(createdAt, that.createdAt) &&
                Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, supplierOrderStatusEnum, createdAt, updatedAt);
    }
}
