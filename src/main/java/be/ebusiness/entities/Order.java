package be.ebusiness.entities;


import be.ebusiness.enumerations.OrderShippingOptionEnum;
import be.ebusiness.enumerations.OrderStatusEnum;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;


/**
 * The persistent class for the orders database table.
 *
 * @author Laurent GRAVEZ
 */

@Entity
@Table(name = "orders", schema = "ebusiness")
public class Order implements Serializable {

    //Properties

    private static final long serialVersionUID= 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name = "status")
    @NotNull
    @Enumerated(EnumType.STRING)
    private OrderStatusEnum orderStatusEnum;

    @Column(name = "total_price")
    @NotNull
    private float totalPrice;

    @Column(name = "total_weight")
    @NotNull
    private float totalWeight;

    @Column(name = "total_volume")
    @NotNull
    private float totalVolume;

    @Basic
    @Column(name = "shipping_options", nullable = false)
    @Enumerated(EnumType.STRING)
    private OrderShippingOptionEnum orderShippingOptionEnum;

    @Column(name="created_at")
    private LocalDateTime createdAt;

    @Column(name="updated_at")
    private LocalDateTime updatedAt;

    //uni-directional many-to-one association to User
    @ManyToOne
    @JoinColumn(name="id_user")
    private User user;


    //Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public OrderStatusEnum getOrderStatusEnum() { return orderStatusEnum; }

    public void setOrderStatusEnum(OrderStatusEnum orderStatusEnum) { this.orderStatusEnum = orderStatusEnum; }

    public float getTotalPrice() { return totalPrice; }

    public void setTotalPrice(float totalPrice) { this.totalPrice = totalPrice; }

    public float getTotalWeight() { return totalWeight; }

    public void setTotalWeight(float totalWeight) { this.totalWeight = totalWeight; }

    public float getTotalVolume() { return totalVolume; }

    public void setTotalVolume(float totalVolume) { this.totalVolume = totalVolume; }

    public OrderShippingOptionEnum getOrderShippingOptionEnum() { return orderShippingOptionEnum; }

    public void setOrderShippingOptionEnum(OrderShippingOptionEnum orderShippingOptionEnum) { this.orderShippingOptionEnum = orderShippingOptionEnum; }

    public LocalDateTime getCreatedAt() { return createdAt; }

    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }

    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }


    //Methods

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id &&
                Double.compare(order.totalPrice, totalPrice) == 0 &&
                Double.compare(order.totalWeight, totalWeight) == 0 &&
                Double.compare(order.totalVolume, totalVolume) == 0 &&
                Objects.equals(orderStatusEnum, order.orderStatusEnum) &&
                Objects.equals(orderShippingOptionEnum, order.orderShippingOptionEnum) &&
                Objects.equals(createdAt, order.createdAt) &&
                Objects.equals(updatedAt, order.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderStatusEnum, totalPrice, totalWeight, totalVolume, orderShippingOptionEnum, createdAt, updatedAt);
    }
}
