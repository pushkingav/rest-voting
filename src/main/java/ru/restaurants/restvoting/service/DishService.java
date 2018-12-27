package ru.restaurants.restvoting.service;

import ru.restaurants.restvoting.model.Dish;
import ru.restaurants.restvoting.util.exception.NotFoundException;

import java.util.List;

public interface DishService {
    Dish create(Dish dish, int restaurant_id);

    Dish update(Dish dish, int restaurant_id);

    Dish get(int id) throws NotFoundException;

    void delete(int id) throws NotFoundException;

    void addDishes(List<Dish> dishes, Integer restaurantId);

    List<Dish> getAllByRestaurant(int restaurantId);

    List <Dish> getAll();

    boolean vote(int restaurantId);
}
