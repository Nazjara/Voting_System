package com.nazjara.repository.datajpa;

import com.nazjara.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface DataJpaRestaurantRepository extends JpaRepository<Restaurant,Integer>
{
    @Modifying
    @Transactional
    @Query("DELETE FROM Restaurant r WHERE r.id=:id")
    int delete(@Param("id") int id);

    @Override
    @Transactional
    Restaurant save(Restaurant restaurant);

    @Override
    Restaurant findOne(Integer id);

    @Override
    @Query("SELECT DISTINCT r FROM Restaurant r")
    List<Restaurant> findAll();

    @Query("SELECT DISTINCT r FROM Restaurant r LEFT JOIN FETCH r.menu")
    List<Restaurant> getAllWithMenu();
}
