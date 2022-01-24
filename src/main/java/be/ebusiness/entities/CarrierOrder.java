package be.ebusiness.entities;

import be.ebusiness.enumerations.CarrierOrderStatusEnum;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * The persistent class for the carriers_orders database table.
 *
 * @author Laurent GRAVEZ
 */

@Entity
@Table(name = "carrier_orders", schema = "ebusiness")
public class CarrierOrder implements Serializable {

    //Properties

    private static final long serialVersionUID= 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name = "status")
    @NotNull
    @Enumerated(EnumType.STRING)
    private CarrierOrderStatusEnum carrierOrderStatusEnum;

    @Column(name = "quantity")
    @NotNull
    private int quantity;

    @Column(name="created_at")
    private LocalDateTime createdAt;

    @Column(name="updated_at")
    private LocalDateTime updatedAt;

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

    public CarrierOrderStatusEnum getCarrierOrderStatusEnum() { return carrierOrderStatusEnum; }

    public void setCarrierOrderStatusEnum(CarrierOrderStatusEnum carrierOrderStatusEnum) { this.carrierOrderStatusEnum = carrierOrderStatusEnum; }

    public int getQuantity() { return quantity; }

    public void setQuantity(int quantity) { this.quantity = quantity; }

    public LocalDateTime getCreatedAt() { return createdAt; }

    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }

    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    public Carrier getCarrier() { return carrier; }

    public void setCarrier(Carrier carrier) { this.carrier = carrier; }


    //Methods

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarrierOrder that = (CarrierOrder) o;
        return id == that.id &&
                quantity == that.quantity &&
                Objects.equals(carrierOrderStatusEnum, that.carrierOrderStatusEnum) &&
                Objects.equals(createdAt, that.createdAt) &&
                Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, carrierOrderStatusEnum, quantity, createdAt, updatedAt);
    }
}
