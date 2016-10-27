package com.nazjara.repository.jpa;

import com.nazjara.model.Restaurant;
import com.nazjara.repository.RestaurantRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class RestaurantRepositoryImpl implements RestaurantRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public boolean delete(int id) {
        return entityManager.createQuery("DELETE FROM Restaurant r WHERE r.id=:id").setParameter("id",id).executeUpdate() != 0;
    }

    @Override
    @Transactional
    public Restaurant save(Restaurant restaurant) {
        if(restaurant.isNew()){
            entityManager.persist(restaurant);
            return restaurant;
        }
        else{
            return entityManager.merge(restaurant);
        }
    }

    @Override
    public Restaurant get(Integer id) {
        return (Restaurant) entityManager.createQuery("SELECT r FROM Restaurant r LEFT JOIN FETCH r.users WHERE r.id=:id").setParameter("id",id).getSingleResult();
    }

    @Override
    public List<Restaurant> getAllWithMenu() {
        return entityManager.createQuery("SELECT DISTINCT r FROM Restaurant r LEFT JOIN FETCH r.menu", Restaurant.class).getResultList();
    }

    @Override
    public List<Restaurant> getAll() {
        return entityManager.createQuery("SELECT DISTINCT r FROM Restaurant r LEFT JOIN FETCH r.users", Restaurant.class).getResultList();
    }
}
