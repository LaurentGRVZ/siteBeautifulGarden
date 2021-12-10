package be.ebusiness.entities;


import be.ebusiness.enumerations.RmaStatusEnum;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * The persistent class for the rmas database table.
 *
 * @author Laurent GRAVEZ
 */

@Entity
@Table(name = "rmas", schema = "ebusiness")
public class Rma implements Serializable {

    //Properties

    private static final long serialVersionUID= 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name = "status")
    @NotNull
    @Enumerated(EnumType.STRING)
    private RmaStatusEnum rmaStatusEnum;

    @Basic
    @Column(name = "url_document")
    @NotNull
    @Size(max = 255)
    private String urlDocument;

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

    public RmaStatusEnum getRmaStatusEnum() { return rmaStatusEnum; }

    public void setRmaStatusEnum(RmaStatusEnum rmaStatusEnum) { this.rmaStatusEnum = rmaStatusEnum; }

    public String getUrlDocument() {
        return urlDocument;
    }

    public void setUrlDocument(String urlDocument) {
        this.urlDocument = urlDocument;
    }

    public LocalDateTime getCreatedAt() { return createdAt; }

    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }

    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }


    //Methods

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rma rma = (Rma) o;
        return id == rma.id &&
                Objects.equals(rmaStatusEnum, rma.rmaStatusEnum) &&
                Objects.equals(urlDocument, rma.urlDocument) &&
                Objects.equals(createdAt, rma.createdAt) &&
                Objects.equals(updatedAt, rma.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rmaStatusEnum, urlDocument, createdAt, updatedAt);
    }
}
