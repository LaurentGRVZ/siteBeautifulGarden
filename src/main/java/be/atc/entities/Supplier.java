package be.atc.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "suppliers", schema = "stockmanagement", catalog = "")
public class Supplier {
    private int id;
    private String name;
    private String mail;
    private String phone;
    private String vatNumber;
    private String businessNumber;
    private String bankAccount;
    private String contactPerson;
    private boolean active;
    private Address addressesByIdAddress;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    @Column(name = "phone", nullable = false, length = 30)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
    @Column(name = "bank_account", nullable = true, length = 30)
    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Basic
    @Column(name = "contact_person", nullable = true, length = 100)
    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
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
        Supplier supplier = (Supplier) o;
        return id == supplier.id &&
                active == supplier.active &&
                Objects.equals(name, supplier.name) &&
                Objects.equals(mail, supplier.mail) &&
                Objects.equals(phone, supplier.phone) &&
                Objects.equals(vatNumber, supplier.vatNumber) &&
                Objects.equals(businessNumber, supplier.businessNumber) &&
                Objects.equals(bankAccount, supplier.bankAccount) &&
                Objects.equals(contactPerson, supplier.contactPerson);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, mail, phone, vatNumber, businessNumber, bankAccount, contactPerson, active);
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
