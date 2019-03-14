package ru.restaurants.restvoting.service;

import ru.restaurants.restvoting.model.Dish;
import ru.restaurants.restvoting.model.MenuItem;
import ru.restaurants.restvoting.model.Restaurant;
import ru.restaurants.restvoting.to.MenuItemTo;
import ru.restaurants.restvoting.util.exception.NotFoundException;

import java.time.LocalDate;
import java.util.List;

public interface DishService {
    Restaurant addRestaurant(Restaurant restaurant, Integer restaurantId);

    List<Restaurant> getAllRestaurants();

    Dish create(Dish dish);

    Dish update(Dish dish, int restaurantId);

    Dish get(int id) throws NotFoundException;

    void delete(int id) throws NotFoundException;

    void addDishes(List<MenuItemTo> menuItemToList, Integer restaurantId);

    List<MenuItem> getAllByRestaurantId(int restaurantId);

    List<MenuItem> getAllByRestaurantIdAndDate(int restaurantId, LocalDate date);
}
