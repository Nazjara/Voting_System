package com.nazjara.model;

public class Meal extends BaseEntity
{
    private double price;

    private Restaurant restaurant;

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
