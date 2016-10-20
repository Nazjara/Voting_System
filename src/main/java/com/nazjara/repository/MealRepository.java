package com.nazjara.repository;

import com.nazjara.model.Meal;

import java.util.List;

public interface MealRepository {

    int delete(int id);

    Meal save(Meal meal);

    Meal update(Meal meal);

    List<Meal> getAll();
}
