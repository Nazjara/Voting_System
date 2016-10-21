package com.nazjara.repository;

import com.nazjara.model.Meal;

import java.util.List;

public interface MealRepository {

    Meal save(Meal meal, int restaurantId);

    boolean delete(int id);

    List<Meal> getAll(int restaurantId);
}
