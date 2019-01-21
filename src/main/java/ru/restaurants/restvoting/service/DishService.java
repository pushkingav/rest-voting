package ru.restaurants.restvoting.service;

import ru.restaurants.restvoting.model.Dish;
import ru.restaurants.restvoting.model.Restaurant;
import ru.restaurants.restvoting.util.exception.NotFoundException;

import java.time.LocalDate;
import java.util.List;

public interface DishService {
    Restaurant addRestaurant(Restaurant restaurant, Integer restaurantId);

    List<Restaurant> listAllRestaurants();

    Dish create(Dish dish, int restaurantId);

    Dish update(Dish dish, int restaurantId);

    Dish get(int id) throws NotFoundException;

    void delete(int id) throws NotFoundException;

    void addDishes(List<Dish> dishes, Integer restaurantId);

    List<Dish> getAllByRestaurantId(int restaurantId);

    List<Dish> getAllByRestaurantIdAndDate(int restaurantId, LocalDate date);

    List <Dish> getAll();
}
