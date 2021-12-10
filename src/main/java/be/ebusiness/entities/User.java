package be.ebusiness.entities;


import be.ebusiness.enumerations.UserGenderEnum;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * The persistent class for the users database table.
 *
 * @author Laurent GRAVEZ
 */

@Entity
@Table(name = "users", schema = "ebusiness")
public class User implements Serializable {

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
    private UserGenderEnum gender;

    @Column(name = "birth_date")
    @NotNull
    private LocalDateTime birthDate;

    @Column(name = "phone")
    @NotNull
    @Size(max = 25)
    private String phone;

    @Column(name = "mail", unique = true)
    @NotNull
    @Size(max = 150)
    private String mail;

    @Column(name = "email_verified_at")
    @NotNull
    private LocalDateTime emailVerifiedAt;

    @Column(name = "password")
    @NotNull
    @Size(max = 255)
    private String password;

    @Column(name = "two_factor_secret")
    @Size(max = 255)
    private String twoFactorSecret;

    @Column(name = "two_factor_recovery_codes")
    @Size(max = 255)
    private String twoFactorRecoveryCodes;

    @Column(name = "remember_token")
    @Size(max = 255)
    private String rememberToken;

    @Column(name = "company_number", unique = true)
    @Size(max = 30)
    private String companyNumber;

    @Column(name = "vat_number", unique = true)
    @Size(max = 30)
    private String vatNumber;

    @Column(name = "active")
    @NotNull
    private boolean active;

    @Column(name="created_at")
    private LocalDateTime createdAt;

    @Column(name="updated_at")
    private LocalDateTime updatedAt;

    //uni-directional many-to-one association to UserType
    @ManyToOne
    @JoinColumn(name="id_user_type")
    private User user;

    //uni-directional many-to-one association to Role
    @ManyToOne
    @JoinColumn(name="id_role")
    private Address address;


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

    public UserGenderEnum getGender() { return gender; }

    public void setGender(UserGenderEnum gender) { this.gender = gender; }

    public LocalDateTime getBirthDate() { return birthDate; }

    public void setBirthDate(LocalDateTime birthDate) { this.birthDate = birthDate; }

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

    public LocalDateTime getEmailVerifiedAt() { return emailVerifiedAt; }

    public void setEmailVerifiedAt(LocalDateTime emailVerifiedAt) { this.emailVerifiedAt = emailVerifiedAt; }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTwoFactorSecret() {
        return twoFactorSecret;
    }

    public void setTwoFactorSecret(String twoFactorSecret) {
        this.twoFactorSecret = twoFactorSecret;
    }

    public String getTwoFactorRecoveryCodes() {
        return twoFactorRecoveryCodes;
    }

    public void setTwoFactorRecoveryCodes(String twoFactorRecoveryCodes) { this.twoFactorRecoveryCodes = twoFactorRecoveryCodes; }

    public String getRememberToken() { return rememberToken; }

    public void setRememberToken(String rememberToken) { this.rememberToken = rememberToken; }

    public String getCompanyNumber() { return companyNumber; }

    public void setCompanyNumber(String companyNumber) { this.companyNumber = companyNumber; }

    public String getVatNumber() {
        return vatNumber;
    }

    public void setVatNumber(String vatNumber) {
        this.vatNumber = vatNumber;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
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

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    public Address getAddress() { return address; }

    public void setAddress(Address address) { this.address = address; }


    //Methods

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                active == user.active &&
                Objects.equals(lastname, user.lastname) &&
                Objects.equals(firstname, user.firstname) &&
                Objects.equals(gender, user.gender) &&
                Objects.equals(birthDate, user.birthDate) &&
                Objects.equals(phone, user.phone) &&
                Objects.equals(mail, user.mail) &&
                Objects.equals(emailVerifiedAt, user.emailVerifiedAt) &&
                Objects.equals(password, user.password) &&
                Objects.equals(twoFactorSecret, user.twoFactorSecret) &&
                Objects.equals(twoFactorRecoveryCodes, user.twoFactorRecoveryCodes) &&
                Objects.equals(rememberToken, user.rememberToken) &&
                Objects.equals(companyNumber, user.companyNumber) &&
                Objects.equals(vatNumber, user.vatNumber) &&
                Objects.equals(createdAt, user.createdAt) &&
                Objects.equals(updatedAt, user.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lastname, firstname, gender, birthDate, phone, mail, emailVerifiedAt, password, twoFactorSecret, twoFactorRecoveryCodes, rememberToken, companyNumber, vatNumber, active, createdAt, updatedAt);
    }

}
