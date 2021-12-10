package be.atc.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "stocks_areas", schema = "stockmanagement", catalog = "")
public class StockArea {
    private int id;
    private String label;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "label", nullable = false, length = 50)
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
        StockArea stockArea = (StockArea) o;
        return id == stockArea.id &&
                Objects.equals(label, stockArea.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, label);
    }
}
