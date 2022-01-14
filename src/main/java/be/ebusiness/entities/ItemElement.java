package be.ebusiness.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * The persistent class for the item_elements database table.
 *
 * @author Laurent GRAVEZ
 */

@Entity
@Table(name = "item_elements", schema = "ebusiness")
public class ItemElement implements Serializable {

    //Properties

    private static final long serialVersionUID= 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name = "price")
    @NotNull
    private float price;

    @Column(name = "quantity")
    @NotNull
    private int quantity;

    @Column(name = "discount")
    @NotNull
    private int discount;

    @Column(name="created_at")
    private LocalDateTime createdAt;

    @Column(name="updated_at")
    private LocalDateTime updatedAt;

    //uni-directional many-to-one association to Order
    @ManyToOne
    @JoinColumn(name="id_order")
    private Order order;

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

    public float getPrice() { return price; }

    public void setPrice(float price) { this.price = price; }

    public LocalDateTime getCreatedAt() { return createdAt; }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }

    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    public Order getOrder() { return order; }

    public void setOrder(Order order) { this.order = order; }

    public Item getItem() { return item;}

    public void setItem(Item item) { this.item = item; }


    //Methods

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemElement that = (ItemElement) o;
        return id == that.id &&
                Double.compare(that.price, price) == 0 &&
                quantity == that.quantity &&
                discount == that.discount &&
                Objects.equals(createdAt, that.createdAt) &&
                Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, quantity, discount, createdAt, updatedAt);
    }
}
