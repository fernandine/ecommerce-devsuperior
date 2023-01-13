package com.jean.dsCommerce.dtos;

import com.jean.dsCommerce.entities.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserDto {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private LocalDate birthDate;
    private String password;
    private String[] roles;

    private List<OrderDto> orders = new ArrayList<>();

    public UserDto() {
    }

    public UserDto(Long id, String name, String email, String phone, LocalDate birthDate, String password, String[] roles) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.birthDate = birthDate;
        this.password = password;
        this.roles = roles;
    }

    public UserDto(User entity) {
        id = entity.getId();
        name = entity.getName();
        email = entity.getEmail();
        phone = entity.getPhone();
        birthDate = entity.getBirthDate();
        password = entity.getPassword();
        roles = entity.getRoles();
        entity.getOrders().forEach(p -> this.orders.add(new OrderDto(p)));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String[] getRoles() {
        return roles;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }

    public List<OrderDto> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderDto> orders) {
        this.orders = orders;
    }
}
