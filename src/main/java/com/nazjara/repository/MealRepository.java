package com.nazjara.repository;

import com.nazjara.model.Meal;

public interface MealRepository {

    int delete(int id);

    Meal save(Meal meal);

    Meal getAll();
}
