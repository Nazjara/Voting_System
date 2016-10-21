package com.nazjara;

import com.nazjara.matcher.ModelMatcher;
import com.nazjara.model.Restaurant;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static com.nazjara.model.BaseEntity.START_SEQ;

public class RestaurantTestData {

    public static final Restaurant RESTAURANT1 = new Restaurant(START_SEQ + 2,"McDonalds");
    public static final Restaurant RESTAURANT2 = new Restaurant(START_SEQ + 3,"Burger King");
    public static final Restaurant RESTAURANT3 = new Restaurant(START_SEQ + 4,"Subway");

    public static final ModelMatcher<Restaurant> MATCHER = new ModelMatcher<>(
            (expected, actual) -> expected == actual ||
                    (Objects.equals(expected.getId(), actual.getId())
                            && Objects.equals(expected.getName(), actual.getName())
                    )
    );

    public static final List<Restaurant> RESTAURANTS = Arrays.asList(RESTAURANT1, RESTAURANT2, RESTAURANT3);

    public static Restaurant getCreated() {
        return new Restaurant(null, "Big Burger");
    }

    public static Restaurant getUpdated() {
        return new Restaurant(START_SEQ + 2, "updated McDonalds");
    }
}
