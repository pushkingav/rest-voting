package ru.restaurants.restvoting.service;

import ru.restaurants.restvoting.model.Restaurant;
import ru.restaurants.restvoting.to.RestaurantTo;

import java.util.List;

public interface RestaurantService {
    Restaurant addRestaurant(Restaurant restaurant, Integer restaurantId);

    Restaurant editRestaurant(Integer restaurantId, String newName);

    List<RestaurantTo> getAllRestaurants();

    List<Restaurant> getAllRestaurantsWithMenu();

}
