package com.nazjara.service;

import com.nazjara.model.Restaurant;
import com.nazjara.repository.RestaurantRepository;
import com.nazjara.repository.datajpa.DataJpaRestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepository repository;

    @Override
    public void delete(int id) {
        repository.delete(id);
    }

    @Override
    public Restaurant save(Restaurant restaurant) {
        Assert.notNull(restaurant,"restaurant must not be null");
        return repository.save(restaurant);
    }

    @Override
    public Restaurant update(Restaurant restaurant) {
        Assert.notNull(restaurant,"restaurant must not be null");
        return repository.save(restaurant);
    }

    @Override
    public Restaurant get(Integer id) {
        return repository.get(id);
    }

    @Override
    public List<Restaurant> getAll() {
        return repository.getAll();
    }
}
