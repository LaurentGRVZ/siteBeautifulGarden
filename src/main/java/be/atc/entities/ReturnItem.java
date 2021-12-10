package be.atc.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "returns_items", schema = "stockmanagement", catalog = "")
public class ReturnItem {
    private int id;
    private int customerNumber;
    private int orderNumber;
    private Object reasonForReturn;
    private int itemNumber;
    private Timestamp date;
    private int quantity;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "customer_number", nullable = false)
    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    @Basic
    @Column(name = "order_number", nullable = false)
    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    @Basic
    @Column(name = "reason_for_return", nullable = false)
    public Object getReasonForReturn() {
        return reasonForReturn;
    }

    public void setReasonForReturn(Object reasonForReturn) {
        this.reasonForReturn = reasonForReturn;
    }

    @Basic
    @Column(name = "item_number", nullable = false)
    public int getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(int itemNumber) {
        this.itemNumber = itemNumber;
    }

    @Basic
    @Column(name = "date", nullable = false)
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Basic
    @Column(name = "quantity", nullable = false)
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReturnItem that = (ReturnItem) o;
        return id == that.id &&
                customerNumber == that.customerNumber &&
                orderNumber == that.orderNumber &&
                itemNumber == that.itemNumber &&
                quantity == that.quantity &&
                Objects.equals(reasonForReturn, that.reasonForReturn) &&
                Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customerNumber, orderNumber, reasonForReturn, itemNumber, date, quantity);
    }
}
