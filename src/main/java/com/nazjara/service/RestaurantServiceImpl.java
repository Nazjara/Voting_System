package com.nazjara.service;

import com.nazjara.model.Restaurant;
import com.nazjara.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepository repository;

    @Override
    public int delete(int id) {
        return 0;
    }

    @Override
    public Restaurant save(Restaurant user) {
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
