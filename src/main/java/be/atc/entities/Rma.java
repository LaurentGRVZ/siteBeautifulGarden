package be.atc.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Rma {
    private int id;
    private String label;
    private ReturnItem returnsItemsByIdReturnItem;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "label", nullable = false, length = 100)
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rma rma = (Rma) o;
        return id == rma.id &&
                Objects.equals(label, rma.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, label);
    }

    @ManyToOne
    @JoinColumn(name = "id_return_item", referencedColumnName = "id", nullable = false)
    public ReturnItem getReturnsItemsByIdReturnItem() {
        return returnsItemsByIdReturnItem;
    }

    public void setReturnsItemsByIdReturnItem(ReturnItem returnsItemsByIdReturnItem) {
        this.returnsItemsByIdReturnItem = returnsItemsByIdReturnItem;
    }
}
