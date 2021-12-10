package be.atc.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users_addresses", schema = "stockmanagement", catalog = "")
public class UserAddress {
    private int id;
    private User usersByIdUser;
    private Address addressesByIdAddress;

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
        UserAddress that = (UserAddress) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    public User getUsersByIdUser() {
        return usersByIdUser;
    }

    public void setUsersByIdUser(User usersByIdUser) {
        this.usersByIdUser = usersByIdUser;
    }

    @ManyToOne
    @JoinColumn(name = "id_address", referencedColumnName = "id", nullable = false)
    public Address getAddressesByIdAddress() {
        return addressesByIdAddress;
    }

    public void setAddressesByIdAddress(Address addressesByIdAddress) {
        this.addressesByIdAddress = addressesByIdAddress;
    }
}
