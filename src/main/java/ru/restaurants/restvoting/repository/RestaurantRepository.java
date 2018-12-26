package ru.restaurants.restvoting.repository;

import ru.restaurants.restvoting.model.Restaurant;

import java.util.List;

public interface RestaurantRepository {
    void add(Restaurant restaurant);

    Restaurant getById(Integer id);

    List<Restaurant> getAll();

    Restaurant getByName(String name);
}
