package com.nazjara.service;

import com.nazjara.model.Restaurant;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.Collection;

import static com.nazjara.RestaurantTestData.*;

public class RestaurantServiceTestImpl extends AbstractServiceTest {

    @Autowired
    protected RestaurantService service;

    @Test
    public void testDelete() throws Exception{
        service.delete(RESTAURANT1.getId());
        MATCHER.assertCollectionEquals(Arrays.asList(RESTAURANT2,RESTAURANT3), service.getAll());
    }

    @Test
    public void testSave() throws Exception{
        Restaurant newRestaurant = getCreated();
        Restaurant created = service.save(newRestaurant);
        newRestaurant.setId(created.getId());
        MATCHER.assertCollectionEquals(Arrays.asList(RESTAURANT1,RESTAURANT2,RESTAURANT3,newRestaurant),service.getAll());
    }

    @Test
    public void testUpdate() throws Exception{
        Restaurant updated = getUpdated();
        service.update(updated);
        MATCHER.assertEquals(updated, service.get(updated.getId()));
    }

    @Test
    public void testGet() throws Exception{
        Restaurant restaurant = service.get(RESTAURANT1.getId());
        MATCHER.assertEquals(RESTAURANT1, restaurant);
    }

    @Test
    public void  testGetAll() throws Exception{
        Collection<Restaurant> restaurants = service.getAll();
        MATCHER.assertCollectionEquals(restaurants,RESTAURANTS);
    }

}
