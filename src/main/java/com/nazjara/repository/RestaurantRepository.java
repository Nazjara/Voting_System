package com.nazjara.repository;

import com.nazjara.model.Restaurant;

import java.util.List;

public interface RestaurantRepository
{
    int delete(int id);

    Restaurant save(Restaurant user);

    Restaurant get(Integer id);

    List<Restaurant> getAll();
}
