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
    private DataJpaMealRepository repository;

    @Override
    public boolean delete(int id) {
        return repository.delete(id) != 0;
    }

    @Override
    @Transactional
    public Meal save(Meal meal) {
        return repository.save(meal);
    }

    @Override
    public List<Meal> getAll() {
        return repository.findAll();
    }
}
