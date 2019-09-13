package ru.restaurants.restvoting.service;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.restaurants.restvoting.model.Restaurant;
import ru.restaurants.restvoting.repository.RestaurantRepository;
import ru.restaurants.restvoting.to.RestaurantTo;
import ru.restaurants.restvoting.util.exception.NotFoundException;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    @Autowired
    RestaurantRepository restaurantRepository;

    @CacheEvict(value = "restaurants", allEntries = true)
    @Transactional
    @Override
    public Restaurant addRestaurant(Restaurant restaurant, Integer id) {
        restaurantRepository.findByName(restaurant.getName()).ifPresent(r -> {
            throw new RuntimeException("Such a restaurant already exists: " + r.getName());
        });
        return restaurantRepository.save(restaurant);
    }

    @Override
    public Restaurant editRestaurant(Integer restaurantId, String newName) {
        Restaurant restaurantForEditing = restaurantRepository.findById(restaurantId).orElseThrow(
                () -> new NotFoundException("No restaurant found with id " + restaurantId)
        );
        restaurantForEditing.setName(newName);
        return restaurantRepository.save(restaurantForEditing);
    }

    @Cacheable("restaurants")
    @Override
    public List<RestaurantTo> getAllRestaurants() {
        List<Restaurant> restaurants = restaurantRepository.findAll();
        List<RestaurantTo> result = new ArrayList<>();
        restaurants.forEach(r -> result.add(RestaurantTo.createFromRestaurant(r)));
        return result;
    }

    @Transactional
    @Override
    public List<Restaurant> getAllRestaurantsWithMenu() {
        List<Restaurant> restaurants = restaurantRepository.findAll();
        restaurants.forEach(p -> Hibernate.initialize(p.getMenuItems()));
        return restaurants;
    }

}
