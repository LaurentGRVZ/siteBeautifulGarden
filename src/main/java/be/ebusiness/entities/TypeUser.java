package be.ebusiness.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * The persistent class for the type_users database table.
 *
 * @author Laurent GRAVEZ
 */

@Entity
@Table(name = "type_users", schema = "ebusiness")
public class TypeUser implements Serializable {

    //Properties

    private static final long serialVersionUID= 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Basic
    @Column(name = "label")
    @NotNull
    @Size(min = 3, max = 255)
    private String label;

    @Column(name="created_at")
    private LocalDateTime createdAt;

    @Column(name="updated_at")
    private LocalDateTime updatedAt;


    //Getters and setters

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getLabel() { return label; }

    public void setLabel(String label) { this.label = label; }

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
        TypeUser typeUser = (TypeUser) o;
        return id == typeUser.id &&
                Objects.equals(label, typeUser.label) &&
                Objects.equals(createdAt, typeUser.createdAt) &&
                Objects.equals(updatedAt, typeUser.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, label, createdAt, updatedAt);
    }
}
