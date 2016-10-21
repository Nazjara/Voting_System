package com.nazjara.repository;

import com.nazjara.model.Restaurant;

import java.util.List;

public interface RestaurantRepository {

    boolean delete(int id);

    Restaurant save(Restaurant restaurant);

    Restaurant get(Integer id);

    List<Restaurant> getAll();
}
