package ru.restaurants.restvoting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import ru.restaurants.restvoting.model.Dish;

import java.util.List;

@Transactional(readOnly = true)
public interface CrudDishRepository extends JpaRepository<Dish, Integer> {
    @Override
    @Transactional
    Dish save(Dish dish);

    @Override
    //@Modifying - does not work here since no query provided
    @Transactional
    void deleteById(Integer integer);

    @Override
    List<Dish> findAll();

    List<Dish> findAllByRestaurantId(Integer restaurantId);
}
