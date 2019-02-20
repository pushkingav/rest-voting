package ru.restaurants.restvoting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import ru.restaurants.restvoting.model.Dish;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
public interface DishRepository extends JpaRepository<Dish, Integer> {
    @Override
    //@Modifying - does not work here since no query provided
    @Transactional
    void deleteById(Integer id);

    @Override
    List<Dish> findAll();

    @Override
    @Transactional
    Dish save(Dish dish);

    Optional<Dish> findById(Integer id);

    Dish findByDescription(String description);
}
