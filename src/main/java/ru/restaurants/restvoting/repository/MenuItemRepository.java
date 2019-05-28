package ru.restaurants.restvoting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.restaurants.restvoting.model.MenuItem;

import java.time.LocalDate;
import java.util.List;

public interface MenuItemRepository extends JpaRepository<MenuItem, Integer> {
    List<MenuItem> findAllByRestaurantId(Integer restaurantId);

    List<MenuItem> findAllByRestaurantIdAndDate(Integer restaurantId, LocalDate date);
}
