package ru.restaurants.restvoting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.restaurants.restvoting.model.Restaurant;
import ru.restaurants.restvoting.repository.RestaurantRepository;

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
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

}
