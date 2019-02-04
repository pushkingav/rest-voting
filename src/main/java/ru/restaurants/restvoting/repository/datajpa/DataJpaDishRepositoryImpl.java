package ru.restaurants.restvoting.repository.datajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.restaurants.restvoting.model.Dish;
import ru.restaurants.restvoting.repository.DishRepository;

import java.util.List;

@Repository
public class DataJpaDishRepositoryImpl implements DishRepository {
    @Autowired
    private CrudRestaurantRepository crudRestaurantRepository;

    @Autowired
    private CrudDishRepository crudDishRepository;

    @Override
    @Transactional
    public Dish save(Dish dish) {
        return crudDishRepository.save(dish);
    }

    @Override
    public void deleteById(Integer id) {
        crudDishRepository.deleteById(id);
    }

    @Override
    public Dish findById(Integer id) {
        return crudDishRepository.findById(id).get();
    }

    @Override
    public List<Dish> findAll() {
        return crudDishRepository.findAll();
    }
}
