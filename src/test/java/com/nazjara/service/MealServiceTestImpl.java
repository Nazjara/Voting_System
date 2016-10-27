package com.nazjara.service;

import com.nazjara.model.Meal;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import java.util.Arrays;
import java.util.Collection;

import static com.nazjara.MealTestData.*;
import static com.nazjara.RestaurantTestData.RESTAURANT1;

public class MealServiceTestImpl extends AbstractServiceTest {

    @Autowired
    protected MealService service;

    @Test
    public void testDelete() throws Exception {
        service.delete(MEAL1.getId());
        MATCHER.assertCollectionEquals(Arrays.asList(MEAL2, MEAL3, MEAL4), service.getAll(RESTAURANT1.getId()));
    }

    @Test
    public void testSave() throws Exception {
        Meal created = getCreated();
        service.save(created,RESTAURANT1.getId());
        MATCHER.assertCollectionEquals(Arrays.asList(MEAL1, MEAL2, MEAL3, MEAL4, created), service.getAll(RESTAURANT1.getId()));
    }

    @Test(expected = DataAccessException.class)
    public void testDuplicateSave() throws Exception {
        Meal duplicateMeal = new Meal(null, "Big Mac", 3.99);
        service.save(duplicateMeal, 3);
    }

    @Test
    public void testUpdate() throws Exception {
        Meal updated = getUpdated();
        service.update(updated,3);
        MATCHER.assertCollectionEquals(Arrays.asList(MEAL2, MEAL3, MEAL4, updated), service.getAll(RESTAURANT1.getId()));
    }

    @Test
    public void testGetAll() throws Exception {
        Collection<Meal> meals = service.getAll(RESTAURANT1.getId());
        MATCHER.assertCollectionEquals(meals, Arrays.asList(MEAL1,MEAL2,MEAL3,MEAL4));
    }
}