package ru.restaurants.restvoting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.restaurants.restvoting.model.Dish;
import ru.restaurants.restvoting.repository.DishRepository;
import ru.restaurants.restvoting.util.exception.NotFoundException;

import java.util.ArrayList;
import java.util.List;

@Service
public class DishServiceImpl implements DishService {

    private final DishRepository dishRepository;

    @Autowired
    public DishServiceImpl(DishRepository repository) {
        this.dishRepository = repository;
    }

    @Override
    public Dish create(Dish dish) {
        return dishRepository.save(dish);
    }

    @Override
    public Dish update(Dish dish) {
        return dishRepository.save(dish);
    }

    @Override
    public Dish get(int id) throws NotFoundException {
        Dish result = dishRepository.findById(id);
        if (result == null) {
            throw new NotFoundException("Not found Dish with id = " + id);
        }
        return result;
    }

    @Override
    public void delete(int id) throws NotFoundException {
        dishRepository.deleteById(id);
    }

    @Override
    public List<Dish> addDishes(List<Dish> dishes) {
        List<Dish> result = new ArrayList<>();
        dishes.forEach(dish -> result.add(dishRepository.save(dish)));
       return result;
    }

    @Override
    public List<Dish> getAllByRestaurant(int restaurantId) {
        return dishRepository.findAllByRestaurantId(restaurantId);
    }

    @Override
    public List<Dish> getAll() {
        return dishRepository.findAll();
    }
}
