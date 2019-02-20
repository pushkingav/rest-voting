package ru.restaurants.restvoting.repository;

import ru.restaurants.restvoting.model.Restaurant;

import java.util.List;
import java.util.Optional;

public interface RestaurantRepository {

    Restaurant add(Restaurant restaurant);

    Optional<Restaurant> getById(Integer id);

    List<Restaurant> getAll();

    Restaurant getByName(String name);
}
