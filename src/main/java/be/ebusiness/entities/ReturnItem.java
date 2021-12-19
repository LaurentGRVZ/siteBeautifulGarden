package be.ebusiness.entities;

import be.ebusiness.enumerations.ReturnItemReasonEnum;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;


/**
 * The persistent class for the return_items database table.
 *
 * @author Laurent GRAVEZ
 */

@Entity
@Table(name = "return_items", schema = "ebusiness")
public class ReturnItem implements Serializable {

    //Properties

    private static final long serialVersionUID= 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name="quantity")
    @NotNull
    private int quantity;

    @Column(name="reason")
    @NotNull
    private ReturnItemReasonEnum reason;

    @Column(name="created_at")
    private LocalDateTime createdAt;

    @Column(name="updated_at")
    private LocalDateTime updatedAt;

    //uni-directional many-to-one association to Rma
    @ManyToOne
    @JoinColumn(name="id_rma")
    private Rma rma;

    //uni-directional many-to-one association to Item element
    @ManyToOne
    @JoinColumn(name="id_item_element")
    private ItemElement itemElement;


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

    public ReturnItemReasonEnum getReason() { return reason; }

    public void setReason(ReturnItemReasonEnum reason) { this.reason = reason; }

    public LocalDateTime getCreatedAt() { return createdAt; }

    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }

    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    public Rma getRma() { return rma; }

    public void setRma(Rma rma) { this.rma = rma; }

    public ItemElement getItemElement() { return itemElement; }

    public void setItemElement(ItemElement itemElement) {this.itemElement = itemElement; }


    //Methods

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReturnItem that = (ReturnItem) o;
        return id == that.id &&
                quantity == that.quantity &&
                Objects.equals(reason, that.reason) &&
                Objects.equals(createdAt, that.createdAt) &&
                Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quantity, reason, createdAt, updatedAt);
    }

}
