package com.nazjara.service;

import com.nazjara.model.Restaurant;

import java.util.List;

public interface RestaurantService {

    void delete(int id);

    Restaurant save(Restaurant restaurant);

    Restaurant update(Restaurant restaurant);

    Restaurant get(Integer id);

    List<Restaurant> getAll();

    List<Restaurant> getAllWithMenu();
}
