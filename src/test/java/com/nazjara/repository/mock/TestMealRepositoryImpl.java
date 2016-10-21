package com.nazjara.repository.mock;

import com.nazjara.model.Meal;
import com.nazjara.repository.MealRepository;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestMealRepositoryImpl implements MealRepository {

    private static final Comparator<Meal> MEAL_COMPARATOR = Comparator.comparing(Meal::getName).reversed();

    // Map  restaurantId -> (mealId -> meal)
    private Map<Integer, Map<Integer, Meal>> repository = new ConcurrentHashMap<>();
    private AtomicInteger counter = new AtomicInteger(0);

    @Override
    public Meal save(Meal meal, int restaurantId) {
        Integer mealId = meal.getId();
        if (meal.isNew()) {
            mealId = counter.incrementAndGet();
            meal.setId(mealId);
        }
        Map<Integer, Meal> meals = repository.computeIfAbsent(restaurantId, ConcurrentHashMap::new);
        meals.put(mealId, meal);
        return meal;
    }

    @Override
    public boolean delete(int mealId) {
        Map<Integer, Meal> meals = repository.get(mealId);
        return meals != null && meals.remove(mealId) != null;
    }

    @Override
    public List<Meal> getAll(int restaurantId) {
        return getAllStream(restaurantId).collect(Collectors.toList());
    }

    private Stream<Meal> getAllStream(int restaurantId) {
        Map<Integer, Meal> meals = repository.get(restaurantId);
        return meals == null ?
                Stream.empty() : meals.values().stream().sorted(MEAL_COMPARATOR);
    }
}
