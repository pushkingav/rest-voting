package ru.restaurants.restvoting.service;

import ru.restaurants.restvoting.model.Dish;
import ru.restaurants.restvoting.model.User;
import ru.restaurants.restvoting.util.exception.NotFoundException;

import java.util.List;

public interface DishService {
    Dish create(Dish dish);

    void delete(int id) throws NotFoundException;

    Dish get(int id) throws NotFoundException;

    User getByName(String name) throws NotFoundException;

    void update(User user);

    List<User> getAll();

    boolean vote(User user, int restaurant_id);
}
