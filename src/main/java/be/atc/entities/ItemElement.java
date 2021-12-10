package be.atc.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "items_elements", schema = "stockmanagement", catalog = "")
public class ItemElement {
    private int id;
    private double price;
    private int quantity;
    private CustomerOrder customersOrdersByIdCustomerOrder;
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
    @Column(name = "price", nullable = false, precision = 0)
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "quantity", nullable = false)
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemElement that = (ItemElement) o;
        return id == that.id &&
                Double.compare(that.price, price) == 0 &&
                quantity == that.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, quantity);
    }

    @ManyToOne
    @JoinColumn(name = "id_customer_order", referencedColumnName = "id")
    public CustomerOrder getCustomersOrdersByIdCustomerOrder() {
        return customersOrdersByIdCustomerOrder;
    }

    public void setCustomersOrdersByIdCustomerOrder(CustomerOrder customersOrdersByIdCustomerOrder) {
        this.customersOrdersByIdCustomerOrder = customersOrdersByIdCustomerOrder;
    }

    @ManyToOne
    @JoinColumn(name = "id_item", referencedColumnName = "id", nullable = false)
    public Item getItemsByIdItem() {
        return itemsByIdItem;
    }

    public void setItemsByIdItem(Item itemsByIdItem) {
        this.itemsByIdItem = itemsByIdItem;
    }
}
