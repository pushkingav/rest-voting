package ru.restaurants.restvoting.repository;

import ru.restaurants.restvoting.model.Restaurant;

public interface RestaurantRepository {
        void add(Restaurant restaurant);

        Restaurant getById(Integer id);
}
