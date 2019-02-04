package ru.restaurants.restvoting.repository;

import ru.restaurants.restvoting.model.MenuItem;

import java.time.LocalDate;
import java.util.List;

public interface MenuItemRepository {
    MenuItem save(MenuItem menuItem);

    void deleteById(Integer id);

    MenuItem findById(Integer id);

    List<MenuItem> findAll();

    List<MenuItem> findAllByRestaurantId(Integer restaurantId);

    List<MenuItem> findAllByRestaurantIdAndDate(Integer restaurantId, LocalDate date);
}
