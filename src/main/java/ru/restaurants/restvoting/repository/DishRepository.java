package ru.restaurants.restvoting.repository;

import ru.restaurants.restvoting.model.Dish;

import java.util.List;

public interface DishRepository {
    Dish save(Dish dish, int restaurant_id);

    void deleteById(Integer id);

    Dish findById(Integer id);

    List<Dish> findAll();

    List<Dish> findAllByRestaurantId(Integer restaurantId);
}
