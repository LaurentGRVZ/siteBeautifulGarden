package be.atc.entities;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "users", schema = "stockmanagement", catalog = "")
public class User {
    private int id;
    private String lastname;
    private String firstname;
    private String mail;
    private String password;
    private byte[] salt;
    private String vatNumber;
    private String businessNumber;
    private boolean active;
    private Role rolesByIdRole;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "lastname", nullable = false, length = 100)
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Basic
    @Column(name = "firstname", nullable = false, length = 100)
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Basic
    @Column(name = "mail", nullable = false, length = 255)
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 255)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "salt", nullable = true)
    public byte[] getSalt() {
        return salt;
    }

    public void setSalt(byte[] salt) {
        this.salt = salt;
    }

    @Basic
    @Column(name = "vat_number", nullable = true, length = 30)
    public String getVatNumber() {
        return vatNumber;
    }

    public void setVatNumber(String vatNumber) {
        this.vatNumber = vatNumber;
    }

    @Basic
    @Column(name = "business_number", nullable = true, length = 30)
    public String getBusinessNumber() {
        return businessNumber;
    }

    public void setBusinessNumber(String businessNumber) {
        this.businessNumber = businessNumber;
    }

    @Basic
    @Column(name = "active", nullable = false)
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                active == user.active &&
                Objects.equals(lastname, user.lastname) &&
                Objects.equals(firstname, user.firstname) &&
                Objects.equals(mail, user.mail) &&
                Objects.equals(password, user.password) &&
                Arrays.equals(salt, user.salt) &&
                Objects.equals(vatNumber, user.vatNumber) &&
                Objects.equals(businessNumber, user.businessNumber);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, lastname, firstname, mail, password, vatNumber, businessNumber, active);
        result = 31 * result + Arrays.hashCode(salt);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_role", referencedColumnName = "id", nullable = false)
    public Role getRolesByIdRole() {
        return rolesByIdRole;
    }

    public void setRolesByIdRole(Role rolesByIdRole) {
        this.rolesByIdRole = rolesByIdRole;
    }
}
