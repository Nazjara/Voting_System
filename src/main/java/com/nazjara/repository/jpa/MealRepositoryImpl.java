package com.nazjara.repository.jpa;

import com.nazjara.model.Meal;
import com.nazjara.model.Restaurant;
import com.nazjara.repository.MealRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class MealRepositoryImpl implements MealRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public Meal save(Meal meal, int restaurantId) {
        meal.setRestaurant(entityManager.getReference(Restaurant.class,restaurantId));
        if (meal.isNew()) {
            entityManager.persist(meal);
            return meal;
        } else {
            return entityManager.merge(meal);
        }
    }

    @Override
    @Transactional
    public boolean delete(int id) {
        return entityManager.createQuery("DELETE FROM Meal m WHERE m.id=:id").setParameter("id",id).executeUpdate() != 0;
    }

    @Override
    public List<Meal> getAll(int restaurantId) {
        return entityManager.createQuery("SELECT m FROM Meal m WHERE m.restaurant.id=:id", Meal.class).setParameter("id",restaurantId).getResultList();
    }
}
