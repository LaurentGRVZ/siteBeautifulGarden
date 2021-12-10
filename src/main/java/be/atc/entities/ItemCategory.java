package be.atc.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "items_categories", schema = "stockmanagement", catalog = "")
public class ItemCategory {
    private int id;
    private Item itemsByIdItem;
    private Category categoriesByIdCategorie;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemCategory that = (ItemCategory) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @ManyToOne
    @JoinColumn(name = "id_item", referencedColumnName = "id", nullable = false)
    public Item getItemsByIdItem() {
        return itemsByIdItem;
    }

    public void setItemsByIdItem(Item itemsByIdItem) {
        this.itemsByIdItem = itemsByIdItem;
    }

    @ManyToOne
    @JoinColumn(name = "id_categorie", referencedColumnName = "id", nullable = false)
    public Category getCategoriesByIdCategorie() {
        return categoriesByIdCategorie;
    }

    public void setCategoriesByIdCategorie(Category categoriesByIdCategorie) {
        this.categoriesByIdCategorie = categoriesByIdCategorie;
    }
}
