package com.nazjara.repository.mock;

import com.nazjara.model.Restaurant;
import com.nazjara.repository.RestaurantRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class TestRestaurantRepositoryImpl implements RestaurantRepository {

    private static final Logger LOG = LoggerFactory.getLogger(TestRestaurantRepositoryImpl.class);

    private Map<Integer, Restaurant> repository = new ConcurrentHashMap<>();
    private AtomicInteger counter = new AtomicInteger(0);

    private static final Comparator<Restaurant> RESTAURANT_COMPARATOR = Comparator.comparing(Restaurant::getId).thenComparing(Restaurant::getName);

    @PostConstruct
    public void postConstruct() {
        LOG.info("+++ PostConstruct");
    }

    @PreDestroy
    public void preDestroy() {
        LOG.info("+++ PreDestroy");
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Restaurant save(Restaurant restaurant) {
        if (restaurant.isNew()) {
            restaurant.setId(counter.incrementAndGet());
        }
        repository.put(restaurant.getId(), restaurant);
        return restaurant;
    }

    @Override
    public Restaurant get(Integer id) {
        return repository.get(id);
    }

    @Override
    public List<Restaurant> getAll() {
        return repository.values().stream()
                .sorted(RESTAURANT_COMPARATOR)
                .collect(Collectors.toList());
    }
}
