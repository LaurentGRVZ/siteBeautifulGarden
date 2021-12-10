package be.ebusiness.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * The persistent class for the orders_document_types database table.
 *
 * @author Laurent GRAVEZ
 */

@Entity
@Table(name = "orders_document_types", schema = "ebusiness")
public class OrderDocumentType implements Serializable {

    //Properties

    private static final long serialVersionUID= 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name = "amount")
    private float amount;

    @Column(name = "url_document")
    @NotNull
    @Size(max = 255)
    private String urlDocument;

    @Column(name="created_at")
    private LocalDateTime createdAt;

    @Column(name="updated_at")
    private LocalDateTime updatedAt;

    //uni-directional many-to-one association to User
    @ManyToOne
    @JoinColumn(name="id_document_type")
    private DocumentType documentType;

    //uni-directional many-to-one association to Address
    @ManyToOne
    @JoinColumn(name="id_order")
    private Order order;


    //Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getAmount() { return amount; }

    public void setAmount(float amount) { this.amount = amount; }

    public String getUrlDocument() {
        return urlDocument;
    }

    public void setUrlDocument(String urlDocument) {
        this.urlDocument = urlDocument;
    }

    public void setAmount(Float amount) { this.amount = amount; }

    public LocalDateTime getCreatedAt() { return createdAt; }

    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }

    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    public DocumentType getDocumentType() { return documentType; }

    public void setDocumentType(DocumentType documentType) { this.documentType = documentType; }

    public Order getOrder() { return order; }

    public void setOrder(Order order) { this.order = order; }


    //Methods

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDocumentType that = (OrderDocumentType) o;
        return id == that.id &&
                Objects.equals(amount, that.amount) &&
                Objects.equals(urlDocument, that.urlDocument) &&
                Objects.equals(createdAt, that.createdAt) &&
                Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, urlDocument, createdAt, updatedAt);
    }

}
