package ru.restaurants.restvoting.service;

import ru.restaurants.restvoting.model.Dish;
import ru.restaurants.restvoting.model.MenuItem;
import ru.restaurants.restvoting.model.Restaurant;
import ru.restaurants.restvoting.to.DishTo;
import ru.restaurants.restvoting.util.exception.NotFoundException;

import java.time.LocalDate;
import java.util.List;

public interface DishService {
    Restaurant addRestaurant(Restaurant restaurant, Integer restaurantId);

    Dish create(Dish dish);

    MenuItem createMenuItem(MenuItem menuItem, int restaurantId);

    Dish update(Dish dish, int restaurantId);

    Dish get(int id) throws NotFoundException;

    void delete(int id) throws NotFoundException;

    void addDishes(List<DishTo> dishToList, Integer restaurantId);

    List<MenuItem> getAllByRestaurantId(int restaurantId);

    List<MenuItem> getAllByRestaurantIdAndDate(int restaurantId, LocalDate date);

    List <MenuItem> getAll();
}
