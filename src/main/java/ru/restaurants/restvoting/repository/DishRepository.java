package ru.restaurants.restvoting.repository;

import ru.restaurants.restvoting.model.Dish;

import java.util.List;

public interface DishRepository {
    Dish save(Dish dish);

    void deleteById(Integer id);

    Dish findById(Integer id);

    Dish findByDescription(String description);

    List<Dish> findAll();
}
