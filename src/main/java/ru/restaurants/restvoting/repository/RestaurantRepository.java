package ru.restaurants.restvoting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import ru.restaurants.restvoting.model.Restaurant;

import java.util.List;
import java.util.Optional;
@Transactional(readOnly = true)
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
    @Override
    Restaurant save(Restaurant restaurant);

    @Override
    List<Restaurant> findAll();

    @Override
    Optional<Restaurant> findById(Integer integer);

    Optional<Restaurant> findByName(String name);
}
