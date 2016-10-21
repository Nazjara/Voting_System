package com.nazjara.repository.datajpa;

import com.nazjara.model.Meal;
import com.nazjara.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class DataJpaMealRepositoryImpl implements MealRepository
{
    @Autowired
    private DataJpaMealRepository mealRepository;

    @Autowired
    private DataJpaRestaurantRepository restaurantRepository;

    @Override
    public boolean delete(int id) {
        return mealRepository.delete(id) != 0;
    }

    @Override
    @Transactional
    public Meal save(Meal meal, int restaurantId) {
        if (!meal.isNew()) {
            return null;
        }
        meal.setRestaurant(restaurantRepository.getOne(restaurantId));
        return mealRepository.save(meal);
    }

    @Override
    public List<Meal> getAll(int restaurantId) {
        return mealRepository.getAll(restaurantId);
    }
}
