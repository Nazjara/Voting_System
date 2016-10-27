package com.nazjara.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "meals",uniqueConstraints = {@UniqueConstraint(columnNames = {"restaurant_id","name"}, name = "meals_unique_restaurant_name_idx")})
public class Meal extends BaseEntity
{
    @Column(name = "price",nullable = false)
    @NotNull
    protected double price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "restaurant_id", nullable = false)
    protected Restaurant restaurant;

    public Meal() {
    }

    public Meal(Integer id, String name, double price) {
        super(id, name);
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
