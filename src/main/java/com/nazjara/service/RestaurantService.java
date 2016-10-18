package com.nazjara.service;

import com.nazjara.model.Restaurant;

import java.util.List;

/**
 * Created by Administrator on 18.10.2016.
 */
public interface RestaurantService {

    int delete(int id);

    Restaurant save(Restaurant user);

    Restaurant get(Integer id);

    List<Restaurant> getAll();
}
