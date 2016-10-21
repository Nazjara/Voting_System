package com.nazjara.service;

import com.nazjara.model.Meal;
import com.nazjara.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class MealServiceImpl implements MealService {

    @Autowired
    private MealRepository repository;

    @Override
    public void delete(int id) {
         repository.delete(id);
    }

    @Override
    public Meal save(Meal meal) {
        Assert.notNull(meal,"meal must not be null");
        return repository.save(meal);
    }

    @Override
    public Meal update(Meal meal) {
        Assert.notNull(meal,"meal must not be null");
        return repository.save(meal);
    }

    @Override
    public List<Meal> getAll() {
        return repository.getAll();
    }
}
