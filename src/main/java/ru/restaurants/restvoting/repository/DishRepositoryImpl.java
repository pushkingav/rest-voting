package ru.restaurants.restvoting.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.restaurants.restvoting.model.Dish;

import java.util.List;

@Repository
public class DishRepositoryImpl implements DishRepository {

    @Autowired
    private CrudDishRepository crudDishRepository;

    @Override
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

    @Override
    public List<Dish> findAllByRestaurantId(Integer restaurantId) {
        return crudDishRepository.findAllByRestaurantId(restaurantId);
    }
}
