package be.ebusiness.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * The persistent class for the suppliers database table.
 *
 * @author Laurent GRAVEZ
 */

@Entity
@Table(name = "suppliers", schema = "ebusiness")
public class Supplier implements Serializable {

    //Properties

    private static final long serialVersionUID= 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    @NotNull
    @Size(min = 2, max = 100)
    private String name;

    @Column(name = "phone")
    @NotNull
    @Size(max = 25)
    private String phone;

    @Column(name = "mail", unique = true)
    @NotNull
    @Size(max = 150)
    private String mail;

    @Column(name = "company_number", unique = true)
    @Size(max = 30)
    private String companyNumber;

    @Column(name = "vat_number", unique = true)
    @Size(max = 30)
    private String vatNumber;

    @Column(name = "bank_account", unique = true)
    @Size(max = 30)
    private String bankAccount;

    @Column(name = "active")
    @NotNull
    private boolean active;

    @Column(name="created_at")
    private LocalDateTime createdAt;

    @Column(name="updated_at")
    private LocalDateTime updatedAt;

    //uni-directional many-to-one association to Address
    @ManyToOne
    @JoinColumn(name="id_address")
    private Address address;


    //Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getCompanyNumber() { return companyNumber; }

    public void setCompanyNumber(String companyNumber) { this.companyNumber = companyNumber; }

    public String getVatNumber() {
        return vatNumber;
    }

    public void setVatNumber(String vatNumber) {
        this.vatNumber = vatNumber;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
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

    public Address getAddress() { return address; }

    public void setAddress(Address address) { this.address = address; }


    //Methods

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Supplier supplier = (Supplier) o;
        return id == supplier.id &&
                active == supplier.active &&
                Objects.equals(name, supplier.name) &&
                Objects.equals(phone, supplier.phone) &&
                Objects.equals(mail, supplier.mail) &&
                Objects.equals(companyNumber, supplier.companyNumber) &&
                Objects.equals(vatNumber, supplier.vatNumber) &&
                Objects.equals(bankAccount, supplier.bankAccount) &&
                Objects.equals(createdAt, supplier.createdAt) &&
                Objects.equals(updatedAt, supplier.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, phone, mail, companyNumber, vatNumber, bankAccount, active, createdAt, updatedAt);
    }
}
