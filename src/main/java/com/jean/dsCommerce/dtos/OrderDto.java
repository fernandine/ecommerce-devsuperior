package com.jean.dsCommerce.dtos;

import com.jean.dsCommerce.entities.Order;
import com.jean.dsCommerce.enums.OrderStatus;

import java.time.Instant;

public class OrderDto {

    private Long id;
    private Instant moment;
    private OrderStatus status;

    public OrderDto() {
    }

    public OrderDto(Long id, Instant moment, OrderStatus status) {
        this.id = id;
        this.moment = moment;
        this.status = status;
    }

    public OrderDto(Order entity) {
        id = entity.getId();
        moment = entity.getMoment();
        status = entity.getStatus();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
