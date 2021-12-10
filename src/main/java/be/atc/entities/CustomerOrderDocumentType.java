package be.atc.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "customers_orders_documents_types", schema = "stockmanagement", catalog = "")
public class CustomerOrderDocumentType {
    private int id;
    private Integer documentNumber;
    private Timestamp documentDate;
    private CustomerOrder customersOrdersByIdCustomerOrder;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "document_number", nullable = true)
    public Integer getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(Integer documentNumber) {
        this.documentNumber = documentNumber;
    }

    @Basic
    @Column(name = "document_date", nullable = false)
    public Timestamp getDocumentDate() {
        return documentDate;
    }

    public void setDocumentDate(Timestamp documentDate) {
        this.documentDate = documentDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerOrderDocumentType that = (CustomerOrderDocumentType) o;
        return id == that.id &&
                Objects.equals(documentNumber, that.documentNumber) &&
                Objects.equals(documentDate, that.documentDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, documentNumber, documentDate);
    }

    @ManyToOne
    @JoinColumn(name = "id_customer_order", referencedColumnName = "id", nullable = false)
    public CustomerOrder getCustomersOrdersByIdCustomerOrder() {
        return customersOrdersByIdCustomerOrder;
    }

    public void setCustomersOrdersByIdCustomerOrder(CustomerOrder customersOrdersByIdCustomerOrder) {
        this.customersOrdersByIdCustomerOrder = customersOrdersByIdCustomerOrder;
    }
}
