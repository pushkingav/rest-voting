package ru.restaurants.restvoting.service;

import ru.restaurants.restvoting.model.Dish;
import ru.restaurants.restvoting.model.Restaurant;
import ru.restaurants.restvoting.model.User;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface UserService {
    //Admin tasks
    Integer addRestaurant(String name);

    Dish createDish(String name, BigDecimal price, int restaurantId);

    List<Restaurant> getRestaurants();

    Restaurant getRestaurantById(Integer id);


    boolean vote(User user, int restaurantId, LocalDateTime dateTime);

    /**
    *   Get all votes for today in a map like restaurantId -> votesTodayCount
    * */
    Map<Integer, Integer> getTodayVotes();

    /**
     *   Get all votes for custom date in a map like restaurantId -> votesTodayCount
     * */
    Map<Integer, Integer> getVotesForDate(LocalDate date);
}
