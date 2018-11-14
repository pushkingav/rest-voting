package ru.restaurants.restvoting.service;

import org.springframework.stereotype.Service;
import ru.restaurants.restvoting.model.Dish;
import ru.restaurants.restvoting.util.exception.NotFoundException;

import java.util.List;

@Service
public class DishServiceImpl implements DishService {
    @Override
    public Dish create(Dish dish) {
        return null;
    }

    @Override
    public Dish update(Dish dish) {
        return null;
    }

    @Override
    public Dish get(int id) throws NotFoundException {
        return null;
    }

    @Override
    public void delete(int id) throws NotFoundException {

    }

    @Override
    public List<Dish> getAllByRestaurant(int restaurantId) {
        return null;
    }

    @Override
    public List<Dish> getAll() {
        return null;
    }
}
