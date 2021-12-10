package be.atc.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "customers_orders", schema = "stockmanagement", catalog = "")
public class CustomerOrder {
    private int id;
    private Timestamp orderDate;
    private Object status;
    private Double totalPrice;
    private Double totalWeight;
    private Double totalVolume;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "order_date", nullable = false)
    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    @Basic
    @Column(name = "status", nullable = false)
    public Object getStatus() {
        return status;
    }

    public void setStatus(Object status) {
        this.status = status;
    }

    @Basic
    @Column(name = "total_price", nullable = true, precision = 0)
    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Basic
    @Column(name = "total_weight", nullable = true, precision = 0)
    public Double getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(Double totalWeight) {
        this.totalWeight = totalWeight;
    }

    @Basic
    @Column(name = "total_volume", nullable = true, precision = 0)
    public Double getTotalVolume() {
        return totalVolume;
    }

    public void setTotalVolume(Double totalVolume) {
        this.totalVolume = totalVolume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerOrder that = (CustomerOrder) o;
        return id == that.id &&
                Objects.equals(orderDate, that.orderDate) &&
                Objects.equals(status, that.status) &&
                Objects.equals(totalPrice, that.totalPrice) &&
                Objects.equals(totalWeight, that.totalWeight) &&
                Objects.equals(totalVolume, that.totalVolume);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderDate, status, totalPrice, totalWeight, totalVolume);
    }
}
