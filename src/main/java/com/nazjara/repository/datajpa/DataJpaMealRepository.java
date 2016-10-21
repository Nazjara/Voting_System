package com.nazjara.repository.datajpa;

import com.nazjara.model.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface DataJpaMealRepository extends JpaRepository<Meal,Integer> {

    @Modifying
    @Transactional
    @Query("DELETE FROM Meal m WHERE m.id=:id")
    int delete(@Param("id") int id);

    @Override
    Meal save(Meal meal);

    @Query("SELECT m FROM Meal m WHERE m.restaurant.id=:restaurantId")
    List<Meal> getAll (@Param("restaurantId") int restaurantId);
}
