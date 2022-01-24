package be.ebusiness.entities;


import be.ebusiness.enumerations.PackagingStatusEnum;
import be.ebusiness.enumerations.PackagingTypeEnum;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * The persistent class for the packagings database table.
 *
 * @author Laurent GRAVEZ
 */

@Entity
@Table(name = "packagings", schema = "ebusiness")
public class Packaging implements Serializable {

    //Properties

    private static final long serialVersionUID= 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name = "status")
    @NotNull
    @Enumerated(EnumType.STRING)
    private PackagingStatusEnum packagingStatusEnum;

    @Column(name = "packaging_type")
    @NotNull
    @Enumerated(EnumType.STRING)
    private PackagingTypeEnum packagingTypeEnum;

    @Column(name = "weight")
    @NotNull
    private float weight;

    @Column(name = "volume")
    @NotNull
    private float volume;

    @Column(name="created_at")
    private LocalDateTime createdAt;

    @Column(name="updated_at")
    private LocalDateTime updatedAt;

    //uni-directional many-to-one association to Order
    @ManyToOne
    @JoinColumn(name="id_order")
    private Order order;

    //uni-directional many-to-one association to CarrierOrder
    @ManyToOne
    @JoinColumn(name="id_carrier_order")
    private CarrierOrder carrierOrder;


    //Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PackagingStatusEnum getPackagingStatusEnum() { return packagingStatusEnum; }

    public void setPackagingStatusEnum(PackagingStatusEnum packagingStatusEnum) { this.packagingStatusEnum = packagingStatusEnum; }

    public PackagingTypeEnum getPackagingTypeEnum() { return packagingTypeEnum; }

    public void setPackagingTypeEnum(PackagingTypeEnum packagingTypeEnum) { this.packagingTypeEnum = packagingTypeEnum; }

    public float getWeight() { return weight; }

    public void setWeight(float weight) { this.weight = weight; }

    public float getVolume() { return volume; }

    public void setVolume(float volume) { this.volume = volume; }

    public LocalDateTime getCreatedAt() { return createdAt; }

    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }

    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    public Order getOrder() { return order; }

    public void setOrder(Order order) { this.order = order; }

    public CarrierOrder getCarrierOrder() { return carrierOrder; }

    public void setCarrierOrder(CarrierOrder carrierOrder) { this.carrierOrder = carrierOrder; }


    //Methods

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Packaging packaging = (Packaging) o;
        return id == packaging.id &&
                Double.compare(packaging.weight, weight) == 0 &&
                Double.compare(packaging.volume, volume) == 0 &&
                Objects.equals(packagingStatusEnum, packaging.packagingStatusEnum) &&
                Objects.equals(packagingTypeEnum, packaging.packagingTypeEnum) &&
                Objects.equals(createdAt, packaging.createdAt) &&
                Objects.equals(updatedAt, packaging.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, packagingStatusEnum, packagingTypeEnum, weight, volume, createdAt, updatedAt);
    }

}
