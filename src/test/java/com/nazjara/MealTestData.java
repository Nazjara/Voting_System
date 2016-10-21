package com.nazjara;

import com.nazjara.matcher.ModelMatcher;
import com.nazjara.model.Meal;

import java.util.Arrays;
import java.util.List;

import static com.nazjara.model.BaseEntity.START_SEQ;

public class MealTestData {

    public static final ModelMatcher<Meal> MATCHER = new ModelMatcher<>();

    public static final Meal MEAL1 = new Meal(START_SEQ + 5, "Big Mac", 3.99);
    public static final Meal MEAL2 = new Meal(START_SEQ + 6, "French Fries Medium", 3.99);
    public static final Meal MEAL3 = new Meal(START_SEQ + 7, "Soft Baked Chocolate Chip Cookie 3 Pc.", 3.99);
    public static final Meal MEAL4 = new Meal(START_SEQ + 8, "Orange Juice Medium", 3.99);
//    public static final Meal MEAL5 = new Meal(START_SEQ + 9, "Big King", 3.99);
//    public static final Meal MEAL6 = new Meal(START_SEQ + 10, "Chicken Nuggets 4 Pc.", 3.99);
//    public static final Meal MEAL7 = new Meal(START_SEQ + 11, "French Toast Sticks 5 Pc.", 3.99);
//    public static final Meal MEAL8 = new Meal(START_SEQ + 12, "Iced Tea (Sweet or Unsweetened) Medium", 3.99);
//    public static final Meal MEAL9 = new Meal(START_SEQ + 13, "Pizza Sub with Cheese", 3.99);
//    public static final Meal MEAL10 = new Meal(START_SEQ + 14, "Loaded Baked Potato with Bacon", 3.99);
//    public static final Meal MEAL11 = new Meal(START_SEQ + 15, "Apple Slices", 3.99);
//    public static final Meal MEAL12 = new Meal(START_SEQ + 16, "Coffee 16 oz.", 3.99);


    public static final List<Meal> MEALS = Arrays.asList(MEAL4, MEAL3, MEAL2, MEAL1);

    public static Meal getCreated() {
        return new Meal(null, "Egg McMuffin", 3.59);
    }

    public static Meal getUpdated() {
        return new Meal(START_SEQ + 5, "updated Big Mac", 3.89);
    }
}
