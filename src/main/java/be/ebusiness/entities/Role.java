package be.ebusiness.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * The persistent class for the roles database table.
 *
 * @author Laurent GRAVEZ
 */

@Entity
@Table(name = "roles", schema = "ebusiness")
@NamedQuery(name = "Role.findAll", query = "SELECT r FROM Role r")

public class Role implements Serializable {

    //Properties

    private static final long serialVersionUID= 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name = "label")
    @NotNull
    @Size(min = 4, max = 100)
    private String label;

    @Column(name="created_at")
    private LocalDateTime createdAt;

    @Column(name="updated_at")
    private LocalDateTime updatedAt;


    //Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }


    //Methods

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return id == role.id &&
                Objects.equals(label, role.label) &&
                Objects.equals(createdAt, role.createdAt) &&
                Objects.equals(updatedAt, role.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, label, createdAt, updatedAt);
    }
}
