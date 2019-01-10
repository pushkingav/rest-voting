package ru.restaurants.restvoting.service;

import ru.restaurants.restvoting.model.Restaurant;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface UserService {
    //Admin tasks
    Integer addRestaurant(String name);

    List<Restaurant> getRestaurants();

    Restaurant getRestaurantById(Integer id);

    boolean vote(int restaurantId, int userId);

    /**
     *   Get all votes for custom date in a map like restaurantId -> votesTodayCount
     * */
    Map<Integer, Integer> getVotesForDate(LocalDate date);
}
