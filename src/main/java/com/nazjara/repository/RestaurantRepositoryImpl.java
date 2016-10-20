package com.nazjara.repository;

import com.nazjara.model.Restaurant;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RestaurantRepositoryImpl implements RestaurantRepository {

    @Override
    public int delete(int id) {
        return 0;
    }

    @Override
    public Restaurant save(Restaurant user) {
        return null;
    }

    @Override
    public Restaurant update(Restaurant restaurant) {
        return null;
    }

    @Override
    public Restaurant get(Integer id) {
        return null;
    }

    @Override
    public List<Restaurant> getAll() {
        return null;
    }
}
