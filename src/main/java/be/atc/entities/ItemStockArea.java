package be.atc.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "items_stocks_areas", schema = "stockmanagement", catalog = "")
public class ItemStockArea {
    private int id;
    private int quantity;
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
        ItemStockArea that = (ItemStockArea) o;
        return id == that.id &&
                quantity == that.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quantity);
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
