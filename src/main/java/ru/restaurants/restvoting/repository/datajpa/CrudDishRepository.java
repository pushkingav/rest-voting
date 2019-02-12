package ru.restaurants.restvoting.repository.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import ru.restaurants.restvoting.model.Dish;

import java.util.List;

//Proxy!
@Transactional(readOnly = true)
public interface CrudDishRepository extends JpaRepository<Dish, Integer> {
    @Override
    //@Modifying - does not work here since no query provided
    @Transactional
    void deleteById(Integer id);

    @Override
    List<Dish> findAll();

    Dish findByDescription(String description);

    @Override
    @Transactional
    Dish save(Dish dish);
}
