package com.nazjara.service;

import com.nazjara.model.Meal;

/**
 * Created by Administrator on 18.10.2016.
 */
public interface MealService {

    int delete(int id);

    Meal save(Meal meal);

    Meal getAll();
}
