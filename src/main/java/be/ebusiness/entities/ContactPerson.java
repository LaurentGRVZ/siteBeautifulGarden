package be.ebusiness.entities;


import be.ebusiness.enumerations.ContactPersonGenderEnum;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * The persistent class for the contact_persons database table.
 *
 * @author Laurent GRAVEZ
 */

@Entity
@Table(name = "contact_persons", schema = "ebusiness")
public class ContactPerson implements Serializable {

    //Properties

    private static final long serialVersionUID= 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name = "lastname")
    @NotNull
    @Size(min = 2, max = 100)
    private String lastname;

    @Column(name = "firstname")
    @NotNull
    @Size(min = 2, max = 100)
    private String firstname;

    @Column(name = "gender")
    @NotNull
    @Enumerated(EnumType.STRING)
    private ContactPersonGenderEnum contactPersonGenderEnum;

    @Column(name = "function")
    @NotNull
    @Size(max = 100)
    private String function;

    @Column(name = "mail", unique = true)
    @NotNull
    @Size(max = 150)
    private String mail;

    @Column(name = "phone")
    @NotNull
    @Size(max = 25)
    private String phone;

    @Column(name = "active")
    @NotNull
    private boolean active;

    @Column(name="created_at")
    private LocalDateTime createdAt;

    @Column(name="updated_at")
    private LocalDateTime updatedAt;

    //uni-directional many-to-one association to User
    @ManyToOne
    @JoinColumn(name="id_user")
    private User user;

    //uni-directional many-to-one association to Supplier
    @ManyToOne
    @JoinColumn(name="id_supplier")
    private Supplier supplier;

    //uni-directional many-to-one association to Carrier
    @ManyToOne
    @JoinColumn(name="id_carrier")
    private Carrier carrier;


    //Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public ContactPersonGenderEnum getContactPersonGenderEnum() { return contactPersonGenderEnum; }

    public void setContactPersonGenderEnum(ContactPersonGenderEnum contactPersonGenderEnum) { this.contactPersonGenderEnum = contactPersonGenderEnum; }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public LocalDateTime getCreatedAt() { return createdAt; }

    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }

    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    public Supplier getSupplier() { return supplier; }

    public void setSupplier(Supplier supplier) { this.supplier = supplier; }

    public Carrier getCarrier() { return carrier; }

    public void setCarrier(Carrier carrier) { this.carrier = carrier; }


    //Methods

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactPerson that = (ContactPerson) o;
        return id == that.id &&
                active == that.active &&
                Objects.equals(lastname, that.lastname) &&
                Objects.equals(firstname, that.firstname) &&
                Objects.equals(contactPersonGenderEnum, that.contactPersonGenderEnum) &&
                Objects.equals(function, that.function) &&
                Objects.equals(mail, that.mail) &&
                Objects.equals(phone, that.phone) &&
                Objects.equals(createdAt, that.createdAt) &&
                Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lastname, firstname, contactPersonGenderEnum, function, mail, phone, active, createdAt, updatedAt);
    }

}
