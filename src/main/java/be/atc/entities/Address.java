package be.atc.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "addresses", schema = "stockmanagement", catalog = "")
public class Address {
    private int id;
    private String street;
    private String postnumber;
    private String postbox;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "street", nullable = false, length = 100)
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Basic
    @Column(name = "postnumber", nullable = false, length = 6)
    public String getPostnumber() {
        return postnumber;
    }

    public void setPostnumber(String postnumber) {
        this.postnumber = postnumber;
    }

    @Basic
    @Column(name = "postbox", nullable = true, length = 6)
    public String getPostbox() {
        return postbox;
    }

    public void setPostbox(String postbox) {
        this.postbox = postbox;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return id == address.id &&
                Objects.equals(street, address.street) &&
                Objects.equals(postnumber, address.postnumber) &&
                Objects.equals(postbox, address.postbox);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, street, postnumber, postbox);
    }
}
