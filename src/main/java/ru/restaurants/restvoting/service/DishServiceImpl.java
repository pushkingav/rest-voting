package ru.restaurants.restvoting.service;

import org.springframework.stereotype.Service;
import ru.restaurants.restvoting.model.Dish;
import ru.restaurants.restvoting.model.User;
import ru.restaurants.restvoting.util.exception.NotFoundException;

import java.util.List;

@Service
public class DishServiceImpl implements DishService {
    @Override
    public Dish create(Dish dish) {
        return null;
    }

    @Override
    public void delete(int id) throws NotFoundException {

    }

    @Override
    public Dish get(int id) throws NotFoundException {
        return null;
    }

    @Override
    public User getByName(String name) throws NotFoundException {
        return null;
    }

    @Override
    public void update(User user) {

    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public boolean vote(User user, int restaurant_id) {
        return false;
    }
}
