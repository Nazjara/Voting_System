package com.nazjara.repository.datajpa;

import com.nazjara.model.Restaurant;
import com.nazjara.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DataJpaRestaurantRepositoryImpl implements RestaurantRepository {

    @Autowired
    private DataJpaRestaurantRepository repository;

    @Override
    public boolean delete(int id) {
        return repository.delete(id) != 0;
    }

    @Override
    public Restaurant save(Restaurant restaurant) {
        return repository.save(restaurant);
    }

    @Override
    public Restaurant get(Integer id) {
        Restaurant restaurant = repository.findOne(id);
        return restaurant != null ? restaurant : null;
    }

    @Override
    public List<Restaurant> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Restaurant> getAllWithMenu() {
        return repository.getAllWithMenu();
    }
}
