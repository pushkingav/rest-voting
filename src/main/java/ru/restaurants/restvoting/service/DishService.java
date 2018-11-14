package ru.restaurants.restvoting.service;

import ru.restaurants.restvoting.model.Dish;
import ru.restaurants.restvoting.model.User;
import ru.restaurants.restvoting.util.exception.NotFoundException;

import java.util.List;

public interface DishService {
    Dish create(Dish dish);

    Dish update(Dish dish);

    Dish get(int id) throws NotFoundException;

    void delete(int id) throws NotFoundException;

    List<Dish> getAllByRestaurant(int restaurantId);

    List <Dish> getAll();
}
