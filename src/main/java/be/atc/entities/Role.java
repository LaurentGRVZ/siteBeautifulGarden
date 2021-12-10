package be.atc.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "roles", schema = "stockmanagement", catalog = "")
public class Role {
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
        Role role = (Role) o;
        return id == role.id &&
                Objects.equals(label, role.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, label);
    }
}
