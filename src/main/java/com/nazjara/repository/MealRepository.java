package com.nazjara.repository;

import com.nazjara.model.Meal;

import java.util.List;

public interface MealRepository {

    Meal save(Meal meal);

    boolean delete(int id);

    List<Meal> getAll();
}
