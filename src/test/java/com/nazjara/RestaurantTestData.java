package com.nazjara;

import com.nazjara.matcher.ModelMatcher;
import com.nazjara.model.Meal;
import com.nazjara.model.Restaurant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static com.nazjara.model.BaseEntity.START_SEQ;

public class RestaurantTestData {

    public static final Restaurant RESTAURANT1 = new Restaurant(START_SEQ + 2,"McDonalds");
    public static final Restaurant RESTAURANT2 = new Restaurant(START_SEQ + 3,"Burger King");
    public static final Restaurant RESTAURANT3 = new Restaurant(START_SEQ + 4,"Subway");

    static
    {
        RESTAURANT3.setMenu(Arrays.asList(new Meal(6,"Big Mac",3.99),new Meal(7,"French Fries Medium",1.69),new Meal(8,"Soft Baked Chocolate Chip Cookie 3 Pc.",1),new Meal(9,"Orange Juice Medium",1.89)));
        RESTAURANT2.setMenu(Arrays.asList(new Meal(10,"Big King",3.89),new Meal(11,"Chicken Nuggets 4 Pc.",1.19),new Meal(12,"French Toast Sticks 5 Pc.",1.99),new Meal(13,"Iced Tea (Sweet or Unsweetened) Medium",2.09)));
        RESTAURANT1.setMenu(Arrays.asList(new Meal(14,"Pizza Sub with Cheese",3.75),new Meal(15,"Loaded Baked Potato with Bacon",2.5),new Meal(16,"Apple Slices",1.5),new Meal(17,"Coffee 16 oz.",1.8)));
        RESTAURANT1.setUsers(new ArrayList<>());
        RESTAURANT2.setUsers(new ArrayList<>());
        RESTAURANT3.setUsers(new ArrayList<>());

    }

    public static final ModelMatcher<Restaurant> MATCHER = new ModelMatcher<>(
            (expected, actual) -> expected == actual ||
                    (Objects.equals(expected.getId(), actual.getId())
                            && Objects.equals(expected.getName(), actual.getName())
                    )
    );

    public static final List<Restaurant> RESTAURANTS = Arrays.asList(RESTAURANT1, RESTAURANT2, RESTAURANT3);

    public static Restaurant getCreated() {
        Restaurant restaurant = new Restaurant(null, "Big Burger");
        restaurant.setUsers(new ArrayList<>());
        restaurant.setMenu(new ArrayList<>());
        return restaurant;
    }

    public static Restaurant getUpdated() {
        return new Restaurant(START_SEQ + 2, "updated McDonalds");
    }
}
