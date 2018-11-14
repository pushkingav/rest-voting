package ru.restaurants.restvoting.repository;

import ru.restaurants.restvoting.model.Dish;

import java.util.List;

public interface DishRepository {
    Dish save(Dish dish);

    void deleteById(Integer integer);

    List<Dish> findAll();

    List<Dish> findAllByRestaurantId(Integer restaurantId);
}
