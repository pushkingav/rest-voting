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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    @Autowired
    RestaurantRepository restaurantRepository;

    @CacheEvict(value = "restaurants", allEntries = true)
    @Transactional
    @Override
    public Restaurant addRestaurant(Restaurant restaurant, Integer id) {
        Optional<Restaurant> checked = restaurantRepository.findByName(restaurant.getName());
        if (checked.isPresent()) {
            throw new RuntimeException("Such a restaurant already exists: " + restaurant.getName());
        }
        return restaurantRepository.save(restaurant);
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
