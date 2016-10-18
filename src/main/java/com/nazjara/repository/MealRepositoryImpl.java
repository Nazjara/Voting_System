package com.nazjara.repository;

import com.nazjara.model.Meal;
import org.springframework.stereotype.Repository;

@Repository
public class MealRepositoryImpl implements MealRepository
{
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
