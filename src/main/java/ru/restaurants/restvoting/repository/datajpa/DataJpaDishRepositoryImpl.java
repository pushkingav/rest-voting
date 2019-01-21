package ru.restaurants.restvoting.repository.datajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.restaurants.restvoting.model.Dish;
import ru.restaurants.restvoting.repository.DishRepository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class DataJpaDishRepositoryImpl implements DishRepository {
    @Autowired
    private CrudRestaurantRepository crudRestaurantRepository;

    @Autowired
    private CrudDishRepository crudDishRepository;

    @Override
    @Transactional
    public Dish save(Dish dish, int restaurant_id) {
        dish.setRestaurant(crudRestaurantRepository.getOne(restaurant_id));
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

    @Override
    public List<Dish> findAllByRestaurantIdAndDate(Integer restaurantId, LocalDate date) {
        return crudDishRepository.findAllByRestaurantIdAndDate(restaurantId, date);
    }
}
