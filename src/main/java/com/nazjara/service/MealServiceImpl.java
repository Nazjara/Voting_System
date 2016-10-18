package com.nazjara.service;


import com.nazjara.model.Meal;
import com.nazjara.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MealServiceImpl implements MealService {

    @Autowired
    private MealRepository repository;

    @Override
    public int delete(int id) {
        return 0;
    }

    @Override
    public Meal save(Meal meal) {
        return null;
    }

    @Override
    public Meal getAll() {
        return null;
    }
}
