package ru.restaurants.restvoting.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.restaurants.restvoting.model.Dish;

import java.util.List;
@Repository
public class DishRepositoryImpl implements DishRepository {

    private final CrudDishRepository crudDishRepository;

    @Autowired
    public DishRepositoryImpl(CrudDishRepository crudDishRepository) {
        this.crudDishRepository = crudDishRepository;
    }

    @Override
    public Dish save(Dish dish) {
        return crudDishRepository.save(dish);
    }

    @Override
    public void deleteById(Integer id) {
        crudDishRepository.deleteById(id);
    }

    @Override
    public Dish getById(Integer id) {
        return crudDishRepository.getOne(id);
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
