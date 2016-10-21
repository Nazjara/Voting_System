package com.nazjara.service;

import com.nazjara.model.Meal;

import java.util.List;

public interface MealService {

    void delete(int id);

    Meal save(Meal meal, int restaurantId);

    Meal update(Meal meal, int restaurantId);

    List<Meal> getAll(int restaurantId);
}
