package ru.restaurants.restvoting.service;

import ru.restaurants.restvoting.model.Restaurant;

import java.util.List;

public interface RestaurantService {
    Restaurant addRestaurant(Restaurant restaurant, Integer restaurantId);

    List<Restaurant> getAllRestaurants();

    List<Restaurant> getAllRestaurantsWithMenu();

}
